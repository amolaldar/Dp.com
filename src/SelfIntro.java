import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SelfIntro {

	public static void main(String[] args) {
		// System.setProperty("webdriver.chrome.driver","E:\\Selenium\\DriverFiles\\Drivers\\chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver","E:\\Selenium\\DriverFiles\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.msedge.driver", "E:\\Selenium\\DriverFiles\\Drivers\\msedgedriver.exe");
		// WebDriver driver = new ChromeDriver();
		// WebDriver driver= new FirefoxDriver();
		WebDriver driver = new EdgeDriver();
		driver.get("https://dev.damacproperties.com/en/projects/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();

	}

}
