/**
 * PokemonDB class, contains main method.
 * @author Jessie Xu
 * @version 1.0
 */
public class PokemonDB {
    /**
     * Finds pokemon with corresponding health.
     * @param health Health to find
     * @param pokemon Sorted pokemon array passed in
     * @return Returns pokemon with expected health
     */
    public static Pokemon findPokemon(int health, Pokemon[] pokemon) {
        compareSort(pokemon);
        int min = 0;
        int max = pokemon.length;
        boolean found = false;
        while (!found && max > min) {
            int mid = (min + max) / 2;
            if (pokemon[mid].getHealth() == health) {
                found = true;
                return pokemon[mid];
            } else {
                if (pokemon[mid].getHealth() < health) {
                    min = min + 1;
                } else {
                    max = max - 1;
                }
            }
        }
        return null;
    }

    /**
     * Sort pokemon array with ascending order.
     * @param pokemon Pokemon array to sort
     */
    public static void compareSort(Pokemon[] pokemon) {
        for (int outer = 0; outer < pokemon.length - 1; outer++) {
            int min = outer;
            for (int inner = outer + 1; inner < pokemon.length; inner++) {
                if (pokemon[min].getHealth() > pokemon[inner].getHealth()) {
                    min = inner;
                }
                Pokemon temp = pokemon[min];
                pokemon[min] = pokemon[outer];
                pokemon[outer] = temp;
            }
        }
    }

    /**
     * Main method.
     * @param args Arguments passed in
     */
    public static void main(String[] args) {
        Water water = new Water();
        Fire fire = new Fire();
        Grass grass = new Grass();
        Pokemon a = new Pokemon("A", 70, water, 40);
        Pokemon b = new Pokemon("B", fire);
        Pokemon temp = new Pokemon("C", 150, grass, -1);
        Pokemon c = new Pokemon(temp);
        Pokemon d = new Pokemon("D", 150, grass, -1);
        Pokemon[] pokemonArray = {a, b, c, d};
        //Test toString()
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        //Test compareTo()
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(c));
        System.out.println(c.compareTo(d));
        System.out.println(a.compareTo(d));
        //Test type()
        System.out.println(water.type());
        System.out.println(fire.type());
        System.out.println(grass.type());
        //Test PokemonType's compareTo()
        System.out.println(water.compareTo(fire));
        System.out.println(water.compareTo(grass));
        System.out.println(grass.compareTo(fire));
        System.out.println(fire.compareTo(grass));
        //Test compareSort()
        for (int i = 0; i < pokemonArray.length; i++) {
            System.out.println(pokemonArray[i]);
        }
        compareSort(pokemonArray);
        for (int i = 0; i < pokemonArray.length; i++) {
            System.out.println(pokemonArray[i]);
        }
        //Test findPokemon()
        System.out.println(findPokemon(25, pokemonArray));
        System.out.println(findPokemon(50, pokemonArray));
        System.out.println(findPokemon(70, pokemonArray));
    }
}