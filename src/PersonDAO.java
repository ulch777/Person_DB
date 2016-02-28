

import java.io.IOException;
import java.util.ArrayList;

public interface PersonDAO 
{	
	public void create(Person p) throws IOException;
	public ArrayList<Person> read() throws IOException;
	public void update(Person p) throws IOException;
	public void delete(Person p) throws IOException;
}
