/**
* PROGRAM ASSIGNMENT 9				ClientMain.java
*
* Author:         Lars Cohenour
* Student ID:	  0325825
* Class:          CIT 1613: Java MW 12:30-1:45PM
*
* Program Description:  Menu driven program to simulate part of a bank account by accessing
* the BankAccount class.
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ClientMain
{


	public static void main(String[] args) throws FileNotFoundException
	{

		Scanner keyboard = new Scanner(System.in);

		/**********data members ****************/

		int actNum;

		String firstName, lastName, fullName;

		double balance, money;

		//BankAccont object
		BankAccount BA = null;

		//loop control
		boolean done = false;

		/*************************************/

		do
		{
			System.out.println();
			System.out.println("**********Main Menu***********");
			System.out.println("1.  Create an instance of Bank Account from keyboard data entry.");
			System.out.println("2.  Print the details of Bank Account instance to console.");
			System.out.println("3.  Print details of Bank Account instance to an ouput file.");
			System.out.println("4.  Make a deposit.");
			System.out.println("5.  Make a withdrawal.");
			System.out.println("6.  Print current balance.");
			System.out.println("7.  Print account holder's full name.");
			System.out.println("8.  Exit.");
			System.out.println();
			int response = keyboard.nextInt();
			System.out.println();

			switch(response)
			{
				case 1:
				{
					if(BA == null)
					{
						BA = getBankAccount(keyboard);
					}
					else
					{
						System.out.println();
						System.out.println("An employee object is already built");
						System.out.println("Enter 1 to delete it and build a new one or zero to make no changes.");
						int ans = keyboard.nextInt();

						if(ans == 1)
						{
							BA = getBankAccount(keyboard);
						}
						else
						{
							System.out.println();
							System.out.println("No changes have been made.");
						}
					}
				} break;

				case 2:
				{
					if(BA != null)
					{
						//printed to console using print method; toString used to print to file
						BA.print();
					}
					else
					{
						System.out.println();
						System.out.println("Please create a bank account (option 1) before using this option");
					}
				} break;

				case 3:
				{

					if(BA != null)
					{
						Scanner keyboard2 = new Scanner(System.in);

						System.out.println("Enter full path to output file.");

						String fname = keyboard2.nextLine();

						File F = new File(fname);

						PrintStream PS = new PrintStream(F);

						//print to file using toString() method
						PS.println(BA.toString());
						PS.close();
					}
					else
					{
						System.out.println();
						System.out.println("Please create a bank account (option 1) before using this option");
					}
				} break;

				case 4:
				{
					if(BA!=null)
					{
						System.out.println("Enter the amount of the deposit.");
						money = keyboard.nextDouble();

						BA.deposit(money);
					}
					else
					{
						System.out.println("Please create a bank account (option 1) before using this option");
					}

				}  break;

				case 5:
				{
					if(BA!=null)
					{
						System.out.println("Enter the amount of the withdrawal.");
						money = keyboard.nextDouble();

						BA.withdraw(money);
					}
					else
					{
						System.out.println("Please create a bank account (option 1) before using this option");
					}
				}  break;

				case 6:
				{
					if(BA!=null)
					{
						System.out.println("Balance: " + BA.getBal());
					}
					else
					{
						System.out.println("Please create a bank account (option 1) before using this option");
					}
				}  break;

				case 7:
				{
					if(BA!=null)
					{
						System.out.println("Full name: " + BA.getFirst() + " " + BA.getLast());
					}
					else
					{
						System.out.println("Please create a bank account (option 1) before using this option");
					}
				}  break;

				case 8:
				{
					done = true;
				} break;

				default:

					System.out.println("This option not implemented.");
				}//switch

		} while(!done);
	}

	//used to create new bank account
	public static BankAccount getBankAccount(Scanner keyboard)
	{
		BankAccount BA;

		System.out.println("Enter the bank account number.");
		int act = keyboard.nextInt();

		System.out.println("Enter the first name on the account. ");
		String first = keyboard.next();

		System.out.println("Enter the last name on the account. ");
		String last = keyboard.next();

		System.out.println("Enter the balance of the account. ");
		double bal = keyboard.nextDouble();

		BA = new BankAccount(act, first, last, bal);

		System.out.println();
		BA.print();

		return BA;
	}
}