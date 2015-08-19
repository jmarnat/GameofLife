package gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Josselin MARNAT on 15/08/15.
 */
public class GameMenuBar extends JMenuBar implements ActionListener {
	private static JLabel jLabelNbAlive, jLabelStep;

	private static JMenu jMenuGameOfLife, jMenuPatterns, jMenuTransformations;
	private static JMenu jMenuStillLifes, jMenuOscillators, jMenuSpaceships;
	private static JMenuItem jMenuItemRotateRight, jMenuItemRotateLeft, jMenuItemFlipHorizontal, jMenuItemFlipVertical;
	private static JMenuItem jMenuItemQuit, jMenuItemSave, jMenuItemLoad, jMenuItemAbout, jMenuItemRules;
	private static JRadioButtonMenuItem jMenuItemLiveCell, jMenuItemDeadCell;
	private static JRadioButtonMenuItem jRadioButtonMenuItemBlock, jRadioButtonMenuItemBeehive, jRadioButtonMenuItemLoaf, jRadioButtonMenuItemBoat;
	private static JRadioButtonMenuItem jRadioButtonMenuItemBlinker, jRadioButtonMenuItemToad, jRadioButtonMenuItemBeacon, jRadioButtonMenuItemPulsar, jRadioButtonMenuItemPentadecathlon;
	private static JRadioButtonMenuItem jRadioButtonMenuItemGlider, jRadioButtonMenuItemLWSS, jRadioButtonMenuItemBSS1, jRadioButtonMenuItemBSS2;


