import java.util.Random;

/**
 * GoalKeeper class.
 * @author Jessie Xu
 * @version 1.0
 */
public class GoalKeeper extends SoccerPlayer {
    private int totalSaves;
    private int totalShotsOnTarget;
    private double ballHandling;

    /**
     *Constructor of GoalKeeper class.
     * @param name Name of player
     * @param country Country of Player
     * @param stamina Stamina of player
     * @param totalSaves Shots on target that were blocked by goalkeeper
     * @param totalShotsOnTarget Total shots on target
     * @param ballHandling Rating on goalkeeper's handling skills
     */
    public GoalKeeper(String name, String country, int stamina, int totalSaves, int totalShotsOnTarget,
                      double ballHandling) {
        super(name, country, stamina);
        this.totalShotsOnTarget = totalShotsOnTarget;
        if (totalSaves > totalShotsOnTarget) {
            this.totalSaves = totalShotsOnTarget;
        } else {
            this.totalSaves = totalSaves;
        }
        this.ballHandling = ballHandling;
    }

    /**
     * Calculates rating of goalkeeper.
     * @return Rating of goalkeeper
     */
    @Override
    public double calculateRating() {
        if (totalShotsOnTarget == 0) {
            return 0;
        } else {
            double rating = (((double) this.totalSaves) / ((double) this.totalShotsOnTarget)) * 100;
            return rating;
        }
    }

    /**
     * Play method of goalkeeper.
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
        this.totalShotsOnTarget = random2;
        int random3 = r.nextInt(this.totalShotsOnTarget);
        if (getStamina() == 0) {
            this.totalSaves = 0;
        } else {
            this.totalSaves = random3;
        }
        this.ballHandling = calculateRating();
    }

    /**
     * Represents detailed information of GoalKeeper.
     * @return Returns a new String toString
     */
    @Override
    public String toString() {
        ballHandling = Math.round(ballHandling * 100);
        this.ballHandling = ballHandling / 100;
        return super.toString()
                + ". As a Goalkeeper, I have stopped "
                + this.totalSaves + " shots from  "
                + this.totalShotsOnTarget
                + " shots on target and my rating is "
                + this.ballHandling;
    }

    /**
     * Overriding equals method in Object class.
     * @param o Object from object class
     * @return Returns if two goalkeepers are the same or not
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof GoalKeeper)) {
            return false;
        } else if (o == this) {
            return true;
        } else {
            GoalKeeper temp = (GoalKeeper) o;
            boolean samePlayer = super.equals(o);
            return ((samePlayer)
                    && (this.totalSaves == temp.totalSaves)
                    && (this.totalShotsOnTarget == temp.totalShotsOnTarget)
                    && (this.ballHandling == temp.ballHandling));
        }
    }
}