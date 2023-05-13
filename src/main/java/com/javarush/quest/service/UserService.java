package com.javarush.quest.service;

import com.javarush.quest.entities.Quest;
import com.javarush.quest.entities.User;
import com.javarush.quest.repository.Repository;
import com.javarush.quest.repository.UserRepository;
import java.util.Collection;
import java.util.List;
import static com.javarush.quest.entities.Quest.*;

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
    @SuppressWarnings("UnnecessaryLocalVariable")
    public List<String> getFirstQuest(){
        Quest quest=null;
        if (quest==null) quest=new Quest(0,1,11);
        //else
        List<String> condition= List.of (
                questStations[quest.getDuringStep()],
                questStations[quest.getFirstAnswer()],
                questStations[quest.getSecondAnswer()]
        );

        return condition;
    }
}
