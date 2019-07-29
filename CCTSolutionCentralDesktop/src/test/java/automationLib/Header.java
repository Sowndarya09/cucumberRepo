package automationLib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DataStore;
import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;
import automationLib.LogIn;
import stepdefinition.stepdefinition;


public class Header extends Driver {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Actions action = new Actions(pgDriver);
	

	public Header(){
		try
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			if(utils.isAlertPresent())
			{
				Driver.pgDriver.switchTo().alert().accept();
			}
			Driver.getPgDriver().switchTo().defaultContent();
		}catch(Exception e)
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
		}
	}
	@FindBy(xpath="//div[@node_name='CPMHCInteractionPortalTop']//*[contains(text(),'Tools')]")
	WebElement lnkHomeTools;

	@FindBy(id ="pySearchText")
	WebElement searchbar;

	@FindBy(name ="CPMSearch_pyDisplayHarness_2")
	WebElement clicksearch;

	@FindBy(xpath="//a[@data-test-id='20150920131130008614663']")
	WebElement optionsbutton;
	@FindBy(linkText= "Preferences")
	WebElement preferenceslink;
	@FindBy(linkText = "Profile")
	WebElement profilelink;
	@FindBy(linkText ="Phone")
	WebElement phonelink;
	@FindBy(linkText ="Logout")
	WebElement logout;
	@FindBy(linkText ="Dashboard")
	WebElement homeDashboard;

	@FindBy(linkText="Lookup Code")
	WebElement lnkHeaderLookupCode;

	@FindBy(linkText="Browse Benefits")
	WebElement lnkHeaderBrowseBenefits;

	@FindBy(linkText="Provider Links")
	WebElement lnkHeaderProviderLinks;
	
	@FindBy(linkText="Medical Policies")
	WebElement lnkHeaderMedicalPolicies;
	
	@FindBy(linkText="Case Search")
	WebElement lnkHeaderCaseSearch;
	
	@FindBy(linkText="Search for Interactions")
	WebElement lnkHeaderSearchForInteractions;
	
	@FindBy(linkText="View Service Intents")
	WebElement lnkHeaderViewServiceIntents;
	
	
	@FindBy(linkText="Search By Claim Number")
	WebElement lnkHeaderSearchByclaimNumber;

	@FindBy(xpath="//a[contains(@data-click,'PortalUser')]")
	static
	WebElement PortalUser;

	public WebElement getsearchbar(){
		return searchbar;
	}
	public WebElement getclicksearchbutton(){
		return clicksearch;
	}

	public WebElement getoptionsbutton(){

		return optionsbutton;
	}

	public WebElement getpreferenceslink(){
		return preferenceslink;
	}

	public WebElement getprofilelink(){
		return profilelink;
	}

	public WebElement getphonelink(){
		return phonelink;
	}
	public WebElement getlogout(){
		return logout;
	}

	@FindBy(id="PegaGadget0Ifr")
	WebElement Iframeelement;

	public boolean clickLookUpCode()
	{
		return utils.clickAnelemnt(this.lnkHeaderLookupCode,"Header","Look up code link");
	}

	public boolean clickBrowseBenefits()
	{
		return utils.clickAnelemnt(this.lnkHeaderBrowseBenefits,"Header","Browse Benefits link");
	}

	public boolean clickSearchByclaimNumber()
	{
		return utils.clickAnelemnt(this.lnkHeaderSearchByclaimNumber,"Header","Search by claimnumber");
	}

	public boolean settextheadersearch(String searchtext){
		return utils.enterTextinAnelemnt(this.getsearchbar(), searchtext, "Header", "Searchbar")	;
	}
	public boolean clickpreferences(){
		return utils.clickAnelemnt(this.getpreferenceslink(), "Header", "Preferences link");

	}

	public boolean clickprofile(){
		return utils.clickAnelemnt(this.getprofilelink(), "Header", "Profile-Link");

	}

	public boolean clicklogout(){
		return utils.clickAnelemnt(this.getlogout(), "Header", "Logout link")	;
	}
	public boolean clickUseroptions() throws InterruptedException{
		return utils.clickAnelemnt(this.getoptionsbutton(), "Header", "User menu");
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:createNewInteractionPhoneCallmember
	 * Type:Textbox 
	 */
	public boolean createNewInteractionPhoneCallmember() throws InterruptedException{
		if(this.clickMember()){
			utils.waitForElementToBeVisible(lnkPhoneCallInteraction);
			if(this.clickLinkPhoneInteraction()){
				Thread.sleep(1000);
				return true;
			}
			else{
				stepdefinition.isServicedown=true;
				extentmanager.ExtentManager.setTeststatus("Warning-Possible Role Issue");
				err.logcommonMethodError("Header", "createNewInteractionPhoneCallmember");
				return false;
			}
		}
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:createNewInteractionPhoneCallprovider
	 * Type:Textbox

	 */
	public boolean createNewInteractionPhoneCallprovider(){	
		if(this.clickProvider()){
			if(this.clickLinkPhoneInteraction())
			{
				return true;
			}
			else{
				stepdefinition.isServicedown=true;
				extentmanager.ExtentManager.setTeststatus("Warning-Possible Role Issue");
				err.logcommonMethodError("Header", "createNewInteractionPhoneCallprovider");
				return false;
			}

		}	
		return false;

	}


	@FindBy(xpath="//a[@data-test-id='2015092013113000865822'][contains(text(),'Member')]")
	WebElement lnkMember;

	@FindBy(xpath="//a[@data-test-id='2015092013113000865822'][contains(text(),'Provider')]")
	WebElement lnkProvider;

	@FindBy(xpath="//a[@data-test-id='2015092013113000865822'][contains(text(),'Broker')]")
	WebElement lnkBroker;

	@FindBy(xpath="//span[contains(text(),'Phone Call')]")
	WebElement lnkPhoneCallInteraction;

	@FindBy(xpath="//span[contains(text(),'Research')]")
	WebElement lnkResearchInteraction;

	@FindBy(xpath="//span[contains(text(),'Secure Message')]")
	WebElement lnkSecureMessageInteraction;

	@FindBy(xpath="//span[contains(text(),'Email')]")
	WebElement lnkEmailInteraction;

	@FindBy(xpath="//span[contains(text(),'Outbound Call')]")
	WebElement lnkOutBoundInteraction;

	@FindBy(xpath="//span[contains(text(),'Chat')]")
	WebElement lnkChatInteraction;

	@FindBy(xpath="//a[@title='Quick Links']")
	WebElement lnkLinks;

	public boolean clickMember()
	{
		return utils.clickAnelemnt(lnkMember, "Header", "Member");
	}

	public boolean clickProvider()
	{
		return utils.clickAnelemnt(lnkProvider, "Header", "Provider");
	}

	public boolean clickBroker()
	{
		return utils.clickAnelemnt(lnkBroker, "Header", "Member");
	}

	public boolean clickLinkPhoneInteraction()
	{
		return utils.clickAnelemnt(lnkPhoneCallInteraction, "Header", "Phone");
	}

	public boolean clickLinkResearchInteraction()
	{
		return utils.clickAnelemnt(lnkResearchInteraction, "Header", "Research");
	}

	public boolean clickLinkChatInteraction()
	{
		return utils.clickAnelemnt(lnkChatInteraction, "Header", "Chat");
	}

	public boolean clickLinkSecureMessageInteraction()
	{
		return utils.clickAnelemnt(lnkSecureMessageInteraction, "Header", "Research");
	}

	public boolean clickLinkEmailInteraction()
	{
		return utils.clickAnelemnt(lnkEmailInteraction, "Header", "Email");
	}

	public boolean clickLinkOutBoundInteraction()
	{
		return utils.clickAnelemnt(lnkOutBoundInteraction, "Header", "OutBound");
	}

	public boolean clickLinks()
	{
		return utils.clickAnelemnt(lnkLinks, "Header", "Links");
	}



	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:createNewInteractionResearchmember
	 * Type:Textbox
	 */

	public boolean createNewInteractionResearchmember() throws InterruptedException{	
		if(this.clickMember()){
			utils.waitForElementToBeVisible(lnkResearchInteraction);
			if(this.clickLinkResearchInteraction())
			{
				return true;
			}
			else{
				stepdefinition.isServicedown=true;
				extentmanager.ExtentManager.setTeststatus("Warning-Possible Role Issue");
				err.logcommonMethodError("Header", "createNewInteractionPhoneCallmember");
				return false;
			}

		}
		return false;
	}

	public boolean logOut() throws InterruptedException{
		if (this.clickUseroptions())
			if(this.clicklogout())
			{
				try 
				{
					Driver.pgDriver.switchTo().alert().accept();
				} catch (Exception e) {
					e.printStackTrace();
				}
				blogger.loginfo("Logged out of Application");
				return true;
			}
		blogger.loginfo("Failed while Logging out of Application");
		return false;
	}

	public boolean navigatetoLookUpCode()
	{
		return utils.selectValueFromListbyVisibleString(lnkLinks, "Lookup Code", "Header", "lnkLinks - Lookup Code");
	}

	public boolean navigatetoBrowseBenefits()
	{
		return utils.selectValueFromListbyVisibleString(lnkLinks, "Browse Benefits", "Header", "lnkLinks - Browse Benefits");
	}
	
	public boolean navigatetoMedicalPolicies()
	{
		return utils.selectValueFromListbyVisibleString(lnkLinks, "Medical Policies", "Header", "lnkLinks - Medical Policies");
	}
	
	public boolean navigatetoProviderLinks()
	{
		return utils.selectValueFromListbyVisibleString(lnkLinks, "Provider Links", "Header", "lnkLinks - Provider Links");
	}
	public static String user;
	
	public static String getUserName()
	{
		user=PortalUser.getText().trim();
		return user;
	}


	/*
	 * @SCU 
	 * #CommonMethodwithoutArgument: createNewInteractionPhoneCallProviderMember
	 * #Description: This functionality creates a new interaction using Phone Call Provider option.
	 * Type:Textbox
	 */

	public boolean createNewInteractionPhoneCallProviderMember() {
		utils.waitforpageload();
		if (this.clickProvider()) {
			if (this.clickLinkPhoneInteraction()) {
				return true;
			}
			else {
				stepdefinition.isServicedown=true;
				extentmanager.ExtentManager.setTeststatus("Warning-Possible Role Issue");
				err.logcommonMethodError("Header", "createNewInteractionPhoneCallprovider");
				return false;
			}

		} 
		return false;
	}

	/*
	 * @SCU 
	 * #CommonMethodwithoutArgument: createNewInteractionResearchProviderMember
	 * #Description: This functionality creates a new interaction using Research Provider option.
	 * Type:Textbox
	 */

	public boolean createNewInteractionResearchProvider() {
		utils.waitforpageload();
		if (this.clickProvider()) {
			if (this.clickLinkResearchInteraction()) {
				return true;
			}
			else {
				stepdefinition.isServicedown=true;
				extentmanager.ExtentManager.setTeststatus("Warning-Possible Role Issue");
				err.logcommonMethodError("Header", "createNewInteractionPhoneCallprovider");
				return false;
			}

		}
		return false;
	}

	@FindBy(xpath = "//a[text()='Home']")
	private WebElement headerHomeIcon;

	public WebElement headerHome() {
		return headerHomeIcon;

	}

	public boolean verifyHeaderForHeaderPage(){
		utils.waitforpageload();
		return utils.validateHeader(this.headerHome(),"Home");
	}

	@FindBy(xpath="//input[@id=\"pySearchText\"]")
	WebElement txtSearchBar;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterSRIDInSearchBar
	 * #Description: This functionality gets the SR ID from the task created and enters the SR ID in the search bar.
	 * Type: Textbox
	 */
	public boolean enterSRIDInSearchBar()
	{
		if(utils.selectValueFromListbyVisibleString(lnkLinks, "Case Search", "Header", "lnkLinks - Case Search")) {
			blogger.loginfo("String Value is: "+MemberComposite.SRIDAfterSubstring);
			return utils.enterTextinAnelemnt(searchText, MemberComposite.SRIDAfterSubstring, "Header", "Case Search Text Box");
		}
		return false;
	}

	@FindBy(xpath="//img[@data-test-id='2016030501100102712945']")
	WebElement imgSearch;


	/*
	 * @SCU
	 * #CommonMethodWithArgument: clickSearchIcon
	 * #Description: This functionality gets the SR ID from the task created and enters the SR ID in the search bar.
	 * Type: Textbox
	 */
	public boolean clickSearchIcon()
	{
		return utils.clickAnelemnt(this.imgSearch, "Header", "Search");
	}

	@FindBy(xpath="//label[@for='pyID1']//parent::div//span//a")
	WebElement lnkSRID;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: clickTheSRID
	 * #Description: This functionality gets clicks the SR-ID of the returned search results.
	 * Type: Textbox
	 */
	public boolean clickTheSRID()
	{
		return utils.clickAnelemnt(this.lnkSRID, "Header", "SR-ID");
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterSRIDInSearchBarForProvider
	 * #Description: This functionality gets the SR ID from the task created and enters the SR ID in the search bar.
	 * Type: Textbox
	 */
	public boolean enterSRIDInSearchBarForProvider()
	{
		if(utils.selectValueFromListbyVisibleString(lnkLinks, "Case Search", "Header", "lnkLinks - Case Search")) {
			blogger.loginfo("String Value is: "+ProviderComposite.SRIDAfterSubstring);
			return utils.enterTextinAnelemnt(searchText, ProviderComposite.SRIDAfterSubstring, "Header", "Case Search Text Box");
		}
		return false;

	}


	@FindBy(xpath="//input[@id='pySearchText']")
	private WebElement searchText;


	/*
	 * @SCU
	 * #CommonMethodWithArgument: enterSRIDInSearchBarForMember
	 * #Description: This functionality gets the SR ID from the task created and enters the SR ID in the search bar.
	 * Type: Textbox
	 */
	public boolean enterSRIDInSearchBarForMember()
	{
		if(utils.selectValueFromListbyVisibleString(lnkLinks, "Case Search", "Header", "lnkLinks - Case Search")) {
			blogger.loginfo("String Value is: "+MemberComposite.SRIDAfterSubstring);
			return utils.enterTextinAnelemnt(searchText, MemberComposite.SRIDAfterSubstring, "Header", "Case Search Text Box");
		}
		return false;

	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: createNewInteractionChatmember
	 * #Description: This functionality creates the new interaction via chat member
	 * Type: Textbox
	 */
	public boolean createNewInteractionChatmember(){	
		if(this.clickMember()){
			if(this.clickLinkChatInteraction())
			{
				return true;
			}

			else{
				stepdefinition.isServicedown=true;
				extentmanager.ExtentManager.setTeststatus("Warning-Possible Role Issue");
				err.logcommonMethodError("Header", "createNewInteractionResearchmember");
				return false;
			}

		}    
		return false;
	}

	public boolean navigateToSearchforInteractions(){
		return utils.selectValueFromListbyVisibleString(lnkLinks, "Search for Interactions", "Header", "lnkLinks - Search for Interactions");

	}

	@FindBy(xpath="//input[@id='pySearchText']")
	WebElement Casesearch;

	@FindBy(xpath="//img[@data-test-id='2016030501100102712945']")
	WebElement searchButtonInCaseSearch;

	@FindBy(xpath="//table[contains(@pl_prop,'pgRepPgSubSectionCPMSearchResults')]//tr[@id='$PpgRepPgSubSectionCPMSearchResultsBB$ppxResults$l1']//td//a")
	WebElement clickSRID;

	/*
	 * @SCU
	 * #CommonMethodWithArgument: searchSRInCaseSearch
	 * #Description: This functionality gets the SR ID from the task created,search the SR ID in the case search and clicks the SR
	 * Type: Textbox
	 */
	public boolean searchSRInCaseSearch()
	{
		if(enterSRIDInSearchBar())
			if(clickSearchIcon())
				return utils.clickAnelemnt(clickSRID, "Header", "clickSRID");
		return false;
	}

	@FindBy(xpath="//h1[text()='Logout']")
	WebElement lblLogOut;

	int i=0;
	public boolean logOutAndReLogin() throws InterruptedException{
		String relogin;
		if (logOut())
			{			
				try 
				{
					Thread.sleep(2000);
					Driver.pgDriver.switchTo().alert().accept();
				} catch (Exception e) {
					e.printStackTrace();
				}
				Driver.pgDriver.switchTo().defaultContent();
				wait=new WebDriverWait(Driver.pgDriver,30);
				try {
					wait.until(ExpectedConditions.visibilityOf(this.lblLogOut));
					Thread.sleep(5000);
					relogin = Driver.pgDriver.getCurrentUrl().replace("logout", "login");
				}catch(Exception e) {
					String[] reloginurl = Driver.pgDriver.getCurrentUrl().split("/public");
					relogin = reloginurl[0]+":1024/public/login.html";
				}
				System.out.println("Relogin URL"+relogin);
				Driver.pgDriver.navigate().refresh();
				Driver.pgDriver.navigate().to(relogin);
				Driver.pgDriver.navigate().refresh();
				return true;
			}
		return false;
	}

	/**This method is used to search sing SR ID*/
	public boolean searchUsingSRID(String[] args) {
		if(utils.enterTextinAnelemnt(Casesearch, args[0], "Header", "Casesearch"))
			if(clickSearchIcon()) {
				return clickTheSRID();
			}
		return false;
	}

	@FindBy(xpath="//a[@data-test-id='20150920131130008614663']")
	WebElement tabUser;

	@FindBy(xpath="//span[contains(text(),'Profile')]")
	WebElement tabProfile;

	@FindBy(xpath="//td[contains(text(),'AntmCSWGS:GandAAssociate-Distr&Monitoring')]")
	WebElement labelAccessGroup;

	@FindBy(xpath="//td[contains(text(),'Access group')]/following-sibling::td[1]")
	WebElement AccessGroup;

	@FindBy(xpath="(//*[text()='Work Group'])[2]/following-sibling::td[1]")
	WebElement WorkGroup;

	@FindBy(xpath="(//td[contains(text(),'LargeGroupLocalCS')])[2]")
	WebElement labelAccessGroupForBroker;


	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickProfileAndVerifyTheAccessGroup
	 * #Description: Clicks the Profile of the User and then navigates to the Profile Window and verifies the Access Group of the User
	 * #Type: Textbox
	 */
	public boolean clickProfileAndVerifyTheAccessGroup() throws InterruptedException
	{
		Boolean flag = false;
		String parent = Driver.pgDriver.getWindowHandle();
		System.out.println("Parent Window ID: "+parent);
		if(utils.clickAnelemnt(this.tabUser, "Header", "User"))
		{
			if(utils.clickAnelemnt(this.tabProfile, "Header", "Profile"))
			{
				Thread.sleep(2000);
				Set<String> handles = Driver.pgDriver.getWindowHandles();
				System.out.println("Parent & Child Window ID: "+handles);
				System.out.println("No.ofwindows"+handles.size());
				Iterator<String> iterator= handles.iterator();
				String parentWindow = iterator.next();
				String childWindow = iterator.next();
				String title = Driver.pgDriver.switchTo().window(childWindow).getTitle().trim();
				System.out.println("Title of the Child Window is: "+title);
				if(title.contains("Operator Profile"))
				{
					System.out.println("Operator Profile is launched and the title is: "+ title); 
					String accessGroup = labelAccessGroup.getText();
					System.out.println(accessGroup);
					flag = utils.validateLabel(labelAccessGroup, "GandAAssociate-Distr&Monitoring");
					Driver.pgDriver.switchTo().window(parent);
					String title1 = Driver.pgDriver.getTitle();
					System.out.println("Title of the Parent Window is: "+title1);
				}
			}
		}
		return flag;
	}

	@FindBy(xpath="//a[contains(text(),'Quick Links')]")
	WebElement lnkQuickLinks;


	public boolean verifyToolsTabIsDisplayed()
	{
		return !utils.isProxyWebelement(lnkHomeTools);
	}


	public boolean verifyQuickLinksTabIsDisplayed()
	{
		return !utils.isProxyWebelement(lnkQuickLinks);
	}


	/*
	 * @SCU
	 * #CommonMethodWithArgument: searchSRInCaseSearchUsingFetchSR
	 * #Description: This functionality gets the SR ID from the rescent work,search the SR ID in the case search and clicks the SR
	 * Type: Textbox
	 */
	public boolean searchSRInCaseSearchUsingFetchSR() throws ParseException
	{
System.out.println(DataStore.retrieveData("Home", "SR ID"));
	  utils.waitforpageload();
		if(utils.selectValueFromListbyVisibleString(lnkLinks, "Case Search", "Header", "lnkLinks - Case Search")) {
			blogger.loginfo("String Value is: "+Home.recentSRname);
			blogger.loginfo(DataStore.retrieveData("Home", "SR ID"));
			//if(utils.enterTextinAnelemnt(searchText, Home.recentSRname, "Header", "Case Search Text Box"))
			if(utils.enterTextinAnelemnt(searchText, DataStore.retrieveData("Home", "SR ID"), "Header", "Case Search Text Box"))
				if(clickSearchIcon())
					return clickTheSRID();
		}
		return false;


	}

	@FindBy(xpath="//label[text()='Member Name']/..//*[@data-test-id='201509171111100835311891']")
	WebElement MemberNameValue;

	@FindBy(xpath="//*[text()='Member ID']/..//*[@data-test-id='201509180929400234553780']")
	WebElement MemberIDValue;

	@FindBy(xpath="//*[text()='Age']/..//*[@data-test-id='201509171111100835312438']")
	WebElement MemberAgeValue;

	public boolean MemberDetailsNotPopulated() {
		if(MemberNameValue.getText().equalsIgnoreCase("")
				&& MemberIDValue.getText().equalsIgnoreCase("")
				&& MemberAgeValue.getText().equalsIgnoreCase("")) {
			blogger.loginfo("PASS : Member Details not populated");
			return true;
		}else {
			blogger.loginfo("FAIL : Member Details populated");
			return false;
		}
	}



	@FindBy(xpath="//*[@data-test-id='201509171111100835311891']")
	WebElement ProviderName;

	@FindBy(xpath="//*[@data-test-id='201509180929400234553780']")
	WebElement ProviderID;

	public boolean ProviderDetailsNotPopulated() {
		if(ProviderName.getText().equalsIgnoreCase("")
				&& ProviderID.getText().equalsIgnoreCase(""))
		{
			blogger.loginfo("PASS : Provider Details not populated");
			return true;
		}else {
			blogger.loginfo("FAIL : Provider Details populated");
			return false;
		}
	}     

	@FindBy(id="SearchStringApplicableKeys")
	WebElement drpDownSelectCodeType;

	@FindBy(id="CodeSearch")
	WebElement txtCodeSearch;

	@FindBy(id="CodeorNameName")
	WebElement rdoBtnName;

	@FindBy(id="CodeorNameCode")
	WebElement rdoBtnCode;

	@FindBy(xpath="//img[@name='CPMSearchMyWork_pyDisplayHarness_2']")
	WebElement btnSearch;

	@FindBy(xpath="//table[@pl_prop='D_MasterDrugName.pxResults']")
	WebElement tblSearchResultsOfCode;


	public boolean selectCodeType(String[] codeType)
	{
		return utils.selectDropDownbyVisibleString(this.drpDownSelectCodeType, codeType[0], "Header", "Code Type Dropdown");	
	}


	public boolean selectNameOrCodeRdoBtnAndEnterDetails(String[] args)
	{
		Boolean flag = false;
		if(args[0].contains("Name"))
		{
			try {
				if(utils.clickAnelemnt(this.rdoBtnName, "Header", "Name Rdo Btn"))
					flag = utils.enterTextinAnelemnt(this.txtCodeSearch, args[1], "Header", "Name is Entered");

			} catch (Exception e) {
				System.out.println("Error in clicking in Name Radio Btn and Name is entered");
				err.logError("Header", "Error in clicking in Name Radio Btn and Name is entered");
				flag = false;
			}

		}else if(args[0].contains("Code"))
		{
			try {
				if(utils.clickAnelemnt(this.rdoBtnCode, "Header", "Code Rdo Btn"))
					flag =utils.enterTextinAnelemnt(this.txtCodeSearch, args[1], "Header", "Name is Entered");
			} catch (Exception e) {
				System.out.println("Error in clicking in Code Radio Btn and Name is entered");
				err.logError("Header", "Error in clicking in Code Radio Btn and Name is entered");
				flag = false;
			}
		}
		return flag;
	}

	public boolean clickSearch()
	{
		return utils.clickAnelemnt(this.btnSearch, "Header", "Search");
	}


	public boolean validateTheResultOfSearchResults(String[] tablevalues)
	{
		return utils.validatetablerowbasedonvalues(this.tblSearchResultsOfCode, tablevalues);
	}

	public static String InteractionIDvalue;

	@FindBy(xpath="//*[@data-test-id='20160916102637026797140']")
	WebElement InteractionID;

	public boolean getInteractionIDFromTaskWithoutData() {
		InteractionIDvalue = InteractionID.getText().trim();
		System.out.println("Interaction ID Value is: "+ InteractionIDvalue);
		return !InteractionIDvalue.equalsIgnoreCase("");
	}

	public boolean createNewInteractionPhoneCallBroker() throws InterruptedException
	{
		if(this.clickBroker()){
			if(this.clickLinkPhoneInteraction())
			{
				return true;
			}
			else{
				stepdefinition.isServicedown=true;
				extentmanager.ExtentManager.setTeststatus("Warning-Possible Role Issue");
				err.logcommonMethodError("Header", "createNewInteractionPhoneCallmember");
				return false;
			}
		}	
		return false;
	}

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: clickProfileAndVerifyTheAccessGroup
	 * #Description: Clicks the Profile of the User and then navigates to the Profile Window and verifies the Access Group of the User
	 * #Type: Textbox
	 */
	public boolean clickProfileAndVerifyTheAccessGroupWithData(String[] args) throws InterruptedException
	{
		Boolean flag = false;
		String parent = Driver.pgDriver.getWindowHandle();
		if(utils.clickAnelemnt(this.tabUser, "Header", "User"))
		{
			if(utils.clickAnelemnt(this.tabProfile, "Header", "Profile"))
			{
				Set<String> handles = Driver.pgDriver.getWindowHandles();
				Iterator<String> iterator= handles.iterator();
				String parentWindow = iterator.next();
				String childWindow = iterator.next();
				Driver.pgDriver.switchTo().window(childWindow);
				String title =Driver.pgDriver.getTitle().trim();
				System.out.println("Title: "+title);
				if(title.contains("Operator Profile"))
				{
					Thread.sleep(3000);
					return utils.validateLabel(labelAccessGroupForBroker, args[0]);
				}else
				{
					err.logcommonMethodError("Header", "Error in switching to childwindow - Operator Profile");
					flag = false;
				}
			}
		}
		return flag;
	}

	public boolean verifyMemberNameInHeaderForProviderFlow(String[] args) throws InterruptedException{
		Thread.sleep(3000);
		return utils.validateLabel(MemberNameValue, args[0]);
	}

	public boolean createNewInteractionResearchBroker() throws InterruptedException
	{
		if(this.clickBroker()){
			if(this.clickLinkResearchInteraction())
			{
				return true;
			}
			else{
				stepdefinition.isServicedown=true;
				extentmanager.ExtentManager.setTeststatus("Warning-Possible Role Issue");
				err.logcommonMethodError("Header", "createNewInteractionResearchBroker");
				return false;
			}
		}	
		return false;

	}

	public boolean createNewInteractionSecureMessageMember() throws InterruptedException
	{

		if(this.clickMember()){
			Thread.sleep(1000);
			if(this.clickLinkSecureMessageInteraction())
			{
				Thread.sleep(1000);
				return true;
			}
			else{
				stepdefinition.isServicedown=true;
				extentmanager.ExtentManager.setTeststatus("Warning-Possible Role Issue");
				err.logcommonMethodError("Header", "createNewInteractionResearchBroker");
				return false;
			}
		}	
		return false;

	}

	/**This functionality creates a new Outbound call Interaction on the Solution Central  Application
	 * 
	 * @return
	 */
	public boolean createNewInteractionOutboundcall() {
		if(this.clickMember()){
			utils.waitForElementToBeVisible(lnkOutBoundInteraction);
			return utils.clickAnelemnt(lnkOutBoundInteraction, "Header", "lnkOutBoundInteraction");
		}
		return false;

	}

	@FindBy(xpath="//li[@title='Broker Interaction']")
	WebElement lnkPhoneCallBrokerOption;

	@FindBy(xpath="//li[@title='Research Broker Interaction']")
	WebElement lnkResearchBrokerInteraction;

	@FindBy(xpath="(//td[contains(text(),'BrokerServicesGWG')])[2]")
	WebElement labelWorkGroupBroker;

	@FindBy(xpath="//td[contains(text(),'Broker Services General WB')]")
	WebElement labelWorkBasketBroker;

	public boolean clickProfileAndverifyWorkGroupAndWorkBaskets(String[] args) throws InterruptedException
	{

		Boolean flag = false;
		String parent = Driver.pgDriver.getWindowHandle();
		if(utils.clickAnelemnt(this.tabUser, "Header", "User"))
		{
			if(utils.clickAnelemnt(this.tabProfile, "Header", "Profile"))
			{
				Set<String> handles = Driver.pgDriver.getWindowHandles();
				Iterator<String> iterator= handles.iterator();
				String parentWindow = iterator.next();
				String childWindow = iterator.next();
				Driver.pgDriver.switchTo().window(childWindow);
				String title =Driver.pgDriver.getTitle().trim();
				System.out.println("Title: "+title);
				if(title.contains("Operator Profile"))
				{
					Thread.sleep(3000);
					if(utils.validateLabel(labelWorkGroupBroker, args[0]))
						if(utils.validateLabel(labelWorkBasketBroker, args[1]))
							return true;
				}else
				{
					err.logcommonMethodError("Header", "Error in switching to childwindow - Operator Profile");
					flag = false;
				}
			}
		}
		return flag;

	}


	@FindBy(xpath="//*[contains(text(),'Search for Interactions')]")
	WebElement searchforInteraction;
	public boolean clickSearchforInteractions()
	{
		return utils.clickAnelemnt(searchforInteraction, "Header", "Reference number");
	}

	public boolean navigatetoSearchByReferenceNumber(){
		return utils.selectValueFromListbyVisibleString(lnkLinks, "Search for Interactions", "Header", "lnkLinks");
	}

	public boolean searchInteractionInCaseSearchUsingFetchInteraction()
	{
		if(utils.selectValueFromListbyVisibleString(lnkLinks, "Case Search", "Header", "lnkLinks - Case Search")) {
			blogger.loginfo("String Value is: "+MemberComposite.interactionID);
			if(utils.enterTextinAnelemnt(searchText, MemberComposite.interactionID, "Header", "Case Search Text Box"))
				if(clickSearchIcon())
					return clickTheSRID();
		}
		return false;
	}

	/**
	 * Validate that CSR is able to create broker Email interaction.
	 * @return
	 * @throws InterruptedException
	 */
	public boolean createNewInteractionEmailBroker() throws InterruptedException
	{
		if(this.clickBroker()){
			utils.waitforpageload();
			return this.clickLinkEmailInteraction();
		}
		return false;
	}

	public boolean validateProfile(String[] args) throws InterruptedException {
		String parent = Driver.pgDriver.getWindowHandle();
		System.out.println("Parent Window ID: "+parent);
		if(utils.clickAnelemnt(this.tabUser, "Header", "User"))
			if(utils.clickAnelemnt(this.tabProfile, "Header", "Profile"))
			{
				Thread.sleep(2000);
				Set<String> handles = Driver.pgDriver.getWindowHandles();
				System.out.println("Parent & Child Window ID: "+handles);
				System.out.println("No.ofwindows"+handles.size());
				Iterator<String> iterator= handles.iterator();
				String parentWindow = iterator.next();
				String childWindow = iterator.next();
				String title = Driver.pgDriver.switchTo().window(childWindow).getTitle().trim();
				System.out.println(AccessGroup.getText());
				System.out.println(args[0]);
				System.out.println(WorkGroup.getText());
				System.out.println(args[1]);
				if(utils.validateLabel(AccessGroup, args[0]))
					return utils.validateLabel(WorkGroup, args[1]);
			}
		return false;
	}


	@FindBy(xpath="//a[@data-test-id='2014111304463909631305']")
	WebElement labelContactName;

	/**
	 * Verifies the pre populated Contact Name field with the user input data
	 * @param args
	 * @return
	 */
	public boolean verifyConactNameInInteractionTabLabel(String[] args)
	{
		utils.waitforpageload();
		return utils.validateLabel(labelContactName, args[0]);
	}

	public boolean verifyCaseIconIsPresentInInteractionLabel()
	{
		return !utils.isProxyWebelement(txtSearchBar);
	}

	/**Search SR and Validate the Alert Pop up displayed
	 * 
	 * @return
	 */
	public boolean searchSRInCaseSearchAndValidateAlertPopUp()
	{
		if(utils.selectValueFromListbyVisibleString(lnkLinks, "Case Search", "Header", "lnkLinks - Case Search")) {
			blogger.loginfo("String Value is: "+MemberComposite.SRIDAfterSubstring);
			if(utils.enterTextinAnelemnt(searchText, MemberComposite.SRIDAfterSubstring, "Header", "Case Search Text Box"))
				if(clickSearchIcon())
					if(utils.clickAnelemnt(this.clickSRID, "Header", "SR-ID")) {
						String alerttext = Driver.pgDriver.switchTo().alert().getText();
						if(utils.isvalueMatch_contain(alerttext,"Grievance and Appeals / Payment Dispute"))
							return utils.isAlertPresent(); 
					}
		}
		return false;
	}

	public boolean validateMemberDropDown()
	{
		if(utils.clickAnelemnt(lnkMember, "Header", "lnkMember"))
			return !utils.isProxyWebelement(lnkChatInteraction) && !utils.isProxyWebelement(lnkPhoneCallInteraction) && !utils.isProxyWebelement(lnkResearchInteraction) && !utils.isProxyWebelement(lnkEmailInteraction);
		return false;
				
	}
	
	public boolean validateProviderDropDown()
	{
		if(utils.clickAnelemnt(lnkProvider, "Header", "lnkProvider"))
			return !utils.isProxyWebelement(lnkPhoneCallInteraction) && !utils.isProxyWebelement(lnkResearchInteraction);
		return false;
				
	}
	
	public boolean validateBrokerDropDown()
	{
		if(utils.clickAnelemnt(lnkBroker, "Header", "lnkBroker"))
			return !utils.isProxyWebelement(lnkPhoneCallInteraction) && !utils.isProxyWebelement(lnkResearchInteraction)&& !utils.isProxyWebelement(lnkEmailInteraction);
		return false;
				
	}
	public boolean validateOptionsInLinks()
	{
		if(utils.clickAnelemnt(lnkLinks, "Header", "lnkLinks"))
			return !utils.isProxyWebelement(lnkHeaderLookupCode) && !utils.isProxyWebelement(lnkHeaderBrowseBenefits)&& !utils.isProxyWebelement(lnkHeaderCaseSearch)&& !utils.isProxyWebelement(lnkHeaderMedicalPolicies)&& !utils.isProxyWebelement(lnkHeaderProviderLinks)&& !utils.isProxyWebelement(lnkHeaderSearchForInteractions)&& !utils.isProxyWebelement(lnkHeaderViewServiceIntents);
		return false;
				
	}
	
	
	public boolean createNewInteractionEmailMember() {
		if(this.clickMember()){
			utils.waitforpageload();
			return this.clickLinkEmailInteraction();
		}
		return false;	
	}
	
		
	/**
	 * Verifies whether that Broker is changed to Broker Services
	 */
	
	@FindBy(xpath="//a[text()='Broker Services ']")
	WebElement lnkBrokerServices;
	
	public boolean verifyBrokerIsChangedToBrokerServices()
	{
		return !utils.isProxyWebelement(lnkBrokerServices);
	}
}


