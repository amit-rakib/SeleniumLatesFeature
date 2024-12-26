package amit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoAutomation {
    public static void main(String[] args) {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        
            String email = "amit@gmail.com";
            String pass = "123456";

            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

            
            driver.findElement(By.id("customer_login_link")).click();
            driver.findElement(By.id("customer_email")).sendKeys(email);
            driver.findElement(By.id("customer_password")).sendKeys(pass);
            driver.findElement(By.xpath("//input[@value='Sign In']")).click();

           
        
    }
}
