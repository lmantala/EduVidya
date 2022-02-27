package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SchoolSearchPage {

	WebDriver driver;
	
	public SchoolSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By byDrpCourseType = By.id("ddl_Category");
	
	public By byDrpcity = By.id("ddl_City");
	
	public By byBtnSearch = By.id("btnSearch");
	
	public By byLblResult = By.xpath("//div[@id=\"content\"]//a[contains(text(),\"Schools Search\")]"); 
	
	
}
