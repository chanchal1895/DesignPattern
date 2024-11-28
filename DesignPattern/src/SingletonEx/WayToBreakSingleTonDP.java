		package SingletonEx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class WayToBreakSingleTonDP {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException, CloneNotSupportedException {
		Sigleton objOriginal = Sigleton.getInstance();
		Sigleton objCopy = Sigleton.getInstance();
		System.out.println("Hash code of objOriginal " + objOriginal.hashCode());
		System.out.println("Hash code of objCopy " + objCopy.hashCode());

		// 1. Reflection - way of breaking singleton DP
		Class<?> SingletonClass = Class.forName("SingletonEx.Sigleton");
		Constructor<Sigleton> constructor = (Constructor<Sigleton>) SingletonClass.getDeclaredConstructor();
		constructor.setAccessible(true);

		Sigleton brokenSingletonUsingRelectionObj = constructor.newInstance();
		System.out.println("Hash code of objOriginal " + objOriginal.hashCode());
		System.out.println(
				"Hash code of brokenSingletonUsingRelectionObj " + brokenSingletonUsingRelectionObj.hashCode());
		
		//2 Serialization - way of breaking singleton DP
		System.out.println("-----------------------------");
		System.out.println("Breaking SingletonDP using Serialization");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Serialization.ser"));
		oos.writeObject(objOriginal);
		oos.close();
		
		//deserialization
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Serialization.ser")) ;
		
		Sigleton brokenSingletonUsingSeralizObj = (Sigleton) ois.readObject();
		System.out.println("Hash code of objOriginal " + objOriginal.hashCode());
		System.out.println(
				"Hash code of brokenSingletonUsingSeralizObj " + brokenSingletonUsingSeralizObj.hashCode());
		
		//3 Clonning - way of breaking singleton DP
				System.out.println("-----------------------------");
				System.out.println("Breaking SingletonDP using Clonning");
		
				Sigleton brokenSingletonUsingClonning = (Sigleton) objOriginal.clone();
				
				System.out.println("Hash code of objOriginal " + objOriginal.hashCode());
				System.out.println(
						"Hash code of brokenSingletonUsingClonning " + brokenSingletonUsingClonning.hashCode());

	}
}

class Sigleton implements Serializable, Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Sigleton obj;

	private Sigleton() {
		System.out.println("Object Created");
	}

	public static Sigleton getInstance() {
		if (obj == null) {
			obj = new Sigleton();
		}
		return obj;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}