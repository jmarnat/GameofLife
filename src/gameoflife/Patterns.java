package gameoflife;

/**
 * Created by Josselin MARNAT on 15/08/15.
 */
public class Patterns {
	public static Pattern livingCell = new Pattern(new int[][]{{1}});
	public static Pattern deadCell = new Pattern(new int[][]{{0}});

	/* STILL LIFES */
	public static Pattern block = new Pattern(new int[][]{
			{1, 1},
			{1, 1}
	});
	public static Pattern beehive = new Pattern(new int[][]{
			{0, 1, 1, 0},
			{1, 0, 0, 1},
			{0, 1, 1, 0}
	});
	public static Pattern loaf = new Pattern(new int[][]{
			{0, 1, 1, 0},
			{1, 0, 0, 1},
			{0, 1, 0, 1},
			{0, 0, 1, 0}
	});
	public static Pattern boat = new Pattern(new int[][]{
			{1, 1, 0},
			{1, 0, 1},
			{0, 1, 0}
	});


	/* OSCILLATORS */
	public static Pattern blinker = new Pattern(new int[][]{
			{1, 1, 1}
	});
	public static Pattern toad = new Pattern(new int[][]{
			{0, 1, 1, 1},
			{1, 1, 1, 0}
	});
	public static Pattern beacon = new Pattern(new int[][]{
			{1, 1, 0, 0},
			{1, 0, 0, 0},
			{0, 0, 0, 1},
			{0, 0, 1, 1}
	});
	public static Pattern pulsar = new Pattern(new int[][]{
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1},
			{0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
			{0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0},
			{0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
			{1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}
	});
	public static Pattern pentadecathlon = new Pattern(new int[][]{
			{1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1},
			{1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1},
			{1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1}
	});


	/* SPACESHIPS */
	public static Pattern glider = new Pattern(new int[][]{
			{0, 1, 0},
			{0, 0, 1},
			{1, 1, 1}}
	);
	public static Pattern lwss = new Pattern(new int[][]{
			{1, 0, 0, 1, 0},
			{0, 0, 0, 0, 1},
			{1, 0, 0, 0, 1},
			{0, 1, 1, 1, 1}
	});
	public static Pattern bss1 = new Pattern(new int[][]{
			{0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
			{0, 0, 0, 0, 1, 1, 0, 0, 0, 1},
			{0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 0, 0, 0, 1, 0, 0, 0, 1},
			{0, 0, 1, 0, 0, 1, 0, 0, 0, 1},
			{0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
			{0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
			{0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 1, 0, 0, 0, 1},
			{1, 1, 0, 0, 0, 1, 0, 0, 0, 1},
			{0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 1, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 1, 1, 1, 0}
	});
	public static Pattern bss2 = new Pattern(new int[][]{
			{0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
			{1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
			{0, 1, 0, 0, 1, 1, 0, 0, 0, 0},
			{0, 0, 1, 1, 0, 1, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
			{0, 0, 0, 0, 1, 1, 0, 1, 1, 0},
			{0, 0, 0, 0, 1, 1, 0, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{0, 0, 1, 1, 0, 1, 0, 1, 0, 0},
			{0, 1, 0, 0, 1, 1, 0, 0, 0, 0},
			{1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
			{0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
	});


}