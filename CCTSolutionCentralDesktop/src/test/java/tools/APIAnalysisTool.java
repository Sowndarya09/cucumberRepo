package tools;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.apache.commons.io.IOUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import gherkin.deps.com.google.gson.annotations.Expose;
import utils.APIUtils;


public class APIAnalysisTool extends JFrame{
	/**
	 * 
	 */
	static BufferedReader textReader;
	static BufferedReader textReader1;
	static BufferedReader textReader2;
	static FileReader reader;
	static FileReader reader1;
	static FileReader reader2;
	static String reportLocation;
	static Date date=new Date();
	static String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
	static ArrayList<String> arraylist = new ArrayList<>();
	static Map<String, String> resultmap = new HashMap<String, String>();
	JPanel jp3;
	JPanel jp1;
	JPanel jp2;
	JLabel label1;
	JTextField textfield1;
	JLabel label5;
	JTextField textfield3;
	JLabel label2;
	JTextField textfield2;
	JLabel label3;
	JLabel label4;
	JButton gobutton;
	JButton runbutton;
	JButton emailbutton ;
	JComboBox api;
	JComboBox apiurl;
	JButton browsebutton;
	JButton donebutton;
	static String reportname;
	static ExtentTest  logger;
	static ExtentReports reports ;

	APIUtils apiutils = new APIUtils();


	static List<JTextField> list;
	static String[] tryyy;

	static String page;
	static String method;


	int count = 0;

	public static void main(String args[]) throws Exception {
		/**Set the look and feel*/
		com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme("Blue");
		UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");

		APIAnalysisTool tp = new APIAnalysisTool();
		tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tp.setVisible(true);
		System.out.println("==================================="+date+"================================");

	}

	public String[] readfromnp() throws IOException {
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\tools\\APIList.txt";
		BufferedReader input = new BufferedReader(new FileReader(filePath));
		List<String> strings = new ArrayList<String>();
		try {
			String line = null;
			while (( line = input.readLine()) != null){
				strings.add(line);
			}
		}

		catch (FileNotFoundException e) {
			System.err.println("Error, file " + filePath + " didn't exist.");
		}
		finally {
			input.close();
		}

		String[] lineArray = strings.toArray(new String[]{});

		return lineArray;
	}

