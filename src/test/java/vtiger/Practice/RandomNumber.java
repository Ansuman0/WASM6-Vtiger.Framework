package vtiger.Practice;

import java.util.Random;

public class RandomNumber {
	
	public static void main(String[] args) {
		
		Random ran = new Random();
		int r = ran.nextInt(1000);
		System.out.println(r);
		
	}

}
