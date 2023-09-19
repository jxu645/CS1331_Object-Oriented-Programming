/**
 * GameSim driver class.
 * @author Jessie Xu
 * @version 1.0
 */
public class GameSim {
    /**
     * Main method.
     * @param args Arguments passed in
     */
    public static void main(String[] args) {
        Team team1 = new Team("GT");
        Team team2 = new Team("UGA");
        GoalKeeper g1 = new GoalKeeper("John", "USA", 20, 20, 30, 19);
        Defender d1 = new Defender("Jake", "USA", 30, 50, 80, 26);
        Attacker a1 = new Attacker("James", "Ireland", 25, 55, 70, 33, Attacker.CelebrationMove.SIUU);
        Attacker a2 = new Attacker("James", "Ireland", 25, 55, 70, 33, Attacker.CelebrationMove.SIUU);
        SoccerPlayer[] sp = {g1, d1, a1, a2};
        for (int i = 0; i < sp.length; i++) {
            for (int j = sp.length - 1; j >= i; j--) {
                if (!(sp[i].equals(sp[j]))) {
                    team1.addTeamMember(sp[i]);
                }
                sp[i].toString();
            }
        }
        SoccerPlayer[] sp2 = {g1, d1, a1, a2};
        for (int i = 0; i < sp2.length; i++) {
            for (int j = sp2.length - 1; j >= i; j--) {
                if (!(sp2[i].equals(sp2[j]))) {
                    team1.addTeamMember(sp2[i]);
                }
                sp2[i].toString();
            }
        }
        System.out.println("Winner is: " + team1.playAgainstTeam(team2));
    }
}
