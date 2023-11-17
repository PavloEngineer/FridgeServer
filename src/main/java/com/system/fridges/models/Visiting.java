package com.system.fridges.models;

import java.util.Calendar;

public class Visiting {

    private int visitingId;
    private int amount;
    private Calendar visitingDate;
    private User user;

    public Visiting(int visitingId, int amount, Calendar visitingDate, User user) {
        this.visitingId = visitingId;
        this.amount = amount;
        this.visitingDate = visitingDate;
        this.user = user;
    }

    public int getVisitingId() {
        return this.visitingId;
    }

    public int getAmount() {
        return this.amount;
    }

    public Calendar getVisitingDate() {
        return this.visitingDate;
    }

    public User getUser() {
        return this.user;
    }

    public void setVisitingId(int visitingId) {
        this.visitingId = visitingId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setVisitingDate(Calendar visitingDate) {
        this.visitingDate = visitingDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Visiting)) return false;
        final Visiting other = (Visiting) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getVisitingId() != other.getVisitingId()) return false;
        if (this.getAmount() != other.getAmount()) return false;
        final Object this$visitingDate = this.getVisitingDate();
        final Object other$visitingDate = other.getVisitingDate();
        if (this$visitingDate == null ? other$visitingDate != null : !this$visitingDate.equals(other$visitingDate))
            return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Visiting;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getVisitingId();
        result = result * PRIME + this.getAmount();
        final Object $visitingDate = this.getVisitingDate();
        result = result * PRIME + ($visitingDate == null ? 43 : $visitingDate.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }

    public String toString() {
        return "Visiting(visitingId=" + this.getVisitingId() + ", amount=" + this.getAmount() + ", visitingDate=" + this.getVisitingDate() + ", user=" + this.getUser() + ")";
    }
}
