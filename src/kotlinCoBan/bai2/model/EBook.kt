package kotlinCoBan.bai2.model

import kotlinCoBan.bai2.utils.TypeBook

// class, inheritance
class EBook(
    title: String,
    author: String,
    year: Int,
    genre: String,
    var sizeMB: Double
) : Book(title, author, year, genre) {

    // override function
    override fun getType() = TypeBook.EBOOK

    override fun toString(): String {
        return "${super.toString()} Kích thước: $sizeMB MB"
    }

}