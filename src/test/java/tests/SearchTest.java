package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashboardPage;
import pages.SchoolSearchPage;

public class SearchTest extends BaseTest {

	DashboardPage dashboardPage;
	SchoolSearchPage schoolSearchPage;
	JavascriptExecutor executor;

	@BeforeMethod
	public void setup() {
	
		if(System.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (System.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		dashboardPage = new DashboardPage(driver);
		schoolSearchPage = new SchoolSearchPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.eduvidya.com/");
		
	}

	@Test
	public void search_schools_by_course_and_cite() throws InterruptedException {

		getWebElement(dashboardPage.byBtnSchool).click();

		Thread.sleep(3000);

		driver.switchTo().frame(driver.findElement(By.id("aswift_3")));
		driver.switchTo().frame(driver.findElement(By.id("ad_iframe")));
		driver.findElement(By.id("dismiss-button")).click();
		Thread.sleep(3000);

		driver.switchTo().defaultContent();

		Select selectCourseType = new Select(getWebElement(schoolSearchPage.byDrpCourseType));
		selectCourseType.selectByValue("1");

		Select selectCity = new Select(getWebElement(schoolSearchPage.byDrpcity));
		selectCity.selectByValue("2");

		getWebElement(schoolSearchPage.byBtnSearch).click();

		Assert.assertEquals(getWebElement(schoolSearchPage.byLblResult).getText(), "Schools Search");

	}

	@AfterMethod
	public void afterTestMethod() {
		if (!Reporter.getCurrentTestResult().isSuccess()) {
			System.out.println("Testcase Failed");
			capture(driver, this.getClass().getName());
		}
		driver.quit();
	}
}
