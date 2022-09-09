package ru.itsjava.services;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.PrintWriter;

@Getter
@AllArgsConstructor

public class MenuServiceImp implements MenuService {

    private PrintWriter serverWriter;
    private MessageInputService messageInputService;

    @Override
    public void menu() {
        System.out.println("Меню:\n" +
                "0. Выход\n" +
                "1. Регистрация\n" +
                "2. Авторизация\n");
    }

    @Override
    public void printMenu() {
        menu();
        switch (messageInputService.getMessage()) {
            case "0": {
                System.out.println("Вы покидаете чат");
                serverWriter.println("!Exit!");
                serverWriter.flush();
                serverWriter.close();
                System.exit(0);
                break;
            }
            case "1": {
                System.out.println("РЕГИСТРАЦИЯ");

                System.out.println("Придумайте свой логин:");
                String login = messageInputService.getMessage();

                System.out.println("Придумайте свой пароль:");
                String password = messageInputService.getMessage();

                serverWriter.println("!Registration!" + login + ":" + password);
                serverWriter.flush();
                printMenu();
                break;
            }
            case "2": {
                System.out.println("АВТОРИЗАЦИЯ");

                System.out.println("Введите свой логин:");
                String login = messageInputService.getMessage();

                System.out.println("Введите свой пароль:");
                String password = messageInputService.getMessage();

                serverWriter.println("!autho!" + login + ":" + password);
                serverWriter.flush();
                break;
            }

        }

    }

}
