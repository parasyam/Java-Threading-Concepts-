package thread.creation.example;
public class Main {
    public static void main(String[] args){
        Thread thread = new Thread(()->{
            System.out.println("we are in the new thread "+ Thread.currentThread().getName());
            System.out.println("current thread pripority"+ Thread.currentThread().getPriority() );

        });
        // to rename 
         thread.setName("new worker thread");
        //  to assign priority 
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("which thread we are running :"+Thread.currentThread().getName()+" this is before starting thread");
        thread.start();
        System.out.println("which thread we are running :"+Thread.currentThread().getName()+" this is After starting thread");
        

    }
}