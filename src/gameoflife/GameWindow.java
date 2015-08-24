package gameoflife;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Josselin MARNAT on 06/08/15.
 */
public class GameWindow extends JFrame {

	public GameWindow(int width, int height, int zoom) {
		// TODO pref : resize window + zoom + colors + grid + language
		// TODO all jMenus (4)

		this.setTitle(TranslationHash.getTranslation("Game of Life"));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setJMenuBar(new GameMenuBar(width, zoom));

		this.add(GameOfLife.gameGrid, BorderLayout.NORTH);
		this.add(new GameButtonsBar(height, width, zoom), BorderLayout.SOUTH);

		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(this.getParent());
		this.setVisible(true);
	}


}
