package BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	@BeforeMethod
	public WebDriver base() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.damacproperties.com/en/sale/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
}
