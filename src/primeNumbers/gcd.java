package primeNumbers;

import java.util.Scanner;

public class gcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter first number");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		System.out.println("Enter second number");
		int b = sc.nextInt();
		sc.close();
		
		System.out.println("GCD of this two numbers is "+gcdCompute(a, b));

	}
	
	public static int gcdCompute(int a, int b){
		while(b!=0){
			int temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}

}
