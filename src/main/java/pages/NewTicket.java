package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTicket {
	WebDriver driver;
	
	
	@FindBy(name="subject")
	WebElement txtSubject;
	@FindBy(id="select2-project_id-4n-container")
	WebElement drpdwnproject;
	@FindBy(className="select2-reporter-ps-container")
	WebElement drpdwnreporter;
	@FindBy(id="priority")
	WebElement drpdwnpriority;
	@FindBy(id="select2-departments_id-w9-container")
	WebElement drpdwndepartment;
	@FindBy(id="file-save-button")
	WebElement btnCreateTicket;
	
	
	
public NewTicket(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void createTicketWithoutMandatoryFields() throws Exception {
		
		
				
	}
}

