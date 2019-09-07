import java.util.Random;

public class Wiener{

     public static void main(String []args){
        System.out.println("Hello World");
        
        double T=1.0d;
        int N=100000;
        double h=T/N;
        double sum=0.0d;
        
        Random rand=new Random();
        
        for(int i=1;i<N+1;i++)
        {
            if(i%1000==0)System.out.println(h*i+":"+sum+",");
            sum+=rand.nextGaussian()*Math.sqrt(h);
        }
     }
}