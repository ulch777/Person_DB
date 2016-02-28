import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDAO_MySQL implements PersonDAO {
	static Connection conn = null;
	static Statement st = null;

	@Override
	public void create(Person person) {
		try {
			connectionOnMysql();
			st.execute("INSERT INTO person VALUES (" + person.id + ",'" + person.fn + "','" + person.ln + "',"
					+ person.age + "); ");
			connectionOff();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> personList = new ArrayList<>();

//		if (person == null) 
//		{
			try {
				connectionOnMysql();
				ResultSet result;
				result = st.executeQuery("select * from person");

				while (result.next()) {
					Person personNew = new Person();

					personNew.setId(result.getInt("Id"));
					personNew.setFn(result.getString("Fname"));
					personNew.setLn(result.getString("Lname"));
					personNew.setAge(result.getInt("Age"));
					personList.add(personNew);
				}
				connectionOff();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return personList;
	}

	@Override
	public void update(Person person) {
		try {
			connectionOnMysql();
			st.execute("UPDATE person SET FName='" + person.fn + "', LName='" + person.ln + "', Age=" + person.age
					+ " WHERE Id=" + person.id + ";");
			connectionOff();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person p) {
		try {
			connectionOnMysql();
			st.execute("delete from person where Id = " + p.id + ";");
			connectionOff();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void connectionOnMysql() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "");
			st = conn.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void connectionOff() {
		try {
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
