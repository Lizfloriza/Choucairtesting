package Testchoucairtesting;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class choucairtesting {
	
	private WebDriver driver ;
	
	@Before
	public void setUp() {
		
		
		System.setProperty("webdriver.chorme.driver", "./src/test/resources/chormedriver/chromedriver.exe");
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/");
	}
	
	@Test
	public void testChoucairPage() {
		
		WebElement filterEmpleo = driver.findElement(By.name("search_keywords"));
		
		filterEmpleo.clear();
		
		filterEmpleo.sendKeys("Automatizador");
		
		filterEmpleo.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("Automatizador", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	

}
