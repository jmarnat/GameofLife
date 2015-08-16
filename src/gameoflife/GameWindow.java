package gameoflife;

import javax.swing.*;

/**
 * Created by Josselin MARNAT on 06/08/15.
 */
public class GameWindow extends JFrame {
	private static GameGrid gameGrid;


	public GameWindow(int width, int height, int zoom) {
		// TODO auto-next
		// TODO serialize
		// TODO pref : resize window + zoom + colors + grid + language
		// TODO all jMenus

		this.setTitle(TranslationHash.getTranslation("Game of Life"));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setJMenuBar(new GameMenuBar(height, width, zoom));

		gameGrid = new GameGrid(height, width, zoom);
		this.add(gameGrid);

		this.setResizable(false);
		this.setLocationRelativeTo(this.getParent());
		this.pack();
		this.setVisible(true);
	}

	public static GameGrid getGameGrid() {
		return gameGrid;
	}

	public void setGameGrid(String fileName) {
		System.out.println(gameGrid.toString());
		gameGrid = GameGrid.open(fileName);
		repaint();
	}


}
