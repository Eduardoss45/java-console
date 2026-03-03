package models;

public class Manager extends User {
    private int teamSize;

    public Manager(int id, String name, String email, int teamSize) {
        super(id, name, email);
        this.teamSize = teamSize;
    }

    @Override
    public String showSummary() {
        return "Gerente: " + name + " | Equipe: " + teamSize + " pessoas";
    }
}
