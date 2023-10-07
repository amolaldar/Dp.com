import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Locators2 {
	static String name = "Amol";
	String finalPass;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "E:\\Selenium\\DriverFiles\\Drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys("ram123");
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		driver.findElement(By.className("signInBtn")).click();
		String errorMsg = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errorMsg);
		Assert.assertEquals(errorMsg, "* Incorrect username or password");
		driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();
		login(driver);

	}

	public static String getPass(WebDriver driver) {
		driver.findElement(By.xpath("//form/h2/following-sibling::input[1]")).sendKeys(name);
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("amol@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("23456789");
		driver.findElement(By.xpath("//button[contains(text(),'Reset ')]")).click();
		String pass = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		System.out.println(pass);
		String finalPass = pass.split("'")[1].split("'")[0].trim();
		System.out.println(finalPass);
		return finalPass;
	}

	public static void login(WebDriver driver) throws InterruptedException {
		String finalPass = getPass(driver);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(finalPass);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		String enteredName = driver.findElement(By.cssSelector("div h2")).getText();

		Assert.assertEquals(enteredName, "Hello " + name + ",");
		Assert.assertEquals(driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText(),
				"You are successfully logged in.");
		driver.findElement(By.cssSelector(".logout-btn")).click();
		driver.close();
	}

}
