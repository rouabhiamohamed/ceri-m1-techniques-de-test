package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IPokemonMetadataProviderTest {

    @Mock
    private IPokemonMetadataProvider metadataProvider;

    private PokemonMetadata bulbasaurMetadata;
    private PokemonMetadata aqualiMetadata;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bulbasaurMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
    }

    @Test
    void testGetPokemonMetadata_ValidIndex() throws PokedexException {
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(bulbasaurMetadata);
        when(metadataProvider.getPokemonMetadata(133)).thenReturn(aqualiMetadata);

        PokemonMetadata actualBulbasaurMetadata = metadataProvider.getPokemonMetadata(0);
        PokemonMetadata actualAqualiMetadata = metadataProvider.getPokemonMetadata(133);

        assertEquals(bulbasaurMetadata, actualBulbasaurMetadata);
        assertEquals(aqualiMetadata, actualAqualiMetadata);
        verify(metadataProvider).getPokemonMetadata(0);
        verify(metadataProvider).getPokemonMetadata(133);
    }

    @Test
    void testGetPokemonMetadata_InvalidIndex() throws PokedexException {
        int invalidIndex = -1;
        when(metadataProvider.getPokemonMetadata(invalidIndex)).thenThrow(new PokedexException("Invalid Pokemon index"));

        assertThrows(PokedexException.class, () -> metadataProvider.getPokemonMetadata(invalidIndex));
    }
}