	public APIAnalysisTool() throws IOException {
		/**Frame title, position and size*/
		setTitle("API Analysis Tool");
		setSize(600, 600);
		setLocationRelativeTo(null);

		/**Set Panel and add elements*/
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JTabbedPane jtp = new JTabbedPane();

		label3 = new JLabel("Select Environment: ");
		String[] apilist = {"Major SIT", "Major Stage","Minor Stage","Minor SIT"};
		api = new JComboBox(apilist);

		label4 = new JLabel("Select API: ");
		String[] urllist = readfromnp();

		ArrayList<String> arry = new ArrayList<String>();


		for(int i=0;i<urllist.length;i++) {
			String[] trying = urllist[i].split("-");
			arry.add(trying[0]);
		}

		String[] st = arry.toArray(new String[arry.size()]);
		apiurl = new JComboBox(st);

		Map<String,String> map = new HashMap<String,String>();

		for(int i=0;i<urllist.length;i++) {
			String[] trying = urllist[i].split("-");
			map.put(trying[0], trying[1]);
		}


		/**Buttons listed and actions to be performed when clicked*/
		gobutton = new JButton("GO");
		runbutton = new JButton("RUN");
		emailbutton = new JButton("DRAFT EMAIL");


		jp2.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		int top = 3, left = 3, bottom = 3, right = 3;
		Insets ins = new Insets(top, left, bottom, right);


		gobutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ENTERED GO");

				jp2.removeAll(); 
				jp2.updateUI();

				String selectedurl = (String) apiurl.getSelectedItem();
				String[] ar = map.get(selectedurl).split(":");

				page = selectedurl;
				method=  ar[0];

				String[] val = ar[1].split(",");

				list = new ArrayList<JTextField>();

				for(int i=0;i<val.length;i++) {
					c.gridx = 0;
					c.gridy = 0+i;
					JLabel label1 = new JLabel(val[i]);
					jp2.add(label1, c);
					c.gridx = 1;
					c.gridy = 0+i;
					JTextField textfield1 = new JTextField(15);
					jp2.add(textfield1, c);
					c.insets = ins;
					list.add(textfield1);
					jp1.add(jp2);
				}

				jp2.add(runbutton);

				System.out.println("Should be visible");

			}
		});

		runbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("ENTERED RUN");


				ArrayList<String> ar = new ArrayList<String>();
				for(JTextField field : list){
					System.out.println(field.getText());
					ar.add(field.getText());
				}


				Boolean flag;
				String[] bar = ar.toArray(new String[ar.size()]);

				flag = executeMethod("automationLib."+page, method,bar);
				System.out.println("BOOLEAN"+flag);
				String parservalue = null;
				try {
					parservalue = IOUtils.toString(APIUtils.reader);
					System.out.println(parservalue);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				String Data = null;
				String finalvalue = toPrettyFormat(parservalue);

				if(!flag) {
					JScrollPane scrollPane = new JScrollPane(new JLabel(parservalue));
					scrollPane.setPreferredSize(new Dimension(400,200));
					Object message = scrollPane;

					JTextArea textArea = new JTextArea(finalvalue);
					textArea.setSize(500, 500);
					textArea.setEditable(false);
					scrollPane.setEnabled(true);
					textArea.setLineWrap(true);
					textArea.setWrapStyleWord(true);
					textArea.setMargin(new Insets(5,5,5,5));
					scrollPane.getViewport().setView(textArea);
					message = scrollPane;

					Object[] options = {"Draft Mail",
					"Cancel"};
					JPanel panel = new JPanel();
					JTextField field1 = new JTextField(10);
					panel.add(field1);
					field1.getText();

					int result =  JOptionPane.showOptionDialog(null,
							message,
							"API Outage!!!",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null, 
							options,
							options[0]); 

					if(result==0) {
						try {
							String from = "AF72532@anthem.com";	
							String subject = "API failure: "+page;
							String body = "Hi Team,\n\n We are facing the below outage on" +" " + page+"\n";
							body+= "\n\nResponse:";
							body += "\n" +finalvalue;
							body += "\n\n Kindly have a look into it and update us";
							String recipients ="AF72532@anthem.com";
							apiutils.sendEmail("","",from,subject,body,recipients);
						} catch (Exception e2) {
							e2.printStackTrace();
						} 
					}else {
						System.out.println("CanCelled");
					}


				}else {

					JScrollPane scrollPane = new JScrollPane(new JLabel(parservalue));
					scrollPane.setPreferredSize(new Dimension(400,300));
					Object message = scrollPane;

					JTextArea textArea = new JTextArea(finalvalue);
					textArea.setSize(500, 500);
					textArea.setEditable(false);
					scrollPane.setEnabled(true);
					textArea.setLineWrap(true);
					textArea.setWrapStyleWord(true);
					textArea.setMargin(new Insets(5,5,5,5));
					scrollPane.getViewport().setView(textArea);
					message = scrollPane;

					Object[] options = {"Draft Mail",
					"Cancel"};
					int result = JOptionPane.showOptionDialog(null,
							message,
							"API Response!!!",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,    
							options,  
							options[0]); 

					if(result==0) {
						try {
							String from = "AF72532@anthem.com";	
							String subject = "API failure: "+page;
							String body = "Hi Team,";
							body+= "\nWe are facing the below outage on " +page+"\n";
							body += "\nResponse:";
							body += finalvalue;
							String recipients ="AF72532@anthem.com";
							apiutils.sendEmail("","",from,subject,body,recipients);
						} catch (Exception e2) {
							e2.printStackTrace();
						} 
					}else {
						System.out.println("CanCelled");
					}
				}

			}

		});



		/**Add all components in Panel*/
		jp1.add(label3);
		jp1.add(api);
		jp1.add(label4);
		jp1.add(apiurl);
		jp1.add(gobutton);

		/**Add components in Frame*/
		jtp.add("API", jp1);
		add(jtp);
	}

	@Expose
	String jsonOutput ;

	public boolean executeMethod(String classname, String methodname,String[] arlist)  {
		try {
			System.out.println("Entered the executemethod");
			boolean returnvalue = true;
			Object returnvalueObject= null;

			Object classobject = Class.forName(classname).newInstance();
			Object castedObject = Class.forName(classname).cast(classobject);
			Class [] argtypes = new Class [] {String[].class};
			Method method = classobject.getClass().getMethod(methodname,argtypes);

			try {
				returnvalueObject= method.invoke(classobject,(Object)arlist);
				returnvalue =(Boolean)returnvalueObject;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} 
			return returnvalue;

		}catch(Exception e1) {
			return false;
		}
	}


	public static String toPrettyFormat(String jsonString) 
	{
		String prettyJson;
		try {
			JsonParser parser11 = new JsonParser();
			JsonObject json = parser11.parse(jsonString).getAsJsonObject();

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonElement jsonElement =  new JsonParser().parse(jsonString);
			System.out.println(gson.toJson(jsonElement));
			prettyJson = gson.toJson(json);
		}catch(Exception e) {
			prettyJson = jsonString;
		}
		return prettyJson;
	}

}
