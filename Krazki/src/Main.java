import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList <Integer> Pipe = new ArrayList();
		
		int Height;
		int PuckNum;
		int r;
		int k;
		int depth;
		
		Height = scanner.nextInt();
		PuckNum = scanner.nextInt();
		
		if(Height < 1 || PuckNum > 300000 || PuckNum < 0)
		{
			System.out.println("Pipe's Height must be >= 1 or Number of Pucks must be >= 0 and <= 300 000");
		}
		else
		{
			for(int i = 0; i < Height; i++)
			{
				r = scanner.nextInt();
				if(r < 1 || r > 1000000000)
				{
					System.out.println("Diameter of Pipe must be >= 1 and <= 1 000 000 000");
				}
				else
				{
					Pipe.add(r);
				}
			}
			depth = Height;
			for(int i = 0; i < PuckNum; i++)
			{
				k = scanner.nextInt();
				if(k < 1 || k > 1000000000)
				{
					System.out.println("Diameter of Puck must be >= 1 and <= 1 000 000 000");
				}
				else if(scanner.hasNextInt() == false)
				{
					depth = 0;
				}
				else
				{
					for(int j = 0; j < Height; j++)
					{
						if(j+1 < Height && k > Pipe.get(j+1))
						{
							depth = j--;
							Height--;
						}
						else if(j+1 == Height)
						{
							depth = j+1;
							Height--;
						}
					}
					if(i == PuckNum-1 && k > Pipe.get(0))
					{
						depth = 0;
					}
				}
			}
			System.out.println(depth);
		}

	}

}
