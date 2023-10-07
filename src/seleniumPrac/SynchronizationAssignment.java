package seleniumPrac;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SynchronizationAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		SynchronizationAssignment assign = new SynchronizationAssignment();
		assign.logIn(driver);
		assign.addCart(driver);
		assign.checkout(driver);

	}

	public void logIn(WebDriver driver) {
		String sentence = driver.findElement(By.cssSelector("p.text-center.text-white")).getText();
		// (username is rahulshettyacademy and Password is learning)
		String userName = sentence.split("and")[0].split("is")[1].trim();
		System.out.println(userName);
		String password = sentence.split("Password is")[1].trim();
		System.out.println(password);
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys("learning");
		WebElement dropdown = driver.findElement(By.cssSelector("div.form-group select"));
		Select profession = new Select(dropdown);
		profession.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.className("btn-md")).click();
	}

	public void addCart(WebDriver driver) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));
		String[] productList = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };
		List<String> prodList = Arrays.asList(productList);
		for (int i = 0; i < products.size(); i++) {
			String singleProd = products.get(i).getText();
			if (prodList.contains(singleProd)) {
				driver.findElements(By.cssSelector("button.btn.btn-info")).get(i).click();
			}
		}
	}

	public void checkout(WebDriver driver) throws InterruptedException {
		String country = "India";
		driver.findElement(By.className("btn-primary")).click();
		int count = driver.findElements(By.cssSelector("div.media")).size();
		Assert.assertEquals(count, 4);
		driver.findElement(By.className("btn-success")).click();

		driver.findElement(By.id("country")).sendKeys("ind");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.suggestions ul li")));
		List<WebElement> countries = driver.findElements(By.cssSelector("div.suggestions ul li"));
		for (WebElement countrySelection : countries) {
			if (countrySelection.getText().equalsIgnoreCase(country)) {
				countrySelection.click();
			}
		}
//		WebElement tc = driver.findElement(By.xpath("//label[@for='checkbox2']"));
//		WebElement checkbox = driver.findElement(with(By.tagName("button")).toLeftOf(tc));
//		checkbox.click();
		driver.findElement(By.className("btn-lg")).click();
	}

}
