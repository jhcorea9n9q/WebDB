package Board;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UTIL.DBConnection;

@WebServlet("/List")
public class List extends HttpServlet {
	
	private Connection CON;
	private java.util.List<HashMap<String, Object>> LIST;
	private String SQL, HTML;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnection DBC = new DBConnection();
		
		try {
			CON = DBC.openDB();
			// Doget을 오버라이드 하면 안 되기 때문에 Try/Catch문으로 예외처리를 해야한다.

				SQL = "select * from ExcelData where 삭제여부 = 'N'";
				LIST = DBC.select(CON, SQL);
				HTML = "";
				
				for(int i = 0; i <LIST.size(); i++) {
					System.out.println(LIST.get(i));
					HTML += LIST.get(i) + "<br>";
				}
//				response.setContentType("text/html; charset=UTF-8"); 
//				response.setCharacterEncoding("UTF-8");
//				response.getWriter().append(HTML);
				
				request.setAttribute("LIST", LIST);
				RequestDispatcher RD = request.getRequestDispatcher("List.jsp");
				RD.forward(request, response);
				
			CON.close();
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
