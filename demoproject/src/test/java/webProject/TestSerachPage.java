/**
 * 
 */
package webProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSerachPage {

	
	public static void main(String[] args) {
		
	    WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
		driver.navigate().to("https://www.myntra.com/");
		driver.getTitle();
		driver.manage().window().maximize();
	}

}
