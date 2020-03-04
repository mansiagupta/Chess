/**This  class is used to save the information about the piece.
 * 
 * @author Mansi Gupta
 * @author Naveen Gaur
 *
 */
public class Piece 
{
	Piece(int p,boolean c)
	{
		this.p=p;
		this.color=c;
		
	}
	/**
	 *0:Pawn
	 *1:King
	 *2:Queen
	 *3:Bishop
	 *4:Knight
	 *5:Rook
	 *false for black
	 *true for white
	 */
	public int p;
	/**Variable c store the color of piece,
	 * false for black and
	 * true for white.
	 */
	public boolean color;

}
