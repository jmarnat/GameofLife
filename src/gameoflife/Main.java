package gameoflife;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
	public static GameGrid gameGrid;
	public static GameWindow gw;

	public static void main(String[] args) {
		new TranslationHash(TranslationHash.EN);
		gameGrid = new GameGrid(40, 60, 15);
		gw = new GameWindow(60, 40, 15);
	}

	public static void repaint() {
		gw.repaint();
	}

	public static void setGameGrid(String fileName) {
		System.out.println("LOAD: " + Main.gameGrid);
		gameGrid = GameGrid.open(fileName);
		System.out.println("LOAD: " + Main.gameGrid);
		// repaint();
	}

	public static void save(String fileName) {
		ObjectOutputStream objOutStr;
		try {
			objOutStr = new ObjectOutputStream(new FileOutputStream(fileName));
			objOutStr.writeObject(gameGrid);
			objOutStr.flush();
			objOutStr.close();
			System.err.println("game saved with success");
		} catch (FileNotFoundException e) {
			System.err.println("backup file not found:");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("backup error:");
			e.printStackTrace();
		}
	}
}