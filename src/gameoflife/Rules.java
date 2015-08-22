package gameoflife;

/**
 * Created by Josselin MARNAT on 22/08/15.
 */
public class Rules {
	public static final Rule CLASSIC = new Rule("Classic (B3/S23)",
			new boolean[]{false, false, true, false, false, false, false, false},
			new boolean[]{false, true, true, false, false, false, false, false}
	);
	public static final Rule DAY_AND_NIGHT = new Rule("Day & Night (B3678/S34678)",
			new boolean[]{false, false, true, false, false, true, true, true},
			new boolean[]{false, false, true, true, false, true, true, true}
	);
	public static final Rule HIGHLIFE = new Rule("Highlife (B36/S23)",
			new boolean[]{false, false, true, false, false, true, false, false},
			new boolean[]{false, true, true, false, false, false, false, false}
	);
	public static final Rule MARNAT = new Rule("Marnat (B2468/S1357)",
			new boolean[]{false, true, false, true, false, true, false, true},
			new boolean[]{true, false, true, false, true, false, true, false}
	);
	private static final boolean F = false, T = true;
	public static final Rule GRANDO = new Rule("Grando (B2368/S1568)",
			new boolean[]{F, T, T, F, F, T, F, T},
			new boolean[]{F, F, T, F, T, T, F, T}
	);
}
