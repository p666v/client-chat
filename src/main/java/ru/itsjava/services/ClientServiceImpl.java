package ru.itsjava.services;

import lombok.SneakyThrows;

import java.io.PrintWriter;
import java.net.Socket;

public class ClientServiceImpl implements ClientService {
    public final static int PORT = 8081;
    public final static String HOST = "localhost";

    @SneakyThrows
    @Override
    public void start() {
        Socket socket = new Socket(HOST, PORT);

        if (socket.isConnected()) {
            new Thread(new SocketRunnable(socket)).start();

            PrintWriter serverWriter = new PrintWriter(socket.getOutputStream());
            MessageInputService messageInputService = new MessageInputServiceImpl(System.in);

            MenuService menuService = new MenuServiceImp(serverWriter, messageInputService);
            menuService.printMenu();

            while (true) {
                System.out.println("----------------------");
                String consoleMessage = messageInputService.getMessage();
                serverWriter.println(consoleMessage);
                serverWriter.flush();
                if (consoleMessage.equals("!Exit!")) {
                    System.exit(0);
                }
            }
        }
    }
}
