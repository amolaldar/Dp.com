import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPrac {

	public static void main(String[] args) throws InterruptedException {
		String name = "Amol";
		System.setProperty("wendriver.chrome.driver", "E:\\Selenium\\DriverFiles\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys("Raj");
		driver.findElement(By.cssSelector("button[class*='signInBtn']")).click();
		WebElement errorMsg = driver.findElement(By.cssSelector("p.error"));
		System.out.println(errorMsg.getText());

		String finalPass = m(driver);
		driver.findElement(By.cssSelector("div button.go-to-login-btn")).click();
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys(finalPass);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[class*='signInBtn']")).click();

	}

	public static String m(WebDriver driver) {
		driver.findElement(By.cssSelector("div.forgot-pwd-container a")).click();
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Amol");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("amoltest@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
		String pass = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		System.out.println(pass);
		String finalPass = pass.split("'")[1].split("'")[0].trim();
		System.out.println(finalPass);
		return finalPass;

	}

}
