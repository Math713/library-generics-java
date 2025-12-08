package Application;

import Models.Services.Library;
import Models.Entities.Book;

import java.util.*;


public class Main {
    static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Library System ===");
            System.out.println("1. Add book");
            System.out.println("2. List books");
            System.out.println("3. Search for books");
            System.out.println("4. Leave");
            System.out.print("Choose: ");

            int option = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (option) {

                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();

                    Book book = new Book(title, author, isbn);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.println("\n--- List of Books ---");
                    library.listBooks().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Title for search: ");
                    String searchTitle = sc.nextLine();

                    System.out.println("\n--- Results ---");
                    library.searchByTitle(searchTitle).forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("Leaving...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
