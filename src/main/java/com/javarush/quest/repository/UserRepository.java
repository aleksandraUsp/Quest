package com.javarush.quest.repository;

import com.javarush.quest.entities.Role;
import com.javarush.quest.entities.User;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository implements Repository<User> {

    private volatile long id=1;
    public Map<Long, User> map = new HashMap<>();

    public UserRepository() {
        map.put(1L, new User(id, "Petr", "3456", Role.USER));
        map.put(2L, new User(incrementId(),"Artur","", Role.GUEST));
        map.put(3L, new User(incrementId(),"Olga","1234", Role.ADMIN));

}

    public synchronized long incrementId() {
        return id++;
    }

    @Override
    public Collection<User> getAll() {
        return map.values();
    }

    @Override
    public Collection<User> find(User pattern) {
        return null;
    }

    @Override
    public User get(long id) {
        return map.get(id);
    }

    @Override
    public long create(User entity) {
        long userIdInRepository=incrementId();
        entity.setId(userIdInRepository);
        update(entity);
        return userIdInRepository;
    }

    @Override
    public void update(User entity) {
        map.put(entity.getId(), entity);
    }

    @Override
    public void delete(User entity) {
        map.remove(entity.getId());
    }
}
