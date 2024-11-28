package SingletonEx;

public class SingletonLazyEx
{
	public static void main(String[] args) {
		Abc1 obj = Abc1.getInstance();
		Abc1 obj2 = Abc1.getInstance();
	}
}
class Abc1{
	
	private static Abc1 obj;
	
	private Abc1() {
		System.out.println("object created");
	}
	public static Abc1 getInstance() {
		if(obj==null)
		{
			obj = new Abc1();
		}
		return obj;
	}
}