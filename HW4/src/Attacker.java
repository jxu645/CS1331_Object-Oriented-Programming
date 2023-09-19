import java.util.Random;

/**
 * Class Attacker.
 * @author Jessie Xu
 * @version 1.0
 */
public class Attacker extends SoccerPlayer {
    private int totalGoals;
    private int totalShotsOnTarget;
    private double attackingRating;
    enum CelebrationMove {
        DIVE, CARTWHEEL, SIUU
    }
    private  CelebrationMove celebrationMove;

    /**
     * Constructor of Attacker class.
     * @param name    Name of player
     * @param country Nationality of player
     * @param stamina Stamina of player
     * @param totalGoals Goals completed by attacker
     * @param totalShotsOnTarget Total shots made by attacker
     * @param attackingRating Rating of attacker
     * @param celebrationMove Celebration move of attacker
     */
    public Attacker(String name, String country, int stamina, int totalGoals, int totalShotsOnTarget,
                    double attackingRating, Attacker.CelebrationMove celebrationMove) {
        super(name, country, stamina);
        this.totalShotsOnTarget = totalShotsOnTarget;
        if (totalGoals > totalShotsOnTarget) {
            this.totalGoals = totalShotsOnTarget;
        } else {
            this.totalGoals = totalGoals;
        }
        this.attackingRating = attackingRating;
        this.celebrationMove = celebrationMove;
    }

    /**
     * Getter method of celebration move.
     * @return Returns current celebration move
     */
    public CelebrationMove getCelebrationMove() {
        return celebrationMove;
    }

    /**
     * Setter method of celebration move.
     * @param celebrationMove Takes in a celebration move
     */
    public void setCelebrationMove(CelebrationMove celebrationMove) {
        this.celebrationMove = celebrationMove;
    }
    /**
     * Calculates rating of attacker.
     * @return Returns rating of attacker
     */
    @Override
    public double calculateRating() {
        if (totalShotsOnTarget == 0) {
            return 0;
        } else {
            double rating = (((double) this.totalGoals) / ((double) this.totalShotsOnTarget)) * 100;
            return rating;
        }
    }

    /**
     * Play method of attacker.
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
            this.totalGoals = 0;
        } else if (getCelebrationMove() == CelebrationMove.SIUU) {
            double temp = (double) random3 * 1.1;
            int finalGoals = (int) Math.round(temp);
            while (this.totalGoals <= this.totalShotsOnTarget) {
                this.totalGoals = finalGoals;
            }
        } else {
            this.totalGoals = random3;
        }
        this.attackingRating = calculateRating();
    }

    /**
     * Overriding toString method of object class.
     * @return Return information of attacker
     */
    @Override
    public String toString() {
        attackingRating = Math.round(attackingRating * 100);
        this.attackingRating = attackingRating / 100;
        return super.toString()
                + ". As a Attacker, I have scored "
                + this.totalGoals
                + " goals from  "
                + this.totalShotsOnTarget
                + " shots on target and my rating is "
                + this.attackingRating
                + ". My celebration is "
                + this.getCelebrationMove();
    }

    /**
     * Overriding equals method.
     * @param o Object from object class
     * @return Returns a boolean value of two objects' comparison
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof Attacker)) {
            return false;
        } else if (o == this) {
            return true;
        } else {
            Attacker temp = (Attacker) o;
            boolean samePlayer = super.equals(o);
            return ((samePlayer) && (this.totalGoals == temp.totalGoals)
                    && (this.totalShotsOnTarget == temp.totalShotsOnTarget)
                    && (this.attackingRating  == temp.attackingRating)
                    && (this.getCelebrationMove() == temp.getCelebrationMove()));
        }
    }
}
