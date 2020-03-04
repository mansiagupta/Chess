import java.util.ArrayList;

public class King extends ChessBoard{
	static boolean check(Coordinates c,boolean color)
	{
		System.out.println(c.r+" "+c.c);
		//for pawn
		//for black
			if(c.c>0 && c.r<6 && cb[c.r+1][c.c-1]!=null && cb[c.r+1][c.c-1].p==0 && color!=cb[c.r+1][c.c-1].color)
				return true;
			if(c.c<7 && c.r<6 && cb[c.r+1][c.c+1]!=null && cb[c.r+1][c.c+1].p==0 && color!=cb[c.r+1][c.c+1].color)
				return true;
		//for white
				if(c.c>0 && c.r>1 && cb[c.r-1][c.c-1]!=null && cb[c.r-1][c.c-1].p==0 && color!=cb[c.r-1][c.c-1].color)
					return true;
				if(c.c<7 && c.r>1 && cb[c.r-1][c.c+1]!=null && cb[c.r-1][c.c+1].p==0 && color!=cb[c.r-1][c.c+1].color)
					return true;
		//System.out.println("Pawn passed");		
		//for knight
		Coordinates xy;
		ArrayList<Coordinates> list=Knight.possible(c);
		for(int i=0;i<list.size();i++)
		{	xy=list.get(i);
			if(cb[xy.r][xy.c]!=null && cb[xy.r][xy.c].p==4 && color!=cb[xy.r][xy.c].color)
			{
				return true;
			}
		}
		//System.out.println("knight passed");
		//for rook type move
			//up
			int row=c.r-1;
			int column=c.c;
			while(row>=0)
			{		
				if(cb[row][column]!=null)
				{
					if( color!=cb[row][column].color && (cb[row][column].p==5 || cb[row][column].p==2))
					{
						return true;
					}
					else
					{
						break;
					}
				}
				row--;
			}
			
			//down
			row=c.r+1;
			column=c.c;
			while(row<8)
			{	
				if(cb[row][column]!=null)
				{
					if(color!=cb[row][column].color && (cb[row][column].p==5 || cb[row][column].p==2))
					{
						return true;
					}
					else
					{
						break;
					}
				}
				row++;
			}
			
			//left
			row=c.r;
			column=c.c-1;
			while(column>=0)
			{		
				if(cb[row][column]!=null)
				{	
					if(color!=cb[row][column].color && (cb[row][column].p==5 || cb[row][column].p==2))
					{
						return true;
					}
					else
					{
						break;
					}
				}
				column--;
			}
			
			//right
			row=c.r;
			column=c.c+1;
			while(column<8)
			{	
				if(cb[row][column]!=null)
				{
					if(color!=cb[row][column].color && (cb[row][column].p==5 || cb[row][column].p==2))
					{
						return true;
					}
					else
					{
						break;
					}
				}
				column++;
			}
			//System.out.println("rook passed");
			//for Bishop type move
				//upper left
				row=c.r-1;
				column=c.c-1;
				while(row>=0 && column>=0)
				{		
					if(cb[row][column]!=null)
					{
						if(color!=cb[row][column].color && (cb[row][column].p==3 || cb[row][column].p==2))
						{
							return true;
						}
						else
						{
							break;
						}
					}
					row--;
					column--;
				}
				
				//upper right
				row=c.r-1;
				column=c.c+1;
				while(row>=0 && column<8)
				{		
					if(cb[row][column]!=null)
					{
						if(color!=cb[row][column].color && (cb[row][column].p==3 || cb[row][column].p==2))
						{
							return true;
						}
						else
						{
							break;
						}
					}
					row--;
					column++;
				}
				
				//down left
				row=c.r+1;
				column=c.c-1;
				while(row<8 && column>=0)
				{		
					if(cb[row][column]!=null)
					{
						if(color!=cb[row][column].color && (cb[row][column].p==3 || cb[row][column].p==2))
						{
							return true;
						}
						else
						{
							break;
						}
					}
					row++;
					column--;
				}
				
				//down right
				row=c.r+1;
				column=c.c+1;
				while(row<8 && column<8)
				{		
					if(cb[row][column]!=null)
					{
						if(color!=cb[row][column].color && (cb[row][column].p==3 || cb[row][column].p==2))
						{
							return true;
						}
						else
						{
							break;
						}
					}
					row++;
					column++;
				}
				//System.out.println("Bishop passed");
		return false;
	}
	ArrayList<Coordinates> validMoves(Coordinates c)
	{	ArrayList<Coordinates> list=new ArrayList<Coordinates>();
		boolean color=cb[c.r][c.c].color;
		Coordinates xy=new Coordinates(0,0);
		cb[c.r][c.c]=null;
		//up
		if(c.r>0)
		{
			if(c.c>0)
			{	
				if(cb[c.r-1][c.c-1]==null || cb[c.r-1][c.c-1].color!=color)
				{
					xy.r=c.r-1;
					xy.c=c.c-1;
					if(!check(xy,color))
					{
						System.out.println(xy.r+" "+xy.c);
						list.add(new Coordinates(xy.r,xy.c));
					}
				}
			}
			if(c.c<7)
			{	
				if(cb[c.r-1][c.c+1]==null || cb[c.r-1][c.c+1].color!=color)
				{
					xy.r=c.r-1;
					xy.c=c.c+1;
					if(!check(xy,color))
					{
						System.out.println(xy.r+" "+xy.c);
						list.add(new Coordinates(xy.r,xy.c));
					}
				}
			}
			xy.r=c.r-1;
			xy.c=c.c;
			if(cb[c.r-1][c.c]==null || cb[c.r-1][c.c].color!=color)
			{
				if(!check(xy,color))
				{
					System.out.println(xy.r+" "+xy.c);
					list.add(new Coordinates(xy.r,xy.c));
				}
			}
		}
		//down
		if(c.r<7)
		{
			if(c.c>0)
			{	
				if(cb[c.r+1][c.c-1]==null || cb[c.r+1][c.c-1].color!=color)
				{
					xy.r=c.r+1;
					xy.c=c.c-1;
					if(!check(xy,color))
					{
						System.out.println(xy.r+" "+xy.c);
						list.add(new Coordinates(xy.r,xy.c));
					}
				}
			}
			if(c.c<7)
			{	
				if(cb[c.r+1][c.c+1]==null || cb[c.r+1][c.c+1].color!=color)
				{
					xy.r=c.r+1;
					xy.c=c.c+1;
					if(!check(xy,color))
					{
						System.out.println(xy.r+" "+xy.c);
						list.add(new Coordinates(xy.r,xy.c));
					}
				}
			}
			xy.r=c.r+1;
			xy.c=c.c;
			if(cb[c.r+1][c.c]==null || cb[c.r+1][c.c].color!=color)
			{
				if(!check(xy,color))
				{
					System.out.println(xy.r+" "+xy.c);
					list.add(new Coordinates(xy.r,xy.c));
				}
			}
		}
		//left
		if(c.c>0)
		{
			if(cb[c.r][c.c-1]==null || cb[c.r][c.c-1].color!=color)
			{
				xy.r=c.r;
				xy.c=c.c-1;
				if(!check(xy,color))
				{
					System.out.println(xy.r+" "+xy.c);
					list.add(new Coordinates(xy.r,xy.c));
				}
			}
		}
		//right
		if(c.c<7)
		{
			if(cb[c.r][c.c+1]==null || cb[c.r][c.c+1].color!=color)
			{
				xy.r=c.r;
				xy.c=c.c+1;
				if(!check(xy,color))
				{
					System.out.println(xy.r+" "+xy.c);
					list.add(new Coordinates(xy.r,xy.c));
				}
			}
		}
		for(int i=0;i<list.size();i++)
		{	xy=list.get(i);
			System.out.println(xy.r+" "+xy.c);
		}
		for(int i=0;i<list.size();i++)
		{	xy=list.get(i);
			if(cb[xy.r][xy.c]!=null &&  color==cb[xy.r][xy.c].color)
			{
				System.out.println("removed");
				list.remove(i);
				i--;
			}
		}
		cb[c.r][c.c]=new Piece(1, color);
		return list;
	}
}
