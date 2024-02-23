package PageClasses;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_HomePage {
    WebDriver driver;
    Properties properties;
    PageUtility page_Util=new PageUtility();
    WaitUtility wait_Util=new WaitUtility();
    @FindBy(xpath = "//span[@class='topbar-user-name']")
    WebElement userProfileName;
    
    @FindBy(xpath = "//a[text()=' Sign Out']")
    WebElement signOutUser;
    
    @FindBy(xpath="//img[@class='dashboard-image']")
    WebElement logo;
    
    @FindBy(xpath = "//span[text()='Events']")
    WebElement eventTab;
    
   @FindBy(id="js-chat-min-icon")
   WebElement chatBox;
    
   @FindBy(xpath = "(//strong[text()='Saumia Alex'])[1]")
   WebElement senderMessage;
   
   @FindBy(name="reply_message")
   WebElement replyMessage;
   
   @FindBy(xpath = "//span[text()='Finance']")
	WebElement financeTab;
	 
   @FindBy(xpath = "//span[text()='Income vs Expenses']")
	WebElement incomeVsExpensesTab;
    
   @FindBy(xpath = "//span[text()='Projects']")
   WebElement projectTab;
   @FindBy(xpath = "//span[text()='All Projects']")
   WebElement allProjects;
   
   @FindBy(xpath = "//span[text()='Items']")
   WebElement itemsTab;
   
   @FindBy(xpath = "//span[text()='Time cards']")
   WebElement timeCardsTab;
   
   @FindBy(xpath = "//span[text()='Tickets']")
   WebElement ticketsTab;
   
   @FindBy(xpath = "//i[@class='fa fa-sign-out font-16']")
   WebElement leaveTab;
   
   @FindBy(xpath = "//span[text()='Announcements']")
   WebElement announcementTab;
   
   @FindBy(xpath = "//textarea[@placeholder='Write a message...']")
   WebElement placeholderReplyMsg;
   
  
    
  
   public QALegend_HomePage(WebDriver driver,Properties prop) {
        this.driver = driver;
        //this.prop=prop;
        PageFactory.initElements(driver, this);
    }
    

	public void logOut() {
        page_Util.clickOnElement(userProfileName);
        page_Util.clickOnElement(signOutUser);
    }
    
    public String getUserProfileName() {
        String userName = page_Util.getTextFromElement(userProfileName);
        return userName;
    }
    public void navigateToHomePage() {
        
        page_Util.clickOnElement(logo);
    }
    public void clickOnEventTab() {
    	page_Util.clickOnElement(eventTab);
    }
public void clickOnChatBox() {
	wait_Util.waitForAnElementToBeClickable(driver,chatBox);
	page_Util.clickOnElement(chatBox);
}
public void clickOnSenderMessage() {
	page_Util.clickOnElement(senderMessage);
}
public void getReplyMessage(String message) {
    page_Util.enterText(replyMessage, message);
    
}

public String displayRepliedMessage(String placeholder) {
    return page_Util.getAttributeValue(placeholderReplyMsg,placeholder);
}
 
   public void pressEnterKey() {
	   wait_Util.waitForAnElementToBeClickable(driver,chatBox);
	   page_Util.pressEnterKey(driver);
   }
	
	public void clickOnFinance() {
		wait_Util.waitForAnElementToBeClickable(driver,financeTab);
		page_Util.clickOnElement(financeTab);
	}
	public void clickOnIncomeVsExpenses() {
		page_Util.moveToElement(driver, incomeVsExpensesTab);
		page_Util.clickOnElement(incomeVsExpensesTab);
	}
	
	public void clickOnProject() {
		wait_Util.waitForAnElementToBeClickable(driver, projectTab);
		page_Util.clickOnElement(projectTab);
		page_Util.clickOnElement(allProjects);
	}
	public void clickOnItemsTab() {
		wait_Util.waitForAnElementToBeClickable(driver, itemsTab);
		page_Util.clickOnElement(itemsTab);
	}
	public void clickOnTimeCards() {
		page_Util.clickOnElement(timeCardsTab);
	}

public void clickOnTicketsTab() {
	page_Util.clickOnElement(ticketsTab);
}

	public void clickOnLeaveTab() {
		
		page_Util.scrollToElement(driver,leaveTab);
		wait_Util.waitForAnElementToBeClickable(driver, leaveTab);
		page_Util.clickOnElement(leaveTab);
	}
	public void clickOnannouncementTab() {
		page_Util.scrollToElement(driver, announcementTab);
		wait_Util.waitForAnElementToBeClickable(driver, announcementTab);
		page_Util.clickOnElement(announcementTab);
	}
	
}
    












