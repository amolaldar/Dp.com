package seleniumPrac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ValuePrac {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> vegNames=driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> vegNames1;
		for(int i=0;i<vegNames.size();i++) {
			 vegNames1=driver.findElements(By.xpath("//tr/td[1]"));
				System.out.println(vegNames1.get(i).getText());
				if(vegNames1.get(i).getText().contains("Beans")) {
					System.out.println("100");
				}
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
			
		}
		
	}
	


