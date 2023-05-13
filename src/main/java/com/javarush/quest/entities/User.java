package com.javarush.quest.entities;

import com.javarush.quest.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "with", buildMethodName = "get")

public class User {
    private long id;

    private String login;

    private String password;

    private Role role;

    private String image;

    private Quest quest;
    private String getImage(){
        return "image"+id;

    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }
}
