package BaseClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataMatching {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.damacproperties.com/en/sale/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//div[@class='inputsHolder']//div[@class='customLocationBubble']")).click();
		List<WebElement> keyWords = driver.findElements(By.cssSelector("div.css-1nmdiq5-menu div"));
		System.out.println(keyWords.size());
		do {
			keyWords.get(i).click();
			driver.findElement(By.cssSelector(".searchBtn")).click();
			String Count = driver.findElement(By.xpath("//div[@class='desktopPropertyFilterWrapper']//h6[1]")).getText()
					.split(" ")[0].trim();
			int property = Integer.parseInt(Count);
			System.out.println(property);
			driver.findElement(By.xpath("//div[@class='inputsHolder']//div[@class='customLocationBubble']")).click();
			driver.findElement(By.cssSelector("div.css-17b2x2c-multiValue div.css-v7duua")).click();
		}
		int j = 0;
		for (int i = 0; i < keyWords.size(); i++) {
			keyWords.get(i).click();
			driver.findElement(By.cssSelector(".searchBtn")).click();
			String Count = driver.findElement(By.xpath("//div[@class='desktopPropertyFilterWrapper']//h6[1]")).getText()
					.split(" ")[0].trim();
			int property = Integer.parseInt(Count);
			System.out.println(property);
			driver.findElement(By.xpath("//div[@class='inputsHolder']//div[@class='customLocationBubble']")).click();
			driver.findElement(By.cssSelector("div.css-17b2x2c-multiValue div.css-v7duua")).click();
			j++;
			if (j > 3) {
				break;
			}
		}

	}
}
