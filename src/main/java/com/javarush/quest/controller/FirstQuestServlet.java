package com.javarush.quest.controller;

import com.javarush.quest.service.UserService;
import com.javarush.quest.util.Jsp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "FirstQuestServlet", value = "/firstQuest")
public class FirstQuestServlet extends HttpServlet {
    private final UserService userService=UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        final UserService userService=UserService.USER_SERVICE;
        //if (session.getAttribute("step") == null) {
        List<String> firstQuest = userService.getFirstQuest(0);

            session.setAttribute("step", 0);
        request.setAttribute("step", firstQuest.get(0));//request.setAttribute("step", "Ты потерял память.Принять вызов НЛО?");
        request.setAttribute("firstAnswer", firstQuest.get(1));//request.setAttribute("firstAnswer", "Принять вызов");
        request.setAttribute("secondAnswer", firstQuest.get(2));//request.setAttribute("secondAnswer", "Отклонить вызов");
            Jsp.forward(request, response, "FirstQuest");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        int step = (Integer) session.getAttribute("step");

        //if(session.getAttribute("firstAnswer")!=null){
        Long numberOfFirstAnswer = (Long) session.getAttribute("firstAnswer");
        //if(session.getAttribute("secondAnswer")!=null)
        Long numberOfSecondAnswer = (Long) session.getAttribute("secondAnswer");
        step=step+1;

        List<String> firstQuest = userService.getFirstQuest(step);
            session.setAttribute("step", step);
            request.setAttribute("step", firstQuest.get(0));
            if (!firstQuest.get(1).equals("Нет вариантов")){
            request.setAttribute("firstAnswer", firstQuest.get(1));}
            else {request.setAttribute("firstAnswer", null);}
            request.setAttribute("secondAnswer", firstQuest.get(2));
            Jsp.forward(request, response, "FirstQuest");

    }
}
