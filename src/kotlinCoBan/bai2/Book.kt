package kotlinCoBan.bai2

// abstract class
abstract class Book(
    val title: String,
    val author: String,
    val year: Int,
    val genre: String,
    val id : String = generateId()
) {
    // companion object
    companion object {
        private var nextId: Int = 1
        fun generateId() : String{
            return "B-${nextId++}"
        }
    }

    // loại sách
    // abstract function
    abstract fun getType(): String

    // override
    override fun toString(): String {
        return "[$id] - $title - $author - $year - $genre - ${getType()}"
    }
}