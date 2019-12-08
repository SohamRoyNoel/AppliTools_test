package Appli.AppliWorld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

public class Demo {

	public static void main(String[] args) {
		
		Eyes eyes = new Eyes();

        // Initialize the eyes SDK and set your private API key.
        eyes.setApiKey("7FDuYlQxftexc7io3ZWKCRqwoAKzwKd98ZXa69NfSOqI110");

        System.setProperty("webdriver.chrome.driver","E:\\Jars\\Chromedriver-78\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {

            // Start the test with a viewport size of 800x600.
            eyes.open(driver, "Applitools site", "Java Screenshot test!", new RectangleSize(800, 600));
            
            driver.get("https://applitools.com/helloworld");
            
            // Creates the baseline for the first RUN
            eyes.checkWindow("Hello"); 
            driver.findElement(By.tagName("button")).click();
//            driver.findElement(By.xpath("/html/body/div/div[2]/p[3]/a")).click();
//            eyes.checkWindow("Click1");
            driver.findElement(By.xpath("/html/body/div/div[2]/p[2]/a")).click();
            eyes.checkWindow("Click");
            

            // End visual UI testing.
            eyes.close();

        } finally {

        	driver.quit();
            // If the test was aborted before eyes.close was called, ends the test as aborted.
            eyes.abortIfNotClosed();

        } 
	}

}
