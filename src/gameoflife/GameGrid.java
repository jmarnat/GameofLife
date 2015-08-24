package gameoflife;

import javax.imageio.*;
import javax.imageio.metadata.IIOMetadata;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Josselin MARNAT on 06/08/15.
 */
public class GameGrid extends JPanel implements Serializable {
	private static final long serialVersionUID = 1L;
	public static boolean DEAD = false, ALIVE = true;
	public static int OLD = 0, NEW = 1;
	private static int width, height;
	private static int step;
	private static boolean[][][] stateGrids;
	private static Pattern pattern = Patterns.LIVINGCELL;
	private static ArrayList<Integer> statistics;
	private static int max;
	private static int zoom; // pixels-size of a square
	private static ImageWriter imageWriter;
	private boolean recordingGif = false;
	private int pi, pj;
	private boolean showPhantom = true;
	private boolean theoricMode = true;
	private Rule rule = Rules.CONWAY;

	/**
	 * Constructor of the "physical" game grid.
	 *
	 * @param width  of the grid
	 * @param height of the grid
	 */
	GameGrid(final int height, final int width, int originalZoom) {
		GameGrid.width = width;
		GameGrid.height = height;
		zoom = originalZoom;

		stateGrids = new boolean[height][width][2];
		statistics = new ArrayList<Integer>();
		max = 0;

		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				stateGrids[i][j][OLD] = DEAD;
		step = 0;


		this.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int i = e.getY() / zoom, j = e.getX() / zoom;
				if ((i < 0) || (j < 0) || (i >= height) || (j >= width)) return;
				pi = i;
				pj = j;

				if (pattern == Patterns.LIVINGCELL) {
					stateGrids[pi][pj][NEW] = ALIVE;
				} else if (pattern == Patterns.DEADCELL) {
					stateGrids[pi][pj][NEW] = DEAD;
				} else {
					int h = pattern.getHeight(), w = pattern.getWidth();
					for (i = 0; i < h; i++) {
						for (j = 0; j < w; j++) {
							if (pattern.getCell(i, j) == 1) {
								if (theoricMode)
									stateGrids[(pi + i + height) % height][(pj + j + width) % width][NEW] = ALIVE;
								else if (((pi + i) < height) && ((pj + j) < width))
									stateGrids[pi + i][pj + j][NEW] = ALIVE;
							}
						}
					}
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
					pi = i;
					pj = j;
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

				if (pattern == Patterns.DEADCELL) {
					stateGrids[pi][pj][NEW] = DEAD;
				} else {
					int h = pattern.getHeight(), w = pattern.getWidth();
					pi = i;
					pj = j;
					for (i = 0; i < h; i++) {
						for (j = 0; j < w; j++) {
							if (pattern.getCell(i, j) == 1) {
								if (theoricMode)
									stateGrids[(pi + i + height) % height][(pj + j + width) % width][NEW] = ALIVE;
								else if (((pi + i) < height) && ((pj + j) < width))
									stateGrids[pi + i][pj + j][NEW] = ALIVE;
							}
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

	static boolean stateNew(int x, int y) {
		return stateGrids[x][y][NEW];
	}

	public static void clear() {
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				stateGrids[i][j][OLD] = stateGrids[i][j][NEW] = DEAD;
		GameGrid.step = 0;
		GameGrid.statistics = new ArrayList<Integer>();
		GameGrid.max = 0;
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
			} while (stateGrids[i][j][OLD] == ALIVE);
			stateGrids[i][j][NEW] = ALIVE;
		}
		GameMenuBar.majNbAlive();
	}

	public static int nbAlive() {
		int nb = 0;
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				if (stateGrids[i][j][NEW] == ALIVE) nb++;
		return (nb);
	}

	public static int step() {
		return step;
	}

	public static void changePattern(Pattern p) {
		pattern = p;
		GameButtonsBar.updatePatternName();
	}

	public static void transformPattern(int transformation) {
		if (transformation == Pattern.FLIP_HORIZONTAL) pattern.flipHorizontal();
		else if (transformation == Pattern.FLIP_VERTICAL) pattern.flipVertical();
		else if (transformation == Pattern.ROTATE_LEFT) pattern.rotateLeft();
		else if (transformation == Pattern.ROTATE_RIGHT) pattern.rotateRight();
		GameOfLife.repaint();
	}

	public static String getPatternName() {
		return pattern.getName();
	}

	public static ArrayList<Integer> getStatistics() {
		return statistics;
	}

	public static int getMax() {
		return max;
	}

	private boolean stateOld(int x, int y) {
		if (theoricMode) {
			return stateGrids[(x + height) % height][(y + width) % width][OLD];
		} else {
			if ((x < 0) || (x >= height) || (y < 0) || (y >= width)) return false;
			else return stateGrids[x][y][OLD];
		}
	}

	private int nbAlive(int x, int y) {
		int n = 0;
		for (int i = -1; i <= 1; i++)
			for (int j = -1; j <= 1; j++)
				if (!((i == 0) && (j == 0)))
					n += ((stateOld(x + i, y + j)) ? 1 : 0);
		return n;
	}

	public void next() {
		int nbAlive = nbAlive();
		statistics.add(nbAlive);
		if (nbAlive > max) max = nbAlive;

		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				stateGrids[i][j][OLD] = stateGrids[i][j][NEW];

		int n;
		boolean s;
		if (theoricMode) {
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					n = nbAlive(i, j);
					s = stateOld(i, j);
					if (s == ALIVE) {
						if (this.rule.getS(n - 1)) stateGrids[i % height][j % width][NEW] = ALIVE;
						else stateGrids[i % height][j % width][NEW] = DEAD;
					} else { /* if it's DEAD... */
						if (this.rule.getB(n - 1)) stateGrids[i % height][j % width][NEW] = ALIVE; /* reborn */
						else stateGrids[i % height][j % width][NEW] = DEAD; /* keep DEAD */
					}
				}
			}
		} else {
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					n = nbAlive(i, j);
					s = stateOld(i, j);
					if (s == ALIVE) {
						if (this.rule.getS(n - 1)) stateGrids[i][j][NEW] = ALIVE;
						else stateGrids[i][j][NEW] = DEAD;
					} else { /* if it's DEAD... */
						if (this.rule.getB(n - 1)) stateGrids[i][j][NEW] = ALIVE; /* reborn */
						else stateGrids[i][j][NEW] = DEAD; /* keep DEAD */
					}
				}
			}
		}

