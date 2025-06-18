package kr.nowsys.time.model;

public class Student {
    String firstName;
    String lastName;
    String country;
    String favoritePL;

    public String getFavoritePL() {
        return favoritePL;
    }

    public void setFavoritePL(String favoritePL) {
        this.favoritePL = favoritePL;
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
