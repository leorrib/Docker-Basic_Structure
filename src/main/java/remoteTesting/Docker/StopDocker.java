package remoteTesting.Docker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;

public class StopDocker {
	
	public void ShutDownAndDelete() throws IOException, InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start dockerDown.bat");
		
		String file = "output.txt";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 60);
		long stopNow = cal.getTimeInMillis();
		Thread.sleep(3000);
		boolean flag = false;
		while(System.currentTimeMillis() < stopNow && !flag) {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currentLine = reader.readLine();
			while(currentLine != null) {
				if(currentLine.contains("selenium-hub exited")) {
					System.out.println("Hub was successfully shut down");
					flag = true;
					break;
				}
				currentLine = reader.readLine();
			}
			reader.close();
		}
		Assert.assertTrue(flag);
		
	}
}
