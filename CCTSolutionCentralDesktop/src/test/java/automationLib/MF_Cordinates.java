package automationLib;

public class MF_Cordinates {
	
	static String x;
	static String y;
	
	public static void MF_Cordinates(String x,String y){
		
	setX(x);
	setY(y);
	}
	public static String getX() {
		return x;
	}
	public static void setX(String x) {
		MF_Cordinates.x = x;
	}
	public static String getY() {
		return y;
	}
	public static void setY(String y) {
		MF_Cordinates.y = y;
	}
	
	

}
