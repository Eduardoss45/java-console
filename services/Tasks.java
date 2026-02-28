package services;

public class Tasks {
    private int id;
    private String title = "";
    private String description = "";

    public Tasks(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Título: " + title + " | Descrição: " + description;
    }
}
