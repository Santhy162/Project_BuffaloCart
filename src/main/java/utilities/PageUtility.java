package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility {

	public  WebElement waitForElementTobeVisible(WebDriver driver, WebElement elementToBeLoaded, int Time) {
        WebDriverWait wait = new WebDriverWait(driver, Time);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
        return element;
    }
	
	public  WebElement waitForElemntTobeClickable(WebDriver driver, WebElement elementToBeClickable, int Time) {
        WebDriverWait wait = new WebDriverWait(driver, Time);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementToBeClickable));
       
        return element;
    }
	
	
	public void MouseH(WebDriver driver, By BY) {
        Actions actions = new Actions(driver);
        //Retrieve WebElemnt 'slider' to perform mouse hover
        WebElement slider = driver.findElement(BY);
        //Move mouse to x offset 50 i.e. in horizontal direction
        actions.moveToElement(slider, 50, 0).perform();
        slider.click();
    }
	
	public void hitenter(WebDriver driver, WebElement el) {
        //Retrieve WebElemnt 'slider' to perform mouse hover
        el.sendKeys(Keys.ENTER);
    }
	
	
	 public static void sleep(long timeout) {
	        try {
	            Thread.sleep(timeout);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	 public static String currentDate() {
		 LocalDate todayDate = LocalDate.now();
		 return todayDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
	 }
	
}
