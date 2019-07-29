package tools;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import automationLib.Driver;
import extentmanager.ExtentManager;
import utils.Utilities;
import utils.UtilitiesForApplication;


public class ImportExport extends JFrame {

	WebDriver driver = Driver.getPgDriver();
	Utilities utils = new Utilities();
	UtilitiesForApplication utilsapp = new UtilitiesForApplication();

	
	JPanel multijp1;
	JPanel multijp2;
	JPanel multijp3;
	JLabel multilabel1;
	JTextField multitextfield1;
	JLabel multilabel2;
	JTextField multitextfield2;
	JLabel multilabel3;
	JTextField multitextfield3;
	JLabel multilabel4;
	JTextField multitextfield4;
	JButton multicreateexcel;
	JButton multicreatefeaturefile ;

	JButton multibrowsebutton1;
	JButton multibrowsebutton2;
	JButton multibrowsebutton3;
	JButton multibrowsebutton4;

	static String multifilepath;
	
	
	CompareFilesCopy cp = new CompareFilesCopy();
	JTabbedPane jtp = new JTabbedPane();
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	JPanel jp4 = new JPanel();
	JPanel jp6 = new JPanel();
	JPanel jp7 = new JPanel();
	JPanel jp5 = new JPanel();
	JPanel jp8 = new JPanel();
	JPanel jp9 = new JPanel();
	JPanel jp10 = new JPanel();

	JLabel label1 = new JLabel("Project Name: ");
	JLabel label2 = new JLabel("Jira ID: ");
	JLabel label3 = new JLabel("Project Name: ");
	JLabel label4 = new JLabel("Feature Files: ");
	JLabel label5 = new JLabel("Project Location");
	JLabel headerLabel1;
	JLabel headerLabel2;


	JTextField textfield = new JTextField(10);
	JTextField textfield1 = new JTextField(10);
	JTextField textfield3 = new JTextField(10);
	JTextField textfield4 = new JTextField(15);
	JTextField textfield5 = new JTextField(15);
	JTextField textField1 = new JTextField(15);
	JTextField textField2 = new JTextField(15);
	
	
	

	JButton but1 = new JButton("CLEAR");
	JButton but = new JButton("IMPORT");
	JButton but4 = new JButton("Browse");
	JButton but2 = new JButton("EXPORT");
	JButton but3 = new JButton("CLEAR");
	JButton but7 = new JButton("COMPARE");
	JButton readButton = new JButton("Local File");
	JButton readButton1 = new JButton("Import File");
	JButton compare = new JButton("Compare");
	
	
	//Text Field for Local File Path and Imported File Path --> Multi Compare
	
		JTextField textField7 = new JTextField(15);
		JTextField textField8 = new JTextField(15);
	
	

	static JTextArea textArea1 = new JTextArea(20, 40);
	static JTextArea textArea2 = new JTextArea(20, 40);

	JEditorPane htmlPane = new JEditorPane();
	JEditorPane htmlPane1 = new JEditorPane();

	static String filePath1;
	static String filePath2;
	static String featurefileLocation;
	static BufferedReader reader1;
	static BufferedReader reader2;
	static BufferedReader reader11;
	static BufferedReader reader12;
	static String line1;
	static String line11;
	static String line111;
	static String line2;
	static String line12;
	
	static String filePath12;
	static String filePath13;
	
	String command ;
	
	String s[];
	
	
	//Multi Compare
	
    String btn;
    
			JButton compare1 = new JButton("Compare");
			
			JButton readButton2 = new JButton("Local File Path");
			JButton readButton3 = new JButton("Imported File Path");
			
			JButton next = new JButton("Next");
			
			JButton iterate = new JButton("Iterate");
			
			JRadioButton online = new JRadioButton("Online");
		     JRadioButton offline = new JRadioButton("Offline");
		     ButtonGroup bG = new ButtonGroup();
		     
				final static String ON = "on";
				final static String OFF = "off";

		
		static JEditorPane htmlPane2 = new JEditorPane();
		static JEditorPane htmlPane3 = new JEditorPane();
	
		static JTextField textField3 = new JTextField(15);
		static JTextField textField4 = new JTextField(15);
		
		static JTextArea textArea3 = new JTextArea(30, 50);
		static JTextArea textArea4 = new JTextArea(30, 50);
		
