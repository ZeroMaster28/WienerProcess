import java.util.Random;
import java.io.FileWriter;
import java.io.BufferedWriter;

/** @author ZeroMaster28 
* Class represents Wiener processs sample path which is 
* written to a file 'data.txt' using basic BufferedWriter.
* In a final phase the path is drawn via gnuplot.
*
* @version 1.0
* Gnuplot drawing phase avaiable only on unix-like systems */
public class Wiener{

     static double T=1.0d;
     static int N=10000;
     static double h=T/N;
     static boolean isWindows;

     public static void main(String []args){
        
	if(args!=null)
	{
		if(args.length==1)
		{
			N=Integer.parseInt(args[0]);	
		}
		if(args.length==2)
		{
			T=Integer.parseInt(args[0]);
			N=Integer.parseInt(args[1]);
		}
	}
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
     
     /**Draws data from file via Gnuplot
      * Plotting_options should contain shell input for gnuplot*/
     static void useGnuplot()
     {

	String homeDirectory = System.getProperty("user.home");
	Process process;
	if (isWindows) {
    	//TO-DO implement
	} 
	else {
	try{
    	process = Runtime.getRuntime().exec("gnuplot < plotting_options -p");
	   }
	catch(Exception ex)
	   {
		//
	   }
     	}
     }
}
