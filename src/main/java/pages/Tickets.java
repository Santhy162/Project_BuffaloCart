package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
public class Tickets {
	 String ticketcount;
	 String [] str;
	WebDriver driver;
	@FindBy(xpath="//a[text()='Tickets']")
	WebElement ticketsModuleLink;
	
	@FindBy(xpath="//a[text() ='New Tickets']")
	WebElement newTicket;
	
	@FindBy(id="file-save-button")
	WebElement newTicketdiv;
	
	@FindBy(id="DataTables_info")
	WebElement ticketsdatatableinfo;
	
	@FindBy(xpath="//a[@id='answered']/ancestor::div/child::p")
	WebElement answeredticketsnumber;
	
	@FindBy(xpath="//a[@id='answered']")
	WebElement answeredticketslink;
	
	@FindBy(xpath="//a[@id='in_progress']/ancestor::div/child::p")
	WebElement inprogressticketsnumber;
	@FindBy(xpath="//a[@id='in_progress']")
	WebElement inprogressticketslink;
	
	@FindBy(xpath="//a[@id='open']/ancestor::div/child::p")
	WebElement openticketsnumber;
	@FindBy(xpath="//a[@id='open']")
	WebElement openticketslink;
	
	@FindBy(xpath="//a[@id='closed']/ancestor::div/child::p")
	WebElement closedticketsnumber;
	@FindBy(xpath="//a[@id='closed']")
	WebElement closedticketslink;
	
	
	public Tickets(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	public boolean ticketModuleLoadSucess() {
		return ticketsModuleLink.isDisplayed();		
	}	
	public void clickNewTicket() {
		newTicket.click();
	}	
	public boolean locateNewTicketDiv() {
		clickNewTicket();
		 return newTicketdiv.isDisplayed();
	}
	 public boolean clickAnsweredTicketsLink() throws InterruptedException {		 
		 answeredticketslink.click();		 
		/*Split the "DataTables_info" div text to array 
		 inorder to get the number of tickets that are answered 'Showing 1 to 5 of 5 Entries'*/	
		PageUtility.sleep(400);
		// Thread.sleep(300);
		  ticketcount = ticketsdatatableinfo.getText();
		 str = ticketcount.split("\\s");  
		 if(Integer.parseInt(str[5]) == Integer.parseInt(answeredticketsnumber.getText()))		 
		    return true;
		 else
			 return false;
		 
	 }
	 public boolean clickInprogressTicketsLink() {
		 inprogressticketslink.click();
		 PageUtility.sleep(400);
		 ticketcount = ticketsdatatableinfo.getText();
		 str = ticketcount.split("\\s"); 
		 if(Integer.parseInt(str[5]) == Integer.parseInt(inprogressticketsnumber.getText()))		 
		    return true;
		 else
			 return false;
	 }
	 public boolean clickOpenTicketsLink() {
		 openticketslink.click();
		 PageUtility.sleep(500);
		 ticketcount = ticketsdatatableinfo.getText();
		 str = ticketcount.split("\\s");  
		 if(Integer.parseInt(str[5]) == Integer.parseInt(openticketsnumber.getText()))		 
		    return true;
		 else
			 return false;
	 }
	 public boolean clickClosedTicketsLink() {
		 closedticketslink.click();
		 PageUtility.sleep(400);
		 ticketcount = ticketsdatatableinfo.getText();
		 str = ticketcount.split("\\s");  
		 if(Integer.parseInt(str[5]) == Integer.parseInt(closedticketsnumber.getText()))		 
		    return true;
		 else
			 return false;
	 }

}
