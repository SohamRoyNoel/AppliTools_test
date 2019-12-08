import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;

public class Demo {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","E:\\Jars\\Chromedriver-78\\chromedriver.exe");
		Eyes eyes = new Eyes();                                       
		// String apiKey = System.getenv("7FDuYlQxftexc7io3ZWKCRqwoAKzwKd98ZXa69NfSOqI110");
		eyes.setApiKey("7FDuYlQxftexc7io3ZWKCRqwoAKzwKd98ZXa69NfSOqI110");                                    
		
		WebDriver innerDriver = new ChromeDriver();                   
		//
		//Add optional global setup/defaults before the eyes.open      
		//
		RectangleSize viewportSize = new RectangleSize(/*width*/ 1024, /*height*/ 768 );
		WebDriver driver = eyes.open(innerDriver, "Hello World App", "Hello World Test", viewportSize);    
		try {
			String website = "https://applitools.com/helloworld";
			driver.get(website);                                      
			eyes.checkWindow("initial screen");                      
			TestResults testResult = eyes.close(false);                
		} finally {
			eyes.abortIfNotClosed();                                   
		}
		innerDriver.quit();
	}

}
