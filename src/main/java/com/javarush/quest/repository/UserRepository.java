package com.javarush.quest.repository;

import com.javarush.quest.entities.Role;
import com.javarush.quest.entities.User;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository implements Repository<User> {

    public final AtomicLong id = new AtomicLong(4);
    public Map<Long, User> map = new HashMap<>();

    public UserRepository() {
        map.put(1L, new User(1L, "Petr", "3456", Role.USER, "image-1.jpg"));
        map.put(2L, new User(2L,"Artur","", Role.GUEST, "image-2.jpg"));
        map.put(3L, new User(3L,"Olga","1234", Role.ADMIN, "image-3.png"));

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
    public void create(User entity) {
        entity.setId(id.incrementAndGet());
        update(entity);
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
