import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main{
    static final Object lock = new Object();
    public static void main(String[] args){
    Bank account1=new Bank(10000,1);
    Bank account2=new Bank(4000,2);
    Thread t1=new Thread(()->{
        int transfer=100;
        for(int i=0;i<1000;i++){
        transfer(account1, account2, 100);
        }

    });
    Thread t2=new Thread(()->{
        int transfer=100;
         for(int i=0;i<1000;i++){
             transfer(account2, account1, 100);
       
         }

    });
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch(InterruptedException e){

        }
        account1.show();
        account2.show();

    }
  
    public static class Bank {
        int balance;
        int id;
        ReentrantLock lock = new ReentrantLock();
        Bank(int balance, int id ){
            this.balance=balance;
            this.id=id;


        }
        void show(){
            System.out.println(balance);
        }
        
        
        
        
        
    }
    public static void transfer(Bank a , Bank b , int amount){
     Bank first ;
     Bank second ;
     if(a.id<b.id){
         first=a;
         second=b;
     }
     else{
         first=b;
         second=a;
     }
     while(true){
         if(first.lock.tryLock()){
             try{
                 if (second.lock.tryLock()) {
                     try{
                      if (a.balance >= amount) {
                             a.balance -= amount;
                             b.balance += amount;
                             System.out.println("Transfer successful");
                         }
                         return ;
                     }
                     finally{
                         second.lock.unlock();
                     }
                 }
             }
             finally{
                 first.lock.unlock();

             }
         }
     }


    }
     
}