package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.Book;

import com.example.demo.service.BookService;

@Controller
@RequestMapping("")
public class BookController {
    @Autowired
    private BookService bookService;

    // Trang chủ
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Hiển thị danh sách sách
    @GetMapping("/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    // Hiển thị form thêm sách
    @GetMapping("/books/add")
    public String addBookForm() {
        return "add-book";
    }

    // Lưu sách mới
    @PostMapping("/books/save")
    public String saveBook(@RequestParam String title, @RequestParam String author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        // Tạo ID mới
        int maxId = bookService.getAllBooks().stream()
                .mapToInt(Book::getId)
                .max()
                .orElse(0);
        book.setId(maxId + 1);
        bookService.addBook(book);
        return "redirect:/books";
    }

    // Hiển thị form sửa sách
    @GetMapping("/books/edit/{id}")
    public String editBookForm(@PathVariable int id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "edit-book";
    }

    // Cập nhật sách
    @PostMapping("/books/update/{id}")
    public String updateBook(@PathVariable int id, @RequestParam String title, @RequestParam String author) {
        Book updatedBook = new Book();
        updatedBook.setTitle(title);
        updatedBook.setAuthor(author);
        bookService.updateBook(id, updatedBook);
        return "redirect:/books";
    }

    // Xóa sách
    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}