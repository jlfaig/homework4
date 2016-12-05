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
    
    String query = "INSERT INTO Book (firstName, lastName, email, title) " +
            "VALUES (?, ?, ?, ?)";
    try {
        ps = connection.prepareStatement(query);
        ps.setString(1, book.getFirstName());
        ps.setString(2, book.getLastName());
        ps.setString(3, book.getEmail());
        ps.setString(4, book.getTitle());
        return ps.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e);
        return 0;
    } finally {
        DBUtil.closePreparedStatement(ps);
        pool.freeConnection(connection);
    }
  }
  
  public static int update(Book book) {
      ConnectionPool pool = ConnectionPool.getInstance();
      Connection connection = pool.getConnection();
      PreparedStatement ps = null;
      
      String query = "UPDATE Book SET" + "FirstName = ?, " + "LastName = ?, "
              + "Email = ?, " + "Title = ?";
      try {
          ps = connection.prepareStatement(query);
          ps.setString(1, book.getFirstName());
          ps.setString(2, book.getLastName());
          ps.setString(3, book.getEmail());
          ps.setString(4, book.getTitle());
          
          return ps.executeUpdate();
      } catch (SQLException e) {
          System.out.println(e);
          return 0;
      } finally {
          DBUtil.closePreparedStatement(ps);
          pool.freeConnection(connection);
      }
  }
  
  public static int delete(Book book) {
      ConnectionPool pool = ConnectionPool.getInstance();
      Connection connection = pool.getConnection();
      PreparedStatement ps = null;
      
      String query = "DELETE FROM Book " + "WHERE Email = ?";
      try {
          ps = connection.prepareStatement(query);
          ps.setString(1, book.getEmail());
          
          return ps.executeUpdate();
      } catch (SQLException e) {
          System.out.println(e);
          return 0;
      } finally {
          DBUtil.closePreparedStatement(ps);
          pool.freeConnection(connection);
      }
  }
  
  public static boolean emailExists(String email) {
      ConnectionPool pool = ConnectionPool.getInstance();
      Connection connection = pool.getConnection();
      PreparedStatement ps = null;
      ResultSet rs = null;
      
      String query = "SELECT Email FROM Book " + "WHERE Email = ?";
      try {
          ps = connection.prepareStatement(query);
          ps.setString(1, email);
          rs = ps.executeQuery();
          return rs.next();
      } catch (SQLException e) {
          System.out.println(e);
          return false;
      } finally {
          DBUtil.closeResultSet(rs);
          DBUtil.closePreparedStatement(ps);
          pool.freeConnection(connection);
      }
  }
  
}
