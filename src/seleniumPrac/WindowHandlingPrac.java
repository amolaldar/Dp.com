package seleniumPrac;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingPrac {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\DriverFiles\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("body a.blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		String parentId = window.next();
		String childId = window.next();
		driver.switchTo().window(childId);
		Thread.sleep(3000);
		String sentence = driver.findElement(By.cssSelector("div p.im-para.red")).getText();
		String userName = sentence.split("at")[1].trim().split(" ")[0].trim();
		System.out.println(userName);
		driver.switchTo().window(parentId);
		driver.findElement(By.name("username")).sendKeys(userName);

	}

}
