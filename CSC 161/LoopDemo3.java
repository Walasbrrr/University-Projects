import java.util.Scanner;

public class LoopDemo3
{
	public static void main(String[] args)
	{
		Scanner wc = new Scanner(System.in);

		int sum = 0;
		int entry;

		System.out.print("print enter number");
		entry = wc.nextInt();

		while(entry != 0 )
		{
			System.out.print("enter number");
			entry = wc.nextInt();
			sum += entry;//this is a very important line

		}



	}
}