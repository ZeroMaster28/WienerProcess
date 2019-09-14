import java.util.Random;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Wiener{

     static final double T=1.0d;
     static final int N=10000;
     static double h=T/N;
     static boolean isWindows;

     public static void main(String []args){
        
        double sum=0.0d;
        Random rand=new Random();
		try{
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
		writer.newLine();
			for(int i=0;i<N+1;i++)
			{
				if(i%1000==0)System.out.println(h*i+":"+sum);
				writer.write(h*i+" "+sum);
				writer.newLine();
				sum+=rand.nextGaussian()*Math.sqrt(h);
			}
		writer.close();
		} 
		catch(Exception ex)
		{
			//
		}
	useGnuplot();
     }
     static void useGnuplot()
     {

	String homeDirectory = System.getProperty("user.home");
	Process process;
	if (isWindows) {
    	//TO-DO implement
	} 
	else {
	try{
    	process = Runtime.getRuntime().exec("gnuplot < plotting_options");
	Thread.currentThread().sleep(10000);
	   }
	catch(Exception ex)
	   {
		//
	   }
     	}
     }
}
