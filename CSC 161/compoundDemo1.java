import java.text.DecimalFormat;


public class compoundDemo1
{
	public static void main(String[] args)
	{
		DecimalFormat D = new DecimalFormat("#00");

		double result;
		result = compounding(100, 0.04, 3); // the method call
		System.out.println("if 100 is compounded at 4% over 3 years, I wll get: " + result);

	System.out.println("In 3 years, the population will be " + compounding(7e9, 0.02, 3));

	System.out.println("\n\n\n");

	int counter;
	System.out.println("at 3% over 7 years: ");
	for( counter = 100; counter <= 1000;counter +=100 )
	{
		double earnings;
		earnings = compounding (counter ,0.03 ,7);
		System.out.println(counter + "\t" + D.format(earnings));
	}

	}//end of main




	//the method definition:
	public static double compounding (double base ,double percent ,int time)
	{
		int k = 0;
		while(k < time)
		{
			base += base * percent;

			k++;
		}
		return base;
		}//end of compound

}//end of the class