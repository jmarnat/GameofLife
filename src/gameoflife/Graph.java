package gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * Created by Josselin MARNAT on 20/08/15.
 */
public class Graph extends JPanel implements MouseMotionListener {
	ArrayList<Integer> statistics;
	int max;
	int overX = -1;
//	JPanel jPanelStats;

	public Graph(ArrayList<Integer> statistics, int max) {
		this.setName("Statistics");
		this.statistics = statistics;
		this.max = max;
		this.setPreferredSize(new Dimension(500, 200));
		this.addMouseMotionListener(this);
		repaint();
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 200);

		g.setColor(Color.WHITE);
		int v = 0;
		int s = statistics.size();

		int v1, v0, vs = 200;
		int a;
		for (int i = 0; i < 500; i++) {
			a = s - 500 + i;
			if (a >= 0) {
				v1 = statistics.get(a);
				if (a > 0) {
					v0 = statistics.get(a - 1);
					if (GameOfLife.showColors) {
						if (v1 > v0) g.setColor(new Color(00, 50, 250));
						else if (v1 < v0) g.setColor(new Color(170, 0, 10));
						else g.setColor(new Color(200, 180, 160));
					} else g.setColor(GameOfLife.colorWhite);
				}
				v = 200 - ((v1 * 200) / ((max == 0) ? 1 : max));
				g.drawLine(i, vs, i, v);

				if (i == overX) {
					g.setColor(Color.GRAY);
					g.drawLine(i, 200, i, v + 1);
				}
				vs = v;
			}
		}

//		g.setColor(Color.GRAY);
//		g.drawString("max: " + max, 10, 150);
//		g.drawString("generation: " + s, 10, 170);
//		g.drawString("live cell(s): " + GameGrid.nbAlive(), 10, 190);
	}

	public void update(ArrayList<Integer> statistics, int max) {
		this.statistics = statistics;
		this.max = max;
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
//		int x = e.getX(), y = e.getY();
//		System.err.println(x+"\t"+y);
//		if ((0 <= x) && (x < 200) && )
		overX = e.getX();
		repaint();
	}


	/*public void showGraph() {
		JFrame jFrame = new JFrame("Statistics");
		JPanel jPanelStats = new JPanel();

		jFrame.pack();
		jFrame.setLocationRelativeTo(jFrame.getParent());
		jFrame.setVisible(true);
	}*/
}
