package automationLib;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TestDataPOJO.memberdetails;
import utils.Utilities;

public class DB_Validation {

	Utilities comnutils= new Utilities();

	String urlSITMember = "jdbc:oracle:thin:@va10dx05-scan2.wellpoint.com:1525/EHU1S";
	String urlUATMember = "jdbc:oracle:thin:@va10dx10v1-scan1.wellpoint.com:1525/EHMBRS1U";
	String urlUATProducts = "jdbc:oracle:thin:@va10dx10v1-scan1.wellpoint.com:1525/EHPRDS1U";
	String urlUATClaims = "jdbc:oracle:thin:@va10dx10v1-scan1.wellpoint.com:1525/EHCLMS1U";

	public Map<String, ArrayList<String>> fetchDataFromDB(String url, String query) throws ClassNotFoundException, SQLException {

		ResultSet  resultSet = null;

		switch (url) {
		case "SITMember":
			resultSet = comnutils.dbConnection(urlSITMember, query);
			break;

		case "UATMember":
			resultSet = comnutils.dbConnection(urlUATMember, query);
			break;

		case "UATProducts":
			resultSet = comnutils.dbConnection(urlUATProducts, query);
			break;

		case "UATClaims":
			resultSet = comnutils.dbConnection(urlUATClaims, query);
			break;

		default:
			System.out.println("Input from feature file is not a valid one. Please change Input to SITMember, UATMember, UATProducts or UATClaims");
			break;
		}

		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		map = resultSetToMap(resultSet);
		
		return map;
	}

	private Map<String, ArrayList<String>> resultSetToMap(ResultSet rs) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		Map<String, ArrayList<String>> rows = new HashMap<String, ArrayList<String>>();

		
		for(int i = 1; i <= columns; ++i){
			ArrayList<String> row = new ArrayList<String>();
			while (rs.next()){
				row.add(rs.getString(i));
			}
			rs.beforeFirst();
			rows.put(md.getColumnName(i), row);
		}

		System.out.println(rows.get("HCID"));
		System.out.println(rows.get("MBR_UNIQ_ID"));

		return rows;
	}



}
