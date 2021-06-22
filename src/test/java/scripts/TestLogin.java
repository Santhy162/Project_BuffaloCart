package scripts;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.DashBoard;
import pages.Login;
import pages.Tickets;
import utilities.ExeclRead;
import utilities.PageUtility;
public class TestLogin extends TestHelper{
	Login login;
	DashBoard dashboard;
	Tickets tickets;
	String uname;
	String pswd;
	@Test(priority =1, groups="must")
	public void testLogin() throws Exception {
		login = new Login(driver);
		uname= ExeclRead.getDatafromExcel(1, 0);
		pswd= ExeclRead.getNumericDatafromExcel(1, 1);		
		login.login(uname, pswd);		
		dashboard = new DashBoard(driver);
		//dashboard.acceptAlert();
		Assert.assertTrue(dashboard.loginSuccess());
	}
	@Test(priority=0)
	public void testinvalidLogin() throws Exception {
		login = new Login(driver);
		uname= ExeclRead.getDatafromExcel(2, 0);
		pswd= ExeclRead.getNumericDatafromExcel(2, 1);
	//	WebElement ele_uname = login.getUserName();		
		//pu.waitForElementTobeVisible(driver, ele_uname, 20);	
		login.login(uname, pswd);
		Assert.assertTrue(login.loginfailedmsgenabled());
	}
	
	@Test(priority=2, groups="must")
	public void loadTickets() {
		dashboard = new DashBoard(driver);		
		dashboard.clickTicket();
		tickets = new Tickets(driver);
		Assert.assertTrue(tickets.ticketModuleLoadSucess());
	}
	@Test(priority=3, groups="functional")
	public void answeredTickets() throws InterruptedException  {
		tickets = new Tickets(driver);
		//Assert.assertTrue(tickets.clickAnsweredTicketsLink());
		Assert.assertTrue(tickets.clickAnsweredTicketsLink());
	}
	@Test(priority=4, groups="functional")
	public void inprogressTickets() {
		tickets = new Tickets(driver);
		Assert.assertTrue(tickets.clickInprogressTicketsLink());
	}
	@Test(priority=5, groups="functional")
	public void openTickets() {
		tickets = new Tickets(driver);
		Assert.assertTrue(tickets.clickOpenTicketsLink());
	}
	@Test(priority=6, groups="functional")
	public void closeTickets() {
		tickets = new Tickets(driver);
		Assert.assertTrue(tickets.clickClosedTicketsLink());
	}
	@Test(priority=9)
	public void loadNewTicket() {
		tickets = new Tickets(driver);
		Assert.assertTrue(tickets.locateNewTicketDiv());
	}	
	@Test(priority=7 )
	public void verifyDate() {
		dashboard = new DashBoard(driver);
		String d = dashboard.verifyDateonNoteBookIcon();
		String date=PageUtility.currentDate();
		System.out.println(date);
	}
	@Test(priority=8, groups="must")
	@Parameters({"sum","sub"})
	public void checkCalculator(String sum,String sub) {
		dashboard = new DashBoard(driver);
		int actualSum =Integer.parseInt(dashboard.verifyAddition());
		int actualsub=Integer.parseInt(dashboard.verifySubtraction());
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualSum,Integer.parseInt(sum));
		soft.assertEquals(actualsub,Integer.parseInt(sub));
		soft.assertAll();		
	}
	@Test(priority=10)
	public void createTicketWithoutMandatoryFields() {
		
	}
}
	
