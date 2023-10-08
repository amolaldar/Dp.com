package seleniumPrac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Addition {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		int sum = 0;
		List<WebElement> prices = driver.findElements(By.cssSelector("div.left-align tr td:nth-child(3)"));
		for (WebElement price : prices) {
			String p = price.getText();
			int pri = Integer.parseInt(p);
			sum = sum + pri;
		}
		System.out.println(sum);
		driver.close();
	}

}
