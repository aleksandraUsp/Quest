package com.javarush.quest.entities;

import java.util.*;

public class Quest {

    List<Integer> firstAnswers= Arrays.asList(1,2,3,5,6,13,7,9,14,10,13,12,13);
    List<Integer> secondAnswers= Arrays.asList(11,0,4,0,8,0,0,0,0,0,0,0);
    public static String[] questStations=new String[]{
            "Ты потерял память.\n Принять вызов НЛО?", //0
            "Принять вызов",//1
            "Ты принял вызов. Поднимаешься на мостик к капитану?",//2
            "Подняться на мостик",//3
            "Отказаться подниматься на мостик",//4
            "Ты поднялся на мостик. Ты кто?",//5
            "Ты не пошел на переговоры. Поражение",//6
            "Рассказать правду о себе",//7
            "Солгать о себе",//8
            "Тебя вернули домой. Победа",//9
            "Твою ложь разоблачили. Поражение",//10
            "Отклонить вызов", //11
            "Ты отклонил вызов. Поражение", //12
            "Поражение!!!",//13 - выводится при поражении в конце квеста
            "Победа!!!"//14
     };
    private int duringStep;
    private int firstAnswer;
    private int secondAnswer;

    public Quest(int duringStep, int firstAnswer, int secondAnswer) {
        this.duringStep= duringStep;
        this.firstAnswer= firstAnswer;
        this.secondAnswer=secondAnswer;
    }

    public List<Integer> getFirstAnswers() {
        return firstAnswers;
    }

    public List<Integer> getSecondAnswers() {
        return secondAnswers;
    }

    public static String[] getQuestStations() {
        return questStations;
    }

    public int getDuringStep() {
        return duringStep;
    }

    public int getFirstAnswer() {
        return firstAnswer;
    }

    public int getSecondAnswer() {
        return secondAnswer;
    }

    public void setFirstAnswers(List<Integer> firstAnswers) {
        this.firstAnswers = firstAnswers;
    }

    public void setSecondAnswers(List<Integer> secondAnswers) {
        this.secondAnswers = secondAnswers;
    }

    public void setQuestStations(String[] questStations) {
        this.questStations = questStations;
    }

    public void setDuringStation(int duringStation) {
        this.duringStep = duringStep;
    }

    public void setFirstAnswer(int firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public void setSecondAnswer(int secondAnswer) {
        this.secondAnswer = secondAnswer;
    }
}
