package Board;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UTIL.DBConnection;

@WebServlet("/Insert")
public class Insert extends HttpServlet {
	
	private Connection CON;
	private String SQL, HTML, Title, Content, RegUser, RegDate;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		DBConnection DBC = new DBConnection();
		
		try {
			Title = request.getParameter("제목");
			Content = request.getParameter("내용");
			RegUser = "Admin";
			RegDate = "20180427";
			
			CON = DBC.openDB();
			SQL = "insert into ExcelData (제목, 내용, 작성자, 작성일자)";
			SQL += "values ";
			SQL += "(?, ?, ?, ?)";
			
			java.util.List LIST = new ArrayList() ;
			LIST.add(Title);
			LIST.add(Content);
			LIST.add(RegUser);
			LIST.add(RegDate);
			
			int RESULT = DBC.edit(CON, SQL, LIST);
			System.out.println(RESULT);
			
			response.sendRedirect("List");
			
			CON.close();
			
		}	catch (Exception e) {
			e.printStackTrace();	
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
