package com.api.bootrestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.bootrestbook.helper.FileUploadHelper;

// import jakarta.servlet.Servlet;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileuploadhelper; 

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        // System.out.println(file.getName());
    try {
            
            
        if(file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file .. !");
        }

        if(!file.getContentType().equals("image/jpeg")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG Content Type are Allowed .. !");
        }

        // file upload code
        
        boolean f = fileuploadhelper.uploadFile(file);
        if(f) {
            // return ResponseEntity.ok("Uploaded file is successfully uploaded");

            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
        }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Try Again");
    }
}
