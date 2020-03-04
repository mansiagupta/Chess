public class ChessBoard 
{
	static Piece [][]cb;
	static Coordinates wk,bk;
	/**Chess Board: Contain all the pieces of the game.
	 * 
	 */
	
	
	static void newGame()
	{
		/**This function set the initial position of the pieces in the game.
		 *0:Pawn
		 *1:King
		 *2:Queen
		 *3:Bishop
		 *4:Knight
		 *5:Rook
		 *false for black
		 *true for white
		 */
		cb=new Piece[8][8];
		

		wk=new Coordinates(7,4);
		bk=new Coordinates(0,4);
		cb[0][0]=new Piece(5,false);
		cb[0][1]=new Piece(4,false);
		cb[0][2]=new Piece(3,false);
		cb[0][3]=new Piece(2,false);
		cb[0][4]=new Piece(1,false);
		cb[0][5]=new Piece(3,false);
		cb[0][6]=new Piece(4,false);
		cb[0][7]=new Piece(5,false);
		
			
		cb[7][0]=new Piece(5,true);
		cb[7][1]=new Piece(4,true);
		cb[7][2]=new Piece(3,true);
		cb[7][3]=new Piece(2,true);
		cb[7][4]=new Piece(1,true);
		cb[7][5]=new Piece(3,true);
		cb[7][6]=new Piece(4,true);
		cb[7][7]=new Piece(5,true);
		
		for(int i=0;i<8;i++)
		{
			cb[1][i]=new Piece(0,false);
			cb[6][i]=new Piece(0,true);
		}
		
	}

}
