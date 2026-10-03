package com.jonny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс приложения.
 * @SpringBootApplication — это «магическая» аннотация, которая:
 * 1. Включает автоконфигурацию Spring Boot
 * 2. Включает сканирование компонентов (ищет классы с @Component, @Service и т.д.)
 * 3. Отмечает этот класс как конфигурационный
 */
@SpringBootApplication
public class BotApplication {
    public static void main(String[] args) {
        System.setProperty("socksProxyHost", System.getenv("VPS_HOST"));
        System.setProperty("socksProxyPort", "2026");
        SpringApplication.run(BotApplication.class, args);
    }
}
