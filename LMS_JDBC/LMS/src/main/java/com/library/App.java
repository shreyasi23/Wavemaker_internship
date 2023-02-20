package com.library;

import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String uName, uPassword, bookTitle, bookAuthor, bookDescrpt, bookPublisher, bookLang, bookGenre;
        int loginStatus, choice, bookID, bookQty;
        boolean transactn = true;

        // Scanner class object
        Scanner sc = new Scanner(System.in);

        //librarian login creds class object
        librarianLoginCreds llc = new librarianLoginCreds();

        // login function class object
        loginFunc lf = new loginFunc();

        // book data class object
        bookData bd = new bookData();

        // library function class object
        libraryFunc lbf = new libraryFunc();

        System.out.println("*=====ABC LIBRARY=====*");
        System.out.println("LOGIN");
        System.out.println("Enter username: ");
        uName = sc.nextLine();
        llc.setLibnName(uName);
        System.out.println("Enter password: ");
        uPassword = sc.next();
        llc.setLibnPassword(uPassword);

        loginStatus = lf.checkUsers(llc);
        if(loginStatus == 1){
            while(transactn){
                System.out.println("Menu:\n1. Display all books\n2. Add book\n3. Search book\n4. Delete book\n5. Logout ");
                System.out.println("Enter choice(1, 2, 3, 4, 5): ");
                choice = sc.nextInt();

                switch (choice){
                    case 1:
                    {
                        System.out.println("List of Books:");
                        lbf.displayBooks();

                        break;
                    }
                    case 2:
                    {
                        System.out.println("Add Book:");
                        System.out.println("Enter ISBN number: ");
                        bookID = sc.nextInt();
                        sc.nextLine();
                        bd.setIsbn(bookID);

                        System.out.println("Enter book title: ");
                        bookTitle = sc.nextLine();
                        bd.setTitle(bookTitle);

                        System.out.println("Enter author's name: ");
                        bookAuthor = sc.nextLine();
                        bd.setAuthor(bookAuthor);

                        System.out.println("Enter book description: ");
                        bookDescrpt = sc.nextLine();
                        bd.setDescrpt(bookDescrpt);

                        System.out.println("Enter publication: ");
                        bookPublisher = sc.next();
                        bd.setPublisher(bookPublisher);

                        System.out.println("Enter book language: ");
                        bookLang = sc.next();
                        bd.setLang(bookLang);

                        System.out.println("Enter book genre: ");
                        bookGenre = sc.next();
                        bd.setGenre(bookGenre);

                        System.out.println("Enter number of books: ");
                        bookQty = sc.nextInt();
                        bd.setInventory(bookQty);

                        lbf.addBook(bd);

                        break;
                    }
                    case 3:
                    {
                        System.out.println("Search Book:");
                        System.out.println("Enter ISBN number of the book: ");
                        bookID = sc.nextInt();
                        lbf.searchBook(bookID);
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Delete Book:");
                        System.out.println("Enter ISBN number of the book: ");
                        bookID = sc.nextInt();
                        lbf.deleteBook(bookID);
                        break;
                    }
                    case 5:
                    {
                        System.out.println("You have logged out successfully!");
                        transactn = false;
                        break;
                    }
                    default:
                    {
                        System.out.println("Invalid input");
                        break;
                    }
                }
            }
        }
        else{
            exit(0);
        }
    }
}
