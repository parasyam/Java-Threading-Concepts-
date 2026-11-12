import java.math.BigInteger;

public class Main{
    public static void main(String[] args){

  BigInteger base=new BigInteger("10");
  BigInteger power=new BigInteger("20");
  Thread c=new Thread(new Compu(base,power));
  c.start();
  try{
    Thread.sleep(1000);
  }
  catch(InterruptedException e){

  }
  c.interrupt();
    }

    public static class Compu implements Runnable{
        private BigInteger base;
        private BigInteger power;
         private BigInteger r=BigInteger.ONE;
         Compu(BigInteger base,BigInteger power){
            this.base=base;
            this.power=power;

         }
        
        public void run(){
            
            for(BigInteger i=BigInteger.ZERO;i.compareTo(power)<0;i=i.add(BigInteger.ONE)){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("it is intruppted");
                    return ;
                }
                r=r.multiply(base);
            }
            System.out.println(r);

        }

    }

}