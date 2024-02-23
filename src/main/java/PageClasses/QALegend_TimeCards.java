package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_TimeCards {
	WebDriver driver;
	PageUtility page_Util=new PageUtility();
	WaitUtility wait_Util=new WaitUtility();
	
	@FindBy(xpath = "//a[text()='Clock In / Out']")
	WebElement clockInOrOut;
	
	
	@FindBy(xpath = "//a[text()='keerthana sasi']")
	WebElement detailStatusOfKeerthana;
	
	@FindBy(xpath = "//h1[text()='17,320.99']")
	WebElement totalWorkHours;
	
	
	
	
	public QALegend_TimeCards(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickOnClockInOrOut() {
		wait_Util.waitForAnElementToBeClickable(driver, clockInOrOut);
		page_Util.clickOnElement(clockInOrOut);
	}
	
	public void clickOnStatusOfKeerthana() {
		page_Util.clickOnElement(detailStatusOfKeerthana);
	}
	public String getTotalWorkHours() {
		return page_Util.getTextFromElement(totalWorkHours);
	}
}
