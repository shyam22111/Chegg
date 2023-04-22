import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.Test;

public class Automate {
	
	WebDriver driver;
	String text;
	String text1;
	int i;
	
	@Test
	public void main() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shyam\\OneDrive\\Desktop\\ProjectLibrary\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
	
		driver.get("https://expert.chegg.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("srnarwade96@gmail.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("DV478MEg562G");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//button[@type='button']")).click();
		
		
		for( i=0; i< 3500; i++) {
			
			Thread.sleep(120000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			try { 
				text = driver.findElement(By.xpath("//div[@data-test='no-question']//div")).getText();
				
			} catch (Exception e) {
				text="ABC";
			}
			
			 text1 = "Thanks for your efforts on Chegg Q&A! Unfortunately, there are no questions available in your queue for the moment.";
			
			 
			if(text.equalsIgnoreCase(text1)) {
			driver.navigate().refresh();
			System.out.println("number of time refreshed "+i);
			}
			
			else {
				System.out.println("Question has been got");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver = new ChromeDriver();
				Thread.sleep(20000);
				driver.get("https://www.youtube.com/watch?v=_eYMW2efULw");
				Thread.sleep(20000);
				driver.findElement(By.xpath("//button[@aria-keyshortcuts='k']")).click();
				
			}
			
		
		
		
	}

}
	
}
