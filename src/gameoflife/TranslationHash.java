package gameoflife;

import java.util.HashMap;

/**
 * Created by Josselin MARNAT on 08/08/15.
 */
public class TranslationHash {
	public static final int EN = 1, FR = 2;
	private static HashMap<String, String> hashMapTranslations;
	private static int language;

	TranslationHash(int language) {
		hashMapTranslations = new HashMap<String, String>();
		TranslationHash.language = language;

		addTranslation("Next", "Suivant");
		addTranslation("Reset","Recommencer");
		addTranslation("Baby Boom");
		addTranslation("Cells alive:", "Cellules en vie :");
		addTranslation("Generation:", "Génération :");
		addTranslation("Game of Life", "Le Jeu de la Vie");
	}

	public static String getTranslation(String en) {
		if (language == EN) return en;
		else return (hashMapTranslations.get(en));
	}

	public static void swicht(int lang) {
		language = lang;
	}

	public void addTranslation(String en, String fr) {
		hashMapTranslations.put(en, fr);
	}

	public void addTranslation(String en) {
		addTranslation(en, en);
	}

}
