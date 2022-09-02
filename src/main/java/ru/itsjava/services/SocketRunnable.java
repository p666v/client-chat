package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.net.Socket;

@RequiredArgsConstructor
public class SocketRunnable implements Runnable {
    private final Socket socket;

    @SneakyThrows
    @Override
    public void run() {
        MessageInputService serverReader = new MessageInputServiceImpl(socket.getInputStream());
        String message;
        while (true) {

            if ((message = serverReader.getMessage()) != null) {
            System.out.println(message);
            }

        }

    }
}
