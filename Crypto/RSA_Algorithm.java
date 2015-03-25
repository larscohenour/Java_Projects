/** PROGRAM ASSIGNMENT 7:     RSA_Alorithm.java
 *
 * Author:         Lars Cohenour
 * Student ID:	   11544807
 * Class:          CIT 2563/ITD 3523: Computer Security, Monday 5:40-6:55
 *
 * Program Description:
 * Program to solve RSA; takes p,q,n,plaintext (number to encrypt), and cyphertext (number to decrypt)
 * and calculates and displays n, totient of n, d, cyphertext (encryptedPlainText), and plaintext (decryptedCypherText).
 */
import java.util.Scanner;
import java.math.*;

public class RSA_Algorithm
{
	public static void main(String []args)
	{
		//Create scanner
		Scanner input = new Scanner(System.in);

		/*Student Information*/
		System.out.println("Program written by Lars Cohenour\t" + "Student ID:  11544807" + "\n \n" + "For Homework Assignment 7: RSA, in CIT 2563: Computer Security");

		/*Formatting*/
		System.out.println("__________________________________________________________________________________ \n");

		//inputs for p, q, e,plainText (number to encrypt), and cypherText (number to decrypt)
		System.out.print("Enter the value for p: "); BigInteger p = input.nextBigInteger();

		/*formatting*/System.out.print("\n");

		System.out.print("Enter the value for q: "); BigInteger q = input.nextBigInteger();

		/*formatting*/System.out.print("\n");

		System.out.print("Enter the value for e: "); BigInteger e = input.nextBigInteger();

		/*formatting*/System.out.print("\n");

		System.out.print("Enter the number to encrypt: "); BigInteger plainText = input.nextBigInteger();

		/*formatting*/System.out.print("\n");

		System.out.print("Enter the number to decrypt: "); BigInteger cypherText = input.nextBigInteger();

		/*formatting*/System.out.print("\n");

		//declare and get value of n
		BigInteger n = p.multiply(q);//where p & q are distinct primes

		//declare and get totient of n
		BigInteger totientOfN = ((p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)));

		//declare and get value of d (causes error if large value of e or totient of n)
		BigInteger d = e.modInverse(totientOfN);

		//declare and get values for encryptedPlaintext and decryptedCypherText
		//modPow method of BigInteger uses the same equation as the equation of encryption/decryption
		BigInteger encryptedPlainText = plainText.modPow(e, n);

		BigInteger decryptedCypherText = cypherText.modPow(d, n);

		//output n, totient of n, d, cyphertext, plaintext
		System.out.println("The value of n is " + n);

		/*formatting*/System.out.print("\n");

		System.out.println("The totient of n is " + totientOfN);

		/*formatting*/System.out.print("\n");

		System.out.println("The value of d is " + d);

		/*formatting*/System.out.print("\n");

		System.out.println("The plaintext encrypted to cyphertext is " + encryptedPlainText);

		/*formatting*/System.out.print("\n");

		System.out.println("The decrypted plaintext is " + decryptedCypherText);

		/*formatting*/System.out.print("\n");
	}
}