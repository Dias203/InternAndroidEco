package kotlinCoBan.bai2.model

import kotlinCoBan.bai2.utils.BookIdGenerator.generateId

// abstract class
abstract class Book(
    var title: String,
    var author: String,
    var year: Int,
    private val genre: String,
    val id : String = generateId()
) {


    // loại sách
    // abstract function
    abstract fun getType(): String

    // override
    override fun toString(): String {
        return "[$id] - $title - $author - $year - $genre - ${getType()}"
    }

}