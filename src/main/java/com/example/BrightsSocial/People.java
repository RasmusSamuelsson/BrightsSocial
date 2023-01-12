package com.example.BrightsSocial;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "PEOPLE")
public class People {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "firstname")

    @NotEmpty(message = "First name should not be empty")
    @Size (max = 15, message = "Name should not be more than 15 characters")
    private String firstName;
    @Column (name = "lastname")
    @NotEmpty(message = "Last name should not be empty")
    @Size (max = 15, message = "Name should not be more than 15 characters")
    private String lastName;
   /* private int age;*/
    private String city;
    @NotEmpty(message = "Username should not be empty")
    @Size (max = 15, message = "Username should not be more than 15 characters")
    private String username;
    @NotEmpty(message = "Password must not be empty")
    @Size (min = 8, message = "Password must be more than 8 characters")
    private String passcode;
    private String repeatPassword;
    @Column (length = 500)
    private String presentation;

    /*@AssertTrue(message="Must agree to terms and conditions")
    private boolean terms;*/

    public People(String firstName, String lastName, String city, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.username = username;
        this.passcode = password;

    }
    public People(String username, String password) {
        this.username = username;
        this.passcode = password;
    }

    public People() {
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

  /*  public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }*/

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                /*", age=" + age +*/
                ", city='" + city + '\'' +
                ", username='" + username + '\'' +
                ", password='" + passcode + '\'' +
                '}';
    }
}
