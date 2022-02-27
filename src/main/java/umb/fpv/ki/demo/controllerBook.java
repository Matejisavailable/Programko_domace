package umb.fpv.ki.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class controllerBook {
    private BookService bookService;

    public controllerBook(BookService bookService){
        this.bookService = bookService;
    }

    List<Book> books;

    public controllerBook(){
        this.books = init();
    }

    public List<Book> init() {
        List<Book> books = new ArrayList<>();

        Book book1 = new Book();
        book1.setAuthor("J.K.Rowling");
        book1.setTitle("Harry Potter 1");
        book1.setIsbn("0123456789");
        book1.setId("1");
        books.add(book1);

        Book book2 = new Book();
        book2.setAuthor("J.K.Rowling");
        book2.setTitle("Harry Potter 2");
        book2.setIsbn("0223456789");
        book2.setId("2");
        books.add(book2);

        Book book3 = new Book();
        book3.setAuthor("Adolf Hitler");
        book3.setTitle("Mein Kampf");
        book3.setIsbn("0233456789");
        book3.setId("3");
        books.add(book3);

        return books;
    }

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String bookAuthor){
        if (bookAuthor == null){
            return bookService.getBooks();
        }

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books){
            if (book.getAuthor().equals(bookAuthor)){
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    @GetMapping("/api/book/{bookId}")
    public Book getBook(@PathVariable Integer bookId){
        return this.books.get(bookId);
    }

    @GetMapping("/api/id")
    public List<Book> getBookId(@RequestParam(required = false) String bookId){
        if (bookId == null){
            return this.books;
        }

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books){
            if (book.getId().equals(bookId)){
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    @GetMapping("/api/isbn")
    public List<Book> getBookIsbn(@RequestParam(required = false) String bookIsbn){
        if (bookIsbn == null){
            return this.books;
        }

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books){
            if (book.getIsbn().equals(bookIsbn)){
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    @PostMapping("/api/books")
    public List<Book> createBook(@RequestBody Book book){
        this.books.add(book);
        return books;
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        this.books.remove(this.books.get(bookId));
    }

    @PutMapping("/api/books/{bookId}")
    public List<Book> putBook(@PathVariable Integer bookId, @RequestBody Book book){
        this.books.get(bookId).setId(book.getId());
        this.books.get(bookId).setAuthor(book.getAuthor());
        this.books.get(bookId).setTitle(book.getTitle());
        this.books.get(bookId).setIsbn(book.getIsbn());
        return books;
    }
}
