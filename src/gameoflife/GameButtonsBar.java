package gameoflife;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Josselin MARNAT on 19/08/15.
 */
public class GameButtonsBar extends JPanel implements ActionListener, ChangeListener {

	private static JButton jButtonNext, jButtonAutoNext, jButtonReset, jButtonBabyBoom;
	private static JSlider sliderRapidity;
	private AutoNext autoNext;
	private boolean autoNextState = false;

	public GameButtonsBar(final int height, final int width, int originalZoom) {
		this.setPreferredSize(new Dimension(originalZoom * width, 60));

		/* "PLAY" BUTTONS*/
		jButtonNext = new JButton(TranslationHash.getTranslation("►I"));
		jButtonNext.setToolTipText("Next");
		jButtonNext.addActionListener(this);

		jButtonAutoNext = new JButton(TranslationHash.getTranslation("►"));
		jButtonAutoNext.setToolTipText("Auto-Next : start");
		jButtonAutoNext.addActionListener(this);

		jButtonReset = new JButton(TranslationHash.getTranslation("□"));
		jButtonReset.setToolTipText("Reset (kill everybody)");
		jButtonReset.addActionListener(this);

		jButtonBabyBoom = new JButton(TranslationHash.getTranslation("✸"));
		jButtonBabyBoom.setToolTipText("Baby boom !");
		jButtonBabyBoom.addActionListener(this);

		/* SLIDER-RAPIDITY */
		sliderRapidity = new JSlider();
		sliderRapidity.setToolTipText("Generation age");
		sliderRapidity.setMinimum(10);
		sliderRapidity.setMaximum(50);
		sliderRapidity.setMinorTickSpacing(2);
		sliderRapidity.setMajorTickSpacing(10);
		sliderRapidity.setSnapToTicks(true);
		sliderRapidity.setPaintTicks(true);
		sliderRapidity.setPaintLabels(true);
		sliderRapidity.addChangeListener(this);

		this.add(jButtonNext);
		this.add(jButtonAutoNext);
		this.add(jButtonBabyBoom);
		this.add(jButtonReset);
		this.add(sliderRapidity);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* BUTTONS */
		if (e.getSource() == jButtonNext) {
			GameGrid.next();
			Main.repaint();
		} else if (e.getSource() == jButtonAutoNext) {
			if (!autoNextState) {
				autoNext = new AutoNext(Main.gameGrid, sliderRapidity.getValue() * 10);
				autoNext.start();
				autoNextState = true;
				jButtonAutoNext.setText("II");
				jButtonAutoNext.setToolTipText("Auto-Next : stop");
				repaint();
			} else {
				autoNext.stop();
				autoNextState = false;
				jButtonAutoNext.setText("►");
				jButtonAutoNext.setToolTipText("Auto-Next : start");
			}
			Main.repaint();
		} else if (e.getSource() == jButtonReset) {
			GameGrid.clear();
			Main.repaint();
		} else if (e.getSource() == jButtonBabyBoom) {
			GameGrid.clear();
			GameGrid.babyBoom();
			Main.repaint();
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if ((e.getSource() == sliderRapidity) && (autoNext != null)) {
			autoNext.setMilis(sliderRapidity.getValue() * 10);
		}
	}
}
