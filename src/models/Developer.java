package models;

public class Developer extends User {
    private String mainLanguage;

    public Developer(int id, String name, String email, String mainLanguage) {
        super(id, name, email);
        this.mainLanguage = mainLanguage;
    }

    @Override
    public String showSummary() {
        return "Dev: " + name + " | Linguagem: " + mainLanguage;
    }
}
