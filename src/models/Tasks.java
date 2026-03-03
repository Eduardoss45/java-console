package models;

import enums.Priority;
import enums.States;

public class Tasks {
    private int id;
    private String title = "";
    private String description = "";
    private States state = States.PENDING;
    private Priority priority = Priority.LOW;
    private User responsible;

    public Tasks(int id, String title, String description, States state, Priority priority, User responsible) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.state = state;
        this.priority = priority;
        this.responsible = responsible;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setState(States state) {
        this.state = state;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Título: " + title + " | Descrição: " + description + " | Status: " + state
                + " | Prioridade: " + priority + " | Responsável: " + responsible.showSummary();
    }
}
