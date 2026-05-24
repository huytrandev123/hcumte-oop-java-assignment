package org.example.model;

public class Student extends Reader {
    private String studentCard;

    public Student(String readerId,
                   String fullName,
                   String email,
                   String studentCard) {

        super(readerId, fullName, email);

        this.studentCard = studentCard;
    }

    public String getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(String studentCard) {
        this.studentCard = studentCard;
    }

    @Override
    public int getMaxBorrow() {
        return 3;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", studentCard='" + studentCard + '\''
                + ", maxBorrow=" + getMaxBorrow();
    }
}
