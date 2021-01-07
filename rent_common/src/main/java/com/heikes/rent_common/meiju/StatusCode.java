package com.heikes.rent_common.meiju;

/**
 * 状态码实体类
 */
public class StatusCode {

    public static final int OK = 20000;//成功
    public static final int ERROR = 20001;//失败
    public static final int LOGINERROR = 20002;//用户名或密码错误或其他登录问题
    public static final int ACCESSERROR = 20003;//权限不足
    public static final int REMOTEERROR = 20004;//远程接口调用错误
    public static final int FILETYPEERROR = 20005;//文件类型错误
    public static final int AUTHCODEERROR = 20006;//验证码输入错误
}
