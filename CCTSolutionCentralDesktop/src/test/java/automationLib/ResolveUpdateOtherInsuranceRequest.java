package automationLib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ResolveUpdateOtherInsuranceRequest {


	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Home home = new Home();
	Actions action=new Actions(Driver.getPgDriver());

	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;

	public ResolveUpdateOtherInsuranceRequest(){
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	}

	@FindBy(xpath="//*[@data-test-id='20180104033407088518136']")
	WebElement EffDate;
	
	@FindBy(xpath="//*[@data-test-id='20180402144743056438671']")
	WebElement ReasonForTermination;

	public boolean verifyUpdateOtherInsRequest(String[] args) {
		boolean flag=false;
		if(utils.validateLabel(EffDate, args[0])) {
			if(utils.validateLabel(ReasonForTermination, args[1])) {
				flag = true;
			}
		}
		if(flag) {
			blogger.loginfo("Update Other Insurance Request verified Succesfully");
			return true;
		}else {
			blogger.loginfo("Update Other Insurance Request failed");
			return false;
		}
	}
	
	@FindBy(id="COBTeamResponse")
	WebElement TeamResponseDrpDown;
	
	@FindBy(id="pyNote")
	WebElement NotesSection;
	
	@FindBy(xpath="//*[text()='Submit']")
	WebElement SubmitButton;
	
	
	public boolean selectFromCOBMEDTeamResponseAndEnterNotes(String[] args) {
		boolean flag = false;
		action.moveToElement(TeamResponseDrpDown);
		if(utils.selectDropDownbyVisibleString(TeamResponseDrpDown, args[0], "ResolveUpdateOtherInsuranceRequest", "TeamResponseDrpDown")) {
		if(utils.enterTextinAnelemnt(NotesSection, args[1], "ResolveUpdateOtherInsuranceRequest", "NotesSection")) {
		flag= utils.clickAnelemnt(SubmitButton, "ResolveUpdateOtherInsuranceRequest", "SubmitButton");
		}
	}
		if(flag) {
			blogger.loginfo("PASS: COB/MED Team Response selected, Notes entered in Notes Section and Submit is clicked");
			return true;
		}else {
			blogger.loginfo("FAIL: COB/MED Team Response not selected/Notes not entered in Notes Section/Submit is not clicked");
			return false;
		}
	}
	
	@FindBy(xpath="//*[text()='Skill Name']/ancestor::table[@id='bodyTbl_right']")
	WebElement SkillRequiredTable;
	
	@FindBy(xpath="(//div[@role='button'])[1]")
	WebElement clickToolIcon;


	@FindBy(xpath="//span[text()='View Skills']")
	WebElement clickOnViewSkills;

	/**This methods clicks the view skills option on clicking the tool icon on Service Request details page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean clickViewSkillsFromToolIcon() throws InterruptedException{
		Thread.sleep(3000);
		utils.scrolltoright();
		if(utils.clickAnelemnt(clickToolIcon, "ResolveUpdateOtherInsuranceRequest", "Tool icon"))
			if(utils.clickAnelemnt(clickOnViewSkills, "ResolveUpdateOtherInsuranceRequest", "View Skills"))
				return true;
		return false;

	}
	
	/**This functionality validates the skills assigned to the SR in the service request details page
	 * 
	 * @param args
	 * @return
	 */
	public boolean validateTheSRSkills(String[] args) {
		return utils.validatetablerowbasedonvalues(SkillRequiredTable, args);
	}

}