package com.javarush.quest.controller;

import com.javarush.quest.entities.Game;
import com.javarush.quest.service.UserService;
import com.javarush.quest.util.Jsp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "FinalPageServlet", value = "/FinalPage")
public class FinalServlet extends HttpServlet {
    private final UserService userService = UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String winState = "Вы выиграли! Поздравляем!!!";
        String loseState = "Вы проиграли. Нам очень жаль. Попробуете еще?";

        Optional<String> optionalOfStep = Optional.ofNullable(request.getParameter("numberOfStep"));
        int numberOfStep = optionalOfStep.map(Integer::parseInt).orElse(300);
        Game state = userService.getGameState(numberOfStep);
        if (state == Game.WIN) {
            session.setAttribute("finalStateString", winState);
            session.setAttribute("finalState", Game.WIN);
        }
        if (state == Game.LOSE) {
            session.setAttribute("finalStateString", loseState);
            session.setAttribute("finalState", Game.LOSE);
        }

        Jsp.forward(request, response, "FinalPage");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String winState = "Вы выиграли! Поздравляем!!!";
        String loseState = "Вы проиграли. Нам очень жаль. Попробуете еще?";

        Optional<String> optionalOfStep = Optional.ofNullable(request.getParameter("numberOfStep"));
        int numberOfStep = optionalOfStep.map(Integer::parseInt).orElse(300);
        Game state = userService.getGameState(numberOfStep);
        if (state == Game.WIN) {
            session.setAttribute("finalStateString", winState);
            session.setAttribute("finalState", Game.WIN);
        }
        if (state == Game.LOSE) {
            session.setAttribute("finalStateString", loseState);
            session.setAttribute("finalState", Game.LOSE);
        }

        Jsp.forward(request, response, "FinalPage");

    }
}
