package phattrienungdungj2ee.bai2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phattrienungdungj2ee.bai2.model.Book;
import phattrienungdungj2ee.bai2.service.BookService;

@Controller // Lưu ý: Dùng @Controller thay vì @RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 1. Hiển thị danh sách sách
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books"; // Trả về file books.html
    }

    // 2. Hiển thị form thêm sách
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book"; // Trả về file add-book.html
    }

    // 3. Xử lý thêm sách mới
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/books"; // Chuyển hướng về trang danh sách
    }

    // 4. Hiển thị form sửa sách
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "edit-book"; // Trả về file edit-book.html
    }

    // 5. Xử lý cập nhật sách
    @PostMapping("/edit")
    public String updateBook(@ModelAttribute Book book) {
        bookService.updateBook(book);
        return "redirect:/books";
    }

    // 6. Xử lý xóa sách
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
