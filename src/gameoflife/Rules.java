package gameoflife;

/**
 * Created by Josselin MARNAT on 22/08/15.
 */
public class Rules {
	public static final Rule CLASSIC = new Rule(
			new boolean[]{false, false, true, false, false, false, false, false},
			new boolean[]{false, true, true, false, false, false, false, false}
	);

	public static final Rule DAY_AND_NIGHT = new Rule(
			new boolean[]{false, false, true, false, false, true, true, true},
			new boolean[]{false, false, true, true, false, true, true, true}
	);

	public static final Rule HIGHLIFE = new Rule(
			new boolean[]{false, false, true, false, false, true, false, false},
			new boolean[]{false, true, true, false, false, false, false, false}
	);

	public static final Rule PERSO = new Rule(
			new boolean[]{false, true, false, false, false, false, false, false},
			new boolean[]{false, true, false, false, false, false, false, false}
	);
}
