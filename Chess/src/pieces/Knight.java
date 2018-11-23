package pieces;

public class Knight extends Pieces{

	@Override
	public boolean canMove(int src_numIndex, int src_charIndex,int numIndex, int charIndex, String[][] board, boolean valid) {
		// 8 moves for horse
		//System.out.println(src_numIndex + " " + src_charIndex + " " + numIndex + " " + charIndex);
		
		if((src_numIndex+2 == numIndex) && ((src_charIndex+1 == charIndex) || (src_charIndex-1 == charIndex))) 
			return true; // 2 squares 
		
		
			// TODO Auto-generated method stub
		
		
		else if((src_numIndex-2 == numIndex) && ((src_charIndex+1 == charIndex) || (src_charIndex-1 == charIndex))) {
			return true; // 2 squares
		}
		
	
		
		else if((src_charIndex+2 == charIndex) && ((src_numIndex+1 == numIndex) || (src_numIndex-1 == numIndex)))
			return true;
		
	
		
		else if((src_charIndex-2 == charIndex) && ((src_numIndex+1 == numIndex) || (src_numIndex-1 == numIndex))) 
			return true;
		
		
		
		return false;
	}
	

	@Override
	public String toString() {
		return "N";
	}


	@Override
	public boolean check(int src_numIndex, int src_charIndex, int numIndex, int charIndex, String[][] board, boolean valid) {
	//System.out.println(numIndex + " " + charIndex);
		if(numIndex+2 <= MAXINDEX && charIndex+1 <= MAXINDEX) {	
		if(valid) {
			if(board[numIndex+2][charIndex+1].equals("bK")) {
				return true;
				
			}
		}
				
		
			else {
				if(board[numIndex+2][charIndex+1].equals("wK")) {
					return true;
				
				}
			}
		}
		
		if(numIndex+2 <= MAXINDEX && charIndex-1 >= MININDEX) {	
			if(valid) {
				if(board[numIndex+2][charIndex-1].equals("bK")) {
					return true;
					
				}
			}
					
			
				else {
					if(board[numIndex+2][charIndex-1].equals("wK")) {
						return true;
					
					}
				}
			}
		
		if(numIndex+1 <= MAXINDEX && charIndex+2 <= MAXINDEX) {	
			if(valid) {
				if(board[numIndex+1][charIndex+2].equals("bK")) {
					return true;
					
				}
			}
					
			
				else {
					if(board[numIndex+1][charIndex+2].equals("wK")) {
						return true;
					
					}
				}
			}
		
		
		if(numIndex+1 <= MAXINDEX && charIndex-2 >= MININDEX) {	
			if(valid) {
				if(board[numIndex+1][charIndex-2].equals("bK")) {
					return true;
					
				}
			}
					
			
				else {
					if(board[numIndex+1][charIndex-2].equals("wK")) {
						return true;
					
					}
				}
			}
		
		
	
			
			if(numIndex-1 >= MININDEX && charIndex-2 >= MININDEX) {	
				if(valid) {
					if(board[numIndex-1][charIndex-2].equals("bK")) {
						return true;
						
					}
				}
						
				
					else {
						if(board[numIndex-1][charIndex-2].equals("wK")) {
							return true;
						
						}
					}
				}
			
			if(numIndex-1 >= MININDEX && charIndex+2 <= MAXINDEX) {	
				if(valid) {
					if(board[numIndex-1][charIndex+2].equals("bK")) {
						return true;
						
					}
				}
						
				
					else {
						if(board[numIndex-1][charIndex+2].equals("wK")) {
							return true;
						
						}
					}
				}
			
			
			if(numIndex-2 >= MININDEX && charIndex-1 >= MININDEX) {	
				if(valid) {
					if(board[numIndex-2][charIndex-1].equals("bK")) {
						return true;
						
					}
				}
						
				
					else {
						if(board[numIndex-2][charIndex-1].equals("wK")) {
							return true;
						
						}
					}
				}
			
			if(numIndex-2 >= MININDEX && charIndex+1 <= MAXINDEX) {	
				if(valid) {
					if(board[numIndex-2][charIndex+1].equals("bK")) {
						return true;
						
					}
				}
						
				
					else {
						if(board[numIndex-2][charIndex+1].equals("wK")) {
							return true;
						
						}
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
		
		if(numIndex+2 <= MAXINDEX && charIndex+1 <= MAXINDEX) {	
			if(valid) {
				if(numIndex+2 == a && charIndex+1 == b) {
					return true;
					
				}
			}
					
			
				else {
					if(numIndex+2 == a && charIndex+1 == b) {
						return true;
					
					}
				}
			}
			
			if(numIndex+2 <= MAXINDEX && charIndex-1 >= MININDEX) {	
				if(valid) {
					if(numIndex+2 == a && charIndex-1 == b) {
						return true;
						
					}
				}
						
				
					else {
						if(numIndex+2 == a && charIndex-1 == b) {
							return true;
						
						}
					}
				}
			
			if(numIndex+1 <= MAXINDEX && charIndex+2 <= MAXINDEX) {	
				if(valid) {
					if(numIndex+1 == a && charIndex+2 == b) {
						return true;
						
					}
				}
						
				
					else {
						if(numIndex+1 == a && charIndex+2 == b) {
							return true;
						
						}
					}
				}
			
			
			if(numIndex+1 <= MAXINDEX && charIndex-2 >= MININDEX) {	
				if(valid) {
					if(numIndex+1 == a && charIndex-2 == b) {
						return true;
						
					}
				}
						
				
					else {
						if(numIndex+1 == a && charIndex-2 == b) {
							return true;
						
						}
					}
				}
			
			
		
				
				if(numIndex-1 >= MININDEX && charIndex-2 >= MININDEX) {	
					if(valid) {
						if(numIndex-1 == a && charIndex-2 == b) {
							return true;
							
						}
					}
							
					
						else {
							if(numIndex-1 == a && charIndex-2 == b) {
								return true;
							
							}
						}
					}
				
				if(numIndex-1 >= MININDEX && charIndex+2 <= MAXINDEX) {	
					if(valid) {
						if(numIndex-1 == a && charIndex+2 == b) {
							return true;
							
						}
					}
							
					
						else {
							if(numIndex-1 == a && charIndex+2 == b) {
								return true;
							
							}
						}
					}
				
				
				if(numIndex-2 >= MININDEX && charIndex-1 >= MININDEX) {	
					if(valid) {
						if(numIndex-2 == a && charIndex-1 == b) {
							return true;
							
						}
					}
							
					
						else {
							if(numIndex-2 == a && charIndex-1 == b) {
								return true;
							
							}
						}
					}
				
				if(numIndex-2 >= MININDEX && charIndex+1 <= MAXINDEX) {	
					if(valid) {
						if(numIndex-2 == a && charIndex+1 == b) {
							return true;
							
						}
					}
							
					
						else {
							if(numIndex-2 == a && charIndex+1 == b) {
								return true;
							
							}
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
