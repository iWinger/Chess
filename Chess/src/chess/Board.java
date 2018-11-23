package chess;



/**
*The Board class is responsible for drawing the board
*and keeping the board updated depending on which
*spaces pieces are occupying and which spaces are empty and need 
*either "  " or "##" printed in them. 
*
* @author  Wingjun Chan
* @author  Jessi Medina
* Date: 10/31/2018
*/

public class Board {
	public static int row = 8;
	public static int col = 8;
	public static String BOARD[][] = new String[row][col];
	
	/* Initialize the board. */
	public Board() {
		for ( int i = 0; i < row; i++) {
			for ( int j = 0; j < col; j++) {
				BOARD[i][j] = "";
			}
		}
	BOARD[0][0] = "bR";
	BOARD[0][1] = "bN";
	BOARD[0][2] = "bB";
	BOARD[0][3] = "bQ";
	BOARD[0][4] = "bK";
	BOARD[0][5] = "bB";
	BOARD[0][6] = "bN";
	BOARD[0][7] = "bR";
	for(int i = 0; i < row; i++)
		BOARD[1][i] = "bp";
	
	BOARD[7][0] = "wR";
	BOARD[7][1] = "wN";
	BOARD[7][2] = "wB";
	BOARD[7][3] = "wQ";
	BOARD[7][4] = "wK";
	BOARD[7][5] = "wB";
	BOARD[7][6] = "wN";
	BOARD[7][7] = "wR";
	
	for(int i = 0; i < row; i++)
		BOARD[6][i] = "wp";
	
	
	}
	
	public boolean isValid(int index) {
		return false;
		
	}
	
	/**
	 * This method prints the initial board with no " " or "##" spaces. This will print out the column characters and row numbers.
	 */
	public void printBoard() {
		int NUM = 8;
		for ( int i = 0; i < BOARD.length; i++) {
			for ( int j = 0; j < BOARD[0].length; j++) {
				System.out.print(BOARD[i][j] + " ");
			}
			// Prints out the numbers.
			System.out.print(NUM);
			NUM--;
			System.out.println();
			
		}
		// Prints out the letters.
		char CHAR = 'a';
		System.out.print(" ");
		for(int i = 0; i < BOARD.length; i++)
			System.out.print((char)(CHAR+i) + "  ");
	}
	
	/**
	 * This method will scan the board and check if  piece is occupying each
	 *  spot. If a piece is not occupying a spot, the method decides
	 *   whether it should print " " or "##" in that spot depending on where it is in the board. 
	 */
	public void updateBlackNWhiteSpots() {
		int swap = 1;
		for ( int i = 0; i < row; i++) {
			for ( int j = 0; j < col; j++) {
				if(!BOARD[i][j].contains("w") && !BOARD[i][j].contains("b")) {
				// Even index starts off with white, otherwise odd index starts off with black.
				if((i+1) % 2 != 0 ) 
					swap = 1;
				else
					swap = 0;
					
					
					if( (j+swap) % 2 != 0) // Check if spot contains the white piece.						 
							BOARD[i][j] = "  ";
							
				// Starts off row with black square.
					else 	// Check if spot contains the black piece.
							BOARD[i][j] = "##"; 
					}
			}		
		}
	}
}
