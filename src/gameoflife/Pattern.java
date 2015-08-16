package gameoflife;

/**
 * Created by Josselin MARNAT on 15/08/15.
 */
public class Pattern {
	public final static int ROTATE_RIGHT = 0, ROTATE_LEFT = 1, FLIP_HORIZONTAL = 2, FLIP_VERTICAL = 3;
	private int[][] patternGrid;

	public Pattern(int patternGrid[][]) {
		this.patternGrid = patternGrid;
	}

	public int getWidth() {
		return patternGrid[0].length;
	}

	public int getHeight() {
		return patternGrid.length;
	}

	public int getCell(int x, int y) {
		try {
			return patternGrid[x][y];
		} catch (Exception e) {
			return 0;
		}
	}

	public void rotateRight() {
		int h = getHeight(), w = getWidth();
		int[][] tmp = new int[w][h];
		for (int i = 0; i < w; i++)
			for (int j = 0; j < h; j++)
				tmp[i][j] = patternGrid[h-1-j][i];
		patternGrid = tmp;
	}

	public void rotateLeft() {
		int h = getHeight(), w = getWidth();
		int[][] tmp = new int[w][h];
		for (int i = 0; i < w; i++)
			for (int j = 0; j < h; j++)
				tmp[i][j] = patternGrid[j][w-1-i];
		patternGrid = tmp;
	}

	public void flipHorizontal() {
		int h = getHeight(), w = getWidth();
		int[][] tmp = new int[h][w];
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
				tmp[i][j] = patternGrid[i][w-1-j];
		patternGrid = tmp;
	}

	public void flipVertical() {
		int h = getHeight(), w = getWidth();
		int[][] tmp = new int[h][w];
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
				tmp[i][j] = patternGrid[h-1-i][j];
		patternGrid = tmp;
	}

	public void print() {
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				System.err.print(getCell(i, j) + " ");
			}
			System.err.println();
		}
	}
}
