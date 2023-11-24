package com.example.RubyChinaUploadService.controller;

import com.example.RubyChinaUploadService.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @RequestMapping("/blog")
    public String upload() {
        String dir =
                "D:\\projects\\developing\\2023\\RubyChinaKG\\knowledge-graph\\data\\1009data\\Ruby Base\\study\\";
        int count = 25;
        String nodeName = "Ruby on Rails";
        String type = "study";
        uploadService.upload(dir, count, nodeName, type);
        return "success";
    }
}
