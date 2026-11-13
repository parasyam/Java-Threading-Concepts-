import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class Main{
    public static void main   (String[] parms)throws Exception{
        List<Integer> a=new ArrayList<>();
        for(int i=0;i<10;i++){
            a.add(i);
        }
        ExecutorService ex=Executors.newFixedThreadPool(2);
        int mid =a.size()/2;
        Callable<Integer> task1=()->{
            int sum=0;
            for (int i = 0; i < mid; i++) {
                sum += a.get(i);
            }
            return sum;
        };
        Callable<Integer> task2=()->{
            int sum=0;
            for(int i=mid;i<10;i++){
                sum+=a.get(i);
            }
            return sum;

        };
        Future<Integer> f1=ex.submit(task1);
        Future<Integer> f2=ex.submit(task2);
       int total = f1.get() + f2.get();
        System.out.println("Final Sum: " + total);
         ex.shutdown();

       
        

      
        
    }
}