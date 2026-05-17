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

        assertThrows(RuntimeException.class,
                () -> library1.borrowBook("Clean Code", "Robert C. Martin"));

        assertThrows(RuntimeException.class,
                () -> library1.borrowBook("Effective Java", "Joshua Bloch"));

        assertThrows(IllegalArgumentException.class,
                () -> library1.borrowBook("", "Author"));
    }

    @Test
    void searchBookMultipleConditionTest() {
        Library library = new Library();
        library.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "Programming"));
        library.borrowBook("Effective Java", "Joshua Bloch");

        List<Book> result1 = library.searchBookByTitle("Clean Code");
        assertNotNull(result1);

        assertNull(library.searchBookByTitle("Effective Java"));

        assertNull(library.searchBookByTitle("Other"));
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