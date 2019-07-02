package date_layer.HW5;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {
	private String f;
	
	public DataReader(String f) {
		this.f=f;
	}
	
	public ArrayList<MonitoredData> read(){
		ArrayList<MonitoredData> arr=new ArrayList<>();
		
		
		try {
			Files.lines(Paths.get(f))
			
			.forEach((line) -> 
			{
			
			List<String> fields=new ArrayList<>();
			fields=  Stream.of(line.split("(?<!\\d)\\s+")).collect(Collectors.toList());
			arr.add(new MonitoredData(fields.get(0),fields.get(1),fields.get(2)));
			
			}
			
			)
			
			
			;
			
		} catch (IOException e) {}
		
		
		return arr;
	}
	
}
