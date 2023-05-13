package com.javarush.quest.controller;

import com.javarush.quest.entities.Role;
import com.javarush.quest.entities.User;
import com.javarush.quest.service.ImageService;
import com.javarush.quest.service.UserService;
import com.javarush.quest.util.Jsp;
import com.javarush.quest.util.QuestException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;


@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {

    UserService userService = UserService.USER_SERVICE;
    ImageService imageService = ImageService.IMAGE_SERVICE;
    private static volatile AtomicInteger UID=new AtomicInteger(1);
    public static final String PART_NAME = "image";

    @Override
    public void init()  {
        getServletContext().setAttribute("roles", Role.values());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<String> stringId = Optional.ofNullable(request.getParameter("id"));
        if (stringId.isPresent()){
            long id=Long.parseLong(stringId.get());
            Optional<User> user = Optional.ofNullable(userService.get(id));
            user.ifPresent(value -> request.setAttribute("user", value));
            Jsp.forward(request,response,"user");
        }
        else Jsp.forward(request,response,"users");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = getId(request);
        String image = "image-" + id;
        Part data = request.getPart(PART_NAME);
        if (Objects.nonNull(data) && data.getInputStream().available() > 0) {
            imageService.uploadImage(request, id);
        }
            User user = User.with()
                    .id(id)
                    .login(request.getParameter("login"))
                    .password(request.getParameter("password"))
                    .image(image)
                    .role(Role.valueOf(request.getParameter("role")))
                    .get();
            postUser(request, user);
            Jsp.redirect(response, "users");
        }


        protected void postUser (HttpServletRequest request, User user){
            Optional<Long> stringId = Optional.ofNullable(user.getId());
            boolean present = stringId.isPresent();
            if (present && request.getParameter("update") != null) {
                userService.update(user);
            } else if (present && request.getParameter("delete") != null) {
                userService.delete(user);
            } else if (!present && request.getParameter("creat") != null) {
                userService.create(user);
            } else {
                throw new QuestException("unknown command for user");
            }
        }

        protected long getId (HttpServletRequest request){
            return request.getParameter("id") != null ?
                    Long.parseLong(request.getParameter("id"))
                    : 0L;
        }
    }







       /* User user = User.builder()
                .id(Long.valueOf(request.getParameter("id")))
                .login(request.getParameter("login"))
                .password(request.getParameter("password"))
                .role(Role.valueOf(request.getParameter("role")))
                .image(request.getParameter("image"))
                .build();
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap.containsKey("create")) {
            userService.create(user);
        } else if (parameterMap.containsKey("update")) {
            userService.update(user);
        } else if (parameterMap.containsKey("delete")) {
            userService.delete(user);
        } else throw new QuestException("unknown command");
        imageService.uploadImage(request, user.getId());
        response.sendRedirect("users");
    }*/

