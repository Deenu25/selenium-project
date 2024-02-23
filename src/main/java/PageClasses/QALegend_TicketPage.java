package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_TicketPage {
	
WebDriver driver;
PageUtility page_Util=new PageUtility();
WaitUtility wait_Util=new WaitUtility();
 @FindBy(xpath = "//a[text()=' Add ticket']")
 WebElement addTickets;
 @FindBy(name = "title")
 WebElement insertTitle;
 @FindBy(id = "description")
 WebElement descriptionBox;
 @FindBy(xpath = "//label[text()='Client']")
 WebElement addClient;
 @FindBy(id = "s2id_client_id")
 WebElement clickAddClient;
 @FindBy(xpath = "//div[text()='AAAA ']")
 WebElement selectClient;
 
 @FindBy(xpath = "//button[text()=' Upload File']")
 WebElement uploadFile;
 @FindBy(xpath = "//button[text()=' Save']")
 WebElement saveButton;
 
 @FindBy(xpath = "//label[text()='Open']")
 WebElement statusOpen;

 






public QALegend_TicketPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
	
	public void clickOnAddTickets() {
		page_Util.clickOnElement(addTickets);
	}
	
	public void inputTitle(String message) {
		page_Util.enterText(insertTitle, "Ticket Test");
		}
	public void addClientTab() {
		wait_Util.waitForAnElementToBeClickable(driver, addClient);
		page_Util.clickOnElement(addClient);
	}
	public void clickOnAddClient() {
		page_Util.clickOnElement(clickAddClient);
	}
	public void clickSelectClient() {
		page_Util.clickOnElement(selectClient);
	}
	public void clickOnDescription() {
		page_Util.clickOnElement(descriptionBox);
	}
	public void insertDescrition(String message) {
		page_Util.enterText(descriptionBox, "Ticket Description");
	}
	public void clickOnFileUpload() {
		page_Util.clickOnElement(uploadFile);
	}
	
	public void fileUpload(String filePath) {
		wait_Util.waitForAnElementToBeClickable(driver,uploadFile);
		page_Util.uploadFileWithRobot("C:\\Users\\Administrator\\Desktop\\JAVA\\All-Java-components-Diagram.png");
	}

	public void clickSaveButton() {
		page_Util.clickOnElement(saveButton);
	}
	public String openStatus() {
		return page_Util.getTextFromElement(statusOpen);
	}
}













