import java.util.Random;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Wiener{

     public static void main(String []args){
        System.out.println("Hello World");
        
        double T=1.0d;
        int N=100000;
        double h=T/N;
        double sum=0.0d;
        
        Random rand=new Random();
		try{
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
		writer.write("x,y");
		writer.newLine();
			for(int i=0;i<N+1;i++)
			{
				if(i%1000==0)System.out.println(h*i+":"+sum);
				writer.write(h*i+","+sum);
				writer.newLine();
				sum+=rand.nextGaussian()*Math.sqrt(h);
			}
		writer.close();
		} 
		catch(Exception ex)
		{
			//
		}
     }
}