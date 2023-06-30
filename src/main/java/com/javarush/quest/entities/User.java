package com.javarush.quest.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "with", buildMethodName = "get")

public class User {
    private long id;

    private String login;

    private String password;

    private Role role;

   /*private Quest quest;


    public Quest getQuest() {
         return new Quest();
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    */
}
