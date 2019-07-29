package automationLib;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;
import utils.Utilities;

public class Puma_Home {

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
	public Puma_Home() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
	}

	@FindBy(id="UserID")
	WebElement txtNetworkID;

	@FindBy(id="PumaDomainName")
	WebElement drpDownDomainName;

	@FindBy(id="AppList")
	WebElement drpDownApplicationName;

	@FindBy(xpath="//div[contains(text(),'Search')]")
	WebElement btnSearch;

	@FindBy(xpath="//label[contains(text(),'PAM-12')]")
	WebElement tabPam;


	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterNetworkIDAndSelectDomainAndSelectApplicationAndClickSearch
	 * #Description: Enters the Network ID, selects the Domain name and selects the Applicatio  name and then clicks search button
	 * #Arguments: NetDomApp
	 * Type: Textbox
	 * Type: Dropdown
	 * Keys: AGPCORP#US
	 * Keys: Appeals#Beacon#Compass#DRT#FUSE#KM#Pharmacy#CPSUI#Intuitive Claim Processing Tool#Program Integrity#Delegated Risk Entity Workflow#CRAV#FICR#FEAR#Solution Central
	 */
	public boolean enterNetworkIDAndSelectDomainAndSelectApplicationAndClickSearch(String[] args)
	{
		if(this.enterNetworkID(args[0]))
			if(this.selectDomain(args[1]))
				if(this.selectApplication(args[2]))
					return this.clickSearch(); 
		return false;
	}


	public boolean enterNetworkID(String networkid)
	{
		return utils.enterTextinAnelemnt(this.txtNetworkID, networkid, "AA_HomePuma", "Network id");

	}

	public boolean selectDomain(String domain)
	{

		return utils.selectDropDownbyVisibleString(this.drpDownDomainName, domain, "AA_HomePuma", "Domain");
	}

	public boolean selectApplication(String app)
	{

		return utils.selectDropDownbyVisibleString(this.drpDownApplicationName, app, "AA_HomePuma", "Application");
	}


	public boolean clickSearch()
	{
		return utils.clickAnelemnt(this.btnSearch, "AA_HomePuma", "Search");
	}


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument:clickPamTab
	 * #Description: Clicks the PAM Tab after searching the user profile
	 * Type: Textbox 
	 */
	public boolean clickPamTab()
	{
		utils.waitforpageload();
		return utils.clickAnelemnt(this.tabPam, "AA_HomePuma", "Tab Pam");
	}



}
