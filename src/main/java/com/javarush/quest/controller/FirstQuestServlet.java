package com.javarush.quest.controller;

import com.javarush.quest.entities.Game;
import com.javarush.quest.service.UserService;
import com.javarush.quest.util.Jsp;
import com.javarush.quest.util.QuestException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@WebServlet(name = "FirstQuestServlet", value = "/firstQuest")
public class FirstQuestServlet extends HttpServlet {
    private final UserService userService=UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        final UserService userService=UserService.USER_SERVICE;
        //if (session.getAttribute("step") == null) {
        List<String> firstQuest = userService.getFirstQuest(0);

        session.setAttribute("numberOfStep", 0);
        request.setAttribute("step", firstQuest.get(0));//request.setAttribute("step", "Ты потерял память.Принять вызов НЛО?");
        request.setAttribute("firstAnswer", firstQuest.get(1));//request.setAttribute("firstAnswer", "Принять вызов");
        request.setAttribute("secondAnswer", firstQuest.get(2));//request.setAttribute("secondAnswer", "Отклонить вызов");
            Jsp.forward(request, response, "FirstQuest");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int numberOfStep, answer;
        Optional<String> optionalOfStep = Optional.ofNullable(request.getParameter("numberOfStep"));
        numberOfStep = optionalOfStep.map(Integer::parseInt).orElse(0);

        answer = 0;

        Optional<String> optionalOfNumberOfFirstAnswer = Optional.ofNullable(request.getParameter("numberOfFirstAnswer"));
        if (optionalOfNumberOfFirstAnswer.isPresent()) {
            int numberOfFirstAnswer = Integer.parseInt(optionalOfNumberOfFirstAnswer.get());
            answer = 1;
        }

        Optional<String> optionalOfNumberOfSecondAnswer = Optional.ofNullable(request.getParameter("numberOfSecondAnswer"));
        if (optionalOfNumberOfSecondAnswer.isPresent()) {
            int numberOfSecondAnswer = Integer.parseInt(optionalOfNumberOfSecondAnswer.get());
            answer = 2;
        }

        if (optionalOfNumberOfFirstAnswer.isEmpty() && optionalOfNumberOfSecondAnswer.isEmpty())
            throw new QuestException("Не выбран первый или второй вариант!");

        if (answer != 1 && answer != 2)
            throw new QuestException("Не выбран первый или второй вариант!");


        int nextStep = userService.getNextStep(numberOfStep, answer);
        if (nextStep == 1000001) throw new QuestException("Что-то пошло не так!");

        Game state=userService.getGameState(nextStep);
        if (state==Game.WIN || state==Game.LOSE){
            session.setAttribute("numberOfStep", nextStep);
            Jsp.forward(request, response, "FinalPage");}

        else numberOfStep = nextStep;


        List<String> firstQuest = userService.getFirstQuest(numberOfStep);
        session.setAttribute("numberOfStep", numberOfStep);
        request.setAttribute("step", firstQuest.get(0));
        //if (!firstQuest.get(1).equals("Нет вариантов")){
        request.setAttribute("firstAnswer", firstQuest.get(1));
        //else {request.setAttribute("firstAnswer", null);}
        request.setAttribute("secondAnswer", firstQuest.get(2));
        Jsp.forward(request, response, "FirstQuest");

    }
}
