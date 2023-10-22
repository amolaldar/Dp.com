package seleniumPrac;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CdPrac {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://dev.damacproperties.com/en/projects/?sfau=au");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("span[class*='projectPageSwitchRound']")).click();
		List<WebElement>projectNames=driver.findElements(By.cssSelector("div[class*='listingCard-module--title']"));
		projectNames.stream().map(s->s.getText()).collect(Collectors.toList()).forEach(s->System.out.println(s));
	
	}

	

}
