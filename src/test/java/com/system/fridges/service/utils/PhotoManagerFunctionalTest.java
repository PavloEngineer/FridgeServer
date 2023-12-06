package com.system.fridges.service.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.Assert;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PhotoManagerFunctionalTest {

    @Test
    public void savePhotoTest() {
        // Arrange
        String originalFilename = "test.jpg";
        MockMultipartFile mockMultipartFile =
                new MockMultipartFile("file", originalFilename, "image/jpeg", "test data".getBytes());

        PhotoManager photoManager = new PhotoManager(mockMultipartFile);

        // Act
        photoManager.savePhoto();
        String absolutePath = photoManager.getAbsolutePath();

        // Assert
        Assert.notNull(absolutePath, "Absolute path should not be null");
    }

    @Test
    public void readPhotoTest() {
        String originalFilename = "test.jpg";
        MockMultipartFile mockMultipartFile =
                new MockMultipartFile("file", originalFilename, "image/jpeg", "test data".getBytes());
        PhotoManager photoManager = new PhotoManager(mockMultipartFile);
        photoManager.savePhoto();

        String absolutePath = photoManager.getAbsolutePath();
        byte[] photoBytes = PhotoManager.pushPhoto(absolutePath);

        // Assert
        Assert.isTrue(photoBytes != null && photoBytes.length > 0, "Photo bytes should not be null or empty");
    }
}
