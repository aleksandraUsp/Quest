package com.javarush.quest.config;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Configg {

    public static final Path WEB_INF= Paths.get(URI.create(Objects.requireNonNull(
            Configg.class.getResource("/")   //обращение к папке \\target\\...\\classes\\
            ).toString())).
            getParent();

}
