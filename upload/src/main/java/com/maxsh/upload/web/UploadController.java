package com.maxsh.upload.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * UploadController
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/11/29
 */
@Controller
public class UploadController {

    @Value("${file.path}")
    private String filePath;

    @GetMapping(value = "/")
    public String index() {
        return "upload";
    }

    @GetMapping("/multi")
    public String uploadMore() {
        return "multi-upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadResult";
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(filePath + file.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/uploadResult";
    }

    @PostMapping("/multiUpload")
    public String multiUpload(@RequestParam("file") MultipartFile[] files,
                                 RedirectAttributes redirectAttributes) {
        if (files.length==0) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadResult";
        }
        for(MultipartFile file:files){
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(filePath + file.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded all");
        return "redirect:/uploadResult";
    }

    @GetMapping(value = "/uploadResult")
    public String uploadResult() {
        return "uploadResult";
    }
}
