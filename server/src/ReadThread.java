import java.io.BufferedReader;
import java.io.IOException;

public class ReadThread  extends Thread{
    private BufferedReader reader;
    private ClientThread clientThread;
    public ReadThread(BufferedReader reader, ClientThread clientThread) {
        this.reader=reader;
        this.clientThread=clientThread;
    }
    @Override
    public void run(){
        while (true){
            try {
                String message =reader.readLine();
//                if(message.equals("exit")){
//                    System.out.println("clint exit ");
//                    clientThread.stopThread();
//                    return;
//                }
                System.out.println(message);
            } catch (IOException e) {
                return;
            }
        }
    }
}
