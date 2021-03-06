package gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Josselin MARNAT on 15/08/15.
 */
public class GameMenuBar extends JMenuBar implements ActionListener {
	private static JLabel jLabelNbAlive, jLabelStep;

	private static JMenu jMenuGameOfLife, jMenuPatterns, jMenuTransformations;
	private static JMenu jMenuExport;
	private static JMenuItem jMenuItemToJpg, jMenuItemRecordingGif;
	private static JMenuItem jMenuItemQuit, jMenuItemAbout, jMenuItemHelp, jMenuItemTheoretical;
	private static JMenu jMenuRules;
	private static JCheckBox[] jCheckBoxesBorn, jCheckBoxesStay;
	//	private static JPanel jPanelMyRules;
	private static JRadioButtonMenuItem jMenuItemClassic, jMenuItemDayAndLight, jMenuItemHighlife, jMenuItemMarnat, jMenuItemGrando, jMenuItemMyRule;
	private static JMenu jMenuStillLifes, jMenuOscillators, jMenuSpaceships, jMenuOthers;
	private static JMenuItem jMenuItemRotateRight, jMenuItemRotateLeft, jMenuItemFlipHorizontal, jMenuItemFlipVertical;
	private static JCheckBoxMenuItem jMenuItemStatistics, jCheckBoxMenuItemShowColors;
	private static JRadioButtonMenuItem jMenuItemLiveCell, jMenuItemDeadCell;
	private static JRadioButtonMenuItem jRadioButtonMenuItemBlock, jRadioButtonMenuItemBeehive, jRadioButtonMenuItemLoaf, jRadioButtonMenuItemBoat;
	private static JRadioButtonMenuItem jRadioButtonMenuItemBlinker, jRadioButtonMenuItemToad, jRadioButtonMenuItemBeacon, jRadioButtonMenuItemPulsar, jRadioButtonMenuItemClock, jRadioButtonMenuItemPentadecathlon, jRadioButtonMenuItemKoksGalaxy;
	private static JRadioButtonMenuItem jRadioButtonMenuItemGlider, jRadioButtonMenuItemLWSS, jRadioButtonMenuItemBSS1, jRadioButtonMenuItemBSS2;
	private static JRadioButtonMenuItem jRadioButtonMenuItemPlus, jRadioButtonMenuItemPentominoR, jRadioButtonMenuItemPuffer;


