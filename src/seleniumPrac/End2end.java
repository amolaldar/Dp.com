package seleniumPrac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class End2end {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\DriverFiles\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		List<WebElement> OriCountries = driver.findElements(By.cssSelector("div.dropdownDiv ul li a"));
		for (WebElement oriCountry : OriCountries) {
			if (oriCountry.getText().equalsIgnoreCase("Gwalior (GWL)")) {
				oriCountry.click();
			}
		}
		WebElement box = driver.findElement(By.cssSelector("div#glsctl00_mainContent_ddl_destinationStation1_CTNR"));
		List<WebElement> destCountries = box.findElements(By.cssSelector("div.dropdownDiv ul li a"));
		for (WebElement destCountry : destCountries) {
			if (destCountry.getText().equalsIgnoreCase("Mumbai (BOM)")) {
				destCountry.click();
			}
		}
		driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).click();
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		driver.findElement(By.cssSelector(".paxinfo")).click();

		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.cssSelector(".paxinfo")).getText(), "5 Adult");
		WebElement currencyDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select currency = new Select(currencyDropdown);
		currency.selectByVisibleText("INR");
		currency.selectByIndex(1);
		currency.selectByValue("USD");
		driver.findElement(By.cssSelector("input[value='Search']"));
		driver.close();
	}

}
