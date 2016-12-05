/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elon.data;

import java.sql.*;
import edu.elon.business.Book;

public class BookDB {
  
  public static int insert(Book book) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    
    //finish typing rest of class froom p. 411
  }
}
