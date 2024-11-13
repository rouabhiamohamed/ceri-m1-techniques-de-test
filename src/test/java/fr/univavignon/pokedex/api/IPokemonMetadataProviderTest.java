
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
        // Given
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(bulbasaurMetadata);
        when(metadataProvider.getPokemonMetadata(133)).thenReturn(aqualiMetadata);

        // When
        PokemonMetadata actualBulbasaurMetadata = metadataProvider.getPokemonMetadata(0);
        PokemonMetadata actualAqualiMetadata = metadataProvider.getPokemonMetadata(133);

        // Then
        assertAll(
                () -> assertEquals(0, actualBulbasaurMetadata.getIndex()),
                () -> assertEquals("Bulbizarre", actualBulbasaurMetadata.getName()),
                () -> assertEquals(126, actualBulbasaurMetadata.getAttack()),
                () -> assertEquals(126, actualBulbasaurMetadata.getDefense()),
                () -> assertEquals(90, actualBulbasaurMetadata.getStamina()),
                () -> assertEquals(133, actualAqualiMetadata.getIndex()),
                () -> assertEquals("Aquali", actualAqualiMetadata.getName()),
                () -> assertEquals(186, actualAqualiMetadata.getAttack()),
                () -> assertEquals(168, actualAqualiMetadata.getDefense()),
                () -> assertEquals(260, actualAqualiMetadata.getStamina())
        );
        verify(metadataProvider, times(1)).getPokemonMetadata(0);
        verify(metadataProvider, times(1)).getPokemonMetadata(133);
    }

    @Test
    void testGetPokemonMetadata_InvalidIndex() {
        // Given
        int[] invalidIndices = {-1, -100};
        for (int invalidIndex : invalidIndices) {
            when(metadataProvider.getPokemonMetadata(invalidIndex))
                    .thenThrow(new PokedexException("Invalid Pokemon index: " + invalidIndex));

            // When/Then
            final int index = invalidIndex;
            PokedexException exception = assertThrows(
                    PokedexException.class,
                    () -> metadataProvider.getPokemonMetadata(index)
            );
            assertTrue(exception.getMessage().contains("Invalid Pokemon index"));
        }
    }

    @Test
    void testGetPokemonMetadata_VerifyMetadataContent() throws PokedexException {
        // Given
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(bulbasaurMetadata);

        // When
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(0);

        // Then
        assertAll(
                () -> assertTrue(metadata.getAttack() > 0, "Attack should be positive"),
                () -> assertTrue(metadata.getDefense() > 0, "Defense should be positive"),
                () -> assertTrue(metadata.getStamina() > 0, "Stamina should be positive"),
                () -> assertNotNull(metadata.getName(), "Name should not be null"),
                () -> assertFalse(metadata.getName().isEmpty(), "Name should not be empty")
        );
    }
}
