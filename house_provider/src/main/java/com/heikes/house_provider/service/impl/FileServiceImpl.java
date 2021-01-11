package com.heikes.house_provider.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.heikes.house_provider.service.FileService;
import com.heikes.house_provider.utils.OssProperties;
import org.apache.commons.io.FilenameUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private OssProperties ossProperties;

    @Override
    public String upload(InputStream inputStream, String module, String orginalFilename) {
        String endpoint = ossProperties.getEndpoint();
        String keyid = ossProperties.getKeyid();
        String bucketname = ossProperties.getBucketname();
        String keysecret = ossProperties.getKeysecret();


        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyid, keysecret);
        if (!ossClient.doesBucketExist(bucketname)){
            ossClient.createBucket(bucketname);
            ossClient.setBucketAcl(bucketname, CannedAccessControlList.PublicRead);
        }
        // 上传文件流。
//        InputStream inputStream = new FileInputStream("<yourlocalFile>");
        //构建objectName 此处采取日期策略 avatar/2020/11/24/a.jpg
        String folder = new DateTime().toString("yyyy/MM/dd");
        String newName= UUID.randomUUID().toString().replaceAll("-", "");
        String extention= FilenameUtils.getExtension(orginalFilename);
        String newFileName=module+"/"+folder+"/"+newName+"."+extention;
        ossClient.putObject(bucketname, newFileName, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();
        return "https://"+bucketname+"."+endpoint+"/"+newFileName;
    }

    @Override
    public void removeFile(String url) {
        String endpoint = ossProperties.getEndpoint();
        String keyid = ossProperties.getKeyid();
        String bucketname = ossProperties.getBucketname();
        String keysecret = ossProperties.getKeysecret();

        // 创建OSSClient实例。
        String host="https://"+bucketname+"."+endpoint+"/";
        String objectName=url.substring(host.length());
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyid, keysecret);

        //删除文件
        ossClient.deleteObject(bucketname, objectName);
        ossClient.shutdown();
    }
}
