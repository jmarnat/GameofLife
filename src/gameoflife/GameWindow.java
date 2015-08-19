package gameoflife;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Josselin MARNAT on 06/08/15.
 */
public class GameWindow extends JFrame {

	public GameWindow(int width, int height, int zoom) {
		// TODO serialize -> load
		// TODO pref : resize window + zoom + colors + grid + language
		// TODO all jMenus (4)

		this.setTitle(TranslationHash.getTranslation("Game of Life"));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setJMenuBar(new GameMenuBar(height, width, zoom));
		// this.setPreferredSize(new Dimension(zoom * width, zoom * height + 80));

		this.add(Main.gameGrid, BorderLayout.NORTH);
		this.add(new GameButtonsBar(height, width, zoom), BorderLayout.SOUTH);

		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(this.getParent());
		this.setVisible(true);
	}


}
