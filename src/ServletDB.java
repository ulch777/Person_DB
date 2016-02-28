

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/ServletDB")
public class ServletDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDB() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ID = 0;
		String FName  = request.getParameter("FName");
		String LName  = request.getParameter("LName");
		int Age = 0;
		String Crud  = request.getParameter("Crud");
		PersonDAO pd = new PersonDAO_MySQL();
		
		
		if (!request.getParameter("ID").isEmpty()){
		ID  = Integer.parseInt(request.getParameter("ID"));
		}
		if (!request.getParameter("Age").isEmpty()){
		Age  = Integer.parseInt(request.getParameter("Age"));
		}
		Person person = new Person(ID, FName, LName, Age);
		ArrayList<Person> pp =  new  ArrayList<Person>();
		
		switch(Crud){
		case ("create") : pd.create(person); 
		break;
		case ("read") : pp = pd.read();
		break;
		case ("update") : pd.update(person);
		break;
		case ("delete") : pd.delete(person);
		break;
		default : pp = pd.read();
		}
		response.getWriter().println(new Gson().toJson(pp));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
