package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_AnnouncementPage {
	
WebDriver driver;
PageUtility page_Util=new PageUtility();
WaitUtility wait_Util=new WaitUtility();

@FindBy(xpath = "//a[text()=' Add announcement']")
WebElement addAnnouncement;
 @FindBy(id = "title")
 WebElement enterTitle;
 
 @FindBy(xpath = "//div[@class='note-editable panel-body']")
 WebElement textBody;
 
 @FindBy(id = "start_date")
 WebElement startDate;
 
 @FindBy(xpath = "(//td[text()='1'])[1]")
 WebElement selectStartDate;
 
 @FindBy(id = "end_date")
 WebElement endDate;
 
 @FindBy(xpath = "(//td[text()='3'])[1]")
 WebElement selectEndDate;
 
 @FindBy(id = "share_with_members")
 WebElement checkBox;
 
 @FindBy(xpath = "//button[text()=' Upload File']")
 WebElement uploadFile;
 
 @FindBy(xpath = "//span[text()='×']")
 WebElement alertMark;
 @FindBy(xpath = "//button[text()=' Save']")
 WebElement saveButton;



@FindBy(xpath = "//h1[text()='Edit announcement']")
WebElement editAnnouncement;



public QALegend_AnnouncementPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
	public void clickOnAddAnnouncement() {
		page_Util.clickOnElement(addAnnouncement);
	}
	public void enterTitle() {
		page_Util.enterText(enterTitle, "Test Automation");
	}
	public void enterBodyOfAnnouncement() {
		page_Util.enterText(textBody, "Test cases should be Automated");
	}
	public void clickOnStartDate() {
		page_Util.clickOnElement(startDate);
	}
	public void clickOnSelectStartDate() {
		page_Util.clickOnElement(selectStartDate);
	}
	public void clickOnEndDate() {
		page_Util.clickOnElement(endDate);
	}
	public void clickOnSelectEndDate() {
		page_Util.clickOnElement(selectEndDate);
	}
	public void selectCheckBox() {
		page_Util.clickOnCheckBox(checkBox);
	}
	public void clickFileUpload(){
		page_Util.scrollToElement(driver, uploadFile);
		wait_Util.waitForAnElementToBeClickable(driver, uploadFile);
		page_Util.clickOnElement(uploadFile);
	}
	public void uploadFile(String filePath) {
		page_Util.uploadFileWithRobot("C:\\Users\\Administrator\\Desktop\\JAVA\\All-Java-components-Diagram.png");
	}
	public void clickOnAlert() {
		alertMark.click();
	}
	public void clickSave() {
		page_Util.scrollToElement(driver,saveButton);
		page_Util.clickOnElement(saveButton);
	}
	
	public String displayEditAnnouncement() {
		return page_Util.getTextFromElement(editAnnouncement);
	}
}











