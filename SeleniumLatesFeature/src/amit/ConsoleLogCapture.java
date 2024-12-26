package amit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogCapture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//a[normalize-space()='Browse Products']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Selenium']")).click();
		driver.findElement(By.className("add-to-cart")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Cart']")).click();
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).clear();
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("2");
		
		
	LogEntries entry =	driver.manage().logs().get(LogType.BROWSER);
	List<LogEntry> logs = entry.getAll();
	
	for(LogEntry e : logs) {
		System.out.println(e.getMessage());
	}


	}

}
