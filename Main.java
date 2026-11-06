package thread.creation.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static final int maxim=999;
    
    public static void main(String[] args){
        Random randon= new Random();
        Valt valt = new Valt(randon.nextInt(maxim));
        List<Thread> threads =new ArrayList<>();
        threads.add(new AscendingHacker(valt));
        threads.add(new DescendingHacker(valt));
        threads.add(new Police());
        for(Thread thread : threads){
            thread.start();
        }


    }
    
    public static class Valt{
        private int password;
        public Valt(int password){
            this.password=password;
        }
        public boolean isCorrectPassword(int guess){
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                
            }
            return this.password==guess;
        }
    }

    public static abstract class HackerThread extends Thread{

        protected Valt valt;
        public HackerThread(Valt valt){
            this.valt=valt;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(MAX_PRIORITY);
        }
        public void start(){
            System.out.println("Starting thread: "+this.getName());
            super.start();
        }
    }

    public static class AscendingHacker extends HackerThread{
        public AscendingHacker(Valt valt){
            super(valt);
        }
        @Override 
        public void run(){
            for(int i=0;i<maxim;i++){
                if(valt.isCorrectPassword(i)){
                    System.out.println(this.getName()+"guessed the password "+ i);
                    System.exit(0);
                }
            }

        }
    }

    public static class DescendingHacker extends HackerThread{
        public DescendingHacker(Valt valt){
            super(valt);
        }
        @Override 
        public void run(){
            for(int i=maxim;i>=0;i--){
                if(valt.isCorrectPassword(i)){
                    System.out.println(this.getName()+"guessed the password "+ i);
                    System.exit(0);
                }
            }

        }

    }
   
    public static class Police extends Thread{
        @Override 
        public void run(){
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    
                }
                
            }
            System.out.println("Hackers are caught");
            System.exit(0);
        }
    }
}