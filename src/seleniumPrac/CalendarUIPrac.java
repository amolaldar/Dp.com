package seleniumPrac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUIPrac {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("input#form-field-travel_comp_date")).click();

		while (!driver.findElement(By.cssSelector(".flatpickr-current-month")).getText().contains("April")) {
			driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
		}
		List<WebElement> dates = driver.findElements(By.cssSelector(".dayContainer span"));
		for (WebElement date : dates) {
			String entereDate = date.getText();
			if (entereDate.equalsIgnoreCase("23")) {
				date.click();
			}

		}

	}

}
