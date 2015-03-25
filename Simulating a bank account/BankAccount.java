/**
* PROGRAM ASSIGNMENT 9				BankAccount.java
*
* Author:         Lars Cohenour
* Student ID:	  0325825
* Class:          CIT 1613: Java MW 12:30-1:45PM
*
* Class contains data members and methods for simulating part of a bank account.
*/


public class BankAccount
{
	/**********data members**********/
	private int actNum;
	private String firstName;
	private String lastName;
	private double balance, money;

	//default constructor
	public BankAccount()
	{
	}

	//four argument constructor
	public BankAccount(int act, String first, String last, double bal)
	{
		actNum = act;
		firstName = first;
		lastName = last;
		balance = bal;
	}


	/*************get methods***********/


	public int getAct()
	{
		return actNum;
	}

	public String getFirst()
	{
		return firstName;
	}

	public String getLast()
	{
		return lastName;
	}

	public double getBal()
	{
		return balance;
	}
	/***********************************/

	/*************set methods***********/
	public void setAct(int act)
	{
		if(act <=0)
		{
			System.out.println();
			System.out.println("Account number cannot be zero or negative.");
		}
		else
		{
			actNum = act;
		}
	}

	public void setFirst(String first)
	{
		firstName = first;
	}

	public void getLast(String last)
	{
		lastName = last;
	}

	public void setBal(double bal)
	{
		if(bal < 0.0)
		{
			System.out.println();
			System.out.printf("Accounts cannot be negative at this bank.\r\n"
			+ "The previous balance has not been changed.\r\n");
		}
		else
		{
			balance = bal;
		}

	}
	/***********************************/

	/**********effectors****************/
	//both function similar to mutators

	public void deposit(double money)
	{
		if(money == 0.00)
		{
			System.out.println();
			System.out.printf("Deposit amount cannot be zero.\r\n");
		}
		else if(money < 0.00)
		{
			System.out.println();
			System.out.printf("Deposit amount cannot be a negative value.\r\n");
		}
		else
		{
			balance = balance + money;
		}
	}

	public void withdraw(double money)
	{
		if(money == 0.00)
		{
			System.out.println();
			System.out.printf("Withdrawal amount cannot be zero.\r\n");

		}
		else if(money < 0.00)
		{
			money = Math.abs(money);
		}


		if(money > balance)
		{
			System.out.println();
			System.out.printf("Insufficient Funds.\r\n");
		}
		else
		{
			balance = balance - money;
		}
	}

	/********print methods**************/

	public void print()
	{
		System.out.printf("Account Number: " + actNum +"\r\n");
		System.out.printf("First Name: " + firstName + "\r\n");
		System.out.printf("Last Name: " + lastName + "\r\n");
		System.out.printf("Balance: $%.2f.\r\n", balance);
	}

	@Override
	public String toString()
	{
		System.out.println();
		String output = "Account Number: " + actNum + "\r\n";
		output += "First Name: " + firstName + "\r\n";
		output += "Last Name: " + lastName + "\r\n";
		String temp = String.format("Balance: $%.2f\r\n", balance);
		output += temp;
		return output;
	}
}