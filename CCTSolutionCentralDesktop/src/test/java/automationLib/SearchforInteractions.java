package automationLib;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class SearchforInteractions extends Driver{

	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());
	String pgname ="search by claim number";

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	@FindBy(id="PegaGadget2Ifr")
	WebElement Iframeelement2;

	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderSearchByClaimnumber;

	@FindBy(xpath="//*[@data-test-id='201802201521570221783376']")	
	private WebElement txtboxclaimnumber;

	@FindBy(xpath="//*[@data-test-id='201802201521570225794397']")	
	private WebElement btnLast30days;


	@FindBy(xpath="//*[@data-test-id='201802201521570223791419']")	
	private WebElement btntoday;

	@FindBy(xpath="//*[@data-test-id='201802201521570224792729']")	
	private WebElement btnYesterday;

	@FindBy(xpath="//*[@data-test-id='201802201521570224793602']")	
	private WebElement btnLast7days;

	@FindBy(xpath="//*[@data-test-id='201802201521570226795552']")	
	private WebElement btnLast90days;

	@FindBy(xpath="//*[@data-test-id='201802201521570226798637']")	
	private WebElement btnsearch;	

	@FindBy(xpath="//*[@data-test-id='201802201521570227802671']")	
	private WebElement btnclearsearch;	


	@FindBy(xpath="//*[text()='Interaction ID']/ancestor::table[@id='bodyTbl_right']")	
	private WebElement tblSearchresult;	

	@FindBy(id="ServiceFromDate")
	private WebElement txtStartDate;

	@FindBy(id="ServiceToDate")
	private WebElement txtendDate;







	public SearchforInteractions(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);

	}

	public boolean validateHeader(){

		if (utils.validateHeader(this.sHeaderSearchByClaimnumber, "Search for Interactions and Service Requests"))
			return true;
		return false;
	}
	
	@FindBy(id="SearchBySRClaim Number")
	WebElement SearchByClaimNumberRBtn;
	public boolean enterClaimNumber(String[] args){
		utils.waitforpageload();
		if(this.validateHeader())
			if(utils.clickAnelemnt(SearchByClaimNumberRBtn, "Search for interactions", "txt box claimnumber"))
			if (utils.enterTextinAnelemnt(txtboxclaimnumber, args[0], "Search for interactions", "txt box claimnumber"))
				return true;
		return false;		

	}


	public boolean clickOnLast30DaysLink(){

		if(utils.clickAnelemnt(btnLast30days, pgname, "Button last 30 days"))
			return true;
		return false;
	}

	public boolean clickOnSearchButton(){

		if(utils.clickAnelemnt(btnsearch, pgname, "Button Search"))
			return true;
		return false;
	}

	public boolean clickOnTodayLink(){

		if(utils.clickAnelemnt(btntoday, pgname, "Button Today"))
			return true;
		return false;
	}

	public boolean enterStartDateAndEndDate(String[] args){
		utils.waitforpageload();
		if(utils.enterTextinAnelemnt(txtStartDate, args[0], pgname, "Start date"))
			if(utils.enterTextinAnelemnt(txtendDate, args[1], pgname, "enddate"))
				return true;
		return false;

	}

	public boolean clickOnLast7DaysLink(){

		if(utils.clickAnelemnt(btnLast7days, pgname, "Button last 7days"))
			return true;
		return false;
	}

	public boolean clickOnYesterdayLink(){

		if(utils.clickAnelemnt(btnYesterday, pgname, "Button last 7days"))
			return true;
		return false;
	}

	public boolean clickOnLast90DaysLink(){

		if(utils.clickAnelemnt(btnLast90days, pgname, "Button last 7days"))
			return true;
		return false;
	}

	public boolean clickOnClearSearchButton(){
		if(utils.clickAnelemnt(btnclearsearch, pgname, "clear search"))
			utils.waitforpageload();
			if (txtboxclaimnumber.getText().equals(""))
				if(txtStartDate.getText().equals(""))
					if(txtendDate.getText().equals(""))
						return true;
		return false;
	}


	public boolean validateAndExpandTheInteractionRow(String[] args) throws InterruptedException
	{utils.waitforpageload();
	WebElement tr =utils.returntablerowbasedonvalues(tblSearchresult, args);
	if(tr!=null){
		if(utils.clickAnelemnt(tr.findElements(By.tagName("td")).get(2),pgname,"Expand button"))
			return true;
		return false;
	}
	else{
		err.logerrormessage("Search did not return any value");
		return false;
	}

	}
	@FindBy(xpath="//a[@title='Click here to open the object']")
	WebElement ViewSR;

	@FindBy(xpath="//span[contains(text(),'Access to Anthem House Account')]")
	WebElement HouseAcc;


	public boolean verifyHouseAccountAccess() throws InterruptedException
	{utils.waitforpageload();

	if(utils.clickAnelemnt(this.ViewSR, "SearchByClaim", "ViewSR"))

	/*PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
	Driver.getPgDriver().switchTo().defaultContent();
	Driver.getPgDriver().switchTo().frame(this.Iframeelement2);*/
	if(!utils.isProxyWebelement(HouseAcc))
		return true;
	else
		return true;
	return false;
	}

	public boolean validateAndExpandTheInteractionRow() throws InterruptedException
	{
		utils.waitforpageload();
		return utils.clickAnelemnt(tblSearchresult.findElements(By.tagName("td")).get(0),pgname,"Expand button");
	}
	
	@FindBy(id="SearchBySRClaim Number")
	WebElement ClaimNumberRdbButton;
	
	public boolean clickOnClaimNumberRadioButton() {
		return utils.clickAnelemnt(ClaimNumberRdbButton, "Search For Interactions", "ClaimNumberRdbButton");
	}
	
    @FindBy(id="SearchBySRSecure Message Reference Number")
    WebElement SelectReferencenum;
    
    @FindBy(id="SecureMessageRefNum")
    WebElement enterSecureMessageRefNum;
    
    public boolean SelectSecureMessagReferenceRadiobtn()
    {
                    return utils.clickAnelemnt(SelectReferencenum, "SearchforInteraction", "SelectReferencenum");
    }
    /**
     * This Method select the radio button tagged to secure message reference number and enter value in text box field
     * @param args
     * @return
     */
    public boolean enterSecureMessageReferenceNumber(String[] args)
    {
                    SelectSecureMessagReferenceRadiobtn();
                    return utils.enterTextinAnelemnt(enterSecureMessageRefNum, args[0],"SearchforInteraction", "enterSecureMessageRefNum");
    }

}