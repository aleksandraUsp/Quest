package com.javarush.quest.service;

import com.javarush.quest.entities.Quest;
import com.javarush.quest.entities.User;
import com.javarush.quest.repository.Repository;
import com.javarush.quest.repository.UserRepository;
import java.util.Collection;
import java.util.List;


public enum UserService {

    USER_SERVICE;

    private final Repository<User> userRepository = new UserRepository();

    public void create(User user) {
        userRepository.create(user);
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
}
