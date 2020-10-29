package org.softwire.training.bookish;

import org.softwire.training.bookish.models.database.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database database = new Database();
        database.initialise();
        String userParameter = "";
        String searchRepeat = "";


        while (!userParameter.equalsIgnoreCase("exit")) {
            while (!searchRepeat.equalsIgnoreCase("n")) {
                search();
                Scanner repeat = new Scanner(System.in);
                System.out.println("Would you like to search again? y/n");
                searchRepeat = repeat.nextLine();
            }
        }
        database.cleanUp();
    }

    public static void search() {
        Database database = new Database();
        ArrayList<Book> result = null;

        Scanner parameterSearch = new Scanner(System.in);
        System.out.println("Parameters to search by: (author/title/genre/all)");
        String userParameter = parameterSearch.nextLine();
        if (userParameter.equalsIgnoreCase("author")) {
            Scanner authorSearch = new Scanner(System.in);
            System.out.println("Author name: ");
            String userAuthor = authorSearch.nextLine();
            result = database.getBooksByAuthor(userAuthor);
        }
        if (userParameter.equalsIgnoreCase("title")) {
            Scanner titleSearch = new Scanner(System.in);
            System.out.println("Title of book: ");
            String userTitle = titleSearch.nextLine();
            result = database.getBooksByTitle(userTitle);
        }
        if (userParameter.equalsIgnoreCase("genre")) {
            Scanner genreSearch = new Scanner(System.in);
            System.out.println("Genre: ");
            String userGenre = genreSearch.nextLine();
            result = database.getBooksByGenre(userGenre);
        }
        if (userParameter.equalsIgnoreCase("all")) {
            result = database.getAllBooks();
        }
        System.out.println(result);
    }
}