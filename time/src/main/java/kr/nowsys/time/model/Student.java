package kr.nowsys.time.model;

import java.util.List;

public class Student {
    String firstName;
    String lastName;
    String country;
    String favoritePL;
    List<String> favoriteOs;

    public List<String> getFavoriteOs() {
        return favoriteOs;
    }

    public void setFavoriteOs(List<String> favoriteOs) {
        this.favoriteOs = favoriteOs;
    }

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
