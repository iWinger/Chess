package pieces;

public class Rook extends Pieces {
// rook can't move if there is a piece in its way, if there's more 2
	@Override
	public boolean canMove(int src_numIndex, int src_charIndex,int numIndex, int charIndex, String[][] board, boolean valid) {
	if(src_charIndex == charIndex) { // VERTICAL.  
	
	if(src_numIndex < numIndex) { 
		for ( int i = src_numIndex; i <= numIndex; i++) {
			if(i == src_numIndex)
				continue;
			
			if( i == numIndex)
				continue;
			
			if(!board[i][src_charIndex].equals("  ") && !board[i][src_charIndex].equals("##"))
					return false;
			
			
		}
		return true;
	}
	
	else {
		
		for ( int i = src_numIndex; i >= numIndex; i--) {
			if(i == src_numIndex)
				continue;
			
			if( i == numIndex)
				continue;
			
			if(!board[i][src_charIndex].equals("  ") && !board[i][src_charIndex].equals("##"))
					return false;
			
			
		}
		return true;
		
		
	}
	
	
	}
	else if(src_numIndex == numIndex) { // HORIZONTAL.
		if(src_charIndex < charIndex) {
			for ( int i = src_charIndex; i <= charIndex; i++) {
				if(i == src_charIndex)
					continue;
				
				if( i == charIndex)
					continue;
				
				if(!board[src_numIndex][i].equals("  ") && !board[src_numIndex][i].equals("##"))
						return false;
				
			}
			return true;
		}
		else {
			for ( int i = src_charIndex; i >= charIndex; i--) {
				if(i == src_charIndex)
					continue;
			
				if( i == charIndex)
					continue;
			
				if(!board[src_numIndex][i].equals("  ") && !board[src_numIndex][i].equals("##")) {
					//System.out.println(i);
					return false;
				}
				
			}
				return true;
		
		}
	}
		
		return false;
		// TODO Auto-generated method stub
 		
	}
	

	@Override
	public String toString() {
		return "R";
	}
	
	
	public boolean check(int src_numIndex, int src_charIndex, int numIndex, int charIndex, String[][] board,boolean valid) {
		//You only need the destination for check.
		boolean check = false;
		
		 
		
			
				for ( int i = charIndex; i <= MAXINDEX; i++) {
					if(i == charIndex)
						continue;
					
					
					if(!board[numIndex][i].equals("  ") && !board[numIndex][i].equals("##")) {
						if(valid) {
							
							if(board[numIndex][i].equals("bK")) {
								return true;
								
							}
								
						}
							else {
								if(board[numIndex][i].equals("wK")) {
									return true;
								
								}
						}
						check = false;
						break;
					}
				
				}
			
	
				
				for ( int i = charIndex; i >= MININDEX; i--) {
					if(i == charIndex)
						continue;
					
					
					if(!board[numIndex][i].equals("  ") && !board[numIndex][i].equals("##")) {
						if(valid) {
							
							if(board[numIndex][i].equals("bK")) {
								return true;
							}
								
						}
							else {
								if(board[numIndex][i].equals("wK")) {
									return true;
								}
						}
						check = false;
						break;
					}
					
				}
				
				
				
			
			
				
					for ( int i = numIndex; i <= MAXINDEX; i++) {
						if(i == numIndex)
							continue;
						
						
						if(!board[i][charIndex].equals("  ") && !board[i][charIndex].equals("##")) {
							if(valid) {
							
								if(board[i][charIndex].equals("bK")) {
									return true;
								}
									
							}
								else {
									if(board[i][charIndex].equals("wK")) {
										return true;
									}
							}
							check = false;
							break;
						}
						
					
					
				}
				
					
					
					for ( int i = numIndex; i >= MININDEX; i--) {
						if(i == numIndex)
							continue;
					
					
						if(!board[i][charIndex].equals("  ") && !board[i][charIndex].equals("##")) {
							if(valid) {
								if(board[i][charIndex].equals("bK")) {
									return true;
								}
									
							}
								else {
									if(board[i][charIndex].equals("wK")) {
										return true;
									}
							}
							check = false;
							break;
						
						}
					
						
				
				}
			
	   return check;
	}


	@Override
	public boolean canPromote(int src_numIndex, int src_charIndex, int numIndex, int charIndex, String promPiece,
			String[][] board, boolean valid) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean precheckmate(int numIndex, int charIndex, String[][] board,
			boolean valid, int row, int col) {
	
		//You only need the destination for check.
				boolean check = false;
				
				 
				
					
						for ( int i = charIndex; i <= MAXINDEX; i++) {
							if(i == charIndex)
								continue;
							
							if(numIndex == row && i == col)
								return true;
							
							if(!board[numIndex][i].equals("  ") && !board[numIndex][i].equals("##")) {
								break;
						
						}
					
						}
						
						for ( int i = charIndex; i >= MININDEX; i--) {
							if(i == charIndex)
								continue;
							
							if(numIndex == row && i == col)
								return true;
							
							
							if(!board[numIndex][i].equals("  ") && !board[numIndex][i].equals("##")) {
								break;
							
						}
						
						}
						
					
					
						
							for ( int i = numIndex; i <= MAXINDEX; i++) {
								if(i == numIndex)
									continue;
								
								
								if(i == row && charIndex == col)
									return true;
								
								
								
								if(!board[i][charIndex].equals("  ") && !board[i][charIndex].equals("##")) {
									break;
								}
								
							
							
						}
						
							
							
							for ( int i = numIndex; i >= MININDEX; i--) {
								if(i == numIndex)
									continue;
								
								if(i == row && charIndex == col)
									return true;
							
							
								if(!board[i][charIndex].equals("  ") && !board[i][charIndex].equals("##")) {
									break;
								
								}
							
								
						
						}
					
			  
		
		
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