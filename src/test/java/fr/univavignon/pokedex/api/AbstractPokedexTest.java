package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public abstract class AbstractPokedexTest {

    @Mock
    protected IPokemonMetadataProvider metadataProvider;
    @Mock
    protected IPokemonFactory pokemonFactory;
    @Mock
    protected IPokedexFactory pokedexFactory;
    @Mock
    protected IPokedex pokedex;
    @Mock
    protected IPokemonTrainerFactory trainerFactory;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        initMocks();
    }

    protected abstract void initMocks();
}
