package gameoflife;

import javax.swing.*;

/**
 * Created by Josselin MARNAT on 06/08/15.
 */
public class GameWindow extends JFrame {
	public GameWindow(int width, int height, int zoom) {
		// TODO auto-next
		// TODO serialize
		// TODO pref : resize window + zoom + colors + grid + language
		// TODO all jMenus

		this.setTitle(TranslationHash.getTranslation("Game of Life"));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		this.setJMenuBar(new GameMenuBar(height, width, zoom));
		this.add(new GameGrid(height, width, zoom));

		this.setResizable(false);
		this.setLocationRelativeTo(this.getParent());
		this.pack();
		this.setVisible(true);
	}


}
