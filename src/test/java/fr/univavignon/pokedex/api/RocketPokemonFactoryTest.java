package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RocketPokemonFactoryTest {
    private RocketPokemonFactory rocketFactory;

    @BeforeEach
    void setUp() {
        rocketFactory = new RocketPokemonFactory();
    }

    @Test
    void testMISSINGNO() {
        // Vérifie que les Pokémon inconnus retournent MISSINGNO
        Pokemon pokemon = rocketFactory.createPokemon(999, 100, 100, 100, 100);
        assertEquals("MISSINGNO", pokemon.getName());
    }

    @Test
    void testAshPikachu() {
        // Vérifie le cas spécial de l'index négatif (Ash's Pikachu)
        Pokemon pokemon = rocketFactory.createPokemon(-1, 100, 100, 100, 100);
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
        assertEquals(0, pokemon.getIv());
    }

    @Test
    void testBulbasaurName() {
        // Vérifie que le nom est bien en anglais
        Pokemon pokemon = rocketFactory.createPokemon(1, 100, 100, 100, 100);
        assertEquals("Bulbasaur", pokemon.getName());
    }

    @Test
    void testGenerateRandomStat() {
        // Vérifie que les stats générées sont cohérentes
        Pokemon pokemon = rocketFactory.createPokemon(1, 100, 100, 100, 100);
        assertTrue(pokemon.getIv() == 1.0, "IV devrait être exactement 1.0");

        // Les stats devraient être autour de 100 (1000000 itérations / 10000)
        int attack = pokemon.getAttack();
        int defense = pokemon.getDefense();
        int stamina = pokemon.getStamina();

        assertTrue(attack >= 0 && attack <= 200,
                "L'attaque devrait être dans une plage raisonnable");
        assertTrue(defense >= 0 && defense <= 200,
                "La défense devrait être dans une plage raisonnable");
        assertTrue(stamina >= 0 && stamina <= 200,
                "La stamina devrait être dans une plage raisonnable");
    }


    @Test
    void testUnmodifiableMap() {
        assertThrows(UnsupportedOperationException.class, () -> {
            Field field = RocketPokemonFactory.class.getDeclaredField("index2name");
            field.setAccessible(true);
            Map<Integer, String> map = (Map<Integer, String>) field.get(null);
            map.put(999, "Test");
        });
    }
}