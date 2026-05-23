# LIBRARY MANAGEMENT SYSTEM

## 1. Problem Analysis

### Book

```text
Book
- bookId : String
- title : String
- author : String
- year : int
- quantity : int
- borrowCount : int

+ isAvailable() : boolean
+ decreaseQty() : void
+ increaseQty() : void
+ increaseBorrowCount() : void
+ bookInfo() : String
```

### Reader

```text
Reader
- readerId : String
- readerName : String
- email : String
- readerType : ReaderType
- borrowedBooksCount : int
- totalBorrowCount : int

+ register() : String
+ increaseBorrowedBooksCount() : void
+ decreaseBorrowedBooksCount() : void
+ increaseTotalBorrowCount() : void
+ displayInfo() : String
```

### ReaderType (Enum)

```text
ReaderType
- STUDENT
- TEACHER
```

### Librarian

```text
Librarian
- librarianId : String
- librarianName : String

+ checkCard(Reader) : boolean
+ checkBookAvailability(Book) : boolean
+ librarianInfo() : String
```

### BorrowSlip

```text
BorrowSlip
- borrowSlipId : String
- reader : Reader
- book : Book
- borrowDate : LocalDate
- dueDate : LocalDate
- returnDate : LocalDate

+ setReturnDate(LocalDate) : void
+ isOverdue(LocalDate) : boolean
+ getLateDays(LocalDate) : long
+ calculateFine(LocalDate) : double
+ displayInfo() : String
```

### Library

```text
Library
- books : List<Book>
- readers : List<Reader>
- borrowSlips : List<BorrowSlip>

+ addBook(Book) : void
+ addReader(Reader) : void

+ borrowBook(...) : BorrowSlip
+ returnBook(...) : double

+ searchBookByTitle(String) : List<Book>
+ searchBookByAuthor(String) : List<Book>

+ getOverdueSlips(LocalDate) : List<BorrowSlip>

+ getMostBorrowedBook() : Book
+ getMostActiveReader() : Reader
```

---

## 2. Relationships Between Classes

### Association

```text
BorrowSlip ------ Reader
BorrowSlip ------ Book
```

Mỗi phiếu mượn thuộc về:

- 1 độc giả
- 1 cuốn sách

---

### Aggregation

```text
Library
 ├── List<Book>
 ├── List<Reader>
 └── List<BorrowSlip>
```

Library quản lý toàn bộ dữ liệu của hệ thống.

---

## 3. Business Rules

### Borrow Book

- Chỉ được mượn khi:

```text
quantity > 0
```

- Khi mượn thành công:

```text
quantity = quantity - 1
borrowedBooksCount++
totalBorrowCount++
borrowCount++
```

---

### Return Book

- Khi trả sách:

```text
quantity = quantity + 1
borrowedBooksCount--
```

- Nếu trả trễ:

```text
fine = lateDays × 5000
```

---

### Reader Type Constraints

#### Student

```text
Maximum 3 books
```

#### Teacher

```text
Maximum 5 books
```

Nếu vượt quá giới hạn:

```text
Borrow request is rejected
```

---

### Search Book

Tìm kiếm theo:

- Tên sách
- Tác giả

Điều kiện:

```text
Case-insensitive
Partial matching
```



---

### Overdue Borrow Slips

Liệt kê các phiếu:

```text
returnDate == null
AND
currentDate > dueDate
```

---

## 4. Statistics (Bonus)

### Most Borrowed Book

Sách có:

```text
borrowCount lớn nhất
```

---

### Most Active Reader

Độc giả có:

```text
totalBorrowCount lớn nhất
```

---

## 5. Class Implementation 

```text
1. ReaderType
2. Reader
3. Book
4. BorrowSlip
5. Librarian
6. Library
7. Main
```

