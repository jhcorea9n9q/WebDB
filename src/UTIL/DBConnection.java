package UTIL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBConnection {
	private static String URL = "jdbc:mysql://MariaDB:3306/test";
	private static String USER = "root";
	private static String PWD = "1234";
	private static List<HashMap<String, Object>> 	 LIST = null;
	// 노출되면 안되는 변수들을, 이 클래스에서만 쓰기 위해 private으로 (메소드는 public으로)
	// 아래의 메소드가 static을 써 메모리에 담아줬으니 변수도 static을 써주자
	
	public static Connection openDB() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PWD);
	}
	
	public static List<HashMap<String, Object>> select(Connection CON, String SQL) throws Exception {
		LIST = new ArrayList<HashMap<String, Object>>();
		
		PreparedStatement PS = CON.prepareStatement(SQL);	
		ResultSet RS = PS.executeQuery();
		ResultSetMetaData RM = RS.getMetaData();
		while(RS.next()) { 
						HashMap<String, Object> MAP = new HashMap<String, Object>();
						for(int i = 1; i <= RM.getColumnCount(); i++) {
								String COLUMN = RM.getColumnName(i);
								Object VALUE = "";								
								if("java.lang.String".equals(RM.getColumnClassName(i))) {
									VALUE = RS.getString(COLUMN);
								} else if("java.lang.Integer".equals(RM.getColumnClassName(i))) {
									VALUE = RS.getInt(COLUMN);
								}
								
								MAP.put(COLUMN, VALUE);
					}
						
					LIST.add(MAP);
		}
					
	   RS.close();
	   PS.close();
	   // close는 만든것과 역순으로 해주자.
		
		return LIST;
	}
	
	public static int edit(Connection CON, String SQL, List DATALIST) throws Exception {
			PreparedStatement PS = CON.prepareStatement(SQL);
			
			for(int i = 1; i <= DATALIST.size(); i++) {
				PS.setString(i, DATALIST.get(i-1).toString());
			}
			
			int RESULT = PS.executeUpdate();
			PS.close();
		return RESULT;
		// 콘솔에 1이 뜨면 성공적.
	}
	// 업데이트 델리트 인서트는 전부 같은 방식이니 edit로 메소드를 통합.
}
