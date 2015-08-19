package gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Created by Josselin MARNAT on 06/08/15.
 */
public class GameGrid extends JPanel implements Serializable {
	private static final long serialVersionUID = 1L;
	public static int DEAD = 0, ALIVE = 1;
	public static int NOW = 0, THEN = 1;
	private static int width, height;
	private static int step;
	private static int[][][] stateGrids;
	private static Pattern pattern = Patterns.livingCell;
	private int pi, pj;
	private int zoom; // pixels-size of a square
	private boolean showPhantom = true;

	/**
	 * Constructor of the "physical" game grid.
	 *
	 * @param width  of the grid
	 * @param height of the grid
	 */
	GameGrid(final int height, final int width, int originalZoom) {
		GameGrid.width = width;
		GameGrid.height = height;
		this.zoom = originalZoom;

		stateGrids = new int[height][width][2];
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				stateGrids[i][j][NOW] = DEAD;
		step = 0;


		this.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int i = e.getY() / zoom, j = e.getX() / zoom;
				if ((i < 0) || (j < 0) || (i >= height) || (j >= width)) return;
				pi = i;
				pj = j;

				if (pattern == Patterns.livingCell) {
					stateGrids[pi][pj][NOW] = ALIVE;
				} else if (pattern == Patterns.deadCell) {
					stateGrids[pi][pj][NOW] = DEAD;
				} else {
					int h = pattern.getHeight(), w = pattern.getWidth();
					for (i = 0; i < h; i++)
						for (j = 0; j < w; j++)
							if (pattern.getCell(i, j) == 1)
								stateGrids[pi + i][pj + j][NOW] = ALIVE;
				}

				GameMenuBar.majNbAlive();
				repaint();

			}

			@Override
			public void mouseMoved(MouseEvent e) {
				int i = e.getY() / zoom, j = e.getX() / zoom;
				if ((i < 0) || (j < 0) || (i >= height) || (j >= width)) {
					return;
				}
				if ((i != pi) || (j != pj)) {
					// stateGrids[i][j][NOW] = pressed;
					pi = i;
					pj = j;
					// GameMenuBar.majNbAlive();
					repaint();
				}
			}
		});
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int i = e.getY() / zoom, j = e.getX() / zoom;
				if ((i < 0) || (j < 0) || (i >= height) || (j >= width)) return;
				int h = pattern.getHeight(), w = pattern.getWidth();
				pi = i;
				pj = j;
				for (i = 0; i < h; i++) {
					for (j = 0; j < w; j++) {
						if (pattern.getCell(i, j) == 1) {
							stateGrids[pi + i][pj + j][NOW] = ALIVE;
						}
					}
				}

				GameMenuBar.majNbAlive();
				repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				showPhantom = true;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				showPhantom = false;
				repaint();
			}
		});

		this.setPreferredSize(new Dimension(zoom * width, zoom * height));
	}

	static int stateNow(int x, int y) {
		if ((x < 0) || (x >= height) || (y < 0) || (y >= width)) return 0;
		else return stateGrids[x][y][NOW];
	}


	private static int nbAlive(int x, int y) {
		int n = 0;
		for (int i = -1; i <= 1; i++)
			for (int j = -1; j <= 1; j++)
				if (!((i == 0) && (j == 0)))
					n += ((stateNow(x + i, y + j) == ALIVE) ? 1 : 0);
		return n;
	}

	public static void next() {
		int n;
		int s;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				n = nbAlive(i, j);
				s = stateNow(i, j);
				if (s == ALIVE) {
					if ((n == 2) || (n == 3)) stateGrids[i][j][THEN] = ALIVE;
					else stateGrids[i][j][THEN] = DEAD;
				} else { /* if it's DEAD... */
					if (n == 3) stateGrids[i][j][THEN] = ALIVE; /* reborn */
					else stateGrids[i][j][THEN] = DEAD; /* keep DEAD */
				}
			}
		}
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				stateGrids[i][j][NOW] = stateGrids[i][j][THEN];
		step++;
		GameMenuBar.majNbAlive();
		GameMenuBar.majStep();
	}


	public static void clear() {
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				stateGrids[i][j][NOW] = DEAD;
		GameGrid.step = 0;
		GameMenuBar.majNbAlive();
		GameMenuBar.majStep();
	}

	public static void babyBoom() {
		int max = width * height / 4;
		for (int n = 0; n < max; n++) {
			int i, j;
			do {
				i = (int) (Math.random() * height);
				j = (int) (Math.random() * width);
			} while (stateGrids[i][j][NOW] == ALIVE);
			stateGrids[i][j][NOW] = ALIVE;
		}
		GameMenuBar.majNbAlive();
	}

	public static int nbAlive() {
		int nb = 0;
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				if (stateGrids[i][j][NOW] == ALIVE) nb++;
		return (nb);
	}

	public static int step() {
		return step;
	}

	public static void changePattern(Pattern p) {
		pattern = p;
	}

	public static void transformPattern(int transformation) {
		if (transformation == Pattern.FLIP_HORIZONTAL) pattern.flipHorizontal();
		else if (transformation == Pattern.FLIP_VERTICAL) pattern.flipVertical();
		else if (transformation == Pattern.ROTATE_LEFT) pattern.rotateLeft();
		else if (transformation == Pattern.ROTATE_RIGHT) pattern.rotateRight();
		Main.repaint();
	}

	public static GameGrid open(String fileName) {
		GameGrid gameGrid = null;
		// TODO ajouter selection de fichier, et check
		try {
			FileInputStream fileInputStream = new FileInputStream(fileName);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			gameGrid = (GameGrid) objectInputStream.readObject();
			objectInputStream.close();
			System.err.println("game restored with success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (gameGrid);
	}



	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (stateNow(i, j) == ALIVE) g.setColor(Color.white);
				else g.setColor(Color.black);
				g.fillRect(j * zoom, i * zoom, zoom, zoom);
			}
		}
		if (!showPhantom) return;
		g.setColor(Color.gray);
		int h = pattern.getHeight(), w = pattern.getWidth();

		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
				if ((pattern.getCell(i, j) == 1) && (stateNow(pi + i, pj + j) != ALIVE))
					g.fillRect((pj + j) * zoom, (pi + i) * zoom, zoom, zoom);
	}

	@Override
	public String toString() {
		return ("alive : " + nbAlive());
	}
}
