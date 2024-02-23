package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_LeavePage {
	
WebDriver driver;
PageUtility page_Util=new PageUtility();
WaitUtility wait_Util=new WaitUtility();
@FindBy(xpath = "//a[text()=' Apply leave']")
WebElement applyLeave;

@FindBy(id = "s2id_leave_type_id")
WebElement leaveType;

@FindBy(id = "select2-results-3")
WebElement casualLeave;

@FindBy(id = "duration_single_day")
WebElement singleDay;

@FindBy(xpath = "//label[text()='Date']")
WebElement dateLabel;

@FindBy(xpath = "//td[text()='1']")
WebElement selectDate;

@FindBy(id = "reason")
WebElement reasonForLeave;

@FindBy(xpath = "//button[text()=' Apply leave']")
WebElement applyLeaveButton;

@FindBy(xpath = "//h1[text()='Leave']")
WebElement leaveView;





public QALegend_LeavePage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

public void clickOnApplyLeave() {
	page_Util.clickOnElement(applyLeave);
}

public void clickOnLeaveType() {
	page_Util.clickOnElement(leaveType);
}
public void selectLeaveType() {
	
	page_Util.clickOnElement(casualLeave);
}
public void radioButtonSelect() {
	page_Util.clickOnRadioButton(singleDay);
}
	public void clickOnDate() {
		page_Util.clickOnElement(dateLabel);
	}
	public void clickOnSelectDate() {
		page_Util.clickOnElement(selectDate);;
	}
	public void enterReasonForLeave() {
		page_Util.enterText(reasonForLeave, "Family Event");
	}
	public void clickOnApplyLeaveButton() {
		page_Util.clickOnElement(applyLeaveButton);
	}
	public String leaveTextDisplay() {
		return page_Util.getTextFromElement(leaveView);
	}
}













