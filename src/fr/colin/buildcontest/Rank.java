package fr.colin.buildcontest;

/**
 * Created by colin on 02/03/2017.
 */
public enum Rank {

    JOUEUR("Joueur", "7", 0, "§7[J] "),
    ADMIN("Administrateur", "c", 100, "§c[Admin] ");


    private String displayName;
    private String color;
    private int power;
    private String tabName;


    private Rank(String displayName, String color, int power, String tabName) {
        this.displayName = displayName;
        this.color = color;
        this.power = power;
        this.tabName = tabName;
    }

    public String getColor() {
        return color;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getPower() {
        return power;
    }

    public String getTabName() {
        return tabName;
    }

    public static Rank getRankWithPower(int power) {
        Rank rank = null;

        for (Rank rank1 : values()) {
            if (rank1.getPower() == power) {
                rank = rank1;
                break;
            }


        }
        return rank;


    }
}
