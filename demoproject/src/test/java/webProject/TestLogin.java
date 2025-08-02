package webProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogin {

	public static void main(String[] args) throws InterruptedException {
		
		//Web driver setup
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
		driver.navigate().to("https://www.myntra.com/");
		
		driver.manage().window().maximize();
		
		 String tit=driver.getTitle();
		 System.out.println(tit);
		 
		 Thread.sleep(500);  
		 
		        //Hard assert
		 Assert.assertEquals(tit,"Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra");
		
		        //Serach wall decor
				WebElement search =driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
			    search.sendKeys("Wall decor");
			    
			    Thread.sleep(500);
			    
				//Click
				WebElement cl =driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconSearch sprites-search']"));
				cl.click();
				
				//Wait for condition
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sort-sortBy")));
				
				//Next page select dropdown
		    
		    String title=driver.getTitle();
		    
		         //Soft assert
		    SoftAssert as =new SoftAssert();
		    as.assertEquals(title,"Buy Wall Decoration Online in India at Unbeatable Prices");
		   
		    System.out.println(title);
		    
		  WebElement dropdown = driver.findElement(By.xpath("//*[@class='sort-sortBy']"));
	      Actions a=new Actions(driver);
		  a.moveToElement(dropdown).click().build().perform();
		   
		  
		   //Print sort options
		  
		   List<WebElement> options= driver.findElements(By.xpath("//ul[@class='sort-list']/li"));
		   
		   System.out.println("Sort options:");
		   for(WebElement op:options)
		   {
			   System.out.println(op.getText());
			   
		  }
		   
		  //Select "What's new" option
		   
		   Thread.sleep(500);
		   for(WebElement op:options)
		   {
			   if(op.getText().contains("What's New"))
			  
			   {
				   op.click();
				   break;
			   }
			   
		  }
		   
		   //scroll
		   
		   Thread.sleep(500); 
		   WebElement brand= driver.findElement(By.xpath("//span[(text()='Brand')]"));
		  // WebElement brand= driver.findElement(By.xpath("//div[@class='verticalFilters-filters']"));
		   JavascriptExecutor j=  (JavascriptExecutor)driver;
		   j.executeScript("arguments[0].scrollIntoView(true);",brand);
		 
		   	  
         //price bar
		  
	     WebElement priceBar=driver.findElement(By.xpath("//span[text()='Price']"));
		//priceBar.click();
		 String str=priceBar.getText();
		 System.out.println(str);
		
		 Assert.assertEquals(str, "PRICE");
		 driver.close();
		 driver.quit();
	}

}
