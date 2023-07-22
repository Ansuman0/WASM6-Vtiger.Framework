package vtiger.Practice;

public class GenericMethodPractice {
	
	public static void main(String[] args) { // caller method
		
		int c =add(40,400);
		System.out.println(c);
		
	}

	
	public static int add(int a, int b) // called method
	{
		int c = a+b;
		return c;
	}
	
	
}
