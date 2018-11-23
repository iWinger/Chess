package chess;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import pieces.Pawn;
import pieces.Pieces;
//Document all Classes, fields, and methods

/**
* This chess program simulates a real game of chess
* with all basic and special moves available to the players.
*
* @author  Wingjun Chan
* @author  Jessi Medina
* Date: 10/31/2018
*/
public class Chess {

	// DRIVER CLASS
	/**
	 * The driver method of Chess.
	 * @param args
	 */
	public static void main(String[] args) {
			boolean illegal = false;
			boolean wkingcheck = false;
			boolean bkingcheck = false;
			int start = 0;
			int wnumtrack = 0;
			int wchartrack = 0;
			int wcountertrack = 0;
			boolean wvalid = false;
			int bnumtrack = 0;
			int bchartrack = 0;
			int bcountertrack = 0;
			boolean bvalid = false;
			
			
			char[] CHAR_ARR = new char[] {'a','b','c','d','e','f','g','h'};
			int[] NUM_ARR = new int[]{8,7,6,5,4,3,2,1};
			int charIndex = 0;
			int numIndex = 0;
			int src_charIndex = 0;
			int src_numIndex = 0;
			boolean drawOffer = false;
			String promPiece = null;
			int lastTurn_src_numIndex = 0;
			int lastTurn_numIndex = 0;
			int lastTurn_charIndex = 0;
			String lastTurn_pieceType = null;
			
			
			White whitePlayer = new White();
			ArrayList<Pieces> whitelist = new ArrayList<Pieces>();
			whitePlayer.addTo(whitelist);
			// System.out.println(whitePlayer.white + whitelist.get(6));
			
			Black blackPlayer = new Black();
			ArrayList<Pieces> blacklist = new ArrayList<Pieces>();
			blackPlayer.addTo(blacklist);
			 //System.out.println(blackPlayer.black + blacklist.get(6));
			
			
			Board chess = new Board();
			
			Scanner reader = new Scanner(System.in);
			int first = 0;
			while(true) {
				
			boolean valid = true;
			chess.updateBlackNWhiteSpots();
			
			if(!illegal) {
			if(first > 0)
			System.out.println();
			chess.printBoard();
			first++;
			}
			 // reset
			if(!illegal)
			System.out.println();
			String fullLine = "";
			String src = "";
			String dest = "";
			System.out.println();
			illegal = false;
			switch(start) {
			case 0: // white
				System.out.print("White's move: ");
				start++;
				valid = true;
				break;
			
			case 1: // black
				System.out.print("Black's move: ");
				start--;
				valid = false;
				break;
			}
			long startTime = System.currentTimeMillis();
			fullLine = reader.nextLine();
			
			if(fullLine.isEmpty()) {
				if(valid) {
				System.out.println();
				System.out.println("Illegal move, try again");
				illegal = true;
				//System.out.println();
				start--;
				continue;
				}
				else {
					System.out.println();
					System.out.println("Illegal move, try again");
					illegal = true;
			//		System.out.println();
					start++;
					continue;
				}
			}
			if(fullLine.contains("stop"))
				System.exit(0);
			
			if(valid && fullLine.equalsIgnoreCase("resign"))
			{
				System.out.println("Black wins");
				//System.out.println(fullLine.substring(6,11));
				System.exit(0);
			}
			else if((!valid) && fullLine.equalsIgnoreCase("resign"))
			{
				System.out.println("White wins");
				System.exit(0);
			}
			
			
			if(valid) {
				if(!drawOffer && fullLine.length() >= 11) {
					if(fullLine.substring(6,11).equals("draw?")) {
						drawOffer = true;
					}
				}
				else if(drawOffer) {
					if(fullLine.equals("draw")) {
						System.exit(0);
					}
					else {
						drawOffer = false;
					}
				}
			}
			else {
				if(!drawOffer && fullLine.length() >= 11) {
					if(fullLine.substring(6,11).equals("draw?")) {
						drawOffer = true;
					}
				}
				else if(drawOffer){
					if(fullLine.equals("draw")) {
						System.exit(0);
					}
					else {
						drawOffer = false;
					}
				}
			}

			
			
			StringTokenizer strtok = new StringTokenizer(fullLine);
			src = strtok.nextToken();
			if(!strtok.hasMoreTokens()) {
				if(valid) {
						System.out.println();
						System.out.println("Illegal move, try again");
						illegal = true;
				//		System.out.println();
						start--;
						continue;
					}
					
					else {
							System.out.println();
							System.out.println("Illegal move, try again");
							illegal = true;
					//		System.out.println();
							start++;
							continue;
						}
					}
				
			
				
			dest = strtok.nextToken();
		
			
			
			if(strtok.hasMoreTokens()) {
				promPiece = strtok.nextToken();
			}
			else {
				promPiece = null;
			}
			
			//System.out.println(promPiece);
			
			if(valid) {
				if((promPiece!=null) && (!promPiece.equals("draw?"))){
					if((!promPiece.equalsIgnoreCase("r")) && (!promPiece.equalsIgnoreCase("n")) && (!promPiece.equalsIgnoreCase("b")) && (!promPiece.equalsIgnoreCase("q"))){
						promPiece=null;
						System.out.println();
						System.out.println("Illegal move, try again.");
						System.out.println();
						start--; // white
						continue;
					}
				}
			}
			else if(!valid) {
				if((promPiece!=null) && (!promPiece.equals("draw?"))){
					if((!promPiece.equalsIgnoreCase("r")) && (!promPiece.equalsIgnoreCase("n")) && (!promPiece.equalsIgnoreCase("b")) && (!promPiece.equalsIgnoreCase("q"))){
						promPiece=null;
						System.out.println();
						System.out.println("Illegal move, try again.");
						System.out.println();
						start++; // black
						continue;
					}
				}
			}
			
			
	
			
			
			if(valid) {
				if(dest.charAt(0) < 97 || dest.charAt(1) > 104){
					System.out.println();
					System.out.println("Illegal move, try again");
					illegal = true;
					//System.out.println();
					start--; // white
					continue;
				}
				
				else if(src.charAt(0) < 97 || src.charAt(1) > 104){
					System.out.println();
					System.out.println("Illegal move, try again");
					illegal = true;
					//System.out.println();
					start--; // white
					continue;
				}
			}
			else {
				if(dest.charAt(0) < 97 || dest.charAt(1) > 104){
					System.out.println();
					System.out.println("Illegal move, try again");
					illegal = true;
					//System.out.println();
					start++; // black
					continue;
				}
				
				else if(src.charAt(0) < 97 || src.charAt(1) > 104){
					System.out.println();
					System.out.println("Illegal move, try again");
					illegal = true;
					//System.out.println();
					start++; // black
					continue;
				}
				
			}
			
			
			
			
			
			// FIND THE PIECE
			for ( int i = 0; i < CHAR_ARR.length; i++) {
				if(dest.charAt(0) == CHAR_ARR[i]) 
					charIndex = i;		
					
				
				
				if(src.charAt(0) == CHAR_ARR[i]) 
					src_charIndex = i;	
					
			}
	if(valid) {
		if(Character.getNumericValue(dest.charAt(1)) < 1 || Character.getNumericValue(dest.charAt(1)) > 8){
			System.out.println();
			System.out.println("Illegal move, try again");
			illegal = true;
			//System.out.println();
			start--; // white
			continue;
		}
		
		else if(Character.getNumericValue(src.charAt(1)) < 1 || Character.getNumericValue(src.charAt(1)) > 8){
			System.out.println();
			System.out.println("Illegal move, try again");
			illegal = true;
			//System.out.println();
			start--; // white
			continue;
		}
	}
	else {
		if(Character.getNumericValue(dest.charAt(1)) < 1 || Character.getNumericValue(dest.charAt(1)) > 8){
			System.out.println();
			System.out.println("Illegal move, try again");
			illegal = true;
			//System.out.println();
			start++; // black
			continue;
		}
		
		else if(Character.getNumericValue(src.charAt(1)) < 1 || Character.getNumericValue(src.charAt(1)) > 8){
			System.out.println();
			System.out.println("Illegal move, try again");
			illegal = true;
			//System.out.println();
			start++; // black
			continue;
		}
		
	}
	
			
			for (int j = 0; j < NUM_ARR.length; j++) {
				if(Character.getNumericValue(dest.charAt(1)) == NUM_ARR[j]) 
					numIndex = j;
				
						
				if(Character.getNumericValue(src.charAt(1)) == NUM_ARR[j]) 
					src_numIndex = j;				
					
			}
			
			
			
			if(valid){ 
				if((src_numIndex == numIndex) && (src_charIndex == charIndex)) {
					System.out.println();
					System.out.println("Illegal move, try again");
					illegal = true;
				//	System.out.println();
					start--;
					continue;
				}
				else if(chess.BOARD[src_numIndex][src_charIndex].contains("b")) {// can't eat your own piece
					System.out.println();
					System.out.println("Illegal move, try again");
					illegal = true;
					//System.out.println();
					start--;
					continue;
				}
			}
			else {
				if((src_numIndex == numIndex) && (src_charIndex == charIndex)) {
					System.out.println();
					System.out.println("Illegal move, try again");
					illegal = true;
					//System.out.println();
					start++;
					continue;
				}
				else if(chess.BOARD[src_numIndex][src_charIndex].contains("w")) {
					System.out.println();
					System.out.println("Illegal move, try again");
					illegal = true;
					//System.out.println();
					start++;
					continue;
				}
				
			}
			
			
			
		if(valid){ // CAN'T EAT YOUR OWN PIECE		
			if(chess.BOARD[numIndex][charIndex].contains("w")) {
				System.out.println();
				System.out.println("Illegal move, try again");
				illegal = true;
				//System.out.println();
				start--; // make it white's turn
				continue;
			}
		}
		else {
			if(chess.BOARD[numIndex][charIndex].contains("b")) {
				System.out.println();
				System.out.println("Illegal move, try again");
				illegal = true;
				//System.out.println();
				start++; // make it black's turn
				continue;
			}
		}
		
		if(valid && (promPiece!=null)) {
			if(promPiece.equalsIgnoreCase("k")) {
				System.out.println();
				System.out.println("Illegal move, try again");
				illegal = true;
				//System.out.println();
				start--; // make it white's turn
				continue;
			}
		}		
		else if(!valid && (promPiece!=null)) {
			if(promPiece.equalsIgnoreCase("k")) {
				System.out.println();
				System.out.println("Illegal move, try again");
				illegal = true;
				//System.out.println();
				start++; // make it black's turn
				continue;
			}
		}
		
		if(chess.BOARD[src_numIndex][src_charIndex].equals("  ") || chess.BOARD[src_numIndex][src_charIndex].equals("##")) {
		if(valid) {
			System.out.println();
			System.out.println("Illegal move, try again");
			illegal = true;
			//System.out.println();
			start--; // make it black's turn
			continue;
			
		}
		else {
			System.out.println();
			System.out.println("Illegal move, try again");
			//illegal = true;
			System.out.println();
			start++; // make it black's turn
			continue;
			
		}
		
		}
		if(valid) { // white
		for( int i = 0; i < whitelist.size(); i++) {
			boolean canmove = whitelist.get(i).canMove(src_numIndex,src_charIndex,numIndex,charIndex,chess.BOARD,valid);
			if(chess.BOARD[src_numIndex][src_charIndex].equals("w" + whitelist.get(i))) {
				if(wkingcheck == true) {
					//if(!chess.BOARD[src_numIndex][src_charIndex].equals("wK")) {
					
					if(canmove)
						whitelist.get(i).move(src_numIndex,src_charIndex,numIndex,charIndex, chess.BOARD);
						
					if(numIndex == bnumtrack && charIndex == bchartrack) // captured white piece
						break;
					
					
						if(blacklist.get(bcountertrack).check(src_numIndex, src_charIndex, bnumtrack, bchartrack, chess.BOARD,bvalid)) {
						whitelist.get(i).move(numIndex,charIndex,src_numIndex,src_charIndex, chess.BOARD);
						System.out.println();
						System.out.println("Illegal move, try again");
						
						illegal = true;
						start--;
						
						//}
					}
						else
							wkingcheck = false;
						
						break;
				}
				
				
				if(canmove && whitelist.get(i).canPromote(src_numIndex,src_charIndex,numIndex,charIndex, promPiece, chess.BOARD,valid)) {
							//System.out.println("success");
							((Pawn) whitelist.get(i)).promote(src_numIndex,src_charIndex,numIndex,charIndex, promPiece, chess.BOARD,valid);
							lastTurn_src_numIndex = src_numIndex;
							lastTurn_numIndex = numIndex;
							lastTurn_charIndex = charIndex;
							lastTurn_pieceType = whitelist.get(i).toString();
							
							
							break;
				}
				else if(lastTurn_numIndex!=0 && whitelist.get(i).canEnPassant(src_numIndex,src_charIndex,numIndex,charIndex,lastTurn_src_numIndex, lastTurn_numIndex, lastTurn_charIndex, lastTurn_pieceType, chess.BOARD, valid)) {
					((Pawn)whitelist.get(i)).enPassant(src_numIndex,src_charIndex,numIndex,charIndex,lastTurn_src_numIndex, lastTurn_numIndex,lastTurn_charIndex, lastTurn_pieceType, chess.BOARD, valid);
					break;
				}
				else if(canmove) {
					
					if(!chess.BOARD[numIndex][charIndex].equals("wK")){
					whitelist.get(i).move(src_numIndex,src_charIndex,numIndex,charIndex, chess.BOARD);
					lastTurn_src_numIndex = src_numIndex;
					lastTurn_numIndex = numIndex;
					lastTurn_charIndex = charIndex;
					lastTurn_pieceType = whitelist.get(i).toString();
					
					if(checkmate(src_numIndex,src_charIndex,numIndex,charIndex, chess.BOARD,valid,whitelist,blacklist)) {
						System.out.println("Checkmate");
						System.out.println("White wins");
						chess.updateBlackNWhiteSpots();
						chess.printBoard();
						System.exit(0);
					}

					
					}
					else {
						System.out.println();
						System.out.println("Illegal move, try again");
						illegal = true;
					//	System.out.println();
						start--;
						continue;
					}
					
				
					if(whitelist.get(i).check(src_numIndex, src_charIndex, numIndex, charIndex, chess.BOARD,valid)) {
					bkingcheck = true;
						wnumtrack = numIndex;
						wchartrack = charIndex;
						wcountertrack = i;
						wvalid = valid;
						System.out.println();
						System.out.println("Check");
						
					}
				
				break;
				}
				else {
					System.out.println();
					System.out.println("Illegal move, try again.");
					illegal = true;
				//	System.out.println();
					start--;
					break;
				}
			}
		}
	}
		else { // black
		for( int j = 0; j < blacklist.size(); j++){
			if(chess.BOARD[src_numIndex][src_charIndex].equals("b" + blacklist.get(j))) {
				boolean canmove2 = blacklist.get(j).canMove(src_numIndex,src_charIndex,numIndex,charIndex, chess.BOARD,valid);
				if(bkingcheck == true) {
					//System.out.println(chess.BOARD[src_numIndex][src_charIndex]);
					//if(!chess.BOARD[src_numIndex][src_charIndex].equals("bK")) {
						//System.out.println(wcountertrack + " " + wnumtrack + " " + wchartrack);
					if(canmove2)						
					blacklist.get(j).move(src_numIndex,src_charIndex,numIndex,charIndex, chess.BOARD);
					
					if(numIndex == wnumtrack && charIndex == wchartrack) // captured white piece
						break;
					
					if(whitelist.get(wcountertrack).check(src_numIndex, src_charIndex, wnumtrack, wchartrack, chess.BOARD,wvalid)){
						System.out.println();
						whitelist.get(j).move(numIndex,charIndex,src_numIndex,src_charIndex, chess.BOARD);
						System.out.println("Illegal move, try again");
						illegal = true;
						start++;
					
						//}
					}
					else
						bkingcheck = false;
					break;
						
				}
				
				
				
				
				if(canmove2 && blacklist.get(j).canPromote(src_numIndex,src_charIndex,numIndex,charIndex, promPiece, chess.BOARD,valid)) {
							//System.out.println("success");
							((Pawn) blacklist.get(j)).promote(src_numIndex,src_charIndex,numIndex,charIndex, promPiece, chess.BOARD,valid);
							lastTurn_src_numIndex = src_numIndex;
							lastTurn_numIndex = numIndex;
							lastTurn_charIndex = charIndex;
							lastTurn_pieceType = blacklist.get(j).toString();
							
							
							break;
					}
				else if(lastTurn_numIndex!=0 && blacklist.get(j).canEnPassant(src_numIndex,src_charIndex,numIndex,charIndex,lastTurn_src_numIndex, lastTurn_numIndex, lastTurn_charIndex, lastTurn_pieceType, chess.BOARD, valid)) {
					((Pawn)blacklist.get(j)).enPassant(src_numIndex,src_charIndex,numIndex,charIndex,lastTurn_src_numIndex, lastTurn_numIndex,lastTurn_charIndex, lastTurn_pieceType, chess.BOARD, valid);
					break;
				}
				else if(canmove2) {
					if(!chess.BOARD[numIndex][charIndex].equals("wK")){
						whitelist.get(j).move(src_numIndex,src_charIndex,numIndex,charIndex, chess.BOARD);
						lastTurn_src_numIndex = src_numIndex;
						lastTurn_numIndex = numIndex;
						lastTurn_charIndex = charIndex;
						lastTurn_pieceType = blacklist.get(j).toString();
					
						
						if(checkmate(src_numIndex,src_charIndex,numIndex,charIndex, chess.BOARD,valid,whitelist,blacklist)) {
							
							System.out.println();
							System.out.println("Checkmate");
							System.out.println("Black wins");
							chess.updateBlackNWhiteSpots();
							chess.printBoard();
							System.exit(0);
						
						}
						
						}
						else {
							System.out.println();
							System.out.println("Illegal move, try again");
							illegal = true;
						//	System.out.println();
							start++;
							continue;
						}
					
				if(blacklist.get(j).check(src_numIndex, src_charIndex, numIndex, charIndex, chess.BOARD,valid)) {
					wkingcheck = true;
					bnumtrack = numIndex;
					bchartrack = charIndex;
					bcountertrack = j;
					bvalid = valid;
					System.out.println();
					System.out.println("Check");
					
				}
				break;
				}
				else {
					System.out.println();
					System.out.println("Illegal move, try again.");
					illegal = true;
					//System.out.println();
					start++;
					break;
				}
			}
		}
	}
			//System.out.println(chess.BOARD[src_numIndex][src_charIndex]);
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime/1000);
		
			}
			
		}
		
		
		private static boolean checkmate(int src_numIndex, int src_charIndex,int numIndex, int charIndex, String[][] board, boolean valid,ArrayList<Pieces> whitelist, ArrayList<Pieces>blacklist) {
			int wRow = 0;
			int wCol = 0;
			int bRow = 0;
			int bCol = 0;
			int MININDEX = 0;
			int MAXINDEX = 7;
			// get coordinates of kings.
			for(int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[0].length; j++) {
					if(board[i][j].equals("wK")) {
						wRow = i;
						wCol = j;
					}
					else if(board[i][j].equals("bK")) {
						bRow = i;
						bCol = j;
					}
				}
			}
			
			boolean wKing1 = false,wKing2 = false,wKing3 = false,wKing4 = false,wKing5 = false,wKing6 = false,wKing7= false,wKing8 = false ,wKing9 = false;
			boolean bKing1 = false,bKing2 = false,bKing3 = false ,bKing4 = false,bKing5 = false,bKing6 = false,bKing7 = false ,bKing8 = false,bKing9 = false;
			/* INSTANTIATE */
			int w = 0;
			
			
			if(wRow-1 >= MININDEX && wCol-1 >= MININDEX) {
				for ( int i = 0; i < board.length; i++) {
					for( int j = 0; j < board[0].length; j++) {
						for(int z = 0; z < blacklist.size(); z++) {
					if(board[i][j].equals("b" + blacklist.get(z)))
					if(blacklist.get(z).precheckmate(i, j, board, valid, wRow-1, wCol-1)) {
						w++;
						wKing1 = true;
						break;
					}
					}
					}
					}
				
			if(board[wRow-1][wCol-1].contains("w"))
				wKing1 = true;
			}
			else
				wKing1 = true;
			
			if(wRow-1 >= MININDEX) {
				for ( int i = 0; i < board.length; i++) {
					for( int j = 0; j < board[0].length; j++) {
						for(int z = 0; z < blacklist.size(); z++) {
					if(board[i][j].equals("b" + blacklist.get(z)))
					if(blacklist.get(z).precheckmate(i, j, board, valid, wRow-1, wCol)) {
						w++;
						wKing2 = true;
						break;
					}
					}
					}
					}
			if(board[wRow-1][wCol].contains("w"))
				wKing2 = true;
			}
			else
				wKing2 = true;
			
			if(wRow-1 >= MININDEX && wCol+1 <= MAXINDEX) {
				for ( int i = 0; i < board.length; i++) {
					for( int j = 0; j < board[0].length; j++) {
						for(int z = 0; z < blacklist.size(); z++) {
					if(board[i][j].equals("b" + blacklist.get(z)))
					if(blacklist.get(z).precheckmate(i, j, board, valid, wRow-1, wCol+1)) {
						w++;
						wKing3 = true;
						break;
					}
					}
					}
					}
			if(board[wRow-1][wCol+1].contains("w"))
				wKing3 = true;
			}
			else
				wKing3 = true;
			
			if(wCol-1 >= MININDEX) {
				for ( int i = 0; i < board.length; i++) {
					for( int j = 0; j < board[0].length; j++) {
						for(int z = 0; z < blacklist.size(); z++) {
					if(board[i][j].equals("b" + blacklist.get(z)))
					if(blacklist.get(z).precheckmate(i, j, board, valid, wRow, wCol-1)) {
						w++;
						wKing4 = true;
						break;
					}
					}
					}
					}
			if(board[wRow][wCol-1].contains("w"))
				wKing4 = true;
			}
			else
				wKing4 = true;
			
			
				for ( int i = 0; i < board.length; i++) {
					for( int j = 0; j < board[0].length; j++) {
						for(int z = 0; z < blacklist.size(); z++) {
					if(board[i][j].equals("b" + blacklist.get(z)))
					if(blacklist.get(z).precheckmate(i, j, board, valid, wRow, wCol)) {
						w++;
						wKing5 = true;
						break;
					}
					}
					}
					}
				
				
			
			
			if(wCol+1 <= MAXINDEX) {
		
				for ( int i = 0; i < board.length; i++) {
					for( int j = 0; j < board[0].length; j++) {
						for(int z = 0; z < blacklist.size(); z++) {
					if(board[i][j].equals("b" + blacklist.get(z)))
					if(blacklist.get(z).precheckmate(i, j, board, valid, wRow, wCol+1)) {
						w++;
						wKing6 = true;
						break;
					}
					}	
					}
					}
			if(board[wRow][wCol+1].contains("w"))
				wKing6 = true;
			}
			else
				wKing6 = true;
			
			if(wRow+1 <= MAXINDEX && wCol-1 >= MININDEX) {
				for ( int i = 0; i < board.length; i++) {
					for( int j = 0; j < board[0].length; j++) {
						for(int z = 0; z < blacklist.size(); z++) {
					if(board[i][j].equals("b" + blacklist.get(z)))
					if(blacklist.get(z).precheckmate(i, j, board, valid, wRow+1, wCol-1)) {
						//System.out.println("horsey");
						w++;
						wKing7 = true;
						break;
					}
					}
					}
					}
			if(board[wRow+1][wCol-1].contains("w"))
				wKing7 = true;
			}
			else
				wKing7 = true;
			
			if(wRow+1 <= MAXINDEX) {
				for ( int i = 0; i < board.length; i++) {
					for( int j = 0; j < board[0].length; j++) {
						for(int z = 0; z < blacklist.size(); z++) {
					if(board[i][j].equals("b" + blacklist.get(z)))
					if(blacklist.get(z).precheckmate(i, j, board, valid, wRow+1, wCol+1)) {
						w++;
						wKing8 = true;
						break;
					}
					}
					}
					}
			if(board[wRow+1][wCol].contains("w"))
				wKing8 = true;
			}
			else
				wKing8 = true;
			
			if(wRow+1 <= MAXINDEX && wCol+1 <= MAXINDEX) {
				for ( int i = 0; i < board.length; i++) {
					for( int j = 0; j < board[0].length; j++) {
						for(int z = 0; z < blacklist.size(); z++) {
					if(board[i][j].equals("b" + blacklist.get(z)))
					if(blacklist.get(z).precheckmate(i, j, board, valid, wRow+1, wCol+1)) {
						w++;
						wKing9 = true;
						break;
					}
					}
					}
					}
			if(board[wRow+1][wCol+1].contains("w"))
				wKing9 = true;
			}
			else
				wKing9 = true;
			
			/* ----------------------------------------------------------------*/
			int b = 0; 
			 
			if(bRow-1 >= MININDEX && bCol-1 >= MININDEX) {

				for ( int i = 0; i < board.length; i++) {
					for( int j = 0; j < board[0].length; j++) {
						for(int z = 0; z < whitelist.size(); z++) {
					if(board[i][j].equals("w" + whitelist.get(z)))
					if(whitelist.get(z).precheckmate(i, j, board, valid, bRow-1, bCol-1)) {
						b++;
						bKing1 = true;
						break;
					}
					}
					}
					}
				
				if(board[bRow-1][bCol-1].contains("b"))
					bKing1 = true;
				}
				else
					bKing1 = true;
				
				if(bRow-1 >= MININDEX) {

					for ( int i = 0; i < board.length; i++) {
						for( int j = 0; j < board[0].length; j++) {
							for(int z = 0; z < whitelist.size(); z++) {
						if(board[i][j].equals("w" + whitelist.get(z)))
						if(whitelist.get(z).precheckmate(i, j,  board, valid, bRow-1, bCol)) {
							b++;
							bKing2 = true;
							break;
						}
						}
						}
						}
				if(board[bRow-1][bCol].contains("b"))
					bKing2 = true;
				}
				else
					bKing2 = true;
				
				if(bRow-1 >= MININDEX && bCol+1 <= MAXINDEX) {

					for ( int i = 0; i < board.length; i++) {
						for( int j = 0; j < board[0].length; j++) {
							for(int z = 0; z < whitelist.size(); z++) {
						if(board[i][j].equals("w" + whitelist.get(z)))
						if(whitelist.get(z).precheckmate(i, j, board, valid, bRow-1, bCol+1)) {
							b++;
							bKing3 = true;
							break;
						}
						}
						}
						}
				if(board[bRow-1][bCol+1].contains("b"))
					bKing3 = true;
				}
				else
					bKing3 = true;
				
				if(bCol-1 >= MININDEX) {
					
					for ( int i = 0; i < board.length; i++) {
						for( int j = 0; j < board[0].length; j++) {
							for(int z = 0; z < whitelist.size(); z++) {
						if(board[i][j].equals("w" + whitelist.get(z)))
						if(whitelist.get(z).precheckmate(i,j,  board, valid, bRow, bCol-1)) {
							b++;
							bKing4 = true;
							break;
						}
						}
						}
						}
				if(board[bRow][bCol-1].contains("b"))
					b++;
					bKing4 = true;
				}
				else
					bKing4 = true;
				
				

					for ( int i = 0; i < board.length; i++) {
						for( int j = 0; j < board[0].length; j++) {
							for(int z = 0; z < whitelist.size(); z++) {
						if(board[i][j].equals("w" + whitelist.get(z)))
						if(whitelist.get(z).precheckmate(i, j,  board, valid, bRow, bCol)) {
							b++;
							bKing5 = true;
							break;
						}
						}
						}
						}
					
				
				
				if(bCol+1 <= MAXINDEX) {
					for ( int i = 0; i < board.length; i++) {
						for( int j = 0; j < board[0].length; j++) {
							for(int z = 0; z < whitelist.size(); z++) {
						if(board[i][j].equals("w" + whitelist.get(z)))
						if(whitelist.get(z).precheckmate(i, j,  board, valid, bRow, bCol+1)) {
							b++;
							bKing6 = true;
							break;
						}
						}
						}
						}
				if(board[bRow][bCol+1].contains("b"))
					bKing6 = true;
				}
				else
					bKing6 = true;
				
				if(bRow+1 <= MAXINDEX && bCol-1 >= MININDEX) {

					for ( int i = 0; i < board.length; i++) {
						for( int j = 0; j < board[0].length; j++) {
							for(int z = 0; z < whitelist.size(); z++) {
						if(board[i][j].equals("w" + whitelist.get(z))) 
							if(whitelist.get(z).precheckmate(i, j, board, valid, bRow+1, bCol-1)) {
							b++;
							bKing7 = true;
							break;
						}
						}
						}
						}
				if(board[bRow+1][bCol-1].contains("b"))
					bKing7 = true;
				}
				else
					bKing7 = true;
				
				if(bRow+1 <= MAXINDEX) {

					for ( int i = 0; i < board.length; i++) {
						for( int j = 0; j < board[0].length; j++) {
							for(int z = 0; z < whitelist.size(); z++) {
						if(board[i][j].equals("w" + whitelist.get(z)))
						if(whitelist.get(z).precheckmate(i, j, board, valid, bRow+1, bCol)) {
							b++;
							bKing8 = true;
							break;
						}
						}
						}
						}
				if(board[bRow+1][bCol].contains("b"))
					bKing8 = true;
				}
				else
					bKing8 = true;
				
				if(bRow+1 <= MAXINDEX && bCol+1 <= MAXINDEX) {

					for ( int i = 0; i < board.length; i++) {
						for( int j = 0; j < board[0].length; j++) {
							for(int z = 0; z < whitelist.size(); z++) {
						if(board[i][j].equals("w" + whitelist.get(z)))
						if(whitelist.get(z).precheckmate(i, j, board, valid, bRow+1, bCol+1)) {
							b++;
							bKing9 = true;
							break;
						}
						}
						}
						}
				if(board[bRow+1][bCol+1].contains("b"))
					bKing9 = true;
				}
				else
					bKing9 = true;
			
			/*------------------------------------------------------------------*/
				
			if(valid) {
			/*	System.out.println("BLACK BOARD");
				System.out.println(bKing1);
				System.out.println(bKing2);
				System.out.println(bKing3);
				System.out.println(bKing4);
				System.out.println(bKing5);
				System.out.println(bKing6);
				System.out.println(bKing7);
				System.out.println(bKing8);
				System.out.println(bKing9);
				*/
				if(bKing1 && bKing2 && bKing3 && bKing4 && bKing5 && bKing6 && bKing7 && bKing8 && bKing9)
					return true; // white wins
			}
			else {
			/*	System.out.println("WHITE BOARD");
				System.out.println(wKing1);
				System.out.println(wKing2);
				System.out.println(wKing3);
				System.out.println(wKing4);
				System.out.println(wKing5);
				System.out.println(wKing6);
				System.out.println(wKing7);
				System.out.println(wKing8);
				System.out.println(wKing9);
				*/
				if(wKing1 && wKing2 && wKing3 && wKing4 && wKing5 && wKing6 && wKing7 && wKing8 && wKing9)
					return true; // black wins
			}
			
			return false;
			
		
			
		}
}
