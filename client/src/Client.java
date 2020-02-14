import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {
    private ReadThread readThread;
    private WriteThread writeThread;
    @Override
    public synchronized   void run(){
        try{
             Socket socket = new Socket("192.168.56.1",5000);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            readThread=  new ReadThread(reader,this);
            writeThread =  new WriteThread(writer,this);
            writeThread.start();
            readThread.start();
        }catch (IOException  e){
            System.out.println(e.getMessage());
        }
    }
    public void Stop()
    {

        writeThread.Stop();
        readThread.Stop();
    }

}
