package chess;
import java.util.ArrayList;
/**
 * The Black class creates all of the pieces
 * for the black side of the board and then adds them 
 * to an arraylist of Pieces
 * @author Wingjun Chan
 * @author Jessi Medina
 * Date: 10/31/2018
 */

import pieces.*;
public class Black {
	String black = "b"; // REMEMBER TO CONCATENATE 
	
	Pieces queen = new Queen();
	Pieces king = new King();
	Pieces rook1 = new Rook();
	Pieces rook2 = new Rook();
	Pieces bishop1 = new Bishop();
	Pieces bishop2 = new Bishop();
	Pieces knight1 = new Knight();
	Pieces knight2 = new Knight();
	Pieces pawn1 = new Pawn();
	Pieces pawn2 = new Pawn();
	Pieces pawn3 = new Pawn();
	Pieces pawn4 = new Pawn();
	Pieces pawn5 = new Pawn();
	Pieces pawn6 = new Pawn();
	Pieces pawn7 = new Pawn();
	Pieces pawn8 = new Pawn();
	
	/**
	 * This method adds all 16 pieces on the black side of
	 * the board to an ArrayList
	 * 
	 * @param list an empty arrayList for black pieces
	 */
	
public void addTo(ArrayList<Pieces> list) {
	list.add(queen);
	list.add(king);
	list.add(rook1);
	list.add(rook2);
	list.add(bishop1);
	list.add(bishop2);
	list.add(knight1);
	list.add(knight2);
	list.add(pawn1);
	list.add(pawn2);
	list.add(pawn3);
	list.add(pawn4);
	list.add(pawn5);
	list.add(pawn6);
	list.add(pawn7);
	list.add(pawn8);
}

/**
 * This method returns a string of "black" + the type of chess
 * piece that is given to the method.
 * 
 * @param piece the black chess piece to be output as a string
 * @return String this returns the type of piece (pawn, king, rook, etc.)
 * and appends it to a string that starts with "black"
 */

public String getString(Pieces piece) {
	return (black + piece.toString());
}

}