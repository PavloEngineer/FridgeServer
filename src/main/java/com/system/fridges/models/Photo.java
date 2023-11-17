package com.system.fridges.models;

public class Photo {

    private int photoId;
    private String location;

    public Photo(int photoId, String location) {
        this.photoId = photoId;
        this.location = location;
    }

    public int getPhotoId() {
        return this.photoId;
    }

    public String getLocation() {
        return this.location;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Photo)) return false;
        final Photo other = (Photo) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getPhotoId() != other.getPhotoId()) return false;
        final Object this$location = this.getLocation();
        final Object other$location = other.getLocation();
        if (this$location == null ? other$location != null : !this$location.equals(other$location)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Photo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getPhotoId();
        final Object $location = this.getLocation();
        result = result * PRIME + ($location == null ? 43 : $location.hashCode());
        return result;
    }

    public String toString() {
        return "Photo(photoId=" + this.getPhotoId() + ", location=" + this.getLocation() + ")";
    }
}
