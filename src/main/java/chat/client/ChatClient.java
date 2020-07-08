package chat.client;

import ch.qos.logback.core.spi.ScanException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import static chat.util.Service.RED;
import static chat.util.Service.BLUE;
import static chat.util.Service.RESET;

@Slf4j
@AllArgsConstructor
public class ChatClient {

    //    private final Socket socket;
    @Getter
    private final String name;
    private final String host;
    private final int port;

    public void start() {
        try (Socket socket = new Socket(host, port)) {

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            log.info("Hello " + name + " you can start chatting :)");

            String message ="";
            while (true) {
                System.out.print("Write your message (or \"exit\" to leave): ");
                message= scanner.nextLine();
                if ("exit".equalsIgnoreCase(message)) {
                    output.println( RED + name + " has left the chat" + RESET);
                    break;
                }
                output.println( RED + name + RESET + ": " + BLUE + message + RESET);
            }

        } catch (UnknownHostException e) {
            log.error("Host is unknown: " + e.getMessage());
        } catch (IOException e) {
            log.error("Initialization socket error: " + e.getMessage());
        }
    }

}
