package com.javarush.quest.service;

import com.javarush.quest.config.Configg;
import com.javarush.quest.repository.UserRepository;
import com.javarush.quest.util.QuestException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;


public enum ImageService {
    IMAGE_SERVICE;
    public static final String IMAGES_FOLDER = "images";
    public static final String PART_NAME = "image";
    public static final String FILENAME_PREFIX = "image-";
    public static final String NO_IMAGE_PNG = "no-image.png";
    public static final List<String> EXTENSIONS = List.of(".jpg", ".jpeg", ".png", ".bmp", ".gif", ".webp");
    private final Path imagesFolder = Configg.WEB_INF.resolve(IMAGES_FOLDER);
    UserService userService = UserService.USER_SERVICE;



    ImageService() {
        try {
            Files.createDirectories(imagesFolder);
        } catch (IOException e) {
            throw new QuestException(e);
        }
    }

    public Path getImagePath(String filename) {
        return EXTENSIONS.stream().
                map(ext -> imagesFolder.resolve(filename + ext))
                .filter(Files::exists)
                .findAny()
                .orElse(imagesFolder.resolve(NO_IMAGE_PNG));
    }

    public void uploadImage(HttpServletRequest request, long id) throws IOException, ServletException {
        Part data = request.getPart(PART_NAME);
        if (Objects.nonNull(data) && data.getInputStream().available() > 0) {
            String filename = data.getSubmittedFileName();
            String ext = filename.substring(filename.lastIndexOf("."));
            deleteOldFiles(FILENAME_PREFIX + id);
            filename = FILENAME_PREFIX + id + ext;
            uploadImageInternal(filename, data.getInputStream(), id);
        }
    }
    public void deleteOldFiles(String filename) {
        EXTENSIONS.stream()
                .map(ext -> imagesFolder.resolve(filename+ext))             //FILENAME_PREFIX + ext))
                .filter(Files::exists)
                .forEach(p -> {
                    try {
                        Files.delete(p);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
     public void uploadImageInternal(String name, InputStream input, long id) {
        try (input) {
            if (input.available() > 0)
                Files.copy(input, imagesFolder.resolve(name), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new QuestException(e);
        }
    }

    /*public void uploadImageInterior(Path path) {
        try (input) {
            if (input.available() > 0)
                Files.copy(input, imagesFolder.resolve(name), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new QuestException(e);
        }
    }*/
}





