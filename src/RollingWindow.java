import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class RollingWindow {
	private static int capacity1=3;
	private static int capacity2=20;
	private static PriorityQueue<Integer> window3 = new PriorityQueue<Integer>(capacity1);
	private static PriorityQueue<Integer> window20 = new PriorityQueue<Integer>(capacity2);
	private static int streamIndex=-1;
	private static int[] a={};
	public static void main(String args[]){
		
		//call inputstream
		try {
			a=inputStream();
		} catch (Exception e) {
			// TODO Auto-generated catch block1
			e.printStackTrace();
		}
		while(hasNext()){
			List<stats> t=recalculateStats(next());
			System.out.println(t);
		}
		
	}
	
	public static int[] inputStream() throws Exception{
		
		List<Integer> in=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(flag!=false){
			System.out.println("Enter the number:");
			int a=sc.nextInt();
			in.add(a);
			sc.nextLine();
			System.out.println("enter" +" '"+"end"+"'"+" to stop inserting the number or any other character for keep inserting:");
			String wishToMove=sc.nextLine();
			//put end if no want to enter any more values
			if(wishToMove.equals("end"))
				flag=false;
		}
		int []input=new int[in.size()];
		int y=0;
		for(int t:in){
			input[y]=t;
			y++;
		}
		return input;
		
	}
	
	public static boolean hasNext(){
		
		streamIndex++;
		if(streamIndex<a.length){
			return true;
		}
		return false;
	}
	
	public static int next(){
		return a[streamIndex];
	}

	
	public static List<stats> recalculateStats(int newElem){
		List<stats> res=new ArrayList<stats>();
		stats s3=new stats();
		stats s20=new stats();
		if(window3.size()==capacity1)
			window3.poll();
		if(window20.size()==capacity2)
			window20.poll();
		
			
			window3.add(newElem);
			window20.add(newElem);
			
		if(window3.size()<capacity1)
		{
			s3.setMax(null);
			s3.setAverage(null);
		}
		else{	
		PriorityQueue<Integer> window3Max=new PriorityQueue<Integer>(3,Collections.reverseOrder());
		window3Max.addAll(window3);
		s3.setMax(window3Max.peek());
		double avg=0;
		int count=0;
		Iterator<Integer> t=window3Max.iterator();
		while(t.hasNext()){
			avg=avg+t.next();
			count++;
		}
		s3.setAverage((Double)avg/count);
		}
		
		if(window20.size()<capacity2)
		{
			s20.setMax(null);
			s20.setAverage(null);
		}
		else{	
		PriorityQueue<Integer> window20Max=new PriorityQueue<Integer>(5,Collections.reverseOrder());
		window20Max.addAll(window20);
		s20.setMax(window20Max.peek());
		double avg=0;
		int count=0;
		Iterator<Integer> t=window20Max.iterator();
		while(t.hasNext()){
			avg=avg+t.next();
			count++;
		}
		s20.setAverage((Double)avg/count);
		}
		
		res.add(s3);
		res.add(s20);
		return res;
	}
	
}
