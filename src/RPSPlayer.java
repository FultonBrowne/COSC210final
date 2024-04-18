import java.util.ArrayList;

public class RPSPlayer {
    public static final int ROCK = 0;
    public static final int PAPER = 1;
    public static final int SCISSORS = 2;

    private String name;
    private String team;
    private ArrayList<Integer> implementsList = new ArrayList<Integer>();
    private int currentImplement;
    public RPSPlayer(String name, String team) {
        this.name = name;
        this.team = team;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return this.name;
    }

    public String getTeam() {
        return this.team;
    }

    public void equip(int role) {
        if (role < 0 || role > 2) {
            throw new IllegalArgumentException("Invalid role");
        }
        this.implementsList.add(role);
    }

    public int getCurrentImplement() {
        return this.currentImplement;
    }

    public int retrieveImplement() {
        if (this.implementsList.size() == 0) {
            throw new IllegalStateException("No implements left");
        }
        this.currentImplement = this.implementsList.remove(0);
        return this.currentImplement;
    }

    public boolean defeats(RPSPlayer other) {
        int thisRole = this.retrieveImplement();
        int otherRole = other.retrieveImplement();
        if (otherRole == thisRole) {
            return false;
        }
        if ((thisRole+1) % 3 == otherRole) {
            return false;
        }
        return true;
    }

    public boolean hasImplements() {
        return this.implementsList.size() > 0;
    }

    public String toString() {
        return this.name + " from " + this.team + " with " + this.implementsList.size() + " implements left.";
    }

}
