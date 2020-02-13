import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Object object = new Object();
        try(Socket socket = new Socket("192.168.56.1",5000)){
            synchronized (object) {
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                new ReadThread(reader).start();
                new WriteThread(writer).start();
                object.wait();
            }
        }catch (IOException | InterruptedException e ){
            System.out.println(e.getMessage());
        }
    }
}
