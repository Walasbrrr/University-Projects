import java.util.Scanner;

public class MenuDemo1
{
	public static void main(String[] args)
	{
		int option;
		Scanner wc = new Scanner(System.in);
		System.out.println("1. CM to IN \n2.IN to CM\n3.Exit\nEnter option: ");
		option = wc.nextInt();

		while (option != 3)
		{
			if(option == 1)
			{
				System.out.println("you choose option 1");

			}//end of if
			else

			{
				if (option == 2)
				{
					System.out.println("you choose option 2");

				}//end of if
				else
				{
					System.out.println("invalid option. please retry.");

				}//end of else

			}//end of else

		}//end of the while



	}//end of main


}//end of the class