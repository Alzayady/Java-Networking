import java.io.BufferedReader;
import java.io.IOException;

public class ReadThread  extends Thread{
    private BufferedReader reader;
    private Client client;
    private Boolean continues =true;
    public ReadThread(BufferedReader reader, Client client) {
        this.reader=reader;
        this.client=client;
    }
    @Override
    public void run(){
        while (continues){
            try {
                String message =reader.readLine();
                if(message.equals("exit")){
                    System.out.println("client run away");
                    client.Stop();
                    return;
                }
                if (continues)
                System.out.println(message);
            } catch (IOException e) {
            return;
            }
        }
    }
    public  void Stop(){
        this.continues=false;
    }
}
