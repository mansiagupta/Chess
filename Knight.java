import java.util.ArrayList;
import java.util.Scanner;

public class Knight extends ChessBoard 
{
	
	Scanner sc=new Scanner(System.in);
	
	static ArrayList<Coordinates> possible(Coordinates xy)
	{	ArrayList<Coordinates> list=new ArrayList<Coordinates>();
		int r=xy.r;
		int c=xy.c;
		//upper two
		if(r>1)
		{
			if(c>0)
			{
				list.add(new Coordinates((r-2),(c-1)));
				
			}
			if(c<7)
			{
				list.add(new Coordinates((r-2),(c+1)));
			}	
		}
		//lower two
		if(r<6)
		{
			if(c>0)
			{
				list.add(new Coordinates((r+2),(c-1)));
			}
			if(c<7 )
			{
				list.add(new Coordinates((r+2),(c+1)));
			}	
		}
		//left two
		if(c>1)
		{
			if(r>0)
			{
				list.add(new Coordinates((r-1),(c-2)));
			}
			if(r<7 )
			{
				list.add(new Coordinates((r+1),(c-2)));
			}	
		}
		//right two
		if(c<6)
		{
			if(r>0)
			{
				list.add(new Coordinates((r-1),(c+2)));
			}
			if(r<7 )
			{
				list.add(new Coordinates((r+1),(c+2)));
			}	
		 }
				return list;
	}
	static ArrayList<Coordinates> validMove(Coordinates c)
	{
		Coordinates xy;
		ArrayList<Coordinates> list=possible(c);
		for(int i=0;i<list.size();i++)
		{	xy=list.get(i);
			if(cb[xy.r][xy.c]!=null && cb[c.r][c.c].color==cb[xy.r][xy.c].color)
			{
				list.remove(i);
				i--;
			}
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
	boolean knight(Coordinates c)
	{	Coordinates xy;
		ArrayList<Coordinates> list=validMove(c);
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
