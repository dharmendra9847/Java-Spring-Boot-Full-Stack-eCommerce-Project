package com.ecommerce.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) {

        // Get the file names of current / original file
        String originalFilename = file.getOriginalFilename();

        // Generate a unique file name
        String randomId = UUID.randomUUID().toString();

        String fileName = randomId.concat(
                originalFilename.substring(
                        originalFilename.lastIndexOf(".")));

        String filePath = path + File.separator + fileName;

        // Check if the exist and create
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdir();
        }

        // Upload to server
        try {
            Files.copy(file.getInputStream(), Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // returning file name
        return fileName;
    }
}
