package data;

public enum MainMenuItemData {
    CHAT("Chat"),
    EXERCISE("Exercise"),
    GRAMMAR("Grammar"),
    STATS("Stats");

    private String name;

    MainMenuItemData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
