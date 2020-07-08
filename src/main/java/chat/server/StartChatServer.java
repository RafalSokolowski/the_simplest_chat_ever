package chat.server;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;

@Slf4j
public class StartChatServer {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5050)) {
            log.info("Waiting for the chat member connection...");

            while (true) {
//                new ChatServer(serverSocket.accept()).start();
                ChatServer chatServer = new ChatServer(serverSocket.accept());
                chatServer.start();
                log.info("New member has joined the chat on: " + chatServer.getSocket());
            }

        } catch (IOException e) {
            log.error("Chat server start error: " + e.getMessage());
        }

    }
}
