package gameoflife;

/**
 * Created by Josselin MARNAT on 22/08/15.
 */
public class Rule {
	private boolean[] B, S;

	public Rule() {
		B = new boolean[8];
		S = new boolean[8];
		for (int i = 0; i < 8; i++) B[i] = S[i] = false;
	}

	public Rule(boolean[] B1, boolean[] S1) {
		B = B1;
		S = S1;
	}

	public boolean getB(int i) {
		return (i >= 0 ? B[i] : false);
	}

	public boolean getS(int i) {
		return (i >= 0 ? S[i] : false);
	}

	public void setB(int i, boolean b) {
		B[i] = b;
	}

	public void setS(int i, boolean b) {
		S[i] = b;
	}

}
