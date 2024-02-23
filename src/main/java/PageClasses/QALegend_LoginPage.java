package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegend_LoginPage {
	WebDriver driver;
	PageUtility page_Util=new PageUtility();
	WaitUtility wait_Util=new WaitUtility();
	@FindBy(id="email")
	WebElement userNamefield;
	
	@FindBy(name ="password")
    WebElement passwordField;

    @FindBy(xpath ="//button[text()='Sign in']")
    WebElement signInButton;




	public QALegend_LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
public void loginCRM(String username,String password) {
        
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
       
    }

	public void enterUserName(String username)
	{
     wait_Util.waitForAnElementToBeVisible(driver, userNamefield);
    page_Util.enterText(userNamefield, username);
		
	}

	public void enterPassword(String password) {
        page_Util.enterText(passwordField, password);
    }

    public void clickLoginButton() 
    {
    	signInButton.click();
    }


	}


