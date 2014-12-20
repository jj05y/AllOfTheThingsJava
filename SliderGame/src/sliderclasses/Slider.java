package sliderclasses;

import java.awt.Container;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Slider extends JFrame {

	private Tile[] tiles;
	private Container c;
	private AMouseListener myListener;
	private ImageIcon[] pics;
	private JLabel bg;
	private Tile winner;
	private boolean randomizing;

	Slider() {
		super("Tiles");
		// System.out.println("game started");

		myListener = new AMouseListener(this);
		pics = new ImageIcon[10];
		tiles = new Tile[8];
		sortTiles();
		sortPics();

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(190, 220);
		this.setVisible(true);
		this.add(bg);
		this.setResizable(false);
		randomize();

	}

	private void sortTiles() {
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = new Tile(i);
			tiles[i].addMouseListener(myListener);

		}

	}

	public void clicked(Object o) {
		Tile t = (Tile) o;
		if (t == winner) {
			winner.setVisible(false);
			for (int i = 0; i < tiles.length; i++) {
				tiles[i].setVisible(true);
			}
			randomize();
		} else {
			t.go();
			if (!randomizing) {
				haveIWon();
			}
		}
	}

	private void haveIWon() {
		String test = "";
		int[][] currStatus = Tile.getLocations();
		for (int i = 0; i < currStatus.length; i++) {
			for (int j = 0; j < currStatus[0].length; j++) {
				test += ("" + currStatus[i][j]);
			}

		}

		// System.out.println("curent status: " + test);
		if (test.equals("123456780")) {
			for (int i = 0; i < tiles.length; i++) {
				tiles[i].setVisible(false);
			}
			winner.setVisible(true);
		}
	}

	private void sortPics() {
		// System.out.println("sorting pics");
		String fileName;

		bg = new JLabel();
		winner = new Tile();

		for (int i = 0; i < pics.length; i++) {
			fileName = ("/" + (i) + ".png");
			// System.out.println(fileName);
			pics[i] = new ImageIcon(getClass().getResource(fileName));
			if (i != 0 && i != 9) {
				tiles[i - 1].setIcon(pics[i]);
				bg.add(tiles[i - 1]);
			}
		}

		bg.setIcon(pics[0]);
		bg.setSize(190, 190);
		winner.setSize(150, 150);
		winner.setLocation(20, 20);
		winner.setIcon(pics[9]);
		winner.setVisible(false);
		winner.addMouseListener(myListener);
		bg.add(winner);

	}

	private void randomize() {
		randomizing = true;
		Random rand = new Random();
		for (int i = 0; i < 30000; i++) {
			tiles[rand.nextInt(8)].go();
		}
		randomizing = false;
	}
}
