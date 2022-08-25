package Practice;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dropDown {

	WebDriver driver;
	String url ="http://qaclickacademy.com/practice.php";
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("Webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws IOException {
		
		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
		
		Select s = new Select(dropDown);
		List<WebElement> e = s.getOptions();
		
		int count=e.size();
		
		for(int i=0;i<count;i++) {
			
			String sValue= e.get(i).getText();
			System.out.println(sValue);
			
			
			}
		

	driver.findElement(By.id("name")).sendKeys("nitya");
	driver.findElement(By.id("alertbtn")).click();
	String alert=driver.switchTo().alert().getText();
	System.out.println(alert);
		
		

			

		
	
	}
}
