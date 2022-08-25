package Practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test_01 {

	
	private WebDriver driver;
	  private String baseUrl="http://live.guru99.com/index.php/";	
	  
	@BeforeMethod
	@BeforeTest
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver");
	    driver = new FirefoxDriver();
	    baseUrl = "http://live.guru99.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @Test
	  public void testTestCase2() throws Exception {
		
		// 1. Go to http://live.guru99.com
	    driver.get(baseUrl); 
	    
	    // 2. Click on Mobile menu
	    driver.findElement(By.linkText("MOBILE")).click();	
	  
	    // 3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100) 	    	      
	    String XPeriaPrice = driver.findElement(By.cssSelector("#product-price-1 > span.price")).getText();
	   
	    // 4. Click on Sony Xperia mobile 	   
	    driver.findElement(By.id("product-collection-image-1")).click();
	    
	    // 5. Read the XPeria mobile price from details page
	    String detailPrice = driver.findElement(By.cssSelector("span.price")).getText();
	    	    
	    //  Product price in list and details page should be equal ($100)
	    try {
	        AssertJUnit.assertEquals(XPeriaPrice, detailPrice); 
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	  }
	
	@AfterMethod
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	  }
}