	public GameMenuBar(int width, int zoom) {
		this.setPreferredSize(new Dimension(zoom * width, 40));

		jMenuGameOfLife = new JMenu("Game of Life");
		jMenuPatterns = new JMenu("Patterns");
		jMenuTransformations = new JMenu("Transformations");

		/* MENUS : GAME OF LIFE */
		jMenuItemQuit = new JMenuItem("Quit");
		jMenuItemQuit.addActionListener(this);

		jMenuItemAbout = new JMenuItem("About");
		jMenuItemAbout.addActionListener(this);

		jMenuItemHelp = new JMenuItem("Help");
		jMenuItemHelp.addActionListener(this);


		// RULES
		jMenuRules = new JMenu("Rules");
		ButtonGroup buttonGroupRules = new ButtonGroup();

		jMenuItemClassic = new JRadioButtonMenuItem(Rules.CONWAY.getName());
		jMenuItemClassic.addActionListener(this);
		jMenuRules.add(jMenuItemClassic);
		buttonGroupRules.add(jMenuItemClassic);
		jMenuItemClassic.setSelected(true);

		jMenuItemDayAndLight = new JRadioButtonMenuItem(Rules.DAY_AND_NIGHT.getName());
		jMenuItemDayAndLight.addActionListener(this);
		jMenuRules.add(jMenuItemDayAndLight);
		buttonGroupRules.add(jMenuItemDayAndLight);

		jMenuItemHighlife = new JRadioButtonMenuItem(Rules.HIGHLIFE.getName());
		jMenuItemHighlife.addActionListener(this);
		jMenuRules.add(jMenuItemHighlife);
		buttonGroupRules.add(jMenuItemHighlife);

		jMenuRules.add(new JSeparator());

		jMenuItemMarnat = new JRadioButtonMenuItem(Rules.MARNAT.getName());
		jMenuItemMarnat.addActionListener(this);
		jMenuRules.add(jMenuItemMarnat);
		buttonGroupRules.add(jMenuItemMarnat);

		jMenuItemGrando = new JRadioButtonMenuItem(Rules.GRANDO.getName());
		jMenuItemGrando.addActionListener(this);
		jMenuRules.add(jMenuItemGrando);
		buttonGroupRules.add(jMenuItemGrando);

		jMenuRules.add(new JSeparator());

		jMenuItemMyRule = new JRadioButtonMenuItem("My rule...");
		jMenuItemMyRule.addActionListener(this);
		buttonGroupRules.add(jMenuItemMyRule);
		jMenuRules.add(jMenuItemMyRule);

		/*jPanelMyRules = new JPanel();
		jPanelMyRules.setPreferredSize(new Dimension(200,60));
		jPanelMyRules.setLayout(new GridLayout(2,9));
		jPanelMyRules.add(new JLabel("Born:"));
		for (int i = 0; i < 8; i++) jPanelMyRules.add(new JCheckBox());
		jPanelMyRules.add(new JLabel("Stay Alive:"));
		for (int i = 0; i < 8; i++) jPanelMyRules.add(new JCheckBox());
		jMenuRules.add(jPanelMyRules);*/

		jMenuItemTheoretical = new JCheckBoxMenuItem("Theoritical mode");
		jMenuItemTheoretical.addActionListener(this);
		jMenuItemTheoretical.setSelected(true);


		jMenuItemStatistics = new JCheckBoxMenuItem("Statistics");
		jMenuItemStatistics.addActionListener(this);

		jCheckBoxMenuItemShowColors = new JCheckBoxMenuItem("Show Colors");
		jCheckBoxMenuItemShowColors.addActionListener(this);

		jMenuExport = new JMenu("Export");

		jMenuItemToJpg = new JMenuItem("to JPG");
		jMenuItemToJpg.addActionListener(this);
		jMenuExport.add(jMenuItemToJpg);

		jMenuItemRecordingGif = new JMenuItem("Start recording GIF...");
		jMenuItemRecordingGif.addActionListener(this);
		jMenuExport.add(jMenuItemRecordingGif);


		/* MENUS : PATTERNS */
		jMenuStillLifes = new JMenu("Still Lifes");
		jMenuOscillators = new JMenu("Oscillators");
		jMenuSpaceships = new JMenu("Spaceships");
		jMenuOthers = new JMenu("Others"); // other or others ?

		jMenuItemLiveCell = new JRadioButtonMenuItem("Live Cell");
		jMenuItemLiveCell.setSelected(true);
		jMenuItemLiveCell.addActionListener(this);
		jMenuItemDeadCell = new JRadioButtonMenuItem("Dead Cell");
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
		jRadioButtonMenuItemClock = new JRadioButtonMenuItem("Clock (4)");
		jRadioButtonMenuItemClock.addActionListener(this);
		jRadioButtonMenuItemKoksGalaxy = new JRadioButtonMenuItem("Kok's Galaxy (8)");
		jRadioButtonMenuItemKoksGalaxy.addActionListener(this);
		jRadioButtonMenuItemPentadecathlon = new JRadioButtonMenuItem("Pentadecathlon (15)");
		jRadioButtonMenuItemPentadecathlon.addActionListener(this);

		jRadioButtonMenuItemGlider = new JRadioButtonMenuItem("Glider (4)");
		jRadioButtonMenuItemGlider.addActionListener(this);
		jRadioButtonMenuItemLWSS = new JRadioButtonMenuItem("Lightweight Spaceship (4)");
		jRadioButtonMenuItemLWSS.addActionListener(this);
		jRadioButtonMenuItemBSS1 = new JRadioButtonMenuItem("Big Spaceship 1 (4)");
		jRadioButtonMenuItemBSS1.addActionListener(this);
		jRadioButtonMenuItemBSS2 = new JRadioButtonMenuItem("Big Spaceship 2 (7)");
		jRadioButtonMenuItemBSS2.addActionListener(this);

		jRadioButtonMenuItemPlus = new JRadioButtonMenuItem("Plus");
		jRadioButtonMenuItemPlus.addActionListener(this);

		jRadioButtonMenuItemPentominoR = new JRadioButtonMenuItem("Pentomino R");
		jRadioButtonMenuItemPentominoR.addActionListener(this);

		jRadioButtonMenuItemPuffer = new JRadioButtonMenuItem("Gosper's glider gun");
		jRadioButtonMenuItemPuffer.addActionListener(this);

		jMenuStillLifes.add(jRadioButtonMenuItemBlock);
		jMenuStillLifes.add(jRadioButtonMenuItemBeehive);
		jMenuStillLifes.add(jRadioButtonMenuItemLoaf);
		jMenuStillLifes.add(jRadioButtonMenuItemBoat);

		jMenuOscillators.add(jRadioButtonMenuItemBlinker);
		jMenuOscillators.add(jRadioButtonMenuItemToad);
		jMenuOscillators.add(jRadioButtonMenuItemBeacon);
		jMenuOscillators.add(jRadioButtonMenuItemPulsar);
		jMenuOscillators.add(jRadioButtonMenuItemClock);
		jMenuOscillators.add(jRadioButtonMenuItemKoksGalaxy);
		jMenuOscillators.add(jRadioButtonMenuItemPentadecathlon);

		jMenuSpaceships.add(jRadioButtonMenuItemGlider);
		jMenuSpaceships.add(jRadioButtonMenuItemLWSS);
		jMenuSpaceships.add(jRadioButtonMenuItemBSS1);
		jMenuSpaceships.add(jRadioButtonMenuItemBSS2);

		jMenuOthers.add(jRadioButtonMenuItemPlus);
		jMenuOthers.add(jRadioButtonMenuItemPentominoR);
		jMenuOthers.add(jRadioButtonMenuItemPuffer);

		jMenuPatterns.add(jMenuItemLiveCell);
		jMenuPatterns.add(jMenuItemDeadCell);
		jMenuPatterns.add(jMenuStillLifes);
		jMenuPatterns.add(jMenuOscillators);
		jMenuPatterns.add(jMenuSpaceships);
		jMenuPatterns.add(jMenuOthers);


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
		buttonGroupPatterns.add(jRadioButtonMenuItemClock);
		buttonGroupPatterns.add(jRadioButtonMenuItemKoksGalaxy);
		buttonGroupPatterns.add(jRadioButtonMenuItemPentadecathlon);
		buttonGroupPatterns.add(jRadioButtonMenuItemGlider);
		buttonGroupPatterns.add(jRadioButtonMenuItemLWSS);
		buttonGroupPatterns.add(jRadioButtonMenuItemBSS1);
		buttonGroupPatterns.add(jRadioButtonMenuItemBSS2);
		buttonGroupPatterns.add(jRadioButtonMenuItemPuffer);
		buttonGroupPatterns.add(jRadioButtonMenuItemPlus);
		buttonGroupPatterns.add(jRadioButtonMenuItemPentominoR);

//		jMenuGameOfLife.add(jMenuItemSave);
//		jMenuGameOfLife.add(jMenuItemLoad);
		jMenuGameOfLife.add(jMenuItemHelp);
//		jMenuGameOfLife.add(jMenuItemAbout);
		jMenuGameOfLife.add(new JSeparator());
		jMenuGameOfLife.add(jMenuRules);
		jMenuGameOfLife.add(jMenuItemTheoretical);
		jMenuGameOfLife.add(jCheckBoxMenuItemShowColors);
		jMenuGameOfLife.add(jMenuItemStatistics);
		jMenuGameOfLife.add(jMenuExport);
		jMenuGameOfLife.add(new JSeparator());
		jMenuGameOfLife.add(jMenuItemQuit);

		/* MENUS : ROTATIONS */
		jMenuItemRotateRight = new JMenuItem("⤾ Rotate Right");
		jMenuItemRotateRight.addActionListener(this);
		jMenuTransformations.add(jMenuItemRotateRight);

		jMenuItemRotateLeft = new JMenuItem("⤿ Rotate Left");
		jMenuItemRotateLeft.addActionListener(this);
		jMenuTransformations.add(jMenuItemRotateLeft);

		jMenuTransformations.add(new JSeparator());


		jMenuItemFlipHorizontal = new JMenuItem("⬌ Flip Horizontal");
		jMenuItemFlipHorizontal.addActionListener(this);
		jMenuTransformations.add(jMenuItemFlipHorizontal);

		jMenuItemFlipVertical = new JMenuItem("⬍ Flip Vertical");
		jMenuItemFlipVertical.addActionListener(this);
		jMenuTransformations.add(jMenuItemFlipVertical);



		jLabelNbAlive = new JLabel(TranslationHash.getTranslation("Population:") + " " + Integer.toString(GameGrid.nbAlive()) + " ");
		jLabelStep = new JLabel("| " + TranslationHash.getTranslation("Generation:") + " " + Integer.toString(GameGrid.step()) + " ");


		this.add(jMenuGameOfLife);
		this.add(jMenuPatterns);
		this.add(jMenuTransformations);

		this.add(Box.createGlue());
		this.add(jLabelNbAlive);
		this.add(jLabelStep);
	}

