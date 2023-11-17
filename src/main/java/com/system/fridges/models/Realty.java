package com.system.fridges.models;

public class Realty {

    private int realtyId;
    private String typeRealty;
    private int numberRooms;
    private float square;
    private int floor;
    private String typeWall;
    private int price;
    private String ownDescription;
    private Address address;

    public Realty(int realtyId, String typeRealty, int numberRooms, float square, int floor, String typeWall, int price,
                  String ownDescription, Address address) {
        this.realtyId = realtyId;
        this.typeRealty = typeRealty;
        this.numberRooms = numberRooms;
        this.square = square;
        this.floor = floor;
        this.typeWall = typeWall;
        this.price = price;
        this.ownDescription = ownDescription;
        this.address = address;
    }

    public int getRealtyId() {
        return this.realtyId;
    }

    public String getTypeRealty() {
        return this.typeRealty;
    }

    public int getNumberRooms() {
        return this.numberRooms;
    }

    public float getSquare() {
        return this.square;
    }

    public int getFloor() {
        return this.floor;
    }

    public String getTypeWall() {
        return this.typeWall;
    }

    public int getPrice() {
        return this.price;
    }

    public String getOwnDescription() {
        return this.ownDescription;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setRealtyId(int realtyId) {
        this.realtyId = realtyId;
    }

    public void setTypeRealty(String typeRealty) {
        this.typeRealty = typeRealty;
    }

    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setTypeWall(String typeWall) {
        this.typeWall = typeWall;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOwnDescription(String ownDescription) {
        this.ownDescription = ownDescription;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Realty)) return false;
        final Realty other = (Realty) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getRealtyId() != other.getRealtyId()) return false;
        final Object this$typeRealty = this.getTypeRealty();
        final Object other$typeRealty = other.getTypeRealty();
        if (this$typeRealty == null ? other$typeRealty != null : !this$typeRealty.equals(other$typeRealty))
            return false;
        if (this.getNumberRooms() != other.getNumberRooms()) return false;
        if (Float.compare(this.getSquare(), other.getSquare()) != 0) return false;
        if (this.getFloor() != other.getFloor()) return false;
        final Object this$typeWall = this.getTypeWall();
        final Object other$typeWall = other.getTypeWall();
        if (this$typeWall == null ? other$typeWall != null : !this$typeWall.equals(other$typeWall)) return false;
        if (this.getPrice() != other.getPrice()) return false;
        final Object this$ownDescription = this.getOwnDescription();
        final Object other$ownDescription = other.getOwnDescription();
        if (this$ownDescription == null ? other$ownDescription != null : !this$ownDescription.equals(other$ownDescription))
            return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Realty;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getRealtyId();
        final Object $typeRealty = this.getTypeRealty();
        result = result * PRIME + ($typeRealty == null ? 43 : $typeRealty.hashCode());
        result = result * PRIME + this.getNumberRooms();
        result = result * PRIME + Float.floatToIntBits(this.getSquare());
        result = result * PRIME + this.getFloor();
        final Object $typeWall = this.getTypeWall();
        result = result * PRIME + ($typeWall == null ? 43 : $typeWall.hashCode());
        result = result * PRIME + this.getPrice();
        final Object $ownDescription = this.getOwnDescription();
        result = result * PRIME + ($ownDescription == null ? 43 : $ownDescription.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        return result;
    }

    public String toString() {
        return "Realty(realtyId=" + this.getRealtyId() + ", typeRealty=" + this.getTypeRealty() + ", numberRooms=" + this.getNumberRooms() + ", square=" + this.getSquare() + ", floor=" + this.getFloor() + ", typeWall=" + this.getTypeWall() + ", price=" + this.getPrice() + ", ownDescription=" + this.getOwnDescription() + ", address=" + this.getAddress() + ")";
    }
}
