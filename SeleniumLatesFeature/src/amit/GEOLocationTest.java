package amit;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class GEOLocationTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		ChromeDriver driver = new ChromeDriver();
		
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String, Object> coordinates = new HashMap<String, Object>();
		
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		coordinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		Thread.sleep(2000);

	String title = 	driver.findElement(By.className("default-ltr-cache-jmnaey")).getText();
	
	System.out.println(title);
		
		
		
		
		

	}

}
