package com.rent.user.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonResponse;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.User;
import com.heikes.rent_common.pojo.UserRole;
import com.heikes.rent_common.utils.AuthCodeUtil;
import com.heikes.rent_common.vo.ResultVo;
import com.rent.user.consumer.service.UserRoleService;
import com.rent.user.consumer.service.UserService;
import com.rent.user.consumer.utils.FileUploadUtil;
import com.rent.user.consumer.utils.PhoneCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2020/12/30
 * @Time:13:46
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {

    //定义合法文件类型
    private static final List<String> CONTENT_TYPES = Arrays.asList("application/x-img","image/jpeg","application/x-png","image/png");

    @Autowired
    private FileUploadUtil fileUploadUtil;

    @Autowired
    private AuthCodeUtil authCodeUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private PhoneCodeUtil phoneCodeUtil;

    @Autowired
    private UserRoleService userRoleService;

    /**
     * @param user
     * @param photo
     * @return
     * 添加普通用户
     */
    @PostMapping(value = "/front/public/addNormalUser")
    public ResultVo<Boolean> addNormalUser(User user, MultipartFile photo, HttpServletRequest request, String authCode, Long roleId) {

        //校验验证码
        String authCodeFlag = request.getHeader("authCodeFlag");
        String theAuthCode = stringRedisTemplate.opsForValue().get(authCodeFlag);

        if (authCode.equalsIgnoreCase(theAuthCode)) {

            if (photo != null) {
                //获取文件类型
                String contentType = photo.getContentType();
                if (!CONTENT_TYPES.contains(contentType)) {
                    return new ResultVo<Boolean>(false, StatusCode.FILETYPEERROR, "错误的文件类型", false);
                }
                try {
                    //获取上传的文件流
                    InputStream inputStream = photo.getInputStream();

                    //校验文件内容
                    BufferedImage bufferedImage = ImageIO.read(inputStream);//返回一个二进制图片
                    //如果该图片没有宽度，则说明不是图片
                    if (bufferedImage.getWidth() <= 0) {
                        return new ResultVo<Boolean>(false, StatusCode.FILETYPEERROR, "错误的文件类型", false);
                    }
                    //上传文件
                    String fileUrl = fileUploadUtil.imageUpload(photo, "Relax/HeadPhoto/");
                    //设置文件存储地址
                    user.setUserImage(fileUrl);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                user.setUserImage("images/4.png");
            }

            //存入数据库
            Bizdto<Boolean> bizdto = userService.insertNormalUser(user, roleId);
            boolean flag = false;
            if (bizdto.getData() == true) {
                flag = true;
                return  new ResultVo<Boolean>(flag, bizdto.getCode(), bizdto.getMessage(), bizdto.getData());
            } else {
                return  new ResultVo<Boolean>(flag, bizdto.getCode(), bizdto.getMessage(), bizdto.getData());
            }
        } else {
            return  new ResultVo<Boolean>(true, StatusCode.AUTHCODEERROR, "验证码输入错误", false);
        }
    }

    /**
     * @param response
     * @param request
     * 生成注册时的验证码
     */
    @GetMapping(value = "/front/public/createCode")
    public void createCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            int width = 200;
            int height = 69;
            BufferedImage verifyImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //生成对应宽高的初始图片
            String randomText = authCodeUtil.drawRandomText(width, height, verifyImg);
            //单独的一个类方法，出于代码复用考虑，进行了封装。
            //功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符
            response.setContentType("image/png");// 必须设置响应内容类型为图片，否则前台不识别
            OutputStream os = response.getOutputStream(); // 获取文件输出流
            ImageIO.write(verifyImg, "png", os);// 输出图片流
            String authCodeFlag = request.getParameter("authCodeFlag");//获取存储验证码的key
            stringRedisTemplate.opsForValue().set(authCodeFlag, randomText, 5L, TimeUnit.MINUTES);
            //stringRedisTemplate.opsForValue().set(authCodeFlag, randomText);//将当前使用者的验证码存入redis
            os.flush();
            os.close();// 关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param request
     * @return
     * 生成redis中存储图形验证码的key
     */
    @GetMapping(value = "/front/public/getAuthCode")
    public ResultVo<String> getAuthCode(HttpServletRequest request) {
        //获取当前使用者旧的验证码的key
        String authCodeFlag = request.getHeader("authCodeFlag");
        //删除当前使用者redis中旧的验证码的key
        stringRedisTemplate.delete(authCodeFlag);
        //生成新的redis中验证码的key
        String newAuthCode = "authcode:" + UUID.randomUUID().toString();
        return new ResultVo<String>(true, StatusCode.OK, "请求成功！", newAuthCode);
    }

    /**
     * @param userAccount
     * @return
     * 查询用户头像地址
     */
    @GetMapping(value = "/front/public/findUserImg")
    public ResultVo<String> findUserImg(String userAccount) {
        Bizdto<User> bizdto = userService.findUserImg(userAccount);
        boolean flag = false;
        if (bizdto.getData() != null) {
            flag = true;
            return new ResultVo<String>(flag, bizdto.getCode(), bizdto.getMessage(), bizdto.getData().getUserImage());
        } else {
            return new ResultVo<String>(flag, bizdto.getCode(), bizdto.getMessage(), null);
        }
    }

    /**
     * @param userAccount
     * @param password
     * @return
     * 执行前台登录操作
     */
    @PostMapping(value = "/front/public/doLogin")
    public ResultVo<List> doLogin(String userAccount, String password) {
        Bizdto<User> bizdto = userService.doLogin(userAccount, password);
        List data = new ArrayList();

        boolean flag = false;
        if (bizdto.getData() != null) {
            if (bizdto.getData().getUserStatus().intValue() != 1) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("userId", bizdto.getData().getId());
                //查询用户角色
                Bizdto<UserRole> roleBizdto = userRoleService.findByColumn(map);
                flag = true;
                String token = "token:" + UUID.randomUUID().toString();
                stringRedisTemplate.opsForHash().put(token, "userId", bizdto.getData().getId().toString());
                stringRedisTemplate.opsForHash().put(token, "roleId", roleBizdto.getData().getRoleId().toString());
                stringRedisTemplate.expire(token, 30L, TimeUnit.MINUTES);
                //stringRedisTemplate.opsForValue().set(token, bizdto.getData().getId().toString(), 30L, TimeUnit.MINUTES);
                //1登录成功，0登录不成功，2表示被封禁
                data.add(1);
                data.add(token);
                data.add(bizdto.getData().getId().toString());
                return new ResultVo<List>(flag, bizdto.getCode(), bizdto.getMessage(), data);
            } else {
                data.add(2);
                return new ResultVo<List>(false, StatusCode.ACCESSERROR, "该用户已被封禁", data);
            }
        } else {
            data.add(0);
            return new ResultVo<List>(flag, bizdto.getCode(), bizdto.getMessage(), data);
        }
    }

    /**
     * @param userAccount
     * @param password
     * @return
     * 执行后台登录操作
     */
    @PostMapping(value = "/front/public/doManageLogin")
    public ResultVo<List> doManageLogin(String userAccount, String password) {
        Bizdto<User> bizdto = userService.doLogin(userAccount, password);
        List data = new ArrayList();

        boolean flag = false;
        if (bizdto.getData() != null) {
            if (bizdto.getData().getUserStatus().intValue() != 1) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("userId", bizdto.getData().getId());
                //查询用户角色
                Bizdto<UserRole> roleBizdto = userRoleService.findByColumn(map);
                if (roleBizdto.getData().getRoleId().intValue() == 4) {
                    data.add(0);
                    return new ResultVo<List>(false, bizdto.getCode(), "权限不足", data);
                } else {
                    flag = true;
                    String token = "token:" + UUID.randomUUID().toString();
                    stringRedisTemplate.opsForHash().put(token, "userId", bizdto.getData().getId().toString());
                    stringRedisTemplate.opsForHash().put(token, "roleId", roleBizdto.getData().getRoleId().toString());
                    stringRedisTemplate.expire(token, 30L, TimeUnit.MINUTES);
                    //stringRedisTemplate.opsForValue().set(token, bizdto.getData().getId().toString(), 30L, TimeUnit.MINUTES);
                    //1登录成功，0登录不成功
                    data.add(1);
                    data.add(token);
                    data.add(bizdto.getData().getId());
                    data.add(roleBizdto.getData().getRoleId());
                    return new ResultVo<List>(flag, bizdto.getCode(), bizdto.getMessage(), data);
                }
            } else {
                data.add(2);
                return new ResultVo<List>(flag, StatusCode.ACCESSERROR, "该用户已被封禁，请联系管理员解除！", data);
            }
        } else {
            data.add(0);
            return new ResultVo<List>(flag, bizdto.getCode(), "用户名或密码错误", data);
        }
    }

    /**
     * @param phoneNumber
     * @return
     * 获取手机登录验证码
     */
    @GetMapping(value = "/front/public/getPhoneCode")
    public ResultVo<Integer> getPhoneCode(String phoneNumber) {
        Map<String, Object> columns = new HashMap<>();
        columns.put("phone", phoneNumber);
        Bizdto<User> bizdto = userService.findUserByColumn(columns);

        if (bizdto.getData() != null) {
            int phoneCode = (int) ((Math.random() * 9 + 1) * 1000);
            //data = {"RequestId":"1B0DE088-FA0A-4818-A37D-2DD77B5A731B","Message":"OK","BizId":"755811009839029951^0","Code":"OK"}
            CommonResponse response  = phoneCodeUtil.sendCode(phoneNumber, "SMS_206752482", phoneCode + "");
            Map<String, String> map = JSONObject.parseObject(response.getData(), Map.class);
            if ("OK".equals(map.get("Code"))) {
                stringRedisTemplate.delete("phone:code:" + phoneNumber);
                stringRedisTemplate.opsForValue().set("phone:code:" + phoneNumber, phoneCode + "", 5L, TimeUnit.MINUTES);
                return new ResultVo<Integer>(true, StatusCode.OK, "验证码发送成功", 1);
            } else {
                return new ResultVo<Integer>(false, StatusCode.ERROR, "验证码发送失败", 0);
            }
        } else {
            return new ResultVo<Integer>(false, bizdto.getCode(), "该手机号未绑定", -1);
        }
    }

    /**
     * @param phoneNumber
     * @param phoneCode
     * @return
     * 使用手机验证码登录
     */
    @PostMapping(value = "/front/public/doLoginByPhoneCode")
    public ResultVo<List> doLoginByPhoneCode(String phoneNumber, String phoneCode) {
        Map<String, Object> columns = new HashMap<>();
        columns.put("phone", phoneNumber);
        Bizdto<User> bizdto = userService.findUserByColumn(columns);
        List data = new ArrayList();

        if (bizdto.getData() != null) {
            if (bizdto.getData().getUserStatus().intValue() != 1) {
                String code = stringRedisTemplate.opsForValue().get("phone:code:" + phoneNumber);
                if (phoneCode.equals(code)) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("userId", bizdto.getData().getId());
                    //查询用户角色
                    Bizdto<UserRole> roleBizdto = userRoleService.findByColumn(map);

                    stringRedisTemplate.delete("phone:code:" + phoneNumber);
                    String token = "token:" + UUID.randomUUID().toString();
                    stringRedisTemplate.opsForHash().put(token, "userId", bizdto.getData().getId());
                    stringRedisTemplate.opsForHash().put(token, "roleId", roleBizdto.getData().getRoleId());
                    stringRedisTemplate.expire(token, 30L, TimeUnit.MINUTES);
                    //stringRedisTemplate.opsForValue().set(token, bizdto.getData().getId().toString(), 30L, TimeUnit.MINUTES);
                    //1登录成功，0登录不成功，2表示被封禁
                    data.add(1);
                    data.add(token);
                    data.add(bizdto.getData().getId().toString());
                    return new ResultVo<List>(true, StatusCode.OK, "登录成功", data);
                } else {
                    data.add(0);
                    return new ResultVo<List>(false, StatusCode.AUTHCODEERROR, "验证码输入错误", data);
                }
            } else {
                data.add(2);
                return new ResultVo<List>(false, StatusCode.ACCESSERROR, "该用户已被封禁，请联系管理员解除！", data);
            }

        } else {
            data.add(0);
            return new ResultVo<List>(false, StatusCode.LOGINERROR, "该手机号未绑定", data);
        }
    }

    /**
     * @param request
     * @return
     * 登录检测
     */
    @PostMapping(value = "/front/public/checkLogin")
    public ResultVo<Boolean> checkLogin(HttpServletRequest request) {
        String token = request.getHeader("token");
        token = token == null ? "" : token;
        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries(token);
        if (map != null && map.size() > 0) {
            return new ResultVo<Boolean>(true, StatusCode.OK, "登录成功", true);
        } else {
            return new ResultVo<Boolean>(false, StatusCode.OK, "未登录", false);
        }
    }

    /**
     * @param request
     * @return
     * 获取当前登录用户信息
     */
    @GetMapping(value = "/front/private/getUserMessage")
    public ResultVo<User> getUserMessage(HttpServletRequest request) {
        String token = request.getHeader("token");
        token = token == null ? "" : token;
        Object userId = stringRedisTemplate.opsForHash().get(token, "userId");
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        Bizdto<User> bizdto = userService.findUserByColumn(map);
        return new ResultVo<User>(true, bizdto.getCode(), bizdto.getMessage(), bizdto.getData());
    }

    /**
     * @param request
     * @return
     * 注销
     */
    @GetMapping(value = "/front/private/loginOut")
    public ResultVo<Boolean> loginOut(HttpServletRequest request) {
        String token = request.getHeader("token");
        token = token == null ? "" : token;
        stringRedisTemplate.delete(token);
        return new ResultVo<Boolean>(true, StatusCode.OK, "注销成功", true);
    }

    /**
     * @param phoneNumber
     * @return
     * 获取找回密码的验证码
     */
    @GetMapping(value = "/front/public/getFindPhoneCode")
    public ResultVo<Integer> getFindPhoneCode(String phoneNumber) {
        Map<String, Object> columns = new HashMap<>();
        columns.put("phone", phoneNumber);
        Bizdto<User> bizdto = userService.findUserByColumn(columns);

        if (bizdto.getData() != null) {
            int phoneCode = (int) ((Math.random() * 9 + 1) * 1000);
            CommonResponse response  = phoneCodeUtil.sendCode(phoneNumber, "SMS_208975744", phoneCode + "");
            Map<String, String> map = JSONObject.parseObject(response.getData(), Map.class);
            if ("OK".equals(map.get("Code"))) {
                stringRedisTemplate.delete("phone:find:password:code:" + phoneNumber);
                stringRedisTemplate.opsForValue().set("phone:find:password:code:" + phoneNumber, phoneCode + "", 1L, TimeUnit.MINUTES);
                return new ResultVo<Integer>(true, StatusCode.OK, "验证码发送成功", 1);
            } else {
                return new ResultVo<Integer>(false, StatusCode.ERROR, "验证码发送失败", 0);
            }
        } else {
            return new ResultVo<Integer>(false, bizdto.getCode(), "该手机号未绑定", -1);
        }
    }

    /**
     * @param phoneNumber
     * @param phoneCode
     * @param password
     * @return
     * 前台找回密码的方法
     */
    @PostMapping(value = "/front/public/doFindPassword")
    public ResultVo<Boolean> doFindPassword(String phoneNumber, String phoneCode, String password) {
        Map<String, Object> columns = new HashMap<>();
        columns.put("phone", phoneNumber);
        Bizdto<User> bizdto = userService.findUserByColumn(columns);

        if (bizdto.getData() != null) {
            String code = stringRedisTemplate.opsForValue().get("phone:find:password:code:" + phoneNumber);
            if (phoneCode.equals(code)) {
                Map<String, Object> map = new HashMap<>();
                map.put("userId", bizdto.getData().getId());
                map.put("password", password);
                Bizdto<Boolean> data = userService.updateColumnById(map);
                stringRedisTemplate.delete("phone:find:password:code:" + phoneNumber);
                //-1验证码输入错误，0修改不成功，1修改成功，2手机号未绑定
                return new ResultVo<Boolean>(true, StatusCode.OK, "修改成功", data.getData());
            } else {
                return new ResultVo<Boolean>(false, StatusCode.AUTHCODEERROR, "验证码输入错误", false);
            }
        } else {
            return new ResultVo<Boolean>(false, StatusCode.LOGINERROR, "该手机号未绑定", false);
        }
    }

    /**
     * @param phoneNumber
     * @param phoneCode
     * @return
     * 后台忘记密码，重置密码的方法
     */
    @PostMapping(value = "/front/public/resetPassword")
    public ResultVo<Boolean> resetPassword(String phoneNumber, String phoneCode) {
        Map<String, Object> columns = new HashMap<>();
        columns.put("phone", phoneNumber);
        Bizdto<User> bizdto = userService.findUserByColumn(columns);

        if (bizdto.getData() != null) {
            String code = stringRedisTemplate.opsForValue().get("phone:find:password:code:" + phoneNumber);
            if (phoneCode.equals(code)) {
                Map<String, Object> map = new HashMap<>();
                map.put("userId", bizdto.getData().getId());
                map.put("password", "000000");
                Bizdto<Boolean> data = userService.updateColumnById(map);
                stringRedisTemplate.delete("phone:find:password:code:" + phoneNumber);
                //-1验证码输入错误，0修改不成功，1修改成功，2手机号未绑定
                return new ResultVo<Boolean>(true, StatusCode.OK, "修改成功", data.getData());
            } else {
                return new ResultVo<Boolean>(false, StatusCode.AUTHCODEERROR, "验证码输入错误", false);
            }
        } else {
            return new ResultVo<Boolean>(false, StatusCode.LOGINERROR, "该手机号未绑定", false);
        }
    }

    /**
     * @param userAccount
     * @return
     * 查询用户账号是否已存在
     */
    @GetMapping(value = "/front/public/checkAccount")
    public ResultVo<Boolean> checkAccount(String userAccount) {
        Map<String, Object> map = new HashMap<>();
        map.put("userAccount", userAccount);
        Bizdto<User> bizdto = userService.findUserByColumn(map);
        boolean data = false;
        if (bizdto.getData() == null) {
            //未查到数据说明，该账号可用
            data = true;
            return new ResultVo<Boolean>(true, StatusCode.OK, "该账号可用！", data);
        }
        return new ResultVo<Boolean>(true, StatusCode.OK, "账号已存在！", data);
    }

    /**
     * @param phone
     * @return
     * 检查手机号是否已绑定
     */
    @GetMapping(value = "/front/public/checkPhone")
    public ResultVo<Boolean> checkPhone(String phone) {
        Map<String, Object> map = new HashMap<>();
        map.put("phone", phone);
        Bizdto<User> bizdto = userService.findUserByColumn(map);
        boolean data = false;
        if (bizdto.getData() == null) {
            //未查到数据说明，该手机号可用
            data = true;
            return new ResultVo<Boolean>(true, StatusCode.OK, "该手机号可用！", data);
        }
        return new ResultVo<Boolean>(true, StatusCode.OK, "手机号已绑定！", data);
    }

    /**
     * @param user
     * @param photo
     * @param request
     * @return
     * 前台管理修改用户信息
     */
    @PostMapping(value = "/front/private/updateUser")
    public ResultVo<Boolean> updateUser(User user, MultipartFile photo, HttpServletRequest request) {

        String userId = request.getHeader("userId");
        Long id = Long.parseLong(userId);

        if (photo != null) {
            //获取文件类型
            String contentType = photo.getContentType();
            if (!CONTENT_TYPES.contains(contentType)) {
                return new ResultVo<Boolean>(false, StatusCode.FILETYPEERROR, "错误的文件类型", false);
            }
            try {
                //获取上传的文件流
                InputStream inputStream = photo.getInputStream();

                //校验文件内容
                BufferedImage bufferedImage = ImageIO.read(inputStream);//返回一个二进制图片
                //如果该图片没有宽度，则说明不是图片
                if (bufferedImage.getWidth() <= 0) {
                    return new ResultVo<Boolean>(false, StatusCode.FILETYPEERROR, "错误的文件类型", false);
                }
                //上传文件
                String fileUrl = fileUploadUtil.imageUpload(photo, "Relax/HeadPhoto/");
                //设置文件存储地址
                user.setUserImage(fileUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("userId", userId);
            Bizdto<User> userByColumn = userService.findUserByColumn(map);
            user.setUserImage(userByColumn.getData().getUserImage());
        }

        //存入数据库
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("userId", userId);
        userMap.put("phone", user.getPhone());
        userMap.put("userName", user.getUserName());
        userMap.put("userImage", user.getUserImage());
        Bizdto<Boolean> bizdto = userService.updateColumnById(userMap);
        boolean flag = false;
        if (bizdto.getData() == true) {
            flag = true;
            return  new ResultVo<Boolean>(flag, bizdto.getCode(), bizdto.getMessage(), bizdto.getData());
        } else {
            return  new ResultVo<Boolean>(flag, bizdto.getCode(), bizdto.getMessage(), bizdto.getData());
        }
    }

    /**
     * @param password
     * @param request
     * @return
     * 验证码是否正确
     */
    @PostMapping(value = "/front/private/checkPassword")
    public ResultVo<Boolean> checkPassword(String password, HttpServletRequest request) {
        String userId = request.getHeader("userId");
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("password", password);
        Bizdto<User> bizdto = userService.findUserByColumn(map);
        if (bizdto.getData() != null) {
            return new ResultVo<Boolean>(true, StatusCode.OK, "密码正确", true);
        } else {
            return new ResultVo<Boolean>(true, bizdto.getCode(), bizdto.getMessage(), false);
        }
    }

    @PostMapping(value = "/front/private/updatePassword")
    public ResultVo<Boolean> updatePassword(String password, HttpServletRequest request) {
        String userId = request.getHeader("userId");
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("password", password);
        Bizdto<Boolean> bizdto = userService.updateColumnById(map);
        if (bizdto.getData()) {
            return new ResultVo<Boolean>(true, StatusCode.OK, "修改成功", true);
        } else {
            return new ResultVo<Boolean>(true, bizdto.getCode(), bizdto.getMessage(), false);
        }
    }
}
