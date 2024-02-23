package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_FinancePage {
	WebDriver driver;
	PageUtility page_Util=new PageUtility();
	WaitUtility wait_Util=new WaitUtility();
	
	@FindBy(xpath = "//a[text()='Chart']")
	WebElement chart;
	
	@FindBy(xpath = "//a[text()='Summary']")
	WebElement summaryOfChart;
	@FindBy(id = "income-vs-expenses-summary-table")
	WebElement summaryTable;

	@FindBy(xpath = "//span[text()='Print']")
	WebElement printSummary;
	
	
	@FindBy(xpath = "//body[@class='dt-print-view']")
	WebElement printView;
	
	@FindBy(xpath = "//h4[text()='Income vs Expenses']")
	WebElement textvisible;
	
	
	
	
	public QALegend_FinancePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	
	public void chartVisibility() {
		wait_Util.waitForAnElementToBeVisible(driver, chart);
		page_Util.isElementDisplayed(chart);
		
	}
	 public void clickOnSummary() {
		 page_Util.clickOnElement(summaryOfChart);
		  }
	 public void clickSummaryTable() {
		 wait_Util.waitForAnElementToBeClickable(driver, summaryTable);
		 page_Util.clickOnElement(summaryTable);
	 }
    public void clickOnPrintSummary() {
    	wait_Util.waitForAnElementToBeClickable(driver, printSummary);
    	page_Util.clickOnElement(printSummary);
    }
    
    public void printView() {
    	page_Util.isElementDisplayed(printView);
    }
    public String getTextVisible()
	{
		return page_Util.getTextFromElement(textvisible);
		
	
	}
}