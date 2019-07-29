package automationLib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class ExelaApplication {

	ErrorLogger err= new ErrorLogger();
	SeleniumUtilities utils= new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();
	Actions action=new Actions(Driver.getPgDriver());

	public ExelaApplication()
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
	}

	@FindBy(id="UserName")
	WebElement UserName;

	@FindBy(id="Password")
	WebElement Password;

	@FindBy(id="IdLocation")
	WebElement IdLocation;

	@FindBy(xpath="//input[@type='submit']")
	WebElement LogOnButton;

	/**Launch EXELA url
	 * 
	 */
	public boolean launchExelaAndLogin(String[] args) throws InterruptedException{
		//Thread.sleep(50000);
		Driver.pgDriver.get("https://anthemvruat.exelaonline.com/");
		utils.waitforpageload();
		if(utils.enterTextinAnelemnt(UserName, args[0], "ExelaApplication", "UserName"))
			if(utils.enterTextinAnelemnt(Password, args[1], "ExelaApplication", "Password"))
				if(utils.selectDropDownbyVisibleString(IdLocation, args[2], "ExelaApplication", "IdLocation"))
					return utils.clickAnelemnt(LogOnButton, "ExelaApplication", "LogOnButton");
		return false;
	}

	@FindBy(xpath="//a[contains(text(),'Upload')]")
	WebElement UploadLink;

	@FindBy(id="DocumentTypeId")
	WebElement DocumentType;

	@FindBy(xpath="//label[text()='WellPoint Received Date:  *']/following-sibling::input")
	WebElement ReceivedDate;

	@FindBy(id="processing_system")
	WebElement ProcessingSystem;

	@FindBy(id="rendering_provider_name")
	WebElement RenderingProviderName;

	@FindBy(id="rendering_provider_npi")
	WebElement RenderingProviderNPI;

	@FindBy(id="date_of_service")
	WebElement DateOfService;

	@FindBy(id="btnsubmit")
	WebElement SubmitButton;

	@FindBy(id="FileUpload")
	WebElement FileUpload;

	@FindBy(xpath="//span[text()=' Document uploaded successfully !!']")
	WebElement SuccessMessage;

	/**Click on Upload Link
	 * 
	 * @return
	 */
	public boolean clickUploadLink() {
		return utils.clickAnelemnt(UploadLink, "ExelaApplication", "UploadLink");
	}

	/**Select Document Type, Enter CoverSheet Information and Clicks Submit
	 * @throws ParseException 
	 * 
	 */
	public boolean enterCoverSheetInfoFromServiceReqDetails() throws ParseException {
		Map<String,String> map = ReviewServiceRequest.map;

		if(utils.selectDropDownbyVisibleString(DocumentType, "Member Submitted", "ExelaApplication", "DocumentType"))
			if(utils.selectDropDownbyVisibleString(ProcessingSystem, map.get("ProcessingSystem"), "ExelaApplication", "ProcessingSystem"))
				if(utils.enterTextinAnelemnt(DateOfService, dateformat(map.get("DateOfService")), "ExelaApplication", "DateOfService"))
					if(utils.enterTextinAnelemnt(RenderingProviderName, map.get("RenderingProviderName"), "ExelaApplication", "RenderingProviderName"))
						if(utils.enterTextinAnelemnt(RenderingProviderNPI, map.get("RenderingProviderNpi"), "ExelaApplication", "RenderingProviderNPI"))
							if(utils.enterTextinAnelemnt(ReceivedDate, dateformat(map.get("ReceivedDate")), "ExelaApplication", "ReceivedDate"))
								if(utils.enterTextinAnelemnt(FileUpload, ReviewServiceRequest.pathWithFileName, "ExelaApplication", "FileUpload"))
									if(utils.clickAnelemnt(SubmitButton, "ExelaApplication", "SubmitButton"))
										return !utils.isProxyWebelement(SuccessMessage);
		return false;
	}

	public String dateformat(String date) throws ParseException {
		Date dateformat = new SimpleDateFormat("MM/dd/yyyy").parse(date);
		SimpleDateFormat newFormat = new SimpleDateFormat("MM/dd/yy");
		String finaldate = newFormat.format(dateformat);
		return finaldate;
	}

	@FindBy(xpath="//table[@class='jtable']//tr//td//a")
	List<WebElement> TransactionID;

	@FindBy(xpath="//li[@class='first active']//a[contains(text(),'Log')]")
	WebElement LogButton;

	/**Get Latest Trasaction ID
	 * 
	 * @return
	 */
	public boolean getLatestTransactionID() {
		if(utils.clickAnelemnt(LogButton, "ExelaApplication", "LogButton")) {
			String transactionID = TransactionID.get(0).getText();
			blogger.loginfo("Transaction ID Generated: "+transactionID);
			return true;
		}
		return false;
	}

	@FindBy(id="member_id")
	WebElement MemberID;

	/**Clicks the Message ID and validates the details populated
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean clickAndValidateTheMessageIDDetails() throws InterruptedException {
		boolean flag = false;
		Map<String,String> map = ReviewServiceRequest.map;

		for(int i=0;i<TransactionID.size();i++) {
			if(TransactionID.get(i).getText().equalsIgnoreCase(map.get("MessageID")))
				flag = utils.clickAnelemnt(TransactionID.get(i), "ExelaApplication", "TransactionID");
		}
		if(flag) {
			Thread.sleep(1000);
			System.out.println(ProcessingSystem.getAttribute("value"));
			System.out.println(MemberID.getAttribute("value"));
			if(utils.isvalueMatch_contain(ProcessingSystem.getAttribute("value"), map.get("ProcessingSystem")))
				if(utils.isvalueMatch_contain(MemberID.getAttribute("value"), map.get("MemberID")))
					return true;
		}
		return false;


	}


}
