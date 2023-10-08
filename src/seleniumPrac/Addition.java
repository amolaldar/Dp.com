package seleniumPrac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Addition {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		Addition ad= new Addition();
		ad.m1(driver);
		ad.m2(driver);
		//driver.close();
	}
	public void m1(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");
		int sum = 0;
		List<WebElement> prices = driver.findElements(By.cssSelector("div.left-align tr td:nth-child(3)"));
		for (WebElement price : prices) {
			String p = price.getText();
			int pri = Integer.parseInt(p);
			sum = sum + pri;
		}
		System.out.println(sum);
	}
	public void m2(WebDriver driver) {
		Actions a= new Actions(driver);
		a.moveToElement(driver.findElement(By.id("mousehover"))).contextClick().build().perform();
	}

}
