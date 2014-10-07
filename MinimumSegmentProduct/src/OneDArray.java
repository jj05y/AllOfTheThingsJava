import java.util.Random;
import javax.swing.JOptionPane;

public class OneDArray {

	int intArray[] = new int[100];
	

	public OneDArray() {
		Random rand = new Random();
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = rand.nextInt(999);
		}
	}
	
	public void showArray() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < intArray.length; i++) {
			
			if ((i % 10) == 0 && i != 0) {
				sb.append("\n");
			}
			sb.append(String.format("%03d ",intArray[i]));

			
		}
		JOptionPane.showMessageDialog(null, sb);
	}
	
	

}
