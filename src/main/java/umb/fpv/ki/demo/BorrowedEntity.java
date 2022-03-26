package umb.fpv.ki.demo;

import javax.persistence.*;

@Entity
public class BorrowedEntity {
    @Id
    @GeneratedValue
    private long borrowedId;
    private String bookId;
    private String userId;



    public long getBorrowedId() {
        return borrowedId;
    }

    public void setBorrowedId(Long borrowedId) {
        this.borrowedId = borrowedId;
    }

   public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
