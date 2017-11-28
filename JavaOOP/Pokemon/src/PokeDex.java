public interface PokeDex {
    Pokemon createPokemon(String name, int health, String type);
    void attackPokemon(Pokemon pokemon);
    void pokemonInfo(Pokemon pokemon);
}
