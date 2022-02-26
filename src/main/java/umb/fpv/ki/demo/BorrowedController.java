package umb.fpv.ki.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BorrowedController {
    private List<BorrowedBooks> borrow;
    private BorrowedService borrowedService;
    public BorrowedController(BorrowedService borrowedService){
        this.borrowedService = borrowedService;
    }
    @GetMapping
    public List<BorrowedBooks> getBorrowings(@RequestParam String borrowingId){
        return this.borrowedService.getBorrowings(borrowingId);
    }
    @PostMapping
    public  List<BorrowedBooks> createBorrowing(@RequestBody BorrowedBooks borrowed){
        return borrowedService.createBorrowing(borrowed);
    }
    @DeleteMapping
    public void deleteBorrowing(@PathVariable Integer borrowId){
        this.borrowedService.deleteBorrowing(borrowId);
    }
}