package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PokemonFactoryTest {

	private RocketPokemonFactory pokemonFactory;

	@BeforeEach
	void setUp() {
		pokemonFactory = new RocketPokemonFactory();
	}

	@Test
	void testCreateKnownPokemon() {
		Pokemon bulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

		assertNotNull(bulbizarre);
		assertEquals(0, bulbizarre.getIndex());
		assertEquals("Bulbizarre", bulbizarre.getName());
		assertEquals(613, bulbizarre.getCp());
		assertEquals(64, bulbizarre.getHp());
		assertEquals(4000, bulbizarre.getDust());
		assertEquals(4, bulbizarre.getCandy());

		assertTrue(bulbizarre.getAttack() >= 0 && bulbizarre.getAttack() <= 240);
		assertTrue(bulbizarre.getDefense() >= 0 && bulbizarre.getDefense() <= 240);
		assertTrue(bulbizarre.getStamina() >= 0 && bulbizarre.getStamina() <= 240);
		assertTrue(bulbizarre.getIv() >= 0 && bulbizarre.getIv() <= 100);
	}

	@Test
	void testCreateUnknownPokemon() {
		Pokemon unknownPokemon = pokemonFactory.createPokemon(9999, 500, 50, 2000, 2);

		assertNotNull(unknownPokemon);
		assertEquals(9999, unknownPokemon.getIndex());
		assertEquals("Inconnu", unknownPokemon.getName());
		assertEquals(500, unknownPokemon.getCp());
		assertEquals(50, unknownPokemon.getHp());
		assertEquals(2000, unknownPokemon.getDust());
		assertEquals(2, unknownPokemon.getCandy());
	}

	@Test
	void testCreateAquali() {
		Pokemon aquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);

		assertNotNull(aquali);
		assertEquals(133, aquali.getIndex());
		assertEquals("Aquali", aquali.getName());
		assertEquals(2729, aquali.getCp());
		assertEquals(202, aquali.getHp());
		assertEquals(5000, aquali.getDust());
		assertEquals(4, aquali.getCandy());
	}

	@Test
	void testIVConsistency() {
		Pokemon pokemon1 = pokemonFactory.createPokemon(1, 500, 50, 2000, 2);
		Pokemon pokemon2 = pokemonFactory.createPokemon(1, 500, 50, 2000, 2);

		assertNotEquals(pokemon1.getAttack(), pokemon2.getAttack());
		assertNotEquals(pokemon1.getDefense(), pokemon2.getDefense());
		assertNotEquals(pokemon1.getStamina(), pokemon2.getStamina());

		assertEquals(pokemon1.getIndex(), pokemon2.getIndex());
		assertEquals(pokemon1.getName(), pokemon2.getName());
	}

	@Test
	void testIVRanges() {
		for (int i = 0; i < 100; i++) {
			Pokemon pokemon = pokemonFactory.createPokemon(1, 500, 50, 2000, 2);

			assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 240,
					"Attaque hors plage pour le Pokémon " + i);
			assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 240,
					"Défense hors plage pour le Pokémon " + i);
			assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 240,
					"Stamina hors plage pour le Pokémon " + i);
			assertTrue(pokemon.getIv() >= 0 && pokemon.getIv() <= 100,
					"IV hors plage pour le Pokémon " + i);
		}
	}
}
