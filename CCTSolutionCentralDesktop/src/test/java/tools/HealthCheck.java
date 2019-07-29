package tools;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import automationLib.Driver;
import extentmanager.ExtentManager;

@SuppressWarnings("serial")
public class HealthCheck extends JFrame{
	/**
	 * 
	 */
	static BufferedReader textReader;
	static BufferedReader textReader1;
	static BufferedReader textReader2;
	static FileReader reader;
	static FileReader reader1;
	static FileReader reader2;
	WebDriver driver = Driver.getPgDriver();
	static String reportLocation;
	static Date date=new Date();
	static String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
	static ArrayList<String> arraylist = new ArrayList<>();
	static Map<String, String> resultmap = new HashMap<String, String>();
	JPanel jp3;
	JPanel jp1;
	JLabel label1;
	JTextField textfield1;
	JLabel label2;
	JTextField textfield2;
	JButton startbutton;
	JButton clearbutton ;
	JComboBox browser;
	JButton browsebutton;
	JButton donebutton;
	static String reportname;
	static ExtentTest  logger;
	static ExtentReports reports ;


	public static void main(String args[]) throws Exception {
		/**Set the look and feel*/
		com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme("Black");
		UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");

		/** Log file */
		String logfilepath = System.getProperty("user.dir")+"\\src\\test\\java\\utils\\";
		File file = new File(logfilepath+"logs.txt"); 
		FileOutputStream fos = new FileOutputStream(file, true);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);

