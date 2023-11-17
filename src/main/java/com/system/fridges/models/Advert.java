package com.system.fridges.models;

import java.util.Calendar;

public class Advert {

    private int advertId;
    private String purposeCreation;
    private Calendar rentBegin;
    private Calendar rentEnd;
    private User user;
    private Realty realty;

    public Advert(int advertId, String purposeCreation, Calendar rentBegin, Calendar rentEnd, User user,
                  Realty realty) {
        this.advertId = advertId;
        this.purposeCreation = purposeCreation;
        this.rentBegin = rentBegin;
        this.rentEnd = rentEnd;
        this.user = user;
        this.realty = realty;
    }

    public int getAdvertId() {
        return this.advertId;
    }

    public String getPurposeCreation() {
        return this.purposeCreation;
    }

    public Calendar getRentBegin() {
        return this.rentBegin;
    }

    public Calendar getRentEnd() {
        return this.rentEnd;
    }

    public User getUser() {
        return this.user;
    }

    public Realty getRealty() {
        return this.realty;
    }

    public void setAdvertId(int advertId) {
        this.advertId = advertId;
    }

    public void setPurposeCreation(String purposeCreation) {
        this.purposeCreation = purposeCreation;
    }

    public void setRentBegin(Calendar rentBegin) {
        this.rentBegin = rentBegin;
    }

    public void setRentEnd(Calendar rentEnd) {
        this.rentEnd = rentEnd;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRealty(Realty realty) {
        this.realty = realty;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Advert)) return false;
        final Advert other = (Advert) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getAdvertId() != other.getAdvertId()) return false;
        final Object this$purposeCreation = this.getPurposeCreation();
        final Object other$purposeCreation = other.getPurposeCreation();
        if (this$purposeCreation == null ? other$purposeCreation != null : !this$purposeCreation.equals(other$purposeCreation))
            return false;
        final Object this$rentBegin = this.getRentBegin();
        final Object other$rentBegin = other.getRentBegin();
        if (this$rentBegin == null ? other$rentBegin != null : !this$rentBegin.equals(other$rentBegin)) return false;
        final Object this$rentEnd = this.getRentEnd();
        final Object other$rentEnd = other.getRentEnd();
        if (this$rentEnd == null ? other$rentEnd != null : !this$rentEnd.equals(other$rentEnd)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$realty = this.getRealty();
        final Object other$realty = other.getRealty();
        if (this$realty == null ? other$realty != null : !this$realty.equals(other$realty)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Advert;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getAdvertId();
        final Object $purposeCreation = this.getPurposeCreation();
        result = result * PRIME + ($purposeCreation == null ? 43 : $purposeCreation.hashCode());
        final Object $rentBegin = this.getRentBegin();
        result = result * PRIME + ($rentBegin == null ? 43 : $rentBegin.hashCode());
        final Object $rentEnd = this.getRentEnd();
        result = result * PRIME + ($rentEnd == null ? 43 : $rentEnd.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $realty = this.getRealty();
        result = result * PRIME + ($realty == null ? 43 : $realty.hashCode());
        return result;
    }

    public String toString() {
        return "Advert(advertId=" + this.getAdvertId() + ", purposeCreation=" + this.getPurposeCreation() + ", rentBegin=" + this.getRentBegin() + ", rentEnd=" + this.getRentEnd() + ", user=" + this.getUser() + ", realty=" + this.getRealty() + ")";
    }
}
