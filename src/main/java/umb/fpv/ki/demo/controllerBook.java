package umb.fpv.ki.demo;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class controllerBook {
    private List<Book> books;
    private BookService bookservice;
    private controllerBook(BookService bookservice){
        this.bookservice = bookservice;

    }

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String bookAuthor){
            return bookservice.getBooks(bookAuthor);
        }

    @GetMapping("/api/book/{bookId}")
    public Book getBook(@PathVariable(required = false) Integer bookId){
        return this.bookservice.getBook(bookId);
    }

    @GetMapping("/api/id")
    public List<Book> getBookId(@RequestParam(required = false) String bookId){
        return bookservice.getBookId(bookId);
    }

    @GetMapping("/api/isbn")
    public List<Book> getBookIsbn(@RequestParam(required = false) String bookIsbn){
            return bookservice.getBookIsbn(bookIsbn);
    }

    @PostMapping("/api/books")
    public List<Book> createBook(@RequestBody Book book){
        return bookservice.createBook(book);
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        this.bookservice.deleteBook(bookId);
    }

    @PutMapping("/api/books/{bookId}")
    public List<Book> putBook(@PathVariable Integer bookId, @RequestBody Book book) {
        return this.bookservice.putBook(bookId, book);
    }
    }
