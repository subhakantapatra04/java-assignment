import java.net.*;
import java.io.*;
import java.util.*;

public class MultithreadedChat {

    static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1 Start Server");
        System.out.println("2 Start Client");
        System.out.print("Enter choice: ");
        int ch = sc.nextInt();

        if (ch == 1) {
            startServer();
        } else if (ch == 2) {
            startClient();
        }
    }

    static void startServer() {
        try {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server started");

            while (true) {
                Socket s = ss.accept();
                clients.add(s);
                new ClientThread(s).start();
            }

        } catch (Exception e) {
            System.out.println("Server error");
        }
    }

    static class ClientThread extends Thread {
        Socket s;

        ClientThread(Socket s) {
            this.s = s;
        }

        public void run() {
            try {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(s.getInputStream()));

                String msg;
                while ((msg = br.readLine()) != null) {
                    for (Socket c : clients) {
                        PrintWriter pw = new PrintWriter(c.getOutputStream(), true);
                        pw.println(msg);
                    }
                }

            } catch (Exception e) {
            }
        }
    }

    static void startClient() {
        try {
            Socket s = new Socket("localhost", 5000);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = br.readLine()) != null) {
                        System.out.println(msg);
                    }
                } catch (Exception e) {
                }
            }).start();

            while (true) {
                String msg = sc.nextLine();
                pw.println(msg);
            }

        } catch (Exception e) {
            System.out.println("Client error");
        }
    }
}
