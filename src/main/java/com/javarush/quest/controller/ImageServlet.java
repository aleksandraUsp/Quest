package com.javarush.quest.controller;

import com.javarush.quest.service.ImageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;

@WebServlet(name = "ImageServlet", value = "/images/*")
@MultipartConfig(fileSizeThreshold=1 <<20)
public class ImageServlet extends HttpServlet {
    private final ImageService avatarService = ImageService.IMAGE_SERVICE;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String nameImage = req.getRequestURI().replace("/images/", "");
        Optional<Path>file= Optional.ofNullable(avatarService.getImagePath(nameImage));
        if (file.isPresent()){
            try (ServletOutputStream outputStream=resp.getOutputStream()){
                Files.copy(file.get(), outputStream);
            }
        }
    }


}
