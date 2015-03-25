/*
 * PROGRAM ASSIGNMENT 1     CaesarCipher.java
 *
 * Author:         Lars Cohenour
 * Student ID:	   11544807
 * Class:          CIT 2563/ITD 3523: Computer Security, Monday 5:40-6:55
 *
 * Program Description:
 *   Program to decipher caesar cipher given by professor by applying a shift value acquired from user
 *   to the message and wrapping the ANSI values of the characters between 65 and 90.  For more information
 *   see comments above while loop.
*/
import java.util.Scanner;

public class CaesarCipher
{
	public static void main(String[] args)
	{
		/*Create Scanner object*/
		Scanner input = new Scanner(System.in);


			/*Student Information*/
			System.out.println("Program written by Lars Cohenour\t" + "Student ID:  11544807" + "\n \n" + "For Homework Assignment 1 in CIT 2563: Computer Security");

			/*Formatting*/
			System.out.println("___________________________________________________________________________________");

			System.out.println("Enter the phrase you want to encrypt or decrypt: ");

			String cipher =  input.nextLine();

			cipher = cipher.toUpperCase();

			System.out.println();
			//To uses encrypted text provided for the assignment, uncomment the "String cipher" variable below and comment out lines 29-33

			//String cipher = "WKHQHWZRUNLQJDQGFBEHUVHFXULWBGHSDUWPHQWDWURVHVWDWHFROOHJHRIIHUVDFHUWLILFDWHSURJUDPLQLQIRUPDWLRQVHFXULWBDWDOOIHGHUDOWUDLQLQJOHYHOVWKHSURJUDPFHUWLILHVWKHVWXGHQWVVDWLVIBLQJSURJUDPUHTXLUHPHQWVDUHWUDLQHGWRWKHIHGHUDOQVWLVVLFQVVLVWDQGDUGVIRULQIRUPDWLRQVBVWHPVVHFXULWBSURIHVVLRQDOVGHVLJQDWHGDSSURYLQJDXWKRULWLHVLQIRUPDWLRQVBVWHPVHFXULWBRIILFHUVVBVWHPVFHUWLILHUVDQGULVNDQDOBVWUHVSHFWLYHOB";
			/*Corrected typo by adding W at 6th position of String cipher so statement says networking instead of neworking*/

			/*Output message to decrypt to user*/
			System.out.println("You need to decrypt the following message by shifting the value of the letters." + "\n \n" + cipher + "\n");

			/*Get value of shift variable from user*/
			System.out.println("Enter a negative or positive integer value to shift the message by: \n");
			int shift = input.nextInt();

			/*Varibles for while loop*/
			char decrypt;
			int len = cipher.length();
			int count = 0;

			/*Formatting*/
			System.out.println("\n");

			/*In the while loop, the decrypt variable is assigned the value of each character in the cipher
			string variable, shifted by the value entered by the user.  Then all the characters are converted
			to an int type, 26 is added to that value and then a modulus operation with the value of 26 is performed.
			After the modulus operation is completed the values are converted back to char and printed to the screen.
			*/

			while (count != len)
			{
				decrypt = ((char)((int)cipher.charAt(count) + shift));
				decrypt = ((char)((int)decrypt - 'A'));
				decrypt = ((char)((int)decrypt + 26));
				decrypt = ((char)((int)decrypt % 26));
				decrypt = ((char)((int)decrypt + 'A'));
				System.out.print(decrypt);
				count++;
			}
			/*Formatting*/
			System.out.println("\n");
	}
}