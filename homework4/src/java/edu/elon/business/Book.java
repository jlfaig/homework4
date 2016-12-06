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
    private Date dueDate;
    private Boolean isOverdue;
    private java.sql.Date sqlDate;
    
    public Book() {
      bookId = null;
      firstName = "";
      lastName = "";
      email = "";
      title = "";
      dueDate = null;
      isOverdue = false;
      sqlDate = null;
    }
    
    public Book(String firstName, String lastName, String email, String title) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.title = title;
      
      Calendar calendar = GregorianCalendar.getInstance();
      calendar.add(Calendar.WEEK_OF_YEAR, 2);
      this.dueDate = calendar.getTime();
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
    
    public Date getDueDate() {
      return dueDate;
    }
    
    public void setDueDate(Date dueDate) {
       this.dueDate = dueDate;
    }
    
    public String getFormatDate() {
      SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
      return sdf.format(dueDate);
    }
    
    public boolean getIsOverdue() {
      Calendar calendar = GregorianCalendar.getInstance();
     if (calendar.getTime().compareTo(dueDate) > 0) {
      isOverdue = true;
     }
     System.out.println("today's date" + calendar.getTime());
      return isOverdue;
    }
    
    public Date setSQLDate(Date dueDate) {
      sqlDate = new java.sql.Date(dueDate.getTime());
      return sqlDate;
    }
}