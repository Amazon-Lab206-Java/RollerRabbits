public abstract class PokeDexAbstract implements PokeDex {
    public Pokemon createPokemon(String name, int health, String type) {
        return new Pokemon(name, health, type);
    }
    public void attackPokemon(Pokemon pokemon) {
        int temp = pokemon.getHealth() - 10;
        pokemon.setHealth(temp);
    }
}
