



public class FactoryClient {

	private static PersonDAO dao = null;

	public static PersonDAO getI(){

		if (dao == null)
		{
//			dao = new PersonDAO_Hibernate();
//			dao = new PersonDAO_Hibernate1();
//			dao = new PersonDAO_H2();
//			dao = new PersonDAO_MySQL();
//			dao = new PersonDAO_Xml();
//			dao = new PersonDAO_Json();
//			dao = new PersonDAO_Mock();
//			dao = new PersonDAO_Mongo();
//			dao = new PersonDAO_NetClient();
//			dao = new PersonDAO_Stub();
			dao = new PersonDAO_HttpConnect();
		}
		return dao;
	}  
}