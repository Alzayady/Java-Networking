import java.io.BufferedReader;
import java.io.IOException;

public class ReadThread  extends Thread{
    private BufferedReader reader;
    private ClientThread clientThread;
    private Boolean continues =true;
    public ReadThread(BufferedReader reader, ClientThread clientThread) {
        this.reader=reader;
        this.clientThread=clientThread;
    }
    @Override
    public void run(){
        while (continues){
            try {
                String message =reader.readLine();
                if(message.equals("exit")){
                    System.out.println("clint exit ");
                    clientThread.stopThread();
                    return;
                }
                if(continues)
                System.out.println(message);
            } catch (IOException e) {
                return;
            }
        }
    }
    public void Stop(){
        this.continues=false;
    }
}
