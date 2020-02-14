import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args)   {
//        InetAddress inetAddress = InetAddress.getLocalHost();
//        System.out.println("IP Address:- " + inetAddress.getHostAddress());
//        System.out.println("Host Name:- " + inetAddress.getHostName());
            try (ServerSocket serverSocket = new ServerSocket(5000)) {
                new ClientThread(serverSocket.accept()).start();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
