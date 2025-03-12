package kotlinCoBan.bai2

class PhysicalBook(
    title: String,
    author: String,
    year: Int,
    genre: String,
    private val page: Int
) : Book(title, author, year, genre) {

    override fun getType() = "Sách giấy"

    override fun toString(): String {
        return "${super.toString()} - $page trang"
    }
}