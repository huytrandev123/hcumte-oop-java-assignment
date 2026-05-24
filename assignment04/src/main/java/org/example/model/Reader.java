package org.example.model;

public class Reader {
    private String readerId;
    private String fullName;
    private String email;

    public Reader(String readerId, String fullName, String email) {
        this.readerId = readerId;
        this.fullName = fullName;
        this.email = email;
    }

    // Getter
    public String getReaderId() {
        return readerId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    // Setter
    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMaxBorrow() {
        return 0;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId='" + readerId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
