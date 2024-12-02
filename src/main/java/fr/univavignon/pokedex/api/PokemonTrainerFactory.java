package fr.univavignon.pokedex.api;

/**
 * Factory for creating instances of {@link PokemonTrainer}.
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    /**
     * Provider of Pokemon metadata.
     */
    private final IPokemonMetadataProvider metadataProvider;

    /**
     * Factory for creating Pokemon instances.
     */
    private final IPokemonFactory pokemonFactory;

    /**
     * Constructs a new PokemonTrainerFactory.
     *
     * @param metadataProvider The provider of Pokemon metadata.
     * @param pokemonFactory   The factory for creating Pokemon instances.
     */
    public PokemonTrainerFactory(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        return new PokemonTrainer(name, team, pokedex);
    }
}