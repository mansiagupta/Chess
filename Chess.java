import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**This class will handle the game.
 * 
 * @author Mansi Gupta
 * @author Naveen Gaur
 *
 */
public class Chess extends ChessBoard implements MouseListener
{
	
	boolean tf=true;
	ArrayList<Coordinates> list;
	King k;
	boolean player=true; 
	Coordinates c;
	JFrame f;

	JButton button[][];
	Chess()
	{
		
		k=new King();
		c=new Coordinates(0,0);
	}
		
		
	void start()
	{
		newGame();
		f=new JFrame("Chess");
		
		button=new JButton[8][8];
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				button[i][j]=new JButton();
				button[i][j].setBounds(j*90,i*90,90,90);
				button[i][j].setRolloverEnabled(false);
				
				
				
				f.add(button[i][j]);
				button[i][j].addMouseListener(this);
				
			}
			
		}
		setCBColor();
		f.setSize(734,757);
		f.setLayout(null);
		f.setVisible(true);
		
	}

	void possible(Coordinates c)
	{
		int i=c.r;
		int j=c.c;
		if(cb[i][j]!=null)
		{	
			//color of piece
			if(cb[i][j].color)
			{
				if(cb[i][j].p==5)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\WhiteRookAttack.jpg"));
				}
				else if(cb[i][j].p==4)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\WhiteKnightAttack.png"));
				}
				
				else if(cb[i][j].p==3)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\WhiteBishopAttack.png"));
				}
				else if(cb[i][j].p==2)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\WhiteQueenAttack.png"));
				}
				else if(cb[i][j].p==1)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\WhiteKingAttack.png"));
				}
				else
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\WhitePawnAttack.png"));
				}
			}
			else
			{
				if(cb[i][j].p==5)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\BlackRookAttack.png"));
				}
				else if(cb[i][j].p==4)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\BlackKnightAttack.png"));
				}
				
				else if(cb[i][j].p==3)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\BlackBishopAttack.png"));
				}
				else if(cb[i][j].p==2)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\BlackQueenAttack.png"));
				}
				else if(cb[i][j].p==1)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\BlackKingAttack.jpg"));
				}
				else
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\BlackPawnAttack.jpg"));
				}
			}
		}
		else
			button[i][j].setIcon(new ImageIcon("src\\Image\\Move.png"));
		
		
	}
	void select(Coordinates c)
	{
		int i=c.r;
		int j=c.c;
		if(cb[i][j]!=null)
		{	
			//color of piece
			if(cb[i][j].color)
			{
				if(cb[i][j].p==5)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\WhiteRookSelect.jpg"));
				}
				else if(cb[i][j].p==4)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\WhiteKnightSelect.png"));
				}
				
				else if(cb[i][j].p==3)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\WhiteBishopSelect.png"));
				}
				else if(cb[i][j].p==2)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\WhiteQueenSelect.png"));
				}
				else if(cb[i][j].p==1)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\WhiteKingSelect.png"));
				}
				else
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\WhitePawnSelect.png"));
				}
			}
			else
			{
				if(cb[i][j].p==5)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\BlackRookSelect.png"));
				}
				else if(cb[i][j].p==4)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\BlackKnightSelect.png"));
				}
				
				else if(cb[i][j].p==3)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\BlackBishopSelect.png"));
				}
				else if(cb[i][j].p==2)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\BlackQueenSelect.png"));
				}
				else if(cb[i][j].p==1)
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\BlackKingSelect.jpg"));
				}
				else
				{
					button[i][j].setIcon(new ImageIcon("src\\Image\\BlackPawnSelect.jpg"));
				}
			}
		}
		
	}
	void kingCheck(Coordinates c)
	{
		if(cb[c.r][c.c].color)
		{
			if(King.check(c,cb[c.r][c.c].color))
			{
			
				button[c.r][c.c].setIcon(new ImageIcon("src\\Image\\WhiteKingAttack.png"));
				if(k.validMoves(c).size()==0)
				{
					Coordinates xy=new Coordinates(0,0);
					for(int i=0;i<8;i++)
					{
						for(int j=0;j<8;j++)
						{
							display();
							xy.r=i;
							xy.c=j;
							if(cb[i][j]!=null && cb[i][j].color)
							{
								switch(cb[i][j].p)
								{
									case 0 :
										list=Pawn.validMoves(xy);
										break;
									case 1 :
										break;
									case 2 :
										list=Queen.validMoves(xy);
										break;
									case 3 :
										list=Bishop.validMoves(xy);
										break;
									case 4 :
										list=Knight.validMove(xy);
										break;
									case 5 :
										list=Rook.validMoves(xy);
										break;
								}
								if(list.size()!=0)
								{
									return;
								}
							}
						}
					}
					for(int i=0;i<8;i++)
					{
						for(int j=0;j<8;j++)
						{	
							
							if((i+j)%2==0)
								button[i][j].setIcon(new ImageIcon("src\\Image\\White.png"));
							else
								button[i][j].setIcon(new ImageIcon("src\\Image\\Black.png"));
						}
					}
					for(int i=0;i<8;i++)
					{
						f.remove(button[3][i]);
						f.remove(button[4][i]);
					}
					button[3][0].setBounds(0, 270, 180, 180);
					f.add(button[3][0]);
					button[3][0].setIcon(new ImageIcon("src\\Image\\Black.jpg"));
					button[3][2].setBounds(180, 270, 360, 180);
					f.add(button[3][2]);
					button[3][2].setIcon(new ImageIcon("src\\Image\\Win.jpg"));
					button[3][6].setBounds(540, 270, 180, 180);
					f.add(button[3][6]);
					button[3][6].setIcon(new ImageIcon("src\\Image\\Black.jpg"));
					
					
				}
			}
		}
		else 
		{	
			if(King.check(c,cb[c.r][c.c].color))
			{
				button[c.r][c.c].setIcon(new ImageIcon("src\\Image\\BlackKingAttack.jpg"));
				if(k.validMoves(c).size()==0)
				{
					Coordinates xy=new Coordinates(0,0);
					for(int i=0;i<8;i++)
					{
						for(int j=0;j<8;j++)
						{
							display();
							xy.r=i;
							xy.c=j;
							if(cb[i][j]!=null && !cb[i][j].color)
							{
								switch(cb[i][j].p)
								{
									case 0 :
										list=Pawn.validMoves(xy);
										break;
									case 1 :
										break;
									case 2 :
										list=Queen.validMoves(xy);
										break;
									case 3 :
										list=Bishop.validMoves(xy);
										break;
									case 4 :
										list=Knight.validMove(xy);
										break;
									case 5 :
										list=Rook.validMoves(xy);
										break;
								}
								if(list.size()!=0)
								{
									return;
								}
							}
						}
					}
					for(int i=0;i<8;i++)
					{
						f.remove(button[3][i]);
						f.remove(button[4][i]);
					}
					for(int i=0;i<8;i++)
					{
						for(int j=0;j<8;j++)
						{	
							
							if((i+j)%2==0)
								button[i][j].setIcon(new ImageIcon("src\\Image\\White.png"));
							else
								button[i][j].setIcon(new ImageIcon("src\\Image\\Black.png"));
						}
					}
					button[3][0].setBounds(0, 270, 180, 180);
					f.add(button[3][0]);
					button[3][0].setIcon(new ImageIcon("src\\Image\\White.jpg"));
					button[3][2].setBounds(180, 270, 360, 180);
					f.add(button[3][2]);
					button[3][2].setIcon(new ImageIcon("src\\Image\\Win.jpg"));
					button[3][6].setBounds(540, 270, 180, 180);
					f.add(button[3][6]);
					button[3][6].setIcon(new ImageIcon("src\\Image\\White.jpg"));
					
				}
			}
		}
		
				
	}
	
	void setCBColor()
	{
		String s;
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{	
				
				if(cb[i][j]!=null)
				{
					if((i+j)%2==0)
						s="AtWhite";
					else
						s="AtBlack";
					
					//color of piece
					if(cb[i][j].color)
					{
						if(cb[i][j].p==5)
						{
							button[i][j].setIcon(new ImageIcon("src\\Image\\WhiteRook"+s+".jpg"));
						}
						else if(cb[i][j].p==4)
						{
							button[i][j].setIcon(new ImageIcon("src\\Image\\WhiteKnight"+s+".png"));
						}
						
						else if(cb[i][j].p==3)
						{
							button[i][j].setIcon(new ImageIcon("src\\Image\\WhiteBishop"+s+".png"));
						}
						else if(cb[i][j].p==2)
						{
							button[i][j].setIcon(new ImageIcon("src\\Image\\WhiteQueen"+s+".png"));
						}
						else if(cb[i][j].p==1)
						{
							button[i][j].setIcon(new ImageIcon("src\\Image\\WhiteKing"+s+".png"));
						}
						else
						{
							button[i][j].setIcon(new ImageIcon("src\\Image\\WhitePawn"+s+".png"));
						}
					}
					else
					{
						if(cb[i][j].p==5)
						{
							button[i][j].setIcon(new ImageIcon("src\\Image\\BlackRook"+s+".png"));
						}
						else if(cb[i][j].p==4)
						{
							button[i][j].setIcon(new ImageIcon("src\\Image\\BlackKnight"+s+".png"));
						}
						
						else if(cb[i][j].p==3)
						{
							button[i][j].setIcon(new ImageIcon("src\\Image\\BlackBishop"+s+".png"));
						}
						else if(cb[i][j].p==2)
						{
							button[i][j].setIcon(new ImageIcon("src\\Image\\BlackQueen"+s+".png"));
						}
						else if(cb[i][j].p==1)
						{
							button[i][j].setIcon(new ImageIcon("src\\Image\\BlackKing"+s+".jpg"));
						}
						else
						{
							button[i][j].setIcon(new ImageIcon("src\\Image\\BlackPawn"+s+".jpg"));
						}
					}
				}
				else
				{
					if((i+j)%2==0)
						button[i][j].setIcon(new ImageIcon("src\\Image\\White.png"));
					else
						button[i][j].setIcon(new ImageIcon("src\\Image\\Black.png"));
				}
				
			}
			
		}
		
	}

	public void mouseClicked(MouseEvent e)
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(tf)
				{	if(e.getSource()==button[i][j])
					{
						setCBColor();
						c.r=i;
						c.c=j; 
						if(player && cb[c.r][c.c]!=null && cb[c.r][c.c].color)
						{
							display();
							select(c);
							player=move(c);
	
						}
						else
						{
							if(!player && cb[c.r][c.c]!=null && (!cb[c.r][c.c].color))
							{
								display();
								select(c);
								player=move(c);
							}
						}
					}
				}
				else if(e.getSource()==button[i][j])
				{
					if(i==c.r && j==c.c)
					{
						tf=true;
						player=cb[c.r][c.c].color;
						setCBColor();
					}
					for(int k=0;k<list.size();k++)
					{
						if(list.get(k).r==i && list.get(k).c==j)
						{	cb[i][j]=cb[c.r][c.c];
							tf=true;
							if(cb[i][j].p==1)
							{
								if(cb[i][j].color)
								{
									wk=new Coordinates(i,j);
								}
								else
								{
									bk=new Coordinates(i,j);
								}
									
							}
							cb[c.r][c.c]=null;
							setCBColor();
							if(!player)
							{
								kingCheck(bk);
							}
							else
							{
								kingCheck(wk);
							}
						}
						
					}
					
				}
			}
			
		}
	}
	
	public void mouseEntered(MouseEvent e)
	{
		//l.setText("Mouse Entered");
	}
	public void mouseExited(MouseEvent e)
	{
		//l.setText("Mouse Exited");
	}
	public void mousePressed(MouseEvent e)
	{
		//l.setText("Mouse Pressed");
	}
	public void mouseReleased(MouseEvent e)
	{
		//l.setText("Mouse Released");
	}
	
	boolean move(Coordinates c)
	{
		
		switch(cb[c.r][c.c].p)
		{
			case 0 :
				list=Pawn.validMoves(c);
				break;
			case 1 :
				list=k.validMoves(c);
				break;
			case 2 :
				list=Queen.validMoves(c);
				break;
			case 3 :
				list=Bishop.validMoves(c);
				break;
			case 4 :
				list=Knight.validMove(c);
				break;
			case 5 :
				list=Rook.validMoves(c);
				break;
		}
		if(list.size()==0)
		{
			return cb[c.r][c.c].color;
			
		}
		for(int i=0;i<list.size();i++)
		{
			possible(list.get(i));
		}
		tf=false;
		return !cb[c.r][c.c].color;
		
	}
	void display()
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{	
				
				if(cb[i][j]!=null)
				{
					//color of piece
					if(cb[i][j].color)
					{
						System.out.print("W");
					}
					else
					{
						System.out.print("B");
					}
					
					//Value of piece
					
					if(cb[i][j].p==5)
					{
						System.out.print("R ");
					}
					else if(cb[i][j].p==4)
					{
						System.out.print("N ");
					}
					
					else if(cb[i][j].p==3)
					{
						System.out.print("B ");
					}
					else if(cb[i][j].p==2)
					{
						System.out.print("Q ");
					}
					else if(cb[i][j].p==1)
					{
						System.out.print("K ");
					}
					else
					{
						System.out.print("P ");
					}
				}
				else
				{	
					System.out.print("__ ");
				}
			}
			System.out.println();
		}
		System.out.println(c.r+" "+c.c);

	}	
}
