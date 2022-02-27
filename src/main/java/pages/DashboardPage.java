package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	public WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By byBtnSchool = By.xpath("//div[@id=\"cssmenu\"]//li/a[contains(text(),'Schools')]");
	
//	public By byBtnCloseAd = By.xpath("//div[@id=\"dismiss-button\"]");
	
	public By byBtnCloseAd = By.id("dismiss-button");
}
