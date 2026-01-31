package phattrienungdungj2ee.bai2.controller;

import phattrienungdungj2ee.bai2.model.Book;
import phattrienungdungj2ee.bai2.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books") // Đường dẫn gốc cho tất cả API
public class BookController {

    @Autowired
    private BookService bookService;

    // 1. API lấy danh sách sách (GET)
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // 2. API lấy sách theo ID (GET)
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // 3. API thêm sách mới (POST)
    @PostMapping
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "Book added successfully!";
    }

    // 4. API cập nhật sách (PUT)
    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        bookService.updateBook(id, updatedBook);
        return "Book updated successfully!";
    }

    // 5. API xóa sách (DELETE)
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "Book deleted successfully!";
    }
}
