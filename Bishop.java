import java.util.ArrayList;
import java.util.Scanner;

public class Bishop extends ChessBoard 
{
	
	Scanner sc=new Scanner(System.in);
	
	static ArrayList<Coordinates> validMoves(Coordinates xy)
	{	ArrayList<Coordinates> list=new ArrayList<Coordinates>();
		
		//upper left
		int r=xy.r-1;
		int c=xy.c-1;
		while(r>=0 && c>=0)
		{		
			if(cb[r][c]!=null && cb[xy.r][xy.c].color==cb[r][c].color)
			{
				break;
			}
			if(cb[r][c]!=null && cb[xy.r][xy.c].color!=cb[r][c].color)
			{
				list.add(new Coordinates((r--),(c--)));
				break;
			}
			list.add(new Coordinates((r--),(c--)));
		}
		
		//upper right
		r=xy.r-1;
		c=xy.c+1;
		while(r>=0 && c<8)
		{		
			if(cb[r][c]!=null && cb[xy.r][xy.c].color==cb[r][c].color)
			{
				break;
			}
			if(cb[r][c]!=null && cb[xy.r][xy.c].color!=cb[r][c].color)
			{
				list.add(new Coordinates((r--),(c++)));
				break;
			}
			list.add(new Coordinates((r--),(c++)));
		}
		
		//lower left
		r=xy.r+1;
		c=xy.c-1;
		while(r<8 && c>=0)
		{		
			if(cb[r][c]!=null && cb[xy.r][xy.c].color==cb[r][c].color)
			{
				break;
			}
			if(cb[r][c]!=null && cb[xy.r][xy.c].color!=cb[r][c].color)
			{
				list.add(new Coordinates((r++),(c--)));
				break;
			}
			list.add(new Coordinates((r++),(c--)));
		}
		
		//lower right
		r=xy.r+1;
		c=xy.c+1;
		while(r<8 && c<8)
		{		
			if(cb[r][c]!=null && cb[xy.r][xy.c].color==cb[r][c].color)
			{
				break;
			}
			if(cb[r][c]!=null && cb[xy.r][xy.c].color!=cb[r][c].color)
			{
				list.add(new Coordinates((r++),(c++)));
				break;
			}
			list.add(new Coordinates((r++),(c++)));
		}
		boolean color=cb[xy.r][xy.c].color;
		Piece tp=cb[xy.r][xy.c],tpl;
		cb[xy.r][xy.c]=null;
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
		cb[xy.r][xy.c]=tp;
		
		return list;
	}
	
	boolean bishop(Coordinates c)
	{	Coordinates xy;
		ArrayList<Coordinates> list=validMoves(c);
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
