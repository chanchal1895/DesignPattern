package FactoryDP;

public class OSFactory {
	
	public OS getInstance(String str) {
		
		if(str.equals("UserFriendly"))
			return new Android();
		else if(str.equals("Powerful"))
			return new IOS();
		else
			return new Windows();
	}

}
