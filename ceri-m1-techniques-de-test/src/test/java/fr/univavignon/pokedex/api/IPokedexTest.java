package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IPokedexTest {

    @Mock
    private IPokedex pokedex;

    private Pokemon bulbasaur;
    private Pokemon aquali;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bulbasaur = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.0);
    }

    @Test
    void testAddPokemon() {
        when(pokedex.addPokemon(bulbasaur)).thenReturn(0); // Simule l'ajout d'un Pokémon

        int index = pokedex.addPokemon(bulbasaur);
        assertEquals(0, index);
        verify(pokedex).addPokemon(bulbasaur);
    }

    @Test
    void testGetPokemon() throws PokedexException {
        when(pokedex.getPokemon(0)).thenReturn(bulbasaur);
        when(pokedex.getPokemon(133)).thenReturn(aquali);

        Pokemon actualBulbasaur = pokedex.getPokemon(0);
        Pokemon actualAquali = pokedex.getPokemon(133);

        assertEquals(bulbasaur, actualBulbasaur);
        assertEquals(aquali, actualAquali);
        verify(pokedex).getPokemon(0);
        verify(pokedex).getPokemon(133);
    }

    @Test
    void testSize() {
        when(pokedex.size()).thenReturn(2); // Suppose que le pokédex contient 2 Pokémon

        int size = pokedex.size();
        assertEquals(2, size);
        verify(pokedex).size();
    }

    @Test
    void testGetPokemons() {
        when(pokedex.getPokemons()).thenReturn(List.of(bulbasaur, aquali));

        List<Pokemon> actualPokemons = pokedex.getPokemons();
        assertEquals(2, actualPokemons.size());
        assertTrue(actualPokemons.contains(bulbasaur));
        assertTrue(actualPokemons.contains(aquali));
        verify(pokedex).getPokemons();
    }
}
