import java.util.ArrayList;
import java.util.Scanner;

public class Queen extends ChessBoard
{
	
	Scanner sc=new Scanner(System.in);
	static ArrayList<Coordinates> validMoves(Coordinates c)
	{	ArrayList<Coordinates> list=Rook.validMoves(c);
		list.addAll(Bishop.validMoves(c));
		return list;
	}
	boolean queen(Coordinates c)
	{	
		ArrayList<Coordinates> list=validMoves(c);
		Coordinates xy;
		if(list.size()==0)
		{
			System.out.println("Illegal Move");
			return cb[c.r][c.c].color;
			
		}
		System.out.println("Enter your choice :-");
		for(int i=0;i<list.size();i++)
		{	xy=list.get(i);
			System.out.println((i+1)+". "+xy.r+","+xy.c);
		}
		int n=sc.nextInt();
		while(n<1 || n>list.size())
		{
			System.out.println("Please select a valid option:");
			n=sc.nextInt();
		}
		xy=list.get(n-1);
		cb[xy.r][xy.c]=cb[c.r][c.c];
		cb[c.r][c.c]=null;
		c=xy;
		return !cb[c.r][c.c].color;
		
	}

}
