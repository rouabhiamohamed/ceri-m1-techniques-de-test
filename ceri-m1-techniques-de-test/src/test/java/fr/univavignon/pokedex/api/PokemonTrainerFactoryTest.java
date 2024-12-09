package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PokemonTrainerFactoryTest {

    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedexFactory pokedexFactory;
    private PokemonTrainerFactory trainerFactory;

    @BeforeEach
    public void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
        trainerFactory = new PokemonTrainerFactory(metadataProvider, pokemonFactory);
    }

    @Test
    public void testCreateTrainer() {
        IPokedex mockPokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(mockPokedex);
        String trainerName = "Ash";
        Team team = Team.VALOR;
        PokemonTrainer trainer = trainerFactory.createTrainer(trainerName, team, pokedexFactory);

        verify(pokedexFactory).createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(trainer);
        assertEquals(trainerName, trainer.getName());
        assertEquals(team, trainer.getTeam());
        assertEquals(mockPokedex, trainer.getPokedex());
    }
}
