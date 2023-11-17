package com.system.fridges.models;

public class Address {

    private int addressId;
    private String region;
    private String area;
    private String city;
    private String street;
    private String numberHouse;
    private String numberApartment;

    public Address(int addressId, String region, String area, String city,
                   String street, String numberHouse, String numberApartment) {
        this.addressId = addressId;
        this.region = region;
        this.area = area;
        this.city = city;
        this.street = street;
        this.numberHouse = numberHouse;
        this.numberApartment = numberApartment;
    }

    public int getAddressId() {
        return this.addressId;
    }

    public String getRegion() {
        return this.region;
    }

    public String getArea() {
        return this.area;
    }

    public String getCity() {
        return this.city;
    }

    public String getStreet() {
        return this.street;
    }

    public String getNumberHouse() {
        return this.numberHouse;
    }

    public String getNumberApartment() {
        return this.numberApartment;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumberHouse(String numberHouse) {
        this.numberHouse = numberHouse;
    }

    public void setNumberApartment(String numberApartment) {
        this.numberApartment = numberApartment;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Address)) return false;
        final Address other = (Address) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getAddressId() != other.getAddressId()) return false;
        final Object this$region = this.getRegion();
        final Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) return false;
        final Object this$area = this.getArea();
        final Object other$area = other.getArea();
        if (this$area == null ? other$area != null : !this$area.equals(other$area)) return false;
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
        final Object this$street = this.getStreet();
        final Object other$street = other.getStreet();
        if (this$street == null ? other$street != null : !this$street.equals(other$street)) return false;
        final Object this$numberHouse = this.getNumberHouse();
        final Object other$numberHouse = other.getNumberHouse();
        if (this$numberHouse == null ? other$numberHouse != null : !this$numberHouse.equals(other$numberHouse))
            return false;
        final Object this$numberApartment = this.getNumberApartment();
        final Object other$numberApartment = other.getNumberApartment();
        if (this$numberApartment == null ? other$numberApartment != null : !this$numberApartment.equals(other$numberApartment))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Address;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getAddressId();
        final Object $region = this.getRegion();
        result = result * PRIME + ($region == null ? 43 : $region.hashCode());
        final Object $area = this.getArea();
        result = result * PRIME + ($area == null ? 43 : $area.hashCode());
        final Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        final Object $street = this.getStreet();
        result = result * PRIME + ($street == null ? 43 : $street.hashCode());
        final Object $numberHouse = this.getNumberHouse();
        result = result * PRIME + ($numberHouse == null ? 43 : $numberHouse.hashCode());
        final Object $numberApartment = this.getNumberApartment();
        result = result * PRIME + ($numberApartment == null ? 43 : $numberApartment.hashCode());
        return result;
    }

    public String toString() {
        return "Address(addressId=" + this.getAddressId() + ", region=" + this.getRegion() + ", area=" + this.getArea() + ", city=" + this.getCity() + ", street=" + this.getStreet() + ", numberHouse=" + this.getNumberHouse() + ", numberApartment=" + this.getNumberApartment() + ")";
    }
}
