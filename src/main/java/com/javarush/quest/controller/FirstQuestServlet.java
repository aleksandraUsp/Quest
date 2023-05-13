package com.javarush.quest.controller;

import com.javarush.quest.entities.Quest;
import com.javarush.quest.service.UserService;
import com.javarush.quest.util.Jsp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@WebServlet(name = "FirstQuestServlet", value = "/firstQuest")
public class FirstQuestServlet extends HttpServlet {
    private final UserService userService=UserService.USER_SERVICE;
    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getServletContext().setAttribute("duringStation", Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,
                11,12,13,14));
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> firstQuest = userService.getFirstQuest();
        request.setAttribute("step", firstQuest.get(0));
        request.setAttribute("firstAnswer", firstQuest.get(1));
        request.setAttribute("secondAnswer", firstQuest.get(2));
        Jsp.forward(request,response,"FirstQuest");
    }

}
