package automationLib;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import runner.MainDriverTest;
import stepdefinition.stepdefinition;

import java.util.ArrayList;
import java.util.List;
import utils.SeleniumUtilities;
import utils.BaseLogger;
import utils.ErrorLogger;


public class BulkActions {
	public BulkActions () throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);

	}
	SeleniumUtilities utils= new SeleniumUtilities();
	ErrorLogger logerror = new ErrorLogger();
	BaseLogger log= new BaseLogger();
	String[] ACAClaimsFiltervalues ={"ACA Claims Pending Review","ACA Claims Review","ACA Claims Urgent Review"};
	String[] NonACALocalClaims ={"Non ACA/Local Claims Pending Review","Non ACA/Local Claims Review","Non ACA/Local Claims Urgent Review"};
	String[] ACAMemberExperience = {"Customer Service Escalation WB","Customer Service Review WB","Pending Dependency Task WB"};
	String [] ACA_Ind_SG_BillingTeam ={"ACA Billing Excpetion","ACA Billing Standard","ACA Billing Urgent"};
	String[] ACA_Ind_SG_EnrollmentTeam ={"ACA Enrollment Review"};
	String[] ProviderServices = {"Provider Review WB","Provider Escalation WB","Provider Pending Dependency Task WB"};
	String[] Largegroup ={"Large Group Local CS Support","Large Group Local Customer Service","Large Group Pharmacy Eligibility Update"};

	@FindBy(id="PegaGadget1Ifr")
	private WebElement Iframeelement;

	@FindBy(id="PegaGadget0Ifr")
	private WebElement Iframeelement0;

	@FindBy(xpath="//*[contains(text(),'Bulk Actions')]")
	private WebElement btnBulkActions;

	@FindBy(xpath="//a[contains(text(),'Filter')]")
	private WebElement lnkAddFilter;
	@FindBy(id="acresults-list")
	private WebElement lnkAssignedToWorkBasket;


	@FindBy(xpath="//input[@class='autocomplete_input ac_']")
	WebElement txtfiltervalue;

	@FindBy(xpath="//table[@id='bodyTbl_right'][@pl_prop='pyBulkProcessReport.pxResults']")
	WebElement tblSRrequest;
	@FindBy(id="pySelected1")
	WebElement checkBoxFirstrow;

	@FindBy(xpath="//*[contains(text(),'Select Action')]")
	WebElement btnSelectAction;

	@FindBy(xpath="//span[contains(text(),'Transfer assignment')]")
	WebElement lnkTransferAssignment;

	@FindBy(id="objWBSelect")
	WebElement dropdwnWBselect;
	@FindBy(xpath="//select[@id='objWBSelect']//option")
	WebElement drpdwnWBOptions;


	private void switchframe1(){
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}
	public WebElement getbtnBulkActions() {

		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame("PegaGadget0Ifr");

		return Driver.getPgDriver().findElement(By.xpath("//*[contains(text(),'Bulk Actions')]"))	;

	}	
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnBulkActions
	 * #Description:clicking on the bulk actions button in the bulk actions page  
	 * Type:Textbox
	 */
	public boolean clickOnBulkActions() throws InterruptedException {
		Thread.sleep(3000);
		return utils.clickAnelemnt(this.getbtnBulkActions(), "BulkActions", "btnBulk actions");
	}

	public boolean selectFilterProperty(String filterproperty){

		List<WebElement> dropdwnFilterstring= Driver.getPgDriver().findElements(By.xpath(("//input[@class='autocomplete_input']")));
		utils.enterTextinAnelemnt(dropdwnFilterstring.get(dropdwnFilterstring.size()-1),filterproperty,"BulkActions", "addfilter text");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Driver.getPgDriver().switchTo().defaultContent();
		return utils.clickAnelemnt(this.lnkAssignedToWorkBasket, "bulk actions", "assigned to work basket link in filterpoerty");
	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:clickOnAddFilters
	 * #Description:clicking on the add filters on the bulk actions page 
	 * Type:Textbox
	 */
	public boolean clickOnAddFilters(){
		this.switchframe1();
		return utils.clickAnelemnt(this.lnkAddFilter, "Bulkactions", "addfilter");
	}


	public boolean verifyfilterValues(String[] workgrpvalues){
		this.switchframe1();
		utils.clickAnelemnt(this.txtfiltervalue, "BulkAction", "filtervalue");
		this.txtfiltervalue.sendKeys(Keys.ARROW_DOWN);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List <WebElement> filterValues=	Driver.getPgDriver().findElements(By.xpath("//div[@class='cellIn']//span"));
		if(filterValues.size()==workgrpvalues.length){
			for(int i=0;i<workgrpvalues.length;i++){
				if(filterValues.get(i).getText().trim().equalsIgnoreCase(workgrpvalues[i].trim()))
					continue;
				else 
				{
					logerror.logcustomerrorwithmessage("Bulkaction", "Verifyvalue", "the value did not match ");	
					return false;
				}
			}
		}
		else 
		{
			logerror.logcustomerrorwithmessage("Bulkaction", "Verifyvalue", "the number of values in the work basket and expected alues did not match ");
			return false;
		}

		return true;	

	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:selectAssignedToWorkBasket
	 * #Description:selecting the assigned to work bsket option in the filter property
	 * Type:Textbox
	 */
	public boolean selectAssignedToWorkBasket(){
		return this.selectFilterProperty("Assigned To WorkBasket");
	}

	public boolean verifyWBValuesForACAClaims(){
		return this.verifyfilterValues(this.ACAClaimsFiltervalues);
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyWBValuesForACAMemberExperience
	 * #Description:verifying the available WB options for the ACA member experience group
	 * Type:Textbox
	 */
	public boolean verifyWBValuesForACAMemberExperience(){
		return this.verifyfilterValues(ACAMemberExperience);
	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyWBValuesForACA_Ind_SG_BillingTeam
	 * #Description:verifying the available WB options for the ACA_Ind_SG_BillingTeam
	 * Type:Textbox
	 */
	public boolean verifyWBValuesForACA_Ind_SG_BillingTeam(){
		return this.verifyfilterValues(ACA_Ind_SG_BillingTeam);
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyWBValuesForACA_Ind_SG_EnrollmentTeam
	 * #Description:verifying the available WB options for the ACA_Ind_SG_EnrollmentTeam
	 * Type:Textbox
	 */
	public boolean verifyWBValuesForACA_Ind_SG_EnrollmentTeam(){
		return this.verifyfilterValues(ACA_Ind_SG_EnrollmentTeam);
	}

	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyWBValuesForProviderServices
	 * #Description:verifying the available WB options for the verifyWBValuesForProviderServices
	 * Type:Textbox
	 */
	public boolean verifyWBValuesForProviderServices(){
		return this.verifyfilterValues(ProviderServices);
	}
	/*
	 * @SCU
	 * #CommonMethodwithoutArgument:verifyWBValuesForLargeGroup
	 * #Description:verifying the available WB options for the large group
	 * Type:Textbox
	 */

	public boolean verifyWBValuesForLargeGroup(){
		return this.verifyfilterValues(Largegroup);
	}

	public boolean navigateTotrasnsferAssignmetWorkBasket(){
		this.switchframe1();
		if(utils.clickAnelemnt(this.checkBoxFirstrow, "Bulkaction", "firstrowCheckBox"))
			if(utils.clickAnelemnt(btnSelectAction, "BulkAction", "SelectAction"))
				return utils.clickAnelemnt(lnkTransferAssignment, "BulkAction", "TransferAssignment");
		return false;

	}

	public boolean validateTransferAssignmentWorkBasket(String[] values){
		this.switchframe1();
		utils.clickAnelemnt(this.checkBoxFirstrow, "Bulkaction", "firstrowCheckBox");
		utils.clickAnelemnt(btnSelectAction, "BulkAction", "SelectAction");	
		utils.clickAnelemnt(lnkTransferAssignment, "BulkAction", "TransferAssignment");
		String validatedvalues="";
		String[] dropdownoptions = values[0].split(",");
		utils.clickAnelemnt(dropdwnWBselect, "BulkAction", "Wb dropdown");
		List <WebElement> options =Driver.getPgDriver().findElements(By.xpath("//select[@id='objWBSelect']//option"));
		utils.clickAnelemnt(options.get(1), "BulkAction", "First vaue in drop down");
		List <String> optionsfrompega = new ArrayList<String>();
		if(options.size()-1==dropdownoptions.length){
			for(int i=0;i<dropdownoptions.length;i++){
				optionsfrompega.add(options.get(i+1).getText());
				validatedvalues=validatedvalues + optionsfrompega.get(i)+",";
			}
		}
		else { 
			log.logCommonMethodfailure("Number of work basket items mismatched", stepdefinition.logger);
			return false;
		}
		for(int i=0;i<dropdownoptions.length;i++)		
			if (validatedvalues.contains(dropdownoptions[i]))	
				continue;		
			else {
				log.logCommonMethodfailure("mismatch" + dropdownoptions[i] + " was missing in the drop down values", stepdefinition.logger);
				return false;
			}
		log.logCommonMethodSuccessMessage("validated "+ validatedvalues, stepdefinition.logger);
		return true;
	}
}
