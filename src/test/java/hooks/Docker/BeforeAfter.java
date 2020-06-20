package hooks.Docker;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import remoteTesting.Docker.StartDocker;
import remoteTesting.Docker.StopDocker;

public class BeforeAfter {
	
	@BeforeTest
	public void startDockerScale() throws IOException, InterruptedException {
		StartDocker start_docker = new StartDocker();
		start_docker.startFile();
	}
	
	@AfterTest
	public void stopDockerDeleteOutput() throws IOException, InterruptedException {
		StopDocker stop_docker = new StopDocker();
		stop_docker.ShutDownAndDelete();
	}

}
