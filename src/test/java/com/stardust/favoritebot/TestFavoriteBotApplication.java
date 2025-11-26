package com.stardust.favoritebot;

import org.springframework.boot.SpringApplication;

public class TestFavoriteBotApplication {

    public static void main(String[] args) {
        SpringApplication.from(FavoriteBotApplication::main).with(TestcontainersConfiguration.class).run(args);
    }
}
