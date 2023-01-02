import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AirMeetApi {
	
	
	@Test
	
	public void start() throws IOException, ParseException {
		
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("text/plain");
				//RequestBody body = RequestBody.create(mediaType, "");
				Request request = new Request.Builder()
				  .url("https://api.airmeet.com/api/v1/airmeet/571844b0-b395-11ec-a8f3-bf153324ebd1/info")
				  .method("GET", null)
				  .addHeader("Cookie", "__cf_bm=ZbVcZPu5EGlPoTiv8S7COt2r9pwqtJeliiuMA6EHrSw-1655113754-0-AcGem2SRct4g+MKkaS42dVIHfu+Y2qNly05omKC/eCxEvPvtrGprPGkwuDjq8zGLV0FIZZv0uFwAaHXXdrW0LLU=; _cfuvid=II4gnYbhnG4OfqASe74Xqt1ECwQBcqFMS_Gnq_GGlj4-1655113754383-0-604800000")
				  .build();
				Response response = client.newCall(request).execute();
				
			String responsebody=response.body().string();
			
				//count total events
		 ArrayList<String> arr=	JsonPath.parse(responsebody).read("$.sessions[*].name");
			System.out.println("Total events is "+arr.size());
			
			
			//printalldata
			for (int i=0;i<=arr.size()-1;i++) {
				System.out.println(arr.get(i));
			}
			
			//verify if the event is present
			Assert.assertTrue(arr.contains("Welcome to Philly"));
			
			
			//Change Status and validate
			String status1 = JsonPath.parse(responsebody).read("$.status");
			
			switch(status1) {
			
			case "ONGOING" :
			
				System.out.println("Started") ;
				break;
				
				
			case "FINISHED" :
				System.out.println("Ended") ;
				break;
								
			case "PAUSED" :
				System.out.println("Paused") ;
				break;
				
			case "CREATED" :
				System.out.println("Not Started") ;
				break;
			
			}
			
			//Speaker List validation
			 ArrayList<String> speakerarr=	JsonPath.parse(responsebody).read("$.sessions[*].speakerList[*].name");
			 System.out.println("Total speaker is "+speakerarr.size());
			 
			 for (int j=0;j<=speakerarr.size()-1;j++) {
					System.out.println(speakerarr.get(j));
				}
			 Assert.assertTrue(speakerarr.contains("Steve Brittin"));
			 
			 //validate Start time and end time of events
			 
			 
			 String starttime = JsonPath.parse(responsebody).read("$.start_time");
			 String endtime = JsonPath.parse(responsebody).read("$.end_time");
			 
			 
		String lili=starttime.substring(0,10);
		LocalDate ld = LocalDate.parse(lili);
	//int month =	ld.getDayOfMonth();
		Date date1=new SimpleDateFormat("YYYY-DD-MMM").parse(lili);  
		System.out.println(starttime +" ada " + endtime +"asdad::::::"+lili+ "     Parsd date  "+date1 );
			 
			 
			
			
		
		
	}

}
