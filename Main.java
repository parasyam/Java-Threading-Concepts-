import java.math.BigInteger;

public class Main{
    public static void main(String[] args){
        Inventory in=new Inventory();
        increment i=new increment(in);
        decrement d= new decrement(in);
        i.start();
        d.start();
        try{
            i.join();
            d.join();
        }
        catch(InterruptedException e){

        }
        in.show();


    }

    public static class increment extends Thread{
        Inventory inv;
        increment(Inventory inv){
            this.inv=inv;
        }
        public void run(){
            for(int i=0;i<1000;i++){
                inv.incr();
            }
        }
        
    }
    public static class decrement extends Thread{
        Inventory inv;
        decrement(Inventory inv){
            this.inv=inv;
        }
        public void run(){
            for(int i=0;i<1000;i++){
                inv.decr();
            }
        }
        
    }

    public static class Inventory{
        Object lock =new Object();
        private int item=0;
         void incr(){
            synchronized(lock){
            item++;
            }
        }
        void decr(){
            synchronized(lock){
            item--;
            }
        }
         void show(){
            System.out.println(item);
        }

    }

}