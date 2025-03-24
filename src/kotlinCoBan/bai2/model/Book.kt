package kotlinCoBan.bai2.model

import kotlinCoBan.bai2.utils.BookIdGenerator.generateId
import kotlinCoBan.bai2.utils.TypeBook

// abstract class
abstract class Book(
    var title: String,
    private var author: String,
    var year: Int,
    private val genre: String,
    val id : String = generateId()
) {


    // loại sách
    // abstract function
    abstract fun getType() : TypeBook

    // override
    override fun toString(): String {
        return String.format(
            "| %-5s | %-35s | %-20s | %-4d | %-20s | %-15s |",
            id, title, author, year, genre, getType()
        )
    }

}