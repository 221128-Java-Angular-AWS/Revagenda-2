package com.revagenda.models;

public class Pokexample {
    private Integer id;
    private Integer height;
    private Integer weight;
    private String name;

    public Pokexample() {
    }

    public Pokexample(Integer id, Integer height, Integer weight, String name) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pokexample{" +
                "id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}
