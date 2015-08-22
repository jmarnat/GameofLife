package gameoflife;

/**
 * Created by Josselin MARNAT on 19/08/15.
 */
public class AutoNext extends Thread {
	int milis;
	GameGrid gameGrid;

	public AutoNext(GameGrid gameGrid, int milis) {
		this.gameGrid = gameGrid;
		this.milis = milis;
	}

	@Override
	public void run() {
		while (true) {
			GameOfLife.gameGrid.next();
			GameOfLife.repaint();

			try {
				sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void setMilis(int milis) {
		this.milis = milis;
	}
}