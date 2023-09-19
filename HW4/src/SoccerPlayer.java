/**
 * Abstract class SoccerPlayer.
 * @author Jessie Xu
 * @version 1.0
 */
public abstract class SoccerPlayer {
    private String name;
    private String country;
    private int stamina;

    /**
     * Constructor of SoccerPlayer class.
     * @param name Name of player
     * @param country Nationality of player
     * @param stamina Stamina of player
     */
    public SoccerPlayer(String name, String country, int stamina) {
        this.name = name;
        this.country = country;
        if (stamina < 1) {
            this.stamina = 20;
        } else {
            this.stamina = stamina;
        }
    }

    /**
     * Getter of string name.
     * @return Returns String name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter of string name.
     * @param name New name to this.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of String country.
     * @return Returns string country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Setter of String country.
     * @param country Takes in new string country value
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Getter of int stamina.
     * @return Returns int stamina
     */
    public int getStamina() {
        return this.stamina;
    }

    /**
     * Setter of int stamina.
     * @param stamina Takes in a new int stamina value
     */
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    /**
     * Overrides Object class's toString.
     * @return Returns information of player
     */
    @Override
    public String toString() {
        return this.name + " from " + this.country + " has " + this.stamina + " stamina left";
    }

    /**
     * Overrides Object's equals method.
     * Determines if the player equals to another player.
     * @param o Object from object class
     * @return Returns a boolean indicates if two SoccerPlayers are the same or not
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SoccerPlayer)) {
            return false;
        } else if (o == null) {
            return false;
        } else if (o == this) {
            return true;
        } else if (this.name == null || this.country == null) {
            return false;
        } else {
            return (this.name == (((SoccerPlayer) o).getName()) && this.country == (((SoccerPlayer) o).getCountry()));
        }
    }

    /**
     * Abstract method will be used in subclasses.
     */
    public abstract void play();

    /**
     * Abstract method will be used in subclasses.
     * @return Returns player rating
     */
    public abstract double calculateRating();

    /**
     * Increase stamina by 5 if player take a rest.
     */
    public void rest() {
        this.setStamina(this.getStamina() + 5);
    }
}