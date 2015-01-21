import java.util.ArrayList;

public class Runner {
	
	public static void main(String[] args) {
		ArrayList<Word> l = new ArrayList<Word>();
		SignerMaker go = new SignerMaker();
		go.readWords(l);
		go.signWords(l);
		go.sort(l);
		go.scoreWords(l);
		
		
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i).getSig() + " " +
								l.get(i).getWord() + " " +
								l.get(i).getScore());
		}
	}
}
