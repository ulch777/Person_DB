import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class PersonDAO_HttpConnect implements PersonDAO {
	String crud = "";
	String json = "";
	
	@Override
	public void create(Person p) throws IOException {
		crud = "create";
		HttpCon(crud, p);
	}

	@Override
	public ArrayList<Person> read() throws IOException {
		crud = "read";
		Person p = new Person();
		HttpCon(crud, p);
		return parse(json);
	}

	@Override
	public void update(Person p) throws IOException {
		crud = "update";
		HttpCon(crud, p);
	}

	@Override
	public void delete(Person p) throws IOException {
		crud = "delete";
		HttpCon(crud, p);
	}
	
	public void HttpCon(String crud, Person p) throws IOException{
		String params = "ID="+p.id+"&FName="+p.fn+"&LName="+p.ln+"&Age="+p.age+"&Crud="+crud;
		String url = "http://localhost:8080/calc/ServletDB?"+params;
		URL obj = new URL(url);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		json = response.toString();
	}
	
	private ArrayList<Person> parse(String json){
		ArrayList<Person> pp = new ArrayList<>();
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		Type type = new TypeToken<ArrayList<Person>>(){}.getType();
		pp = gson.fromJson(json, type);
		return pp;	
	}
}
