package automationLib;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.MainframeUtilities;
import utils.SeleniumUtilities;
import utils.Utilities;


public class MF_ReflectionLogin {
	
	


	

		SeleniumUtilities utils = new SeleniumUtilities();
		ErrorLogger err = new ErrorLogger();
		BaseLogger blogger = new BaseLogger();
		Utilities comnutils = new Utilities();
		MainframeUtilities mf=new MainframeUtilities();

		/*
		 * page factory init will initialize all the objects with proxy content
		 * any of the web element defirned is accessed only when action is being done on the element
		 * using ajax elementlocator factory the elements which will be loaded later can be handled as per
		 * the parmetres given driver will wait for 20 seconds polling every (250ms default in locatorfactory) for the presence of elemnt 
		 * when it is being accessed by driver 
		 */
		public MF_ReflectionLogin() {
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			if(!utils.checkIfErrorPage())
			{
				utils.refreshthepage();
			}
		}

		@FindBy(xpath= "//input[contains(@name,'username')]")
		WebElement txtLoginUserName;

		@FindBy(xpath= "//input[@type='password']")
		WebElement pwdLoginPwd;

		@FindBy(tagName = "button")
		WebElement btnLoginSubmit;
		
		@FindBy(xpath="//span[text()='web-CA']")
		WebElement webCA;

			

		public WebElement gettxtLoginUserName(){
			return txtLoginUserName;
		}


		public WebElement getpwdLoginuserPWD(){
			return pwdLoginPwd;
		}

		public WebElement getbtnLoginuSubmit(){
			return btnLoginSubmit;
		}

		
		


		public boolean clickbtnLoginsubmit (){
			return utils.clickAnelemnt(this.btnLoginSubmit, "Login", "Submit Button");
		}

		public boolean settxtLoginUserName (String User){
			return utils.enterTextinAnelemnt(this.txtLoginUserName, User, "Login", "Username Textbox");
		}

		public boolean setpwdLoginPwd (String pwd){
			return utils.enterTextinAnelemnt(this.pwdLoginPwd, pwd, "Login", "passwordbox");
		}

		/*
		 * @SCU
		 * #CommonMethodwithArgument:logIn
		 * #Arguments:username,password
		 * Type:Textbox
		 */
		public boolean logIn(String[] args){
			
				if(settxtLoginUserName(args[0]))
					if(setpwdLoginPwd(args[1]))
						return clickbtnLoginsubmit();

			return false;
		}


		public boolean logIn(){
			
				if(settxtLoginUserName(comnutils.getPropertyvalue("reflectionusername")))
					if(setpwdLoginPwd(comnutils.getPropertyvalue("reflectionpassword")))
						clickbtnLoginsubmit();
						//return utils.clickAnelemnt(webCA, "refelction", "Web-CA");
				try
				{
					return utils.clickAnelemnt(webCA, "refelction", "Web-CA");
					
				}catch(NoSuchElementException e)
				{
					
				}
				return false;
				
		}
		
		public boolean launchMainFrameReflectionApp() {
			Driver.pgDriver.get("https://zfe.wellpoint.com:7443/zfe/");
			return true;
		}
		
		
	}



