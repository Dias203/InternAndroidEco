package kotlinCoBan.bai2.system.handler

import kotlinCoBan.bai2.model.Book
import kotlinCoBan.bai2.model.EBook
import kotlinCoBan.bai2.model.PhysicalBook
import kotlinCoBan.bai2.system.manager.BookManager
import kotlinCoBan.bai2.system.manager.BorrowManager
import kotlinCoBan.bai2.utils.Menu

class BookHandler {
    private lateinit var bookManager: BookManager
    private lateinit var borrowManager: BorrowManager


    fun setBookAndBorrow(bookManager: BookManager, borrowManager: BorrowManager) {
        this.bookManager = bookManager
        this.borrowManager = borrowManager
    }


    fun handleBooksMenu() {
        var inBookMenu = true

        while (inBookMenu) {
            Menu.bookMenu()
            val bookChoice = readlnOrNull()?.toIntOrNull()

            when (bookChoice) {
                1 -> addBookIntoLibraryManager()
                2 -> updateBook()
                3 -> findBookByTitle()
                5 -> displayBooks()
                6 -> deleteBook()
                7 -> borrowBook()
                8 -> returnBook()
                9 -> getTotalBorrowedBooks()
                10 -> sortBooks2()
                11 -> filterBooks()
                0 -> inBookMenu = false
                else -> println("Lựa chọn không hợp lệ!")
            }
        }
    }

    private fun addBookIntoLibraryManager() {
        var input: Int?

        do {
            println("Chọn loại sách muốn thêm:")
            println("1. Sách giấy")
            println("2. Sách điện tử")
            print("Nhập lựa chọn của bạn: ")
            input = readlnOrNull()?.toIntOrNull()
            if (input != null && input != 1 && input != 2) {
                println("Lựa chọn không hợp lệ! Vui lòng chọn lại.")
            }
        } while (input == null || (input != 1 && input != 2))

        if (input == 1) {
            print("Nhập tên sách: ")
            val title = readlnOrNull()
            print("Nhập tên tác giả: ")
            val author = readlnOrNull()
            print("Nhập năm xuất bản: ")
            val year = readlnOrNull()?.toIntOrNull()
            print("Nhập thể loại sách: ")
            val genre = readlnOrNull()
            print("Nhập số trang: ")
            val page = readlnOrNull()?.toIntOrNull()

            if (title.isNullOrBlank() || author.isNullOrBlank() || genre.isNullOrBlank() || year == null || page == null) {
                println("Lỗi: Vui lòng nhập đầy đủ và chính xác thông tin sách.")
            } else {
                val book = PhysicalBook(title, author, year, genre, page)
                bookManager.addBook(book)
            }
        } else {
            print("Nhập tên sách: ")
            val title = readlnOrNull()
            print("Nhập tên tác giả: ")
            val author = readlnOrNull()
            print("Nhập năm xuất bản: ")
            val year = readlnOrNull()?.toIntOrNull()
            print("Nhập thể loại sách: ")
            val genre = readlnOrNull()
            print("Nhập kích thước (MB) của sách: ")
            val sizeMB = readlnOrNull()?.toDoubleOrNull()

            if (title.isNullOrBlank() || author.isNullOrBlank() || genre.isNullOrBlank() || year == null || sizeMB == null) {
                println("Lỗi: Vui lòng nhập đầy đủ và chính xác thông tin sách.")
            } else {
                val book = EBook(title, author, year, genre, sizeMB)
                bookManager.addBook(book)
            }
        }
    }

    private fun findBookByTitle() {
        do {
            print("Nhập tên sách: ")
            val bookTitle = readlnOrNull()

            if (bookTitle.isNullOrBlank()) {
                println("Lỗi: Vui lòng nhập đầy đủ thông tin!")
            } else {
                bookManager.searchBookByTitle(bookTitle)
            }
        } while (bookTitle.isNullOrBlank())
    }

    private fun displayBooks() {
        bookManager.displayBooks()
    }

    private fun borrowBook() {
        do {
            print("Nhập UserID: ")
            val userID = readlnOrNull()
            print("Nhập BookID: ")
            val bookID = readlnOrNull()

            if (userID.isNullOrBlank() || bookID.isNullOrBlank()) {
                println("Lỗi: Vui lòng nhập đầy đủ thông tin!")
            } else {
                borrowManager.borrowBook(userID, bookID)
            }
        } while (userID.isNullOrBlank() || bookID.isNullOrBlank())
    }

    private fun returnBook() {
        do {
            print("Nhập UserID: ")
            val userID = readlnOrNull()
            print("Nhập BookID: ")
            val bookID = readlnOrNull()

            if (userID.isNullOrBlank() || bookID.isNullOrBlank()) {
                println("Lỗi: Vui lòng nhập đầy đủ thông tin!")
            } else {
                borrowManager.returnBook(userID, bookID)
            }
        } while (userID.isNullOrBlank() || bookID.isNullOrBlank())
    }

