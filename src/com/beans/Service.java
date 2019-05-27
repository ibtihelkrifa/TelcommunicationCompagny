package com.beans;

public abstract class Service
{
    private String description;
    private float cout;

    public float getCout() {
        return cout;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Service(String description, float cout)
    {
        this.setCout(cout);
        this.setDescription(description);
    }
}
