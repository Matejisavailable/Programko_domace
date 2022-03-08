package umb.fpv.ki.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BorrowedEntity {
    @Id
    @GeneratedValue
    private String borrowedId;
    private String bookId;
    private String userId;

    public String getBorrowedId() {
        return borrowedId;
    }

    public void setBorrowedId(String borrowedId) {
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
