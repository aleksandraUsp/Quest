package com.javarush.quest.entities;


import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "with", buildMethodName = "get")
public class User {

    private long id;

    private String login;

    private String password;

    private Role role;

    private String image;

}
