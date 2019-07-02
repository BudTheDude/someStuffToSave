package task_layer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import date_layer.HW5.DataReader;
import date_layer.HW5.MonitoredData;

public class Monitor {
	private ArrayList<MonitoredData> data;
	private DataReader reader=new DataReader("/home/bud/workspace3/HW5/src/Activities.txt");
	
	public Monitor() {
		data=reader.read();
	}
	
	public void dayCount() {
		 
		HashSet<Date> dates=new HashSet<>();
		data.forEach((n)->
		{
			dates.add(n.getStart());
			dates.add(n.getEnd());
		}
				);
		
		long nrOfDates=dates.stream()
				.count();
		
		System.err.print("Number of monitored days:");
		System.out.print(nrOfDates+"\n");
	}
	
	public void totalActivityCount() {
		
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		String[] activities= { "Leaving",  "Toileting",  "Showering", "Sleeping", "Breakfast", "Lunch", "Dinner", "Snack", "Spare_Time/TV", "Grooming"};
		for(int i=0;i<activities.length;i++) {
			map.put(activities[i], 0);
		}
		
		data.forEach((n)->
		{
			map.put(n.getLabel(),map.get(n.getLabel())+1);
		}
				);
		System.err.println("Total Activity Count:");
		map.forEach((n,m)->{
			System.out.println(n+":"+m);
		});
	}
	
	public void activityCountPerDay() {
		System.err.println("Activity Count for each Day:");
		HashSet<Date> dates=new HashSet<>();
		data.forEach((n)->
		{
			dates.add(n.getStart());
			dates.add(n.getEnd());
		}
				);
		
		dates.forEach((n)->
		{
			System.out.println("-->"+n);
			HashMap<String,Integer> map=new HashMap<String,Integer>();
			String[] activities= { "Leaving",  "Toileting",  "Showering", "Sleeping", "Breakfast", "Lunch", "Dinner", "Snack", "Spare_Time/TV", "Grooming"};
			for(int i=0;i<activities.length;i++) {
				map.put(activities[i], 0);
			}
			data.forEach((m)->{
				
				
				
				
				if(m.getStart().equals(n) || m.getEnd().equals(n) ) {
					
					map.put(m.getLabel(),map.get(m.getLabel())+1);
				}
				
				
				});
			
				map.forEach((p,q)->{
				System.out.println("    -"+p+":"+q);
				
			});
		}
				);
	}
	
	public void timeForEachLine() {
		System.err.println("Time for each line");
		data.forEach((n)->
		{
			
			Long[] info=timeDiff(n.getFullDate("e"),n.getFullDate("s"));
			System.out.println(n.getLabel()+"-> "+"Hours:"+info[0]+", Minutes:"+info[1]+", Seconds:"+info[2]);
		}
				);
	}
	
	public Long[] timeDiff(Date end, Date start) {
		String str="";
		long diff=end.getTime()-start.getTime();
		
		long secInMilli = 1000;
		long minInMilli = 60*secInMilli;
		long hoursInMilli= 60*minInMilli;
		
		long elapsedHours=diff/hoursInMilli;
		diff=diff%hoursInMilli;
		
		long elapsedMinutes=diff/minInMilli;
		diff=diff%minInMilli;
		
		long elapsedSeconds=diff/secInMilli;
		Long[] info= {elapsedHours,elapsedMinutes,elapsedSeconds};
		return info;
	}
	
	public void totalActivityTime() {
		HashMap<String,Long[]> map=new HashMap<String,Long[]>();
		String[] activities= { "Leaving",  "Toileting",  "Showering", "Sleeping", "Breakfast", "Lunch", "Dinner", "Snack", "Spare_Time/TV", "Grooming"};
		for(int i=0;i<activities.length;i++) {
			Long[] put= {(long)0,(long)0,(long)0};
			map.put(activities[i], put);
		}
		
		data.forEach((n)->
		{
			Long[] info=timeDiff(n.getFullDate("e"),n.getFullDate("s"));
			Long[] update= {map.get(n.getLabel())[0]+info[0],map.get(n.getLabel())[1]+info[1],map.get(n.getLabel())[2]+info[2]};
			map.put(n.getLabel(),update);
		}
				);
		System.err.println("Total Activity Time:");
		map.forEach((n,m)->{
			//correcting the time
			long seconds=m[2]+m[1]*60+m[0]*3600;
			
			long hours=seconds/3600;
			seconds=seconds%3600;
			
			long minutes=seconds/60;
			seconds=seconds%60;
			
			
			System.out.println(n+"-> "+"Hours:"+hours+", Minutes:"+minutes+", Seconds:"+seconds);
		});
		
	}
	
	public void filter() {
		HashMap<String,Long[]> map=new HashMap<String,Long[]>();
		String[] activities= { "Leaving",  "Toileting",  "Showering", "Sleeping", "Breakfast", "Lunch", "Dinner", "Snack", "Spare_Time/TV", "Grooming"};
		for(int i=0;i<activities.length;i++) {
			Long[] put= {(long)0,(long)0,(long)0};
			map.put(activities[i], put);
		}
		System.err.println("Filtered Activities:");
		map.forEach((n,m)->
		
		{
			List<MonitoredData> col=data.stream()
			.filter((q)->q.getLabel().equals(n))
			.collect(Collectors.toList());
			
			AtomicInteger count = new AtomicInteger();
			count.set(0);
			
			col.forEach((z)->
			{
				
				Long[] check=timeDiff(z.getFullDate("e"),z.getFullDate("s"));
				if(check[0]==0 && check[1]<5)
					count.set(count.get() +1);
			}
			
			
					
					
					);
			
			if((float)count.get()/(float)col.size()<0.9)
				System.out.println(n);
			
		}
				);
		
	}
	public static void main(String[] args){
		Monitor m=new Monitor();
		m.dayCount();
		m.totalActivityCount();
		m.activityCountPerDay();
		m.timeForEachLine();
		m.totalActivityTime();
		m.filter();
	}
}

