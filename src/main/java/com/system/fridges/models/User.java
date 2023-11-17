package com.system.fridges.models;

import java.util.Calendar;

public class User {

    private int userId;

    private String password;
    private String email;
    private String fullName;
    private Calendar birthDate;
    private String sex;
    private String typeUser;
    private boolean isBan;

    public User(int userId, String password, String email, String fullName,
                Calendar birthDate, String sex, String typeUser, boolean isBan) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.typeUser = typeUser;
        this.isBan = isBan;
    }

    public String getPassword() {
        return this.password;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Calendar getBirthDate() {
        return this.birthDate;
    }

    public String getSex() {
        return this.sex;
    }

    public String getTypeUser() {
        return this.typeUser;
    }

    public boolean isBan() {
        return this.isBan;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public void setSex(String sex) {
        if (!sex.equals("Чоловік") && !sex.equals("Жінка")) {
            sex = " ";
        }
        this.sex = sex;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public void setBan(boolean isBan) {
        this.isBan = isBan;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$fullName = this.getFullName();
        final Object other$fullName = other.getFullName();
        if (this$fullName == null ? other$fullName != null : !this$fullName.equals(other$fullName)) return false;
        final Object this$birthDate = this.getBirthDate();
        final Object other$birthDate = other.getBirthDate();
        if (this$birthDate == null ? other$birthDate != null : !this$birthDate.equals(other$birthDate)) return false;
        final Object this$sex = this.getSex();
        final Object other$sex = other.getSex();
        if (this$sex == null ? other$sex != null : !this$sex.equals(other$sex)) return false;
        final Object this$typeUser = this.getTypeUser();
        final Object other$typeUser = other.getTypeUser();
        if (this$typeUser == null ? other$typeUser != null : !this$typeUser.equals(other$typeUser)) return false;
        if (this.isBan() != other.isBan()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $fullName = this.getFullName();
        result = result * PRIME + ($fullName == null ? 43 : $fullName.hashCode());
        final Object $birthDate = this.getBirthDate();
        result = result * PRIME + ($birthDate == null ? 43 : $birthDate.hashCode());
        final Object $sex = this.getSex();
        result = result * PRIME + ($sex == null ? 43 : $sex.hashCode());
        final Object $typeUser = this.getTypeUser();
        result = result * PRIME + ($typeUser == null ? 43 : $typeUser.hashCode());
        result = result * PRIME + (this.isBan() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "User(password=" + this.getPassword() + ", email=" + this.getEmail() + ", fullName=" + this.getFullName() + ", birthDate=" + this.getBirthDate() + ", sex=" + this.getSex() + ", typeUser=" + this.getTypeUser() + ", isBan=" + this.isBan() + ")";
    }
}
