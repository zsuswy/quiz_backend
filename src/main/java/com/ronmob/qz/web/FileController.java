package com.ronmob.qz.web;

import com.ronmob.qz.common.MD5Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建时间：9/19/17
 * 创建人：sunwuyang
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @Value("${upload_dir}")
    private String upload_dir;

    @Value("${img_url_path}")
    private String img_url_path;


    @RequestMapping(value = "/upload", produces = "application/json")
    @ResponseBody
    public Object upload(@RequestParam MultipartFile file, HttpSession session) {
        String orgFileName = file.getOriginalFilename();
        String extension = orgFileName.substring(orgFileName.lastIndexOf(".")).toLowerCase();
        String targetFileName = MD5Tool.MD5(orgFileName + String.valueOf(System.currentTimeMillis())) + extension;

        File targetFile = new File(upload_dir, targetFileName);
        Map<Object, Object> responseData = new HashMap<>();
        try {
            file.transferTo(targetFile);
            responseData.put("link", img_url_path + targetFileName);

        } catch (Exception ex) {
            responseData.put("error", ex.toString());
            ex.printStackTrace();
        }

        return responseData;
    }
}