	public GameMenuBar(int height, int width, int zoom) {
		this.setPreferredSize(new Dimension(zoom * width, 40));

		jMenuGameOfLife = new JMenu("Game of Life");
		jMenuPatterns = new JMenu("Patterns");
		jMenuTransformations = new JMenu("Transformations");

		/* MENUS : GAME OF LIFE */
		jMenuItemQuit = new JMenuItem("Quit");
		jMenuItemQuit.addActionListener(this);

		jMenuItemSave = new JMenuItem("Save...");
		jMenuItemSave.setEnabled(false);
		jMenuItemSave.addActionListener(this);

		jMenuItemLoad = new JMenuItem("Load...");
		jMenuItemLoad.setEnabled(false);
		jMenuItemLoad.addActionListener(this);

		jMenuItemAbout = new JMenuItem("About");
		jMenuItemAbout.setEnabled(false);
		jMenuItemAbout.addActionListener(this);

		jMenuItemRules = new JMenuItem("Rules");
		jMenuItemRules.setEnabled(false);
		jMenuItemRules.addActionListener(this);

		/* MENUS : PATTERNS */
		jMenuStillLifes = new JMenu("Still Lifes");
		jMenuOscillators = new JMenu("Oscillators");
		jMenuSpaceships = new JMenu("Spaceships");

		jMenuItemLiveCell = new JRadioButtonMenuItem("Live livingCell");
		jMenuItemLiveCell.setSelected(true);
		jMenuItemLiveCell.addActionListener(this);
		jMenuItemDeadCell = new JRadioButtonMenuItem("Dead livingCell");
		jMenuItemDeadCell.addActionListener(this);

		jRadioButtonMenuItemBlock = new JRadioButtonMenuItem("Block");
		jRadioButtonMenuItemBlock.addActionListener(this);
		jRadioButtonMenuItemBeehive = new JRadioButtonMenuItem("Beehive");
		jRadioButtonMenuItemBeehive.addActionListener(this);
		jRadioButtonMenuItemLoaf = new JRadioButtonMenuItem("Loaf");
		jRadioButtonMenuItemLoaf.addActionListener(this);
		jRadioButtonMenuItemBoat = new JRadioButtonMenuItem("Boat");
		jRadioButtonMenuItemBoat.addActionListener(this);

		jRadioButtonMenuItemBlinker = new JRadioButtonMenuItem("Blinker (2)");
		jRadioButtonMenuItemBlinker.addActionListener(this);
		jRadioButtonMenuItemToad = new JRadioButtonMenuItem("Toad (2)");
		jRadioButtonMenuItemToad.addActionListener(this);
		jRadioButtonMenuItemBeacon = new JRadioButtonMenuItem("Beacon (2)");
		jRadioButtonMenuItemBeacon.addActionListener(this);
		jRadioButtonMenuItemPulsar = new JRadioButtonMenuItem("Pulsar (3)");
		jRadioButtonMenuItemPulsar.addActionListener(this);
		jRadioButtonMenuItemPentadecathlon = new JRadioButtonMenuItem("Pentadecathlon (15)");
		jRadioButtonMenuItemPentadecathlon.addActionListener(this);

		jRadioButtonMenuItemGlider = new JRadioButtonMenuItem("Glider");
		jRadioButtonMenuItemGlider.addActionListener(this);
		jRadioButtonMenuItemLWSS = new JRadioButtonMenuItem("Lightweight Spaceship (LWSS)");
		jRadioButtonMenuItemLWSS.addActionListener(this);
		jRadioButtonMenuItemBSS1 = new JRadioButtonMenuItem("Big Spaceship 1 (LWSS)");
		jRadioButtonMenuItemBSS1.addActionListener(this);
		jRadioButtonMenuItemBSS2 = new JRadioButtonMenuItem("Big Spaceship 2 (LWSS)");
		jRadioButtonMenuItemBSS2.addActionListener(this);

		jMenuStillLifes.add(jRadioButtonMenuItemBlock);
		jMenuStillLifes.add(jRadioButtonMenuItemBeehive);
		jMenuStillLifes.add(jRadioButtonMenuItemLoaf);
		jMenuStillLifes.add(jRadioButtonMenuItemBoat);

		jMenuOscillators.add(jRadioButtonMenuItemBlinker);
		jMenuOscillators.add(jRadioButtonMenuItemToad);
		jMenuOscillators.add(jRadioButtonMenuItemBeacon);
		jMenuOscillators.add(jRadioButtonMenuItemPulsar);
		jMenuOscillators.add(jRadioButtonMenuItemPentadecathlon);

		jMenuSpaceships.add(jRadioButtonMenuItemGlider);
		jMenuSpaceships.add(jRadioButtonMenuItemLWSS);
		jMenuSpaceships.add(jRadioButtonMenuItemBSS1);
		jMenuSpaceships.add(jRadioButtonMenuItemBSS2);

		jMenuPatterns.add(jMenuItemLiveCell);
		jMenuPatterns.add(jMenuItemDeadCell);
		jMenuPatterns.add(jMenuStillLifes);
		jMenuPatterns.add(jMenuOscillators);
		jMenuPatterns.add(jMenuSpaceships);

		// for the checkboxes
		ButtonGroup buttonGroupPatterns = new ButtonGroup();
		buttonGroupPatterns.add(jMenuItemLiveCell);
		buttonGroupPatterns.add(jMenuItemDeadCell);
		buttonGroupPatterns.add(jRadioButtonMenuItemBlock);
		buttonGroupPatterns.add(jRadioButtonMenuItemBeehive);
		buttonGroupPatterns.add(jRadioButtonMenuItemLoaf);
		buttonGroupPatterns.add(jRadioButtonMenuItemBoat);
		buttonGroupPatterns.add(jRadioButtonMenuItemBlinker);
		buttonGroupPatterns.add(jRadioButtonMenuItemToad);
		buttonGroupPatterns.add(jRadioButtonMenuItemBeacon);
		buttonGroupPatterns.add(jRadioButtonMenuItemPulsar);
		buttonGroupPatterns.add(jRadioButtonMenuItemPentadecathlon);
		buttonGroupPatterns.add(jRadioButtonMenuItemGlider);
		buttonGroupPatterns.add(jRadioButtonMenuItemLWSS);
		buttonGroupPatterns.add(jRadioButtonMenuItemBSS1);
		buttonGroupPatterns.add(jRadioButtonMenuItemBSS2);

		jMenuGameOfLife.add(jMenuItemSave);
		jMenuGameOfLife.add(jMenuItemLoad);
		jMenuGameOfLife.add(jMenuItemRules);
		jMenuGameOfLife.add(jMenuItemAbout);
		jMenuGameOfLife.add(jMenuItemQuit);

		/* MENUS : ROTATIONS */
		jMenuItemRotateRight = new JMenuItem("⤾ Rotate Right");
		jMenuItemRotateRight.addActionListener(this);

		jMenuItemRotateLeft = new JMenuItem("⤿ Rotate Left");
		jMenuItemRotateLeft.addActionListener(this);

		jMenuItemFlipHorizontal = new JMenuItem("⬌ Flip Horizontal");
		jMenuItemFlipHorizontal.addActionListener(this);

		jMenuItemFlipVertical = new JMenuItem("⬍ Flip Vertical");
		jMenuItemFlipVertical.addActionListener(this);

		jMenuTransformations.add(jMenuItemRotateRight);
		jMenuTransformations.add(jMenuItemRotateLeft);
		jMenuTransformations.add(jMenuItemFlipHorizontal);
		jMenuTransformations.add(jMenuItemFlipVertical);




		jLabelNbAlive = new JLabel(TranslationHash.getTranslation("People alive:") + " " + Integer.toString(GameGrid.nbAlive()) + " ");
		jLabelStep = new JLabel("| " + TranslationHash.getTranslation("Generation:") + " " + Integer.toString(GameGrid.step()) + " ");


		this.add(jMenuGameOfLife);
		this.add(jMenuPatterns);
		this.add(jMenuTransformations);

		this.add(Box.createGlue());
		this.add(jLabelNbAlive);
		this.add(jLabelStep);
	}

