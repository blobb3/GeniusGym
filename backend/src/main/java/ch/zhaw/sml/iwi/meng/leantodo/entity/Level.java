package ch.zhaw.sml.iwi.meng.leantodo.entity;

public enum Level {
    ANFAENGER("Anfänger"),
    SPORTLER("Sportler"),
    EXPERTE("Experte");

    private final String displayName;

    Level(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Level calculateLevel(int punkte) {
        if (punkte < 50) {
            return ANFAENGER;
        } else if (punkte < 200) {
            return SPORTLER;
        } else {
            return EXPERTE;
        }
    }
}