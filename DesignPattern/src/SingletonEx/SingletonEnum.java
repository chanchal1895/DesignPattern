package SingletonEx;

public class SingletonEnum {
	public static void main(String[] args) {
		Abc3 obj = Abc3.INSTANCE;
		obj.i=8;
		obj.show();
		
		Abc3 obj1 = Abc3.INSTANCE;
		obj1.i=20;
		obj1.show();
		
	}
}

enum Abc3{
	INSTANCE;//= public void getInstance(){} and it has by default private constructor
	
	int i;
	public void show() {
		System.out.println(i);
	}
}