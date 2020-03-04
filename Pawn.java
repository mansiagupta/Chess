import java.util.ArrayList;
import java.util.Scanner;

public class Pawn extends ChessBoard 
{	
	Scanner sc=new Scanner(System.in);
	
	
	static ArrayList<Coordinates> validMoves(Coordinates c)
	{
		ArrayList<Coordinates> list=new ArrayList<Coordinates>();
		int flag;
		if(cb[c.r][c.c].color)
		{
			flag=-1;
			
		}
		else
		{
			flag=1;
		}
		
		if(cb[c.r+flag][c.c]==null)
		{
			list.add(new Coordinates(c.r+flag,c.c));
		}
		if(flag==-1 && c.r==6 && cb[c.r+2*flag][c.c]==null)
		{
			list.add(new Coordinates(c.r+2*flag,c.c));
		}
		if(flag==1 && c.r==1 && cb[c.r+2*flag][c.c]==null)
		{
			list.add(new Coordinates(c.r+2*flag,c.c));
		}
		
		if(c.c>0)
		{
			if(cb[c.r+flag][c.c-1]!=null && cb[c.r+flag][c.c-1].color!=cb[c.r][c.c].color)
				list.add(new Coordinates(c.r+flag,c.c-1));
		}
		
		if(c.c<7)
		{
			if(cb[c.r+flag][c.c+1]!=null && cb[c.r+flag][c.c+1].color!=cb[c.r][c.c].color)
				list.add(new Coordinates(c.r+flag,c.c+1));
		}
		boolean color=cb[c.r][c.c].color;
		Piece tp=cb[c.r][c.c],tpl;
		cb[c.r][c.c]=null;
		Coordinates temp;
		for(int i=0;i<list.size();i++)
		{	temp=list.get(i);
			tpl=cb[temp.r][temp.c];
			cb[temp.r][temp.c]=tp;
			if(color)
			{	if(King.check(wk, true))
				{
					list.remove(i);
					i--;
				}
			}
			else
			{
				if(King.check(bk, false))
				{
					list.remove(i);
					i--;
				}
			}
			cb[temp.r][temp.c]=tpl;
			
		}
		cb[c.r][c.c]=tp;
		return list;
	}
	void promotion(Coordinates c)
	{
		System.out.println("By which you want to promote:-");
		System.out.println("2:Queen");
		System.out.println("3:Bishop");
		System.out.println("4:Knight");
		System.out.println("5:Rook");
		
		int n=sc.nextInt();
		while(n<2 || n>5)
		{
			System.out.println("Please select a valid option:");
			n=sc.nextInt();
		}
		cb[c.r][c.c].p=n;
		
		
	}
	boolean pawn(Coordinates c)
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
		if(c.r==0 || c.r==7)
		{
			promotion(c);
		}
		return !cb[c.r][c.c].color;
		
	}
	

}

