package seleniumPrac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("nav-hamburger-menu"))).click().build().perform();
		Practice p = new Practice();
		p.option(driver);
		p.Electronic(driver);
	}

	public void option(WebDriver driver) {
		List<WebElement> options = driver.findElements(By.cssSelector("div#hmenu-content div"));
		for (WebElement optionsList : options) {
			System.out.println(optionsList.getText());
			if (optionsList.getText().equalsIgnoreCase("Electronics")) {
				optionsList.click();
				break;
			}
		}
		
	}
	public void Electronic(WebDriver driver) {
		List<WebElement> options = driver.findElements(By.cssSelector("ul[class*='hmenu-vis'] a"));
		for (WebElement optionsList : options) {
			System.out.println(optionsList.getText());
			if (optionsList.getText().equalsIgnoreCase("Headphones")) {
				optionsList.click();
				break;
			}
		}
		
	}

}
