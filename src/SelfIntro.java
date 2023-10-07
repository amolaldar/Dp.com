import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SelfIntro {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.findElement(By.name("name")).sendKeys("Amol");
		driver.findElement(By.name("email")).sendKeys("amol@test.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Amol@123");
		driver.findElement(By.cssSelector("div.form-check input.form-check-input")).click();
		driver.findElement(By.cssSelector("div.form-check input.form-check-input")).isEnabled();
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));

		Select s = new Select(dropdown);
		s.selectByVisibleText("Female");
		driver.findElement(By.id("inlineRadio1")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[value='option3']")).isEnabled());
		driver.findElement(By.name("bday")).sendKeys("05/06/1994");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		String msg = driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).getText();
		Assert.assertEquals(msg, " Success! The Form has been submitted successfully!.");
	}

}
