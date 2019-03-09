package de.hsog.algorithm;

public class Hashing {

	public static void main(String[] args) {
		System.out.println( "+5% +3  = " + (+5% +3) );   //  2
		System.out.println( "+5 / +3 = " + (+5 / +3) );  //  1

		System.out.println( "+5% –3  = " + (+5% (-3)) );   //  2
		System.out.println( "+5 / –3 = " + (+5 / -3) );  // –1

		System.out.println( "-5% +3  = " + (-5% +3) );   // –2
		System.out.println( "-5 / +3 = " + (-5 / +3) );  // –1

		System.out.println( "-5% –3  = " + (-5% -3) );   // –2
		System.out.println( "-5 / –3 = " + (-5 / -3) );  //  1
		
		System.out.println("------------------------------");
		for (int i = 0; i < 15; i++) {
			System.out.println( i+" % 5  = " + (i % 5));  	
		}
		

	}

}
