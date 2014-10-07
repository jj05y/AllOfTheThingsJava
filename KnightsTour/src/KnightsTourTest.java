import javax.swing.JOptionPane;

public class KnightsTourTest {

	public static void main(String args[]) {

		gameBoard myGameBoard = new gameBoard();
		GameMoves myMoves = new GameMoves();
		int count = 1;
		long simulations = 0;

		myMoves.setRandomStart(myGameBoard, count);
		count++;

		int userChoice = Integer
				.parseInt(JOptionPane
						.showInputDialog("Press 1 for brute force\nPress 2 for smart algorithm"));

		switch (userChoice) {

		case 1: //case one is random pig ignorance, keep trying till you get all the squares,
			JOptionPane.showMessageDialog(null, "This will take a while...\n");
			while (count != 65) {
				simulations++;
				if (myMoves.checkAllMoves(myGameBoard) == false) {
					count = 1;
					myGameBoard = new gameBoard();
					myMoves.setRandomStart(myGameBoard, count++);

					continue;
				}
				myMoves.randomMove(myGameBoard, count++);
				// myGameBoard.drawBoard();

			}

			myGameBoard.drawBoard();

			System.out.printf("\n%d Moves, %d simulations\n", count - 1,
					simulations);
			myGameBoard.popUpOutput(count, simulations);

			break;

		case 2: //case 2, allocates weight to the easy squares to get to, eg, the centre, the algorithm gets the tough squares done as early as possible, eg, corners
			gameBoard numberedMoves = new gameBoard();
			numberedMoves.buildNumberedMoves();
			//numberedMoves.drawBoard(); //uncomment this if you wanna see the smart board placement allocations,
			numberedMoves.popUpOutput(); //uncomment this if you wanna see the smart board placement allocations,

			while (count != 65) {
				simulations++;
				if (myMoves.checkAllMoves(myGameBoard) == false) {
					count = 1;
					myGameBoard = new gameBoard();
					myMoves.setRandomStart(myGameBoard, count++);

					continue;
				}
				myMoves.makeCalcMove(myGameBoard, numberedMoves, count++);
				//myGameBoard.drawBoard();
			}

			myGameBoard.popUpOutput(count, simulations);
			myGameBoard.drawBoard();

			break;

		default:
			JOptionPane.showMessageDialog(null, "That's not an option");
		}

	}
}