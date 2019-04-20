import java.util.*;
import java.lang.*;


class Operations {
	
	//Addition function gives sum of two numbers
	public double Add(double a, double b)
	{
	  return a+b;
	}
	
	//Multiplication function gives product of two numbers
	public double Multiply(double number1,double number2)
	{
	return number1*number2;
	}

	//Division function gives quotient of two numbers
	public double Divide(double number1,double number2)
	{
		try
		{
			return (number1/number2);
		}
		
		catch(Exception ex)
		{
			return Integer.parseInt(ex.getMessage());
		}
	}
}

public class Calculator
	{
		public static void main(String args[])
	    {
		
			double a,b;
			Operations o = new Operations();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the two numbers : ");
			a=sc.nextDouble();
			b=sc.nextDouble();
			System.out.println("Addition : "+o.Add(a,b));
			System.out.println("Multiply : "+o.Multiply(a,b));
			System.out.println("Division : "+o.Divide(a,b));
		}
		
				
	}
	
	
