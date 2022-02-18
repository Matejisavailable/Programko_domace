package umb.fpv.ki.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoControler {

    private final List<Book> books = new ArrayList<>();


    @GetMapping("/books")
    public List<Book> get(){
        // List books = new ArrayList();
        //books.add(new Book("Lord of the rings"));
        //books.add(new Book("Boha"));

        return books;
        }


   /* @GetMapping("/books/{bookID}")
    public Book getBookByID(@PathVariable Integer bookID, @RequestParam String bookName) {
        return new Book("Lord of the Rings");
    }*/

    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    @PostMapping("/books/by-name")
    public Book create(@RequestParam String name) {
        Book book = new Book();
        book.name = name;
        books.add(book);
        return book;
    }
    /*class Book{

        public Book(String name){
            this.name = name;
        }

        public String name;
    }*/


}
