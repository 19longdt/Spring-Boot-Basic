package me.loda.spring.componentservicerepository;

public class Girl {
    private String name;

    @Override
    public String toString() {
        return "Girl(" + this.name + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl(String name) {
        this.name = name;
    }
}
