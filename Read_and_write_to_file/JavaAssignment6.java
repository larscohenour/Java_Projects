/**
* PROGRAM ASSIGNMENT 6				JavaAssignment6.java
*
* Author:         Lars Cohenour
* Student ID:	  0325825
* Class:          CIT 1613: Java MW 12:30-1:45PM
*
* Program Description:
* Program acquires an values from a file provided by the user, that represent the size
* of the carbon foot print for a city.  The program calculates and displays and writes to a file the sum, average, and the average rounded down
* and determines the amount of the fine for based on that amount.
*/

import java.math.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class JavaAssignment6
{
	/**
	* @param args
	* *throws FileNotFoundException
	*/

	public static void main(String[] args) throws FileNotFoundException
	{

		//create scanner object
		Scanner keyboard = new Scanner(System.in);

		//declare and initialize string variables
		String inputFileName = " ";  String outputFileName = " "; String cityName = " ";

		//Display welcome message and program info to user
		System.out.println("Welcome to the Rose State Software Engineering Lab.");

		System.out.println("Please be ready to provide the data file name for Carbon FP for US cities.\n");

		System.out.println("Program will crash if wrong filename is given.\n" +
		"In that case please run program again ascertaining correct file name.");

		//get input file name from user
		System.out.println("Please enter the full path of input data file name. [Relative path needed on UNIX]: " );
		inputFileName = keyboard.nextLine();

		System.out.println();

		//create an object for input file name
		File Fin = new File(inputFileName);
		//create scanner for input file object (Fin)
		Scanner Fread = new Scanner(Fin);

		//get output file name from user
		System.out.println("Please provide full path to output file. [Relative path needed on UNIX]\n" +
		"CAUTION: IF OUTPUT FILE EXISTS ALL DATA IN IT WILL BE DELETED!\n" +
		"In that case please run program again ascertaining correct file name.");
		outputFileName = keyboard.nextLine();

		System.out.println();

		/********begin advanced option code***************/

		//display message to user about validating file
		System.out.println("Validating file names.\n");

		//if the values for the input and output file names, program teminates
		if(inputFileName.equals(outputFileName))
		{
			//give user message about the input error and tell them that the program is closing
			System.out.println("You have specified a name for an output file that is actually input file.\n" +
			"Dangerous operation.  Exiting the program to avoud data loss.  Run program\n" +
			"again and specify different names for input and output files.");

			//close program
			System.exit(0);
		}
		else
		{
			//inform user that file names are valid
			System.out.println("File names are valid.\n");
		}
		/********end advanced option code*****************/

		System.out.println();

		// create an object for output file name
		File Fout = new File(outputFileName);

		//create print stream for output file object
		PrintStream PS = new PrintStream(Fout);

		System.out.println("***********************************************");
		PS.println("***********************************************");

		while(Fread.hasNext())
		{
			//variable declared and initialized inside loop so values will be set back to zero after each interation
			int roundAvg = 0; int value = 0; int sum = 0; int count = 0; double avg;

			//read city name
			cityName = Fread.next();

			//read first FP value
			value = Fread.nextInt();

			System.out.println("***********************************************");
			PS.println("***********************************************");

			System.out.println("Data for the city of " + cityName);
			PS.println("Data for the city of " + cityName);

			if(value >= 0)
			{
				System.out.print("Carbon footprint values are: ");
				PS.print("Carbon footprint values are: ");

				while(value >= 0)
				{
					System.out.print(" " + value);
					PS.print(" " + value);
					//add initial and each subsequent value to sum
					sum += value;
					count ++;
					//read next value
					value = Fread.nextInt();

				}

				System.out.println();
				PS.println();

				avg = (double)sum / count;

				roundAvg = (int)Math.round(avg);

				System.out.printf("Sum of all Carbon foot print values is " + sum + "\r\n");
				System.out.printf("The total number of readings is " + count + "\r\n");
				System.out.printf("The real average carbon footprint is %.2f\r\n", avg);
				System.out.printf("Possibly to benefit you, the rounded down averaged value of carbon footprint is " + roundAvg + "\r\n");

				PS.printf("Sum of all Carbon foot print values is " + sum + "\r\n");
				PS.printf("The total number of readings is " + count);
				PS.printf("The real average carbon footprint is %.2f\n", avg);
				PS.println("\n");
				PS.printf("Possibly to benefit you, the rounded down averaged value of carbon footprint is " + roundAvg);
				PS.println("\n");

				//determine the amount of the fine based on roundAvg
				if(roundAvg <= 1)
				{
					System.out.println("There is no fine.");
					PS.println("There is no fine.");
				}
				else if(roundAvg <= 3)
				{
					System.out.println("Your fine is $1,000,000.00");
					PS.println("Your fine is $1,000,000.00");
				}
				else if(roundAvg <= 5)
				{
					System.out.println("Your fine is $2,000,000.00");
					PS.println("Your fine is $2,000,000.00");
				}
				else if(roundAvg <= 7)
				{
					System.out.println("Your fine is $3,000,000.00");
					PS.println("Your fine is $3,000,000.00");
				}
				else if(roundAvg > 7)
				{
					System.out.println("Your fine is $4,500,000.00");
					PS.println("Your fine is $4,500,000.00");
				}

			}
			else
			{
				System.out.println("No carbon foot print values were entered, for this city");
				PS.println("No carbon foot print values were entered for this city.");

				System.out.println("***********************************************");
				PS.println("***********************************************");
			}

		}

		Fread.close();
		PS.close();
	}
}

