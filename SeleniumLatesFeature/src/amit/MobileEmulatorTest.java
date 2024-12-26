package amit;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v130.emulation.Emulation;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
	    DevTools devTools =	driver.getDevTools();
	    
	    devTools.createSession();
	    devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
	    
	    driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	    driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//a[normalize-space()='Library']")).click();

	}

}
