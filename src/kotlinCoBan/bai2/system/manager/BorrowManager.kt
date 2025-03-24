package kotlinCoBan.bai2.system.manager

import kotlinCoBan.bai2.utils.book.borrowBook
import kotlinCoBan.bai2.utils.book.returnBook

class BorrowManager(
    private var bookManager: BookManager = BookManager(),
    private var userManager: UserManager = UserManager()
) : LibraryManager {
    private val borrowedBooks = mutableMapOf<String, MutableList<String>>()

    override fun borrowBook(userId: String, bookId: String) {
        val user = userManager.findUserById(userId) ?: return println("Lỗi: Không tìm thấy người dùng với ID: $userId!")
        val book = bookManager.findBookById(bookId) ?: return println("Lỗi: Không tìm thấy sách với ID: $bookId!")

        borrowedBooks.borrowBook(userId, bookId, user, book)
    }

    override fun returnBook(userId: String, bookId: String) {
        val user = userManager.findUserById(userId) ?: return println("Lỗi: Không tìm thấy người dùng với ID: $userId!")
        val book = bookManager.findBookById(bookId) ?: return println("Lỗi: Không tìm thấy sách với ID: $bookId!")

        borrowedBooks.returnBook(userId, bookId, user, book)
    }

    override fun displayBorrowedBooks(userId: String) {
        val user = userManager.findUserById(userId) ?: return println("Lỗi: Không tìm thấy người dùng!")

        val borrowedBookIds = borrowedBooks[userId]
        println("=== Sách đã mượn của ${user.name} ===")

        if (borrowedBookIds.isNullOrEmpty()) {
            println("${user.name} chưa mượn sách nào.")
            return
        }

        val borrowedBooksList = borrowedBookIds.mapNotNull { bookManager.findBookById(it) }
        borrowedBooksList.forEachIndexed { index, book ->
            println("${index + 1}. $book")
        }
    }

    override fun getUserBorrowedBooksCount(userId: String): Int =
        borrowedBooks[userId]?.size ?: 0

    override fun getTotalBorrowedBooks(): Int =
        borrowedBooks.values.sumOf { it.size }
}