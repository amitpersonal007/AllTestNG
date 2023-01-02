package MobileTests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.testng.annotations.Test;

public class AdbExe{
	
	@Test
	public void exe() throws IOException, InterruptedException {
		
		String command = "cmd /c adb shell dumpsys battery";
        Process proc = Runtime.getRuntime().exec(command);
        
        BufferedReader stdInput = new BufferedReader(new 
        	     InputStreamReader(proc.getInputStream()));

        	BufferedReader stdError = new BufferedReader(new 
        	     InputStreamReader(proc.getErrorStream()));
        	
        	
        	System.out.println("Here is the standard output of the command:\n");   //Read Output for success 
        	String s = null;
        	while ((s = stdInput.readLine()) != null) {
        	    System.out.println(s);
        	}
        	
        	System.out.println("Here is the standard error of the command (if any):\n"); //Read Error Message in console
        	while ((s = stdError.readLine()) != null) {
        	    System.out.println(s);
        	}
        		  
 	
	}
	
}