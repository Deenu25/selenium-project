package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import AutomationCore.BaseClass;
import PageClasses.QALegend_AnnouncementPage;
import PageClasses.QALegend_EventPage;
import PageClasses.QALegend_FinancePage;
import PageClasses.QALegend_HomePage;
import PageClasses.QALegend_ItemsPage;
import PageClasses.QALegend_LeavePage;
import PageClasses.QALegend_LoginPage;
import PageClasses.QALegend_ProjectPage;
import PageClasses.QALegend_TicketPage;
import PageClasses.QALegend_TimeCards;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.WaitUtility;


public class QALegendTestCases extends BaseClass {
    public WebDriver driver;
    FileInputStream fis;
	 Properties prop;
	 QALegend_LoginPage login_Page;
	 QALegend_HomePage home_Page;
	 QALegend_EventPage event_Page;
	 QALegend_FinancePage finance_Page;
	 QALegend_ProjectPage project_Page;
	 QALegend_ItemsPage item_Page;
	 QALegend_TimeCards timecards_Page;
	 QALegend_TicketPage ticket_Page;
	 QALegend_LeavePage leave_Page;
	 QALegend_AnnouncementPage announcement_Page;
	 ExcelUtility excel_Utility;
	 WaitUtility wait_Utility;
	 FakerUtility faker_Utility;
	
	 @BeforeMethod(alwaysRun = true )
    @Parameters({"Browser"})
    public void initialization(String browser) throws Exception {
        driver = browserIntialization(browser);
        prop = new Properties();
        driver.manage().window().maximize();
        fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\Testdata.properties");
        prop.load(fis);
        driver.get(prop.getProperty("url"));
        login_Page = new QALegend_LoginPage(driver);
        home_Page = new QALegend_HomePage(driver,prop);
        event_Page=new QALegend_EventPage(driver);
        finance_Page=new QALegend_FinancePage(driver);
        project_Page=new QALegend_ProjectPage(driver);
        item_Page=new QALegend_ItemsPage(driver);
        timecards_Page=new QALegend_TimeCards(driver);
        ticket_Page=new QALegend_TicketPage(driver);
        leave_Page=new QALegend_LeavePage(driver);
        announcement_Page=new QALegend_AnnouncementPage(driver);
        excel_Utility=new ExcelUtility();
        wait_Utility=new WaitUtility();
        faker_Utility=new FakerUtility();
        
	}
    
        
    
    @Test(groups = {"Smoke"})
    public void addEvent() throws IOException, InterruptedException {
    	login_Page.loginCRM(prop.getProperty("username"),prop.getProperty("password"));
   
       
    home_Page.clickOnEventTab();
    event_Page.clickOnAddEvent();
    String event_Title=excel_Utility.getString(1, 0, excelFilePath, "Events")+faker_Utility.randomNumberCreation();
    event_Page.inputTitle(event_Title);
    event_Page.inputDescription(excel_Utility.getString(1, 1, excelFilePath, "Events"));
    System.out.println(faker_Utility.randomNumberCreation());
    event_Page.clickOnStartDate();
    event_Page.enterStartDate();
    event_Page.clickOnEndDate();
    event_Page.enterEndDate();
    event_Page.inputLocation(excel_Utility.getString(1, 2, excelFilePath, "Events")+faker_Utility.randomNumberCreation());
    event_Page.selectShareWith();
    event_Page.tickCheckBoxRepeat();
    event_Page.clickOnSave();
   AssertJUnit.assertEquals(event_Page.getTitleOfThePage(),prop.getProperty("eventCalendarTitle"));
    
    }
    
