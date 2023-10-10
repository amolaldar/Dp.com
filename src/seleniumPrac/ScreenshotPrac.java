package seleniumPrac;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class ScreenshotPrac {

	public static void main(String[] args) throws IOException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src,new File("C:\\screenshot\\google.png"));

	}

}
