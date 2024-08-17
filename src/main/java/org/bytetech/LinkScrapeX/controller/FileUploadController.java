package org.bytetech.LinkScrapeX.controller;

import org.bytetech.LinkScrapeX.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
public class FileUploadController {

    @Autowired
    private ExcelService service;

    @PostMapping("/upload")
    @ResponseBody
    public String file(@RequestParam("file") File file) {

        List<String> list = service.dataReadTest(file);

        return "File Uploaded: " + file.getName();

    }
}
