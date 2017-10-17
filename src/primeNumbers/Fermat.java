package primeNumbers;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Fermat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is to find out that if the number is Prime or not.");
		System.out.println("Enter number");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		System.out.println("Enter number of iterations");
		int n = sc.nextInt();
		sc.close();
		
		if(ifPrime(x, n)){
			System.out.println("Prime Number");
		} else {
			System.out.println("Not a Prime Number");
		}
	}

	public static boolean ifPrime(int x, int n){
		for(int i = 1; i < n; i++){
			// nextInt is normally exclusive of the top value,
			// so add 1 to make it inclusive
			int a = ThreadLocalRandom.current().nextInt(2, x-1);
			if (PowerMod.powermod(a, x-1, x) != 1){
				return false;
			}		
		}
		return true;
	}
	
}
