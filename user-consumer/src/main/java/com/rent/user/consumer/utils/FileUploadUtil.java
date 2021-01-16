package com.rent.user.consumer.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.UUID;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2020/12/30
 * @Time:15:07
 */
public class FileUploadUtil {

    /**
     * @param file
     * @return
     * OSS简单文件流上传
     */
    public String imageUpload(MultipartFile file, String path) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI4G1jxXdXhmEZQiE8rBEc";
        String accessKeySecret = "i5c8qzDQv3nbkAjBoaWhYCuO7YwVZI";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        //获取上传的文件名
        String fileName = file.getOriginalFilename();
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + fileType;

        // 上传文件流。
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            // <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
            ossClient.putObject("tangyanxin", path + newFileName, inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 关闭OSSClient。
        ossClient.shutdown();

        return "https://tangyanxin.oss-cn-beijing.aliyuncs.com/" + path + newFileName;
    }
}
