package sliderclasses;

import java.awt.Color;

import javax.swing.JLabel;

public class Tile extends JLabel {

	private static int locations[][] = new int[3][3];
	private static int moves[][] = { { 0, 0 }, { +1, 0 }, { 0, +1 }, { -1, 0 }, { 0, -1 } };
	private Animator myAni;
	private int x, y, number;
	static boolean randomizing;

	Tile(int i) {

		x = i % 3;
		y = i / 3;
		number = i + 1;

		this.setSize(50, 50);
		this.setBackground(Color.WHITE);
		this.setLocation(20 + x * 50, 20 + y * 50);
		locations[y][x] = (number);
		this.setVisible(true);

		myAni = new Animator();

	}

	Tile() {
	}; // this is only going to be the winning tile

	public void go() {
		// System.out.println(this.getText() + " clicked");
		int move = where();
		if (move != 0) {
			if (!randomizing) {
				myAni.animate(this, moves[move][0], moves[move][1]);
			} else {
				this.setLocation(this.getX() + 50*moves[move][0], this.getY() + 50*moves[move][1]);
			}
			locations[y][x] = 0;
			x += moves[move][0];
			y += moves[move][1];
			locations[y][x] = number;
		}
		// printBoard();

	}

	private int where() {
		int move = 0;
		int tempx, tempy;
		for (int i = 0; i < moves.length; i++) {
			tempx = x;
			tempy = y;
			tempx += moves[i][0];
			tempy += moves[i][1];
			if (tempx >= 0 && tempx < 3 && tempy >= 0 && tempy < 3) {
				if (locations[tempy][tempx] == 0) {
					move = i;
					// System.out.println("0 was at " + tempy + "," + tempx);
				}
			}
		}

		return move;
	}

	static private void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(locations[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int getNum() {
		return number;
	}

	static public int[][] getLocations() {
		return locations;
	}

	public void setRandomizing(boolean b) {
		randomizing = b;
	}

}
