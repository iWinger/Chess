package pieces;

public class Pawn extends Pieces {
//WHITE IS TRUE, BLACK IS FALSE, VALID REPRESENTS T/F
	

	
	public boolean canPromote(int src_numIndex, int src_charIndex,int numIndex, int charIndex, String promote, String[][] board, boolean valid) {
		if(valid) {
			if((src_numIndex==numIndex+1) && (numIndex == 0) && (src_charIndex==charIndex) && (charIndex < 8) && (numIndex < 8)) {
				return true;
			}
			else if((src_numIndex==numIndex+1) && (numIndex == 0) && (src_charIndex==charIndex-1) && (charIndex < 8) && (charIndex>=0) && board[numIndex][charIndex].contains("b") && (numIndex < 8)) {
				return true;
			}
			else if((src_numIndex==numIndex+1) && (numIndex == 0) && (src_charIndex==charIndex+1) && (charIndex < 8) && (charIndex>=0) && board[numIndex][charIndex].contains("b") && (numIndex < 8)) {
				return true;
			}
		}
		else if(!valid) {
			if((src_numIndex==numIndex-1) && (numIndex == 7) && (src_charIndex==charIndex)) {
				return true;
			}
			else if((src_numIndex==numIndex-1) && (numIndex == 7) && (src_charIndex==charIndex-1) && (charIndex < 8) && (charIndex>=0) && board[numIndex][charIndex].contains("w") && (numIndex < 8)) {
				return true;
			}
			else if((src_numIndex==numIndex-1) && (numIndex == 7) && (src_charIndex==charIndex+1) && (charIndex < 8) && (charIndex>=0) && board[numIndex][charIndex].contains("w") && (numIndex < 8)) {
				return true;
			}
		}
		return false;
	}
	
