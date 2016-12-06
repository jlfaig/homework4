/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elon.business;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author jfaig
 */
public class Book implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String title;
    private Integer bookId;
    private String dueDate;
    
    public Book() {
      bookId = null;
      firstName = "";
      lastName = "";
      email = "";
      title = "";
      dueDate = "";
    }
    
    public Book(Integer bookId, String firstName, String lastName, String email, String title, String dueDate) {
      this.bookId = bookId;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.title = title;
      this.dueDate = dueDate;
    }
    
    public Integer getBookId() {
      return bookId;
    }
    
    public void setBookId(Integer bookId) {
      this.bookId = bookId;
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
    
    public String getDueDate() {
      return dueDate;
    }
    
    public void setDueDate(String dueDate) {
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
       Date date = null;
       try {
         date = (java.util.Date) formatter.parse(dueDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       System.out.println("date:" + date);
      Calendar calendar = GregorianCalendar.getInstance();
      calendar.setTime(date);
      calendar.add(Calendar.WEEK_OF_YEAR, 2);
      SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
      this.dueDate = sdf.format(calendar.getTime());
    }
}