		HealthCheck tp = new HealthCheck();
		tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tp.setVisible(true);
		System.out.println("==================================="+date+"================================");
	}


	public HealthCheck() throws IOException {
		/**Frame title, position and size*/
		setTitle("Health Check");
		//setSize(600, 110);
		setSize(600, 150);
		setLocationRelativeTo(null);

		/**Set Panel and add elements*/
		jp1 = new JPanel();
		jp3 = new JPanel(new GridLayout(10, 1));
		JTabbedPane jtp = new JTabbedPane();
		label1 = new JLabel("Enter Application URL: ");
		textfield1 = new JTextField(15);

		String[] browserlist = {"IE", "Chrome", "Firefox"};
		browser = new JComboBox(browserlist);

		/**Buttons listed and actions to be performed when clicked*/
		clearbutton = new JButton("CLEAR");
		startbutton = new JButton("START");
		browsebutton = new JButton("BROWSE");
		donebutton = new JButton("SCAN");

		startbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String url = textfield1.getText();
				String selectedBrowser = (String) browser.getSelectedItem();
				if(!url.equalsIgnoreCase("")) {
					System.out.println("Initiating Browser...");
					try {
						Driver.setPgDriver(selectedBrowser);
						Driver.setUrl(url);
					} catch (Exception e1) {
						e1.printStackTrace();
					}


					label1.setVisible(false);
					textfield1.setVisible(false);
					browser.setVisible(false);
					startbutton.setVisible(false);
					clearbutton.setVisible(false);

					label2 = new JLabel("Select Page File You Want To Navigate: ");
					textfield2 = new JTextField(15);
					label2.setVisible(true);
					textfield2.setVisible(true);


					browsebutton.setVisible(true);
					browsebutton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							/*							try {
								UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
							} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
									| UnsupportedLookAndFeelException e1) {
								e1.printStackTrace();
							}
							 */
							JFileChooser chooser = new JFileChooser();
							chooser.setCurrentDirectory(new File (System.getProperty("user.dir")));
							chooser.setMultiSelectionEnabled(false);
							if (chooser.showOpenDialog(browsebutton) == JFileChooser.APPROVE_OPTION) {
								File file = chooser.getSelectedFile();
								if (file == null) {
									return;
								}
								textfield2.setText(file.toString());
							}

						}
					});


					donebutton.setVisible(true);
					donebutton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String filename = textfield2.getText();
							if(!filename.equalsIgnoreCase("")) {
								try {
									readFromFileAndVerifyElementPresent(donebutton, filename,driver);
								} catch (ClassNotFoundException e1) {
									e1.printStackTrace();
								}
							}else {
								JOptionPane.showMessageDialog(donebutton, "Enter Java file path", "Alert", JOptionPane.OK_OPTION);
							}
						}
					});


					jp1.add(label2);
					jp1.add(textfield2);
					jp1.add(browsebutton);
					jp1.add(donebutton);

				}else {
					JOptionPane.showMessageDialog(startbutton, "Enter Application url to launch browser", "Alert", JOptionPane.OK_OPTION);
				}

			}
		});

		/**Clears text in the text box*/
		clearbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textfield1.setText("");
			}
		});

		ChangeListener changeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
				int index = sourceTabbedPane.getSelectedIndex();
				if(sourceTabbedPane.getTitleAt(index).equalsIgnoreCase("Reports"))
					try {
						jp3.removeAll();
						readFromFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		};

		JScrollPane panelPane = new JScrollPane(jp3);
		panelPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelPane.setBounds(50, 30, 300, 50);


		/**Add all components in Panel*/
		jp1.add(label1);
		jp1.add(textfield1);
		jp1.add(browser);
		jp1.add(startbutton); 
		jp1.add(clearbutton);

		/**Add components in Frame*/
		jtp.addChangeListener(changeListener);
		jtp.add("Scan", jp1);
		jtp.add("Reports", panelPane);
		add(jtp);
	}



	private JLabel readFromFile() throws IOException{
		JLabel link = null;
		try{	
			for(int i=0;i<arraylist.size();i++) {
				System.out.println(arraylist.get(i));
				link = new JLabel("<HTML><p><FONT color=\"#000099\"><U>"+arraylist.get(i)+"</U></FONT><br /></p></HTML>");
				link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				String filename =link.getText();
				link.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						String value = filename.substring(filename.indexOf("U>")+1,filename.indexOf("</U>")).trim();
						String value1 = value.replaceAll(">", "");
						System.out.println(value1);
						if (e.getClickCount() > 0) {
							if (Desktop.isDesktopSupported()) {
								Desktop desktop = Desktop.getDesktop();
								try {
									URI uri = new URI("file:///C:/HealthCheck_Reports/"+value1);
									desktop.browse(uri);
								} catch (Exception ex) {

								} 
							}
						}
					}
				});
				jp3.add(link);

			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return link;
	}


	public void readFromFileAndVerifyElementPresent(JButton button, String javaFileName,WebDriver driver) throws ClassNotFoundException{

		int numberOfLines = 0;
		String[] path1 = javaFileName.split(Pattern.quote("\\"));
		String path2 = path1[path1.length-1];
		String[] path3 = path2.split("\\.");
		int result = JOptionPane.showConfirmDialog(this, "Navigate To Page and Start Scan by Clicking 'OK'",
				"alert", JOptionPane.OK_CANCEL_OPTION);
		System.out.println("RESULT: "+result);
		if(result==0) {
			try {
				System.out.println("Verifying Elements present...");
				numberOfLines = readLines(Driver.getPgDriver(), javaFileName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("No of Element present and verified: "+numberOfLines+"\n");
			JLabel link = new JLabel("<HTML><FONT color=\"#000099\"><U>Click here</U></FONT>\r\n" + " for latest report</HTML>       \n");

			link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			link.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() > 0) {
						if (Desktop.isDesktopSupported()) {
							Desktop desktop = Desktop.getDesktop();
							try {
								URI uri = new URI("file:///C:/HealthCheck_Reports/"+timeStamp+"_"+path3[0]+".html");
								desktop.browse(uri);
							} catch (Exception ex) {

							} 
						} 
					}
				}
			});

			Object[] message = {
					"Scan Complete. No of Element verified: " +numberOfLines,
					link,
					"Previous Scan resutls are displayed in 'Results' tab",
					"Click 'Ok' to Scan further"
			};
			int result1 =JOptionPane.showConfirmDialog(this,message ,"Result", JOptionPane.OK_CANCEL_OPTION);
			System.out.println(result1);
			if(result1==0) {

			}else{
				Driver.pgDriver.quit();
				label2.setVisible(false);
				textfield2.setVisible(false);
				browsebutton.setVisible(false);
				donebutton.setVisible(false);
				label1.setVisible(true);
				textfield1.setVisible(true);
				browser.setVisible(true);
				startbutton.setVisible(true);
				clearbutton.setVisible(true);

			}
		}else {
			System.out.println("Entered Else Condition ");
		}
		System.out.println("Completed ");
	}



	/**Reads line from java file and extract lines starting with @FindBy tags
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException */
	public static int readLines(WebDriver driver, String javaFilePath) throws IOException, ClassNotFoundException{
		String path = javaFilePath;
		String[] javaFileNameSplit = javaFilePath.split(Pattern.quote("\\"));
		String[] javaFileName = javaFileNameSplit[javaFileNameSplit.length-1].split("\\.");
		int numberOfLines = 0;
		String line = null;
		Map<String, String> map = new HashMap<String, String>();
		Map<String, Integer> framemap = new HashMap<String, Integer>();
		int i =0;

		reader = new FileReader(path);
		textReader = new BufferedReader(reader);
		while ((line = textReader.readLine()) != null) {
			if (line.trim().startsWith("@FindBy")) {
				String webelement;
				while ((webelement = textReader.readLine()) != null) {
					if (webelement.trim().contains("WebElement")) {
						String[] element = webelement.replaceAll(";", "").split("\\s+");
						map.put(element[element.length-1], line);
						break;
					}
				}
				numberOfLines++;   
			} else if (line.trim().startsWith("Driver.getPgDriver().switchTo().frame")) {
				framemap.put(line.trim(), i+1);
				i++;
			}
		}
		int result;
		//resultmap = null;
		do {
			verifyElementPresent(map, driver, framemap);
			result = JOptionPane.showConfirmDialog(null, "Do you want to makes some changes to this page and verify elements again??? If so, please perform the necessary action and the click 'OK' to continue the Scan",
					"alert", JOptionPane.OK_CANCEL_OPTION);
		}while(result==0);

		reporting(map, javaFileName[0]);


		reader.close(); 
		return numberOfLines;

	}

	public static void reporting(Map<String, String> map, String javaFileName){
		/**Reporting*/
		timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
		new File ("C:\\HealthCheck_Reports").mkdirs();
		reportLocation = "C:\\HealthCheck_Reports\\";
		reportname = timeStamp + "_"+javaFileName+".html";
		ExtentManager.createInstance(reportLocation + reportname);
		reports = ExtentManager.getInstance();

		for (Entry<String, String> entry : resultmap.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			String result = entry.getValue();
			String elementname = entry.getKey();

			if(map.get(elementname)!=null) {
				logger=reports.createTest("WebElement "+elementname);
				if(result=="PASS") {
					logger.pass("Element is present - locator: "+map.get(elementname));
				}else {
					logger.fail("Element is not present - locator: "+map.get(elementname));
				}
			}

		}
		arraylist.add(reportname);
		reports.flush();
	}



	/**Verifies webelement present in the browser
	 * @param framemap 
	 * @return 
	 * @return 
	 * @return 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException */
	public static Map<String, String> verifyElementPresent(Map<String, String> map, WebDriver driver, Map<String, Integer> framemap) throws IOException, ClassNotFoundException{
		By by = null;
		String result = null;

		//if(resultmap==null) {
			for (Entry<String, String> entry : map.entrySet()) {
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				String valueofelement = entry.getValue();
				String elementname = entry.getKey();
				by = getElement(valueofelement);
				Driver.getPgDriver().switchTo().defaultContent();
				try {
					driver.findElement(by);
					System.out.println("PRESENT:   "+elementname.trim());
					result = "PASS";
				}
				catch(NoSuchElementException e) {
					System.out.println("NOT PRESENT: "+elementname.trim());
					result  = switchFrameAndVerify(map, driver, framemap, elementname);
				}	
				resultmap.put(elementname, result);
			}
		/*}else {

			for (Entry<String, String> entry : resultmap.entrySet()) {
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				String result1 = entry.getValue();
				String elementname1 = entry.getKey();
				if(result1!="PASS") {
					String valueofelement1 = map.get(elementname1);
					by = getElement(valueofelement1);
					try {
						driver.findElement(by);
						System.out.println("PRESENT:   "+elementname1.trim());
						result = "PASS";
					}
					catch(NoSuchElementException e) {
						System.out.println("NOT PRESENT: "+elementname1.trim());
						result  = switchFrameAndVerify(map, driver, framemap, elementname1);
					}	
					resultmap.put(elementname1, result);
				}
			}
		}*/



		/*if(resultmap.isEmpty())
			resultmap.put(elementname, result);
			else {
				for (Entry<String, String> entry1 : resultmap.entrySet()) {
					String valueofelement1 = entry1.getValue();
					String elementname1 = entry1.getKey();
					if(resultmap.get(valueofelement1)!="PASS") {
						resultmap.put(elementname1, valueofelement1);
					}
				}
			}*/


		return resultmap;
	}

	public static String switchFrameAndVerify(Map<String, String> map, WebDriver driver2, Map<String, Integer> framemap, String elementname) throws ClassNotFoundException, IOException {
		String result = null;
		for (Entry<String, Integer> entry : framemap.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			String valueofframe = entry.getKey();
			String[] frameelement  = valueofframe.split("\\.frame");
			String frame = frameelement[frameelement.length-1].replaceAll("this.", "").replaceAll("\\)", "").replaceAll("\\(", "").split(";")[0];

			try {
				Driver.getPgDriver().switchTo().defaultContent();
				driver2.switchTo().frame(driver2.findElement(getElement(map.get(frame))));
				try {
					driver2.findElement(getElement(map.get(elementname)));
					result = "PASS";
					break;
				}catch (Exception e) {
					result = "FAIL";
					continue;
				}
			}catch(Exception e) {
				result="FAIL, Frame not present";
			}


		}	
		return result;
	}

	public static By getElement(String valueofelement) {
		By by = null;
		String val = valueofelement.substring(valueofelement.indexOf("(")+1,valueofelement.lastIndexOf(")")).replaceAll("\"", "").trim();
		String key = val.substring(0, val.indexOf("=")).toLowerCase().trim();
		String value = val.substring(val.indexOf("=")+1).trim();

		switch(key) {
		case "xpath":
			by = By.xpath(value);
			break;

		case "id" :
			by = By.id(value);
			break;

		case "tagname" :
			by = By.tagName(value);
			break;

		case "classname" :
			by = By.className(value);
			break;

		case "linktext" :
			by = By.linkText(value);
			break;

		case "partiallinktext" :
			by = By.partialLinkText(value);
			break;

		case "cssselector" :
			by = By.cssSelector(value);
			break;

		case "name" :
			by = By.name(value);
			break;

		default:
			System.out.println("Key or Value is null. No Element is listed. Key: "+key+" Value: "+value);
			break;
		}
		return by;
	}

}
