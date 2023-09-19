/**
 * Interface PokemonType.
 * @author Jessie Xu
 * @version 1.0
 */
public interface PokemonType extends Comparable<PokemonType> {
    /**
     * Abstract method type that should return name of class in String format.
     * @return Returns class name in form of String
     */
    String type();
}
