package library;

import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Display Books");
            System.out.println("4. Search Book");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    library.addBook(new Book(isbn, title, author, genre));
                    System.out.println("Book added!");
                    break;

                case 2:
                    System.out.print("Member ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Contact: ");
                    String contact = sc.nextLine();
                    library.addMember(new Member(id, name, contact));
                    System.out.println("Member added!");
                    break;

                case 3:
                    library.displayBooks();
                    break;

                case 4:
                    System.out.print("Keyword: ");
                    library.searchBooks(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Member ID: ");
                    Member m = library.findMember(sc.nextLine());
                    System.out.print("Book ISBN: ");
                    Book b = library.findBook(sc.nextLine());
                    if (m != null && b != null && m.borrowBook(b))
                        System.out.println("Book borrowed!");
                    else
                        System.out.println("Borrow failed!");
                    break;

                case 6:
                    System.out.print("Member ID: ");
                    Member rm = library.findMember(sc.nextLine());
                    System.out.print("Book ISBN: ");
                    Book rb = library.findBook(sc.nextLine());
                    if (rm != null && rb != null && rm.returnBook(rb))
                        System.out.println("Book returned!");
                    else
                        System.out.println("Return failed!");
                    break;

                case 7:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
            }
        }
    }
}
