package com.system.fridges.service.utils;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class PhotoManager {

    private static final String UPLOAD_PATH = "/fridges/img";

    private final MultipartFile file;

    private String absolutePath;

    public PhotoManager(MultipartFile multipartFile) {
        this.file = multipartFile;
    }

    public void savePhoto() {
        if (file == null || file.isEmpty() || file.getOriginalFilename() == null) return;
        try {
            // Отримати шлях до теки проекту
            String folderPath = System.getProperty(UPLOAD_PATH);

            // Створити файл у папці "img"
            File destination = new File(folderPath, Objects.requireNonNull(file.getOriginalFilename()));

            // Зберегти файл на сервері
            FileCopyUtils.copy(file.getBytes(), destination);

            absolutePath = destination.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAbsolutePath() {
        if (absolutePath != null) {
            return absolutePath;
        }
       return "";
    }

    public static byte[] pushPhoto(String photoPath){
        if (photoPath != null) {
            try {
                Path path = Paths.get(photoPath);
                return Files.readAllBytes(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
