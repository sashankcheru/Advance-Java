import java.util.ArrayList;

class Book 
{
    int bookId;
    String title, author;
    boolean isAvailable = true;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }


    void displayInfo() {
        System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Available: " + (isAvailable ? "Yes" : "No"));
    }



    void borrowBook() 
    {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed.");
        } else {
            System.out.println("Book unavailable.");
        }
    }

    void returnBook() {
        isAvailable = true;
        System.out.println("Book returned.");
    }
}

class Library
 {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added.");
    }



    void listAvailable() {
        for (Book book : books) {
            if (book.isAvailable) {
                book.displayInfo();
            }
        }
    }



    Book find(String title) {
        for (Book book : books) {
            if (book.title == title) {
                return book;
            }
        }
        return null;
    }
}



class Student 
{
    int studentId;
    String name;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }




    void borrowBook(Book book)
     {
        if (borrowedBooks.size() < 3 && book != null && book.isAvailable) {
            borrowedBooks.add(book);
            book.borrowBook();
        } else {
            System.out.println("Cannot borrowBook.");
        }
    }

    void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returnBook();
        } else {
            System.out.println("Book not borrowed.");
        }
    }




    void displayBorrowed() 
    {
        for (Book book : borrowedBooks) {
            book.displayInfo();
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book(1, "Swami and Friends ", "R.K. Narayan"));

        library.addBook(new Book(2, "Wings of Fire", "A.P.J.Abdul Kalam"));
        library.addBook(new Book(3, "The Blue Umbrella", "Ruskin Bond"));

        library.listAvailable();

        Student student = new Student(224203, "Sashank");

        Book book = library.find("The Blue Umbrella");
        student.borrowBook(book);

        student.borrowBook(book);
        library.listAvailable();
        student.displayBorrowed();
        student.returnBook(book);
        library.listAvailable();
    }
}