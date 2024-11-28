package SingletonEx;

public class SingletonEagerEx {
	
	public static void main(String[] args) {
		Abc abc = Abc.getInstance();
		Abc abc2 = Abc.getInstance();
	}

}
class Abc{
	 
	static Abc obj = new Abc();//Eager Intantiation
	private Abc() {
		System.out.println("Object Created "+ obj);
	}
	public static Abc getInstance() {
		//System.out.println("Object Created"+ obj);
		return obj;
	}
	
}