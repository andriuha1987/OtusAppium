package data;

public enum ShareFreeLessonsType {
    COPY_TO_CLIPBOARD("Copy to clipboard"),
    SAVE_TO_DRIVE("Save to Drive"),
    MESSENGER("Messenger"),
    GMAIL("Gmail"),
    HANGOUTS("Hangouts"),
    COPY("Copy");

    private String name;

    ShareFreeLessonsType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
