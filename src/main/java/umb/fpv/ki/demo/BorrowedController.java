package umb.fpv.ki.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BorrowedController {
    List<BorrowedBooks> borrow;
    public BorrowedController(){
        this.borrow = call();
    }

    public List<BorrowedBooks> call(){
        List<BorrowedBooks> borrowed = new ArrayList<>();
        BorrowedBooks borrow1 = new BorrowedBooks();
        borrow1.setBorrowId("1");
        borrowed.add(borrow1);
        return borrowed;
    }

    @GetMapping("/api/BorrowedBooks")
    public List<BorrowedBooks> getBorrowings(@RequestParam(required = false) String borrowingId){
        if(borrowingId == null){
            return this.borrow;
        }
        List<BorrowedBooks> Borrowings = new ArrayList<>();
        for (BorrowedBooks borrow : borrow){
            if(borrow.getBorrowId().equals(borrowingId)){
                Borrowings.add(borrow);
            }
        }
        return Borrowings;
    }

    @PostMapping("api/BorrowedBooks")
    public  List<BorrowedBooks> createBorrowing(@RequestBody BorrowedBooks borrowed){
        this.borrow.add(borrowed);

        return borrow;
    }

    @DeleteMapping("/api/BorrowedBooks/{borrowId}")
    public void deleteBorrowing(@PathVariable Integer borrowId){
        this.borrow.remove(this.borrow.get(borrowId));
    }
}