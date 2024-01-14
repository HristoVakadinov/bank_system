import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try(
                Socket socket = new Socket("127.0.0.1", 1211);
                Scanner receiver = new Scanner(socket.getInputStream());
                Scanner scan = new Scanner(System.in);
                PrintWriter sender = new PrintWriter(socket.getOutputStream(), true);
                ) {
            System.out.println("Connection established");
//            while (true) {
//                String message = receiver.nextLine();
//                if (message.equals("END")) {
//                    break;
//                }
//                System.out.println(message);
//                message = scan.nextLine();
//                sender.println(message);
//            }

            while (receiver.hasNextLine()) {
                String message = receiver.nextLine();
                if (message.equals("END")) {
                    break;
                }
                System.out.println(message);
                message = scan.nextLine();
                sender.println(message);
            }
        }
    }
}
