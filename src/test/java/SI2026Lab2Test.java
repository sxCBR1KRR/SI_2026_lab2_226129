import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SI2026Lab2Test {

    @Test
    void searchBookEveryStatementTest() {
        Library library1 = new Library();
        library1.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        library1.addBook(new Book("Effective Java", "Joshua Bloch", "Programming"));
        library1.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy"));

        List<Book> result = library1.searchBookByTitle("Clean Code");
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Clean Code", result.get(0).getTitle());

        Library library2 = new Library();
        library2.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        library2.addBook(new Book("Effective Java", "Joshua Bloch", "Programming"));

        assertNull(library2.searchBookByTitle("Harry Potter"));

        Library library3 = new Library();
        assertThrows(IllegalArgumentException.class, () -> library3.searchBookByTitle(""));
    }

    @Test
    void borrowBookEveryBranchTest() {
        Library library1 = new Library();
        library1.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));

        library1.borrowBook("Clean Code", "Robert C. Martin");
        assertNull(library1.searchBookByTitle("Clean Code"));

        Library library2 = new Library();
        library2.addBook(new Book("Effective Java", "Joshua Bloch", "Programming"));

        assertThrows(RuntimeException.class,
                () -> library2.borrowBook("Clean Code", "Robert C. Martin"));

        Library library3 = new Library();
        library3.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        library3.borrowBook("Clean Code", "Robert C. Martin");

        assertThrows(RuntimeException.class,
                () -> library3.borrowBook("Clean Code", "Robert C. Martin"));
    }

    @Test
    void searchBookMultipleConditionTest() {
        Library library1 = new Library();
        library1.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));

        List<Book> result1 = library1.searchBookByTitle("Clean Code");
        assertNotNull(result1);
        assertEquals(1, result1.size());

        Library library2 = new Library();
        library2.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        library2.borrowBook("Clean Code", "Robert C. Martin");

        assertNull(library2.searchBookByTitle("Clean Code"));

        Library library3 = new Library();
        library3.addBook(new Book("Effective Java", "Joshua Bloch", "Programming"));

        assertNull(library3.searchBookByTitle("Clean Code"));
    }

    @Test
    void borrowBookMultipleConditionTest() {
        Library library1 = new Library();
        assertThrows(IllegalArgumentException.class,
                () -> library1.borrowBook("", ""));

        Library library2 = new Library();
        assertThrows(IllegalArgumentException.class,
                () -> library2.borrowBook("", "Joshua Bloch"));

        Library library3 = new Library();
        assertThrows(IllegalArgumentException.class,
                () -> library3.borrowBook("Effective Java", ""));

        Library library4 = new Library();
        library4.addBook(new Book("Effective Java", "Joshua Bloch", "Programming"));

        assertDoesNotThrow(() -> library4.borrowBook("Effective Java", "Joshua Bloch"));
    }
}