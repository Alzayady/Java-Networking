import java.io.BufferedReader;
import java.io.IOException;

public class ReadThread  extends Thread{
    private BufferedReader reader;
    public ReadThread(BufferedReader reader) {
        this.reader=reader;
    }
    @Override
    public void run(){
        while (true){
            try {
                String message =reader.readLine();
                System.out.println(message);
            } catch (IOException e) {
            return;
            }
        }
    }
}
