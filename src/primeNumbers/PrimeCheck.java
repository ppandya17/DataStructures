package primeNumbers;

import java.util.Scanner;

public class PrimeCheck {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("This program is to find out is input number is Prime number or not");
		System.out.println("Enter number");
		Scanner sc = new Scanner(System.in);
		Double n = sc.nextDouble();
		
		sc.close();
		
		if(isPrime(n)){
			System.out.println("Prime Number");
		} else {
			System.out.println("not a Prime Number");
		}
	}
	

	public static boolean isPrime(Double n){
		for(int i=2; i <= Math.sqrt(n); i++){
			if( n % i == 0){	
				return false;
			}
		}
		return true;
	}
	
}
