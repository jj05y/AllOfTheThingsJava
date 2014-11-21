package ducksweep;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DuckSweep extends JFrame {

	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	// Fields
	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	// Mouse Listener
	private AMouseListener mouseList = new AMouseListener(this);

	// Flag Counter
	private FlagCounter myFlagCounter = new FlagCounter();

	// Arrays of things and the odd button
	private JButton[][] buttons = new JButton[10][10];
	private ImageIcon[] pics = new ImageIcon[16];
	private JLabel[][] picArray = new JLabel[10][10];
	private boolean[][] beenToo = new boolean[picArray.length][picArray[0].length];
	private int[] movesX = { 0, -1, 0, +1, +1, +1, 0, -1, -1 };
	private int[] movesY = { 0, +1, +1, +1, 0, -1, -1, -1, 0 };
	private JButton resetButton;
	private JButton exitButton;
	private JLabel flagCounter;
	private JLabel backGround;
	private JLabel face;

	// The random object
	private Random rand;

	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	// Constructor!
	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	public DuckSweep() {

		super("Duck Sweeper");

		rand = new Random();

		loadPics();
		drawButtons(); // and a label
		makePicArray();
		drawPics();

		add(backGround);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 400);
		this.setLocationRelativeTo(null);
		setVisible(true);

	}

	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	// BUTTONS!
	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	private void drawButtons() {

		backGround = new JLabel();
		backGround.setLocation(0, 0);
		backGround.setSize(350, 400);
		backGround.setIcon(pics[12]);

		int x = 50, y = 50;
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[0].length; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setSize(25, 25);
				buttons[i][j].setLocation(x + 25 * i, y + 25 * j);
				buttons[i][j].addMouseListener(mouseList);
				backGround.add(buttons[i][j]);

			}
		}
		// sort out reset
		resetButton = new JButton("Reset");
		resetButton.setSize(100, 30);
		resetButton.setLocation(50, 325);
		resetButton.addMouseListener(mouseList);
		backGround.add(resetButton);

		exitButton = new JButton("Exit");
		exitButton.setSize(100, 30);
		exitButton.setLocation(200, 325);
		exitButton.addMouseListener(mouseList);
		backGround.add(exitButton);

		// yeah, its not a button, but meh,
		flagCounter = new JLabel("Number of Flags is: 0");
		flagCounter.setHorizontalAlignment(SwingConstants.CENTER);
		flagCounter.setLocation(50, 10);
		flagCounter.setSize(250, 30);
		backGround.add(flagCounter);

		face = new JLabel();
		face.setIcon(pics[14]);
		face.setLocation(150, 310);
		face.setSize(50, 50);
		backGround.add(face);

	}

	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	// Pic Managment
	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	private void loadPics() {
		pics[0] = null;
		pics[1] = new ImageIcon(getClass().getResource("/1.png"));
		pics[2] = new ImageIcon(getClass().getResource("/2.png"));
		pics[3] = new ImageIcon(getClass().getResource("/3.png"));
		pics[4] = new ImageIcon(getClass().getResource("/4.png"));
		pics[5] = new ImageIcon(getClass().getResource("/5.png"));
		pics[6] = new ImageIcon(getClass().getResource("/6.png"));
		pics[7] = new ImageIcon(getClass().getResource("/7.png"));
		pics[8] = new ImageIcon(getClass().getResource("/8.png"));
		pics[9] = new ImageIcon(getClass().getResource("/duck.png"));
		pics[10] = new ImageIcon(getClass().getResource("/flag.png"));
		pics[11] = new ImageIcon(getClass().getResource("/duck2.gif"));
		pics[12] = new ImageIcon(getClass().getResource("/bg.jpg"));
		pics[13] = new ImageIcon(getClass().getResource("/loose.png"));
		pics[14] = new ImageIcon(getClass().getResource("/meh.png"));
		pics[15] = new ImageIcon(getClass().getResource("/win.gif"));
	}

	public void makePicArray() {
		int x = 50, y = 50;
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[0].length; j++) {
				picArray[i][j] = new JLabel();
				picArray[i][j].setSize(25, 25);
				picArray[i][j].setLocation(x + 25 * i, y + 25 * j);
				backGround.add(picArray[i][j]);
			}
		}
	}

	private void drawPics() {
		int[] neighbours;
		randomizeDucks();
		int numDucks = 0;
		for (int i = 0; i < picArray.length; i++) {
			for (int j = 0; j < picArray[0].length; j++) {
				if (picArray[i][j].getIcon() != pics[9]) {
					neighbours = getNeighbours(i, j);
					numDucks = 0;
					for (int k = 0; k < neighbours.length; k++) {
						if (picArray[i + movesY[neighbours[k]]][j + movesX[neighbours[k]]].getIcon() == pics[9]) {
							numDucks++;
						}
					}
					// System.out.println(numDucks);
					picArray[i][j].setIcon(pics[numDucks]);
				}
			}
		}
	}

	public void clearBlanks(int i, int j) {
		//System.out.println("i = " + i + " j = " + j);
		int[] neighbours = getNeighbours(i, j);
		beenToo[i][j] = true;

		for (int k = 0; k < neighbours.length; k++) {
			if (neighbours[k] != 0) {
				if (picArray[i + movesY[neighbours[k]]][j + movesX[neighbours[k]]].getIcon() != pics[9]
						&& buttons[i + movesY[neighbours[k]]][j + movesX[neighbours[k]]].getIcon() == null) {
					buttons[i + movesY[neighbours[k]]][j + movesX[neighbours[k]]].setVisible(false);
				}
			}
		}

		for (int k = 0; k < neighbours.length; k++) {
			if (picArray[i + movesY[neighbours[k]]][j + movesX[neighbours[k]]].getIcon() == pics[0] && neighbours[k] != 0) {
				if (beenToo[i + movesY[neighbours[k]]][j + movesX[neighbours[k]]] == true) {
					continue;
				}

				clearBlanks(i + movesY[neighbours[k]], j + movesX[neighbours[k]]);

			}
		}
	}

	private int[] getNeighbours(int i, int j) {
		int[] neighbours = new int[movesX.length];

		for (int k = 0; k < movesX.length; k++) {
			if (i + movesY[k] >= 0 && i + movesY[k] <= 9 && j + movesX[k] >= 0 && j + movesX[k] <= 9) {
				neighbours[k] = k;
			} else {
				neighbours[k] = 0;
			}
		}
		// for (int l = 0; l < neighbours.length; l++) {
		// System.out.print(neighbours[l]);
		// }
		// System.out.println();

		return neighbours;
	}

	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	// Button Clickers and Reset and Exit
	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	public void leftButtonClicked(Object b) {

		JButton button = (JButton) b;

		if (button == resetButton) {
			reset();
		} else if (button == exitButton) {
			System.exit(0);
		} else {
			if (face.getIcon() == pics[14] && button.getIcon() != pics[10]) {
				int i = (button.getX() - 50) / 25;
				int j = (button.getY() - 50) / 25;
				button.setVisible(false);


				if (haveIWon()) {
					showDucks();
					face.setIcon(pics[15]);
					// JOptionPane.showMessageDialog(null, "You win :)");
					// reset();
				}

				if (picArray[i][j].getIcon() == pics[9]) {
					picArray[i][j].setIcon(pics[11]);
					showDucks();
					face.setIcon(pics[13]);
					// JOptionPane.showMessageDialog(null, "You Loose :(");
					// reset();
				} else if (picArray[i][j].getIcon() == pics[0]) {
					clearBlanks(i, j);
				}
			}
		}
	}

	public void rightButtonClicked(Object b) {
		if (face.getIcon() == pics[14]) {
			JButton button = (JButton) b;

			if (button != exitButton && button != resetButton) {
				if (button.getIcon() == null) {
					button.setIcon(pics[10]);
					myFlagCounter.addFlag();
				} else {
					button.setIcon(null);
					myFlagCounter.removeFlag();

				}
				flagCounter.setText(myFlagCounter.getNumFlags());
			}
		}
	}

	private void reset() {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[0].length; j++) {
				buttons[i][j].setVisible(true);
				buttons[i][j].setIcon(null);
				backGround.remove(picArray[i][j]);
				beenToo[i][j] = false;
			}
		}

		myFlagCounter.reset();
		flagCounter.setText("Number of Flags: 0");
		makePicArray();
		drawPics();
		face.setIcon(pics[14]);

	}

	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	// DUCKS
	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	private void randomizeDucks() {
		int a, b;
		for (int i = 0; i < 10; i++) {

			a = rand.nextInt(10);
			b = rand.nextInt(10);
			if (beenToo[a][b]) {
				i--;
			} else {
				picArray[a][b].setIcon(pics[9]);
			}
			beenToo[a][b] = true;
		}
	}

	private void showDucks() {
		for (int i = 0; i < picArray.length; i++) {
			for (int j = 0; j < picArray[0].length; j++) {
				if (picArray[i][j].getIcon() == pics[9]) {
					buttons[i][j].setVisible(false);
				}
			}
		}
	}

	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	// Win Condition
	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	private boolean haveIWon() {
		int invisible = 0;
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[0].length; j++) {
				if (buttons[i][j].isVisible() == false) {
					invisible++;
				}
			}
		}
		return (invisible >= 90);
	}
}
