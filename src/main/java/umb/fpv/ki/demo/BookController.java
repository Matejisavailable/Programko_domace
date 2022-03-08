package umb.fpv.ki.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<BookDto> getBooks(@RequestParam(required = false) String bookAuthor) {
        return bookService.getBooks(bookAuthor);
    }

    @GetMapping("/api/books/{bookId}")
    public BookDto getBook(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping("/api/books")
    public String createBook(@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable int bookId) {
        bookService.deleteBook(bookId);
    }

    @PutMapping("/api/books/{bookId}")
    public void updateBook(@PathVariable int bookId, @RequestBody BookDto bookDto) {
        bookService.updateBook(bookId, bookDto);
    }
}
