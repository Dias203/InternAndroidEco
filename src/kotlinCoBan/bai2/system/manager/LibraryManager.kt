package kotlinCoBan.bai2.system.manager

import kotlinCoBan.bai2.model.Book
import kotlinCoBan.bai2.model.User

interface LibraryManager {

    /**=========================================BOOKS==================================================*/

    // Thêm sách
    fun addBook(book: Book) {}

    // Hiển thị sách
    fun displayBooks() {}

    // Tìm sách theo ID
    fun findBookById(bookId: String): Book? {
        return null
    }

    // Tìm sách theo tiêu đề
    fun searchBookByTitle(title: String): List<Book> {
        return listOf()
    }

    fun updatePhysicalBook(bookId: String, publishYear: Int, pages: Int) {}

    // Cập nhật sách điện tử, tận dụng phương thức updateBook
    fun updateEBook(bookId: String, publishYear: Int, sizeMB: Double) {}


    // Xóa sách
    fun deleteBook(bookId: String): Boolean {
        return false
    }

    /**=========================================USERS==================================================*/
    // Thêm người dùng
    fun addUser(user: User) {}

    // Hiển thị người dùng
    fun displayUsers() {}

    // Tìm người dùng theo ID
    fun findUserById(userId: String): User? {
        return null
    }
    // Tìm người dùng theo tên
    fun findUserByName(userName: String): List<User> {
        return listOf()
    }

    // Lấy tất cả người dùng
    fun getAllUsers(): List<User> {
        return listOf()
    }
    fun updateUser(userId: String, userNewName: String, userNewEmail: String) {}
    fun deleteUser(userId: String): Boolean {
        return false
    }

    /**======================================BORROW BOOKS==================================================*/

    // Các phương thức ảo để BorrowManager ghi đè
    fun borrowBook(userId: String, bookId: String){}

    fun returnBook(userId: String, bookId: String){}

    fun displayBorrowedBooks(userId: String) {}

    // Phương thức lấy tổng số sách đang được mượn
    fun getTotalBorrowedBooks(): Int {
        return 0
    }

    fun getUserBorrowedBooksCount(userId: String): Int {
        return 0
    }
}