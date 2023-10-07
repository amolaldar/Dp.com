package seleniumPrac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		WebElement checkBox2 = driver.findElement(By.id("checkBoxOption2"));
		checkBox2.click();
		System.out.println(driver.findElement(By.xpath("//label[@for='benz']")).getText());
		String option2 = driver.findElement(By.xpath("//label[@for='benz']")).getText();

		driver.findElement(By.cssSelector("#dropdown-class-example")).click();
		List<WebElement> options = driver.findElements(By.cssSelector("#dropdown-class-example option"));
		for (WebElement option : options) {
			String value = option.getText();
			if (value.equalsIgnoreCase(option2)) {
				option.click();
				break;
			}
		}
		String dropdownOption = driver.findElement(By.cssSelector("#dropdown-class-example")).getText();
		driver.findElement(By.id("name")).sendKeys(dropdownOption);
		driver.findElement(By.id("confirmbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		driver.switchTo().alert().accept();
		String finalWord = alertText.split(",")[0].split(" ")[1].trim();
		System.out.println(finalWord);
		// Assert.assertEquals(finalWord, dropdownOption);
	}

}
