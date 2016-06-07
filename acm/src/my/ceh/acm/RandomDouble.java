package my.ceh.acm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class RandomDouble {

	public static void main(String[] args) {
		Random random = new Random() ;
		try {
			FileOutputStream out = new FileOutputStream("D://out.txt");
			
			DecimalFormat df = new DecimalFormat("0.00");
			StringBuffer sb = new StringBuffer();
			double[][] ds = new double[100000][2];
			for(int i=0; i<200000; i++){
				double nextDouble = random.nextDouble()*10000;
				if(i%2==0){
					sb.append( df.format(nextDouble) + " " ) ;
					ds[i/2][0] = Double.parseDouble( df.format(nextDouble) );
				} else {
					ds[i/2][1] = Double.parseDouble( df.format(nextDouble) );
					sb.append( df.format(nextDouble) + "\r\n" );
				}
			}
			
			String result = sb.toString();
			byte[] buff = new byte[2000000];
			buff = result.getBytes();
			out.write(buff,0,buff.length); 
			
			for(int j=0; j<ds.length; j++){
				for(int jj=j; jj<ds.length; jj++){
					if(j!=jj&&(Math.abs(ds[j][0]-ds[jj][0])<0.01)&&(Math.abs(ds[j][1]-ds[jj][1])<0.01)){
						System.out.println( "(" + ds[j][0] + "," + ds[j][1] + ")" +" "+ "(" + ds[jj][0] + "," + ds[jj][1] + ")");
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
