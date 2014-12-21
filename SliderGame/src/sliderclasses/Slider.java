package sliderclasses;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Slider extends JFrame {

	private Tile[] tiles;
	private AMouseListener myListener;
	private ImageIcon[] pics;
	private JLabel bg;
	private Tile winner;
	private boolean randomizing;
	

	Slider() {
		super(":)");
		// System.out.println("game started");

		myListener = new AMouseListener(this);
		pics = new ImageIcon[10];
		tiles = new Tile[8];
		sortTilesNPics();

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(190, 220);
		this.setVisible(true);
		this.add(bg);
		this.setResizable(false);
		randomize();

	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////

	private void sortTilesNPics() {
		
		bg = new JLabel();
		winner = new Tile(myListener);
		String fileName;
		
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = new Tile(i, myListener);
		}

		for (int i = 0; i < pics.length; i++) {
			fileName = ("/" + (i) + ".png");
			// System.out.println(fileName);
			pics[i] = new ImageIcon(getClass().getResource(fileName));
			if (i != 0 && i != 9) { //the backgroud and win image arnt associated with  moveable tiles,
				tiles[i - 1].setIcon(pics[i]);
				bg.add(tiles[i - 1]);
			}
		}
		
		winner.setIcon(pics[9]);
		bg.setIcon(pics[0]);
		bg.setSize(190, 190);
		bg.add(winner);

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////
	
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

	///////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	
	///////////////////////////////////////////////////////////////////////////////////////////////////

	private void randomize() {
		randomizing = true;
		Tile.randomizing = true;
		Random rand = new Random();
		for (int i = 0; i < 3000; i++) {
			tiles[rand.nextInt(8)].go();
		}
		randomizing = false;
		Tile.randomizing = false;
	}
}
