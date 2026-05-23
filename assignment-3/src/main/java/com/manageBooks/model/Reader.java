package com.manageBooks.model;

public class Reader {
    private String readerId;
    private String readerName;
    private String readerEmail;
    private ReaderType readerType;
    private int readerBorrowBooksCount;

    // Constructor
    public Reader(String readerId, String readerName, String readerEmail, ReaderType readerType, int readerBorrowBooksCount) {
        this.readerId = readerId;
        this.readerName = readerName;
        this.readerEmail = readerEmail;
        this.readerType = readerType;
        this.readerBorrowBooksCount = readerBorrowBooksCount;
    }

    // Getter - Setter
    public String getReaderId() {
        return readerId;
    }
    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getReaderName() {
        return readerName;
    }
    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getReaderEmail() {
        return readerEmail;
    }
    public void setReaderEmail(String readerEmail) {
        this.readerEmail = readerEmail;
    }

    public ReaderType getReaderType() {
        return readerType;
    }
    public void setReaderType(ReaderType readerType) {
        this.readerType = readerType;
    }

    public int getReaderBorrowBooksCount() {
        return readerBorrowBooksCount;
    }

    // register()
    public String readerRegister() {
        return "[ " + readerName + " đã đăng kí thẻ thư viện ]";
    }

    // increaseBorrowedBooksCount()
    public void increaseBorrowedBooksCount() {
        readerBorrowBooksCount++;
    }

    public void decreaseBorrowedBooksCount() {
        if (readerBorrowBooksCount > 0) {
            readerBorrowBooksCount--;
        }
    }

    // Log info
    public String readerInfo() {
        return "===== READER INFORMATION =====\n" +
                "ID      : " + readerId + "\n" +
                "Name    : " + readerName + "\n" +
                "Email   : " + readerEmail + "\n" +
                "Type    : " + readerType;
    }
}
