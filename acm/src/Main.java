import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
	Problem Description
	FatMouse prepared M pounds of cat food, ready to trade with the cats guarding the warehouse containing his favorite food, JavaBean.
	The warehouse has N rooms. The i-th room contains J[i] pounds of JavaBeans and requires F[i] pounds of cat food. FatMouse does not have to trade for all the JavaBeans in the room, instead, he may get J[i]* a% pounds of JavaBeans if he pays F[i]* a% pounds of cat food. Here a is a real number. Now he is assigning this homework to you: tell him the maximum amount of JavaBeans he can obtain.
	
	Input
	The input consists of multiple test cases. Each test case begins with a line containing two non-negative integers M and N. Then N lines follow, each contains two non-negative integers J[i] and F[i] respectively. The last test case is followed by two -1's. All integers are not greater than 1000.
	
	Output
	For each test case, print in a single line a real number accurate up to 3 decimal places, which is the maximum amount of JavaBeans that FatMouse can obtain.
	
	Sample Input
	5 3
	7 2
	4 3
	5 2
	20 3
	25 18
	24 15
	15 10
	-1 -1
**/

public class Main {
    
    public static void main(String[] args) {
        acm1009();
    }
    
    public static void acm1009() {
        DecimalFormat df = new DecimalFormat("0.000");
        
        Scanner cin = new Scanner(System.in) ;
        int m = cin.nextInt() ;
        int n = cin.nextInt() ;
        while( m!=-1 && n!=-1 ){
        	double sum = 0.0 ;
        	Trade[] trades = new Trade[n] ;
        	for(int i=0; i<n; i++){
        		int J = cin.nextInt();
        		trades[i] = new Trade() ;
        		trades[i].J = J ;
        		int F = cin.nextInt();
        		trades[i].F = F ;
        		trades[i].ratio = (1.0000*J)/F ;
        	}
        	
        	MyComparator cmp = new MyComparator();
        	Arrays.sort( trades,  cmp);
            
            int count = 0 ;
            while(m>0){
            	if(m>=trades[count].F) {
            		sum += trades[count].J;
            		m -= trades[count].F;
            	} else {
            		sum += trades[count].ratio * m ;
            		m = 0 ;	//½áÊøÌõ¼þ
            	}
            	count++;
            }
            
            System.out.println(df.format(sum));
            m = cin.nextInt();
            n = cin.nextInt();
        }
    }
    
    static class Trade {
    	public int J ;
    	public int F ;
    	public double ratio ;
    }
    
    static class MyComparator implements Comparator<Trade> {
        @Override
        public int compare(Trade t1, Trade t2){
            if( t1.ratio > t2.ratio ) {
                return -1;
            } else if (t1.ratio < t2.ratio){
                return 1 ;
            } else {
                return 0 ;
            }
        }
    }
 
    
  
}