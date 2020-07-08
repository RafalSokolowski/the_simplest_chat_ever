package chat.server;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static chat.util.Service.closeSocket;

@Slf4j
@AllArgsConstructor
@Getter
public class ChatServer extends Thread {

    private final Socket socket;

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String message = "";
            while (true) {
                message = input.readLine();
                if (message.matches("(.*) has left the chat(.*)")) {
                    System.out.printf("Message from [%s:%d] %s\n", socket.getInetAddress(), socket.getPort(), message);
                    break;
                }
                System.out.printf("Message from [%s:%d] %s\n", socket.getInetAddress(), socket.getPort(), message);
            }

        } catch (IOException e) {
            log.error("Server error: " + e.getMessage());
        } finally {
            closeSocket(socket);
        }

    }

}
