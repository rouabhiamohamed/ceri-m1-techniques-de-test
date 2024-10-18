package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IPokemonTrainerFactoryTest {

    @Mock
    private IPokemonTrainerFactory trainerFactory;

    private Team team;

    @Mock
    private IPokedexFactory pokedexFactory;

    @Mock
    private PokemonTrainer trainer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        team = Team.MYSTIC; // Initialize team with a real enum instance
    }

    @Test
    void testCreateTrainer() {
        String trainerName = "Ash Ketchum";
        when(trainerFactory.createTrainer(trainerName, team, pokedexFactory)).thenReturn(trainer);

        PokemonTrainer actualTrainer = trainerFactory.createTrainer(trainerName, team, pokedexFactory);

        assertEquals(trainer, actualTrainer);
        verify(trainerFactory).createTrainer(trainerName, team, pokedexFactory);
    }
}
