package seleniumPrac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyworAuto {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://dev.damacproperties.com/en/sale/");
		driver.manage().window().maximize();
		// String[] keywords = { "Abdali", "Arjan", "Battersea", "Dubai" };
		driver.findElement(By.xpath("//div[@class='customLocationWarper ']//div[@class='customLocationBubble']"))
				.click();
		List<WebElement> keywordsDrop = driver.findElements(By.cssSelector("div.css-qr46ko div"));
		System.out.println(keywordsDrop.size());
		KeyworAuto ka = new KeyworAuto();
		ka.m(driver, keywordsDrop);
	}

	public void m(WebDriver driver, List<WebElement> keywordsDrop) {

		for (int i = 0; i < keywordsDrop.size(); i++) {
			System.out.println(keywordsDrop.get(i).getText());
			keywordsDrop.get(i).click();
			driver.findElement(By.xpath("(//button[text()='Search'])[1]")).click();
			String propCount = driver.findElement(By.cssSelector("h6.1")).getText().split("Properties")[0].trim();
			int countProp = Integer.parseInt(propCount);
			string abc;

		}
	}
}
