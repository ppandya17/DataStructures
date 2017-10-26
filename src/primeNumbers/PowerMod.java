package primeNumbers;

import java.util.Scanner;

public class PowerMod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This program is to Compute (X^n mod m) faster at O(log n)");
		System.out.println("Enter number X");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		System.out.println("Enter number N");
		int n = sc.nextInt();
		
		System.out.println("Enter number M");
		int m = sc.nextInt();
		
		sc.close();
		
		System.out.println("(X^n mod m) is "+powermod(x, n, m));
	}
	
	public static int powermod(int x, int n, int m){
		int prod = 1;
		
		while(n > 0){
			if((n & 1) == 1){
				prod = (prod * x) % m;
			}
			x = (x*x) % m;
			n = n/2;
		}
		return prod;
	}

}
