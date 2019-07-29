package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

import javax.swing.JFileChooser;

import org.omg.CORBA.Environment;

public class ReadFile {



	public static  String fileName = "C:\\images\\New folder\\Text.txt";
	public static void main(String [] args) throws IOException {

		// The name of the file to open.


		try {
			// Assume default encoding.
			FileWriter fileWriter =
					new FileWriter(fileName);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter =
					new BufferedWriter(fileWriter);

			// Note that write() does not automatically
			// append a newline character.
			bufferedWriter.write("chkbx Member Info : Hello there,\n$chkbx Member Info");
			bufferedWriter.write(" chkbx Contact Review: here is some text.$chkbx Contact Review");
			bufferedWriter.newLine();
			bufferedWriter.write("chkbx Group  Info : We are writing$chkbx Group  Info");
			bufferedWriter.write("Line 4  : the text to the file$Line 4");

			// Always close files.
			bufferedWriter.close();
		}
		catch(IOException ex) {
			System.out.println(
					"Error writing to file '"
							+ fileName + "'" + ex);
			// Or we could just do this:
			// ex.printStackTrace();
		}

		/*writeOver();
		writeOver();
		writeOver();
		writeOver();
		writeOver();*/


		try {
			// Use this for reading the data.
			byte[] buffer = new byte[1000];

			FileInputStream inputStream = 
					new FileInputStream(fileName);

			// read fills buffer with data and returns
			// the number of bytes read (which of course
			// may be less than the buffer size, but
			// it will never be more).
			int total = 0;
			int nRead = 0;
			while((nRead = inputStream.read(buffer)) != -1) {
				// Convert to String so we can display it.
				// Of course you wouldn't want to do this with
				// a 'real' binary file.


				System.out.println("once");
				System.out.println(new String(buffer));
				String str =new String(buffer);
/*
				System.out.println(str.indexOf("Line 2"));
				System.out.println(str.indexOf("Line 3"));*/
				String str1=str.substring(str.indexOf("chkbx Member Info"), str.indexOf("$chkbx Member Info"));
				System.out.println(str1.split(":")[1]);
				System.out.println(str.substring(str.indexOf("Line 1"), str.indexOf("$Line 1")));


				total += nRead;
			}   

			// Always close files.
			inputStream.close();        

			System.out.println("Read " + total + " bytes");
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							fileName + "'");                
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ fileName + "'");                  
			// Or we could just do this: 
			// ex.printStackTrace();
		}
	}


	public String readFile(String sKey)
	{
		
		System.out.println("=================================Checking Value of : "+ sKey );
		String sValue = null;
		try {
			// Use this for reading the data.
			byte[] buffer = new byte[1000];

			FileInputStream inputStream = 
					new FileInputStream(fileName);

			// read fills buffer with data and returns
			// the number of bytes read (which of course
			// may be less than the buffer size, but
			// it will never be more).
			int total = 0;
			int nRead = 0;
			
			if(sKey== null)
			{
				return null;
			}
			while((nRead = inputStream.read(buffer)) != -1) {
				// Convert to String so we can display it.
				// Of course you wouldn't want to do this with
				// a 'real' binary file.


				System.out.println("once");
			//	System.out.println(new String(buffer));
				String str =new String(buffer);

			

				System.out.println(str.indexOf(sKey) +" " + str.indexOf("$"+sKey));
				// check the value of the entered key should match in Data sheet  
				 sValue= str.substring(str.indexOf((sKey), str.indexOf("$"+sKey)));
				// System.out.println(sValue);
				 int index1=str.indexOf(sKey);
				 int indexlast=str.indexOf("$"+sKey);
				 sValue= str.substring(index1, indexlast);
				 System.out.println(sValue);
				 
				 
				total += nRead;
			}   

			// Always close files.
			inputStream.close();        

			System.out.println("Read :: " + total + " bytes");
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							fileName + "'");                
		}
		catch(Exception ex) {
			System.out.println(
					"Error reading file '" 
							+ fileName   + "'"); 
			System.out.println(sKey+ ": Error ");
			// Or we could just do this: 
			// ex.printStackTrace();
		}
		return sValue.split(":")[1].trim();
	}
	public static void writeOver(String str) throws IOException
	{

		String Data = str+"\n";
		File file = new File(fileName);
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(Data);
		bw.newLine();
		
		bw.close();
	}

	public void writeOnSheet(String str)
	{
		try {
			// Assume default encoding.
			FileWriter fileWriter =
					new FileWriter(fileName);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter =
					new BufferedWriter(fileWriter);

			// Note that write() does not automatically
			// append a newline character.
			bufferedWriter.write(str);
			/*bufferedWriter.write(" Line 2 : here is some text.\n");
             bufferedWriter.newLine();
             bufferedWriter.write("Line 3 : We are writing\n");
             bufferedWriter.write(" Line 4  : the text to the file.\n");*/

			// Always close files.
			bufferedWriter.close();
		}
		catch(IOException ex) {
			System.out.println(
					"Error writing to file '"
							+ fileName + "'" + ex);
			// Or we could just do this:
			// ex.printStackTrace();
		}

	}




}
