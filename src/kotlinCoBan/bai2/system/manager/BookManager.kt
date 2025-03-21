package kotlinCoBan.bai2.system.manager

import kotlinCoBan.bai2.model.Book
import kotlinCoBan.bai2.model.EBook
import kotlinCoBan.bai2.model.PhysicalBook
import kotlinCoBan.bai2.utils.book.updateBookDetails
import kotlinCoBan.bai2.utils.book.updatePages
import kotlinCoBan.bai2.utils.book.updateSize

open class BookManager : LibraryManager {
    private val books = mutableListOf<Book>()

    override fun addBook(book: Book) {
        books.add(book)
        println("Đã thêm sách thành công!")
    }

    override fun displayBooks() {
        println("=== Danh sách sách (${books.size} cuốn) ===")
        if (books.isEmpty()) {
            println("Thư viện hiện không có sách!")
            return
        }
        books.forEach { println(it) }
    }

    override fun findBookById(bookId: String): Book? =
        books.find { it.id == bookId }

    override fun searchBookByTitle(title: String): List<Book> {
        val results = books.filter {
            it.title.contains(title, ignoreCase = true)
        }
        displaySearchResults(title, results)
        return results
    }

    override fun updatePhysicalBook(bookId: String, publishYear: Int, pages: Int) {
        val book = findBookById(bookId) ?: return println("Không tìm thấy sách với ID: $bookId")

        if (book !is PhysicalBook) {
            println("Lỗi: Sách với ID $bookId không phải sách giấy!")
            return
        }

        updateBookDetails(book, publishYear, pages)
    }

    override fun updateEBook(bookId: String, publishYear: Int, sizeMB: Double) {
        val book = findBookById(bookId) ?: return println("Không tìm thấy sách với ID: $bookId")

        if (book !is EBook) {
            println("Lỗi: Sách với ID $bookId không phải sách điện tử!")
            return
        }

        updateBookDetails(book, publishYear, sizeMB)
    }

    private fun displaySearchResults(title: String, results: List<Book>) {
        println("=== Kết quả tìm kiếm cho '$title' (${results.size} cuốn) ===")
        if (results.isEmpty()) {
            println("Không tìm thấy kết quả nào!")
        } else {
            results.forEachIndexed { index, book ->
                println("${index + 1}. $book")
            }
        }
    }

    private fun updateBookDetails(book: PhysicalBook, publishYear: Int, pages: Int) {
        val isBaseUpdated = book.updateBookDetails(publishYear)
        val isSizeUpdated = book.updatePages(pages)
        displayUpdateResult(book, isBaseUpdated && isSizeUpdated)
    }

    private fun updateBookDetails(book: EBook, publishYear: Int, sizeMB: Double) {
        val isBaseUpdated = book.updateBookDetails(publishYear)
        val isSizeUpdated = book.updateSize(sizeMB)
        displayUpdateResult(book, isBaseUpdated && isSizeUpdated)
    }

    private fun displayUpdateResult(book: Book, isSuccess: Boolean) {
        if (isSuccess) {
            println("Cập nhật thông tin sách thành công!")
            println("Thông tin sách sau khi cập nhật: $book")
        } else {
            println("Có lỗi khi cập nhật thông tin sách!")
        }
    }
}