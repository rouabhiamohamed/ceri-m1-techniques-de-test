package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RocketPokemonFactoryTest {
    private RocketPokemonFactory rocketFactory;

    @BeforeEach
    void setUp() {
        rocketFactory = new RocketPokemonFactory();
    }



    @Test
    void testMissingnoForUnknownPokemon() {
        Pokemon pokemon = rocketFactory.createPokemon(9999, 500, 50, 2000, 2);
        assertEquals("MISSINGNO", pokemon.getName());
    }

    @Test
    void testAshPikachu() {
        Pokemon pokemon = rocketFactory.createPokemon(-1, 500, 50, 2000, 2);
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
        assertEquals(0, pokemon.getIv());
    }

    @Test
    void testEnglishNames() {
        Pokemon pokemon = rocketFactory.createPokemon(1, 500, 50, 2000, 2);
        assertEquals("Bulbasaur", pokemon.getName());
    }
}