import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main{
    static Semaphore s=new Semaphore(5);
    public static void parking(int vechile){
        try{
            s.acquire();
            System.out.println("Vehicle " + vechile + " entered parking");
             Thread.sleep(5000);
            System.out.println("Vehicle " + vechile + " left parking");
            s.release();

        }catch(InterruptedException e){
            
        }

    }
    public static void main(String[] parms){
        List<Thread> l=new ArrayList<>();
        for(int i=0;i<10;i++){
            int vechile=i+1;
            Thread t=new Thread(()->{
                parking(vechile);
            });
            l.add(t);
            
        }
        for(Thread i:l){
            i.start();
        }
    }
}