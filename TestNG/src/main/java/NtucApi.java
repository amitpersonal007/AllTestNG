
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NtucApi {
	
	
	@Test
	public void start() throws IOException, ParseException {
		
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("text/plain");
				//RequestBody body = RequestBody.create(mediaType, "");
				Request request = new Request.Builder()
				  .url("https://api.zs-uat.fairprice.com.sg/order-service/order/70190259?include[0]=cancelledItems&rawData=true&includeSubstitution=true")
				  .method("GET", null)
				  .addHeader("Authorization", "Bearer 1660281988.5641zop62f5e48489b675.78078270")
				  .build();
				Response response = client.newCall(request).execute();
				
				System.out.println(response.code());
				String responsebody=response.body().string();
				
				 List<String> arr=	JsonPath.parse(responsebody).read("$.data.order.items[*].name");
				// System.out.println(arr.get(0));
				 
				 
				
				 
			 List<String> arr1=JsonPath.parse(responsebody).read("$.data.order.items[*].barcodes[0]");
			 //System.out.println(arr1.get(0));
			 
			 Map<String, String> myMap = new HashMap<String, String>();
			 for (int i = 0; i < arr.size(); i++) {
			      myMap.put(arr.get(i), arr1.get(i));
			 }

			
			 System.out.println(myMap.get("Ziploc Freezer Bags - Quart"));
				 		
	}

}
