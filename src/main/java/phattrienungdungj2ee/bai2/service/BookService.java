package phattrienungdungj2ee.bai2.service;

import phattrienungdungj2ee.bai2.model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private Long nextId = 1L; // Biến đếm để tự động tạo ID

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addBook(Book book) {
        book.setId(nextId++); // Tự động gán ID và tăng lên 1
        books.add(book);
    }

    public void updateBook(Book updatedBook) {
        Book book = getBookById(updatedBook.getId());
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
        }
    }

    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
