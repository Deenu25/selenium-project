package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_ProjectPage {
	WebDriver driver;
	PageUtility page_Util=new PageUtility();
	WaitUtility wait_Util=new WaitUtility();
	@FindBy(xpath = "(//span[@class='caret'])[2]")
	WebElement statusOfProjects;
	@FindBy(xpath = "//li[text()='Completed']")
	WebElement completedProject;
	@FindBy(xpath = "//span[text()='Excel']")
	WebElement projectExcel;
	@FindBy(xpath = "//h1[text()='Projects']")
	WebElement projectText;
	
	
	
	public QALegend_ProjectPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void clickOnProjectStatus() {
		page_Util.clickOnElement(statusOfProjects);
	}
	public void clickOnCompletedProject() {
		page_Util.clickOnElement(completedProject);
	}
	public void clickOnExcel() {
        page_Util.clickOnElement(projectExcel);
	}
	public String displayProjectText() {
		 return page_Util.getTextFromElement(projectText);
	}
}