	@Override            
	public boolean canMove(int src_numIndex, int src_charIndex,int numIndex, int charIndex, String[][] board, boolean valid) {
		
	if(valid) { 

		// white 2 moves
		if(src_numIndex == 6 && src_charIndex == 0 && (src_numIndex-2 == numIndex))
				return true;
		if(src_numIndex == 6 && src_charIndex == 1 && (src_numIndex-2 == numIndex))
			return true;
		if(src_numIndex == 6 && src_charIndex == 2 && (src_numIndex-2 == numIndex))
			return true;
		if(src_numIndex == 6 && src_charIndex == 3 && (src_numIndex-2 == numIndex))
			return true;
		if(src_numIndex == 6 && src_charIndex == 4 && (src_numIndex-2 == numIndex))
			return true;
		if(src_numIndex == 6 && src_charIndex == 5 && (src_numIndex-2 == numIndex))
			return true;
		if(src_numIndex == 6 && src_charIndex == 6 && (src_numIndex-2 == numIndex))
			return true;
		if(src_numIndex == 6 && src_charIndex == 7 && (src_numIndex-2 == numIndex))
			return true;
		if(src_numIndex == 6 && src_charIndex == 8 && (src_numIndex-2 == numIndex))
			return true;
		
		
		
		if(src_numIndex-1 >= MININDEX)
			if(src_numIndex-1 == numIndex && src_charIndex == charIndex) { // only move 1 spot forward
				if((board[src_numIndex-1][src_charIndex].equals("  ")) || (board[src_numIndex-1][src_charIndex].equals("##")))
				return true;
			}	
		
			if(src_numIndex-1 <= MAXINDEX && src_charIndex+1 <= MAXINDEX)
			if(src_numIndex-1 == numIndex && src_charIndex+1 == charIndex)	
			if(!board[src_numIndex-1][src_charIndex+1].equals("  ") && !board[src_numIndex-1][src_charIndex+1].equals("##")){
				return true;
			}
			
			if(src_numIndex-1 <= MAXINDEX && src_charIndex-1 >= MININDEX)
			if(src_numIndex-1 == numIndex && src_charIndex-1 == charIndex)
			if(!board[src_numIndex-1][src_charIndex-1].equals("  ") && !board[src_numIndex-1][src_charIndex-1].equals("##")){
				return true;
			}
			
	
			
			
			
			
			
			
				
			
		}	
	else { // black pawn
		
		//black 2 moves
		
		if(src_numIndex == 1 && src_charIndex == 0 && (src_numIndex+2 == numIndex))
			return true;
	if(src_numIndex == 1 && src_charIndex == 1 && (src_numIndex+2 == numIndex))
		return true;
	if(src_numIndex == 1 && src_charIndex == 2 && (src_numIndex+2 == numIndex))
		return true;
	if(src_numIndex == 1 && src_charIndex == 3 && (src_numIndex+2 == numIndex))
		return true;
	if(src_numIndex == 1 && src_charIndex == 4 && (src_numIndex+2 == numIndex))
		return true;
	if(src_numIndex == 1 && src_charIndex == 5 && (src_numIndex+2 == numIndex))
		return true;
	if(src_numIndex == 1 && src_charIndex == 6 && (src_numIndex+2 == numIndex))
		return true;
	if(src_numIndex == 1 && src_charIndex == 7 && (src_numIndex+2 == numIndex))
		return true;
	if(src_numIndex == 1 && src_charIndex == 8 && (src_numIndex+2 == numIndex))
		return true;
		
		
		
		if(src_numIndex<= MAXINDEX)
			if(src_numIndex+1 == numIndex && src_charIndex == charIndex) { // only move 1 spot forward
				return true;
		}
		
			if(src_numIndex+1 <= MAXINDEX && src_charIndex+1 <= MAXINDEX)
				if(src_numIndex+1 == numIndex && src_charIndex+1 == charIndex)	
			if(!board[src_numIndex+1][src_charIndex+1].equals("  ") && !board[src_numIndex+1][src_charIndex+1].equals("##")){
				return true;
			}
			
		
			if(src_numIndex+1 <= MAXINDEX && src_charIndex-1 >= MININDEX)
				if(src_numIndex+1 == numIndex && src_charIndex-1 == charIndex)	
			if(!board[src_numIndex+1][src_charIndex-1].equals("  ") && !board[src_numIndex+1][src_charIndex-1].equals("##")){
				return true;
			}
			
			
		
		
	
	}		
		return false;
		
					
	
	}
	/**
	 * This method will promote the pawn to the specified promotion piece if one is given.
	 * If no promPiece is given, the pawn will be promoted to a queen.
	 * 
	 * @param src_numIndex int corresponding to the row the piece is moving from.
	 * @param src_charIndex int corresponding to the column the piece is moving from.
	 * @param numIndex int corresponding to the row the piece is moving to.
	 * @param charIndex int corresponding to the column the piece is moving to.
     * @param promPiece String containing the letter corresponding to which type of piece the promoted piece would become.
     * @param board 2D array containing the current board.
	 * @param valid boolean verifying the color of the piece. valid == white. !valid == black.
	 */

	
	public void promote(int src_numIndex, int src_charIndex,int numIndex, int charIndex, String promPiece, String[][] board, boolean valid) {
		if(valid) {
			if(promPiece!=null) {
				board[numIndex][charIndex] = ("w"+promPiece.toUpperCase());
			}
			else {
				board[numIndex][charIndex] = ("wQ");
			}
				board[src_numIndex][src_charIndex] = "G";
		}
		else if(!valid)
		{
			if(promPiece!=null) {
				board[numIndex][charIndex] = ("b" + promPiece.toUpperCase());
			}
			else {
				board[numIndex][charIndex] = ("bQ");
			}
				board[src_numIndex][src_charIndex] = "G";
		}
	}
	
	@Override
	public String toString() {
		return "p";
	}

	@Override
	public boolean check(int src_numIndex, int src_charIndex, int numIndex, int charIndex, String[][] board,
			boolean valid) {
	if(valid) {
		
		if(numIndex-1 >= MININDEX && charIndex+1 <= MAXINDEX)	
			if(board[src_numIndex-1][src_charIndex+1].equals("bK")){
				return true;
			}
			
			if(numIndex-1 >= MININDEX && charIndex-1 >= MININDEX)	
			if(board[numIndex-1][charIndex-1].equals("bK")){
				return true;
			}
	}
	
	else {
		
		if(numIndex+1 <= MAXINDEX && charIndex+1 <= MAXINDEX)
		if(board[src_numIndex+1][src_charIndex+1].equals("wK")){
			return true;
		}
		
	
		if(numIndex+1 <= MAXINDEX && charIndex-1 >= MININDEX)	
		if(board[numIndex+1][charIndex-1].equals("wK")){
			return true;
		}
		
		
		
	}
	
	
	
	
		return false;
	}

