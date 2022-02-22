package umb.fpv.ki.demo;

public class BorrowedBooks {

        private String borrowId;
        public String bookId;
        public String userId;
        public String getBorrowId() {
            return borrowId;
        }
        public void setBorrowId(String borrowId) {
            this.borrowId = borrowId;
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
