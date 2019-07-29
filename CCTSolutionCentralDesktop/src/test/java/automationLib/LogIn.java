package automationLib;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtilities;
import utils.ErrorLogger;
import utils.BaseLogger;
import utils.Utilities;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import TestDataPOJO.memberdetails;
import dataReader.JsonDataParsor;
import jsonManager.JsonDataReader;

public class LogIn {

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Utilities comnutils = new Utilities();

	/*
	 * page factory init will initialize all the objects with proxy content any
	 * of the web element defirned is accessed only when action is being done on
	 * the element using ajax elementlocator factory the elements which will be
	 * loaded later can be handled as per the parmetres given driver will wait
	 * for 20 seconds polling every (250ms default in locatorfactory) for the
	 * presence of elemnt when it is being accessed by driver
	 */
	public LogIn() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if (!utils.checkIfErrorPage()) {
			utils.refreshthepage();
		}
	}

	@FindBy(xpath = "//input[contains(@placeholder,'ser')]")
	WebElement txtLoginUserName;

	@FindBy(xpath = "//input[@type='password']")
	WebElement pwdLoginPwd;

	@FindBy(tagName = "button")
	WebElement btnLoginSubmit;

	@FindBy(className = "login-block")
	WebElement divLoginHeader;

	@FindBy(xpath = "//div[contains(@class,'error')]")
	WebElement divLoginError;

	@FindBy(xpath = "//img[contains(@src,Login)]")
	WebElement LoginLogo;

	@FindBy(className = "error")
	WebElement ErrorMessage;

	@FindBy(name = "username")
	WebElement txtBxUserName;

	@FindBy(name = "password")
	WebElement txtBxPwd;

	@FindBy(name = "submit")
	WebElement btnLoginMF;

	
	
	public WebElement gettxtLoginUserName() {
		return txtLoginUserName;
	}

	public WebElement getpwdLoginuserPWD() {
		return pwdLoginPwd;
	}

	public WebElement getbtnLoginuSubmit() {
		return btnLoginSubmit;
	}

	public WebElement getdivLoginHeader() {
		return divLoginHeader;
	}

	public WebElement getdivLoginError() {
		return divLoginError;
	}
	
	public boolean ValidateLoginPage()
	{
		utils.waitForElementToBeVisible(LoginLogo);
		return !utils.isProxyWebelement(LoginLogo);
	}

	public boolean isvalidLogin() {
		utils.waitforpageload();
		if (!utils.isProxyWebelement(getdivLoginError())) {
			if (getdivLoginError().getText().contains("Please check your username and password and try again.")) {
				System.out.println("Invalid Login Credentials");
				return false;
			}
			return false;
		} else {
			return true;
		}
	}

	public boolean clickbtnLoginsubmit() {
		return utils.clickAnelemnt(this.btnLoginSubmit, "Login", "Submit Button");
	}

	public boolean settxtLoginUserName(String User) {
		return utils.enterTextinAnelemnt(this.txtLoginUserName, User, "Login", "Username Textbox");
	}

	public boolean setpwdLoginPwd(String pwd) {
		return utils.enterTextinAnelemnt(this.pwdLoginPwd, pwd, "Login", "passwordbox");
	}

	/*
	 * @SCU #CommonMethodwithArgument:logIn #Arguments:username,password
	 * Type:Textbox
	 */
	public boolean logIn(String[] args) {
		if (this.ValidateLoginPage())
			if (settxtLoginUserName(args[0]))
				if (setpwdLoginPwd(args[1]))
					if (clickbtnLoginsubmit())
						return true;
		return false;
	}

	
	public boolean logIn() {
		if (this.ValidateLoginPage())
			if (settxtLoginUserName(comnutils.getPropertyvalue("username")))
				if (setpwdLoginPwd(comnutils.getPropertyvalue("password")))
					if (clickbtnLoginsubmit())
						return true;
		return false;
	}

	
	public boolean enterUserNameAndPwdForMF(String[] args) {
		if (utils.enterTextinAnelemnt(txtBxUserName, args[0], "LogIn", "User name"))
			if (utils.enterTextinAnelemnt(txtBxPwd, args[1], "LogIn", "User name"))
				if (utils.clickAnelemnt(this.btnLoginSubmit, "Login", "Submit Button"))
					return true;
		return false;
	}

	private boolean login(memberdetails mem) {
		if (this.ValidateLoginPage())
			if (settxtLoginUserName(mem.username))
				if (setpwdLoginPwd(mem.password))
					if (clickbtnLoginsubmit())
						return true;
		return false;

	}

	public boolean jsonLogin(String[] args) {

		memberdetails mem = JsonDataReader.getInstance().getJsonReader().getmemberbydataid(args[0]);
		return login(mem);

	}
}
