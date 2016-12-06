/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elon.data;

import java.sql.*;
import edu.elon.business.Book;
import java.util.ArrayList;

public class BookDB {
  
  public static int insert(Book book) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    
    String query = "INSERT INTO Book (firstName, lastName, email, title, dueDate) " +
            "VALUES (?, ?, ?, ?, ?)";
    try {
        ps = connection.prepareStatement(query);
        ps.setString(1, book.getFirstName());
        ps.setString(2, book.getLastName());
        ps.setString(3, book.getEmail());
        ps.setString(4, book.getTitle());
        ps.setDate(5, (Date) book.setSQLDate(book.getDueDate()));
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
              + "Email = ?, " + "Title = ? + DueDate = ?";
      try {
          ps = connection.prepareStatement(query);
          ps.setString(1, book.getFirstName());
          ps.setString(2, book.getLastName());
          ps.setString(3, book.getEmail());
          ps.setString(4, book.getTitle());
          ps.setDate(5, (Date) book.setSQLDate(book.getDueDate()));
          
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
      
      String query = "DELETE FROM Book " + "WHERE BookId = ?";
      try {
          ps = connection.prepareStatement(query);
          ps.setInt(1, book.getBookId());
          
          return ps.executeUpdate();
      } catch (SQLException e) {
          System.out.println(e);
          return 0;
      } finally {
          DBUtil.closePreparedStatement(ps);
          pool.freeConnection(connection);
      }
  }
  
  public static ArrayList<Book> selectBooks() {
	ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
	
	String query = "SELECT * FROM Book";
	try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Book> users = new ArrayList<Book>();
            while (rs.next())
            {
                Book book = new Book();
                book.setBookId(rs.getInt("BookId"));
                book.setFirstName(rs.getString("FirstName"));
                book.setLastName(rs.getString("LastName"));
                book.setEmail(rs.getString("Email"));
                book.setTitle(rs.getString("Title"));
                book.setDueDate((Date)rs.getDate("DueDate"));
                users.add(book);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }       
  
}