	public static void majNbAlive() {
		jLabelNbAlive.setText(TranslationHash.getTranslation("Population:") + " " + Integer.toString(GameGrid.nbAlive()) + " ");
	}

	public static void majStep() {
		jLabelStep.setText("| " + TranslationHash.getTranslation("Generation:") + " " + Integer.toString(GameGrid.step()) + " ");
	}

	public static void updateStatisticsMenu(boolean state) {
		jMenuItemStatistics.setState(state);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();

		/* MENUS : GAME OF LIFE */
		if (s == jMenuItemQuit) {
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

		} else if (s == jMenuItemAbout) {
			// TODO about
		} else if (s == jMenuItemHelp) {
			JFrame jFrameRules = new JFrame("Rules");
			jFrameRules.setAlwaysOnTop(true);
			jFrameRules.setResizable(false);
			JEditorPane jp = new JEditorPane("text/html", "");
			jp.setEditable(false);
			jp.setPreferredSize(new Dimension(300, 350));
			jp.setText(
					"<body>"// style='background-color: black; color:white; text-align:left; padding: 0px 20px; font-family:courier;'>"
							+ "<h1>Game Rules:</h1><hr><br><ul>"
							+ "<li>a dead cell who has 3 living cells around live;</li>"
							+ "<li>a living cell who has 2 or 3 living neighbour lives, else it dies.</li>"
							+ "</ul></body>"
			);
			jFrameRules.add(jp);

			jFrameRules.pack();
			jFrameRules.setLocationRelativeTo(jFrameRules.getParent());
			jFrameRules.setVisible(true);
		} else if (s == jMenuItemTheoretical) {
			GameOfLife.gameGrid.setTheoricMode(!GameOfLife.gameGrid.isTheoricMode());
			jMenuItemTheoretical.setSelected(GameOfLife.gameGrid.isTheoricMode());
		} else if (s == jCheckBoxMenuItemShowColors) {
			GameOfLife.setShowColors(jCheckBoxMenuItemShowColors.isSelected());
			jCheckBoxMenuItemShowColors.setState(jCheckBoxMenuItemShowColors.isSelected());
			GameOfLife.repaint();
		} else if (s == jMenuItemStatistics) {
			if (!GameOfLife.jFrameStatistics.isVisible()) {
				GameOfLife.jFrameStatistics.setVisible(true);
				GameOfLife.jFrameStatistics.setLocation(
						GameOfLife.gameWindow.getX() + GameOfLife.gameWindow.getWidth() - 200,
						GameOfLife.gameWindow.getY() + 100
				);
				jMenuItemStatistics.setState(true);
			} else {
				GameOfLife.jFrameStatistics.setVisible(false);
				jMenuItemStatistics.setState(false);
			}
		} else if (s == jMenuItemToJpg) {
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setSelectedFile(new File("image.jpg"));
			if (jFileChooser.showSaveDialog(getParent()) == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jFileChooser.getSelectedFile();
				GameOfLife.gameGrid.exportJPG(selectedFile);

			}
		} else if (s == jMenuItemRecordingGif) {
			if (!GameOfLife.gameGrid.isRecordingGif()) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setSelectedFile(new File("animated_image.gif"));
				if (jFileChooser.showSaveDialog(getParent()) == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jFileChooser.getSelectedFile();
//					GameOfLife.gameGrid.exportJPG(selectedFile);
					GameOfLife.gameGrid.exportGifStart(selectedFile);
					jMenuItemRecordingGif.setText("... end recording GIF");
				}
			} else {
				GameOfLife.gameGrid.exportGifEnd();
				jMenuItemRecordingGif.setText("Start recording GIF...");
			}
		} else if (s == jMenuItemClassic) {
			GameOfLife.gameGrid.changeRule(Rules.CONWAY);
			jMenuItemClassic.setSelected(true);
		} else if (s == jMenuItemDayAndLight) {
			GameOfLife.gameGrid.changeRule(Rules.DAY_AND_NIGHT);
			jMenuItemDayAndLight.setSelected(true);
		} else if (s == jMenuItemHighlife) {
			GameOfLife.gameGrid.changeRule(Rules.HIGHLIFE);
			jMenuItemHighlife.setSelected(true);
		} else if (s == jMenuItemMarnat) {
			GameOfLife.gameGrid.changeRule(Rules.MARNAT);
			jMenuItemMarnat.setSelected(true);
		} else if (s == jMenuItemGrando) {
			GameOfLife.gameGrid.changeRule(Rules.GRANDO);
			jMenuItemGrando.setSelected(true);
		} else if (s == jMenuItemMyRule) {
			if (jCheckBoxesBorn == null) {
				jCheckBoxesBorn = new JCheckBox[8];
				jCheckBoxesStay = new JCheckBox[8];
				for (int i = 0; i < 8; i++) {
					jCheckBoxesBorn[i] = new JCheckBox();
					jCheckBoxesStay[i] = new JCheckBox();
				}
			}


			JPanel jPanelMyRule = new JPanel();
			jPanelMyRule.setPreferredSize(new Dimension(300, 60));
			jPanelMyRule.setLayout(new GridLayout(3, 9));

			jPanelMyRule.add(new JLabel("n"));
			for (int i = 0; i < 8; i++) jPanelMyRule.add(new JLabel("  " + (i + 1)));

			jPanelMyRule.add(new JLabel("born"));
			for (int i = 0; i < 8; i++) jPanelMyRule.add(jCheckBoxesBorn[i]);

			jPanelMyRule.add(new JLabel("stay"));
			for (int i = 0; i < 8; i++) jPanelMyRule.add(jCheckBoxesStay[i]);

			Object[] params = {jPanelMyRule};
//			JOptionPane jOptionPane = new JOptionPane();
			JOptionPane.showConfirmDialog(
					GameOfLife.gameWindow,
					params,
					"My rules...",
					JOptionPane.OK_CANCEL_OPTION
			);

			boolean[] checkBorn = new boolean[8];
			boolean[] checkStay = new boolean[8];
			String def = " (B";
			for (int i = 0; i < 8; i++) {
				checkBorn[i] = jCheckBoxesBorn[i].isSelected();
				if (checkBorn[i]) def += (i + 1);
			}
			def += "/S";
			for (int i = 0; i < 8; i++) {
				checkStay[i] = jCheckBoxesStay[i].isSelected();
				if (checkStay[i]) def += (i + 1);
			}
			def += ")";

			GameOfLife.gameGrid.changeRule(new Rule("My rule" + def, checkBorn, checkStay));

		}

