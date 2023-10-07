package seleniumPrac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("autocomplete")).sendKeys("united");
		List<WebElement> countries = driver.findElements(By.cssSelector("ul#ui-id-1 li"));
		for (WebElement country : countries) {
			String selectedCountry = country.getText();
			if (selectedCountry.equalsIgnoreCase("United Kingdom (UK)")) {
				country.click();
			}
		}
		Thread.sleep(2000);
		String enteredCountrey = driver.findElement(By.id("autocomplete")).getText();
		System.out.println(enteredCountrey);

		Assert.assertEquals(enteredCountrey, "United Kingdom (UK)");

	}

}
