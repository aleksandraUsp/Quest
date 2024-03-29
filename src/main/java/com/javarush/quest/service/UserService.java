package com.javarush.quest.service;

import com.javarush.quest.entities.Game;
import com.javarush.quest.entities.Quest;
import com.javarush.quest.entities.User;
import com.javarush.quest.repository.Repository;
import com.javarush.quest.repository.UserRepository;


import java.util.Collection;
import java.util.List;


public enum UserService {

    USER_SERVICE;

    private final Repository<User> userRepository = new UserRepository();

    public long create(User user) {
        long id=userRepository.create(user);
        return id;
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public Collection<User> getAll() {
        return userRepository.getAll();
    }

    public User get(long id) {
        return userRepository.get(id);
    }

    public List<String> getFirstQuest(int duringStep) {
            Quest quest = new Quest();
            String step = quest.getQuestStep(duringStep);
            String firstAnswer = quest.getFirstAnswer(duringStep);
            String secondAnswer = quest.getSecondAnswer(duringStep);
            return List.of(step, firstAnswer, secondAnswer);
        /*} else {
            Quest quest = get(id).getQuest();
            String step = quest.getQuestStep(duringStep);
            String firstAnswer = quest.getFirstAnswer(duringStep);
            String secondAnswer = quest.getSecondAnswer(duringStep);
            return List.of(step, firstAnswer, secondAnswer);
        }*/
    }
    public int getNextStep(int step, int numberOfAnswer){
        int nextStep;
        if (step==0 & numberOfAnswer==1) nextStep=1;
        else if (step==0 & numberOfAnswer==2) nextStep=6;
        else if (step==1 & numberOfAnswer==1) nextStep=2;
        else if (step==1 & numberOfAnswer==2) nextStep=4;
        else if (step==2 & numberOfAnswer==1) nextStep=3;
        else if (step==2 & numberOfAnswer==2) nextStep=5;
        else nextStep=1000001; //ошибка
        return nextStep;
    }

    public Game getGameState(int step){
      if (step==3) return Game.WIN;
      if (step==4 || step==5 || step==6) return Game.LOSE;
      else return Game.GAME;
    }
}
