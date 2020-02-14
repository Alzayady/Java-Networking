import java.io.PrintWriter;
import java.util.Scanner;

public class WriteThread extends Thread {
    private Scanner scanner;
    private PrintWriter writer;
    Boolean continues=true;
    private  ClientThread clientThread;
    public  WriteThread(PrintWriter writer, ClientThread clientThread){
        scanner=new Scanner(System.in);
        this.writer=writer;
        this.clientThread=clientThread;
    }
    @Override
    public void run(){
        while (continues){
            String message=scanner.nextLine();
            if(!continues){
                return;
            }
            writer.println(message);
            if(message.equals("exit")){
                clientThread.stopThread();
                return;
            }
        }
    }
    public  void Stop()
    {
        this.continues=false;
        scanner.close();
    }
}
