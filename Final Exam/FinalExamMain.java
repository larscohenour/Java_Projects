/**
* PROGRAM ASSIGNMENT: FinalExamMain				FinalExamMain.java
*
* Author:         Lars Cohenour
* Student ID:	  0325825
* Class:          CIT 1613: Java MW 12:30-1:45PM
*
* Program Description: Contains main method that provides a menu driven interface
* to implement Dog.java
* .
*/


import java.util.Scanner;

public class FinalExamMain
{
	public static void main(String[] args)
	{
		//scanner object
		Scanner keyboard = new Scanner(System.in);

		/**********data members**********/

		String DogName;

		int age;

		double weight;

		//Dog object
		Dog D = null;

		//loop control
		boolean done = false;

		/************************************/

		do
		{
			System.out.println();
			System.out.println("**********Main Menu***********");
			System.out.println("1.  Create an instance of Dog in the kennel from keyboard data entry.");
			System.out.println("2.  Print all the details of dog to console.");
			System.out.println("3.  Change Dog's age.");
			System.out.println("4.  Change Dog's weight.");
			System.out.println("5.  Print Dog's name only to console.");
			System.out.println("6.  Print Dog's weight only to console formatted to two decimal places.");
			System.out.println("7.  Print Dog's age only to console.");
			System.out.println("8.  Exit.");
			System.out.println();
			int response = keyboard.nextInt();
			System.out.println();

				switch(response)
				{
					case 1:
					{
						if(D == null)
						{
							D = getDog(keyboard);
						}
						else
						{
							System.out.println();
							System.out.println("A dog instance is already built");
							System.out.println("Enter 1 to delete it and build a new one or zero to make no changes.");
							int ans = keyboard.nextInt();

							if(ans == 1)
							{
								D = getDog(keyboard);
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
						if(D != null)
						{
							D.print();
						}
						else
						{
							System.out.println();
							System.out.println("Please create an instance of dog (option 1) before using this option");
						}
					} break;

					case 3:
					{
						if(D!=null)
						{
							System.out.println("Enter dog's new age:");
							age = keyboard.nextInt();

							if(age < 0)
							{
								System.out.println();
								System.out.println("The dogs age cannot be negative.");
							}
							else
							{
								D.setAge(age);
								System.out.println("Age changed successfully.");
							}

						}
						else
						{
							System.out.println("Please create an instance (option 1) before using this option");
						}

					}  break;

					case 4:
					{
						if(D!=null)
						{
							System.out.println("Enter dog's new weight:");
							weight = keyboard.nextDouble();

							if(weight <= 0)
							{
								System.out.println();
								System.out.println("The dogs weight cannot be zero or negative.");
							}
							else
							{
								D.setWeight(weight);
							}
						}
						else
						{
							System.out.println("Please create an instance (option 1) before using this option");
						}

					}  break;

					case 5:
					{
						if(D!=null)
						{
							System.out.println(D.getDogName());
						}
						else
						{
							System.out.println("Please create an instance (option 1) before using this option");
							System.out.println();
						}

					}  break;

					case 6:
					{
						if(D!=null)
						{
							System.out.printf("Dog's weight = %.2f", D.getWeight());
							System.out.println();

						}
						else
						{
							System.out.println("Please create an instance (option 1) before using this option");
						}

					}  break;

					case 7:
					{
						if(D!=null)
						{
							System.out.println("Dog's Age = " + D.getAge());
							System.out.println();
						}
						else
						{
							System.out.println("Please create an instance (option 1) before using this option");
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

			System.out.println("End of program");
		}

	//used to create new bank account
	public static Dog getDog(Scanner keyboard)
	{
		Dog D;

		keyboard.nextLine();//used to clear buffer instead of having second scanner object
		System.out.println("Enter dog's name: ");
		String nm = keyboard.nextLine();

		System.out.println();
		System.out.println("Enter the dog's age: [whole number only]");
		int ag = keyboard.nextInt();

		System.out.println("Enter the dog's weight in pounds [xx.yy]");
		double wt = keyboard.nextDouble();

		D = new Dog(nm, ag, wt);

		System.out.println();
		D.print();

		return D;
	}
}
