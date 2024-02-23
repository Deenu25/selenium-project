package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_EventPage {
	WebDriver driver;
	PageUtility page_Util=new PageUtility();
	WaitUtility wait_Util=new WaitUtility();
	
	@FindBy(xpath = "//div[@class='title-button-group']")
	WebElement addEvent;

	@FindBy(name = "title")
	WebElement addTitle;
	
	@FindBy(id = "description")
	WebElement addDescription;
	
	@FindBy(id = "start_date")
	WebElement startDate;
	@FindBy(xpath = "(//td[text()='1'])[3]")
	WebElement enterStartDate;
	@FindBy(id = "end_date")
	WebElement endDate;
	@FindBy(xpath = "(//td[text()='2'])[3]")
	WebElement enterEndDate;
	@FindBy(name = "location")
	WebElement location;
    
	
	
	@FindBy(name = "share_with")
	WebElement shareWith;
	@FindBy(xpath = "//label[text()='Repeat']")
	WebElement repeat;
	
	@FindBy(xpath = "//button[text()=' Save']")
	WebElement saveButton;
	
	
	@FindBy(xpath ="//h1[text()='Event calendar']")
	WebElement eventCalendarTitle;
	
	
	
	

	public QALegend_EventPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	

    public void clickOnAddEvent() {
    	page_Util.clickOnElement(addEvent);
    }
    public void inputTitle(String message) {
addTitle.sendKeys("Automation Page");
}
     	
public void inputDescription(String message) {
		
		addDescription.sendKeys("This is Automated Page");
    
	}
public void clickOnStartDate() {
	page_Util.clickOnElement(startDate);
}
public void enterStartDate() {
	page_Util.clickOnElement(enterStartDate);
}
public void clickOnEndDate() {
	page_Util.clickOnElement(endDate);
}
public void enterEndDate() {
	page_Util.clickOnElement(enterEndDate);
}
public void inputLocation(String message) {
	page_Util.enterText(location, "Trvm");
}


public void selectShareWith() {
	page_Util.scrollToElement(driver, shareWith);
	page_Util.clickOnRadioButton(shareWith);
}
public void tickCheckBoxRepeat() {
	page_Util.clickOnCheckBox(repeat);
}
public void clickOnSave() {
	page_Util.clickOnElement(saveButton);
}
public String getTitleOfThePage()
{

return eventCalendarTitle.getText();
	
}
}
















