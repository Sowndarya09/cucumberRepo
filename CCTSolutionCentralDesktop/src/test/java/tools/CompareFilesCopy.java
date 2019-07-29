package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompareFilesCopy {
	List<Boolean> list = new ArrayList<Boolean>();
	boolean flag = false;
	
	static BufferedReader reader1;
	static BufferedReader reader2;
	static String line1;
	static String replacedline1;
	static String line2;
	static String replacedline2;
	
	  private ArrayList<String> longestCommonSubsequenceList;
      private static final String INSERT_COLOR = "#99FFCC";
      private static final String DELETE_COLOR = "#CB6D6D";
      
     static String text1 ;
     
     static String text2;
     
     static String result;
     
     
     private ArrayList<String> tempList;
     
	 
	 private String normalizeText(String text) {
         
         text = text.trim();
         text = text.replace("\n", " ");
         text = text.replace("\t", " ");
        
         while (text.contains("  ")) {
             text = text.replace("  ", " ");
         }
         return text;
     }
	 
	  private ArrayList<String> longestCommonSubsequence(String text1, String text2) {
          String[] text1Words = text1.split(" ");
          String[] text2Words = text2.split(" ");
          int text1WordCount = text1Words.length;
          int text2WordCount = text2Words.length;
         
          int[][] solutionMatrix = new int[text1WordCount + 1][text2WordCount + 1];
         
          for (int i = text1WordCount - 1; i >= 0; i--) {
              for (int j = text2WordCount - 1; j >= 0; j--) {
                  if (text1Words[i].equals(text2Words[j])) {
                      solutionMatrix[i][j] = solutionMatrix[i + 1][j + 1] + 1;
                  }
                  else {
                      solutionMatrix[i][j] = Math.max(solutionMatrix[i + 1][j],
                          solutionMatrix[i][j + 1]);
                  }
              }
          }
         
          int i = 0, j = 0;
          ArrayList<String> lcsResultList = new ArrayList<String>();
          while (i < text1WordCount && j < text2WordCount) {
              if (text1Words[i].equals(text2Words[j])) {
                  lcsResultList.add(text2Words[j]);
                  i++;
                  j++;
              }
              else if (solutionMatrix[i + 1][j] >= solutionMatrix[i][j + 1]) {
                  i++;
              }
              else {
                  j++;
              }
          }
          return lcsResultList;
      }
	  StringBuffer stringBuffer;
	  StringBuffer stringBuffer1;
	  String s1;
	  
	  private String markTextDifferences(String text1, String text2,
	            ArrayList<String> lcsList, String insertColor, String deleteColor) {
	            stringBuffer = new StringBuffer();
	            stringBuffer1 = new StringBuffer();
	            //String s;
	            if (text1 != null && lcsList != null) {
	                String[] text1Words = text1.split(" ");
	                String[] text2Words = text2.split(" ");
	                int i = 0, j = 0, word1LastIndex = 0, word2LastIndex = 0;
	                for (int k = 0; k < lcsList.size(); k++) {
	                    for (i = word1LastIndex, j = word2LastIndex;
	                        i < text1Words.length && j < text2Words.length;) {
	                        if (text1Words[i].equals(lcsList.get(k)) &&
	                            text2Words[j].equals(lcsList.get(k))) {
	                        	stringBuffer.append("<SPAN>" + lcsList.get(k) + " </SPAN>");
	                        	stringBuffer1.append("<SPAN>" + lcsList.get(k) + " </SPAN>");
	                            word1LastIndex = i + 1;
	                            word2LastIndex = j + 1;
	                            i = text1Words.length;
	                            j = text2Words.length;
	                        }
	                        else if (!text1Words[i].equals(lcsList.get(k))) {
	                            for (; i < text1Words.length &&
	                                !text1Words[i].equals(lcsList.get(k)); i++) {
	                  
	                                stringBuffer.append("<SPAN style='BACKGROUND-COLOR:" +  deleteColor + "'>" + text1Words[i] + " </SPAN>");
	                            }
	                        } else if (!text2Words[j].equals(lcsList.get(k))) {
	                            for (; j < text2Words.length && !text2Words[j].equals(lcsList.get(k)); j++) {
	                                stringBuffer1.append("<SPAN style='BACKGROUND-COLOR:" + insertColor + "'>" + text2Words[j] + " </SPAN>");
	                            }
	                        }
	                    }
	                }
	                for (; word1LastIndex < text1Words.length; word1LastIndex++) {
	                    stringBuffer.append("<SPAN style='BACKGROUND-COLOR:" + deleteColor + "'>" + text1Words[word1LastIndex] + " </SPAN>");
	                }
	                for (; word2LastIndex < text2Words.length; word2LastIndex++) {
	                    stringBuffer1.append("<SPAN style='BACKGROUND-COLOR:" + insertColor + "'>" + text2Words[word2LastIndex] + " </SPAN>");
	                }
	            }
	            s1  = stringBuffer.toString()+"~"+ stringBuffer1.toString();
	            return s1;
	            
	        }
    
	  String[] s;
	
	  
	  //Application app = new Application();
	  
	public String compareTwoFiles(String value) throws IOException {
		ArrayList<String> array = new ArrayList<String>();
		 ArrayList<String> array1 = new ArrayList<String>();
		
			reader1 = new BufferedReader(new FileReader(ImportExport.filePath1));
			reader2 = new BufferedReader(new FileReader(ImportExport.filePath2));
		//System.out.println("Reader 1: "+"C:\\Users\\AF56975\\Documents\\Compare\\"+CompareFeatureFiles.first);
		 //System.out.println("Reader 2: "+"C:\\Users\\AF56975\\Documents\\Compare1\\"+CompareFeatureFiles.second);	
		 
			line1 = reader1.readLine();
			 line2 = reader2.readLine();
  
		
		int lineNum = 1;
		if (line1 == null && line2 == null) {
			System.out.println("Both null");
		} else {
			while (line1 != null || line2 != null) {
				try {
					if (line1.length() == 0) {
						line1 = reader1.readLine();
						line1 = line1.replace("<", "{").replace(">", "}").replace(",", ";");
					} else if (line2.length() == 0) {
						line2 = reader2.readLine();
						line2 = line2.replace("<", "{").replace(">", "}").replace(",", ";");
					} else if (!line1.equalsIgnoreCase(line2)) {
						
						flag = false;
						list.add(flag);
						this.longestCommonSubsequenceList = longestCommonSubsequence(line1, line2);
				        result = markTextDifferences(line1, line2,
				             longestCommonSubsequenceList, INSERT_COLOR, DELETE_COLOR);
				        s = result.split("~");
				        System.out.println("Value 1 : "+s[0]+"\n");
				        System.out.println("Value 2 : "+s[1]+"\n");
				        array.add(s[0]);
				        array1.add(s[1]);
				       
				        	
						//System.out.println("Files has different content.. File1 has " + line1 + " in line " + lineNum
								//+ " and File2 has " + line2 + " in line " + lineNum);
						line1 = reader1.readLine();
						line1 = line1.replace("<", "{").replace(">", "}").replace(",", ";");
						line2 = reader2.readLine();
						line2 = line2.replace("<", "{").replace(">", "}").replace(",", ";");
						lineNum++;
					}
					else {
						
						flag = true;
						list.add(flag);
						array.add(line1);
				        array1.add(line2);
						// System.out.println("PASS "+ line1+ line2);
						// System.out.println("Two Files have same content");
						line1 = reader1.readLine();
						line1 = line1.replace("<", "{").replace(">", "}").replace(",", ";");
						line2 = reader2.readLine();
						line2 = line2.replace("<", "{").replace(">", "}").replace(",", ";");
						lineNum++;
					}
				} catch (NullPointerException e) {
					if (line1 == null) {
						//System.out.println("File1 has " + line1 + " and File2 has " + line2);
						break;
					} else {
						//System.out.println("File1 has " + line1 + " and File2 has " + line2);
						break;
					}
				}
			}
			if (!list.contains(false)) {
				System.out.println("Two files matched");
			}
			reader1.close();
			reader2.close();
		}
		
		if(value.equals("one"))
			return array.toString();
		else
			return array1.toString();	
	}
	
	
	
	public String compareTwoFilesForMultiCompare(String value,String filename) throws IOException {
		//CompareFeatureFiles.compare();
		ArrayList<String> array2 = new ArrayList<String>();
		 ArrayList<String> array3 = new ArrayList<String>();
		
			 reader1 = new BufferedReader(new FileReader(ImportExport.filePath12+"\\"+filename));
			// reader1 = new BufferedReader(new FileReader("C://Users//AF56975//Documents//Compare//CCTSUSTAIN-31504.feature"));
			// System.out.println("Path: "+ImportExport.filePath12+"\\"+filename);
			 reader2 = new BufferedReader(new FileReader(ImportExport.filePath13+"\\"+filename));
			// reader2 = new BufferedReader(new FileReader("C://Users//AF56975//Documents//Compare1//CCTSUSTAIN-31504.feature"));
			// System.out.println("Path: "+ImportExport.filePath13+"\\"+filename);
	 
			 line1 = reader1.readLine();
			 line2 = reader2.readLine();

	     
		
		int lineNum = 1;
		if (line1 == null && line2 == null) {
			System.out.println("Both null");
		} else {
			while (line1 != null || line2 != null) {
				try {
					if (line1.length() == 0) {
						line1 = reader1.readLine();
						line1 = line1.replace("<", "{").replace(">", "}").replace(",", ";");
					} else if (line2.length() == 0) {
						line2 = reader2.readLine();
						line2 = line2.replace("<", "{").replace(">", "}").replace(",", ";");
					} else if (!line1.equalsIgnoreCase(line2)) {
						
						flag = false;
						list.add(flag);
						System.out.println("List: "+list.toString());
						this.longestCommonSubsequenceList = longestCommonSubsequence(line1, line2);
				        result = markTextDifferences(line1, line2,
				             longestCommonSubsequenceList, INSERT_COLOR, DELETE_COLOR);
				        s = result.split("~");
				        System.out.println("Result: "+result);
				        System.out.println("Value 1 : "+s[0]+"\n");
				        System.out.println("Value 2 : "+s[1]+"\n");
				        array2.add(s[0]);
				        array3.add(s[1]);
				       
				        	
						line1 = reader1.readLine();
						line1 = line1.replace("<", "{").replace(">", "}").replace(",", ";");
						line2 = reader2.readLine();
						line2 = line2.replace("<", "{").replace(">", "}").replace(",", ";");
						lineNum++;
					}
					else {
						
						flag = true;
						list.add(flag);
						array2.add(line1);
				        array3.add(line2);

						line1 = reader1.readLine();
						line1 = line1.replace("<", "{").replace(">", "}").replace(",", ";");
						line2 = reader2.readLine();
						line2 = line2.replace("<", "{").replace(">", "}").replace(",", ";");
						lineNum++;
					}
				} catch (NullPointerException e) {
					if (line1 == null) {
						//System.out.println("File1 has " + line1 + " and File2 has " + line2);
						break;
					} else {
						//System.out.println("File1 has " + line1 + " and File2 has " + line2);
						break;
					}
				}
			}
			if (!list.contains(false)) {
				System.out.println("Two files matched");
			}
			reader1.close();
			reader2.close();
		}
		
		if(value.equals("one"))
			return array2.toString();
		else
			return array3.toString();
	}
	
	
	public String abc(String filename) throws IOException
	{
		ArrayList<String> array2 = new ArrayList<String>();
		 ArrayList<String> array3 = new ArrayList<String>();
		
			 reader1 = new BufferedReader(new FileReader("C:\\Users\\AF56975\\Documents\\Compare\\"+filename));
			// System.out.println("Path: "+ImportExport.filePath12+"\\"+filename);
			 reader2 = new BufferedReader(new FileReader("C:\\Users\\AF56975\\Documents\\Compare1\\"+filename));
			// System.out.println("Path: "+ImportExport.filePath13+"\\"+filename);
	 
			 line1 = reader1.readLine();
			 line2 = reader2.readLine();

	     
		
		int lineNum = 1;
		if (line1 == null && line2 == null) {
			System.out.println("Both null");
		} else {
			while (line1 != null || line2 != null) {
				try {
					if (line1.length() == 0) {
						line1 = reader1.readLine();
						line1 = line1.replace("<", "{").replace(">", "}").replace(",", ";");
					} else if (line2.length() == 0) {
						line2 = reader2.readLine();
						line2 = line2.replace("<", "{").replace(">", "}").replace(",", ";");
					} else if (!line1.equalsIgnoreCase(line2)) {
						
						/*flag = false;
						list.add(flag);
						System.out.println("List: "+list.toString());
						this.longestCommonSubsequenceList = longestCommonSubsequence(line1, line2);
				        result = markTextDifferences(line1, line2,
				             longestCommonSubsequenceList, INSERT_COLOR, DELETE_COLOR);
				        s = result.split("~");
				        System.out.println("Result: "+result);
				        System.out.println("Value 1 : "+s[0]+"\n");
				        System.out.println("Value 2 : "+s[1]+"\n");
				        array2.add(s[0]);
				        array3.add(s[1]);
				       
				        	
						line1 = reader1.readLine();
						line1 = line1.replace("<", "{").replace(">", "}").replace(",", ";");
						line2 = reader2.readLine();
						line2 = line2.replace("<", "{").replace(">", "}").replace(",", ";");
						lineNum++;*/
						flag=false;
						tempList.add(filename);
						System.out.println("Two files mismatched");
						System.out.println("Filename: "+tempList.toString());
					}
					else {
						
						flag = true;
						list.add(flag);
						array2.add(line1);
				        array3.add(line2);

						line1 = reader1.readLine();
						line1 = line1.replace("<", "{").replace(">", "}").replace(",", ";");
						line2 = reader2.readLine();
						line2 = line2.replace("<", "{").replace(">", "}").replace(",", ";");
						lineNum++;
					}
				} catch (NullPointerException e) {
					if (line1 == null) {
						//System.out.println("File1 has " + line1 + " and File2 has " + line2);
						break;
					} else {
						//System.out.println("File1 has " + line1 + " and File2 has " + line2);
						break;
					}
				}
			}
			if (!list.contains(false)) {
				System.out.println("Two files matched");
			}
			reader1.close();
			reader2.close();
		}
		return filename;
		

	}
	
	
	public String compareTwoFilesForMultiCompareForOffline(String value,String filename) throws IOException {
		//CompareFeatureFiles.compare();
		ArrayList<String> array2 = new ArrayList<String>();
		 ArrayList<String> array3 = new ArrayList<String>();
		
			 reader1 = new BufferedReader(new FileReader(ImportExport.filePath12+"\\"+filename));
			// System.out.println("Path: "+ImportExport.filePath12+"\\"+filename);
			 reader2 = new BufferedReader(new FileReader(ImportExport.filePath13+"\\"+filename));
			// System.out.println("Path: "+ImportExport.filePath13+"\\"+filename);
	 
			 line1 = reader1.readLine();
			 line2 = reader2.readLine();

	     
		
		int lineNum = 1;
		if (line1 == null && line2 == null) {
			System.out.println("Both null");
		} else {
			while (line1 != null || line2 != null) {
				try {
					if (line1.length() == 0) {
						line1 = reader1.readLine();
						line1 = line1.replace("<", "{").replace(">", "}").replace(",", ";");
					} else if (line2.length() == 0) {
						line2 = reader2.readLine();
						line2 = line2.replace("<", "{").replace(">", "}").replace(",", ";");
					} else if (!line1.equalsIgnoreCase(line2)) {
						
						flag = false;
						list.add(flag);
						System.out.println("List: "+list.toString());
						this.longestCommonSubsequenceList = longestCommonSubsequence(line1, line2);
				        result = markTextDifferences(line1, line2,
				             longestCommonSubsequenceList, INSERT_COLOR, DELETE_COLOR);
				        s = result.split("~");
				        System.out.println("Result: "+result);
				        System.out.println("Value 1 : "+s[0]+"\n");
				        System.out.println("Value 2 : "+s[1]+"\n");
				        array2.add(s[0]);
				        array3.add(s[1]);
				       
				        	
						line1 = reader1.readLine();
						line1 = line1.replace("<", "{").replace(">", "}").replace(",", ";");
						line2 = reader2.readLine();
						line2 = line2.replace("<", "{").replace(">", "}").replace(",", ";");
						lineNum++;
					}
					else {
						
						flag = true;
						list.add(flag);
						array2.add(line1);
				        array3.add(line2);

						line1 = reader1.readLine();
						line1 = line1.replace("<", "{").replace(">", "}").replace(",", ";");
						line2 = reader2.readLine();
						line2 = line2.replace("<", "{").replace(">", "}").replace(",", ";");
						lineNum++;
					}
				} catch (NullPointerException e) {
					if (line1 == null) {
						//System.out.println("File1 has " + line1 + " and File2 has " + line2);
						break;
					} else {
						//System.out.println("File1 has " + line1 + " and File2 has " + line2);
						break;
					}
				}
			}
			if (!list.contains(false)) {
				System.out.println("Two files matched");
			}
			reader1.close();
			reader2.close();
		}
		
		if(value.equals("one"))
			return array2.toString();
		else
			return array3.toString();
	}
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		CompareFilesCopy cp = new CompareFilesCopy();
		//cp.compareTwoFiles();
		//cp.compareTwoFilesForMultiCompare("one");
		cp.abc("CCTSUSTAIN-31504.feature");
	}
}
