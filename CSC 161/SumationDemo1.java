import java.util.Scanner;

public class SumationDemo1
{
	public static void main(String[] args)
	{
		//Method into RAM
		Scanner wc = new Scanner(System.in);

		//Variables
		int sum = 0, entry, numEvens = 0;

		System.out.print("enter first number: ");
		entry = wc.nextInt();

		while(entry != 0 )
		{
			if(isEven( entry ) == true)
				numEvens ++;

			sum += entry;//this is a very important line
			System.out.print("enter next number: ");
			entry = wc.nextInt();
		}
		System.out.println("The sum of your numbers is: " + sum + "and the numberst that are even are: "+ numEvens);
		}//end of main





	public static boolean isEven(int bob)
	{
		if (bob %2 == 0)
			return true;
		else
			return false;
	}//end of isEven

	public static double compound (double base ,double percent ,int time)
	{
		int k = 0;
		while(k < time)
		{
			base += base * percent;

			k++;
		}//end of compound


	}



}// end of the class