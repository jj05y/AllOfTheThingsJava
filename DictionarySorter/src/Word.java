public class Word implements Comparable {
	private int score;
	private String word;
	private String sig;

	public Word(String w) {
		word = w;
		score = 0;
	}


	public int getScore() {
		return score;
	}

	public void setScore(int n) {
		this.score += n;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String w) {
		this.word = w;
	}

	public String getSig() {
		return sig;
	}

	public void setSig(String s) {
		this.sig = s;
	}

	public int compareTo(Object o) {
		Word w = (Word) o;
		if (this.sig.compareTo(w.getSig()) < 0) {
			return -1;
		} else if (this.sig.compareTo(w.getSig()) > 0) {
			return 1;
		} else {
			return 0;
		}
	}



}
