package gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameOfLife {
	public static int WIDTH = 60, HEIGHT = 40, PIX_SIZE = 15;
	//	public static int WIDTH = 180, HEIGHT = 120, PIX_SIZE = 5;
	public static GameGrid gameGrid;
	public static GameWindow gameWindow;
	public static JFrame jFrameStatistics;
	public static Graph graph;
	public static boolean showColors = false;
	public static Color
			colorAlive = new Color(200, 180, 160),
			colorDying = new Color(100, 0, 70),
			colorBorning = new Color(20, 160, 250);
	public static Color colorWhite = Color.WHITE;

	public static Rule rule = Rules.CLASSIC; // todo


	public static void main(String[] args) {
		new TranslationHash(TranslationHash.EN);

		gameGrid = new GameGrid(HEIGHT, WIDTH, PIX_SIZE);
		gameWindow = new GameWindow(WIDTH, HEIGHT, PIX_SIZE);

		jFrameStatistics = new JFrame("Statistics");
		graph = new Graph(GameGrid.getStatistics(), GameGrid.getMax());
		jFrameStatistics.add(graph);
		jFrameStatistics.pack();

		jFrameStatistics.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		jFrameStatistics.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				GameMenuBar.updateStatisticsMenu(false);
				// gameWindow.setLocation(gameWindow.getX() + gameWindow.getWidth() - 100, gameWindow.getY());
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}
		});
		jFrameStatistics.setResizable(false);
		jFrameStatistics.setVisible(false);


//		gameGrid.exportGifStart();
	}

	public static void repaint() {
		gameWindow.repaint();
		graph.repaint();
	}

	public static void updateStatistics() {
		graph.update(GameGrid.getStatistics(), GameGrid.getMax());
	}

	public static void setShowColors(boolean showColors1) {
		showColors = showColors1;
	}
}