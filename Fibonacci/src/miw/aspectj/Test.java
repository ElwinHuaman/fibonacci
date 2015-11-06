package miw.aspectj;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		int x = ran.nextInt(20)+5;

		for (int n = 0; n < x; n++) {			
			int fn = Calculator.fibonacci(n);
			System.out.println( n + ",F(" + n + ")=" + fn);	
		}
	}

}
