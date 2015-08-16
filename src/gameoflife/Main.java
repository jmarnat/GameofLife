package gameoflife;

public class Main {
	private static GameWindow gw;

	public static void main(String[] args) {
		new TranslationHash(TranslationHash.EN);
		gw = new GameWindow(60, 40, 15);
	}

	public static void repaint() {
		gw.repaint();
	}
}

