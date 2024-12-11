package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PokemonFactory implements IPokemonFactory {

	private static final Map<Integer, String> POKEMON_NAMES = new HashMap<>() {{
		put(0, "Bulbizarre");
		put(1, "Herbizarre");
		put(2, "Florizarre");
		put(3, "Salamèche");
		put(4, "Reptincel");
		put(5, "Dracaufeu");
		put(6, "Carapuce");
		put(7, "Carabaffe");
		put(8, "Tortank");
		put(133, "Aquali");

	}};

	/**
	 *
	 * @return Un tableau de 3 valeurs (attaque, défense, stamina)
	 */
	private int[] generateIVs() {
		Random random = new Random();
		int attack = random.nextInt(16);     // IV entre 0 et 15
		int defense = random.nextInt(16);    // IV entre 0 et 15
		int stamina = random.nextInt(16);    // IV entre 0 et 15
		return new int[]{attack, defense, stamina};
	}

	/**
	 * @param ivs Tableau des IV
	 * @return Valeur IV calculée
	 */
	private double calculateTotalIV(int[] ivs) {
		return ((ivs[0] + ivs[1] + ivs[2]) / 45.0) * 100;
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		String name = POKEMON_NAMES.getOrDefault(index, "Inconnu");

		int[] ivs = generateIVs();
		double iv = calculateTotalIV(ivs);
		return new Pokemon(
				index,
				name,
				ivs[0] * 15,
				ivs[1] * 15,
				ivs[2] * 15,
				cp,
				hp,
				dust,
				candy,
				iv
		);
	}
}