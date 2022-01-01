package test.in;

import java.util.concurrent.TimeUnit;

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

public class SecondProgram {

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
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test
	public void action1() throws InterruptedException  {
		WebElement User = driver.findElement(By.id("txtUsername"));
		User.sendKeys("Admin");
		WebElement pass = driver.findElement(By.id("txtPassword"));
		pass.sendKeys("admin123");
		Thread.sleep(4000);
		WebElement login = driver.findElement(By.xpath("//input[@value='LOGIN']"));
		login.click();
	}
	@Test
	public void action2() {
		WebElement User = driver.findElement(By.id("txtUsername"));
		User.sendKeys("Admin");
		WebElement pass = driver.findElement(By.id("txtPassword"));
		pass.sendKeys("admin@123");
		WebElement login = driver.findElement(By.xpath("//input[@class='button']"));
		login.click();
	}
	@After
	public void validation() {
		WebElement wel = driver.findElement(By.id("welcome"));
		String text = wel.getText();
		boolean contains = text.contains("Welcome");
		Assert.assertTrue(contains);
		//the down word should match if doesnt match it fail
		Assert.assertEquals("Welcome Paul", text);
	}
}
