package com.javarush.quest.controller;

import com.javarush.quest.service.UserService;
import com.javarush.quest.util.Jsp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "UserDataServlet", value = "/userData")
public class UserDataServlet extends HttpServlet {
    private final UserService userService = UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        final UserService userService = UserService.USER_SERVICE;
        Jsp.forward(request, response, "userData");
    }
}
