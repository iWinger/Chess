package pieces;
/**
* The Pieces class is the overarching abstract class that
* all of the chess pieces extend. This class lays the framework
* for all pieces to implement methods such as canMove and move, but also
* provides the abstract methods for special cases such as Promote and En Passant
*
* @author  Wingjun Chan
* @author  Jessi Medina
* Date: 10/31/2018
*/
public abstract class Pieces {
	//Instance Fields.
	char[] CHAR_ARR = new char[] {'a','b','c','d','e','f','g','h'};
	int[] NUM_ARR = new int[]{8,7,6,5,4,3,2,1};
	int charIndex = 0;
	int numIndex = 0;
	int src_charIndex = 0;
	int src_numIndex = 0;
	int MAXINDEX = 7;
	int MININDEX = 0;
	int count = 0;
	//Methods.
	public abstract boolean canMove(int src_numIndex, int src_charIndex,int numIndex, int charIndex, String[][] board, boolean valid);
	public void move(int src_numIndex, int src_charIndex,int numIndex, int charIndex, String[][] board) {
	
		board[numIndex][charIndex] = board[src_numIndex][src_charIndex];
		board[src_numIndex][src_charIndex] = "G";
		
			
	}
	public abstract boolean check(int src_numIndex, int src_charIndex,int numIndex, int charIndex, String[][] board, boolean valid);
	
    public abstract boolean canPromote(int src_numIndex, int src_charIndex,int numIndex, int charIndex, String promPiece, String[][] board, boolean valid);

    public abstract boolean precheckmate(int numIndex, int charIndex, String[][] board, boolean valid,int a, int b);

    public abstract boolean canEnPassant(int src_numIndex, int src_charIndex,int numIndex, int charIndex, int lastTurn_src_numIndex, int lastTurn_numIndex, int lastTurn_charIndex, String lastTurn_pieceType, String[][] board, boolean valid);

}
