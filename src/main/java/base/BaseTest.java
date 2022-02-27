package base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseTest {

	public WebDriver driver;

	public static void capture(WebDriver driver, String name) {
		Date date = new Date();
		String currentDate = date.toString().replace(" ", "-").replace(":", "-");
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(ss, new File("target/screenshot/"+name+"-"+currentDate+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public WebElement getWebElement(By locator) {
		return driver.findElement(locator);
	}
	
	
}
