package date_layer.HW5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MonitoredData {
	private String start_time;
	private String end_time;
	private String label;
	
	public MonitoredData(String start,String end,String label) {
		this.label=label;
		this.end_time=end;
		this.start_time=start;
		
	}
	
	public Date getStart() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date=null;
		try {
			date = format.parse(start_time.substring(0,11));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	
	public Date getEnd() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date=null;
		try {
			date = format.parse(end_time.substring(0,11));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public Date getFullDate(String choice) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" , Locale.ENGLISH);
		Date date=null;
		try {
			if(choice.equals("s"))
				date = format.parse(start_time);
			if(choice.equals("e"))
				date = format.parse(end_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public String getLabel() {
		return label;
	}
	
	
	
	
	
}
