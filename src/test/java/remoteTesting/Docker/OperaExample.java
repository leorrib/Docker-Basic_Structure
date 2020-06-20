package remoteTesting.Docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class OperaExample {

	@Test
	public void optest() throws MalformedURLException {
		// TODO Auto-generated method stub
		OperaOptions opo = new OperaOptions();
		URL address = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(address, opo);
		
		driver.get("http://yahoo.com");
		System.out.println("On Opera: " + driver.getTitle());
	}

}
