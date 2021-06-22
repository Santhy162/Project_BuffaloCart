package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class DashBoard {
	WebDriver driver;
	Alert alert;
	
	@FindBy(xpath="//a[@href='http://buffalocart.com/demo/erp/admin/dashboard']")
	WebElement dashboard;
	@FindBy(className="icon-bell")
	WebElement bell_icon;
	@FindBy(xpath="/html/body/div[1]/aside[1]/div/nav/ul[2]/li[12]/a")
	WebElement ticket;
	@FindBy(className="icon-notebook")
	WebElement iconNotebook;
	
	@FindBy(xpath="//div[@id='idCalculadora']/preceding-sibling::h2")
	WebElement datetext;
	
	@FindBy(xpath="//input[@value='1']")
	WebElement one;
	@FindBy(xpath="//input[@value='0']")
	WebElement zero;
	@FindBy(xpath="//input[@value='+']")
	WebElement plus;
	@FindBy(xpath="//input[@value='7']")
	WebElement seven;
	@FindBy(xpath="//input[@value='=']")
	WebElement equals;
	@FindBy(id="idCalculadoratxtResultado")
	WebElement calResult;
	@FindBy(xpath="//input[@value='-']")
	WebElement minus;
	@FindBy(xpath="//input[@value='9']")
	WebElement nine;
	@FindBy(xpath="//input[@value='8']")
	WebElement eight;
	@FindBy(xpath="//input[@id='idCalculadoraBorrar']")
	WebElement clear;
	
	
	public DashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	public void acceptAlert() {
		alert = driver.switchTo().alert();
		alert.accept();
	}
	public boolean loginSuccess() {
		return (dashboard.isDisplayed() || bell_icon.isDisplayed());
	}
	public void clickTicket() {
		ticket.click();
	}
	public void clickNotebookIcon() {
		iconNotebook.click();
	}
	public String verifyDateonNoteBookIcon() {
		clickNotebookIcon();
		//remove the day from date 
		String[] datestr = (datetext.getText()).split("\\s");
		String[] date=PageUtility.currentDate().split("\\s");
		return " ";
	}
	public String verifyAddition() {
		clickNotebookIcon();
		Actions action = new Actions(driver);
		action.moveToElement(clear).click()
				.moveToElement(one).click()
				//.moveToElement(zero).click()
				.moveToElement(plus).click()
				.moveToElement(seven).click()
				.moveToElement(equals).click()
				.build()
				.perform();
		System.out.println(calResult.getAttribute("value"));
		return calResult.getAttribute("value");
		
	}
	public String verifySubtraction() {
		Actions action = new Actions(driver);
		action.moveToElement(clear).click()
				.moveToElement(nine).click()
				.moveToElement(minus).click()
				.moveToElement(seven).click()
				//.moveToElement(eight).click()
				.moveToElement(equals).click()
				.build()
				.perform();
		System.out.println(calResult.getAttribute("value"));
		return calResult.getAttribute("value");
	}
}
