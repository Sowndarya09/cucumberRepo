package automationLib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.BaseLogger;
import utils.DataSet;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

/**
 * Methods for Accept Payment Page
 * 
 * @author AF02876 test
 */

public class ProviderLinks {

	/**
	 * Methods in the Program test
	 */
	DataSet ds = new DataSet();
	ErrorLogger err = new ErrorLogger();
	SeleniumUtilities utils = new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();

	@FindBy(id = "PegaGadget2Ifr")
	private WebElement Iframeelement;

	/**
	 * Constructor for the Create Promised Action class defining the Iframe and
	 * the Page Factory
	 */
	public ProviderLinks() throws IOException {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		Driver.getPgDriver().switchTo().defaultContent();
		gotoLastIframe();
	}

	public ErrorLogger getErr() {
		return err;
	}

	public SeleniumUtilities getUtils() {
		return utils;
	}

	public WebElement getIframeelement() {
		return Iframeelement;
	}

	public boolean validateHostLinksInProviderLinks() {

		boolean flag = false;

		String[] args = { "Alpha Prefix Router", "Anthem Central & West Host SharePoint Site", "BPM Framework",
				"DRG Calculator", "Inter-Plan Programs Directory", "Jira Software", "MBU Virtual Rescan",
				"McKesson | CXT V4.4 Claim processed prior to 12/03/18",
				"McKesson | CXT V6.0 Claim processed on or after 12/03/18",
				"National Plan & Provider Enumeration System (NPPES)  NPI Registry", "Plan to Plan Chat",
				"RightFax (FAXMO3)" };

		for (int i = 0; i < args.length;i++) {
			String webelement = "//a[text()='" + args[i] + "']";
			flag = !utils.isProxyWebelement(Driver.getPgDriver().findElement(By.xpath(webelement)));
			if (!flag){
				blogger.loginfo("Link" + args[i] + "is not available");
			return false;
		}
		}
		if (flag) {
			blogger.loginfo("All Links are available");
			return true;
		} else {
			blogger.loginfo("Failed to validate links");
			return false;
		}

	}
	@FindBy(xpath="//iframe")
	private List<WebElement> iframes;

	public void gotoLastIframe(){
		System.out.println("1");
		Driver.getPgDriver().switchTo().defaultContent();
		System.out.println("2");
		
		int i=this.iframes.size();
		System.out.println(i);
		Driver.getPgDriver().switchTo().frame(i-1);
		System.out.println("##########");
	}

}
