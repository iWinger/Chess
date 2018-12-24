# Chess

About Chess
------------
A two-player game written in Java that uses ASCII art to represent pieces. The objective of the game is to win by checkmating
the other opponent's king by making him run out of moves to play.

Pieces
-------
Pawn,Knight,Bishop,Rook,Queen,King

Moves
--------------
Castling: Allows you to swap places in the middle of the available spaces with the rook.
Enpassant: Captures a pawn immediately that moved two spaces.
Check: Endanger a king through piece movement.
Checkmate: When there's no more available moves for the other person's king, the game is over.

Illegal Move Detection
----------------------
If there are any moves outside the allotted moves permitted, there will be an error message.

How To Play
-------------
Using chess-language with rows and files, to move a piece would require movements such as:

e2 e4
f7 f6
  .
  .
  .
  etc
  .
  .
  .
Checkmate
White wins
