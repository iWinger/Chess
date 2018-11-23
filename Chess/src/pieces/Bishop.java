package pieces;

public class Bishop extends Pieces{
	@Override
	public boolean canMove(int src_numIndex, int src_charIndex,int numIndex, int charIndex, String[][] board, boolean valid) {
		
		//BOTTOM RIGHT DIAGONAL.
	if(numIndex > src_numIndex && charIndex > src_charIndex) {
		for(int i = src_numIndex, j= src_charIndex; (i < numIndex && j < charIndex); i++,j++) {
			
			if(i == src_numIndex || j == src_charIndex) 
				continue;
			
			if(i == numIndex || j == charIndex)
				continue;
			
			
				if(!board[i][j].equals("  ") && !board[i][j].equals("##"))
					return false;
			}
				return true;
		}
		
		//UPPER RIGHT DIAGONAL.
		if(numIndex < src_numIndex && charIndex > src_charIndex) {
			for(int i = src_numIndex, j= src_charIndex; (i > numIndex && j < charIndex); i--,j++) {
				
				if(i == src_numIndex || j == src_charIndex) 
					continue;
				
				if(i == numIndex || j == charIndex)
					continue;
				
				
					if(!board[i][j].equals("  ") && !board[i][j].equals("##"))
						return false;
				}
					return true;
		}
		
		//UPPER LEFT DIAGONAL.
		if(numIndex < src_numIndex && charIndex < src_charIndex) {
			for(int i = src_numIndex, j= src_charIndex; (i > numIndex && j > charIndex); i--,j--) {
				
				if(i == src_numIndex || j == src_charIndex) 
					continue;
				
				if(i == numIndex || j == charIndex)
					continue;
				
				
					if(!board[i][j].equals("  ") && !board[i][j].equals("##"))
						return false;
				}
					return true;
		}
		//BOTTOM LEFT DIAGONAL.
		if(numIndex > src_numIndex && charIndex < src_charIndex) {
			for(int i = src_numIndex, j= src_charIndex; (i < numIndex && j > charIndex); i++,j--) {
				
				if(i == src_numIndex || j == src_charIndex) 
					continue;
				
				if(i == numIndex || j == charIndex)
					continue;
				
				
					if(!board[i][j].equals("  ") && !board[i][j].equals("##"))
						return false;
				}
					return true;
		}
		
		
		
		return false;
	
	}
	

	@Override
	public String toString() {
		return "B";
	}


	@Override
	public boolean check(int src_numIndex, int src_charIndex, int numIndex, int charIndex, String[][] board, boolean valid) {
		for(int i = numIndex, j= charIndex; (i <= MAXINDEX && j <= MAXINDEX); i++,j++) {
			if(i == numIndex || j == charIndex)
				continue;
			
			if(!board[i][j].equals("  ") && !board[i][j].equals("##")) {
				if(valid) {
					
					if(board[i][j].equals("bK")) {
						return true;
						
					}
						
				}
					else {
						if(board[i][j].equals("wK")) {
							return true;
						
						}
				}
				
				break;
			}
		}
			
			for(int i = numIndex, j= charIndex; (i >= MININDEX && j <= MAXINDEX); i--,j++) {
				if(i == numIndex || j == charIndex)
					continue;
				
				if(!board[i][j].equals("  ") && !board[i][j].equals("##")) {
					if(valid) {
						
						if(board[i][j].equals("bK")) {
							return true;
							
						}
							
					}
						else {
							if(board[i][j].equals("wK")) {
								return true;
							
							}
					}
					
					break;
				}
			
		}
	

			for(int i = numIndex, j= charIndex; (i >= MININDEX && j >= MININDEX); i--,j--) {
				if(i == numIndex || j == charIndex)
					continue;
				
				if(!board[i][j].equals("  ") && !board[i][j].equals("##")) {
					if(valid) {
						
						if(board[i][j].equals("bK")) {
							return true;
							
						}
							
					}
						else {
							if(board[i][j].equals("wK")) {
								return true;
							
							}
					}
					
					break;
				}
			
		}	
	
			for(int i = numIndex, j= charIndex; (i <= MAXINDEX && j >= MININDEX); i++,j--) {
				if(i == numIndex || j == charIndex)
					continue;
				
				if(!board[i][j].equals("  ") && !board[i][j].equals("##")) {
					if(valid) {
						
						if(board[i][j].equals("bK")) {
							return true;
							
						}
							
					}
						else {
							if(board[i][j].equals("wK")) {
								return true;
							
							}
					}
					
					break;
				}
			
		}
			return false;
}


	@Override
	public boolean canPromote(int src_numIndex, int src_charIndex, int numIndex, int charIndex, String promPiece,
			String[][] board, boolean valid) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean precheckmate(int numIndex, int charIndex, String[][] board,
			boolean valid, int a, int b) {
		for(int i = numIndex, j= charIndex; (i <= MAXINDEX && j <= MAXINDEX); i++,j++) {
			if(i == numIndex || j == charIndex)
				continue;
			
			if(i == a && j == b)
				return true;
			
			if(!board[i][j].equals("  ") && !board[i][j].equals("##")) {
			break;
			}
		}
			
			for(int i = numIndex, j= charIndex; (i >= MININDEX && j <= MAXINDEX); i--,j++) {
				if(i == numIndex || j == charIndex)
					continue;
				
				if( i == a && j == b)
					return true;
				
				if(!board[i][j].equals("  ") && !board[i][j].equals("##")) {
					break;
					
				}
			
		}
	

			for(int i = numIndex, j= charIndex; (i >= MININDEX && j >= MININDEX); i--,j--) {
				if(i == numIndex || j == charIndex)
					continue;
				
				if(i == a && j == b)
					return true;
				if(!board[i][j].equals("  ") && !board[i][j].equals("##")) {
					break;
				}
			
		}	
	
			for(int i = numIndex, j= charIndex; (i <= MAXINDEX && j >= MININDEX); i++,j--) {
				if(i == numIndex || j == charIndex)
					continue;
				
				if(i==a && j == b)
					return true;
				if(!board[i][j].equals("  ") && !board[i][j].equals("##")) {
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
