import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SignerMaker {

	String line;
	int[] scores = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };

	public void readWords(ArrayList<Word> l) {
		try {
			File file = new File("UK.dic");
			BufferedReader br = new BufferedReader(new FileReader(file));
			line = br.readLine();
			while (line != null) {
				l.add(new Word(line));
				line = br.readLine();
			}

			br.close();
		} catch (IOException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
	}

	public void signWords(ArrayList<Word> l) {
		for (int i = 0; i < l.size(); i++) {
			char[] chars = l.get(i).getWord().toCharArray();
			Arrays.sort(chars);
			l.get(i).setSig(new String(chars));
		}
	}

	public void scoreWords(ArrayList<Word> l) {
		for (int i = 0; i < l.size(); i++) {
			for (int j = 0; j < l.get(i).getWord().length(); j++) {
				if ((int)l.get(i).getWord().charAt(j) <= 122 && (int)l.get(i).getWord().charAt(j) >= 97) {
					l.get(i).setScore(scores[((int)l.get(i).getWord().charAt(j))-97]);
				}
			}
		}

	}

	@SuppressWarnings("unchecked")
	public void sort(ArrayList<Word> l) {
		Collections.sort(l);

	}

}
