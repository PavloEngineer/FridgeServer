package com.system.fridges.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int transactionId;

    @Column(name = "begin_date", nullable = false)
    private LocalDateTime beginDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @ManyToOne
    //@Column(name = "access", nullable = false)
    @JoinColumn(name = "access", nullable = false)
    private Access  access;

    public Transaction(LocalDateTime beginDate, LocalDateTime endDate, Access access) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.access = access;
    }

    public Transaction() {}

    public int getTransactionId() {
        return transactionId;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDateTime beginDate, LocalDateTime endDate) {
        if (beginDate.isBefore(endDate)) {
            this.beginDate = beginDate;
            this.endDate = endDate;
        }
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }
}
