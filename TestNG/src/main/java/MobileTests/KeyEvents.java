package MobileTests;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class KeyEvents {
	
	AppiumDriver driver;

	
	@Test
	
	public void exec() {
		  AndroidDriver androiddriver = (AndroidDriver)driver;	
		String string="ABCdsdS!@#$$@#@#A";
		
		  String[] arr = string.split("");
		  
		  for(String c1:arr){
			  System.out.println(c1);
		  }
		  
		  for(String c:arr){
			  
			  
			  char[] charArray = c.toCharArray();
			  
			  for(int i=0; i < charArray.length; i++){
		            
		            
		            if( Character.isUpperCase( charArray[i] )) {
		            	  System.out.println("Uppercase "+charArray[i]);
		            }
		            
		            else if(Character.isLowerCase( charArray[i] )){
		            	
		            	androiddriver.pressKey(new KeyEvent(Enum.valueOf(AndroidKey.class, c)));
		            	
		            }      
		        }
		  }
	}
}
