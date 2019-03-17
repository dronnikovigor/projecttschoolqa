package model;

public class Tariff {
    private String name;
    private String description;
    private String cost;
    private String sms;
    private String calls;
    private String internet;

    public Tariff(String name, String description, String cost, String sms,
                  String calls, String internet) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.sms = sms;
        this.calls = calls;
        this.internet = internet;
    }

    public Tariff() {
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

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getCalls() {
        return calls;
    }

    public void setCalls(String calls) {
        this.calls = calls;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }
}
