package automationLib;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;
import stepdefinition.stepdefinition; 

public class AccessDocuments extends Driver {

	SeleniumUtilities utils=new SeleniumUtilities();
	ErrorLogger err=new ErrorLogger();
	BaseLogger blogger = new BaseLogger();


	/**
	 * Constructor for the Access Documents class defining the Iframe and the Page Factory
	 * vinoth-test subba
	 * test -  Gopi
	 */
	public AccessDocuments() throws IOException
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getPgDriver(), 20), this);
		if(!utils.checkIfErrorPage())
		{
			utils.refreshthepage();
		}
		try{
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelement);
	      }catch(Exception e){
		Driver.getPgDriver().switchTo().defaultContent();
		Driver.getPgDriver().switchTo().frame(this.Iframeelementtemp);
		}	
	}
		

	@FindBy(id="PegaGadget3Ifr")
	private WebElement Iframeelement;

	@FindBy(id="PegaGadget2Ifr")
	private WebElement Iframeelementtemp;


	@FindBy(xpath="//a[contains(@name,'AccessDocuments')]")
	WebElement linkAccessDocumentselect;

	@FindBy(xpath="//div[@node_name='AccessDocMemberContractsList']//table[@class='gridTable ']")
	WebElement tblAccessDocumentsCoverage;

	@FindBy(id="EOCDocType")
	WebElement chkbxAccessDocumentEOCDoc;

	@FindBy(id="AmendmentsDocType")
	WebElement chkbxAccessDocumentAmendment;

	@FindBy(id="SBCDocType")
	WebElement chkbxAccessDocumentSBCDoc;

	@FindBy(id="CERT")
	WebElement chkbxAccessDocumentCert;

	@FindBy(id="SOBDocType")
	WebElement chkbxAccessDocumentSOB;

	@FindBy(id="HPDFDocType")
	WebElement chkbxAccessDocumentHDFP;

	@FindBy(id="EnglishLang")
	WebElement chkbxAccessDocumentLanguageEnglish;

	@FindBy(id="SpanishLang")
	WebElement chkbxAccessDocumentLanguageSpanish;

	@FindBy(id="TagalogLang")
	WebElement chkbxAccessDocumentLanguageTagalog;

	@FindBy(id="ChineseLang")
	WebElement chkbxAccessDocumentLanguageChinese;

	@FindBy(id="KoreanLang")
	WebElement chkbxAccessDocumentLanguageKorean;

	@FindBy(id="VietnameseLang")
	WebElement chkbxAccessDocumentLanguageVietnamese;

	@FindBy(xpath="//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']")
	WebElement tableAccessDocumentResulttable;

	@FindBy(id="FulfillmentMethod1")
	WebElement drpdwnDeliveryMethod;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Search']")
	private WebElement btnSearch;

	@FindBy(xpath="//*[@class='pzbtn-mid'][text()='Submit']")
	private WebElement btnSubmit;

	@FindBy(xpath="//textarea[@id='Notes']")
	WebElement txtbxNotes;

	@FindBy(className="actionTitleBarLabelStyle")
	WebElement headerCompleeDocumentReview;

	/**This functionality navigates to the Access Documents page and then selects the coverage type for the member
	 * */
	public boolean selectCoveragetype(String[] coverage)
	{
		this.linkAccessDocumentselect.click();
		String coveragexpath="//div[@node_name='AccessDocMemberContractsList']//table[@class='gridTable ']//*[contains(text(),'"+coverage[0]+"')]";
		utils.waitforpageload();
		Driver.pgDriver.findElement(By.xpath(coveragexpath)).click();
		return true;
	}

	/**This functionality clicks the submit button in the Access Documents page
	 * 
	 * @return
	 */
	public boolean clickgetBtnSubmit()
	{
		return utils.clickAnelemnt(btnSubmit, "AccessDocuments", "btnSubmit");
	}

	/**This functionality verifies the EOC documents with the user specify language and gets the results in the table with the Adobe type document attached and then by performing submit action notes text box is displayed
	 * 
	 * @param language
	 * @return
	 */
	public boolean verifyEOCDoc(String [] language)
	{
		try{
			Boolean varstate=true;
			this.unselectEOCDoc();
			this.unselectenglish();
			if(utils.clickAnelemnt(this.chkbxAccessDocumentEOCDoc, "Access Document", " EOC chkbox"))
			{
				for(String lang:language)
				{
					if(lang.toLowerCase().trim().contains("english"))
					{
						if(!(this.chkbxAccessDocumentLanguageEnglish.isSelected())){
							this.chkbxAccessDocumentLanguageEnglish.click();
							continue;
						}
					}
					else if(lang.toLowerCase().trim().contains("span"))
					{
						this.chkbxAccessDocumentLanguageSpanish.click();
						continue;
					}

					else if(lang.toLowerCase().trim().contains("chinese"))
					{
						this.chkbxAccessDocumentLanguageChinese.click();
						continue;
					}

					else if(lang.toLowerCase().trim().contains("taga"))
					{
						this.chkbxAccessDocumentLanguageTagalog.click();
						continue;
					}

					else if(lang.toLowerCase().trim().contains("korean"))
					{
						this.chkbxAccessDocumentLanguageKorean.click();
						continue;
					}

					else if(lang.toLowerCase().trim().contains("viet"))
					{
						this.chkbxAccessDocumentLanguageVietnamese.click();
						continue;
					}

				}
				if(utils.clickAnelemnt(this.btnSearch, "Access Documents", "Search Button"))
				{
					System.out.println("Click Done");
					wait=new WebDriverWait(Driver.pgDriver,10);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']")));

				}
				else
					System.out.println("table not loaded");
				for(int i=0;i<language.length;i++)
				{
					String[] tablevalues=new String[]{"",language[i],"Evidence of Coverage (EOC)"};
					if(utils.validateRowValues(this.tableAccessDocumentResulttable, tablevalues))
					{
						if(language[i].toLowerCase().contains("english"))
						{
							System.out.println(language[i]);
							int rownum=utils.getRowNumber(this.tableAccessDocumentResulttable, tablevalues);
							String adobe=Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[2]//img")).getAttribute("src");
							if(adobe.contains("adobe"))
							{
								System.out.println("Adobe present");
								Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[1]//img")).click();
								wait=new WebDriverWait(Driver.pgDriver,10);
								WebElement drpdwn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(("FulfillmentMethod"+(i+1)))));
								utils.selectDropDownbyIndex(drpdwn, 2, "Access Document", "Drop down - DeliveryMethod");
							}
							else
							{
								System.out.println("No Adobe");
								varstate=false;
								break;
							}

						}
						else
						{
							System.out.println(language[i]);
							int rownum=utils.getRowNumber(this.tableAccessDocumentResulttable, tablevalues);
							String adobe=Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[2]//img")).getAttribute("src");
							if(adobe.contains("adobe"))
							{
								System.out.println("Adobe present");
								varstate=true;
								break;
							}
							else
								System.out.println("No Adobe");
							Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[1]//img")).click();
							wait = new WebDriverWait(Driver.pgDriver, 10);
							WebElement drpdwn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FulfillmentMethod"+(i+1))));
							utils.selectDropDownbyIndex(drpdwn, 2, "Access Document", "Drop down - DeliveryMethod");
						}
					}
					else
					{
						err.logError("AccessDocuments", "EOC-Row not present ");
					}

				}
				if(!varstate)
				{
					err.logError("AccessDocuments", "The adobe pdf sign was not present ");
					return false;
				}
				utils.clickAnelemnt(this.btnSubmit, "Access Document", "Button-Submit"); 
				return !utils.isProxyWebelement(txtbxNotes);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
			return false;
		}
		return true;
	}



	/**This functionality verifies the Amendments documents with the user specify language and gets the results in the table with the Adobe type document attached and then by performing submit action notes text box is displayed
	 * 
	 * @param language
	 * @return
	 */
	public boolean verifyAmendmentsDoc(String [] language)
	{
		try{
			Boolean varstate=true;
			this.unselectEOCDoc();
			this.unselectenglish();
			if(utils.clickAnelemnt(this.chkbxAccessDocumentAmendment, "Access Document", " Amendment chkbox"))
			{
				for(String lang:language)
				{
					if(lang.toLowerCase().trim().contains("english"))
					{
						if(!(this.chkbxAccessDocumentLanguageEnglish.isSelected())){
							this.chkbxAccessDocumentLanguageEnglish.click();
							continue;
						}
					}
					else if(lang.toLowerCase().trim().contains("spanish"))
					{
						utils.waitforpageload();
						this.chkbxAccessDocumentLanguageSpanish.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("chinese"))
					{
						utils.waitforpageload();
						this.chkbxAccessDocumentLanguageChinese.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("taga"))
					{
						utils.waitforpageload();
						this.chkbxAccessDocumentLanguageTagalog.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("korean"))
					{
						utils.waitforpageload();
						this.chkbxAccessDocumentLanguageKorean.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("viet"))
					{
						utils.waitforpageload();
						this.chkbxAccessDocumentLanguageVietnamese.click();
						continue;
					}
				}
				if(utils.clickAnelemnt(this.btnSearch, "Access Documents", "Search Button"))
				{
					System.out.println("Click Done");
					wait=new WebDriverWait(Driver.pgDriver,10);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']")));
				}
				else
					System.out.println("table not loaded");
				for(int i=0;i<language.length;i++)
				{
					String[] tablevalues=new String[]{"",language[i],"Amendment"};
					if(utils.validateRowValues(this.tableAccessDocumentResulttable, tablevalues))
					{
						if(language[i].toLowerCase().contains("english"))
						{
							System.out.println(language[i]);
							int rownum=utils.getRowNumber(this.tableAccessDocumentResulttable, tablevalues);
							String adobe=Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[2]//img")).getAttribute("src");
							if(adobe.contains("adobe"))
							{
								System.out.println("Adobe present");
								varstate=false;
								break;
							}
							else
							{
								System.out.println("No Adobe");
								Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[1]//img")).click();
								wait = new WebDriverWait(Driver.pgDriver, 10);
								WebElement drpdwn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FulfillmentMethod"+(i+1))));
								utils.selectDropDownbyIndex(drpdwn, 2, "Access Document", "Drop down - DeliveryMethod");
							}
						}
						else
						{
							System.out.println(language[i]);
							int rownum=utils.getRowNumber(this.tableAccessDocumentResulttable, tablevalues);
							String adobe=Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[2]//img")).getAttribute("src");
							if(adobe.contains("adobe"))
							{
								System.out.println("Adobe present");
								varstate=false;
								break;
							}
							else
								System.out.println("No Adobe");
							Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[1]//img")).click();
							wait = new WebDriverWait(Driver.pgDriver, 10);
							WebElement drpdwn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FulfillmentMethod"+(i+1))));
							utils.selectDropDownbyIndex(drpdwn, 2, "Access Document", "Drop down - DeliveryMethod");
						}
					}
					else
					{
						System.out.println("Row not found "+tablevalues);
						err.logError("AccessDocuments", "EOC-Row not present ");
						return false;
					}
				}
				if(!varstate)
				{
					err.logError("AccessDocuments", "The adobe pdf sign is present ");
					return false;
				}

				utils.clickAnelemnt(this.btnSubmit, "Access Document", "Button-Submit"); 
				return !utils.isProxyWebelement(txtbxNotes);
			}

		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
			return false;
		}
		return true;
	}

	/**This functionality verifies the SBC documents with the user specify language and gets the results in the table with the Adobe type document attached and then by performing submit action notes text box is displayed
	 * 
	 * @param language
	 * @return
	 */
	public boolean verifySBCDoc(String [] language)
	{
		try{
			Boolean varstate=true;
			this.unselectEOCDoc();
			this.unselectenglish();
			if(utils.clickAnelemnt(this.chkbxAccessDocumentSBCDoc, "Access Document", " EOC chkbox"))
			{
				for(String lang:language)
				{
					if(lang.toLowerCase().trim().contains("english"))
					{
						if(!(this.chkbxAccessDocumentLanguageEnglish.isSelected())){
							this.chkbxAccessDocumentLanguageEnglish.click();
							continue;
						}
					}
					else if(lang.toLowerCase().trim().contains("spanish"))
					{
						this.chkbxAccessDocumentLanguageSpanish.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("chinese"))
					{
						this.chkbxAccessDocumentLanguageChinese.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("taga"))
					{
						this.chkbxAccessDocumentLanguageTagalog.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("korean"))
					{
						this.chkbxAccessDocumentLanguageKorean.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("viet"))
					{
						this.chkbxAccessDocumentLanguageVietnamese.click();
						continue;
					}
				}
				if(utils.clickAnelemnt(this.btnSearch, "Access Documents", "Search Button"))
				{
					System.out.println("Click Done");
					wait=new WebDriverWait(Driver.pgDriver,10);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']")));
				}
				else
					System.out.println("table not loaded");
				for(int i=0;i<language.length;i++)
				{
					String[] tablevalues=new String[]{"",language[i],"Summary of Benefits and Coverage (SBC)"};
					if(utils.validateRowValues(this.tableAccessDocumentResulttable, tablevalues))
					{
						if(language[i].toLowerCase().contains("english"))
						{
							System.out.println(language[i]);
							int rownum=utils.getRowNumber(this.tableAccessDocumentResulttable, tablevalues);
							String adobe=Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[2]//img")).getAttribute("src");
							if(adobe.contains("adobe"))
							{
								System.out.println("Adobe present");
								Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[1]//img")).click();
								wait = new WebDriverWait(Driver.pgDriver, 10);
								WebElement drpdwn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FulfillmentMethod"+(i+1))));
								utils.selectDropDownbyIndex(drpdwn, 2, "Access Document", "Drop down - DeliveryMethod");
							}
							else
							{
								blogger.logserviceDown();
								varstate=false;
								break;
							}
						}
						else
						{
							System.out.println(language[i]);
							int rownum=utils.getRowNumber(this.tableAccessDocumentResulttable, tablevalues);
							String adobe=Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[2]//img")).getAttribute("src");
							if(adobe.contains("adobe"))
							{
								System.out.println("Adobe present");
								varstate=false;
								break;
							}
							else
								System.out.println("No Adobe");
							Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[1]//img")).click();
							wait = new WebDriverWait(Driver.pgDriver, 10);
							WebElement drpdwn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FulfillmentMethod"+(i+1))));
							utils.selectDropDownbyIndex(drpdwn, 2, "Access Document", "Drop down - DeliveryMethod");
						}
					}
					else
					{
						System.out.println("Row not found "+tablevalues);
						err.logError("AccessDocuments", "EOC-Row not present ");
						return false;
					}
				}
				if(!varstate)
				{
					err.logError("AccessDocuments", "The adobe pdf sign is present ");
					return false;
				}
				utils.clickAnelemnt(this.btnSubmit, "Access Document", "Button-Submit"); 
				return !utils.isProxyWebelement(txtbxNotes);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
			return false;
		}
		return true;
	}


	/**This functionality verifies the SBC documents with the user specify language and gets the results in the table with the Adobe type document attached and then by performing submit action notes text box is displayed">
	 * 
	 * @param language
	 * @return
	 */
	public boolean verifyCertDoc(String [] language)
	{
		try{
			Boolean varstate=true;
			this.unselectEOCDoc();
			this.unselectenglish();
			if(utils.clickAnelemnt(this.chkbxAccessDocumentCert, "Access Document", " EOC chkbox"))
			{
				for(String lang:language)
				{
					if(lang.toLowerCase().trim().contains("english"))
					{
						if(!(this.chkbxAccessDocumentLanguageEnglish.isSelected())){
							this.chkbxAccessDocumentLanguageEnglish.click();
							continue;
						}
					}
					else if(lang.toLowerCase().trim().contains("spanish"))
					{
						this.chkbxAccessDocumentLanguageSpanish.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("chinese"))
					{
						this.chkbxAccessDocumentLanguageChinese.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("taga"))
					{
						this.chkbxAccessDocumentLanguageTagalog.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("korean"))
					{
						this.chkbxAccessDocumentLanguageKorean.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("viet"))
					{
						this.chkbxAccessDocumentLanguageVietnamese.click();
						continue;
					}
				}
				if(utils.clickAnelemnt(this.btnSearch, "Access Documents", "Search Button"))
				{
					System.out.println("Click Done");
					wait=new WebDriverWait(Driver.pgDriver,10);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']")));
				}
				else
					System.out.println("table not loaded");
				for(int i=0;i<language.length;i++)
				{
					String[] tablevalues=new String[]{"",language[i],"CERT"};
					if(utils.validateRowValues(this.tableAccessDocumentResulttable, tablevalues))
					{
						if(language[i].toLowerCase().contains("english"))
						{
							System.out.println(language[i]);
							int rownum=utils.getRowNumber(this.tableAccessDocumentResulttable, tablevalues);
							String adobe=Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[2]//img")).getAttribute("src");
							if(adobe.contains("adobe"))
							{
								System.out.println("Adobe present");
								varstate=false;
							}
							else
							{
								System.out.println("No Adobe");
								Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[1]//img")).click();
								wait = new WebDriverWait(Driver.pgDriver, 10);
								WebElement drpdwn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FulfillmentMethod"+(i+1))));
								utils.selectDropDownbyIndex(drpdwn, 2, "Access Document", "Drop down - DeliveryMethod");
							}
						}
						else
						{
							System.out.println(language[i]);
							int rownum=utils.getRowNumber(this.tableAccessDocumentResulttable, tablevalues);
							String adobe=Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[2]//img")).getAttribute("src");
							if(adobe.contains("adobe"))
							{
								System.out.println("Adobe present");
								varstate=false;
							}
							else
								System.out.println("No Adobe");
							Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[1]//img")).click();
							wait = new WebDriverWait(Driver.pgDriver, 10);
							WebElement drpdwn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FulfillmentMethod"+(i+1))));
							utils.selectDropDownbyIndex(drpdwn, 2, "Access Document", "Drop down - DeliveryMethod");
						}
					}
					else
					{
						System.out.println("Row not found "+tablevalues);
						err.logError("AccessDocuments", "EOC-Row not present ");
						return false;
					}
				}
				if(!varstate)
				{
					err.logError("AccessDocuments", "The adobe pdf sign is present ");
					return false;
				}
				utils.clickAnelemnt(this.btnSubmit, "Access Document", "Button-Submit"); 
				return !utils.isProxyWebelement(txtbxNotes);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
			return false;
		}
		return true;
	}

	/**This functionality verifies the SOB documents with the user specify language and gets the results in the table with the Adobe type document attached and then by performing submit action notes text box is displayed
	 * 
	 * @param language
	 * @return
	 */

	public boolean verifySOBDoc(String [] language)
	{
		try{
			Boolean varstate=true;
			this.unselectEOCDoc();
			this.unselectenglish();
			if(utils.clickAnelemnt(this.chkbxAccessDocumentSOB, "Access Document", " SOB chkbox"))
			{
				for(String lang:language)
				{
					if(lang.toLowerCase().trim().contains("english"))
					{
						if(!(this.chkbxAccessDocumentLanguageEnglish.isSelected())){
							this.chkbxAccessDocumentLanguageEnglish.click();
							continue;
						}
					}
					else if(lang.toLowerCase().trim().contains("spanish"))
					{
						this.chkbxAccessDocumentLanguageSpanish.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("chinese"))
					{
						this.chkbxAccessDocumentLanguageChinese.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("taga"))
					{
						this.chkbxAccessDocumentLanguageTagalog.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("korean"))
					{
						this.chkbxAccessDocumentLanguageKorean.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("viet"))
					{
						this.chkbxAccessDocumentLanguageVietnamese.click();
						continue;
					}
				}
				if(utils.clickAnelemnt(this.btnSearch, "Access Documents", "Search Button"))
				{
					System.out.println("Click Done");					
					wait=new WebDriverWait(Driver.pgDriver,20);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']")));
				}
				else{
					System.out.println("table not loaded");
				}
				for(int i=0;i<language.length;i++)
				{
					String[] tablevalues=new String[]{"","Summary of Benefits (SOB)",language[i]};
					if(utils.validateRowValues(this.tableAccessDocumentResulttable, tablevalues))
					{
						if(language[i].toLowerCase().contains("english"))
						{
							System.out.println(language[i]);
							int rownum=utils.getRowNumber(this.tableAccessDocumentResulttable, tablevalues);
							String adobe=Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[2]//img")).getAttribute("src");
							if(adobe.contains("adobe"))
							{
								System.out.println("Adobe present");
								err.logerrormessage("Adobe present");

								varstate=false;
							}
							else
							{
								System.out.println("No Adobe");
								Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[1]//img")).click();
								wait = new WebDriverWait(Driver.pgDriver, 10);
								WebElement drpdwn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FulfillmentMethod"+(i+1))));
								utils.selectDropDownbyIndex(drpdwn, 2, "Access Document", "Drop down - DeliveryMethod");

							}
						}
						else
						{
							System.out.println(language[i]);
							int rownum=utils.getRowNumber(this.tableAccessDocumentResulttable, tablevalues);
							System.out.println("gsagdjsagjdad sagdgsha   gasgdsa viett  "+rownum);
							System.out.println("gsagdjsagjdad sagdgsha   gasgdsa  "+rownum);
							String adobe=Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[2]//img")).getAttribute("src");
							if(adobe.contains("adobe"))
							{
								System.out.println("Adobe present");
								varstate=false;
							}
							else{
								System.out.println("No Adobe");

								Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[1]//img")).click();
								wait = new WebDriverWait(Driver.pgDriver, 10);
								WebElement drpdwn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FulfillmentMethod"+(i+1))));
								utils.selectDropDownbyIndex(drpdwn, 2, "Access Document", "Drop down - DeliveryMethod");
							}
						}
					}
					else
					{
						System.out.println("Row not found "+tablevalues);
						err.logError("AccessDocuments", "EOC-Row not present ");
						return false;
					}
				}			
				if(!varstate)
				{
					err.logError("AccessDocuments", "The adobe pdf sign is present ");
					return false;
				}
				utils.clickAnelemnt(this.btnSubmit, "Access Document", "Button-Submit"); 
				return !utils.isProxyWebelement(txtbxNotes);
			}	
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
			return false;
		}
		return true;
	}


/**This functionality verifies the HPDF documents with the user specify language and gets the results in the table with the Adobe type document attached and then by performing submit action notes text box is displayed
 * 
 * @param language
 * @return
 */
	public boolean verifyHPDFDoc(String [] language)
	{
		utils.waitforpageload();
		try{
			Boolean varstate=true;
			this.unselectEOCDoc();
			this.unselectenglish();
			if(utils.clickAnelemnt(this.chkbxAccessDocumentHDFP, "Access Document", " HPDF chkbox"))
			{
				for(String lang:language)
				{
					if(lang.toLowerCase().trim().contains("english"))
					{
						if(!(this.chkbxAccessDocumentLanguageEnglish.isSelected())){
							this.chkbxAccessDocumentLanguageEnglish.click();
							continue;
						}
					}
					else if(lang.toLowerCase().trim().contains("spanish"))
					{
						this.chkbxAccessDocumentLanguageSpanish.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("chinese"))
					{
						this.chkbxAccessDocumentLanguageChinese.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("taga"))
					{
						this.chkbxAccessDocumentLanguageTagalog.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("korean"))
					{
						this.chkbxAccessDocumentLanguageKorean.click();
						continue;
					}
					else if(lang.toLowerCase().trim().contains("viet"))
					{
						this.chkbxAccessDocumentLanguageVietnamese.click();
						continue;
					}
				}
				if(utils.clickAnelemnt(this.btnSearch, "Access Documents", "Search Button"))
				{
					System.out.println("Click Done");
					wait=new WebDriverWait(Driver.pgDriver,10);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']")));
				}
				else
					System.out.println("table not loaded");
				for(int i=0;i<language.length;i++)
				{
					String[] tablevalues=new String[]{"",language[i],"Health Benefit Plan Description Form (HPDF)"};
					Thread.sleep(1000);
					if(utils.validateRowValues(this.tableAccessDocumentResulttable, tablevalues))
					{
						if(language[i].toLowerCase().contains("english"))
						{
							System.out.println(language[i]);
							int rownum=utils.getRowNumber(this.tableAccessDocumentResulttable, tablevalues);
							String adobe=Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[2]//img")).getAttribute("src");
							if(adobe.contains("adobe"))
							{
								System.out.println("Adobe present");
								varstate=false;
							}
							else
							{
								System.out.println("No Adobe");
								Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[1]//img")).click();
								wait = new WebDriverWait(Driver.pgDriver, 10);
								WebElement drpdwn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FulfillmentMethod"+(i+1))));
								utils.selectDropDownbyIndex(drpdwn, 2, "Access Document", "Drop down - DeliveryMethod");
							}
						}
						else
						{
							System.out.println(language[i]);
							int rownum=utils.getRowNumber(this.tableAccessDocumentResulttable, tablevalues);
							String adobe=Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[2]//img")).getAttribute("src");
							if(adobe.contains("adobe"))
							{
								System.out.println("Adobe present");
								varstate=false;
							}
							else
								System.out.println("No Adobe");
							Driver.pgDriver.findElement(By.xpath("//*[@node_name='AccessDocSearchResults']//table[@class='gridTable ']//tr["+rownum+"]//td[1]//img")).click();
							wait = new WebDriverWait(Driver.pgDriver, 10);
							WebElement drpdwn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FulfillmentMethod"+(i+1))));
							utils.selectDropDownbyIndex(drpdwn, 2, "Access Document", "Drop down - DeliveryMethod");
						}
					}
					else
					{
						System.out.println("Row not found "+tablevalues[2]);
						err.logError("AccessDocuments", "EOC-Row not present ");
						return false;
					}
				}
				if(!varstate)
				{
					err.logError("AccessDocuments", "The adobe pdf sign is present ");
					return false;
				}
				utils.clickAnelemnt(this.btnSubmit, "Access Document", "Button-Submit"); 
				return !utils.isProxyWebelement(txtbxNotes);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
			return false;
		}
		return true;
	}
	
	public void unselectEOCDoc() throws InterruptedException{
		if(this.chkbxAccessDocumentEOCDoc.isSelected())	{
			utils.clickAnelemnt(this.chkbxAccessDocumentEOCDoc, "Access Document", " EOC DOC");
			Thread.sleep(1000);
		}
	}
	
	public void unselectenglish() throws InterruptedException{
		if((this.chkbxAccessDocumentLanguageEnglish.isSelected())){
			Thread.sleep(1000);
			this.chkbxAccessDocumentLanguageEnglish.click();
		}
	}
	
	
	@FindBy(id="EvidenceOfCoverageAvailableYes")
	WebElement rdbEvidenceOfCoverageAvailableYes;
	
	
	@FindBy(xpath="//div[contains(@class,'content-item content-paragraph item-2')]//div//span")
	WebElement txtInstructionalMsgForNo;
	
	@FindBy(xpath="//div[@section_index='7']//div/p")
	WebElement txtInstructionalMsgForYes;
	
	@FindBy(id="EvidenceOfCoverageAvailableNo")
	WebElement rdbEvidenceOfCoverageAvailableNo;
	
	public boolean isEOCAvailable(String args[]){
		if(args[0].equalsIgnoreCase("Yes"))
			return utils.clickAnelemnt(rdbEvidenceOfCoverageAvailableYes, "Access Document", " EOC DOC");
		else if(args[0].equalsIgnoreCase("No"))
		return utils.clickAnelemnt(rdbEvidenceOfCoverageAvailableNo,"Access Document", " EOC DOC");
		else 
			return false;
	}
	
	public boolean validateInstructionalTextNo(String args[]){
		return utils.validateLabel(txtInstructionalMsgForNo, args[0]);
	}
	
	public boolean validateInstructionalTextYes(String args[]){
		
	/*	String value=this.txtInstructionalMsgForYes.getText().replaceAll("/n", " ");
		System.out.println("The Text is:"+value);
		return utils.isvalueMatch_contain(args[0], value);
		*/
		String actualText = args[0];
		System.out.println("Actual Text: "+actualText);
		String expectedText = txtInstructionalMsgForYes.getText().trim();
		String expectedtext1=expectedText.replaceAll("\n","");
		System.out.println("Expected Text: "+expectedtext1);
		return utils.isvalueMatch_contain(actualText, expectedtext1);
	}
	
	

	
	@FindBy(id="EvidenceOfCoverageTypeMail")
	WebElement rdbMail;
	
	@FindBy(id="EvidenceOfCoverageTypeEmail")
	WebElement rdbEmail;
	
	@FindBy(xpath="//input[@data-test-id='201904111115350745113445']")
	WebElement txtPrfdContact;
	
	@FindBy(xpath="//input[@data-test-id='20190411141617016296530']")
	WebElement txtPrfdEmail;
	
	public boolean clickOnMailOrEmail(String args[]){
		if(args[0].equalsIgnoreCase("Mail"))
			return utils.clickAnelemnt(rdbMail, "Access Document", "Mail");
		else if(args[0].equalsIgnoreCase("Email"))
		return utils.clickAnelemnt(rdbEmail,"Access Document", " Email");
		else 
			return false;
	}
	
	public boolean enterPreferredContactNumber(String args[])
	{
		return utils.enterTextinAnelemnt(txtPrfdContact, args[0], "Access Document","Number");
	}
	
	public boolean enterPreferredEmail(String args[])
	{
		return utils.enterTextinAnelemnt(txtPrfdEmail, args[0], "Access Document","Email");
	}
}
