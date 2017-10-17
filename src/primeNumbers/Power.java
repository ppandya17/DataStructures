package primeNumbers;

import java.util.Scanner;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This program is to find the N power of any base number");
		System.out.println("Enter Base number");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		System.out.println("Enter power number");
		int n = sc.nextInt();
		sc.close();
		
		System.out.println("base^power of this two numbers is "+calculatePower(x, n));
	}

	public static int calculatePower(int x, int n){
		int prod = 1;
		while(n>0){
			if ((n & 1) == 1){
				prod = prod *x;
			}
			x = x*x;
			n = n/2;
		}
		return prod;
	}
}
