package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	
	@FindBy(name="user_name")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary  btn-flat']")
	WebElement signin;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	WebElement loginfailedmsg;
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String userName) {
		username.sendKeys(userName);
	}
	public void setPassword(String pswd) {
		password.sendKeys(pswd);
	}
	public void clickLogin() {
		signin.click();
	}
	
	public void login(String uname, String pswd) {
		this.setUserName(uname);
		this.setPassword(pswd);
		this.clickLogin();
		
	}
	
	public WebElement getUserName() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getErrorMsg() {
		return loginfailedmsg;
	}
	
	public boolean loginfailedmsgenabled() {
		return loginfailedmsg.isDisplayed();
		//return true;
	}

}
