package pieces;

public class King extends Pieces{
	boolean hasMoved = false;
	
	@Override
	public boolean canMove(int src_numIndex, int src_charIndex,int numIndex, int charIndex, String[][] board, boolean valid) {
		
	/* ERROR-CHECKING IS DONE. LET"S DO THE IMPLEMENTATION. */
	if(((src_numIndex == numIndex-1) || (src_numIndex == numIndex+1)) && (src_charIndex == charIndex)) {
		this.hasMoved = true;
		return true; // 2 squares
	}
	else if((src_numIndex == numIndex) && (src_charIndex+1 == charIndex)) {
		this.hasMoved = true;
		return true;  // 1 square
	}
	else if((src_numIndex == numIndex) && (src_charIndex-1 == charIndex)) {
		this.hasMoved = true;
		return true; // 1 square
	}
	else if(((src_numIndex == numIndex-1) || (src_numIndex == numIndex+1)) && (src_charIndex-1 == charIndex)) {
		this.hasMoved = true;
		return true; // 2 squares
	}
	else if(((src_numIndex == numIndex-1) || (src_numIndex == numIndex+1)) && (src_charIndex+1 == charIndex)) {
		this.hasMoved = true;
		return true; // 2 squares
	}
	//castling **WORK IN PROGRESS**
	else if((!hasMoved) && (src_numIndex == 8) && (charIndex == 7) && (board[8][6].equals("  ")) && (charIndex == 7) && (board[8][7].equals("##"))) {
		this.hasMoved = true;
		return true;
	}
	else if(!hasMoved) {
		if(valid) {
			if(src_charIndex == charIndex-2) {
				if(board[src_numIndex][src_charIndex+1].equals("  ") && board[src_numIndex][src_charIndex+2].equals("##") && board[src_numIndex][src_charIndex+3].equals("wR")) {
					hasMoved = true;
					board[7][7] = "  ";
					board[7][5] = "wR";
					return true;
				}
			}
			if(src_charIndex == charIndex+2) {
				if(board[src_numIndex][src_charIndex-1].equals("  ") && board[src_numIndex][src_charIndex-2].equals("##") && board[src_numIndex][src_charIndex-3].equals("  ") && board[src_numIndex][src_charIndex-4].equals("wR")) {
					hasMoved = true;
					board[7][0] = "##";
					board[7][3] = "wR";
					return true;
				}
			}
		}
		else if(!valid) {
			if(src_charIndex == charIndex-2) {
				if(board[src_numIndex][src_charIndex+1].equals("##") && board[src_numIndex][src_charIndex+2].equals("  ") && board[src_numIndex][src_charIndex+3].equals("bR")) {
					hasMoved = true;
					board[0][7] = "##";
					board[0][5] = "bR";
					return true;
				}
			}
			if(src_charIndex == charIndex+2) {
				if(board[src_numIndex][src_charIndex-1].equals("##") && board[src_numIndex][src_charIndex-2].equals("  ") && board[src_numIndex][src_charIndex-3].equals("##") && board[src_numIndex][src_charIndex-4].equals("bR")) {
					hasMoved = true;
					board[0][0] = "  ";
					board[0][3] = "bR";
					return true;
				}
			}
		}
	}
	
	// total should be 8 squares. ONE SQUARE FROM CURRENT POSITION.
	
		return false;
	}
	

	public boolean canPromote(int src_numIndex, int src_charIndex,int numIndex, int charIndex, String promPiece, String[][] board, boolean valid) {
		return false;
	}
	
	@Override
	public String toString() {
		return "K";
	}




	@Override
	public boolean check(int src_numIndex, int src_charIndex, int numIndex, int charIndex, String[][] board, boolean valid) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean precheckmate(int numIndex, int charIndex, String[][] board,
			boolean valid, int a, int b) {
		// TODO Auto-generated method stub
	if(numIndex-1 == a && charIndex-1 == b)
		return true;
	
	if(numIndex-1 == a && charIndex==b)
		return true;
	
	if(numIndex-1 == a && charIndex+1==b)
		return true;
	
	if(numIndex == a && charIndex-1==b)
		return true;
	
	if(numIndex == a && charIndex+1==b)
		return true;
	if(numIndex+1 == a && charIndex-1==b)
		return true;
	if(numIndex+1 == a && charIndex==b)
		return true;
	if(numIndex+1 == a && charIndex+1==b)
		return true;
	
	return false;
}


	@Override
	public boolean canEnPassant(int src_numIndex, int src_charIndex, int numIndex, int charIndex,
			int lastTurn_src_numIndex, int lastTurn_numIndex, int lastTurn_charIndex, String lastTurn_pieceType,
			String[][] board, boolean valid) {
		// TODO Auto-generated method stub
		return false;
	}
}
