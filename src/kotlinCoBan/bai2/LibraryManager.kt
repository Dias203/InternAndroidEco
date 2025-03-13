package kotlinCoBan.bai2

class LibraryManager {
    private val books = mutableListOf<Book>()
    private val users = mutableListOf<User>()
    private val borrowedBooks = mutableMapOf<String, MutableList<String>>() // đánh dấu danh sách sách người dùng mượn

    //function
    fun addBook(book: Book) {
        books.add(book)
        println("Thêm sách thành công!")
    }

    fun addUser(user: User) {
        users.add(user)
        println("Thêm người dùng thành công!")
    }

    fun getAllUsers() : List<User> {
        return users
    }

    fun displayBooks() {
        println("=== Danh sách sách (${books.size} cuốn) ===")
        if (books.isEmpty()) {
            println("Không có sách trong thư viện!")
            return
        }

        for (item in books) {
            println(item.toString()) // Sử dụng extension function display()
        }
    }

    fun displayUsers() {
        println("=== Danh sách người dùng (${users.size} người) ===")
        if(users.isEmpty()) {
            println("Không có người dùng nào!")
            return
        }
        users.forEachIndexed { index:Int, user:User ->
            println("${index + 1} - $user ")
        }
    }

    // nullable
    private fun findBookById(bookId: String) : Book? {
        return books.find { it.id == bookId }
    }

    fun searchBookByTile(title: String) : List<Book>{
        val result = books.filter {
            it.title.contains(title, ignoreCase = true)
        }
        println("=== Kết quả tìm kiếm cho '$title' (${result.size} cuốn) ===")
        if(result.isEmpty()) {
            println("Không tìm thấy kết quả nào!")
        } else{
            result.forEachIndexed { index, book ->  println("${index + 1} - $book")}
        }
        return result
    }

    // nullable
    private fun findUserById(userId: String) : User? {
        return users.find { it.id == userId } //trả về phần tử đầu tiên thỏa mãn hoặc null nếu không thấy
    }

    fun findUserByName(userName: String) : List<User> {
        val result = users.filter {
            it.name.contains(userName, ignoreCase = true)
        }
        if(result.isEmpty()) {
            println("Không tìm thấy kết quả nào!")
        } else{
            result.forEachIndexed { index, user ->  println("${index + 1} - $user")}
        }
        return result
    }

    // Phương thức cho mượn sách
    fun borrowBook(userId: String, bookId: String) : Boolean {
        val user = findUserById(userId)
        val book = findBookById(bookId)

        if(user == null) {
            println("Lỗi: Không tìm thấy người dùng với ID = $userId!")
            return false
        }
        if(book == null) {
            println("Lỗi: Không tìm thấy sách với ID = $bookId!")
            return false
        }

        return borrowedBooks.borrowBook(userId, bookId, user, book)
    }

    // Phương thức trả sách
    fun returnBook(userId: String, bookId: String) : Boolean {
        val user = findUserById(userId)
        val book = findBookById(bookId)

        if(user == null) {
            println("Lỗi: Không tìm thấy người dùng với ID = $userId!")
            return false
        }
        if(book == null) {
            println("Lỗi: Không tìm thấy sách với ID = $bookId!")
            return false
        }

        return borrowedBooks.returnBook(userId, bookId, user, book)
    }

    fun displayBorrowedBooks(userId: String) {
        val user = findUserById(userId)

        if(user == null) {
            println("Lỗi: Không tìm thấy người dùng")
            return
        }

        //lấy danh sách đã mượn của userId, null nếu không tìm thấy userId
        val userBorrowedBooks = borrowedBooks[userId]

        println("=== SÁCH ĐÃ MƯỢN CỦA ${user.name} ===")
        if (userBorrowedBooks.isNullOrEmpty()) {
            println("${user.name} chưa mượn sách nào.")
            return
        }

        // Tìm thông tin chi chiết từng cuốn sách để log chi tiết ra
        val borrowedBooksList = userBorrowedBooks.mapNotNull { bookId ->
            findBookById(bookId)
        }

        borrowedBooksList.forEachIndexed { index, book ->
            println("${index + 1} - $book")
        }
    }
}

// Extension functions
fun MutableMap<String, MutableList<String>>.borrowBook(userId: String, bookId: String, user: User, book: Book): Boolean {
    // Kiểm tra sách được mượn bởi người nào chưa
    // nếu đã tồn tại key = userId thì sẽ get value là 1 danh sách sách đã mượn
    // nếu chưa tồn tại thì sẽ thêm cặp key - value là userId - list trống
    // getOrPut chỉ trả về giá trị value <=> mutableList
    val userBorrowedBooks = this.getOrPut(userId) { mutableListOf() }

    // kiểm tra nếu chứa Id sách muốn mượn trong list
    if (userBorrowedBooks.contains(bookId)) {
        println("Lỗi: ${user.name} đã mượn sách ${book.title} rồi!")
        return false
    }

    // nếu chưa tồn tại thì add vào list
    userBorrowedBooks.add(bookId)
    println("${user.name} đã mượn sách ${book.title} thành công!")
    return true
}

fun MutableMap<String, MutableList<String>>.returnBook(userId: String, bookId: String, user: User, book: Book): Boolean {
    val userBorrowedBooks = this[userId]

    if (userBorrowedBooks == null || !userBorrowedBooks.contains(bookId)) {
        println("Lỗi: ${user.name} chưa mượn sách ${book.title}!")
        return false
    }

    userBorrowedBooks.remove(bookId)
    println("${user.name} đã trả sách ${book.title} thành công!")
    return true
}