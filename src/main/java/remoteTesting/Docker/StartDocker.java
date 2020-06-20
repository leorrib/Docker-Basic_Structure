package remoteTesting.Docker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;

public class StartDocker {
	
	public void startFile() throws IOException, InterruptedException {
		File fi = new File("output.txt");
		if(fi.delete()) {
			System.out.println("old output.txt file successfully detected and deleted");
		}
		
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start dockerUp.bat");
		
		String file = "output.txt";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 45);
		long stopNow = cal.getTimeInMillis();
		int i = 0;
		Thread.sleep(3000);
		while(System.currentTimeMillis() < stopNow && i < 3) {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currentLine = reader.readLine();
			i = 0;
			while(currentLine != null && i < 3) {
				if(currentLine.contains("The node is registered")) {
					i++;
				}
				currentLine = reader.readLine();
			}
			reader.close();
		}
		Assert.assertTrue(i == 3);
		System.out.println(i + " nodes were registered initially");
		
		runtime.exec("cmd /c start scale.bat");
		System.out.println("number of nodes with chrome increased to 5");
		Thread.sleep(10000);
		
		
	}
}
