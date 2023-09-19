import java.util.Random;

/**
 * Defender class.
 * @author Jessie Xu
 * @version 1.0
 */
public class Defender extends SoccerPlayer {
    private int totalPasses;
    private int totalPassesCompleted;
    private double defenseRating;

    /**
     * Constructor of Defender class.
     * @param name    Name of player
     * @param country Nationality of player
     * @param stamina Stamina of player
     * @param totalPasses Total passes made by defender
     * @param totalPassesCompleted Total passes completed by defender
     * @param defenseRating Rating of defender
     */
    public Defender(String name, String country, int stamina, int totalPasses, int totalPassesCompleted,
                    double defenseRating) {
        super(name, country, stamina);
        this.totalPasses = totalPasses;
        if (totalPassesCompleted > totalPasses) {
            this.totalPassesCompleted = totalPasses;
        } else {
            this.totalPassesCompleted = totalPassesCompleted;
        }
        this.defenseRating = defenseRating;
    }

    /**
     * Calculates rating of defender.
     * @return Rating of defender
     */
    @Override
    public double calculateRating() {
        if (totalPasses == 0) {
            return 0;
        } else {
            double rating = (((double) this.totalPassesCompleted) / ((double) this.totalPasses)) * 100;
            return rating;
        }
    }

    /**
     * Play method of defender.
     */
    @Override
    public void play() {
        Random r = new Random();
        int random = r.nextInt(100);
        if (getStamina() < 0) {
            this.setStamina(0);
        } else {
            this.setStamina(this.getStamina() - random);
        }
        int random2 = r.nextInt(100);
        this.totalPasses = random2;
        int random3 = r.nextInt(this.totalPasses);
        if (getStamina() == 0) {
            this.totalPassesCompleted = 0;
        } else {
            this.totalPassesCompleted = random3;
        }
        this.defenseRating = calculateRating();
    }

    /**
     * Detailed information of defender.
     * @return Returns data of defender
     */
    @Override
    public String toString() {
        defenseRating = Math.round(defenseRating * 1000);
        this.defenseRating = defenseRating / 100;
        return super.toString()
                + ". As a Defender, I have completed "
                + this.totalPassesCompleted
                + " passes from "
                + this.totalPasses
                + " initiated passes and my rating is "
                + this.defenseRating;
    }

    /**
     * Overriding method equals of defender class.
     * @param o Object from object class
     * @return Returns if two objects are the same or not
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof Defender)) {
            return false;
        } else if (o == this) {
            return true;
        } else {
            Defender temp = (Defender) o;
            boolean samePlayer = super.equals(o);
            return ((samePlayer)
                    && (this.totalPasses == temp.totalPasses)
                    && (this.totalPassesCompleted == temp.totalPassesCompleted)
                    && (this.defenseRating == temp.defenseRating));
        }
    }
}
