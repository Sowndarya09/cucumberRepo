package automationLib;

import java.util.List;

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

import com.aventstack.extentreports.ExtentReporter;


import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class PegaDesignerStudio 
{Actions action;
	SeleniumUtilities utils = new SeleniumUtilities();
	ErrorLogger err = new ErrorLogger();
	BaseLogger blogger=new BaseLogger();
	public static String name;
	public static ExtentReporter reports;
	
	WebDriverWait wait;
	
	
	@FindBy(id="pySearchTextForRecents")
	WebElement searchforUserIDs;
	
	@FindBy(id="pySearchText")
	WebElement searchboxtop;
	
	@FindBy(xpath="//div[@node_name='pzSearchResultName']//a")
	WebElement MemberIDsearchresult;
	
	@FindBy(xpath="//a[@title='Add item ']")
	WebElement imgAddbtn;
	
	@FindBy(xpath="//div[contains(@data-ui-meta,'pzWorkBasket')]//a[@title='Add item ']")
	WebElement imgWorkAddWorkbasket;
	
	@FindBy(xpath="//div[contains(@data-ui-meta,'pzSkills')]//a[@title='Add item ']")
	WebElement imgWorkAddSkills;
	
	@FindBy(xpath="//a[@id='TABANCHOR']//*[text()='Profile']")
	WebElement TabProfile;
	@FindBy(xpath="//a[@id='TABANCHOR']//*[text()='Work']")
	WebElement TabWork;
	
	@FindBy(xpath="//input[@title='Access Group'][@value='']")
	WebElement txtbxAccessGroup;
	
	@FindBy(xpath="//a[@title='Delete item 1']")
	WebElement deleteRow;
	
	@FindBy(xpath="//*[@id='pyWorkBasketName'][@value='']")
	WebElement txtbxWorkBasket;
	
	@FindBy(id="pyWorkGroup")
	WebElement txtbxWorkGroup;
	
	@FindBy(id="pyReportTo")
	WebElement  txtbxReportsTo;
	
	@FindBy(xpath="//*[@id='pySkillName'][@value='']")
	WebElement txtbxSkill;
	
	@FindBy(xpath="//button[@title='Save your changes to this record']")
	WebElement btnSave;
	
	@FindBy(id="pyOpAvailable")
	WebElement chkbxoperatoravailable;
	
	@FindBy(id="pyWorkbasketFirst")
	WebElement chkbxWorkBasketFirst;
	
	@FindBy(id="pyMergeWorkbaskets")
	WebElement chkbxmergeWorkBaskets;
	
	@FindBy(id="pyUseAllWorkbasketsInWorkgroup")
	WebElement chkbxAllworkbasket;
	
	@FindBy(xpath="//input[@type='radio'][@id='DefaultAG']")
	WebElement radiobtnfroaccessgrp;
	
	
	
	
	public PegaDesignerStudio()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		
		// change the driver  
	}
	@FindBy(id="PegaGadget0Ifr")
	WebElement Iframeelement;
	
	/*@SCU
	 *#CommonMethodwithoutArgument:launchPegaDesignerStudio
	 * Type:Textbox
	 
	 */

	/*@SCU
	 * #CommonMethodwithArgument:selectMemberIDfromrecent
	 * #Description: This functionality enters the member ID in the search ID text box and clicks the member ID from the recent tab.
	 * #Arguments:MemberID
	 * Type:Textbox 
	 */
	
	public boolean selectMemberIDfromrecent(String[] memberid)
	{
		try{
			
		if(utils.enterTextinAnelemnt(this.searchforUserIDs, memberid[0], "PegastudioDesigner", "Search ID textbox"))
		{
			Driver.pgDriver.findElement(By.xpath("//a[@title='"+memberid[0]+"']"));
			WebDriverWait wait=new WebDriverWait(Driver.pgDriver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Click to edit']")));
		}
		else
		{
			err.logcustomerrorwithmessage("PegaStudioDesigner", "SelectmemberIDfromrecent", "Not able to clic ");
			return false;
		}
		
	}catch(Exception e)
		{
		err.logcustomerrorwithmessage("PegaStudiodesinger", "SelectmemberIDfromrecent", "Not able to select the member from the search");
		return false;
		}
		return true;
	}
	
	/*@SCU
	 * #CommonMethodwithArgument:selectMemberIDfromSearchBar
	 * #Description: This functionality selects member ID from search bar by entering the member ID in the search box and then click the link.
	 * #Arguments:MemberID
	 * Type:Textbox 
	 */
	public boolean selectMemberIDfromSearchBar(String[] memberid)
	{
		try{
			Driver.pgDriver.switchTo().defaultContent();
		if(utils.enterTextinAnelemnt(this.searchboxtop, memberid[0], "PegastudioDesigner", "Search ID textbox"))
		{
			utils.pressEnter(this.searchboxtop, "PegaStudioDesigner", "Pressing enter on the search box");
			utils.clickAnelemnt(this.MemberIDsearchresult, "PegaStudioDesigner", "Member id link");
			Driver.pgDriver.switchTo().frame(this.Iframeelement);
			//this.uncheckAll();
			return true;
			
		}
		else
		{
			err.logcustomerrorwithmessage("PegaStudioDesigner", "SelectmemberIDfromrecent", "Not able to clic ");
			return false;
		}
		
	}catch(Exception e)
		{
		err.logcustomerrorwithmessage("PegaStudiodesinger", "SelectmemberIDfromrecent", "Not able to select the member from the search");
		return false;
		}
		
	}
	
	/*@SCU
	 * #CommonMethodwithArgument:SetAccessGroupforUser
	 * #Description: This functionality set the Access Group for the user by getting the access group value from the user.
	 * #Arguments:AccessGroup
	 * Type:Textbox 
	 */
	
	public boolean SetAccessGroupforUser(String[] accessgroup)
	{
		try{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		utils.clickAnelemnt(this.TabProfile,"PegaDesignerStudio","Profile tab");
	utils.clickAnelemnt(this.deleteRow, "PegaDesignerStudio", "Delete button");
	utils.clickAnelemnt(this.imgAddbtn, "PegaDesignerStudio", "Add button");
	;
			if(utils.enterTextinAnelemnt(this.txtbxAccessGroup, accessgroup[0], "PegaDesignerStudio", "AccessGroup Text Box"))
			{
				Driver.pgDriver.findElement(By.xpath("//*[text()='Application Access']")).click();
				utils.waitforpageload();
				utils.clickAnelemnt(this.radiobtnfroaccessgrp, "PegaDesignerStudio", "Radio button");
				return true;
			}
		
		}catch(Exception e)
		{
			err.logcommonMethodError("PegaStudioDesigner", "SetAccessGroupforUser");
			return false;
		}
		return false;
		
	}
	
	

	/*@SCU
	 * #CommonMethodwithArgument:SetWorkgroup
	 * #Description: This functionality set the work group for the user by getting the workbasket value from the user.
	 * #Arguments:WorkBasket
	 * Type:Textbox 
	 */
	
	public boolean SetWorkgroup(String[] workbasket)
	{
		
		try{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
			
		utils.clickAnelemnt(this.TabWork,"PegaDesignerStudio","Work tab");
		
			if(utils.enterTextinAnelemnt(this.txtbxWorkGroup, workbasket[0], "PegaDesignerStudio", "AccessGroup Text Box"))
			{
				
				//Driver.pgDriver.findElement(By.xpath("//*[text()='Scheduling']")).click();
				//utils.clickAnelemnt(this.btnSave, "PegaDesignerStudio", "Save Button");
				return true;
			}
			
		
		}catch(Exception e)
		{
			err.logcommonMethodError("PegaStudioDesigner", "AddWorkBasketUnderGroup");
			return false;
		}
		
		return false;
	}
	
	
	/*@SCU
	 * #CommonMethodwithArgument:SetReportsTo
	 * #Description: This functionality set Reports by getting the workbasket value from the user.
	 * #Arguments:WorkBasket
	 * Type:Textbox
	 */
	
	public boolean SetReportsTo(String[] workbasket)
	{
		try{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		utils.clickAnelemnt(this.TabWork,"PegaDesignerStudio","Work tab");
		
			if(utils.enterTextinAnelemnt(this.txtbxReportsTo, workbasket[0], "PegaDesignerStudio", "AccessGroup Text Box"))
			{
				
				//Driver.pgDriver.findElement(By.xpath("//*[text()='Scheduling']")).click();
				return true;
			}
		
		}catch(Exception e)
		{
			err.logcommonMethodError("PegaStudioDesigner", "AddWorkBasketUnderGroup");
			return false;
		}
		return false;
		
	}
	
	/*@SCU
	 * #CommonMethodwithArgument:AddWorkBasketUnderWork
	 * #Description: This functionality add the work basket under work by getting the workbasket value from the user.
	 * #Arguments:WorkBasket
	 * Type:Textbox 
	 */
	public boolean AddWorkBasketUnderWork(String[] workbasket)
	{
		try{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		utils.clickAnelemnt(this.TabWork,"PegaDesignerStudio","Work tab");
		int a=Driver.pgDriver.findElements(By.xpath("//table[contains(@pl_prop,'WorkBasketList')]//a[@class='iconDelete']")).size();
		if(a>1)
		{
		for(int i=0;i<a;i++)
		{
			String tempxpath="//table[contains(@pl_prop,'WorkBasketList')]//tr[@pl_index='1']//a[@class='iconDelete']";
			System.out.println(tempxpath);
			Driver.pgDriver.findElement(By.xpath(tempxpath)).click();
			Thread.sleep(500);
		}
		}
		for(String wrkbskt:workbasket)
		{
		if(utils.clickAnelemnt(this.imgWorkAddWorkbasket, "PegaDesignerStudio", "Add Button"))
		{
			if(utils.enterTextinAnelemnt(this.txtbxWorkBasket, wrkbskt, "PegaDesignerStudio", "AccessGroup Text Box"))
			{
				Driver.pgDriver.findElement(By.xpath("//*[text()='Scheduling']")).click();
				utils.clickAnelemnt(this.btnSave, "PegaDesignerStudio", "Save button");
			}
		}
		}
		return true;
		}catch(Exception e)
		{
			err.logcommonMethodError("PegaStudioDesigner", "AddWorkBasketUnderGroup");
			return false;
		}
		
		
	}
	
	/*@SCU
	 * #CommonMethodwithArgument:AddSkillUnderWork
	 * #Description: This functionality add the skill under work by getting the skill value from the user.
	 * #Arguments:Skill
	 * Type:Textbox 
	 */
	public boolean AddSkillUnderWork(String[] skill)
	{
		try{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		utils.clickAnelemnt(this.TabWork,"PegaDesignerStudio","Work tab");
		int a=Driver.pgDriver.findElements(By.xpath("//table[contains(@pl_prop,'Skills')]//a[@class='iconDelete']")).size();
		if(a>1)
		{
		for(int i=0;i<a;i++)
		{
			String tempxpath="//table[contains(@pl_prop,'Skills')]//tr[@pl_index='1']//a[@class='iconDelete']";
			System.out.println(tempxpath);
			Driver.pgDriver.findElement(By.xpath(tempxpath)).click();
			utils.waitforpageload();
		}
		}
		for(String wrkbskt:skill)
		{
		if(utils.clickAnelemnt(this.imgWorkAddSkills, "PegaDesignerStudio", "Add Button"))
		{
			if(utils.enterTextinAnelemnt(this.txtbxSkill, wrkbskt, "PegaDesignerStudio", "AccessGroup Text Box"))
			{
				utils.clickAnelemnt(this.btnSave, "PegaDesignerStudio", "AddSkillUnderWork");
				
			}
		}
		}
		return true;
		}catch(Exception e)
		{
			err.logcommonMethodError("PegaStudioDesigner", "AddSkillUnderGroup");
			return false;
		}
		
		
	}
	
	/*@SCU
	 * #CommonMethodwithoutArgument:SaveChanges
	 * #Description: This functionality save the changes made by the user.
	 * Type:Textbox 
	 */
	public boolean SaveChanges()
	{
		try{
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);
		if(utils.clickAnelemnt(this.btnSave, "PegaDesignerStudio", "Save button"))
		{
			
			utils.waitforpageload();
			
			return true;
		}
		else
		return false;
		}
		catch(Exception e)
		{
			err.logcustomerrorwithmessage("PegaDesignerStudio", "SaveChanges", "Save failed");
		}
		return false;
	}
	
	
	public boolean uncheckAll()
	{
		utils.clickAnelemnt(this.TabWork,"PegaDesignerStudio","Work tab");
		if(this.chkbxoperatoravailable.isSelected())
			utils.clickAnelemnt(this.chkbxoperatoravailable, "PegaStudioDesigner", "Check box operrator available");
			
			if(this.chkbxWorkBasketFirst.isSelected())
				utils.clickAnelemnt(this.chkbxWorkBasketFirst, "PegaStudioDesigner", "Check box Workbaskets first");
			
					
				
				if(this.chkbxmergeWorkBaskets.isSelected())
					
						utils.clickAnelemnt(this.chkbxmergeWorkBaskets, "PegaStudioDesigner", "Check box Merge Workbaskets");
					
					
					//if(this.chkbxAllworkbasket.isSelected())
						
							//utils.clickAnelemnt(this.chkbxAllworkbasket, "PegaStudioDesigner", "Check box Workbaskets All");
						return true;
	}
	public boolean check_operator_available_to_receive_work()
	{
		utils.clickAnelemnt(this.TabWork,"PegaDesignerStudio","Work tab");
		if(this.chkbxoperatoravailable.isSelected())
		return true;
		else
			utils.clickAnelemnt(this.chkbxoperatoravailable, "PegaStudioDesigner", "Check box operrator available");
		return true;
	}
	
	public boolean check_Workbaskets_first()
	{
		utils.clickAnelemnt(this.TabWork,"PegaDesignerStudio","Work tab");
		if(this.chkbxWorkBasketFirst.isSelected())
			return true;
			else
				utils.clickAnelemnt(this.chkbxWorkBasketFirst, "PegaStudioDesigner", "Check box Workbaskets first");
			return true;
	}

	public boolean check_Merge_WorkBaskets()
	{
		utils.clickAnelemnt(this.TabWork,"PegaDesignerStudio","Work tab");
		if(this.chkbxmergeWorkBaskets.isSelected())
			return true;
			else
				utils.clickAnelemnt(this.chkbxmergeWorkBaskets, "PegaStudioDesigner", "Check box Merge Workbaskets");
			return true;
	}
	public boolean check_use_all_workbasket()
	{
		utils.clickAnelemnt(this.TabWork,"PegaDesignerStudio","Work tab");
		this.check_Merge_WorkBaskets();
		if(this.chkbxAllworkbasket.isSelected())
			return true;
			else
				utils.clickAnelemnt(this.chkbxAllworkbasket, "PegaStudioDesigner", "Check box Workbaskets All");
			return true;
		
	}
	
	
	//Sprint 2.4 Code
	
	//SIT
	@FindBy(xpath="//a[contains(text(),'Administrator')]")
	WebElement tabAdministrator;
	
	//UAT
	@FindBy(xpath="//a[contains(text(),'Admin')]")
	WebElement tabAdmin;
	
	@FindBy(xpath="//span[contains(text(),'Log off')]")
	WebElement tablogoff;
	
	@FindBy(xpath="//h1[text()='Logout']")
	WebElement lblLogOut;
	
	/*
	 * @SCU
	 * #CommonMethodWithoutArgument: logOutAndReLogin
	 * #Description: This functionality clicks the admin tab in the pega designer studio and clicks the logoff option and reloads the page for re-login
	 * #Type: Textbox
	 */
	public boolean logOutAndReLogin()
	{
		System.out.println("try..");
		Driver.pgDriver.switchTo().defaultContent();
		//WebElement element = this.tabAdministrator;
		//JavascriptExecutor executor = (JavascriptExecutor)Driver.pgDriver;
		//executor.executeScript("arguments[0].click();", element);
		utils.clickAnelemnt(this.tabAdmin, "PegaDesignerStudio", "Admin");
		utils.clickAnelemnt(this.tablogoff, "PegaDesignerStudio", "Admin");
		Driver.pgDriver.switchTo().defaultContent();
		wait=new WebDriverWait(Driver.pgDriver,20);
		wait.until(ExpectedConditions.visibilityOf(this.lblLogOut));		
		String relogin = Driver.pgDriver.getCurrentUrl().replace("logout", "login");
		System.out.println("Relogin URL"+relogin);
		Driver.pgDriver.navigate().refresh();
		Driver.pgDriver.navigate().to(relogin);
		return true;
	}
	
	@FindBy(xpath="//table[@pl_prop='.pySkills']//following::div[@node_type='SECTION_BODY']//table//tbody//a")
	WebElement lnkAddSkilIcon;
	
	@FindBy(xpath="//input[contains(@name,'$ppySkillName')]")
	WebElement txtEnterSkillName;
	
	//@FindBy(xpath="//select[@id='ISnsSelect']/option")
	@FindBy(xpath="//select[@id='ISnsSelect']//option")
	List<WebElement> SkillOptions;
	
	@FindBy(xpath="//table[@pl_prop='.pySkills']//a[@class='iconDelete']")
	WebElement deleteIcon;
	
	public boolean navigateToWorkAndVerifySkill(String[] args)
	{
		if(utils.clickAnelemnt(this.TabWork, "PegaDesignerStudio", "Work Tab"))
		{
			if(utils.clickAnelemnt(this.deleteIcon, "PegaDesignerStudio", "Delete Icon"))
			{
				if(utils.clickAnelemnt(this.lnkAddSkilIcon, "PegaDesignerStudio", "Add Icon"))
					{
					utils.enterTextinAnelemnt(this.txtEnterSkillName, args[0], "PegaDesignerStudio", "Skill Name");
					this.txtEnterSkillName.sendKeys(Keys.ARROW_DOWN);
					
					for(WebElement e:SkillOptions)
					{
						System.out.println("Skill Options: "+e.getText());
						if(e.getText().trim().equalsIgnoreCase(args[0])){
						blogger.loginfo("Actual Value matched : "+e.getText().trim()+" with the expected value "+args[0]);
						System.out.println("Text match in UI: "+e.getText().trim()+" with the expected "+args[0]);
						return true;
						}else{
						System.out.println("Text didnt match in UI:"+e.getText().trim()+" With the expected "+args[0]);
						}
					}
				
			 }
			}
			return false;
		}
		return false;
	}
	
	
}


