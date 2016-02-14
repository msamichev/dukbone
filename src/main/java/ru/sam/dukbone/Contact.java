package ru.sam.dukbone;

import java.net.URL;
import java.time.LocalDateTime;

/**
 *
 */
public class Contact {

    private String firstName;
    private String lastName;
    private LocalDateTime birthDate;
    private URL personalSite;

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

    public LocalDateTime getBirthDate() {

        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {

        this.birthDate = birthDate;
    }

    public URL getPersonalSite() {

        return personalSite;
    }

    public void setPersonalSite(URL personalSite) {
        this.personalSite = personalSite;
    }

    public String toString() {
        return "First name: " + getFirstName()
                + " Last name: " + getLastName()
                + " Birth date: " + getBirthDate()
                + " Personal site: " + getPersonalSite();
    }
}