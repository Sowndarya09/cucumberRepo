package automationLib;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtilities;
import utils.ErrorLogger;
import utils.BaseLogger;
import utils.DataSet;
import utils.Utilities;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;



public class Puma_Login {

	DataSet ds=new DataSet();
	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();
	Utilities comnutils = new Utilities();

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCompleteBilling;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructor for the Create Promised Action class defining the Iframe and the Page Factory  
	 */
	public Puma_Login() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
	}


	@FindBy(id="txtUserID")
	WebElement txtUserName;

	@FindBy(id="txtPassword")
	WebElement txtPassword;

	@FindBy(name="Domain")
	WebElement drpDownDomain;

	@FindBy(id="sub")
	WebElement btnLogin;

	@FindBy(xpath="//img[@id='imgLogo']")
	WebElement LoginLogo;	


	public boolean ValidateLoginPage()
	{
		return !utils.isProxyWebelement(LoginLogo);	
	}

	public boolean settxtLoginUserName (String User){
		return utils.enterTextinAnelemnt(this.txtUserName, User, "Login", "Username Textbox");
	}

	public boolean setpwdLoginPwd (String pwd){
		return utils.enterTextinAnelemnt(this.txtPassword, pwd, "Login", "passwordbox");			
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:logIn
	 * #Description: Picks the User Name and Password from the Config file and enters the user name and password in the respective field
	 * Type: Textbox 
	 */
	public boolean logIn(){
		if(this.ValidateLoginPage())
			if(settxtLoginUserName(comnutils.getPropertyvalue("username")))
				if(setpwdLoginPwd(comnutils.getPropertyvalue("password")))
				{
					System.out.println("Username and Password is picked from the Config file");
					return true;
				}
		return false;
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: selectUserGroups
	 * #Description: Selects the user group in the Login page
	 * #Argument: UserGroup
	 * Type: Dropdown
	 * Keys: agpcorp#wellpoint
	 */
	public boolean selectUserGroups(String[] args)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownDomain, args[0], "AA_LoginPuma", "Group Selection");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:clickLoginBtn
	 * #Description: Clicks the login button after entering the username and password and selecting the user group
	 * Type: Textbox 
	 */
	public boolean clickLoginBtn()
	{
		return utils.clickAnelemnt(this.btnLogin, "AA_LoginPuma", "Login button");
	}





}
