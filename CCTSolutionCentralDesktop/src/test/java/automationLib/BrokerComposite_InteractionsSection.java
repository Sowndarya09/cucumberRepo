package automationLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class BrokerComposite_InteractionsSection {


	SeleniumUtilities utils = new SeleniumUtilities();

	BaseLogger blogger = new BaseLogger();
	ErrorLogger err=new ErrorLogger();

	WebDriverWait wait;
	
	public BrokerComposite_InteractionsSection()
	
	{
		try
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			if(utils.isAlertPresent())
			{
				Driver.pgDriver.switchTo().alert().accept();
			}
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement);

		}catch(Exception e)
		{
			PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
			Driver.getPgDriver().switchTo().defaultContent();
			Driver.getPgDriver().switchTo().frame(this.Iframeelement); 
		}
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Recent Inquiry Tracking')]")
	WebElement labelRecentInquiryTracking;
	
	@FindBy(xpath="//span[contains(text(),'Related/Linked Interactions')]")
	WebElement labelRelatedInteractions;
	
	@FindBy(xpath="//span[contains(text(),'Search for Service Requests for Contract')]")
	WebElement labelSearchForServiceRequest;
	
	
	@FindBy(id="PegaGadget1Ifr")
	WebElement Iframeelement;
	
	
	public boolean verifySearchForServiceRequestsForContractIsNotDispalyed()
	{
		return utils.isProxyWebelement(labelSearchForServiceRequest);
	}
	
	public boolean verifyRelatedLinkedInteractionsIsNotDispalyed()
	{
		return utils.isProxyWebelement(labelRelatedInteractions);
	}
	
	@FindBy(xpath="//span[text()='Recent Inquiry Tracking']")
	WebElement RecentInquiryTracking;
	
	/**This functionality verifies that the Recent inquiry tracking sub section is not displayed under interactions tab
	 * 
	 */
	public boolean verifyRecentInquiryTrackingIsNotDisplayed() {
		return utils.isProxyWebelement(RecentInquiryTracking);
	}
	
	@FindBy(xpath="//table[@pl_prop='D_RecentServiceItemsForGroup.pxResults']")
	WebElement TableOpenServiceRequest;
	
	/**This functionality validates the open service requests information in the open service requests subsection
	 * 
	 * @param args
	 * @return
	 */
	public boolean verifyOpenServiceRequests(String[] args) {
		return utils.validatetablerowbasedonvalues(TableOpenServiceRequest, args);
	}
	
	@FindBy(xpath="//table[@pl_prop='D_BrokerInteractions.pxResults']")
	WebElement TableRecentInteraction;
	
	/**This functionality validates the recent interactions information in the recent interactions subsection
	 * 
	 * @param args
	 * @return
	 */
	public boolean verifyRecentInteractions(String[] args) {
		return utils.validatetablerowbasedonvalues(TableRecentInteraction, args);
	}
	
	@FindBy(xpath="//table[@pl_prop='']")
	WebElement TableMemberView;
	
	/**This functionality validates the member 360 view information in the member 360 view subsection
	 * 
	 * @param args
	 * @return
	 */
	public boolean verifyMember360View(String[] args) {
		return utils.validatetablerowbasedonvalues(TableMemberView, args);
	}
	
	
	
}