	@Override
	public boolean precheckmate(int numIndex, int charIndex, String[][] board,
			boolean valid, int a, int b) {
		if(valid) {
			
			if(numIndex-1 >= MININDEX && charIndex+1 <= MAXINDEX)	
				if(numIndex-1 == a && charIndex+1 == b){
					return true;
				}
				
				if(numIndex-1 >= MININDEX && charIndex-1 >= MININDEX)	
				if(numIndex-1 == a && charIndex+1 == b){
					return true;
				}
		}
		
		else {
			
			if(numIndex+1 <= MAXINDEX && charIndex+1 <= MAXINDEX)
			if(numIndex+1 == a && charIndex+1 == b){
				return true;
			}
			
		
			if(numIndex+1 <= MAXINDEX && charIndex-1 >= MININDEX)	
			if(numIndex+1 == a && charIndex-1 == b){
				return true;
			}
			
			
			
		}
		
		
		
		
			return false;
	}
	
	/**
	 * This method will execute an En Passant special move for the pawn specified.
	 * 
	 * @param src_numIndex int corresponding to the row the piece is moving from.
	 * @param src_charIndex int corresponding to the column the piece is moving from.
	 * @param numIndex int corresponding to the row the piece is moving to.
	 * @param charIndex int corresponding to the column the piece is moving to.
     * @param lastTurn_src_numIndex int corresponding to the row the piece from the last turn moved from.
     * @param lastTurn_numIndex int corresponding to the row the piece from the last turn moved to.
     * @param lastTurn_charIndex int corresponding to the column the piece from the last turn moved from.
     * @param lastTurn_pieceType String containing a letter corresponding to the type of piece that moved last turn.
     * @param board 2D array containing the current board.
	 * @param valid boolean verifying the color of the piece. valid == white. !valid == black.
	 */

	@Override
	public boolean canEnPassant(int src_numIndex, int src_charIndex,int numIndex, int charIndex, int lastTurn_src_numIndex, int lastTurn_numIndex, int lastTurn_charIndex, String lastTurn_pieceType, String[][] board, boolean valid) {
		//lastTurn_src_numIndex
		//lastTurn_numIndex
		//lastTurn_pieceType
		
		if(valid) {
			if(lastTurn_pieceType == "p"){
				if(lastTurn_src_numIndex == 1) {
					if(lastTurn_numIndex == 3) {
						if(src_numIndex == lastTurn_numIndex) {
							if((src_charIndex-1==lastTurn_charIndex) || (src_charIndex+1==lastTurn_charIndex)) {
								return true;
							}
						}
					}
				}
			}
		}
		else if(!valid) {
			if(lastTurn_pieceType == "p"){
				if(lastTurn_src_numIndex == 6) {
					if(lastTurn_numIndex == 4) {
						if(src_numIndex == lastTurn_numIndex) {
							if((src_charIndex-1==lastTurn_charIndex) || (src_charIndex+1==lastTurn_charIndex)) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public void enPassant(int src_numIndex, int src_charIndex,int numIndex, int charIndex, int lastTurn_src_numIndex, int lastTurn_numIndex, int lastTurn_charIndex, String lastTurn_pieceType, String[][] board, boolean valid) {
		if(valid) {
			board[src_numIndex][src_charIndex] = "G";
			board[lastTurn_numIndex][lastTurn_charIndex] = "G";
			board[numIndex][charIndex]="wp";
		}
		else if(!valid) {
			board[src_numIndex][src_charIndex] = "G";
			board[lastTurn_numIndex][lastTurn_charIndex] = "G";
			board[numIndex][charIndex]="bp";
		}
	}
}
