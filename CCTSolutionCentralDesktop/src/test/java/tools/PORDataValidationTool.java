package tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class PORDataValidationTool extends JFrame {

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

	static String filepath;
	static String filepath1;
	
	JTabbedPane jtp = new JTabbedPane();
	JTabbedPane jtpfinal = new JTabbedPane();


	public static void main(String args[]) throws Exception {
		/**Set the look and feel*/
		com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme("Black");
		UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");

		/** Log file */
		String logfilepath = System.getProperty("user.dir");
		File file = new File(logfilepath+"//logs.txt"); 
		FileOutputStream fos = new FileOutputStream(file, true);
		PrintStream ps = new PrintStream(fos);
		Date date = new Date();
		System.out.println("Time:"+date);
		System.setOut(ps);
		
		PORDataValidationTool tp = new PORDataValidationTool();
		tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tp.setVisible(true);
	}


	public PORDataValidationTool() throws IOException {
		/**Frame title, position and size*/
		setTitle("Test Data Analyser");
		setSize(600, 150);
		setLocationRelativeTo(null);

		/**Set Panel and add elements*/
		jp1 = new JPanel();
		label1 = new JLabel("Enter Input File: ");
		textfield1 = new JTextField(15);
		
		jp2 = new JPanel();
		label2 = new JLabel("Enter Input File: ");
		textfield2 = new JTextField(15);
		
		jp3 = new JPanel();
		label3 = new JLabel("Enter Input File: ");
		textfield3 = new JTextField(15);

		/**Buttons listed and actions to be performed when clicked*/

		runbutton = new JButton("RUN");
		browsebutton = new JButton("BROWSE");
		browsebutton1 = new JButton("BROWSE");
		browsebutton2 = new JButton("BROWSE");
		runbutton1 = new JButton("RUN");
		runbutton2 = new JButton("RUN");

		runbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag;

				String filename1 = textfield1.getText();
				File file = new File(filename1);
				filepath = file.getParent();
				EHubValidation eh = new EHubValidation();
				try {
					eh.execute(filename1, filepath);
					flag = true;
				} catch (Exception e1) {
					flag = false;
					e1.printStackTrace();
				}
				if(flag)
					JOptionPane.showMessageDialog(runbutton, "eHUBValidation is completed Successfully!!! in the path "+filepath, "Alert", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(runbutton, "Not Generated", "Alert", JOptionPane.OK_OPTION);
			}
		});




		browsebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
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
		

		browsebutton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
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
					textfield2.setText(file.toString());
				}

			}
		});
		
		browsebutton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
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
					textfield3.setText(file.toString());
				}

			}
		});
		
		runbutton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag;

				String filename1 = textfield2.getText();
				File file = new File(filename1);
				filepath = file.getParent();
				RPCValidation rpc = new RPCValidation();
				try {
					rpc.execute(filename1, filepath);
					flag = true;
				} catch (Exception e1) {
					flag = false;
					e1.printStackTrace();
				}
				if(flag)
					JOptionPane.showMessageDialog(runbutton, "RPC Validation is completed Successfully!!! in the path "+filepath, "Alert", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(runbutton, "Not Generated", "Alert", JOptionPane.OK_OPTION);
			}
		});
		
		runbutton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag;
				String filename1 = textfield3.getText();
				File file = new File(filename1);
				filepath = file.getParent();
				Validation val =new Validation();
				try {
					val.execute(filename1);
					flag = true;
				} catch (Exception e1) {
					flag = false;
					e1.printStackTrace();
				}
				if(flag)
					JOptionPane.showMessageDialog(runbutton, "Validation is completed Successfully!!! Updated sheet in the path "+filepath, "Alert", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(runbutton, "Not Generated", "Alert", JOptionPane.OK_OPTION);
			}
		});



		jp1.add(label1);
		jp1.add(textfield1);
		jp1.add(browsebutton);
		jp1.add(runbutton);
		
		jp2.add(label2);
		jp2.add(textfield2);
		jp2.add(browsebutton1);
		jp2.add(runbutton1);
		
		
		jp3.add(label3);
		jp3.add(textfield3);
		jp3.add(browsebutton2);
		jp3.add(runbutton2);
		

		/**Add components in Frame*/
		jtp.add("Validation", jp3);
		jtp.add("eHUB Validation", jp1);
		jtp.add("RPC Validation", jp2);
		add(jtp);
	}


}
