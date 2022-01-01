package test.in;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	 static WebDriver driver;
		
		@BeforeClass
		public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		
		}
		@AfterClass
		public static void closeBrowser() {
			driver.close();
			
		}
		@Before
		public void openApplication() {
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
		}
		@Test
		public void action1() {
			WebElement User = driver.findElement(By.id("email"));
			User.sendKeys("shariqueanwar27@gmail.com");
			WebElement pass = driver.findElement(By.id("pass"));
			pass.sendKeys("Jmsa@786");
			WebElement login = driver.findElement(By.name("login"));
			login.click();
		}
		@Test
		public void action2() {
			WebElement User = driver.findElement(By.id("email"));
			User.sendKeys("shariqueanwar27@gmail.com");
			WebElement pass = driver.findElement(By.id("pass"));
			pass.sendKeys("admin@123");
			WebElement login = driver.findElement(By.id("login"));
			login.click();
		}
		@After
		public void validation() {
			WebElement wel = driver.findElement(By.xpath("//input[@aria-label='Search Facebook']"));
			String text = wel.getText();
			boolean contains = text.contains("Search facebook");
			Assert.assertTrue(contains);
			//the down word should match if doesnt match it fail
			Assert.assertEquals("Search facebook Box", text);
		}
	}