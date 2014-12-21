package sliderclasses;

import java.util.Timer;

public class Animator {
	private Timer myTimer;
	private Tile myTile;
	private int i;
	private int x;
	private int y;
		
	private class LoopyStuff extends java.util.TimerTask {
		public void run() {
			if (i == 25) {
				myTimer.cancel();
			}
			myTile.setLocation(myTile.getX() + x*2, myTile.getY() + y*2);
			i++;
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void animate(Tile t, int x1, int y1) {
		myTile = t;
		i = 1;
		x = x1;
		y = y1;
		myTimer = new Timer();
		myTimer.schedule(new LoopyStuff(), 0, 2 ); 
	}
}
