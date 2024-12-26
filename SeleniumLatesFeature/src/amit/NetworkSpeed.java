package amit;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v128.network.model.ConnectionType;
import org.openqa.selenium.devtools.v85.network.Network;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.empty()));
		
		
	long startTime = 	System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[normalize-space()='Virtual Library']")).click();
		
		long endTime = 	System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
		
		driver.close();


	}

}
