package com.system.fridges.models;

import java.util.Calendar;

public class Subscription {
    private int subscriptionId;
    private Calendar beginDate;
    private Calendar endDate;
    private int price;
    private User user;

    public Subscription(int subscriptionId, Calendar beginDate, Calendar endDate, int price, User user) {
        this.subscriptionId = subscriptionId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.price = price;
        this.user = user;
    }

    public int getSubscriptionId() {
        return this.subscriptionId;
    }

    public Calendar getBeginDate() {
        return this.beginDate;
    }

    public Calendar getEndDate() {
        return this.endDate;
    }

    public int getPrice() {
        return this.price;
    }

    public User getUser() {
        return this.user;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public void setBeginDate(Calendar beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Subscription)) return false;
        final Subscription other = (Subscription) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getSubscriptionId() != other.getSubscriptionId()) return false;
        final Object this$beginDate = this.getBeginDate();
        final Object other$beginDate = other.getBeginDate();
        if (this$beginDate == null ? other$beginDate != null : !this$beginDate.equals(other$beginDate)) return false;
        final Object this$endDate = this.getEndDate();
        final Object other$endDate = other.getEndDate();
        if (this$endDate == null ? other$endDate != null : !this$endDate.equals(other$endDate)) return false;
        if (this.getPrice() != other.getPrice()) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Subscription;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getSubscriptionId();
        final Object $beginDate = this.getBeginDate();
        result = result * PRIME + ($beginDate == null ? 43 : $beginDate.hashCode());
        final Object $endDate = this.getEndDate();
        result = result * PRIME + ($endDate == null ? 43 : $endDate.hashCode());
        result = result * PRIME + this.getPrice();
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }

    public String toString() {
        return "Subscription(subscriptionId=" + this.getSubscriptionId() + ", beginDate=" + this.getBeginDate() + ", endDate=" + this.getEndDate() + ", price=" + this.getPrice() + ", user=" + this.getUser() + ")";
    }
}
