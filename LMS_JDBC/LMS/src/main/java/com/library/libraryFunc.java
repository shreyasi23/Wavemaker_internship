package com.library;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class libraryFunc {
    int bookID, bookQty;
    String bookTitle, bookAuthor, bookDescrpt, bookPublisher, bookLang, bookGenre;

    // function to add books into LMS_db database
    public void addBook(bookData bdObj) {
        String addBookQuery = "insert into book(isbn, title, author, descrpt, publisher, lang, genre, inventory) values(?,?,?,?,?,?,?,?);";
        try {
            bookID = bdObj.getIsbn();
            bookTitle = bdObj.getTitle();
            bookAuthor = bdObj.getAuthor();
            bookDescrpt = bdObj.getDescrpt();
            bookPublisher = bdObj.getPublisher();
            bookLang = bdObj.getLang();
            bookGenre = bdObj.getGenre();
            bookQty = bdObj.getInventory();

            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LMS_db?useSSL=false", "root", "Shreya@2001");
            PreparedStatement preparedStatement = connection.prepareStatement(addBookQuery);

            preparedStatement.setInt(1, bookID);
            preparedStatement.setString(2, bookTitle);
            preparedStatement.setString(3, bookAuthor);
            preparedStatement.setString(4, bookDescrpt);
            preparedStatement.setString(5, bookPublisher);
            preparedStatement.setString(6, bookLang);
            preparedStatement.setString(7, bookGenre);
            preparedStatement.setInt(8, bookQty);

            int rs2 = preparedStatement.executeUpdate();
            if (rs2 == 1) {
                System.out.println("Record inserted successfully!");
            } else {
                System.out.println("Some error occured, couldn't insert record");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // function to display all books in LMS_db database
    public void displayBooks() {
        String displayBookQuery = "select * from book;";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LMS_db?useSSL=false", "root", "Shreya@2001");
            Statement statement = connection.createStatement();
            ResultSet rs3 = statement.executeQuery(displayBookQuery);

            while (rs3.next()) {
                bookID = rs3.getInt("isbn");
                bookTitle = rs3.getString("title");
                bookAuthor = rs3.getString("author");
                bookDescrpt = rs3.getString("descrpt");
                bookPublisher = rs3.getString("publisher");
                bookLang = rs3.getString("lang");
                bookGenre = rs3.getString("genre");
                bookQty = rs3.getInt("inventory");
                System.out.println(bookID + "\t " + bookTitle + "\t " + bookAuthor + "\t " + bookDescrpt + "\t " + bookPublisher + "\t " + bookLang + "\t " + bookGenre + "\t " + bookQty);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // function to search a book
    public void searchBook(int find) {
        String searchBookQuery = "select * from book where isbn = "+find+";";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LMS_db?useSSL=false", "root", "Shreya@2001");
            Statement s1 = connection.createStatement();
            ResultSet rs4 = s1.executeQuery(searchBookQuery);
            while (rs4.next()) {
                bookID = rs4.getInt("isbn");
                bookTitle = rs4.getString("title");
                bookAuthor = rs4.getString("author");
                bookDescrpt = rs4.getString("descrpt");
                bookPublisher = rs4.getString("publisher");
                bookLang = rs4.getString("lang");
                bookGenre = rs4.getString("genre");
                bookQty = rs4.getInt("inventory");
                System.out.println(bookID + "\t " + bookTitle + "\t\t " + bookAuthor + "\t " + bookDescrpt + "\t " + bookPublisher + "\t " + bookLang + "\t " + bookGenre + "\t " + bookQty);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    // function to delete a book
    public void deleteBook(int bookID){
        String deleteBookQuery = "delete from book where isbn = "+bookID+";";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LMS_db?useSSL=false", "root", "Shreya@2001");
            Statement s2 = connection.createStatement();
            int isDeleted = s2.executeUpdate(deleteBookQuery);
            if(isDeleted == 1){
                System.out.println("Record deleted successfully");
            }
            else{
                System.out.println("Some error occurred, unable to delete record");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}