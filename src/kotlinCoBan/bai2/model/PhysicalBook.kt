package kotlinCoBan.bai2.model

import kotlinCoBan.bai2.utils.TypeBook

class PhysicalBook(
    title: String,
    author: String,
    year: Int,
    genre: String,
    var page: Int
) : Book(title, author, year, genre) {

    override fun getType() = TypeBook.PAPER_BOOK

    override fun toString(): String {
        return "${super.toString()} $page trang"
    }
}