package TestSteps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.HomePage_Elements;
import io.cucumber.java.en.*;
import io.cucumber.core.cli.Main;


public class Output_Top10_Stocks {
	
	WebDriver driver =null;
	HomePage_Elements home;

	@Given("Browser is open")
	public void browser_is_open() {
		
		System.out.println("in elements");
		System.out.println("browser is open");
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();

	}

	@And("User launch Bursa Webpage")
	public void user_launch_bursa_webpage() {
		
		driver.navigate().to("https://www.bursamalaysia.com/");
		  
	}

	@When("User successfully navigated to homepage")
	public void user_successfully_navigated_to_homepage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cc-compliance']/a")));
		WebElement l = driver.findElement(By.xpath("//div[@class='cc-compliance']/a"));
		l.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tbody/tr/th//a)[3]")));

	}
	

	@Then("Output the top 10 stocks")
	public void output_top_10_stocks() {
		  
	    List<WebElement> all_code_elements = driver.findElements(By.xpath("//div[@id=\"pills-active\"]//tbody/tr/td[1]"));
	    List<WebElement> all_name_elements = driver.findElements(By.xpath("//div[@id=\"pills-active\"]//tbody/tr/th//a"));
	    List<WebElement> all_change_elements = driver.findElements(By.xpath("//div[@id=\"pills-active\"]//tbody/tr/td[3]"));
	    List<WebElement> all_volume_elements = driver.findElements(By.xpath("//div[@id=\"pills-active\"]//tbody/tr/td[4]"));
	    List<String> codes = new ArrayList<>();
	    List<String> names = new ArrayList<>();
	    List<String> changes = new ArrayList<>();
	    List<String> volumes = new ArrayList<>();
	    for(WebElement ele1:all_code_elements)
	        codes.add(ele1.getText());
	    for(WebElement ele2:all_name_elements)
	        names.add(ele2.getText());
	    for(WebElement ele3:all_change_elements)
	        changes.add(ele3.getText());
	    for(WebElement ele4:all_volume_elements)
	        volumes.add(ele4.getText());
	    for(int i=0; i<all_change_elements.size(); i++)
	     System.out.println("Code:" + codes.get(i) +" "+ "Name:" + names.get(i)+" "+"Change:"+ changes.get(i)+" "+"Volume:" + volumes.get(i));
	    Collections.sort(changes);
	    System.out.println("Change:" + changes);
	}

}
