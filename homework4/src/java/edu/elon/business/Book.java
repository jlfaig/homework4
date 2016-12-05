/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elon.business;

import java.io.Serializable;

/**
 *
 * @author jfaig
 */
public class Book implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String title;
    
    public Book() {
      firstName = "";
      lastName = "";
      email = "";
      title = "";
    }
    
    public Book(String firstName, String lastName, String email, String title) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.title = title;
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
    
    public String getEmail() {
      return email;
    }
    
    public void setEmail(String email) {
      this.email = email;
    }
    
    public String getTitle() {
      return title;
    }
    
    public void setTitle(String title) {
      this.title = title;
    }
}