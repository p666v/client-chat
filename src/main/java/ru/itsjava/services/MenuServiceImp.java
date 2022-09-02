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
                "1. Авторизация\n" +
                "2. Регистрация\n" +
                "0. Выход\n");
    }

    @Override
    public void printMenu() {
        menu();
        switch (messageInputService.getMessage()) {
            case "1": {
                System.out.println("ВЫ ВЫБРАЛИ АВТОРИЗАЦИЮ");

                System.out.println("Введите свой логин:");
                String login = messageInputService.getMessage();

                System.out.println("Введите свой пароль:");
                String password = messageInputService.getMessage();

                serverWriter.println("!autho!" + login + ":" + password);
                serverWriter.flush();
                break;
            }
            case "2": {
                System.out.println("ВЫ ВЫБРАЛИ РЕГИСТРАЦИЮ");

                System.out.println("Придумайте свой логин:");
                String login = messageInputService.getMessage();

                System.out.println("Придумайте свой пароль:");
                String password = messageInputService.getMessage();

                serverWriter.println("!Registration!" + login + ":" + password);
                serverWriter.flush();
                break;
            }
            case "0": {
                System.out.println("Вы покидаете чат");
                serverWriter.println("!Exit!");
                serverWriter.flush();
                serverWriter.close();
                System.exit(0);

                break;
            }

        }
    }

}
