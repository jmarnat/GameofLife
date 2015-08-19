package gameoflife;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Josselin MARNAT on 19/08/15.
 */
public class Slider extends JPanel {

	private JSlider slide;
	private JLabel label;

	Slider(String nom, int min, int max) {
		this.setLayout(new BorderLayout(1, 2));
		Color fgColor = new Color(255, 200, 0);

		label = new JLabel(nom);
		label.setForeground(fgColor);
		label.setOpaque(false);

		slide = new JSlider();
		slide.setMinimum(min);
		slide.setMaximum(max);
		slide.setValue((min + max) / 2);
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		slide.setMinorTickSpacing(1);
		slide.setMajorTickSpacing(5);
		slide.setSnapToTicks(true);
		slide.setForeground(fgColor);
		slide.setPreferredSize(new Dimension(190, 40));
		slide.setOpaque(false);

		this.add(label);
		this.add(slide);
		this.setPreferredSize(new Dimension(200, 40));
		this.setOpaque(false);
	}

	/**
	 * @return value of actual slider
	 */
	public int getValue() {
		return this.slide.getValue();
	}
}
