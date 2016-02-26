package com.mdp.bank.model;

/**
 * Created on 2/25/16.
 *
 * @author Adrian Pena
 */
public class Customer {
    private long id;
    private string name;
    private string lastName;
    private string email;

    public Customer(){
    }

    public Customer(long id, string name, string lastName, string email){
        this.id = id;
        this.name = name;
        this .lastName=lastName;
        this.email=email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public string getName() {
        return name;
    }

    public void setName(string name) {
        this.name = name;
    }

    public string getLastName() {
        return lastName;
    }

    public void setLastName(string lastName) {
        this.lastName = lastName;
    }

    public string getEmail() {
        return email;
    }

    public void setEmail(string email) {
        this.email = email;
    }
}
