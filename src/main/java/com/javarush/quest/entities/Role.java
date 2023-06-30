package com.javarush.quest.entities;

import com.javarush.quest.util.QuestException;

public enum Role {
    USER, ADMIN, GUEST;

    public static Role getRole(String role){
        if (role.equals("USER"))
        return USER;
        else if (role.equals("ADMIN"))
            return ADMIN;
        else if (role.equals("GUEST")) return GUEST;
        else throw new QuestException("Неизвестна роль пользователя");
    }
}

