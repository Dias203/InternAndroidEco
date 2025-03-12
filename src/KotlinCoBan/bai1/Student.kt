package KotlinCoBan.bai1

class Student(
    var id: Int,
    var name: String,
    var age: Int,
    var gpa: Float,
    var gender: Char,
    var scholarship: Boolean
) {
    fun displayInfo() {
        println("ID: $id, Name: $name, Age: $age, GPA: $gpa, Gender: $gender, Scholarship: $scholarship")
    }
}