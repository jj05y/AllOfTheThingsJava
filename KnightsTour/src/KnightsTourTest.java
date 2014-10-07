/*
 * 
 * Knights Tour.
 * This is a program which attempts to solve a puzzle, "Can you move a knight (chess piece) from a randomly allocated start
 * position to every single square on a chess board, without landing on the same square twice?"
 * 
 *There are two implementations of the program, the first being brute force, and the second, using a smart algorithm. 
 *
 *Written by Joe Duffin.
 */




import javax.swing.JOptionPane;

public class KnightsTourTest {

	public static void main(String args[]) {

		gameBoard myGameBoard = new gameBoard();
		GameMoves myMoves = new GameMoves();
		int count = 1;
		long simulations = 0;
		ATimer myTimer = new ATimer();
		

		myMoves.setRandomStart(myGameBoard, count);
		count++;

		int userChoice = Integer
				.parseInt(JOptionPane
						.showInputDialog("Press 1 for brute force\nPress 2 for smart algorithm"));

		switch (userChoice) {

		case 1: //case one is random pig ignorance, keep trying till you get all the squares,
			JOptionPane.showMessageDialog(null, "This will take a while...\n");
			myGameBoard = new gameBoard();
			myTimer.startTimer();
			while (count != 65) {
				simulations++;
				if (myMoves.checkAllMoves(myGameBoard) == false) {
					count = 1;
					myGameBoard.reset();
					myMoves.setRandomStart(myGameBoard, count++);

					continue;
				}
				myMoves.randomMove(myGameBoard, count++);
				// myGameBoard.drawBoard();

			}
			myTimer.stopTimer();
			myGameBoard.drawBoard();

			//System.out.printf("\n%d Moves, %d simulations\n", count - 1,
			//		simulations);
			myGameBoard.popUpOutput(count, simulations, myTimer.getTime());
			

			break;

		case 2: //case 2, allocates weight to the easy squares to get to, eg, the centre, the algorithm gets the tough squares done as early as possible, eg, corners
			gameBoard numberedMoves = new gameBoard();
			numberedMoves.buildNumberedMoves();
			myGameBoard = new gameBoard();
			//numberedMoves.drawBoard(); //uncomment this if you wanna see the smart board placement allocations on cmd line,
			//numberedMoves.popUpOutput(); //uncomment this if you wanna see the smart board placement allocations in JOptionPane,
			
			myTimer.startTimer();
			
			while (count != 65) {
				simulations++;
				if (myMoves.checkAllMoves(myGameBoard) == false) {
					count = 1;
					myGameBoard.reset();
					myMoves.setRandomStart(myGameBoard, count++);

					continue; //start again!!!!
				}
				myMoves.makeCalcMove(myGameBoard, numberedMoves, count++);
				//myGameBoard.drawBoard(); //drawing every attempt seriously increases computation time.
			}

			myTimer.stopTimer();
			myGameBoard.popUpOutput(count, simulations, myTimer.getTime());
			//myGameBoard.drawBoard(); //unomment for cmd line output

			break;

		default:
			JOptionPane.showMessageDialog(null, "That's not an option");
		}

	}
}