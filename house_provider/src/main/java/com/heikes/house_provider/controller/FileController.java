package com.heikes.house_provider.controller;

import com.heikes.house_provider.service.FileService;
import com.heikes.rent_common.dto.Bizdto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/oss/file")
@CrossOrigin
public class FileController {
    @Resource
    private FileService fileService;

    @PostMapping("/upload")
    public Bizdto<Object> upload(MultipartFile image,
                                 @RequestParam("module") String module){
        Bizdto<Object> bizdto = new Bizdto<>();
        try {
            InputStream inputStream = image.getInputStream();
            String originalFilename = image.getOriginalFilename();
            String fileURL = fileService.upload(inputStream,module,originalFilename);
            bizdto.setCode(200);
            bizdto.setMessage("文件上传成功");
            bizdto.setData(fileURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bizdto;
    }
}
