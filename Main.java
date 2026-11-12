public class Main{
    public static void main(String[] args){
        System.out.println("before thread line");
        MyThreads t = new MyThreads();
        t.start();
       System.out.println("after thread 1");
        Thread t1= new Thread(new MyT());
        t1.start();
       
         System.out.println("after thread 2");


         Thread t2  =new Thread(()->{
           System.out.println("this is thead"+Thread.currentThread().getName());
           
         });
         t2.run();

    }
}

class MyThreads extends Thread {
    public void run(){
        System.out.println("thread is running"+ this.getName());
    }
}

class MyT implements Runnable{
    // runnable can not return a result can not throw checked exceptions 
    public void run(){
        System.out.println("thread is running with runnable ");
    }
} 