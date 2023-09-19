/**
 * Class Team.
 * @author Jessie Xu
 * @version 1.0
 */
public class Team {
    private String teamName;
    private SoccerPlayer[] players;
    private int index = 0;
    /**
     * Contructor of team class.
     * @param teamName Takes in string value team name
     */
    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new SoccerPlayer[11];
    }

    /**
     * Getter method of team class.
     * @return Returns teamName
     */
    public String getTeamName() {
        return this.teamName;
    }

    /**
     * Setter method of team class.
     * @param teamName Takes in new String teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Overriding object class's toString method.
     * @return Returns team info
     */
    @Override
    public String toString() {
        String returnValue = "Team name: " + getTeamName();
        for (SoccerPlayer i: players) {
            returnValue = returnValue + "\n" + i;
        }
        return returnValue;
    }

    /**
     * Method that add member into players array.
     * @param player Single player passed in
     */
    public void addTeamMember(SoccerPlayer player) {
        if (index < 11) {
            players[index] = player;
            index++;
        }
    }

    /**
     * Team play against method.
     * @param opponent Takes in another Team object
     * @return Return winning team's name
     */
    public String playAgainstTeam(Team opponent) {
        double thisRating = 0;
        double opponentRating = 0;
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i] != null) {
                this.players[i].play();
                thisRating += this.players[i].calculateRating();
            }
        }
        thisRating = thisRating / this.players.length;
        for (int i = 0; i < opponent.players.length; i++) {
            if (opponent.players[i] != null) {
                opponent.players[i].play();
                opponentRating += opponent.players[i].calculateRating();
            }
        }
        opponentRating = opponentRating / opponent.players.length;
        if (opponentRating > thisRating) {
            return opponent.teamName;
        } else if (opponentRating < thisRating) {
            return this.teamName;
        } else if (opponentRating == thisRating) {
            return "Tie";
        }
        return null;
    }
}