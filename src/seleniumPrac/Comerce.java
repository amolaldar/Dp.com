package seleniumPrac;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Comerce {
	int j = 0;;

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		String[] vegetableNames = { "Brocolli", "Cauliflower", "Cucumber" };
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Comerce com = new Comerce();
		com.checkout(driver, vegetableNames);
	}

	public void checkout(WebDriver driver, String[] vegetableNames) {
		List<WebElement> vegNames = driver.findElements(By.cssSelector("h4.product-name"));
		int count = vegNames.size();
		System.out.println(count);
		List<String> name = Arrays.asList(vegetableNames);

		for (int i = 0; i < vegNames.size(); i++) {
			String vegs = vegNames.get(i).getText().split("-")[0].trim();
			System.out.println(vegs);
			if (name.contains(vegs)) {
				driver.findElements(By.cssSelector("div.product-action button")).get(i).click();
				j++;
				if (j == 3) {

					break;
				}
			}
		}
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		String promo = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		Assert.assertEquals(promo, "Code applied ..!");
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		WebElement dropdown = driver.findElement(By.cssSelector("select[style='width: 200px;']"));
		Select country = new Select(dropdown);
		country.selectByValue("Argentina");
		// System.out.println(driver.findElement(By.cssSelector("select[style='width:
		// 200px;']")).getText());
		driver.findElement(By.cssSelector(".chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		driver.close();
	}
}
