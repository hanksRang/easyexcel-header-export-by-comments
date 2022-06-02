package com.hongke.file.excel;

import com.hongke.file.excel.service.impl.Comments2ExcelHeaderHelper;
import com.hongke.file.excel.util.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @GetMapping("/")
    String home() {
        return "Spring is here!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Comments2ExcelHeaderHelper comments2ExcelHeaderHelper =
                SpringContextUtil.getBean("comments2ExcelHeaderHelper");
        comments2ExcelHeaderHelper.export();
    }
}