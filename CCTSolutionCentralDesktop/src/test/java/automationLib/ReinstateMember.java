package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;
/**
 * Cancel Payment Page 
 * @author AF02876
 *
 */
public class ReinstateMember {
	/**
	 * Methods in the Program 
	 */
	DataSet ds=new DataSet();
	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();

	// Changes to the Heading HEader 
	@FindBy(className="actionTitleBarLabelStyle")
	private WebElement sHeaderCompleteBilling;
	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelement;
	@FindBy(xpath="//div[@node_name='ReinstateMember']//label[contains(text(),'ISG Mainframe')]")
	private WebElement labelReinstateMemberISGMainframe;
	@FindBy(xpath="//div[@node_name='ReinstateMember']//label[contains(text(),'Please access Mainframe to fulfill this request.')]")
	private WebElement labelReinstateMemberAccessMainframe;
	

	/**
	 * Constructor for the Create Promised Action class defining the Iframe and the Page Factory  
	 */
	public ReinstateMember() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);// change the driver 
	}
	
	 @FindBy(xpath="//table[@class='gridTable '][contains(@pl_prop,'TaggedItems')]")
		private WebElement tableItemsDiscussedDuringManageBillingReview;
	
	
	   @FindBy(className="actionTitleBarLabelStyle")
	    WebElement labelManageBillingReinstateMemberTitle;
	   
	   @FindBy(xpath="//div[@title='Disclose Items Discussed During Manage Billing Review']")
		private WebElement lnktxtItemsDiscussedManageBillingReview;
	    
	        //TODO
	    //@FindBy(xpath="//span[text()='Items Discussed During Manage Enrollment & Billing Review']")
	   @FindBy(xpath="//*[text()='Items Discussed During Manage Enrollment & Billing Review']")
	    WebElement lableManageBillingReinstateMemberItemsDiscussed;
	    
	    @FindBy(xpath="//div[@node_name='ReviewTaggedItems']/parent::div//table[@id='gridLayoutTable']")
	    WebElement tableManageBillingReinstateReview;

		public ErrorLogger getErr() {
			return err;
		}

		public SeleniumUtilities getUtils() {
			return utils;
		}

		public WebElement getsHeaderCompleteBilling() {
			return sHeaderCompleteBilling;
		}

		public WebElement getIframeelement() {
			return Iframeelement;
		}

		public WebElement getLabelManageBillingReinstateMemberTitle() {
			return labelManageBillingReinstateMemberTitle;
		}

		public WebElement getLableManageBillingReinstateMemberItemsDiscussed() {
			return lableManageBillingReinstateMemberItemsDiscussed;
		}

		public WebElement getTableManageBillingReinstateReview() {
			return tableManageBillingReinstateReview;
		}

		
		
		
		
		
		/**
		 * Checking HEader of the Page 
		 * @param header
		 * @return
		 */
		public boolean validateHeader(WebElement header , String sCheckHEader)
		{
			if(!utils.isProxyWebelement(header))
				if(utils.isvalueMatch_contain(header.getText().trim(), sCheckHEader))
					return true ;
			return false; 
		}
		
		
		
		//Check in Value in the Table 
		
		public boolean clickgetBtnSubmit()
		{
			return utils.clickAnelemnt(this.getBtnSubmit(), "Complete Billing  Review ", "Submit button");
		}
		
		public WebElement getBtnSubmit() {
			return btnSubmit;
		}
		
		@FindBy (xpath="//button[@title='Complete this assignment']")	
		private WebElement btnSubmit;

		
		
		
		// Methods checking the page 
		
		
		/**
		 * Method to check the headers and check the values of the page 
		 * @return
		 */
		public boolean checkReinstateMemberPage()
		{
			utils.waitforpageload();
			if(this.validateHeader(this.getLabelManageBillingReinstateMemberTitle(), "Reinstate Member"))
				if(!utils.isProxyWebelement(labelReinstateMemberAccessMainframe))
					if(!utils.isProxyWebelement(labelReinstateMemberISGMainframe))
						if(this.validateHeader(this.getLableManageBillingReinstateMemberItemsDiscussed(), "Items Discussed During Manage Enrollment & Billing Review"))
							if(this.clickgetBtnSubmit())
								return true;
			return false;
	
		}
		
		public boolean validatetaggedcheckboxes()
		{
			ArrayList<String> actual = null,expected=new ArrayList<String>(); 
			if(utils.clickAnelemnt(this.lnktxtItemsDiscussedManageBillingReview, "Complete Billing", "Items Discussed"))
		
				// GET THE ACTUAL VALUE FROm THE APPLICATION		
				actual=utils.getcolumnStringFromTableByName(this.tableItemsDiscussedDuringManageBillingReview,"Description");
			    actual.remove(0);
			//GET THE EXPECTED VALUE FROM HASHMAP
			    
			for(Map.Entry<String, String> entry:ds.data.entrySet())
				expected.add(entry.getValue());
			
			Collections.reverse(expected);
			
			for(int i=0;i<actual.size();i++)
			{
				System.out.println(actual.get(i)+"---------"+expected.get(i));
				if(actual.get(i).equalsIgnoreCase(expected.get(i)))
					continue;
				else
					return false;
			}
		
			return true;
		}
		
}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

