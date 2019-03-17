package model;

public class Option {
    private String name;
    private String description;
    private String cost;
    private String costOfConnection;

    public Option() {
    }

    public Option(String name, String description, String cost, String costOfConnection) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.costOfConnection = costOfConnection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCostOfConnection() {
        return costOfConnection;
    }

    public void setCostOfConnection(String costOfConnection) {
        this.costOfConnection = costOfConnection;
    }
}
