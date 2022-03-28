package umb.fpv.ki.demo;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class BorrowingController {

    private BorrowingService borrowedService;

    public BorrowingController(BorrowingService borrowedService){
        this.borrowedService = borrowedService;
    }

    @GetMapping("/api/borrowings")
    public List<BorrowedDTO> getBorrowings(@RequestParam(required = false) String borrowingId){
        return this.borrowedService.getBorrowings(borrowingId);
    }
    @GetMapping("/api/borrowings/{borrowingId}")
    public BorrowedDTO getBorrowId(@PathVariable String borrowingId){
        return this.borrowedService.getBorrowId(borrowingId);
    }
    @PostMapping("/api/borrowings")
    public long createBorrowing(@RequestBody BorrowedDTO borrowedDto){
        return borrowedService.createBorrowing(borrowedDto);
    }
    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowing(@PathVariable Integer borrowId){
        this.borrowedService.deleteBorrowing(borrowId);
    }
}