    private fun updateBook() {
        // Nhập và kiểm tra BookID
        var bookID: String?
        do {
            print("Nhập BookID cần cập nhật: ")
            bookID = readlnOrNull()
            if (bookID.isNullOrBlank()) {
                println("Lỗi: ID sách không được để trống! Vui lòng nhập lại.")
            }
        } while (bookID.isNullOrBlank())

        val book = bookManager.findBookById(bookID)
        if (book == null) {
            println("Không tìm thấy sách với ID: $bookID")
            return
        }

        println("Thông tin sách hiện tại: $book")
        println("Nhập thông tin mới:")

        // Nhập và kiểm tra năm xuất bản
        var newYear: Int?
        do {
            print("Năm xuất bản mới: ")
            val newYearStr = readlnOrNull()
            newYear = if (newYearStr.isNullOrBlank()) null else newYearStr.toIntOrNull()
            if (newYearStr.isNullOrBlank()) {
                println("Lỗi: Năm xuất bản không được để trống! Vui lòng nhập lại.")
            } else if (newYear == null) {
                println("Lỗi: Năm xuất bản phải là số nguyên! Vui lòng nhập lại.")
            }
        } while (newYear == null)

        when {
            book is PhysicalBook -> {
                // Nhập và kiểm tra số trang
                var newPages: Int?
                do {
                    print("Số trang mới: ")
                    val newPagesStr = readlnOrNull()
                    newPages = if (newPagesStr.isNullOrBlank()) null else newPagesStr.toIntOrNull()
                    if (newPagesStr.isNullOrBlank()) {
                        println("Lỗi: Số trang không được để trống! Vui lòng nhập lại.")
                    } else if (newPages == null) {
                        println("Lỗi: Số trang phải là số nguyên! Vui lòng nhập lại.")
                    }
                } while (newPages == null)

                bookManager.updatePhysicalBookWithCoroutine(bookID, newYear, newPages)
            }
            else -> {
                // Nhập và kiểm tra kích thước
                var newSize: Double?
                do {
                    print("Kích thước mới: ")
                    val newSizeStr = readlnOrNull()
                    newSize = if (newSizeStr.isNullOrBlank()) null else newSizeStr.toDoubleOrNull()
                    if (newSizeStr.isNullOrBlank()) {
                        println("Lỗi: Kích thước không được để trống! Vui lòng nhập lại.")
                    } else if (newSize == null) {
                        println("Lỗi: Kích thước phải là số! Vui lòng nhập lại.")
                    }
                } while (newSize == null)

                bookManager.updateEBookWithCoroutine(bookID, newYear, newSize)
            }
        }
        println("Cập nhật sách thành công!")
    }



    private fun deleteBook() {
        print("Nhập BookID cần xóa: ")
        val bookID = readlnOrNull()

        if (bookID.isNullOrBlank()) {
            println("Lỗi: ID sách không được để trống!")
            return
        }

        bookManager.deleteWithCoroutine(bookID)
    }

    private fun getTotalBorrowedBooks() {
        val result = borrowManager.getTotalBorrowedBooks()
        println("Tổng số sách đang được mượn là: $result")
    }


    /*
    // Kotlin Reflection
    private fun sortBooks() {
        // Sắp xếp theo year, nếu bằng thì theo title dùng reflection
        bookManager.displayBooks { book1, book2 ->
            val yearComparison = Book::year.get(book1) - Book::year.get(book2)
            if (yearComparison != 0) yearComparison
            else Book::title.get(book1).compareTo(Book::title.get(book2))
        }
    }

     */

    // Comparator
    private fun sortBooks2() {
        // Tạo Comparator: year -> title -> sizeMB (EBook) hoặc pages (PhysicalBook)
        val customComparator: Comparator<Book> = compareBy<Book> { Book::year.get(it) }
            .thenBy { Book::title.get(it) }
            .thenBy { book ->
                when (book) {
                    is EBook -> book.sizeMB // Sắp xếp theo sizeMB cho EBook
                    is PhysicalBook -> book.page // Chuyển pages thành Double cho PhysicalBook
                    else -> 0.0 // Trường hợp mặc định (nếu có loại sách khác)
                }
            }

        // Sử dụng Comparator trong displayBooks
        bookManager.displayBooks { book1, book2 ->
            customComparator.compare(book1, book2)
        }
    }

    private fun filterBooks() {
        bookManager.filterBooks(
            {book: Book -> book is PhysicalBook },
            {book: Book -> (book as PhysicalBook).page > 300 }
        )
    }
}