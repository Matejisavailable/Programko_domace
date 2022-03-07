package umb.fpv.ki.demo;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class BorrowedController {

    private BorrowedService borrowedService;

    public BorrowedController(BorrowedService borrowedService){
        this.borrowedService = borrowedService;
    }
    @GetMapping("/api/borrowings")
    public List<BorrowedDto> getBorrowings(@RequestParam String borrowingId){
        return this.borrowedService.getBorrowings(borrowingId);
    }
    @GetMapping("/api/borrowings/{borrowingId}")
    public BorrowedDto getBorrowId(@PathVariable String borrowingId){
        return this.borrowedService.getBorrowId(borrowingId);
    }
    @PostMapping("/api/borrowings")
    public String createBorrowing(@RequestBody BorrowedDto borrowedDto){
        return borrowedService.createBorrowing(borrowedDto);
    }
    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowing(@PathVariable Integer borrowId){
        this.borrowedService.deleteBorrowing(borrowId);
    }
}