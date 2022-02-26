package umb.fpv.ki.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Service
public class BorrowedService {
    private List<BorrowedBooks> borrow;

    public BorrowedService(){
        this.borrow = ini();
    }

    public List<BorrowedBooks> ini(){
        List<BorrowedBooks> borrowed = new ArrayList<>();
        BorrowedBooks borrow1 = new BorrowedBooks();
        borrow1.setBorrowId("1");
        borrowed.add(borrow1);
        return borrowed;
    }
    public List<BorrowedBooks> getBorrowings(String borrowingId){
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
    public  List<BorrowedBooks> createBorrowing(BorrowedBooks borrowed){
        this.borrow.add(borrowed);
        return borrow;
    }
    public void deleteBorrowing(int borrowId){
        this.borrow.remove(this.borrow.get(borrowId));
    }
}