		step++;
		GameMenuBar.majNbAlive();
		GameMenuBar.majStep();

		GameOfLife.updateStatistics();


		// export gif
		if (recordingGif) {
			BufferedImage bufferedImage = new BufferedImage(width * zoom, height * zoom, BufferedImage.TYPE_INT_RGB);
			showPhantom = false;
			paintComponent(bufferedImage.createGraphics());
			try {
				imageWriter.writeToSequence(new IIOImage(bufferedImage, null, null), imageWriter.getDefaultWriteParam());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void paintComponent(Graphics g) {
		if (GameOfLife.showColors) {
			boolean s0, s1;
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					s0 = stateOld(i, j);
					s1 = stateNew(i, j);
					if (s0 && s1) g.setColor(GameOfLife.colorAlive);
					else if (!s0 && s1) g.setColor(GameOfLife.colorBorning);
					else if (s0 && !s1) g.setColor(GameOfLife.colorDying);
					else g.setColor(Color.black);
					g.fillRect(j * zoom, i * zoom, zoom, zoom);
				}
			}
		} else {
			g.setColor(Color.white);
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (stateNew(i, j) == ALIVE) g.setColor(GameOfLife.colorWhite);
					else g.setColor(Color.black);
					g.fillRect(j * zoom, i * zoom, zoom, zoom);
				}
			}
		}

		// PHANTOM
		if (!showPhantom) return;
		g.setColor(Color.gray);
		int h = pattern.getHeight(), w = pattern.getWidth();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (pattern.getCell(i, j) == 1) {
					if (theoricMode && (stateNew((pi + i) % height, (pj + j) % width) != ALIVE))
						g.fillRect(((pj + j) % width) * zoom, ((pi + i) % height) * zoom, zoom, zoom);
					else if (((pi + i) < height) && ((pj + j) < width) && (stateNew(pi + i, pj + j) != ALIVE))
						g.fillRect((pj + j) * zoom, (pi + i) * zoom, zoom, zoom);
				}
			}
		}
	}

	@Override
	public String toString() {
		return ("alive : " + nbAlive());
	}

	public void exportJPG(File outputFile) {
		System.err.println("export...");
		BufferedImage bufferedImage = new BufferedImage(width * zoom, height * zoom, BufferedImage.TYPE_INT_RGB);
		showPhantom = false;
		paintComponent(bufferedImage.createGraphics());

		try {
			ImageIO.write(bufferedImage, "jpg", outputFile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		System.err.println("done?");
	}


	public void exportGifStart(File file) {
		recordingGif = true;
		try {
			// creating buffered image
			BufferedImage bufferedImage = new BufferedImage(width * zoom, height * zoom, BufferedImage.TYPE_INT_RGB);
			showPhantom = false;
			paintComponent(bufferedImage.getGraphics());

			// setting output
			ImageTypeSpecifier imageTypeSpecifier = new ImageTypeSpecifier(bufferedImage);
			imageWriter = ImageIO.getImageWriters(imageTypeSpecifier, "GIF").next();
			imageWriter.setOutput(ImageIO.createImageOutputStream(file));
			ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();
			IIOMetadata iioMetadata = imageWriter.getDefaultImageMetadata(imageTypeSpecifier, imageWriteParam);
			imageWriter.prepareWriteSequence(iioMetadata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void exportGifEnd() {
		recordingGif = false;
		imageWriter.dispose();
	}

	public boolean isRecordingGif() {
		return this.recordingGif;
	}

	public void changeRule(Rule rule) {
		this.rule = rule;
	}

	public boolean isTheoricMode() {
		return this.theoricMode;
	}

	public void setTheoricMode(boolean b) {
		this.theoricMode = b;
	}

	public String getRuleName() {
		return this.rule.getName();
	}
}
