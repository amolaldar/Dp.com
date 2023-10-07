import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaBrushUp {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.id("autosuggest")).sendKeys("ama");
//		driver.findElement(By.cssSelector("a[value='BOM']")).click();
//		driver.findElement(By.cssSelector("a[value='DEL']")).click();
		Thread.sleep(2000);
		List<WebElement> countries = driver.findElements(By.cssSelector(".wM6W7d span"));
		for (WebElement country : countries) {
			if (country.getText().equals("amazon prime")) {
				country.click();
			}

		}
		// driver.close();

	}
}
