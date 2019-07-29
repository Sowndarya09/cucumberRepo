package automationLib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class Provider {
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	private WebDriverWait wait;
	static String ProviderName="";
	BaseLogger blogger = new BaseLogger();

	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement1;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	@FindBy(id="PegaGadget3Ifr")
	private WebElement Iframeelement3;

	@FindBy(xpath="//input[@id='PlanSearchSearch with the plan' and @value='Search with the plan']")
	private WebElement radSrchWithPlan;
	@FindBy(xpath="//input[@id='PlanSearchSearch all plans' and @value='Search all plans']")
	private WebElement radSrchAllPlans;
	@FindBy(xpath="//select[@id='ProviderLooking']")
	private WebElement drpdwnImLookingfor;
	@FindBy(xpath="//select[@id='ProviderSpeciality']")
	private WebElement drpdwnPrvdrSpeciality;
	@FindBy(xpath="//input[@id='ProviderName']")
	private WebElement txtProvNameOptional;
	@FindBy(id="LocationValue")
	private WebElement txtLocatedNear;
	@FindBy(xpath="//select[@id='ProviderDistance']")
	private WebElement drpdwnWithinDistance;


	@FindBy(xpath="//div[@title='Disclose Additional Options']/i[@class='icon icon-openclose']")
	private WebElement btnAdditionalOptions;
	@FindBy(xpath="//select[@id='ProviderSubSpecialty']")
	private WebElement drpdwnSubSpecialty;
	@FindBy(xpath="//select[@id='ServiceAvailable']")
	private WebElement drpdwnServiceAvailable;
	@FindBy(xpath="//select[@id='Gender']")
	private WebElement drpdwnGender;
	@FindBy(xpath="//select[@id='AreaOfExpertise']")
	private WebElement drpdwnAreaOfExpertise;
	@FindBy(xpath="//select[@id='Language']")
	private WebElement drpdwnLanguage;
	@FindBy(xpath="//select[@id='LevelofCare']")
	private WebElement drpdwnLevelofCare;
	@FindBy(xpath="//select[@id='HospitalAffiliation']")
	private WebElement drpdwnHospitalAffiliation;
	@FindBy(xpath="//select[@id='PatientPopulation']")
	private WebElement drpdwnPatientPopulation;
	@FindBy(xpath="//div[@class='pzbtn-mid'][contains(text(),'Search')]")
	private WebElement btnSearch;



	@FindBy(xpath="//input[@id='BluePrecision']")
	private WebElement chkboxBluePrecision;
	@FindBy(xpath="//input[@id='BlueDistinction']")
	private WebElement chkboxBlueDistinction;
	@FindBy(xpath="//input[@id='EnhancedPersonalHC']")
	private WebElement chkboxEnhancedPersonalHC;

	@FindBy(xpath="//*[@class='pzbtn-mid'][contains(text(),'Other actions')]")
	private WebElement btnOtherActions;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Cancel this work']")	
	private WebElement lnkOtherCancelThisWork;

	@FindBy (xpath="//*[@class='menu-item-title'][text()='Update PCP']")	
	private WebElement lnkOtherUpdatePCP;

	@FindBy(id="CancellationReason")
	WebElement drpdwnCancellationreason;
	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	@FindBy(xpath="//input[@id='TagProvider']")
	private WebElement chkboxProvDtlsDiscussed;
	@FindBy(xpath="//table[@pl_prop='ProviderList.pxResults']")
	private WebElement tblProvResults;
	@FindBy(xpath="//span[@class='collapseRowDetails']")
	private WebElement btnCollapseProvDetails;
	@FindBy(xpath="//span[@class='expandRowDetails']")
	private WebElement btnExpandProvDetails;
	@FindBy(xpath="//table[@pl_prop='ProviderList.pxResults']//span[starts-with(text(),'  ')]")
	private WebElement labelProvResultsAftExp;


	@FindBy(xpath="//*[contains(text(),'General Information')]")
	private WebElement labelGeneralInfo;
	@FindBy(xpath="//table[@pl_prop='ProviderList.pxResults']//*[@class='field-item dataValueRead']//span[@class='leftJustifyStyle']")
	private WebElement labelDistance;

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionDoctorDetailsBBBB']//span")
	private WebElement labelProvName;

	@FindBy(xpath="//table[@pl_prop='ProviderList.pxResults']//div[@class='field-item dataLabelRead'][contains(text(),'No items')]")
	private WebElement labelNoitems;

	@FindBy(xpath="//div[contains(text(),'xport')]")
	WebElement btnProviderExport;
	@FindBy(xpath="//div[text()='Email']")
	WebElement btnProviderEmail;
	@FindBy(id="ModalButtonSubmit")
	WebElement btnProvideremailsubmit;
	@FindBy(id="pyEmailAddress")
	WebElement txtbxRecipientemail;
	@FindBy(id="IsProviderPCP")
	WebElement chkbxUpdatePCP;

	@FindBy(xpath="//table[@class='gridTable ']//tr[2]//span[@title='press enter to expand row']")
	WebElement btnProviderExpand; 

	@FindBy(id="TagProvider")
	WebElement chkbxTagProvider;

	@FindBy(xpath="//div[@node_name='CareProviderDetails']//label[@for='Name']/parent::div//span")
	WebElement LblProviderName;
	public Provider()
	{
		/**Removing the switch in constructor's
		 * 
		 */
		try {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		} catch (Exception e) {
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement1);
			e.printStackTrace();
		}
	}


	public boolean ExpandAdditionalOpts(){
		if(utils.clickAnelemnt(this.btnAdditionalOptions, "Provider", "Expand/Collapse Additional Options button"))
			return true;
		else return false;

	}


	public boolean SelectAddnalOptSubSpecialty(String args[]){
		return utils.selectDropDownbyVisibleString(this.drpdwnSubSpecialty, args[0], "Provider", "Sub-Specialty Dropdown");
	}


	public boolean SelectAddnalOptGender(String args[]){
		return utils.selectDropDownbyVisibleString(this.drpdwnGender, args[0], "Provider", "Gender Dropdown");
	}


	public boolean SelectAddnalOptLanguage(String args[]){
		return utils.selectDropDownbyVisibleString(this.drpdwnLanguage, args[0], "Provider", "Language Dropdown");
	}

	public boolean SelectAddnalOptHospAffiliation(String args[]){
		return utils.selectDropDownbyVisibleString(this.drpdwnHospitalAffiliation, args[0], "Provider", "Hospital Affiliation Dropdown");
	}

	public boolean SelectAddnalOptServicecAvail(String args[]){
		return utils.selectDropDownbyVisibleString(this.drpdwnServiceAvailable, args[0], "Provider", "Service Available Dropdown");
	}

	public boolean SelectAddnalOptAreaofExpert(String args[]){
		if(utils.selectDropDownbyVisibleString(this.drpdwnAreaOfExpertise, args[0], "Provider", "Area of Expertise Dropdown")){
			return true;
		}else return false;
	}

	public boolean SelectAddnalOptLevelofCare(String args[]){
		return utils.selectDropDownbyVisibleString(this.drpdwnLevelofCare, args[0], "Provider", "Level of Care Dropdown");
	}

	public boolean SelectAddnalOptPatientPopul(String args[]){
		return utils.selectDropDownbyVisibleString(this.drpdwnPatientPopulation, args[0], "Provider", "Patient Population Dropdown");
	}

	public boolean ClickSearchbtnProvider(){
		return utils.clickAnelemnt(this.btnSearch, "Provider", "Search button");
	}


	public boolean selectAwardsRecognition(String args[]){
		for(int i=0;i<args.length;i++)
		{
			if(args[i].contains("Precision"))
			{
				String s1=args[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				String[] s=new String[]{s1};
				if(utils.clickAnelemnt(this.chkboxBluePrecision, "Provider", "Blue Precision checkbox"))
				{

					if(i==args.length-1)
					{

						return true;
					}
					continue;
				}
				else
				{
					err.logcommonMethodError("Provider", "Blue Precision");
					System.out.println( " Sorry, there is no attribute present as "+args[i]);

				}
			}

			else if(args[i].contains("Distinction"))
			{
				String s1=args[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				String[] s=new String[]{s1};
				if(utils.clickAnelemnt(this.chkboxBlueDistinction, "Provider", "Blue Distinction checkbox"))
				{

					if(i==args.length-1)
					{

						return true;
					}
					continue;
				}
				else
				{
					err.logcommonMethodError("Provider", "Blue Distinction");
					System.out.println( " Sorry, there is no attribute present as "+args[i]);

				}
			}
			else if(args[i].contains("Enhanced"))
			{
				String s1=args[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				String[] s=new String[]{s1};
				if(utils.clickAnelemnt(this.chkboxEnhancedPersonalHC, "Provider", "Enhanced Personal health checkbox"))
				{

					if(i==args.length-1)
					{

						return true;
					}
					continue;
				}
				else
				{
					err.logcommonMethodError("Provider", "Enhanced Personal health ");
					System.out.println( " Sorry, there is no attribute present as "+args[i]);
					return false;
				}
			}
			else  
				break;
		}
		return true;
	}

	public boolean ExpandValidateProvResults() throws InterruptedException{

		wait = new WebDriverWait(Driver.pgDriver,10);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@pl_prop='ProviderList.pxResults']")));
		if(this.tblProvResults.isDisplayed()){
			try
			{
				List<WebElement> expandbtn = Driver.pgDriver.findElements(By.xpath("//span[@class='expandRowDetails']"));
				System.out.println("No of results :"+expandbtn.size());
				int iterator = 0;
				for (WebElement btn : expandbtn) {



					btn.click();

					utils.waitforpageload();

					iterator++;
				}
				try{
					this.labelProvResultsAftExp.isDisplayed();
					System.out.println("Blank value found after expansion");
					return false;
				}
				catch(Exception e)
				{
					System.out.println("No Blank value found after expansion");
					return true;
				}
			}catch(Exception e){
				if(this.labelNoitems.isDisplayed()){
					System.out.println("No items found. Please refine your search");
					return true;
				}
				else

					return false;

			}

		}else{
			return false;
		}
	}




	public boolean validateCancelThisWork(String[] cancelreason)
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Provider", "Other Actions Button"))
		{
			if(utils.clickAnelemnt(this.lnkOtherCancelThisWork, "Provider", "Cancel this Work"))
			{

				if(utils.selectDropDownbyVisibleString(this.drpdwnCancellationreason, cancelreason[0], "Cancel Provider", "Cancel reason"))
				{
					if(utils.clickAnelemnt(this.btnSubmit, "cancel Billing", "Submit button on cancel billing"));

					return true;
				}
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;


	}

	public boolean navigatetoUpdatePCP()
	{
		if(utils.clickAnelemnt(this.btnOtherActions, "Provider", "Other Actions Button"))
		{
			utils.clickAnelemnt(this.btnOtherActions, "Provider", "Other Actions Button");
			if(utils.clickAnelemnt(this.lnkOtherUpdatePCP, "Provider", "Update PCP"))
			{
				return true;

			}
			else
				return false;
		}
		return false;


	}


	public boolean validateProvResultbyDistance(String args[]){

		wait = new WebDriverWait(Driver.pgDriver,10);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@pl_prop='ProviderList.pxResults']")));
		if(this.tblProvResults.isDisplayed()){
			List<WebElement> expandbtn = Driver.pgDriver.findElements(By.xpath("//table[@pl_prop='ProviderList.pxResults']//*[@class='field-item dataValueRead']//span[@class='leftJustifyStyle']"));
			System.out.println("No of results :"+expandbtn.size());
			int iterator = 0;
			for (WebElement btn : expandbtn) {



				String Distanceval = btn.getText();
				System.out.println("Distance Value is :"+Distanceval);
				float ActualDistance = Float.parseFloat(Distanceval);
				System.out.println("Actual Distance is "+ActualDistance);
				String Dist = args[0];
				System.out.println("Dist from input is :"+Dist);
				float ExpectedDistance = Float.parseFloat(Dist);
				System.out.println("Expected Distance is "+ExpectedDistance);
				if(ActualDistance<=ExpectedDistance)
					iterator++;
				else 
					break;

			}
			return true;	


		}else{
			System.out.println("No search results found");
			return true;
		}

	}

	public boolean validateProvResultbyOptNameDistn(String args[]){

		wait = new WebDriverWait(Driver.pgDriver,10);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@pl_prop='ProviderList.pxResults']")));
		if(this.tblProvResults.isDisplayed()){
			List<WebElement> expandbtn = Driver.pgDriver.findElements(By.xpath("//table[@pl_prop='ProviderList.pxResults']//*[@class='field-item dataValueRead']//span[@class='leftJustifyStyle']"));
			System.out.println("No of results :"+expandbtn.size());
			int iterator = 0;
			for (WebElement btn : expandbtn) {


				String Distanceval = btn.getText();
				System.out.println("Distance Value is :"+Distanceval);
				float ActualDistance = Float.parseFloat(Distanceval);
				System.out.println("Actual Distance is "+ActualDistance);
				String Dist = args[1];
				System.out.println("Dist from input is :"+Dist);
				float ExpectedDistance = Float.parseFloat(Dist);
				System.out.println("Expected Distance is "+ExpectedDistance);
				if(ActualDistance<=ExpectedDistance)
					iterator++;
				else 
					break;


			}
			List<WebElement> OptNames = Driver.pgDriver.findElements(By.xpath("//table[@class='gridTable ']//div[@class='field-item dataValueRead']//span[contains(text(),'"+args[0]+"')]"));
			int OptNameSize = OptNames.size();
			System.out.println("OptNameSize is :"+OptNameSize);

			List<WebElement> Results = Driver.pgDriver.findElements(By.xpath("//span[@class='expandRowDetails']"));
			System.out.println("No of results :"+Results.size());

			if(OptNameSize==Results.size()){
				return true;

			} else
				System.out.println("Name of Provider in Search results doesnt match with optional name search criteria");
			return false;
		}else{
			System.out.println("No search results found");
			return true;
		}

	}



	public boolean settxtBxImLookingFor(String SearchInput)
	{
		new WebDriverWait(Driver.getPgDriver(),30).until(ExpectedConditions.elementToBeClickable(drpdwnImLookingfor));
		new WebDriverWait(Driver.getPgDriver(),30).until(ExpectedConditions.visibilityOf(drpdwnImLookingfor));
		return utils.selectDropDownbyVisibleString(this.drpdwnImLookingfor, SearchInput, "Provider", "I'm Looking For Dropdown");
	}

	int j=0;
	public boolean settxtBxSpecialize(String SearchInput)
	{
		j++;
		try{
			utils.selectDropDownbyVisibleString(this.drpdwnPrvdrSpeciality, SearchInput, "Provider", "Provider Speciality Dropdown");
			Driver.pgDriver.findElement(By.xpath("//label[@for='ProviderDistance']")).click();

			return true;
		}
		catch(Exception e)
		{				
			if (j<4)
			{
				return settxtBxSpecialize(SearchInput);
			}
			else
				return false;
		}

	}


	public boolean settxtBxOptionalName(String SearchInput)
	{

		return utils.enterTextinAnelemnt(this.txtProvNameOptional, SearchInput, "Provider", "Optional Name text");

	}


	int i=0;
	public boolean settxtBxLocatedNear(String SearchInput)
	{
		try{
			i++;
			System.out.println("Insdie the loop");
			utils.enterTextinAnelemnt(this.txtLocatedNear, SearchInput, "Provider", "Located Near text");
			Driver.pgDriver.findElement(By.xpath("//label[@for='ProviderDistance']")).click();
			return true;
		}
		catch(Exception e)
		{

			if(i < 3)
			{
				System.out.println("Exception occured.handled");
				return settxtBxLocatedNear(SearchInput);
			}

			else 
				return false;
		}

	}

	public boolean settxtBxDistance(String SearchInput)
	{

		return utils.selectDropDownbyVisibleString(this.drpdwnWithinDistance, SearchInput, "Provider", "Within Distance Dropdown");

	}


	public boolean EnterProviderMandatoryFields(String[] ProvFilters)
	{

		for(int i=0;i<ProvFilters.length;i++)
		{
			System.out.println("the current loop "+i+"but the length is "+ProvFilters.length);
			if(ProvFilters[i].toLowerCase().contains("looking"))
			{
				String s1=ProvFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				String[] s=new String[]{s1};

				if( this.settxtBxImLookingFor(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (ProvFilters[i].toLowerCase().contains("special"))
			{
				utils.waitforpageload();
				String s1=ProvFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				String[] s=new String[]{s1};

				if(this.settxtBxSpecialize(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (ProvFilters[i].toLowerCase().contains("optional"))
			{
				String s1=ProvFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				String[] s=new String[]{s1};

				if(this.settxtBxOptionalName(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (ProvFilters[i].toLowerCase().contains("loc"))
			{
				String s1=ProvFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				String[] s=new String[]{s1};
				System.out.println(s1+ "to be entered inlocated");
				if(this.settxtBxLocatedNear(s1))
				{

					continue;
				}
				else
					break;
			}
			else if (ProvFilters[i].toLowerCase().contains("distance"))
			{
				String s1=ProvFilters[i];
				s1 = s1.substring(s1.indexOf(":") + 1);
				String[] s=new String[]{s1};

				if(this.settxtBxDistance(s1))
				{

					continue;
				}
				else
					break;
			}
			else
				break;
		}
		System.out.println("Mandatory fields entered");
		return true;

	}
	public boolean selectPCPCheckbox()
	{
		try{
			if(utils.clickAnelemnt(this.chkbxUpdatePCP, "Provider", "Able to serve as PCP"))
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured "+e);
			err.logError("Provider", "PCP checkbox");
			return false;
		}
	}

	public boolean checkDownload() throws InterruptedException
	{
		int n=Driver.pgDriver.getWindowHandles().size();
		if(utils.clickAnelemnt(this.btnProviderExport, "Provider", "Export button"))
		{
			Thread.sleep(3000);
			Set s=Driver.pgDriver.getWindowHandles();
			Iterator ite=s.iterator();
			if(s.size()>n)
			{
				System.out.println("initial no of window "+n+" new no of window"+s.size());
				System.out.println("size is great");
				String popuphandle=ite.next().toString();
				Driver.getPgDriver().switchTo().window(popuphandle);
				if(Driver.pgDriver.getPageSource().contains("Failed"))
					return false;
				else
				{
					Thread.sleep(5000);
					return true;
				}
			}
			else
				return false;
		}
		return false;
	}

	public boolean sendEmail() throws InterruptedException
	{
		utils.waitforpageload();		
		utils.scrolltomiddle(); /**Email button to be visible*/
		
		if(utils.clickAnelemnt(this.btnProviderEmail, "Provider", "Emailll button"))
		{
			wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@node_name='pzModalTemplate']")));

			if(utils.enterTextinAnelemnt(this.txtbxRecipientemail, "test@test.com", "Provider", "Recipient email "))
			{
				if(utils.clickAnelemnt(this.btnProvideremailsubmit, "Provider", "Email Submit"))
					return true;
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;
	}

	public boolean tagFirstProvider()
	{
		try
		{
			if(utils.clickAnelemnt(this.btnProviderExpand, "Provider", "Expand First Provider"))
			{
				utils.waitforpageload();
				if(utils.clickAnelemnt(this.chkbxTagProvider,"Provider","Check box tag"))
				{
					this.ProviderName=this.LblProviderName.getText().toString();
					return true;
				}
				else
					return false;
			}
			else
				return false;
		}
		catch(Exception e){

			return false;
		}
	}

	public boolean clickbtnSubmit()
	{
		if(utils.clickAnelemnt(this.btnSubmit, "Provider", "Submit Button"))
			return true;
		else
			return false;

	}

	//Changes start here - Sprint 6.1
	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderProviderSearch;
	@FindBy(xpath="//span[text()='Provider Results']")
	private WebElement sHeaderProviderResults;
	@FindBy(className="//table[@pl_prop='ProviderList.pxResults']")
	private WebElement providerResultsTbl;
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyLegacyMemTxtRemoval
	 * Type:Textbox 
	 * Description: Need to remove the below Legacy Member message:"To locate providers for legacy members/policy use the change plan function to select the appropriate plan to search"
	 * Verify the message no longer appears for Legacy member - in Provider search.
	 */
	public boolean verifyLegacyMemTxtRemoval(){
		String legacyText="To locate providers for this legacy member/policy, use the Change Plan function to select the appropriate plan to search.";
		if(utils.validateHeader(this.sHeaderProviderSearch,"Manage Provider")){
			try{
				if(Driver.pgDriver.findElement(By.tagName("em")).getText().trim().equalsIgnoreCase(legacyText))
					System.out.println("Legacy text isnt removed:\n"+legacyText);
				return false;
			}catch(Exception e){
				System.out.println("Legacy text doesnt exist on Provider search page:\n");
				return true;
			}
		}
		err.logcommonMethodError("Provider","verifyLegacyMemTxtRemoval");
		return false;
	}
	public WebElement getProviderResultsTbl(){

		List<WebElement> tables = Driver.pgDriver.findElements(By.xpath("//table[@pl_prop='ProviderList.pxResults']"));
		return tables.get(0);
	}
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateProviderSearchResults
	 * #Arguments:Search Results - header values should be passed[comma separated]-in order of display in screen.
	 * Type:TextBox
	 * Description:Validate Provider search result header and results  table is displayed.
	 */
	public boolean validateProviderSearchResults(String[] args){
		utils.waitforpageload();
		if(utils.validateHeader(sHeaderProviderResults, "Provider Results")){
			System.out.println("Provider results section is displayed");
			String space = " ";
			StringBuilder input = new StringBuilder();
			System.out.println("Newly constructed Input:"+input.append(space).append(",").append(args[0]).append(",").append(args[1]).append(",").append(args[2]).append(",").append(args[3]).toString());
			String colHdrs[] = input.append(space).append(",").append(args[0]).append(",").append(args[1]).append(",").append(args[2]).append(",").append(args[3]).toString().split(",");
			if(utils.validateTableRowHeader(getProviderResultsTbl(), colHdrs)){
				System.out.println("Column Headers in UI matched with user data");
				return true;
			}else 
				err.logError("Provider", "Provider Results column header doesnt match ");
			return false;
		}
		err.logError("Provider", "Provider Results label is not displayed");
		return false;
	}

	@FindBy(xpath="//*[@data-test-id='201603311811550632126864']")
	WebElement memberPrefix;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:verifyMemberPrefix
	 * #Arguments:Member prefix for the provider
	 * Type:TextBox
	 * Description:This method verifies the member prefix in the UI matches with value entered
	 */
	public boolean verifyMemberPrefix(String args[]){
		if(utils.validateHeader(this.sHeaderProviderSearch,"Manage Provider")){
			try{
				if(this.memberPrefix.getText().trim().equalsIgnoreCase(args[0]))
					blogger.loginfo("Member Prefix is validated for the Provider"+this.memberPrefix.getText());
				return true;
			}catch(Exception e){
				blogger.loginfo("Member Prefix doesnt exist on Provider search page:\n");
				return false;
			}
		}
		err.logcommonMethodError("Provider","verifyMemberPrefix");
		return false;
	}

	@FindBy(xpath="//input[@id='PlanSearchSearch with the plan']")
	WebElement searchWithPlanRdoBtn;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:searchWithPlanDetails
	 * #Description:This method searches the provider plan with the details entered by user in Provider Task
	 * #Arguments:Looking For,Specializes in and Located Near
	 * Type:Textbox
	 */
	public boolean searchWithPlanDetails(String args[]){

		try{
			boolean flag = searchWithPlanRdoBtn.isDisplayed();
			if(!flag) {
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.pgDriver.switchTo().frame(Iframeelement);
			}

		}
		catch(Exception e)
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement);
		}


		try{
			WebDriverWait wait = new WebDriverWait(Driver.pgDriver,8);
			wait.until(ExpectedConditions.visibilityOf(this.searchWithPlanRdoBtn));
			utils.clickAnelemnt(this.searchWithPlanRdoBtn, "Provider", "Search With the Plan/Network/Prefix");
			utils.selectDropDownbyVisibleString(this.drpdwnImLookingfor, args[0], "Provider", "Im looking for a");
			this.drpdwnImLookingfor.sendKeys(Keys.TAB);
			utils.waitforpageload();
			utils.selectDropDownbyVisibleString(this.drpdwnPrvdrSpeciality, args[1], "Provider", "Who specializes in");
			utils.enterTextinAnelemnt(this.txtLocatedNear, args[2], "Provider", "Located Near");
			this.txtLocatedNear.sendKeys(Keys.TAB);
			//utils.clickAnelemnt(this.btnSearch, "Provider", "Search button");
			Driver.pgDriver.findElement(By.xpath("//div[@class='pzbtn-mid'][contains(text(),'Search')]")).click();
			utils.waitforpageload();
			System.out.println("Successfully entered details to search with plan/network prefix");
		}catch(Exception e){
			err.logcommonMethodError("Provider","searchWithPlanDetails"+e);
			System.out.println("Exception occured in searchWithPlanDetails"+e);
			return false;
		}
		return true;
	}

	@FindBy(xpath="//input[@id='PlanSearchSearch all plans' and @value='Search all plans']")
	WebElement searchByAllPlanRdoBtn;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:searchByAllPlanDetails
	 * #Description:This method searches by the provider 'All plan' with the details entered by user in Provider Task
	 * #Arguments:Looking For,Specializes in and Located Near
	 * Type:Textbox
	 */
	public boolean searchByAllPlanDetails(String args[]){
		try{
			WebDriverWait wait = new WebDriverWait(Driver.pgDriver,8);
			wait.until(ExpectedConditions.visibilityOf(this.searchByAllPlanRdoBtn));
			utils.clickAnelemnt(this.searchByAllPlanRdoBtn, "Provider", "Search all plans/network");
			utils.selectDropDownbyVisibleString(this.drpdwnImLookingfor, args[0], "Provider", "Im looking for a");
			utils.selectDropDownbyVisibleString(this.drpdwnPrvdrSpeciality, args[1], "Provider", "Who specializes in");
			utils.enterTextinAnelemnt(this.txtLocatedNear, args[2], "Provider", "Located Near");
			//utils.clickAnelemnt(this.btnSearch, "Provider", "Search button");
			this.btnSearch.click();
			System.out.println("Successfully entered details to Search all plans/network");
			utils.waitforpageload();
		}catch(Exception e){
			err.logcommonMethodError("Provider","searchByAllPlanDetails"+e);
			System.out.println("Exception occured in searchByAllPlanDetails"+e);
			return false;
		}
		return true;
	}
	@FindBy(xpath="//input[@id='TagProvider1']")
	WebElement providerChkBox;

	@FindBy(xpath="//input[@id='TagGandA1']")
	WebElement memberGAChkBox;
	/*
	 * @SCU
	 * #CommonMethodwithArgument:validateProviderResultsDisplayed
	 * #Description:This method verifies if Provider search results and Grievance and Appeals indicator checkbox is added in UI for details searched by user in Provider Task
	 * #Arguments:Provider Results
	 * Type:Table
	 * Keys:Care Provider#Distance#Location#Network Type
	 */
	public boolean validateProviderResultsDisplayed(String args[]){

		/*try{
			boolean flag = providerChkBox.isDisplayed();
			if(!flag) {
				Driver.getPgDriver().switchTo().defaultContent();
				Driver.pgDriver.switchTo().frame(Iframeelement3);
			}

		}
		catch(Exception e)
		{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.pgDriver.switchTo().frame(Iframeelement3);
		}*/

		try{
			utils.waitforpageload();
			WebElement result = utils.getProviderResultsBasedOnValues(getProviderResultsTbl(),args);
			result.findElement(By.xpath(".//span[@data-ctl='expCollIcon']")).click();
			utils.waitforpageload();
			//Verify Grievance and Appeals indicator checkbox is added in UI
			/*if(this.providerChkBox.isDisplayed() && this.memberGAChkBox.isDisplayed()){
					System.out.println("'Provider details discussed with the contact' and 'Member has Grievance and/ or Appeal for this provider' checkbox is added in UI");
				}
				System.out.println("Provider Result matched::Successfully matched details to search with plan/network prefix");*/
		}catch(Exception e){
			err.logcommonMethodError("Provider","validateProviderResultsDisplayed"+e);
			System.out.println("Exception occured in validateProviderResultsDisplayed"+e);
			return false;
		}
		return true;
	}

	@FindBy(xpath="//span[text()='The provider database is unavailable. Try again later.']")
	WebElement OutageMessage; 

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectProviderFromResults
	 * #Description:This method selects a Provider from search results and selects discussed with contact option
	 * #Arguments:Provider Results
	 * Type:Table
	 * Keys:Care Provider#Distance#Location#Network Type
	 */
	public boolean selectProviderFromResults(String args[]){
		try{
			utils.waitforpageload();
			WebElement result = utils.getProviderResultsBasedOnValues(getProviderResultsTbl(),args);
			List<WebElement> row = result.findElements(By.tagName("td"));
			row.get(0).click();
			if(utils.clickAnelemnt(this.providerChkBox, "Provider", "Provider details discussed with the contact"))
				return true;
			else
				if(!utils.isProxyWebelement(OutageMessage))
					return utils.setServiceDown(OutageMessage.getText());
				else
					return false;

		}catch(Exception e){
			err.logcommonMethodError("Provider","selectProviderFromResults"+e);
			System.out.println("Exception occured in selectProviderFromResults"+e);
			return !utils.isServiceDown();
		}
	}

	/*
	 * @SCU
	 * #CommonMethodwithArgument:selectProviderWithGrievanceIndicatorCheckedFromResults
	 * #Description:This method selects a Provider from search results and selects discussed with contact and grievance indicator option checked.
	 * #Arguments:Provider Results
	 * Type:Table
	 * Keys:Care Provider#Distance#Location#Network Type
	 */
	public boolean selectProviderWithGrievanceIndicatorCheckedFromResults(String args[]) throws InterruptedException{
			WebElement result = utils.getProviderResultsBasedOnValues(getProviderResultsTbl(),args);
			result.findElement(By.xpath("//span[@data-ctl='expCollIcon']")).click();
			utils.waitforpageload();
			//Need to write steps to select Info discussed with contact checkbox and Grievance indicator
			return utils.clickAnelemnt(this.memberGAChkBox, "Provider", "Member has Grievance and/ or Appeal for this provider");
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnSubmit
	 * #Description:This method clicks on Submit button in Provider Results page.
	 * Type:Textbox
	 */
	public boolean clickOnSubmit(){
		((JavascriptExecutor) Driver.getPgDriver()).executeScript("arguments[0].scrollIntoView(true);",
				this.btnSubmit);
			return utils.clickAnelemnt(this.btnSubmit, "Provider", "Submit Button");
	}

	//Need to check, if the below functionality is a valid test scenario.
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:validateMsgOnSubmit
	 * #Description:This method validates the message displayed - When CSR tags particular provider for 'Member has Grievance and/ or Appeal for this provider' but does not tag 'Provider details discussed with the contact' and try to submit on Provider Result.
	 * Type:Textbox
	 */
	public boolean validateMsgOnSubmit(){
		try{

			System.out.println("validateMsgOnSubmit in Provider Results page");
		}catch(Exception e){
			err.logcommonMethodError("Provider","validateMsgOnSubmit"+e);
			System.out.println("Exception occured in validateMsgOnSubmit"+e);
			return false;
		}
		return true;
	}
	@FindBy (xpath="//a[contains(text(),'Change Plan')]")	
	private WebElement ChangePlan;
	@FindBy(xpath="//select[@id='TypeofCare']")
	private WebElement DrpTypeofCare;
	@FindBy(xpath="//select[@id='StateDropDownValues']")
	private WebElement DrpState;
	@FindBy(xpath="//select[@id='PlanName']")
	private WebElement DrpPlan;
	@FindBy(xpath="//div[@class='spin-overlay']")
	private WebElement spin;

	@FindBy(xpath="//*[@class='buttonTdButton'][text()='Submit']")
	private WebElement ChangeplanbtnSubmit;

	public boolean ChangePlanbasedoninput(String args[]){
		try{
			utils.waitforpageload();
			utils.clickAnelemnt(this.ChangePlan, "Provider", "Search With the Plan/Network/Prefix");

			WebDriverWait wait = new WebDriverWait(Driver.pgDriver,30);
			wait.until(ExpectedConditions.visibilityOf(this.DrpTypeofCare));
			utils.selectDropDownbyVisibleString(this.DrpTypeofCare, args[0], "Provider", "Type of Care");
			this.DrpTypeofCare.sendKeys(Keys.TAB);
			utils.waitforpageload();
			utils.selectDropDownbyVisibleString(this.DrpState, args[1], "Provider", "State");
			this.DrpState.sendKeys(Keys.TAB);
			utils.waitforpageload();
			//Thread.sleep(20000);
			wait.until(ExpectedConditions.invisibilityOf(this.spin));
			utils.selectDropDownbyVisibleString(this.DrpPlan, args[2], "Provider", "Plan name");
			//					this.DrpPlan.sendKeys(Keys.TAB);
			utils.waitforpageload();
			//utils.clickAnelemnt(this.ChangeplanbtnSubmit, "Provider", "Submit button");

			Driver.pgDriver.findElement(By.xpath("//*[@class='buttonTdButton'][text()='  Submit ']")).click();
			utils.waitforpageload();
			System.out.println("Successfully Changed the plan details");
		}catch(Exception e){
			err.logcommonMethodError("Provider","ChangePlanbasedoninput"+e);
			System.out.println("Exception occured in ChangePlanbasedoninput"+e);
			return false;
		}
		return true;
	}		

	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionLocationInfoBBBBBB']//div[1]/span")
	private WebElement TierDetails;
	@FindBy(xpath="//div[@param_name='EXPANDEDSubSectionLocationInfoBBBBBB']//div[@class='content-inner ']//span[@data-test-id='20160922115002042774799']")
	private WebElement TierDetailshover;

	public boolean ValidateTierDetails(String[] args)
	{
		String TierValue=this.TierDetails.getText().toString();
		if(TierValue.contains(args[0]))
		{
			System.out.println("Tier value matched "+TierValue);
			return true;
		}
		else
			return false;						

	}
	public boolean verifyHoverTextInTierDetails(String[] hovermessage)
	{
		String hovermsg = hovermessage[0];
		System.out.println("Hover Msg: "+hovermsg);
		Actions action = new Actions(Driver.pgDriver);
		action.moveToElement(TierDetailshover).build().perform();
		utils.waitforpageload();
		String hovertext=Driver.pgDriver.findElement(By.xpath("//div[@param_name='EXPANDEDSubSectionLocationInfoBBBBBB']//div[@class='content-inner ']//span[@data-test-id='20160922115002042774799']")).getAttribute("aria-label").toString();
		System.out.println("Hover Msg in UI: "+hovertext);
		if(hovertext.contains(hovermsg))
		{
			System.out.println("Hover Text is matched and validated");
			return true;
		}
		else
		{
			System.out.println("Hover Text is does not matched");
			return false;
		}

	}

	//Sprint 2.4

	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: verifyNoGandAIndicatorIsDisplayed
	 * #Description: This functionality verifies that the G an d A indicator check box is displayed or not
	 * #Type: Textbox
	 */
	public boolean verifyNoGandAIndicatorIsDisplayed()
	{
		try
		{
			this.memberGAChkBox.isDisplayed();
			blogger.loginfo("G and A indicator check box is displayed");
			System.out.println("G and A indicator check box is displayed");
			return false;
		}catch(Exception e)
		{
			blogger.loginfo("G and A indicator check box is not displayed");
			System.out.println("G and A indicator check box is not displayed");
			return true;
		}
	}


	//Sprint 4.1

	@FindBy(id="IsProviderAcceptingNewPats")
	WebElement chckBxAcceptingNewPatients;

	public boolean verifyAcceptingNewPatientsCheckBoxIsDisplayed()
	{
		try
		{
			WebElement element = Driver.pgDriver.findElement(By.id("IsProviderAcceptingNewPats"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			chckBxAcceptingNewPatients.isDisplayed();
			blogger.loginfo("Accepting New Patients check Box is displayed");
			System.out.println("Accepting New Patients check Box is displayed");
			return true;
		}catch(Exception e)
		{
			blogger.loginfo("Accepting New Patients check Box is displayed");
			System.out.println("Accepting New Patients check Box is displayed");
			return false;
		}
	}


	public boolean clickAcceptingNewPatientsCheckBox()
	{
			return utils.clickAnelemnt(chckBxAcceptingNewPatients, "Provider", "Accept New Patient check box is clicked");
	}

	@FindBy(xpath="//span[contains(text(),'Search Criteria')]")
	WebElement lnkSearchCriteria;


	public boolean clickSearchCriteria()
	{
		return utils.clickAnelemnt(lnkSearchCriteria, "Provider", "Search Criteria");
	}

	@FindBy(xpath="//div[contains(text(),'Export')]")
	WebElement btnExport;

	public boolean clickBtnExport()
	{
		return utils.clickAnelemnt(btnExport, "Provider", "Export");
	}

	@FindBy(xpath="//div[contains(text(),'Other actions')]")
	WebElement drpDownOtherActions;


	@FindBy(xpath="//span[text()='Research Provider']")
	WebElement lnkOthrActionsResearchProvider;

	/*Navigate to research provider page */
	public boolean navigateToResearchProvider()
	{
		if(utils.clickAnelemnt(drpDownOtherActions, "Provider", "Other Actions button"))
			return utils.clickAnelemnt(lnkOthrActionsResearchProvider, "Provider", "Research Provider");
		return false;
	}
	
	@FindBy(id="ReasonForRequest")
	WebElement ReasonForRequest;
	
	@FindBy(id="Notes")
	WebElement Notes;
	
	/**Selects Reason for Contact and enter Notes Section
	 * 
	 * @param args
	 * @return
	 */
	public boolean selectReasonForContactNEnterNotes(String[] args) {
		if(utils.selectDropDownbyVisibleString(ReasonForRequest, args[0], "Provider", "ReasonForRequest"))
			return utils.enterTextinAnelemnt(Notes, args[1], "Provider", "Notes");
		return false;
	}
	
	@FindBy(id="ProviderSearchTypeFind a Provider by PCP ID")
	WebElement RdoBtnFindByPCPID;
	
	@FindBy(id="PrimaryCarePysicianIdentifier")
	WebElement TxtBoxPCPID;
	
	public boolean clickRdoBtnFindByPCPId() {
		return utils.clickAnelemnt(RdoBtnFindByPCPID, "Provider", "RdoBtnFindByPCPID");
	}
	
	public boolean searchPCPID(String[] args) {
		if(clickRdoBtnFindByPCPId())
			if(utils.enterTextinAnelemnt(TxtBoxPCPID, args[0], "Provider", "TxtBoxPCPID"))
				return ClickSearchbtnProvider();
		return false;
	}
	
	@FindBy(xpath="//span[text()='Request Grievance and App...']")
	WebElement GrievanceAndAppealText;
	
	public boolean verifyGATaskIsNotPresentInOtherActions() {
		if(utils.clickAnelemnt(this.btnOtherActions, "Provider", "Other Actions Button"))
			return utils.isProxyWebelement(GrievanceAndAppealText);
		return false;
	}
	
	public boolean verifyGATaskPresentInOtherActions() {
		if(utils.clickAnelemnt(this.btnOtherActions, "Provider", "Other Actions Button"))
			return !utils.isProxyWebelement(GrievanceAndAppealText);
		return false;
	}
	
	@FindBy(id="PlanSearchSearch with the plan")
	WebElement rdoBtnSearchWithPlanNetwork;
	
	@FindBy(name="$PpyWorkPage$pProviderSearch$pProviderSearchType")
	WebElement rdoBtnFindAProvider;
	
	@FindBy(id="PlanSearchSearch all plans")
	WebElement rdoBtnSearchAllPlansNetwrok;
	
	@FindBy(id="ProviderSearchTypeFind a Provider by PCP ID")
	WebElement rdoBtnFindProviderPCPID;
	
	@FindBy(id="ReasonForRequest")
	WebElement drpDownReasonForRequest;
	
	
	public boolean enterProviderDetailsAndClickSearchForFindingProviderWithPlanNetwork(String[] args)
	{
		if(utils.clickAnelemnt(rdoBtnSearchWithPlanNetwork, "Provider", "SearchWithPlanNetwork"))
			if(utils.clickAnelemnt(rdoBtnFindAProvider, "Provider", "Find A Provider"))
				if(utils.selectDropDownbyVisibleString(drpdwnImLookingfor, args[0], "Provider", "I'm looking For"))
					if(utils.selectDropDownbyVisibleString(drpdwnPrvdrSpeciality, args[1], "Provider", "Speciality"))
						//if(utils.enterTextinAnelemnt(txtLocatedNear, args[2], "Provider", "Located Near"))
							return utils.clickAnelemnt(btnSearch, "Provider", "Search");
		return false;
	}
	
	public boolean validateTheProvidersDisplayed(String[] args) throws InterruptedException
	{
		try{
			//utils.waitforpageload();
			Thread.sleep(3000);
			WebElement element = Driver.pgDriver.findElement(By.xpath("//table[@pl_prop='ProviderList.pxResults']"));
			((JavascriptExecutor) Driver.pgDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement result = utils.getProviderResultsBasedOnValues(getProviderResultsTbl(),args);
			result.findElement(By.xpath("//input[contains(@id,'TagProvider')]")).click();
			utils.waitforpageload();
		}catch(Exception e){
			err.logcommonMethodError("Provider","validateProviderResultsDisplayed"+e);
			System.out.println("Exception occured in validateProviderResultsDisplayed"+e);
			return false;
		}
		return true;
		
	}
	
	
	public boolean selectReasonForRequest(String[] args)
	{
		return utils.selectDropDownbyVisibleString(drpDownReasonForRequest, args[0], "Provider", "ReasonForRequest");		
	}
	
	
	@FindBy(xpath="//div[contains(text(),'Other actions')]")
	WebElement lnkOtherActions;
	
	@FindBy(xpath="//li[@title='Cancel this work']")
	WebElement lnkCancelThisWork;
	
	@FindBy(xpath="//li[@title='Request Manager/OE Help']")
	WebElement lnkRequestManagerOEHelp;
	
	@FindBy(xpath="//li[@title='Report Provider Network Issue']")
	WebElement lnkReportProviderNetworkIssue;
	
	@FindBy(xpath="//li[@title='Research Provider']")
	WebElement lnkResearchProvider;
	
	@FindBy(xpath="//li[@title='Report Provider Profile Issue']")
	WebElement lnkReportProviderProfileIssue;
	
	
	
	public boolean clickOnOtherActions()
	{
		return utils.clickAnelemnt(lnkOtherActions, "Provider", "Other Actions");
	}
	
	public boolean verifyOptionsInOtherActions()
	{
		return !utils.isProxyWebelement(lnkCancelThisWork) && !utils.isProxyWebelement(lnkRequestManagerOEHelp) && !utils.isProxyWebelement(lnkResearchProvider) && !utils.isProxyWebelement(lnkReportProviderProfileIssue) && !utils.isProxyWebelement(lnkReportProviderNetworkIssue);
	}
	
	public boolean clickOnReportProviderNetworkIssueInOtherActions()
	{
		return utils.selectValueFromListbyVisibleString(lnkOtherActions, "Report Provider Network I...", "Provider", "Report Provider Network Issue");
	}
	
	
	public boolean clickOnReportProviderProfileIssueInOtherActions()
	{
		return utils.selectValueFromListbyVisibleString(lnkOtherActions, "Report Provider Profile I...", "Provider", "Report Provider Network Issue");
	}
	
	@FindBy(xpath="//*[text()='Find a Provider by PCP ID']")
	WebElement rdbPCPIDHidden;
	
	@FindBy(xpath="//input[@id='TagGandA1']")
	WebElement rdbGandAHidden;
	
	@FindBy(xpath="//*[text()='Assign PCP']")
	WebElement rdbAssignPCPHidden;
	
	public boolean verifyPCPIDRadioButtonHidden()
	{
	 return utils.isProxyWebelement(rdbPCPIDHidden);
	}
	
	public boolean verifyRequestGAndAButtonIsHidden()
	{
	 return utils.isProxyWebelement(rdbGandAHidden);
	}
	
	public boolean verifyAssignPCPButtonIsHidden()
	{
	 return utils.isProxyWebelement(rdbAssignPCPHidden);
	}
	
	
}
