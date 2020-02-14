import java.io.PrintWriter;
import java.util.Scanner;

public class WriteThread extends Thread {
    private Scanner scanner;
    private PrintWriter writer;
    private Boolean continues=true;
    private Client client;
    public  WriteThread(PrintWriter writer, Client client){
        scanner=new Scanner(System.in);
        this.client=client;
        this.writer=writer;
    }
    @Override
    public void run(){
        while (continues){
                String message =scanner.nextLine();
                if(continues)
                writer.println(message);
                if(message.equals("exit")){
                    client.Stop();
                    return;
                }
            }
        }

    public  void Stop(){
        this.continues=false;
        scanner.close();
    }
}
