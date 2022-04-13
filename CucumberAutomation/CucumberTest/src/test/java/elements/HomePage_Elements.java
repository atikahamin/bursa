package elements;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage_Elements {

	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='cc-compliance']/a")
	WebElement	close_cookies_btn;
	
	@FindBy(xpath = "(//tbody/tr/th//a)[3]")
	WebElement	table_name;
	
	
	public HomePage_Elements(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
				
	}
	
	
	public void complianceDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cc-compliance']/a")));	
	}
	
	public void clickCompliance() {
		close_cookies_btn.click();
		
	}
	
	public void tableNameDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tbody/tr/th//a)[3]")));
	}
	
}
	
