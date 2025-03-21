public class LibraryManagementDLL {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true, 0);
        library.addBook("To Kill a Mockingbird", "Harper Lee", "Classic", 102, true, 1);
        library.addBook("1984", "George Orwell", "Dystopian", 103, true, 2);

        System.out.println("\nLibrary Collection (Forward):");
        library.displayBooksForward();

        System.out.println("\nUpdating Availability of Book ID 102:");
        library.updateAvailability(102, false);
        library.displayBooksForward();

        System.out.println("\nTotal Books in Library: " + library.countBooks());

        System.out.println("\nRemoving Book ID 103:");
        library.removeBook(103);
        library.displayBooksForward();
    }
}
class Book {
    String title;
    String author;
    String genre;
    int bookID;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private Book head;
    private Book tail;
    private int count = 0;

    public void addBook(String title, String author, String genre, int bookID, boolean isAvailable, Integer position) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null || position == null || position == 0) {
            newBook.next = head;
            if (head != null) head.prev = newBook;
            head = newBook;
            if (tail == null) tail = newBook;
        } else {
            Book temp = head;
            int index = 0;
            while (temp.next != null && index < position - 1) {
                temp = temp.next;
                index++;
            }
            newBook.next = temp.next;
            newBook.prev = temp;
            if (temp.next != null) temp.next.prev = newBook;
            temp.next = newBook;
            if (newBook.next == null) tail = newBook;
        }
        count++;
    }

    public void removeBook(int bookID) {
        Book temp = head;
        while (temp != null && temp.bookID != bookID) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp.prev != null) temp.prev.next = temp.next;
        else head = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        else tail = temp.prev;
        count--;
    }

    public Book searchBookByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public Book searchBookByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void updateAvailability(int bookID, boolean isAvailable) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.isAvailable = isAvailable;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayBooksForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookID + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    public void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookID + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    public int countBooks() {
        return count;
    }
}
