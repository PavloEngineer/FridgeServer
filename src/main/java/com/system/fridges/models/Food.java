package com.system.fridges.models;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private int foodId;

    @Column(name = "date_validity", nullable = false)
    private Date dateValidity;

    @Column(name = "number_boxes", nullable = false)
    private int numberBoxes;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @Column(name = "transaction_id", nullable = false)
    @JoinColumn(name = "transaction_id")
    private Transaction  transaction;

    public Food(Date dateValidity, int numberBoxes, String name, Transaction transaction) {
        this.dateValidity = dateValidity;
        this.numberBoxes = numberBoxes;
        this.name = name;
        this.transaction = transaction;
    }

    public Food() {}

    public int getFoodId() {
        return foodId;
    }

    public Date getDateValidity() {
        return dateValidity;
    }

    public void setDateValidity(Date dateValidity) {
        this.dateValidity = dateValidity;
    }

    public int getNumberBoxes() {
        return numberBoxes;
    }

    public void setNumberBoxes(int numberBoxes) {
        this.numberBoxes = numberBoxes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
