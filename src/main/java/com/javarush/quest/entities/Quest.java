package com.javarush.quest.entities;
import java.util.HashMap;
import java.util.Map;

public class Quest {
    public Quest() {
   }

    public String getQuestStep(int step) {
        Map<Integer, String> questSteps=new HashMap<>();
        questSteps.put(0, "Ты потерял память.Принять вызов НЛО?");
        questSteps.put(1, "Ты принял вызов. Поднимаешься на мостик к капитану?");
        questSteps.put(2, "Ты поднялся на мостик. Ты кто?");
        questSteps.put(3, "Тебя вернули домой. Победа");
        questSteps.put(4, "Ты не пошел на переговоры. Поражение");
        questSteps.put(5, "Твою ложь разоблачили. Поражение");
        questSteps.put(6, "Ты отклонил вызов. Поражение");
        String stepString=questSteps.get(step);
        return stepString;
    }
    public String getFirstAnswer(int step) {
        if(step<=2){
        Map<Integer, String> firstAnswers=new HashMap<>();
        firstAnswers.put(0, "Принять вызов");
        firstAnswers.put(1, "Подняться на мостик");
        firstAnswers.put(2, "Рассказать правду о себе");
        return firstAnswers.get(step);}
        else return "Нет вариантов";
    }

   public String getSecondAnswer(int step) {
       if(step<=2){
       Map<Integer, String> secondAnswers=new HashMap<>();
       secondAnswers.put(0, "Отклонить вызов");
       secondAnswers.put(1, "Отказаться подниматься на мостик");
       secondAnswers.put(2, "Солгать о себе");
       return secondAnswers.get(step);}
       else return "Нет вариантов";
    }
}
