package chat.client;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class StartChatClient {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Provide your nick to join the chat (and press Enter): ");
        new ChatClient(scanner.nextLine(),"localhost",5050).start();

    }
}