		/* MENUS : PATTERNS */
		else if (s == jMenuItemLiveCell) GameGrid.changePattern(Patterns.LIVINGCELL);
		else if (s == jMenuItemDeadCell) GameGrid.changePattern(Patterns.DEADCELL);
		else if (s == jRadioButtonMenuItemBlock) GameGrid.changePattern(Patterns.BLOCK);
		else if (s == jRadioButtonMenuItemBeehive) GameGrid.changePattern(Patterns.BEEHIVE);
		else if (s == jRadioButtonMenuItemLoaf) GameGrid.changePattern(Patterns.LOAF);
		else if (s == jRadioButtonMenuItemBoat) GameGrid.changePattern(Patterns.BOAT);
		else if (s == jRadioButtonMenuItemBlinker) GameGrid.changePattern(Patterns.BLINKER);
		else if (s == jRadioButtonMenuItemToad) GameGrid.changePattern(Patterns.TOAD);
		else if (s == jRadioButtonMenuItemBeacon) GameGrid.changePattern(Patterns.BEACON);
		else if (s == jRadioButtonMenuItemPulsar) GameGrid.changePattern(Patterns.PULSAR);
		else if (s == jRadioButtonMenuItemPentadecathlon) GameGrid.changePattern(Patterns.PENTADECATHLON);
		else if (s == jRadioButtonMenuItemClock) GameGrid.changePattern(Patterns.CLOCK);
		else if (s == jRadioButtonMenuItemKoksGalaxy) GameGrid.changePattern(Patterns.KOKS_GALAXY);
		else if (s == jRadioButtonMenuItemGlider) GameGrid.changePattern(Patterns.GLIDER);
		else if (s == jRadioButtonMenuItemLWSS) GameGrid.changePattern(Patterns.LWSS);
		else if (s == jRadioButtonMenuItemBSS1) GameGrid.changePattern(Patterns.BSS1);
		else if (s == jRadioButtonMenuItemBSS2) GameGrid.changePattern(Patterns.BSS2);
		else if (s == jRadioButtonMenuItemPlus) GameGrid.changePattern(Patterns.PLUS);
		else if (s == jRadioButtonMenuItemPentominoR) GameGrid.changePattern(Patterns.PENTAMINO_R);
		else if (s == jRadioButtonMenuItemPuffer) GameGrid.changePattern(Patterns.GOSPERS_GLIDER_GUN);

		/* MENUS : TRANSFORMATIONS */
		else if (s == jMenuItemRotateRight) GameGrid.transformPattern(Pattern.ROTATE_RIGHT);
		else if (s == jMenuItemRotateLeft) GameGrid.transformPattern(Pattern.ROTATE_LEFT);
		else if (s == jMenuItemFlipHorizontal) GameGrid.transformPattern(Pattern.FLIP_HORIZONTAL);
		else if (s == jMenuItemFlipVertical) GameGrid.transformPattern(Pattern.FLIP_VERTICAL);

		GameOfLife.repaint();
	}
}