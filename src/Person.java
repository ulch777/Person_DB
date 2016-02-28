

public class Person 
{
	int id;
	String fn;
	String ln;
	int age;
	Person(int id, String fn, String ln, int age)
	{
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.age = age;
	}
	Person(){ }
	
	public void setId(int id) {
		this.id = id;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public String getFn() {
		return fn;
	}
	public String getLn() {
		return ln;
	}
	public int getAge() {
		return age;
	}
}
