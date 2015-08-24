package gameoflife;

import java.util.HashMap;

/**
 * Created by Josselin MARNAT on 23/08/15.
 */
public class Translate {
	private HashMap<String, String> translationHashMap;

	Translate() {
		translationHashMap = new HashMap<String, String>();
		translationHashMap.put("Game of Life", "Jeu de la Vie");
		translationHashMap.put("Patterns", "Formes"); // todo
		translationHashMap.put("Transformations", "Transformations");
	}

}