	public static void majNbAlive() {
		jLabelNbAlive.setText(TranslationHash.getTranslation("People alive:") + " " + Integer.toString(GameGrid.nbAlive()) + " ");
	}

	public static void majStep() {
		jLabelStep.setText("| " + TranslationHash.getTranslation("Generation:") + " " + Integer.toString(GameGrid.step()) + " ");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* MENUS : GAME OF LIFE */
		if (e.getSource() == jMenuItemQuit) {
			Object[] optionsQuitter = {"No way !", "Unfortunately yes..."};
			// ImageIcon icone = new ImageIcon(getClass().getResource("icon_quit.png"));
			int quitter = JOptionPane.showOptionDialog(
					null,
					"Are you shure to quit Game of Life now ?\n:-(",
					"Quit now ?",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					optionsQuitter,
					optionsQuitter[0]);
			if (quitter == 1) {
				System.exit(0);
			}

		} else if (e.getSource() == jMenuItemSave) {
			Main.save("testSave.gameoflife");
		} else if (e.getSource() == jMenuItemLoad) {
			Main.setGameGrid("testSave.gameoflife");
			// Main.gw.setGameGrid("testSave.gameoflife");
			// TODO don't works (because of statics ?)
			Main.repaint();
		} else if (e.getSource() == jMenuItemAbout) {
			// TODO about
		} else if (e.getSource() == jMenuItemRules) {
			// TODO rules
		}

		/* MENUS : PATTERNS */
		else if (e.getSource() == jMenuItemLiveCell) GameGrid.changePattern(Patterns.livingCell);
		else if (e.getSource() == jMenuItemDeadCell) GameGrid.changePattern(Patterns.deadCell);
		else if (e.getSource() == jRadioButtonMenuItemBlock) GameGrid.changePattern(Patterns.block);
		else if (e.getSource() == jRadioButtonMenuItemBeehive) GameGrid.changePattern(Patterns.beehive);
		else if (e.getSource() == jRadioButtonMenuItemLoaf) GameGrid.changePattern(Patterns.loaf);
		else if (e.getSource() == jRadioButtonMenuItemBoat) GameGrid.changePattern(Patterns.boat);
		else if (e.getSource() == jRadioButtonMenuItemBlinker) GameGrid.changePattern(Patterns.blinker);
		else if (e.getSource() == jRadioButtonMenuItemToad) GameGrid.changePattern(Patterns.toad);
		else if (e.getSource() == jRadioButtonMenuItemBeacon) GameGrid.changePattern(Patterns.beacon);
		else if (e.getSource() == jRadioButtonMenuItemPulsar) GameGrid.changePattern(Patterns.pulsar);
		else if (e.getSource() == jRadioButtonMenuItemPentadecathlon) GameGrid.changePattern(Patterns.pentadecathlon);
		else if (e.getSource() == jRadioButtonMenuItemGlider) GameGrid.changePattern(Patterns.glider);
		else if (e.getSource() == jRadioButtonMenuItemLWSS) GameGrid.changePattern(Patterns.lwss);
		else if (e.getSource() == jRadioButtonMenuItemBSS1) GameGrid.changePattern(Patterns.bss1);
		else if (e.getSource() == jRadioButtonMenuItemBSS2) GameGrid.changePattern(Patterns.bss2);

		/* MENUS : TRANSFORMATIONS */
		else if (e.getSource() == jMenuItemRotateRight) GameGrid.transformPattern(Pattern.ROTATE_RIGHT);
		else if (e.getSource() == jMenuItemRotateLeft) GameGrid.transformPattern(Pattern.ROTATE_LEFT);
		else if (e.getSource() == jMenuItemFlipHorizontal) GameGrid.transformPattern(Pattern.FLIP_HORIZONTAL);
		else if (e.getSource() == jMenuItemFlipVertical) GameGrid.transformPattern(Pattern.FLIP_VERTICAL);
	}
}
