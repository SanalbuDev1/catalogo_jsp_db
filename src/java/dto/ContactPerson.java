/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author salvarez
 */
public class ContactPerson {

    public ContactPerson(int id, String name, String lastname, int contactName, String description) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.contactName = contactName;
        this.description = description;
    }

    public ContactPerson() {
    }

   
    
    
    
    protected int id;
    protected String name;
    protected String lastname;
    protected int contactName;
    protected String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getContactName() {
        return contactName;
    }

    public void setContactName(int contactName) {
        this.contactName = contactName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ContactPerson{" + "id=" + id + ", name=" + name + ", lastname=" + lastname + ", contactName=" + contactName + ", description=" + description + '}';
    }

}
