package phattrienungdungj2ee.bai2.service;

import org.springframework.stereotype.Service;

import phattrienungdungj2ee.bai2.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    // Tạo danh sách listBook ảo để lưu trữ thay vì database
    private List<Book> books = new ArrayList<>();

    // 1. Lấy danh sách tất cả sách
    public List<Book> getAllBooks() {
        return books;
    }

    // 2. Lấy sách theo ID
    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // 3. Thêm sách mới
    public void addBook(Book book) {
        books.add(book);
    }

    // 4. Cập nhật thông tin sách
    public void updateBook(int id, Book updatedBook) {
        Book book = getBookById(id);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
        }
    }

    // 5. Xóa sách theo ID
    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
