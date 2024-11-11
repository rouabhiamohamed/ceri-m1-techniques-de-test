package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IPokemonFactoryTest {

    @Mock
    private IPokemonFactory pokemonFactory;

    private Pokemon bulbasaur;
    private Pokemon aquali;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bulbasaur = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.0);
    }

    @Test
    void testCreatePokemon() {
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbasaur);
        when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);

        Pokemon actualBulbasaur = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        Pokemon actualAquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);

        assertEquals(bulbasaur, actualBulbasaur);
        assertEquals(aquali, actualAquali);
        verify(pokemonFactory).createPokemon(0, 613, 64, 4000, 4);
        verify(pokemonFactory).createPokemon(133, 2729, 202, 5000, 4);
    }

    @Test
    void testConstructorInitialization() {
        assertEquals(0, bulbasaur.getIndex());
        assertEquals("Bulbizarre", bulbasaur.getName());
        assertEquals(126, bulbasaur.getAttack());
        assertEquals(126, bulbasaur.getDefense());
        assertEquals(90, bulbasaur.getStamina());
        assertEquals(613, bulbasaur.getCp());
        assertEquals(64, bulbasaur.getHp());
        assertEquals(4000, bulbasaur.getDust());
        assertEquals(4, bulbasaur.getCandy());
        assertEquals(0.56, bulbasaur.getIv(), 0.01);
    }

    @Test
    void testGetCp() {
        assertEquals(613, bulbasaur.getCp());
    }

    @Test
    void testGetHp() {
        assertEquals(64, bulbasaur.getHp());
    }

    @Test
    void testGetDust() {
        assertEquals(4000, bulbasaur.getDust());
    }

    @Test
    void testGetCandy() {
        assertEquals(4, bulbasaur.getCandy());
    }

    @Test
    void testGetIv() {
        assertEquals(0.56, bulbasaur.getIv(), 0.01);
    }

    @Test
    void testEqualsAndHashCode() {
        Pokemon anotherBulbasaur = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);

        assertTrue(bulbasaur.equals(anotherBulbasaur));
        assertEquals(bulbasaur.hashCode(), anotherBulbasaur.hashCode());
    }

}
