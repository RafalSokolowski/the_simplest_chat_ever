package chat.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.Socket;

@Slf4j
public class Service {

    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";

    public static void closeSocket(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            log.error("Closing socket error: " + e.getMessage());
        }
    }

    public static void giveMeInputAndOutput (Socket socket) {

    }

}
