package com.heikes.house_provider.service;

import java.io.InputStream;

public interface FileService {
    /**
     * @Description: 阿里云oss文件上传
     * @Param: [inputStream, module, orginalFilename]
     * 文件输入流，文件夹名称，文件原名称
     * @return: java.lang.String
     * @Author: Heikes
     * @Date: 2020/11/24
     */
    String upload(InputStream inputStream, String module, String orginalFilename);

    void removeFile(String url);
}
