package com.example.L9UploadMultipleFile.controller;

import com.example.L9UploadMultipleFile.entity.Attachment;
import com.example.L9UploadMultipleFile.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;

@RestController
@RequestMapping("/uploadMultipleFile")
public class AttachmentController {
    @Autowired
    AttachmentRepository attachmentRepository;

public static final String uploadDir="Yuklash uchun";
@PostMapping
    public void uploadMultipleFileToSystem(MultipartHttpServletRequest request) throws IOException {
    Iterator<String> fileNames = request.getFileNames();
    List<MultipartFile> files = request.getFiles(fileNames.next());
    if (files!=null){
    files.stream().forEach(multipartFile -> {
        String originalFileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = Long.parseLong(StringUtils.cleanPath(String.valueOf(multipartFile.getSize())));
        String contentType = StringUtils.cleanPath(multipartFile.getContentType());
        String[] split = originalFileName.split("\\.");
        String name = UUID.randomUUID() + "." + split[split.length - 1];
        Attachment attachment = new Attachment(originalFileName, size, contentType, name);
        attachmentRepository.save(attachment);
        Path path = Paths.get(uploadDir + "/" + name);
        Path filePath = path.resolve(name);

        try {
            Files.copy(multipartFile.getInputStream(), filePath);
        } catch (IOException e) {
            System.out.println("Xatolik");
        }
    });}


    }
}
