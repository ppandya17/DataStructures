package primeNumbers;

import java.util.Scanner;


public class lcm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This program is to find out LCM of two numbers");
		System.out.println("Enter first number");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		System.out.println("Enter second number");
		int b = sc.nextInt();
		sc.close();
		
		System.out.println("LCM of this two numbers is "+computeLCM(a, b));

	}
	
	public static int computeLCM(int a, int b){
		return a* b / gcd.gcdCompute(a, b);
	}

}
