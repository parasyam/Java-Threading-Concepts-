public class Main{
    static final Object lock = new Object();
    static int num=1;
    public static void main(String[] args){

        Thread odd =new Thread(()->{
            while(num<100){
                synchronized(lock){
                    if(num%2==0){
                        try{
                            lock.wait();
                        }
                        catch(InterruptedException e){

                        }
                    }
        System.out.println("odd"+num);
           num++;
           lock.notify();

                }
            }
        });


         Thread even =new Thread(()->{
           while(num<100){
          synchronized (lock) {
           if(num%2==1){
            try{
                lock.wait();
            }catch(InterruptedException e){

            }
            
           }
           System.out.println("even"+num);
           num++;
           lock.notify();


          }
           }
        });
        odd.start();
        even.start();


    }
}