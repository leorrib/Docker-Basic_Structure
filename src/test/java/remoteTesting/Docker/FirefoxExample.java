package remoteTesting.Docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class FirefoxExample {
	
	@Test
	public void fftest() throws MalformedURLException {
		// TODO Auto-generated method stub
		FirefoxOptions ffo = new FirefoxOptions();
		URL address = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(address, ffo);
		
		driver.get("http://outlook.com");
		System.out.println("On Firefox: " + driver.getTitle());
	}

}
