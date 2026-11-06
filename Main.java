package thread.creation.example;
public class Main {
    public static void main(String[] args){
        Thread thread = new Thread(()->{
            System.out.println("we are in the new thread "+ Thread.currentThread().getName());
            System.out.println("current thread pripority"+ Thread.currentThread().getPriority() );
             throw new RuntimeException("Something went wrong!");

        });
        // to rename 
         thread.setName("new worker thread");
        //  to assign priority 
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        thread.setUncaughtExceptionHandler((t,e)->{
            System.out.println("A critical error happend in thead "+ t.getName()+"the errror is"+e.getMessage());
        });
       
    }
}