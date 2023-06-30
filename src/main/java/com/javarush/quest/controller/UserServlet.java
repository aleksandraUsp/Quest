package com.javarush.quest.controller;

import com.javarush.quest.entities.Role;
import com.javarush.quest.entities.User;
import com.javarush.quest.service.UserService;
import com.javarush.quest.util.Jsp;
import com.javarush.quest.util.QuestException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;


@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {

    UserService userService = UserService.USER_SERVICE;
    private static volatile AtomicInteger UID=new AtomicInteger(1);


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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = getId(request);
        User user = User.with()
                    .id(id)
                    .login(request.getParameter("login"))
                    .password(request.getParameter("password"))
                    .role(Role.getRole(request.getParameter("role")))
                    .get();
            postUser(request, user);
            Jsp.redirect(response, "users");
        }


        protected void postUser (HttpServletRequest request, User user){
            if (user.getId()>0L && request.getParameter("action").equals("update"))
                userService.update(user);
             else if (user.getId()>0L && request.getParameter("actionDelete").equals("delete")) {
                userService.delete(user);
            } else if (user.getId()==0L && request.getParameter("action").equals("create")) {
                long id=userService.create(user);
                setUserParametersInSession(request, id);
            } else {
                throw new QuestException("unknown command for user");
            }
        }

        protected long getId (HttpServletRequest request){
            return request.getParameter("id") != null ?
                    Long.parseLong(request.getParameter("id"))
                    : 0L;
        }

    public void setUserParametersInSession(HttpServletRequest request, long id) {
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        session.setAttribute("login", userService.get(id).getLogin());
        session.setAttribute("password", userService.get(id).getPassword());
        session.setAttribute("role", userService.get(id).getRole());

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

