package com.springclassproject.springclassproject.Models;
import javax.persistence.*;


@Entity
@Table(name = "employee")
public class Employees
{
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "isactive")
    private boolean isActive;

    public Employees()
    {

    }
    public Employees(String firstName, String lastName, String id, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}

