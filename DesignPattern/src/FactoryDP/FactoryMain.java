package FactoryDP;

public class FactoryMain {
	public static void main(String[] args) {
		
		OSFactory objFactory= new OSFactory();
		OS obj = objFactory.getInstance("UserFriendly");
		OS obj2 = objFactory.getInstance("Powerful");
		obj.specs();
		obj2.specs();
		OS obj3 = objFactory.getInstance("");
		obj3.specs();
		
		
	}

}
