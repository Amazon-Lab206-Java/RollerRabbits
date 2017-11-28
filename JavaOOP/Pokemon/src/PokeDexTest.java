public class PokeDexTest {
    public static void main(String[] args) {
        PokeDex pokeDex = new PokeDexImplementation();
        Pokemon pikachu = pokeDex.createPokemon("Pikachu", 30, "Electric");
        pokeDex.pokemonInfo(pikachu);
        System.out.println("---Attacking Pikachu---");
        pokeDex.attackPokemon(pikachu);
        pokeDex.pokemonInfo(pikachu);

        pokeDex.createPokemon("Val", 5000, "Rock");
        System.out.println("Num pokemon created: " + Pokemon.getCountPokemon());
    }
}
