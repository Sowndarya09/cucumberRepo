package tools;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class MedisysXmlFileProcessing extends JFrame {
	
	JPanel jp1;
	JPanel jp2;
	JPanel jp3;
	JPanel jp4;
	JPanel jp5;
	JLabel label1;
	JTextField textfield1;
	JLabel label2;
	JTextField textfield2;
	JLabel label3;
	JTextField textfield3;
	JLabel label4;
	JLabel label5;
	JTextField textfield4;
	JButton runbutton;
	JButton runbutton1;
	JButton runbutton2;
	JButton browsebutton;
	JButton browsebutton1;
	JButton browsebutton2;
	JComboBox list;
	
	static String filepath;
	static String filepath1;
	
	JTabbedPane jtp = new JTabbedPane();
	JTabbedPane jtpfinal = new JTabbedPane();
	
	public static void main(String args[]) throws Exception {
		/**Set the look and feel*/
		com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme("Black");
		UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

		/** Log file */
		System.out.println("==========================================================================");
		Date date = new Date();
		System.out.println("Time:"+date);
		String logfilepath = System.getProperty("user.dir");
		File file = new File(logfilepath+"//MedisysXmlFileProcessing_logs.txt"); 
		FileOutputStream fos = new FileOutputStream(file, true);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		System.out.println("==========================================================================");
		
		MedisysXmlFileProcessing tp = new MedisysXmlFileProcessing();
		tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tp.setVisible(true);
	}
	
	public MedisysXmlFileProcessing() throws IOException {
		/**Frame title, position and size*/
		setTitle("Medisys Xml File Processing");
		setSize(600, 150);
		setLocationRelativeTo(null);

		/**Set Panel and add elements*/
		jp1 = new JPanel();
		label1 = new JLabel("Enter Location Of The Xml Files Present: ");
		textfield1 = new JTextField(20);
		label2 = new JLabel("Select GBD Url: ");
		String[] urllist = {"https://uats-gbd-soa-services.anthem.com:443/MedisysWS-v1/transaction", 
				"https://uats-gbd-soa-services.anthem.com:444/MedisysWS-v1/transaction", 
				"https://uats-gbd-soa-services.anthem.com:445/MedisysWS-v1/transaction",
				"https://devs-gbd-soa-services.anthem.com:443/MedisysWS-v1/transaction",
				"https://devs-gbd-soa-services.anthem.com:444/MedisysWS-v1/transaction"};
		list = new JComboBox(urllist);
		//textfield2 = new JTextField(15);

		/**Buttons listed and actions to be performed when clicked*/

		runbutton = new JButton("LOAD");
		browsebutton = new JButton("BROWSE");

		runbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag;

				String filename1 = textfield1.getText();
				String gbdurl = (String) list.getSelectedItem();
				if(!filename1.equalsIgnoreCase("")) {
				File file = new File(filename1);
				try {
					Medisys_API_POC md = new Medisys_API_POC();
					md.mainMethod(file,gbdurl);
					flag = true;
				} catch (Exception e1) {
					flag = false;
					e1.printStackTrace();
				}
				if(flag)
					JOptionPane.showMessageDialog(runbutton, "Completed Successfully!!! Logs present in the path "+file, "Alert", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(runbutton, "Did not complete successfully", "Alert", JOptionPane.OK_OPTION);
			}else {
				JOptionPane.showMessageDialog(runbutton, "Enter Location of xml file!", "Alert", JOptionPane.OK_OPTION);
			}
			}});




		browsebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				try {
					File file1 = new File(filepath);
					chooser.setCurrentDirectory(file1);
				}catch(Exception e1) {

				}
				chooser.setMultiSelectionEnabled(false);
				if (chooser.showOpenDialog(browsebutton) == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					if (file == null) {
						return;
					}
					textfield1.setText(file.toString());
				}

			}
		});
		



		jp1.add(label1);
		jp1.add(textfield1);
		jp1.add(browsebutton);
		jp1.add(label2);
		jp1.add(list);
		jp1.add(runbutton);
		

		/**Add components in Frame*/
		jtp.add("Update XML", jp1);
		add(jtp);
	}


}
