package seleniumPrac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		// js.executeScript("document.querySelector('.tablefixHead').scrollTop=5000");
		int columnCount = driver.findElements(By.cssSelector("div.left-align tr:nth-child(1) th")).size();
		System.out.println("columnCount= " + columnCount);
		int rowCount = driver.findElements(By.cssSelector("div.left-align tr")).size();
		System.out.println("rowCount= " + rowCount);
		List<WebElement> courses = driver.findElements(By.cssSelector("div.left-align tr:nth-child(3) td"));
		for (WebElement course : courses) {
			System.out.println(course.getText());
		}
		driver.close();

	}

}
