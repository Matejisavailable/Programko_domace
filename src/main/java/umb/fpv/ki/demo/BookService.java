package umb.fpv.ki.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public List<Book> getBooks(){
        return books;
    }

    public Book createBook(Book book){
        books.add(book);
        return book;
    }

    public Book getById(Integer id){
        return null;
    }


}
