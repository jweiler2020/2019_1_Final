import java.util.Scanner;

public class PerfectSquare
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = kb.nextInt();
		int closeSquare = findCloseSquare(num);
		System.out.println(String.format("The closest square to that number is %d", closeSquare));
	}
	
	private static int findCloseSquare(int n)
	{
		int root = (int)Math.round(Math.sqrt(n));
		return root*root;
	}
}
