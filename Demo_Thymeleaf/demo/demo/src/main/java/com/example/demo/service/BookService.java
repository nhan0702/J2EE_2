package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>(List.of(
            new Book(1, "1984", "George Orwell"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "The Great Gatsby", "F. Scott Fitzgerald")));

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst().orElse(null);
    }

    public void addBook(Book book) {
        books.add(book);

    }

    public void updateBook(int id, Book updatedBook) {
        books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .ifPresent(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                });
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
        // Cập nhật ID sau khi xóa sách
        reorganizeBookIds();
    }

    public void reorganizeBookIds() {
        for (int i = 0; i < books.size(); i++) {
            books.get(i).setId(i + 1);
        }
    }
}
