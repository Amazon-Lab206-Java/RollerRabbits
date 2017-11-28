public class PokeDexImplementation extends PokeDexAbstract {
    public void pokemonInfo(Pokemon pokemon) {
        System.out.println("Name " + pokemon.getName());
        System.out.println("Health " + pokemon.getHealth());
        System.out.println("Type " + pokemon.getType());
    }
}
