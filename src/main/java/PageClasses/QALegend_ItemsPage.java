package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_ItemsPage {
	WebDriver driver;
	PageUtility page_Util=new PageUtility();
	WaitUtility wait_Util=new WaitUtility();
	@FindBy(xpath = "//a[text()=' Add item']")
	WebElement addItems;
	
	@FindBy(name ="title")
	WebElement inputTitle;
	@FindBy(id = "description")
	WebElement inputDescription;
	@FindBy(name = "unit_type")
	WebElement enterUnitType;
	@FindBy(name = "item_rate")
	WebElement enterItemRate; 
	@FindBy(xpath = "//button[text()=' Save']")
	WebElement saveButton;
	@FindBy(xpath = "//h1[text()=' Items']")
	WebElement itemView;
	
	
	
	
	
	public QALegend_ItemsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void clickOnAddItems() {
		page_Util.clickOnElement(addItems);
	}
	
	public void inputTitleField(String msg) {
		page_Util.enterText(inputTitle, msg);
	}
	public void inputDescriptionField(String msg) {
		page_Util.enterText(inputDescription, msg);
	}
	public void enterUnitTypeField(String msg) {
		page_Util.enterText(enterUnitType, msg);
	}
	public void enterItemRateField(String msg) {
		page_Util.enterText(enterItemRate,msg);
		
	}
	public void pressSaveButton() {
		wait_Util.waitForAnElementToBeVisible(driver, saveButton);
		page_Util.clickOnElement(saveButton);
	}
	public String displayItem() {
		return page_Util.getTextFromElement(itemView);
	}
}













