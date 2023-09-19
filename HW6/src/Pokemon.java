/**
 * Pokemon class.
 * @author Jessie Xu
 * @version 1.0
 */
public class Pokemon {
    private String name;
    private int health;
    private int strength;
    private PokemonType type;

    /**
     * 4-args constructor of Pokemon.
     * @param name Name of pokemon
     * @param health Health of pokemon
     * @param type Type of pokemon
     * @param strength Strength of pokemon
     */
    public Pokemon(String name, int health, PokemonType type, int strength) {
        if (name.equals(null) || name.trim().equals("")) {
            this.name = "Pikachu";
        } else {
            this.name = name;
        }
        if (health < 1 || health > 100) {
            this.health = 50;
        } else {
            this.health = health;
        }
        if (type instanceof Fire || type instanceof Water || type instanceof Grass) {
            this.type = type;
        } else {
            this.type = (PokemonType) new Fire();
        }
        if (strength < 1 || strength > 100) {
            this.strength = 50;
        } else {
            this.strength = strength;
        }
    }

    /**
     * 2-args constructor of Pokemon.
     * @param name Name of pokemon
     * @param type Type of pokemon
     */
    public Pokemon(String name, PokemonType type) {
        if (name.equals(null) || name.trim().equals("")) {
            this.name = "Pikachu";
        } else {
            this.name = name;
        }
        if (type instanceof Grass) {
            this.health = 65;
        } else if (type instanceof Water) {
            this.health = 80;
        } else {
            this.health = 50;
        }
        if (type instanceof Fire || type instanceof Water || type instanceof Grass) {
            this.type = type;
        } else {
            this.type = (PokemonType) new Fire();
        }
        this.strength = (int) (Math.random() * 100 + 1);
    }

    /**
     * 1-args constructor of Pokemon.
     * @param object Pokemon object passed in
     */
    public Pokemon(Pokemon object) {
        this.name = object.getName();
        this.health = object.getHealth();
        this.type = object.getType();
        this.strength = object.getStrength();
    }

    /**
     * Getter method of name.
     * @return Returns name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method of health.
     * @return Returns health
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Getter method of strength.
     * @return Returns strength
     */
    public int getStrength() {
        return this.strength;
    }

    /**
     * Getter method of type.
     * @return Returns type
     */
    public PokemonType getType() {
        return this.type;
    }

    /**
     * Overriding toString method in object class.
     * @return Returns pokemon info
     */
    @Override
    public String toString() {
        return this.getName() + " is a "
                + this.getType().type() + " type with health "
                + this.getHealth() + " and strength "
                + this.getStrength();
    }

    /***
     * Method that compares two pokemon objects and see if they equals to each other.
     * @param p Pokemon object passed in
     * @return Returns 0 if two pokemons are equal
     */
    public int compareTo(Pokemon p) {
        if (Integer.compare(this.health, p.health) != 0) {
            return Integer.compare(this.health, p.health);
        } else if (Integer.compare(this.strength, p.strength) != 0) {
            return Integer.compare(this.strength, p.strength);
        } else if ((this.type.compareTo(p.type) != 0)) {
            return this.type.compareTo(p.type);
        } else {
            return 0;
        }
    }
}
