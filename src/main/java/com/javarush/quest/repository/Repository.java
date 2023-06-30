package com.javarush.quest.repository;

import java.util.Collection;


public interface Repository<T> {

    Collection<T> getAll();
    Collection<T>find (T pattern);

   T get(long id);

    long create(T entity);

    void update(T entity);

    void delete(T entity);
}
