package com.system.fridges.models;

import java.util.Calendar;

public class Card {

    private String numberCard;
    private int cardId;
    private Calendar validityDate;
    private int cvv;
    private User user;

    public Card(int cardId, String numberCard, Calendar validityDate, int cvv, User user) {
        this.cardId = cardId;
        this.numberCard = numberCard;
        this.validityDate = validityDate;
        this.cvv = cvv;
        this.user = user;
    }

    public String getNumberCard() {
        return this.numberCard;
    }

    public int getCardId() {
        return this.cardId;
    }

    public Calendar getValidityDate() {
        return this.validityDate;
    }

    public int getCvv() {
        return this.cvv;
    }

    public User getUser() {
        return this.user;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public void setValidityDate(Calendar validityDate) {
        this.validityDate = validityDate;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Card)) return false;
        final Card other = (Card) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$numberCard = this.getNumberCard();
        final Object other$numberCard = other.getNumberCard();
        if (this$numberCard == null ? other$numberCard != null : !this$numberCard.equals(other$numberCard))
            return false;
        if (this.getCardId() != other.getCardId()) return false;
        final Object this$validityDate = this.getValidityDate();
        final Object other$validityDate = other.getValidityDate();
        if (this$validityDate == null ? other$validityDate != null : !this$validityDate.equals(other$validityDate))
            return false;
        if (this.getCvv() != other.getCvv()) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Card;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $numberCard = this.getNumberCard();
        result = result * PRIME + ($numberCard == null ? 43 : $numberCard.hashCode());
        result = result * PRIME + this.getCardId();
        final Object $validityDate = this.getValidityDate();
        result = result * PRIME + ($validityDate == null ? 43 : $validityDate.hashCode());
        result = result * PRIME + this.getCvv();
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }

    public String toString() {
        return "Card(numberCard=" + this.getNumberCard() + ", cardId=" + this.getCardId() + ", validityDate=" + this.getValidityDate() + ", cvv=" + this.getCvv() + ", user=" + this.getUser() + ")";
    }
}