    @Test(groups = {"Regression"})
    public void testChatBoxFunctionality() throws InterruptedException { 
        
    	login_Page.loginCRM(prop.getProperty("username"),prop.getProperty("password"));
        
        home_Page.clickOnChatBox();
        home_Page.clickOnSenderMessage();
        home_Page.getReplyMessage(prop.getProperty("replyMessage"));
        
        home_Page.pressEnterKey();
        AssertJUnit.assertEquals(home_Page.displayRepliedMessage("placeholder"),prop.getProperty("placeholdervalue"));
        
            }
    @Test(groups = {"Smoke"})
    public void incomeVsExpenses() throws InterruptedException, AWTException {
       
    	login_Page.loginCRM(prop.getProperty("username"),prop.getProperty("password"));
        
        home_Page.clickOnFinance();
        home_Page.clickOnIncomeVsExpenses();
        
        finance_Page.chartVisibility();
        finance_Page.clickOnSummary();
        
        finance_Page.clickSummaryTable();
        
        finance_Page.clickOnPrintSummary();
        finance_Page.printView();
        AssertJUnit.assertEquals(finance_Page.getTextVisible(),prop.getProperty("textvisible"));
        }
    @Test(retryAnalyzer = Re_Run_FailedTestcases.class)
    public void projectStatusDropdown() throws InterruptedException {
        
    	login_Page.loginCRM(prop.getProperty("username"),prop.getProperty("password"));
        
       
        home_Page.clickOnProject();
        project_Page.clickOnProjectStatus();
        project_Page.clickOnCompletedProject();
        project_Page.clickOnExcel();
        AssertJUnit.assertEquals(project_Page.displayProjectText(),prop.getProperty("projectText"));
        }
    @Test(groups = {"Smoke"})
    public void addItems() throws InterruptedException { 
       
    	login_Page.loginCRM(prop.getProperty("username"),prop.getProperty("password"));
        
        
        home_Page.clickOnItemsTab();
        item_Page.clickOnAddItems();
        item_Page.inputTitleField(prop.getProperty("inputTitle"));
        item_Page.inputDescriptionField(prop.getProperty("inputDescription"));
        item_Page.enterUnitTypeField(prop.getProperty("enterUnitType"));
        item_Page.enterItemRateField(prop.getProperty("enterItemRate"));
        
        item_Page.pressSaveButton();
        AssertJUnit.assertEquals(item_Page.displayItem(),prop.getProperty("itemView"));
        }   
    
    @Test(groups = {"Regression"})
    public void clockInOrOutMembers() throws InterruptedException { 
       
    	login_Page.loginCRM(prop.getProperty("username"),prop.getProperty("password"));
        
       
        home_Page.clickOnTimeCards();
       
        timecards_Page.clickOnClockInOrOut();
        timecards_Page.clickOnStatusOfKeerthana();
        timecards_Page.getTotalWorkHours();
        AssertJUnit.assertEquals(timecards_Page.getTotalWorkHours(),prop.getProperty("totalWorkHours"));
        
}
    @Test(groups = {"Smoke"})
    public void Tickets() throws InterruptedException{ 
    	login_Page.loginCRM(prop.getProperty("username"),prop.getProperty("password"));
        
         
        home_Page.clickOnTicketsTab();
        ticket_Page.clickOnAddTickets();
        ticket_Page.inputTitle(prop.getProperty("insertTitle"));
        
        ticket_Page.addClientTab();
        ticket_Page.clickOnAddClient();
        ticket_Page.clickSelectClient();
        ticket_Page.clickOnDescription();
        ticket_Page.insertDescrition(prop.getProperty("insertDescription"));
        ticket_Page.clickOnFileUpload();
        
        ticket_Page.fileUpload(prop.getProperty("filePath"));
        ticket_Page.clickSaveButton();
        AssertJUnit.assertEquals(ticket_Page.openStatus(),prop.getProperty("statusOpen"));
}
    @Test(groups = {"Regression"})
    public void applyLeave() throws InterruptedException {
    
    	login_Page.loginCRM(prop.getProperty("username"),prop.getProperty("password"));
        
        
        home_Page.clickOnLeaveTab();
        leave_Page.clickOnApplyLeave();
        leave_Page.clickOnLeaveType();
        leave_Page.selectLeaveType();
        leave_Page.radioButtonSelect();
        leave_Page.clickOnDate();
        leave_Page.clickOnSelectDate();
        leave_Page.enterReasonForLeave();
        leave_Page.clickOnApplyLeaveButton();
        AssertJUnit.assertEquals(leave_Page.leaveTextDisplay(),prop.getProperty("leaveView"));
   
        
}
    @Test(groups = {"Smoke"})
    public void addAnnouncement() throws InterruptedException {
    	
    	login_Page.loginCRM(prop.getProperty("username"),prop.getProperty("password"));
        
        
        home_Page.clickOnannouncementTab();
        announcement_Page.clickOnAddAnnouncement();
        announcement_Page.enterTitle();
        announcement_Page.enterBodyOfAnnouncement();
        announcement_Page.clickOnStartDate();
        announcement_Page.clickOnSelectStartDate();
        announcement_Page.clickOnEndDate();
        announcement_Page.clickOnSelectEndDate();
        announcement_Page.selectCheckBox();
        announcement_Page.clickFileUpload();
       
        announcement_Page.uploadFile(prop.getProperty("filePath"));
        announcement_Page.clickOnAlert();
        announcement_Page.clickSave();
        AssertJUnit.assertEquals(announcement_Page.displayEditAnnouncement(),prop.getProperty("editAnnouncement"));
        }



@AfterMethod(alwaysRun = true)
public void tearDown() {
	driver.quit();
}
}