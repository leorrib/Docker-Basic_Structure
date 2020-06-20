package remoteTesting.Docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeExample1 {
	
	@Test
	public void chtest1() throws MalformedURLException {
		// TODO Auto-generated method stub
		ChromeOptions co = new ChromeOptions();
		URL address = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(address, co);
		
		driver.get("http://google.com");
		System.out.println("On Chrome: " + driver.getTitle());
	}

}
