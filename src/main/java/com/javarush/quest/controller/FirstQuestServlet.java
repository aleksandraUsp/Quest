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
    private final UserService userService = UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        final UserService userService = UserService.USER_SERVICE;
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
        String winState = "Вы выиграли! Поздравляем!!!";
        String loseState = "Вы проиграли. Нам очень жаль. Попробуете еще?";
        int numberOfStep, answer;
        Optional<String> optionalOfStep = Optional.ofNullable(request.getParameter("numberOfStep"));
        numberOfStep = optionalOfStep.map(Integer::parseInt).orElse(0);

        answer = 0;

        Optional<String> optionalOfNumberOfFirstAnswer = Optional.ofNullable(request.getParameter("numberOfFirstAnswer"));
        if (optionalOfNumberOfFirstAnswer.isPresent()) {
            answer = 1;
        }

        Optional<String> optionalOfNumberOfSecondAnswer = Optional.ofNullable(request.getParameter("numberOfSecondAnswer"));
        if (optionalOfNumberOfSecondAnswer.isPresent()) {
            answer = 2;
        }

        if (optionalOfNumberOfFirstAnswer.isEmpty() && optionalOfNumberOfSecondAnswer.isEmpty())
            throw new QuestException("Не выбран первый или второй вариант!");

        if (answer != 1 && answer != 2)
            throw new QuestException("Не выбран первый или второй вариант!");


        int nextStep = userService.getNextStep(numberOfStep, answer);
        if (nextStep == 1000001) throw new QuestException("Что-то пошло не так!");

        Game state = userService.getGameState(nextStep);
        session.setAttribute("numberOfStep", nextStep);
        session.setAttribute("finalState", state);   // set Game.WIN or Game.GAME or Game.LOSE

        if (state == Game.WIN) {
            session.setAttribute("finalStateString", winState);
            Jsp.forward(request, response, "FinalPage");
        }
        if (state == Game.LOSE) {
            session.setAttribute("finalStateString", loseState);
            Jsp.forward(request, response, "FinalPage");
        } else numberOfStep = nextStep;


        List<String> firstQuest = userService.getFirstQuest(numberOfStep);
        session.setAttribute("numberOfStep", numberOfStep);
        request.setAttribute("step", firstQuest.get(0));
        request.setAttribute("firstAnswer", firstQuest.get(1));
        request.setAttribute("secondAnswer", firstQuest.get(2));
        Jsp.forward(request, response, "FirstQuest");

    }
}
