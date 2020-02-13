import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends Thread {
    private Socket socket;
    Scanner scanner;
    WriteThread writeThread;
    ReadThread readThread;
    public ClientThread(Socket socket){
     this.socket=socket;
     scanner=new Scanner(System.in);
    }
    @Override
    public void run(){
        try {
            synchronized (this) {

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writeThread = new WriteThread(writer);
                readThread = new ReadThread(reader, this);
                writeThread.start();
                readThread.start();
                wait();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("client run  away !!!");
        }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                scanner.close();

        }
    }
    public void stopThread(){
        this.writeThread.Stop();
    }
}
