package amit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional; // Correct Java Optional import

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.fetch.Fetch;
import org.openqa.selenium.devtools.v129.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v129.network.Network;
import org.openqa.selenium.devtools.v129.network.model.ResponseReceived;

public class NetworkFailedRequest {

    public static void main(String[] args) {

        // Set up ChromeDriver
        ChromeDriver driver = new ChromeDriver();

        // Start DevTools session
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Enable Network Tracking
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Set up request patterns to intercept all requests
        List<RequestPattern> requestPatterns = new ArrayList<>();
        requestPatterns.add(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty()));

        // Enable Fetch with the request patterns
        devTools.send(Fetch.enable(Optional.of(requestPatterns), Optional.empty()));

        // Add listener to capture failed network requests
        devTools.addListener(Network.responseReceived(), response -> {
            ResponseReceived received = response;
            Integer statusCode = received.getResponse().getStatus();
            String url = received.getResponse().getUrl();

            if (statusCode >= 400) {
                System.out.println("Failed Request Detected:");
                System.out.println("URL: " + url);
                System.out.println("Status Code: " + statusCode);
            }
        });

        // Navigate to a test page
    	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[normalize-space()='Virtual Library']")).click(); // Replace with a URL that triggers failed requests

        // Wait to allow network requests to complete
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clean up
        driver.quit();
    }
}

