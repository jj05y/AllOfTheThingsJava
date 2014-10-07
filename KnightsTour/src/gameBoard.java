import javax.swing.JOptionPane;

public class gameBoard {

	private int x = 0;
	private int y = 0;
	private int gameBoard[][] = new int[8][8];

	// public gameBoard() {
	// int gameBoard[][] = new int[8][8];
	// }

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setValue(int x, int y, int value) {
		gameBoard[x][y] = value;
	}

	public int getValue(int x, int y) {
		return gameBoard[x][y];
	}

	public void drawBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.printf("%2d ", gameBoard[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public void popUpOutput(int moves, long simulations) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (gameBoard[i][j] < 10) {
					sb.append(0);
				}
				sb.append(gameBoard[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}

		sb.append(String.format("\n%d Moves, %d simulations\n", moves - 1,
				simulations));

		JOptionPane.showMessageDialog(null, sb.toString());
	}

	public void popUpOutput() {

		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("Numbered Moves Board\n"));
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (gameBoard[i][j] < 10) {
					sb.append(0);
				}
				sb.append(gameBoard[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
	
	JOptionPane.showMessageDialog(null, sb.toString());
	
	}

	public void buildNumberedMoves() {

		int temp[][] = { { 2, 3, 4, 4, 4, 4, 3, 2 },
				{ 3, 4, 6, 6, 6, 6, 4, 3 }, { 4, 6, 8, 8, 8, 8, 6, 4 },
				{ 4, 6, 8, 8, 8, 8, 6, 4 }, { 4, 6, 8, 8, 8, 8, 6, 4 },
				{ 4, 6, 8, 8, 8, 8, 6, 4 }, { 3, 4, 6, 6, 6, 6, 4, 3 },
				{ 2, 3, 4, 4, 4, 4, 3, 2 } };
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				gameBoard[i][j] = temp[i][j];
			}
		}

	}
}
