package sliderclasses;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class AMouseListener implements MouseListener {
	
	private Slider theGame;
	
	AMouseListener(Slider tg) {
		theGame = tg;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		theGame.clicked(e.getSource());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
