/**
* PROGRAM ASSIGNMENT FinalExam				Dog.java
*
* Author:         Lars Cohenour
* Student ID:	  0325825
* Class:          CIT 1613: Java MW 12:30-1:45PM
*
* Class contains data members and methods for dog class.
*/

public class Dog
{


	/**********data members**********/

	private String DogName;

	private int age;

	private double weight;

	/************************************/

	/**
	* Explicit constructor for DogClass, sets values for data members
	*/
	public Dog(String nm, int ag, double wt)
	{
		DogName = nm;
		age = ag;
		weight = wt;
	}

	/**********get methods**********/

	public String getDogName()
	{
		return DogName;
	}

	public int getAge()
	{
		return age;
	}

	public double getWeight()
	{
		return weight;
	}

	/**********set methods**********/

	public void setDogName(String nm)
	{
		DogName = nm;
	}

	public void setAge(int ag)
	{
		if(ag < 0)
		{
			System.out.println();
			System.out.println("The dogs age cannot be negative.");
		}
		else
		{
			age = ag;
		}
	}

	public void setWeight(double wt)
	{
		if(wt <=0)
		{
			System.out.println();
			System.out.println("Weight cannot be zero or negative.");
		}
		else
		{
			weight = wt;
		}
	}

	public void print()
	{
		System.out.println();
		System.out.printf("Dog Name = " + DogName + "\r\n");
		System.out.printf("Dog Age = " + age + "\r\n");
		System.out.printf("Dog Name = %.2f\r\n", weight);
	}


}
