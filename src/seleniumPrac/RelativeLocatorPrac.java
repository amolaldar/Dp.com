package seleniumPrac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocatorPrac {
public static void main(String[] args) {
	WebDriver driver= new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/angularpractice/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	WebElement above=driver.findElement(By.name("name"));
	String title=driver.findElement(with(By.tagName("label")).above(above)).getText();
	System.out.println(title);
	
	WebElement below=driver.findElement(By.cssSelector("label[for='exampleInputPassword1']"));
	driver.findElement(with(By.tagName("input")).below(below)).click();
	//pass.sendKeys("password");
	WebElement checkboxText=driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
	driver.findElement(with(By.tagName("input")).toLeftOf(checkboxText)).click();
	
	WebElement rad1=driver.findElement(By.id("inlineRadio1"));
System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rad1)).getText()) ;
}
}
