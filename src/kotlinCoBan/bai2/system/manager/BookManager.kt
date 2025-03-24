package kotlinCoBan.bai2.system.manager

import kotlinCoBan.bai2.model.Book
import kotlinCoBan.bai2.model.EBook
import kotlinCoBan.bai2.model.PhysicalBook
import kotlinCoBan.bai2.utils.book.DataBook
import kotlinCoBan.bai2.utils.book.updateBookDetails
import kotlinCoBan.bai2.utils.book.updatePages
import kotlinCoBan.bai2.utils.book.updateSize
import kotlinCoBan.bai2.utils.displayAll
import kotlinx.coroutines.*

open class BookManager : LibraryManager {
    private val books = mutableListOf<Book>()

    override fun addBook(book: Book) {
        books.add(book)
        println("Đã thêm sách thành công!")
    }


    override fun displayBooks(sortBy: ((Book, Book) -> Int)?) {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            // Phần code hiển thị danh sách
            println("=== Danh sách sách (${DataBook.listDataBook.size} cuốn) ===")
            if (DataBook.listDataBook.isEmpty()) {
                println("Thư viện hiện không có sách!")
                return@launch
            }

            val sortedBooks = sortBy?.let { DataBook.listDataBook.sortedWith(it) } ?: DataBook.listDataBook
            sortedBooks.displayAll { it.toString() }
        }
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

    // Thêm hàm lọc sách
    override fun filterBooks(vararg predicates: (Book) -> Boolean): List<Book> {
        var filteredBooks = DataBook.listDataBook.toList()
        predicates.forEach { predicate ->
            filteredBooks = filteredBooks.filter(predicate)
        }
        displayFilteredResults(filteredBooks)
        return filteredBooks
    }

    private fun displayFilteredResults(results: List<Book>) {
        println("=== Kết quả lọc (${results.size} cuốn) ===")
        if (results.isEmpty()) {
            println("Không tìm thấy sách nào phù hợp với điều kiện!")
        } else {
            results.forEachIndexed { index, book ->
                println("${index + 1}. $book")
            }
        }
    }

    // suspend fun, dispatcher
    override suspend fun addWithCoroutine(book: Book) {
          withContext(Dispatchers.IO) {
              books.add(book)
              println("Đã thêm sách thành công!")
          }
    }

    // launch, coroutine scope
    fun updateEBookWithCoroutine(bookId: String, publishYear: Int, sizeMB : Double) {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            val book = findBookById(bookId) ?: return@launch println("Không tìm thấy sách với ID: $bookId")

            if(book !is EBook) {
                println("Lỗi: Sách với ID $bookId không phải sách điện tử!")
                return@launch
            }
            updateEBookDetailsWithCoroutine(book, publishYear, sizeMB)
        }
    }
    private suspend fun updateEBookDetailsWithCoroutine(book: EBook, publishYear: Int, sizeMB: Double) {
        withContext(Dispatchers.IO) {
            val isBaseUpdated = book.updateBookDetails(publishYear)
            val isSizeUpdated = book.updateSize(sizeMB)
            displayUpdateResult(book, isBaseUpdated && isSizeUpdated)
        }
    }

    fun updatePhysicalBookWithCoroutine(bookId: String, publishYear: Int, pages: Int) {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            val book = findBookById(bookId) ?: return@launch println("Không tìm thấy sách với ID: $bookId")

            if(book !is PhysicalBook) {
                println("Lỗi: Sách với ID $bookId không phải sách điện tử!")
                return@launch
            }
            updatePhysicalBookDetailsWithCoroutine(book, publishYear, pages)
        }
    }

    private suspend fun updatePhysicalBookDetailsWithCoroutine(book: PhysicalBook, publishYear: Int, pages: Int) {
        withContext(Dispatchers.IO) {
            val isBaseUpdated = book.updateBookDetails(publishYear)
            val isSizeUpdated = book.updatePages(pages)
            displayUpdateResult(book, isBaseUpdated && isSizeUpdated)
        }
    }

    // async
    override fun deleteWithCoroutine(bookId: String) = runBlocking {
        val result = async {
            findBookById(bookId)?.let {
                books.remove(it)
                "Xóa sách có ID: $bookId thành công"
            } ?: run {
                "Không tìm thấy sách với ID: $bookId"
            }
        }
        println(result.await())
    }

    override fun deleteWithCoroutine2(bookId: String) {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            val result = async {
                findBookById(bookId)?.let {
                    books.remove(it)
                    "Xóa sách có ID: $bookId thành công"
                } ?: run {
                    "Không tìm thấy sách với ID: $bookId"
                }
            }
            println(result.await())
        }
    }



}