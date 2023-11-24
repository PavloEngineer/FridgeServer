package com.system.fridges.models;

import jakarta.persistence.*;


@Entity
@Table(name = "fridge")
public class Fridge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fridge_id")
    private int fridgeId;

    @Column(name = "temperature", nullable = false)
    private float  temperature;

    @Column(name = "humidity", nullable = false)
    private float  humidity;

    @ManyToOne
    //@Column(name = "office_id", nullable = false)
    @JoinColumn(name = "office_id", nullable = false)
    private Office  office;

    @ManyToOne
    //@Column(name = "model_id", nullable = false)
    @JoinColumn(name = "model_id", nullable = false)
    private Model  model;

    public Fridge(float temperature, float humidity, Office office, Model model) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.office = office;
        this.model = model;
    }

    public Fridge() {}

    public int getFridgeId() {
        return fridgeId;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
