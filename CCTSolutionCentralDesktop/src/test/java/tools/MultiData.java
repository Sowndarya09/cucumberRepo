package tools;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class MultiData extends JFrame{
	/**
	 * 
	 */
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


	public static void main(String args[]) throws Exception {
		/**Set the look and feel*/
		com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme("Black");
		UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");

		MultiData tp = new MultiData();
		tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tp.setVisible(true);
	}


	public MultiData() throws IOException {
		/**Frame title, position and size*/
		setTitle("Feature File Data Parameterization");
		setSize(500, 300);
		setLocationRelativeTo(null);

		/**Set Panel and add elements*/
		multijp1 = new JPanel();
		multijp2 = new JPanel();
		JTabbedPane multijtp = new JTabbedPane();
		JTabbedPane multijtpfinal = new JTabbedPane();
		multilabel1 = new JLabel("Enter Feature File Path: ");
		multitextfield1 = new JTextField(15);
		multilabel2 = new JLabel("Enter Excel Sheet Path: ");
		multitextfield2 = new JTextField(15);

		multilabel3 = new JLabel("Enter Feature File Path: ");
		multitextfield3 = new JTextField(15);
		multilabel4 = new JLabel("Enter Excel Sheet Path: ");
		multitextfield4 = new JTextField(15);

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
					e1.printStackTrace();
					flag = false;
				}

				if(flag) {
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
				JFileChooser chooser = new JFileChooser();
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

				JFileChooser chooser = new JFileChooser();
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

				String filename3 = multitextfield3.getText();
				File file2 = new File(filename3);
				multifilepath = file2.getParent();
				JFileChooser chooser = new JFileChooser();
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
		c.gridx = 0;
		c.gridy = 0;
		multijp1.add(multilabel1,c);

		c.gridx = 0;
		c.gridy = 1;
		multijp1.add(multitextfield1,c);

		c.gridx = 0;
		c.gridy = 2;
		multijp1.add(multibrowsebutton1,c);

		c.gridx = 1;
		c.gridy = 0;

		c.gridx = 1;
		c.gridy = 1;

		c.gridx = 1;
		c.gridy = 2;

		c.gridx = 2;
		c.gridy = 2;
		multijp1.add(multicreateexcel,c);

		c.insets = ins;

		multijp3.add(multijp1);
		multijp2.add(multilabel3);
		multijp2.add(multitextfield3);
		multijp2.add(multibrowsebutton3);
		multijp2.add(multilabel4);
		multijp2.add(multitextfield4);
		multijp2.add(multibrowsebutton4);
		multijp2.add(multicreatefeaturefile); 

		/**Add components in Frame*/

		multijtp.add("Excel Template Generation", multijp1);
		multijtp.add("Feature File Creation", multijp2);
		multijtpfinal.add("MultiData",multijtp);
		add(multijtpfinal);
	}


}
