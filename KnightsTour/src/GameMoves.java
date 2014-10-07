import java.util.Random;

public class GameMoves {

	int horizontal[] = { 2, 1, -1, -2, -2, -1, 1, 2};
	int vertical[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	Random rand = new Random();

	public void setRandomStart(gameBoard myGameBoard, int count) {

		int x = rand.nextInt(8);
		int y = rand.nextInt(8);

		myGameBoard.setX(x);
		myGameBoard.setY(y);
		myGameBoard.setValue(x, y, count);
	}

	public int randomMove(gameBoard myGameBoard, int count) {

		int x = myGameBoard.getX();
		int y = myGameBoard.getY();

		int nextMove = rand.nextInt(8); // choose a move
		x += horizontal[nextMove]; // apply it
		y += vertical[nextMove];

		boolean check = checkForMove(myGameBoard, x, y);

		while (check == false) { // check if its out of bounds or already
									// occupied

			x -= horizontal[nextMove];
			y -= vertical[nextMove];

			nextMove = rand.nextInt(8);

			x += horizontal[nextMove];
			y += vertical[nextMove];
			check = checkForMove(myGameBoard, x, y);

		}

		myGameBoard.setValue(x, y, count); // apply the move
		myGameBoard.setX(x); // update game board position
		myGameBoard.setY(y);

		return 1;

	}

	private boolean checkForMove(gameBoard myGameBoard, int x, int y) {

		boolean check = false;

		if (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
			if (myGameBoard.getValue(x, y) == 0) {
				check = true;
			}
		}
		return check;
	}

	public boolean checkAllMoves(gameBoard myGameBoard) {

		boolean check = false;
		int x = myGameBoard.getX();
		int y = myGameBoard.getY();

		for (int i = 0; i <= 7; i++) {

			x += horizontal[i];
			y += vertical[i];

			if (x >= 0 && x <= 7 && y >= 0 && y <= 7) { // if x and y are within
				// bounds
				if (myGameBoard.getValue(x, y) == 0) { // see what value is at
														// that co ordinate
					check = true; // if there is at least one possible move, all
									// is well,
				}
			}

			x -= horizontal[i];
			y -= vertical[i];

		}
		return check;
	}

	public void makeCalcMove(gameBoard myGameBoard, gameBoard numberedMoves,
			int count) {

		int x = myGameBoard.getX();
		int y = myGameBoard.getY();

		boolean check = false;
		int possibleMoves[] = new int[8];
		int moveIndexToMake = 0;
		int numberedMovesValue;

		int best = 10;

		for (int i = 0; i <= 7; i++) {

			x += horizontal[i];
			y += vertical[i];

			check = checkForMove(myGameBoard, x, y);
			if (check == true) {
				
				numberedMovesValue = numberedMoves.getValue(x, y);
				if ( numberedMovesValue < best) { // see what
															// value is
															// at
															// that
															// coordinate
					best = numberedMovesValue; // this is then a
															// marker of lowest
															// possible move,
				}

			}
			x -= horizontal[i];
			y -= vertical[i];

		}

		for (int i = 0; i <= 7; i++) { // this loop adds markers to the possible
										// moves array of moves that share the
										// smame 'best value'

			x += horizontal[i];
			y += vertical[i];

			check = checkForMove(myGameBoard, x, y);
			if (check == true) {

				if (numberedMoves.getValue(x, y) == best) {
					possibleMoves[i] = 1;
				}
			}
			x -= horizontal[i];
			y -= vertical[i];
		}

		do {
			moveIndexToMake = rand.nextInt(8);
		} while (possibleMoves[moveIndexToMake] == 0);

		x += horizontal[moveIndexToMake];
		y += vertical[moveIndexToMake];

		myGameBoard.setX(x);
		myGameBoard.setY(y);
		myGameBoard.setValue(x, y, count);

	}
}