		JButton but8 = new JButton("Save Local File - Multi");
		JButton  but9 = new JButton("Save Imported File - Multi");
		
		JPanel jp11 = new JPanel();
		
		static String textField5;
		static String textField6;
		
		int i=0;
		
		int j=0;
		
		//Config Tab
		
		
		static JTextField textField9 = new JTextField(15);
		static JTextField textField10 = new JTextField(15);
		//static JTextField textField11 = new JTextField(15);
		JLabel label6 = new JLabel("Project Location: ");
		JLabel label7 = new JLabel("Local Location: ");
		//JLabel label8 = new JLabel("Report Location: ");
		static Date date=new Date();
		static String reportLocation;
		static String reportname;
		static String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
		static ExtentTest  logger;
		static ExtentReports reports;
		static ArrayList<String> arraylist = new ArrayList<>();
		static Map<String, String> resultmap = new HashMap<String, String>();
		//Map<String, String> map3;
		String[] javaFileName;
		
		
		/*//Sub Task
		
		JButton open = new JButton("Open Browser");
		
		public static WebDriver pgDriver;
		public static String drType;*/
		


	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme("Grey");
		UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");

		ImportExport tp = new ImportExport();
		tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tp.setVisible(true);
	}

	public ImportExport() {
		setTitle("Comparator Tool");
		setSize(900, 600);
		setLocationRelativeTo(null);


		//Setting Header label
		headerLabel1 = new JLabel("Enter the Project Name and JIRA ID in the Field to Import/Export Test Scripts!", JLabel.CENTER);
		headerLabel2 = new JLabel("Enter the Project Name and JIRA ID in the Field to Import/Export Test Scripts!", JLabel.CENTER);

		
		//Configuration tab
		
		jp8.add(label6);
		jp8.add(textField9);
		jp8.add(label7);
		jp8.add(textField10);
		//jp8.add(label8);
		//jp8.add(textField11);
		
		
		
		
		// IMPORT tab

		jp1.add(headerLabel1);
		jp6.add(label1);
		jp6.add(textfield);
		jp6.add(label2);
		jp6.add(textfield1);
		jp6.add(but);
		jp6.add(but1);	
		jp1.add(jp6);

		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String localDownloadFilePath = textField10.getText();
				String jiraid = textfield1.getText();
				List<String> jiraidList = Arrays.asList(jiraid.split(","));
				
				/*String localFileCount = textfield1.getText();
				String[] loc = localFileCount.split(",");
				System.out.println("Loc Array: "+loc);
				int locCount = loc.length;
				System.out.println("Int: "+locCount);*/
				
				if(!jiraid.equalsIgnoreCase("")) {
					JLabel label_login = new JLabel("Username: ");
					JTextField login = new JTextField(10);
					JLabel label_password = new JLabel("Password: ");
					JPasswordField passwordval = new JPasswordField(15);
					Object[] array = { label_login,  login, label_password, passwordval };

					JOptionPane.showConfirmDialog(null, array, "Login", 
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE);

					String username = login.getText();
					String password = passwordval.getText();

					for(String temp : jiraidList)
					{
					command = "curl -H \"Content-Type:application/json\" -u "+username+":"+password+" https://jira.anthem.com/rest/raven/1.0/export/test?keys="+temp.trim()+" -k -o "+localDownloadFilePath+temp+".feature";
					System.out.println("Command: "+command);
					try {
						Runtime.getRuntime().exec(command);					
						}catch (IOException e1) {
						JOptionPane.showMessageDialog(but2, "Exception occurred. Please try Again!", "Alert", 1);
						e1.printStackTrace();
					}
					//featurefileLocation = utilsapp.getPropertyvalue("locallocation");
					featurefileLocation = textField10.getText();
					}
					 
					JOptionPane.showMessageDialog(but, "Feaure File Downloaded Successfully. Please refer the location: "+featurefileLocation+" for the downloaded file", "Success", 1);
				}else {
					JOptionPane.showMessageDialog(but, "Enter Jira ID to import", "Alert", 1);
				}
			}
		});

		but1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textfield.setText("");
				textfield1.setText("");
			}
		});

		//Export tab
		
		//Browse - Button
		
		//String filepath2 = utilsapp.getPropertyvalue("projlocation");
		
		

		but4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String filepath3 = textField9.getText();
				System.out.println("--->> "+filepath3);
				JFileChooser chooser = new JFileChooser(filepath3);
				chooser.setMultiSelectionEnabled(true);
				if (chooser.showOpenDialog(but4) == JFileChooser.APPROVE_OPTION) {
					File[] file = chooser.getSelectedFiles();
					if (file == null) {
						return;
					}
					textfield4.setText(Arrays.toString(file));
				}
			}
		});

		
		
		but2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String projectname = textField9.getText();
				String featurefilepath = textfield4.getText().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "");
				List<String> featurefilepathList = Arrays.asList(featurefilepath.split(","));
				//System.out.println("FeaturefilePathList: "+featurefilepathList);
				
				JLabel label_login = new JLabel("Username: ");
				JTextField login = new JTextField(10);
				JLabel label_password = new JLabel("Password: ");
				JPasswordField passwordval = new JPasswordField(15);
				Object[] array = { label_login,  login, label_password, passwordval };

				JOptionPane.showConfirmDialog(null, array, "Login", 
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE);

				String username = login.getText();
				String password = passwordval.getText();
				
				for(String temp1 : featurefilepathList)
				{
				command = "curl -H \"Content-Type: multipart/form-data\" -u "+username+":"+password+" -F \"file=@"+temp1+"\" https://jira.anthem.com/rest/raven/1.0/import/feature?projectKey="+projectname+" -k";
				System.out.println("Command: "+command);
				try {
					Runtime.getRuntime().exec(command);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(but2, "Exception occurred. Please try Again!", "Alert", 1);
					e1.printStackTrace();
				}
				}

				JOptionPane.showMessageDialog(but2, "Successfully exported to JIRA", "Alert", 1);

			}
		});

		but3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textfield3.setText("");
				textfield4.setText("");
			}
		});


		//Adding the Labels and Fields in Export tab section

		jp2.add(headerLabel2);
		jp7.add(label3);
		jp7.add(textfield3);
		jp7.add(label4);
		jp7.add(textfield4);
		jp7.add(but4);
		jp7.add(but2);
		jp7.add(but3);	
		jp2.add(jp7);


		//COMPARE tab
		// File 1 Chooser -- Project LOcation as JFileChooser

		//String filepath1 = utilsapp.getPropertyvalue("projlocation");

		

		readButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			String filepath1 = textField9.getText();
			System.out.println("Path: "+filepath1);
			JFileChooser fc = new JFileChooser(filepath1);
			int returnVal = fc.showOpenDialog(readButton);
			fc.setMultiSelectionEnabled(true);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				try {
					BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					textArea1.setHighlighter(null);
					textArea1.read(input, "READING FILE :-)");
					textField1.setText(file.toString());
					filePath1 = textField1.getText();

					// --> To display the selected file content

					FileInputStream fr = new FileInputStream(file);
					InputStreamReader isr = new InputStreamReader(fr, "UTF-8");
					BufferedReader reader = new BufferedReader(isr);
					StringBuffer buffer = new StringBuffer();

					String line = null;
					while ((line = reader.readLine()) != null) {
						buffer.append(line);
						buffer.append("\n");
					}

					reader.close();

					htmlPane.setText(buffer.toString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				System.out.println("Operation is CANCELLED :(");
			}
			}
		});


		// File 2 Chooser

		readButton1.addActionListener(ev -> {
			String localDownloadFilePath = textField10.getText();
			String jiraid = textField2.getText();
			List<String> jiraidList = Arrays.asList(jiraid.split(","));

			if(!jiraid.equalsIgnoreCase("")) {
				JLabel label_login = new JLabel("Username: ");
				JTextField login = new JTextField(10);
				JLabel label_password = new JLabel("Password: ");
				JPasswordField passwordval = new JPasswordField(15);
				Object[] array = { label_login,  login, label_password, passwordval };

				JOptionPane.showConfirmDialog(null, array, "Login", 
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE);

				String username = login.getText();
				String password = passwordval.getText();

				for(String temp : jiraidList)
				{
				
				command = "curl -H \"Content-Type:application/json\" -u "+username+":"+password+" https://jira.anthem.com/rest/raven/1.0/export/test?keys="+temp+" -k -o "+localDownloadFilePath+temp+".feature";
				//command = "curl -H \"Content-Type:application/json\" -u "+username+":"+password+" https://jira.anthem.com/rest/raven/1.0/export/test?keys="+temp+" -k -o "+utilsapp.getPropertyvalue("locallocation")+temp+".feature";
				//filePath2 = utilsapp.getPropertyvalue("locallocation")+jiraid+".feature";
				filePath2 = localDownloadFilePath+jiraid+".feature";
				try {
					Runtime.getRuntime().exec(command);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				}

				
				JOptionPane.showMessageDialog(but, "Done", "Success", 1);
			}else {
				JOptionPane.showMessageDialog(but, "Enter Jira ID for Import", "Alert", 1);
			}
			try
			{
				FileInputStream fr1 = new FileInputStream(filePath2);
				InputStreamReader isr1 = new InputStreamReader(fr1, "UTF-8");
				BufferedReader reader1 = new BufferedReader(isr1);
				StringBuffer buffer1 = new StringBuffer();

				String line1 = null;
				while ((line1 = reader1.readLine()) != null) {
					buffer1.append(line1);
					buffer1.append("\n");
				}

				reader1.close();

				htmlPane1.setText(buffer1.toString());
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		});

		//Compare Code

		CompareFilesCopy cf = new CompareFilesCopy();

		compare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String localFileCount = textField1.getText();
				String[] loc = localFileCount.split(",");
				System.out.println("Loc Array: "+loc);
				int locCount = loc.length;
				System.out.println("Int: "+locCount);
				try {
					System.out.println("Entered Into Try..");
					htmlPane.setHighlighter(null);
					htmlPane.setEditable(false);
					htmlPane.setContentType("text/html");
					htmlPane.setFont(new Font("Segoe Script", Font.PLAIN, 16));
					htmlPane.setText("<html><body>" + cf.compareTwoFiles("one").replaceAll(",", "<br>") + "</body></html>");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					htmlPane1.setHighlighter(null);
					htmlPane1.setEditable(false);
					htmlPane1.setContentType("text/html");
					htmlPane1.setFont(new Font("Segoe Script", Font.PLAIN, 16));
					htmlPane1.setText("<html><body>" + cf.compareTwoFiles("two").replaceAll(",", "<br>")+ "</body></html>");
				} catch (IOException e1) {
					e1.printStackTrace();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
				}		
			}
		});
		
		

				//String filepath11 = utilsapp.getPropertyvalue("projlocation");
		
		

				// File 2 Chooser - Multi Compare

				readButton2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
											
						String filepath11 = textField9.getText();
						JFileChooser fc = new JFileChooser();
						fc.setCurrentDirectory(new java.io.File(filepath11));
						fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						int returnVal = fc.showOpenDialog(readButton2);
						fc.setAcceptAllFileFilterUsed(true);
						
						if (returnVal == JFileChooser.APPROVE_OPTION) {
							//File file = fc.getCurrentDirectory();
							File file = fc.getSelectedFile();
							//System.out.println("File Path: "+file);	
							//String path = fc.getSelectedFile().getPath();
							String path = file.getAbsolutePath();
							//System.out.println("Path: "+path);		
							textField3.setText(path);
							filePath12 = textField3.getText();
							//System.out.println("Path1: "+filePath12);
							
					}else
					{
						System.out.println("Operation is CANCELLED :(");
					}
					
					}
					
					
				});


				// File 2 Chooser - Multi Compare

				readButton3.addActionListener(ev -> {
					String filepath11 = textField9.getText();				
					JFileChooser fc1 = new JFileChooser();
					fc1.setCurrentDirectory(new java.io.File(filepath11));
					fc1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int returnVal1 = fc1.showOpenDialog(readButton3);
					fc1.setAcceptAllFileFilterUsed(true);
					
					if (returnVal1 == JFileChooser.APPROVE_OPTION) {
						File file1 = fc1.getCurrentDirectory();
						//System.out.println("File Path: "+file1);	
						String path2 = fc1.getSelectedFile().getPath();
						//System.out.println("Path2: "+path2);
						textField4.setText(path2.toString());
						filePath13 = textField4.getText();
						//System.out.println("Path2: "+filePath13);
				}else
				{
					System.out.println("Operation is CANCELLED :(");
				}
				
				});
				
				//Iterate Code
				
				CompareFeatureFiles cff1 = new CompareFeatureFiles();
				
				iterate.addActionListener(new ActionListener()  {
					@Override
					public void actionPerformed(ActionEvent e)  {
						
						//String reportLocation = textField11.getText();
						
								try {
									cff1.compare();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								JOptionPane.showConfirmDialog(null, "There are "+CompareFeatureFiles.tempList.size()+" Files matched. Do you want to procced with Comparison? Please refer the C:\\Comparator_Reports for the detailed report", "Compare Confirmation Pop up", 
										JOptionPane.OK_CANCEL_OPTION,
										JOptionPane.PLAIN_MESSAGE);
								
								reporting();
					}
				});


				
	
				CompareFilesCopy cf1 = new CompareFilesCopy();			
				CompareFeatureFiles cff = new CompareFeatureFiles();
				
				//Next Code

				next.addActionListener(new ActionListener()  {
					
					@Override
					public void actionPerformed(ActionEvent e)  {
						/*try
						{*/
						/*if(btn.equalsIgnoreCase("online")|| btn.equalsIgnoreCase("null"))
						{*/
					if(btn.equalsIgnoreCase("online"))
								{ 
						System.out.println("Count: "+CompareFeatureFiles.tempList.size());
							s= CompareFeatureFiles.tempList.toArray(new String[0]);
								
								try {
									System.out.println("Entered Into Try..");
									htmlPane2.setHighlighter(null);
									htmlPane2.setEditable(false);
									htmlPane2.setContentType("text/html");
									htmlPane2.setFont(new Font("Segoe Script", Font.PLAIN, 16));
									htmlPane2.setText("<html><body>" + cf1.compareTwoFilesForMultiCompare("one",s[j]).replaceAll(",", "<br>") + "</body></html>");
									//System.out.println("FileNAme"+s[j]);
								} catch (IOException e1) {
									e1.printStackTrace();
									JOptionPane.showInputDialog("File Compariosn has completed.. :)");
								}
								try {
									htmlPane3.setHighlighter(null);
									htmlPane3.setEditable(false);
									htmlPane3.setContentType("text/html");
									htmlPane3.setFont(new Font("Segoe Script", Font.PLAIN, 16));
									htmlPane3.setText("<html><body>" + cf1.compareTwoFilesForMultiCompare("two",s[j]).replaceAll(",", "<br>")+ "</body></html>");
									//System.out.println("FileNAme"+s[j]);
								} catch (IOException e1) {
									e1.printStackTrace();  
									JOptionPane.showInputDialog("File Compariosn has completed.. :)");
								}
								
								System.out.println("FileNAme"+s[j]);
								
								//Save Local File - Multi
								but8.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										try {
											BufferedWriter bw = null;
											FileWriter fw = null;
											StringBuffer stringBuffer = new StringBuffer();
											//System.out.println("Filepath 12: "+ImportExport.filePath12+"\\"+s[j]);
											reader11 = new BufferedReader(new FileReader(ImportExport.filePath12+"\\"+s[j]));
											//line1 = reader1.readLine();
											//System.out.println("Filepath 13: "+ImportExport.filePath12+"\\"+s[j]);
											fw = new FileWriter(ImportExport.filePath12+"\\"+s[j]);
											bw = new BufferedWriter(fw);
											while ((line11 = reader11.readLine()) != null) {
												stringBuffer.append(line11);
												stringBuffer.append("\n");
												System.out.println(line11+"\n");
												bw.write(line11+"\r\n");
											}
											bw.flush();
											bw.close();

											System.out.println(" Output File is written in feature file");
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											System.out.println(" Output File is written in not feature file");
											e1.printStackTrace();
										}			
									}
								});
								
								//Save Imported File - Multi
								
								but9.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										try {
											BufferedWriter bw = null;
											FileWriter fw = null;
											StringBuffer stringBuffer = new StringBuffer();
											System.out.println("Filepath 13: "+ImportExport.filePath13+"\\"+s[j-1]);
											reader12 = new BufferedReader(new FileReader(ImportExport.filePath13+"\\"+s[j-1]));
											System.out.println("Filepath 12: "+ImportExport.filePath12+"\\"+s[j-1]);
											String filePath = ImportExport.filePath12+"\\"+s[j-1];
											//System.out.println("one: "+filePath);
											fw = new FileWriter(filePath);
											bw = new BufferedWriter(fw);
											while ((line12 = reader12.readLine()) != null) {
												stringBuffer.append(line12);
												stringBuffer.append("\n");
												System.out.println(line12+"\n");
												bw.write(line12+"\r\n");
											}
											bw.flush();
											bw.close();
											System.out.println(" Output File is written in feature file");
											JOptionPane.showMessageDialog(but, "Local file is replaced with the Imported Version Successfully", "Success", 1);
										} catch (IOException e1) {

											System.out.println(" Output File is written in not feature file");
											e1.printStackTrace();
										}	
										//j++;
									}
								});
							j++;			
		}
					}/*catch(Exception ArrayIndexOutOfBoundsException)
					{
						JOptionPane.showInputDialog("File Compariosn has completed.. :)");
						
				}*/
					//}
			});
	

		//Adding the Tab's
		jtp.addTab("Configuration", jp8);
		jtp.addTab("Import", jp1);
		jtp.addTab("Export", jp2);
		jtp.addTab("Compare", jp3);
		jtp.addTab("Multi Compare", jp4);
		

		
		

		jp3.add(textField1);
		jp3.add(readButton);
		jp3.add(textField2);
		jp3.add(readButton1);
		jp3.add(compare);
		
		
		/*jp8.add(label5);
		jp8.add(textfield5);*/
		
		
		//Adding Tabs for Multi Compare
		
		jp4.add(textField3);
		jp4.add(readButton2);
		jp4.add(textField4);
		jp4.add(readButton3);
		jp4.add(next);
		
		jp4.add(iterate);
		bG.add(offline);
		bG.add(online);
		jp4.add(online);
		jp4.add(offline);
		//offline.setSelected(true);
	     this.setVisible(true);
	    
		
	/*	JRadioButton enableButton = new JRadioButton("Enable");
		enableButton.setActionCommand(ON);
		JRadioButton disableButton = new JRadioButton("Disable");
		disableButton.setActionCommand(OFF);*/

	     
	     offline.addActionListener(new ActionListener() {
	    	 @Override
	      public void actionPerformed(ActionEvent event)  
	      {  
	    		
	    		// String btn =  bG.getSelection().getActionCommand();
	    		 btn = offline.getText();
	    		 System.out.println("Selected Radio Button: "+ btn);
	      }
	     });
	     

	     
	     online.addActionListener(new ActionListener() {
	    	 @Override
	      public void actionPerformed(ActionEvent event)  
	      {  
	    		
	    		// String btn =  bG.getSelection().getActionCommand();
	    		 btn = online.getText();
	    		 System.out.println("Selected Radio Button: "+ btn);
	      }
	     });
	     
	     
		
		
		//Adding Tabs for Sub Task
		
		/*jp8.add(open);*/

		//Setting the J Editor Pane Size

		htmlPane.setPreferredSize(new Dimension(400, 400));
		htmlPane1.setPreferredSize(new Dimension(400, 400));
		
		
		htmlPane2.setPreferredSize(new Dimension(400, 400));
		htmlPane3.setPreferredSize(new Dimension(400, 400));

		//Setting Scroll Pane for J Editor Pane

		jp5.add(new JScrollPane(htmlPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
		jp5.add(new JScrollPane(htmlPane1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
		jp3.add(jp5);

		JButton but5 = new JButton("Save Local File");
		JButton  but6 = new JButton("Save Imported File");


		//Save Local File

		but5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter bw = null;
					FileWriter fw = null;
					StringBuffer stringBuffer = new StringBuffer();
					reader1 = new BufferedReader(new FileReader(ImportExport.filePath1));

					//line1 = reader1.readLine();
					fw = new FileWriter(filePath2);
					bw = new BufferedWriter(fw);
					while ((line1 = reader1.readLine()) != null) {
						stringBuffer.append(line1);
						stringBuffer.append("\n");
						System.out.println(line1+"\n");
						bw.write(line1+"\r\n");
					}
					bw.flush();
					bw.close();

					System.out.println(" Output File is written in feature file");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println(" Output File is written in not feature file");
					e1.printStackTrace();
				}			
			}
		});


		//Save Imported File

		but6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter bw = null;
					FileWriter fw = null;
					StringBuffer stringBuffer = new StringBuffer();
					reader2 = new BufferedReader(new FileReader(ImportExport.filePath2));
					fw = new FileWriter(filePath1);
					bw = new BufferedWriter(fw);
					while ((line2 = reader2.readLine()) != null) {
						stringBuffer.append(line2);
						stringBuffer.append("\n");
						System.out.println(line2+"\n");
						bw.write(line2+"\r\n");
					}
					bw.flush();
					bw.close();
					System.out.println(" Output File is written in feature file");
					JOptionPane.showMessageDialog(but, "Local file is replaced with the Imported Version Successfully", "Success", 1);
				} catch (IOException e1) {

					System.out.println(" Output File is written in not feature file");
					e1.printStackTrace();
				}			
			}
		});
		
		
		
	
		
		
		
		/*//Open Browser - Sub Task
		
		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				File file = new File("webdrivers//chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				System.setProperty("webdriver.chrome.driver","webdrivers//chromedriver.exe" );

				//WebDriver chromeDriver = new ChromeDriver();
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				WebDriver chromeDriver = new ChromeDriver(options);
				pgDriver = chromeDriver;
				drType = "chrome";
				
				Driver.getPgDriver().get("https://jira.anthem.com/");
				Driver.getPgDriver().manage().window().maximize();
				String str = Driver.getPgDriver().getCurrentUrl();
				Driver.pgDriver.manage().window().maximize();
				Driver.pgDriver.get("https://jira.anthem.com/");
				//System.out.println("The current URL is " + str);
			}
					
				});*/
		
		
		
		
		jp11.add(new JScrollPane(htmlPane2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
		jp11.add(new JScrollPane(htmlPane3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
		jp4.add(jp11);





		jp3.add(but5);
		jp3.add(but6);
		
		jp4.add(but8);
		jp4.add(but9);
		
		
		
		
		/**Mulit Data
		 * 
		 */
		
		/**Set Panel and add elements*/
		multijp1 = new JPanel();
		multijp2 = new JPanel();
		JTabbedPane multijtp = new JTabbedPane();
		JTabbedPane multijtpfinal = new JTabbedPane();
		multilabel1 = new JLabel("Enter Feature File Path: ");
		multitextfield1 = new JTextField(15);
		multilabel2 = new JLabel("Enter Excel Sheet Path: ");
		multitextfield2 = new JTextField(15);

		multilabel3 = new JLabel("   Enter Feature File Path: ");
		multitextfield3 = new JTextField(50);
		multilabel4 = new JLabel("   Enter Excel Sheet Path: ");
		multitextfield4 = new JTextField(50);

		/**Buttons listed and actions to be performed when clicked*/

		multicreateexcel = new JButton("Excel Generation");
		multicreatefeaturefile = new JButton("Create Feature File");
		multibrowsebutton1 = new JButton("BROWSE");
		multibrowsebutton2 = new JButton("BROWSE");
		multibrowsebutton3 = new JButton("BROWSE");
		multibrowsebutton4 = new JButton("BROWSE");
		
		multicreateexcel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag;

				String filename1 = multitextfield1.getText();
				String filename2 = filename1;
				File file = new File(filename1);
				multifilepath = file.getParent();
				Create_Excel_File ce = new Create_Excel_File();
				try {
					ce.writeToExcelSheet(filename1, filename2);
					flag = true;
				} catch (Exception e1) {
					flag = false;
					e1.printStackTrace();
				}

				//JOptionPane.showMessageDialog(createfeaturefile, "Excel File Updated Successfully", "Alert", JOptionPane.OK_OPTION);
				if(flag) {
					JOptionPane.showMessageDialog(null,
							"Excel File Generated",
							"Alert",
							JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null,
							"Excel File is not Generated",
							"Alert",
							JOptionPane.OK_OPTION);
				}
			}
		});

		multicreatefeaturefile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				boolean flag;

				String filename3 = multitextfield3.getText();
				String filename4 = multitextfield4.getText();
				
				File file = new File(filename3);
				multifilepath = file.getParent();

				Create_new_FF cf = new Create_new_FF();
				String filepath = null;
				try {
					filepath = cf.generateFeatureFile(filename3, filename4);
					flag = true;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					flag = false;
				}

				if(flag) {
				//JOptionPane.showMessageDialog(createfeaturefile, "Feature File Created", "Alert", JOptionPane.OK_OPTION);
				JOptionPane.showMessageDialog(null,
						"New Feature File Created in the path: "+filepath,
						"Alert",
						JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null,
							"New Feature File Created in the path: "+filepath,
							"Alert",
							JOptionPane.OK_OPTION);	
				}

			}
		});


		multibrowsebutton1.addActionListener(new ActionListener() {
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
				try {
				File file1 = new File(multifilepath);
				chooser.setCurrentDirectory(file1);
				}catch(Exception e1) {
					
				}
				chooser.setMultiSelectionEnabled(false);
				if (chooser.showOpenDialog(multibrowsebutton1) == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					if (file == null) {
						return;
					}
					multitextfield1.setText(file.toString());
				}

			}
		});

		multibrowsebutton2.addActionListener(new ActionListener() {
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
				//chooser.setCurrentDirectory(new File (System.getProperty("user.dir")));
				chooser.setMultiSelectionEnabled(false);
				if (chooser.showOpenDialog(multibrowsebutton2) == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					if (file == null) {
						return;
					}
					multitextfield2.setText(file.toString());
				}

			}
		});

		multibrowsebutton3.addActionListener(new ActionListener() {
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
				//chooser.setCurrentDirectory(new File (System.getProperty("user.dir")));
				try {
					File file1 = new File(multifilepath);
					chooser.setCurrentDirectory(file1);
					}catch(Exception e1) {
						
					}
				chooser.setMultiSelectionEnabled(false);
				if (chooser.showOpenDialog(multibrowsebutton3) == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					if (file == null) {
						return;
					}
					multitextfield3.setText(file.toString());
				}

			}
		});

		multibrowsebutton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*							try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				 */
				
				String filename3 = multitextfield3.getText();
				File file2 = new File(filename3);
				multifilepath = file2.getParent();
				JFileChooser chooser = new JFileChooser();
				//chooser.setCurrentDirectory(new File (System.getProperty("user.dir")));
				try {
					File file1 = new File(multifilepath);
					chooser.setCurrentDirectory(file1);
					}catch(Exception e1) {
						
					}
				chooser.setMultiSelectionEnabled(false);
				if (chooser.showOpenDialog(multibrowsebutton4) == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					if (file == null) {
						return;
					}
					multitextfield4.setText(file.toString());
				}

			}
		});



		GridBagConstraints c = new GridBagConstraints();
		int top = 3, left = 3, bottom = 3, right = 3;
		Insets ins = new Insets(top, left, bottom, right);
		multijp3 = new JPanel();
		multijp3.setLayout(new GridBagLayout());

		/**Add all components in Panel*/
		multijp1.add(multilabel1);
		multijp1.add(multitextfield1);
		multijp1.add(multibrowsebutton1);
		multijp1.add(multicreateexcel,c);
		multijp3.add(multijp1);
		
		//multijp2.setLayout( new GridLayout( 2 , 1 ) );  // 2 rows 1 column
		//enclosingPanel.add( labelPanel );
		
		multijp2.add(multilabel3);
		multijp2.add(multitextfield3);
		multijp2.add(multibrowsebutton3);
		multijp2.add(multilabel4 );
		multijp2.add(multitextfield4);
		multijp2.add(multibrowsebutton4);
		multijp2.add(multicreatefeaturefile); 

		/**Add components in Frame*/

		multijtp.add("Excel Template Generation", multijp1);
		multijtp.add("Feature File Creation", multijp2);
		jtp.add("MultiData",multijtp);
		//add(multijtpfinal);
		add(jtp);

	}
	
	public static void reporting (/*Map<String, String> map3*/){
		/**Reporting*/
		timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
		new File ("C:\\Comparator_Reports").mkdirs();
		reportLocation = "C:\\Comparator_Reports\\";
		reportname = timeStamp + ".html";
		System.out.println("Report Name: "+reportname);
		ExtentManager.createInstance(reportLocation + reportname);
		reports = ExtentManager.getInstance();

		for (Entry<String, String> entry : CompareFeatureFiles.map1.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			String result = entry.getValue();
			String fileName = entry.getKey();

			if(CompareFeatureFiles.map1.get(fileName)!=null) {
				logger=reports.createTest("Feature File: "+fileName);
				if(result=="Matched") {
					logger.pass("Feature File Matched"+CompareFeatureFiles.map1.get(fileName));
				}else {
					logger.fail("Feature File Not Matched"+CompareFeatureFiles.map1.get(fileName));
				}
			}

		}
		arraylist.add(reportname);
		reports.flush();
	}

}
