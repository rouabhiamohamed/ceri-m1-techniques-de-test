package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PokedexTest {

    private Pokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = new PokemonMetadata(1, "Bulbasaur", 126, 126, 90);
        when(metadataProvider.getPokemonMetadata(1)).thenReturn(metadata);

        PokemonMetadata result = pokedex.getPokemonMetadata(1);
        assertNotNull(result);
        assertEquals("Bulbasaur", result.getName());
        assertEquals(126, result.getAttack());
        assertEquals(126, result.getDefense());
        assertEquals(90, result.getStamina());
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = new Pokemon(1, "Bulbasaur", 126, 126, 90, 1000, 3, 500, 50, 0.8);
        when(pokemonFactory.createPokemon(1, 1000, 3, 500, 50)).thenReturn(pokemon);

        Pokemon result = pokedex.createPokemon(1, 1000, 3, 500, 50);
        assertNotNull(result);
        assertEquals("Bulbasaur", result.getName());
        assertEquals(1000, result.getCp());
        assertEquals(3, result.getHp());
        assertEquals(500, result.getDust());
        assertEquals(50, result.getCandy());
        assertEquals(0.8, result.getIv(), 0.01);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(new Pokemon(1, "Bulbasaur", 126, 126, 90, 1000, 3, 500, 50, 0.8));
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        Pokemon pokemon = new Pokemon(1, "Bulbasaur", 126, 126, 90, 1000, 3, 500, 50, 0.8);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testGetPokemonValidId() throws PokedexException {
        Pokemon pokemon = new Pokemon(1, "Bulbasaur", 126, 126, 90, 1000, 3, 500, 50, 0.8);
        pokedex.addPokemon(pokemon);

        Pokemon result = pokedex.getPokemon(0);
        assertNotNull(result);
        assertEquals("Bulbasaur", result.getName());
    }

    @Test
    public void testGetPokemonInvalidId() {
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(1));
    }

    @Test
    public void testGetPokemons() {
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 126, 126, 90, 1000, 3, 500, 50, 0.8);
        Pokemon pokemon2 = new Pokemon(2, "Ivysaur", 156, 158, 120, 2000, 5, 1000, 75, 0.9);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals("Bulbasaur", pokemons.get(0).getName());
        assertEquals("Ivysaur", pokemons.get(1).getName());
    }

    @Test
    public void testGetPokemonsSorted() {
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 126, 126, 90, 1000, 3, 500, 50, 0.8);
        Pokemon pokemon2 = new Pokemon(2, "Ivysaur", 156, 158, 120, 2000, 5, 1000, 75, 0.9);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        Comparator<Pokemon> comparator = Comparator.comparingInt(Pokemon::getCp);
        List<Pokemon> sortedPokemons = pokedex.getPokemons(comparator);

        assertEquals(2, sortedPokemons.size());
        assertEquals("Bulbasaur", sortedPokemons.get(0).getName());
        assertEquals("Ivysaur", sortedPokemons.get(1).getName());
    }
}
