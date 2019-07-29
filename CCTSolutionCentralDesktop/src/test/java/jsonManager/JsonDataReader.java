package jsonManager;


import dataReader.JsonDataParsor;

public class JsonDataReader {
	
		
		private static JsonDataReader fileReaderManager = new JsonDataReader();
		//private static ConfigFileReader configFileReader;
		private static JsonDataParsor jsonDatareader;
		
		private JsonDataReader() {
		}
		
		 public static JsonDataReader getInstance( ) {
		      return fileReaderManager;
		 }
		
		 
		 public JsonDataParsor getJsonReader(){
			 return (jsonDatareader == null) ? new JsonDataParsor() : jsonDatareader;
		}
	}


