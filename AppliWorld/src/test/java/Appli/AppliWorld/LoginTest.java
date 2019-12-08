package Appli.AppliWorld;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;

public class LoginTest {

	@Test
	public void loginWithValidCred() {
		Eyes eyes = new Eyes();                                        // Note 1
		String apiKey = System.getenv("7FDuYlQxftexc7io3ZWKCRqwoAKzwKd98ZXa69NfSOqI110");
		eyes.setApiKey(apiKey);                                        // Note 2

		WebDriver innerDriver = new ChromeDriver();                    // Note 3
		//
		//Add optional global setup/defaults before the eyes.open      // Note 4
		//
		RectangleSize viewportSize = new RectangleSize(/*width*/ 1024, /*height*/ 768 );
		WebDriver driver = eyes.open(innerDriver,
				"Hello World App", "Hello World Test", viewportSize);      // Note 5
		try {
			String website = "https://applitools.com/helloworld";
			driver.get(website);                                       // Note 6
			eyes.checkWindow("initial screen");                        // Note 7
			TestResults testResult = eyes.close(false);                // Note 8
		} finally {
			eyes.abortIfNotClosed();                                   // Note 9
		}
		innerDriver.quit();  
	}
}
