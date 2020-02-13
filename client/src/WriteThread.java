import java.io.PrintWriter;
import java.util.Scanner;

public class WriteThread extends Thread {
    private Scanner scanner;
    private PrintWriter writer;
    Boolean continues=true;
    public  WriteThread(PrintWriter writer){
        scanner=new Scanner(System.in);
        this.writer=writer;
    }
    @Override
    public void run(){
        while (continues){
            writer.println(scanner.nextLine());
        }
    }
    public  void Stop(){
        this.continues=false;
    }
}
