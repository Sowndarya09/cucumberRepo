package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Searcher {

	  private static final String defaultPath = System.getProperty("user.dir")+"\\batch1";
	  static String toSearch = "WrapUp";

	  
	  
	  private static String filepath = null;
	  private Map<String, Integer> result =  new HashMap<String, Integer>();

	  private Searcher() {
	    this.filepath = defaultPath;
	  }


	  public static void main(String[] args) throws IOException {
	    Searcher search = new Searcher();

	    String folderToSearch = search.filepath;

	    File folder = new File(folderToSearch);
	    Set<File> list = new HashSet<File>();
	    search.getFiles(folder, list);

	    for (File file : list) {
	    	search.search(toSearch, file);
	    }
	  }

	  private void getFiles(File folder, Set<File> list) {

	    folder.setReadOnly();
	    File[] files = folder.listFiles();
	    for (int j = 0; j < files.length; j++) {
	      list.add(files[j]);
	      if (files[j].isDirectory())
	        getFiles(files[j], list);
	    }
	  }
	  
	  
	  
	  public void search(String toSearch, File file) throws IOException {
		  int count =0;
		    
		    FileInputStream fstream = new FileInputStream(file);
		      BufferedReader in = new BufferedReader(new InputStreamReader(fstream));
		      String readLine = "";
		      while ((readLine = in.readLine()) != null) {
		        String[] words = readLine.split("\\W");
		        for (String text : words) {
		          if (text.equalsIgnoreCase(toSearch)) {
		            count++;
		          }
		        }
		      }
		      in.close();
		      if (count != 0) {
		      System.out.println(file.getName() + " - " + count + " matches ");
		      }
		  }
	  
	}

