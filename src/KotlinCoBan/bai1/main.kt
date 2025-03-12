package KotlinCoBan.bai1


fun main() {



    val listStudent =  listOf(
        Student(1, "Nguyen Van A", 19, 8.5f, 'M', true),
        Student(2, "Tran Thi B", 22, 6.2f, 'F', false),
        Student(3, "Le Van C", 17, 9.0f, 'M', true),
        Student(4, "Pham Thi D", 21, 5.5f, 'F', false),
        Student(5, "Hoang Van E", 20, 7.8f, 'M', false),
        Student(6, "Nguyen Thi F", 23, 8.9f, 'F', true),
        Student(7, "Do Van G", 18, 6.7f, 'M', false),
        Student(8, "Pham Van H", 19, 9.2f, 'M', true),
        Student(9, "Le Thi I", 20, 6.9f, 'F', false),
        Student(10, "Vu Van J", 22, 8.0f, 'M', true),
        Student(11, "Bui Thi K", 18, 7.0f, 'F', false),
        Student(12, "Ngo Van L", 23, 9.5f, 'M', true),
        Student(13, "Pham Thi M", 21, 6.2f, 'F', false),
        Student(14, "Tran Van N", 19, 7.6f, 'M', false),
        Student(15, "Nguyen Thi O", 20, 8.3f, 'F', true),
        Student(16, "Dinh Van P", 17, 5.5f, 'M', false),
        Student(17, "Le Thi Q", 22, 9.8f, 'F', true),
        Student(18, "Bui Van R", 18, 6.0f, 'M', false),
        Student(19, "Vu Thi S", 21, 8.1f, 'F', true),
        Student(20, "Hoang Van T", 19, 7.2f, 'M', false),
        Student(21, "Pham Thi U", 20, 9.4f, 'F', true),
        Student(22, "Tran Van V", 22, 5.8f, 'M', false),
        Student(23, "Le Thi W", 17, 7.9f, 'F', false),
        Student(24, "Ngo Van X", 23, 8.6f, 'M', true),
        Student(25, "Nguyen Thi Y", 18, 6.3f, 'F', false),
        Student(26, "Do Van Z", 21, 9.1f, 'M', true),
        Student(27, "Bui Thi AA", 20, 7.4f, 'F', false),
        Student(28, "Pham Van BB", 19, 8.7f, 'M', true),
        Student(29, "Tran Thi CC", 22, 6.1f, 'F', false),
        Student(30, "Vu Van DD", 17, 7.5f, 'M', false),
        Student(31, "Le Thi EE", 18, 9.0f, 'F', true),
        Student(32, "Nguyen Van FF", 23, 6.8f, 'M', false),
        Student(33, "Pham Thi GG", 21, 7.3f, 'F', false),
        Student(34, "Hoang Van HH", 20, 8.5f, 'M', true),
        Student(35, "Bui Thi II", 19, 5.7f, 'F', false),
        Student(36, "Tran Van JJ", 22, 9.9f, 'M', true),
        Student(37, "Ngo Thi KK", 17, 6.4f, 'F', false),
        Student(38, "Vu Van LL", 18, 7.1f, 'M', false),
        Student(39, "Le Thi MM", 21, 8.2f, 'F', true),
        Student(40, "Nguyen Van NN", 19, 5.9f, 'M', false),
        Student(41, "Pham Thi OO", 20, 9.3f, 'F', true),
        Student(42, "Do Van PP", 22, 6.5f, 'M', false),
        Student(43, "Bui Thi QQ", 17, 7.7f, 'F', false),
        Student(44, "Tran Van RR", 23, 8.4f, 'M', true),
        Student(45, "Le Thi SS", 18, 5.6f, 'F', false),
        Student(46, "Nguyen Van TT", 21, 9.6f, 'M', true),
        Student(47, "Pham Thi UU", 20, 6.6f, 'F', false),
        Student(48, "Hoang Van VV", 19, 7.0f, 'M', false),
        Student(49, "Bui Thi WW", 22, 8.8f, 'F', true),
        Student(50, "Tran Van XX", 23, 5.4f, 'M', false)
    )

    //2
    /*
    val studentScholarship = listStudent.filter { it.gpa >= 8.0 }
    studentScholarship.forEach { it.displayInfo() }

     */

    //3
    /*
    listStudent.forEach { student: Student ->
        when {
            student.age < 18 -> println("ID: ${student.id}, Name: ${student.name}, Age: ${student.age} - Vi thanh nien")
            student.age >= 18 && student.age <= 22 -> println("ID: ${student.id}, Name: ${student.name}, Age: ${student.age} - Sinh vien")
            student.age > 22 -> println("ID: ${student.id}, Name: ${student.name}, Age: ${student.age} - Da tot nghiep hoac di lam")
            else -> println("Loi")
        }
    }

     */

    //4
    /*
    println("Trước khi nhập điểm!")
    listStudent.forEach {
        it.displayInfo()
    }

    println("Nhập điểm hợp lệ cho từng sinh viên")
    listStudent.forEach { student: Student ->
        var newGpa: Float
        do {
            println("Nhập điểm cho từng sinh viên")
            val input = readLine()
            newGpa = input?.toFloat()!!
            if(newGpa !in 0f..10f) {
                println("Lỗi, yêu cầu nhập lại")
            }
        } while (newGpa == null || newGpa !in 0f..10f )
        student.gpa = newGpa
    }

    println("Sau khi nhập điểm!")
    listStudent.forEach {
        it.displayInfo()
    }
     */

    //5
    /*
    val major = setOf("CNTT, KHMT, HTTT, ANM, TTNT")
    println(major)

    val studentToName = listStudent.map { it.id to it.name }.toMap()
    studentToName.forEach { (id, name) ->
        println("ID: $id - Name: $name")
    }

     */

    //7
    /*
    val newListStudent = mutableListOf<Student>()
    for(item in listStudent) {
        newListStudent.add(item)
    }

    var input: Int
    do {
        // Hiển thị menu cho người dùng
        println("Nhập lựa chọn của bạn:")
        println("1 -> Nhập sinh viên từ bàn phím")
        println("2 -> Sắp xếp sinh viên theo GPA")
        println("3 -> Số lượng sinh viên theo loại học lực")
        println("Nhấn phím khác để thoát")

        // Đọc giá trị từ bàn phím
        val userInput = readLine()
        input = userInput?.toIntOrNull() ?: -1 // nếu null thì giá trị input sẽ là -1

        // Xử lý từng trường hợp
        when (input) {
            1 -> {
                println("Nhập thông tin sinh viên mới:")
                var id : Int
                do {
                    print("ID: ")
                    id = readLine()?.toIntOrNull() ?: -1
                    if (id == -1 || newListStudent.any { it.id == id }) {
                        println("ID không hợp lệ hoặc đã tồn tại, vui lòng thử lại.")
                    } else {
                        break // Thoát vòng lặp nếu id hợp lệ
                    }
                } while (true)
                print("Tên: ")
                val name = readLine()?.toString()!!
                print("Tuổi: ")
                val age = readLine()?.toInt()!!
                print("GPA: ")
                val gpa = readLine()?.toFloat()!!
                print("Gender: ")
                val gender = readLine()!!.toCharArray()[0]
                print("Scholarship: ")
                val scholarship = readLine()?.toBoolean()!!

                if (newListStudent.none{it.id == id}  && age > 0) {
                    newListStudent.add(Student(id, name, age, gpa, gender, scholarship))
                    println("Thêm sinh viên thành công!")
                } else {
                    println("Dữ liệu nhập không hợp lệ hoặc ID đã tồn tại, vui lòng thử lại.")
                }
            }

                2 -> {
                println("Sắp xếp sinh viên theo GPA:")
                val sortedStudentGpa = newListStudent.sortedBy { it.gpa }
                    sortedStudentGpa.forEach { it.displayInfo() }
                }
            3 -> {
                println("Số lượng sinh viên theo loại học lực:")
                var kem = 0
                var yeu = 0
                var tb = 0
                var tbk = 0
                var kha = 0
                var gioi = 0
                var xuatsac = 0
                for (student in newListStudent) {
                    when {
                        student.gpa < 4 -> kem++
                        student.gpa >= 4 && student.gpa < 5 -> yeu++
                        student.gpa >= 5 && student.gpa < 6 -> tb++
                        student.gpa >= 6 && student.gpa < 7 -> tbk++
                        student.gpa >= 7 && student.gpa < 8 -> kha++
                        student.gpa >= 8 && student.gpa < 9 -> gioi++
                        student.gpa >= 9 -> xuatsac++
    package thuchanh

fun main() {



    val listStudent =  listOf(
        Student(1, "Nguyen Van A", 19, 8.5f, 'M', true),
        Student(2, "Tran Thi B", 22, 6.2f, 'F', false),
        Student(3, "Le Van C", 17, 9.0f, 'M', true),
        Student(4, "Pham Thi D", 21, 5.5f, 'F', false),
        Student(5, "Hoang Van E", 20, 7.8f, 'M', false),
        Student(6, "Nguyen Thi F", 23, 8.9f, 'F', true),
        Student(7, "Do Van G", 18, 6.7f, 'M', false),
        Student(8, "Pham Van H", 19, 9.2f, 'M', true),
        Student(9, "Le Thi I", 20, 6.9f, 'F', false),
        Student(10, "Vu Van J", 22, 8.0f, 'M', true),
        Student(11, "Bui Thi K", 18, 7.0f, 'F', false),
        Student(12, "Ngo Van L", 23, 9.5f, 'M', true),
        Student(13, "Pham Thi M", 21, 6.2f, 'F', false),
        Student(14, "Tran Van N", 19, 7.6f, 'M', false),
        Student(15, "Nguyen Thi O", 20, 8.3f, 'F', true),
        Student(16, "Dinh Van P", 17, 5.5f, 'M', false),
        Student(17, "Le Thi Q", 22, 9.8f, 'F', true),
        Student(18, "Bui Van R", 18, 6.0f, 'M', false),
        Student(19, "Vu Thi S", 21, 8.1f, 'F', true),
        Student(20, "Hoang Van T", 19, 7.2f, 'M', false),
        Student(21, "Pham Thi U", 20, 9.4f, 'F', true),
        Student(22, "Tran Van V", 22, 5.8f, 'M', false),
        Student(23, "Le Thi W", 17, 7.9f, 'F', false),
        Student(24, "Ngo Van X", 23, 8.6f, 'M', true),
        Student(25, "Nguyen Thi Y", 18, 6.3f, 'F', false),
        Student(26, "Do Van Z", 21, 9.1f, 'M', true),
        Student(27, "Bui Thi AA", 20, 7.4f, 'F', false),
        Student(28, "Pham Van BB", 19, 8.7f, 'M', true),
        Student(29, "Tran Thi CC", 22, 6.1f, 'F', false),
        Student(30, "Vu Van DD", 17, 7.5f, 'M', false),
        Student(31, "Le Thi EE", 18, 9.0f, 'F', true),
        Student(32, "Nguyen Van FF", 23, 6.8f, 'M', false),
        Student(33, "Pham Thi GG", 21, 7.3f, 'F', false),
        Student(34, "Hoang Van HH", 20, 8.5f, 'M', true),
        Student(35, "Bui Thi II", 19, 5.7f, 'F', false),
        Student(36, "Tran Van JJ", 22, 9.9f, 'M', true),
        Student(37, "Ngo Thi KK", 17, 6.4f, 'F', false),
        Student(38, "Vu Van LL", 18, 7.1f, 'M', false),
        Student(39, "Le Thi MM", 21, 8.2f, 'F', true),
        Student(40, "Nguyen Van NN", 19, 5.9f, 'M', false),
        Student(41, "Pham Thi OO", 20, 9.3f, 'F', true),
        Student(42, "Do Van PP", 22, 6.5f, 'M', false),
        Student(43, "Bui Thi QQ", 17, 7.7f, 'F', false),
        Student(44, "Tran Van RR", 23, 8.4f, 'M', true),
        Student(45, "Le Thi SS", 18, 5.6f, 'F', false),
        Student(46, "Nguyen Van TT", 21, 9.6f, 'M', true),
        Student(47, "Pham Thi UU", 20, 6.6f, 'F', false),
        Student(48, "Hoang Van VV", 19, 7.0f, 'M', false),
        Student(49, "Bui Thi WW", 22, 8.8f, 'F', true),
        Student(50, "Tran Van XX", 23, 5.4f, 'M', false)
    )

    //2
    /*
    val studentScholarship = listStudent.filter { it.gpa >= 8.0 }
    studentScholarship.forEach { it.displayInfo() }

     */

    //3
    /*
    listStudent.forEach { student: Student ->
        when {
            student.age < 18 -> println("ID: ${student.id}, Name: ${student.name}, Age: ${student.age} - Vi thanh nien")
            student.age >= 18 && student.age <= 22 -> println("ID: ${student.id}, Name: ${student.name}, Age: ${student.age} - Sinh vien")
            student.age > 22 -> println("ID: ${student.id}, Name: ${student.name}, Age: ${student.age} - Da tot nghiep hoac di lam")
            else -> println("Loi")
        }
    }

     */

    //4
    /*
    println("Trước khi nhập điểm!")
    listStudent.forEach {
        it.displayInfo()
    }

    println("Nhập điểm hợp lệ cho từng sinh viên")
    listStudent.forEach { student: Student ->
        var newGpa: Float
        do {
            println("Nhập điểm cho từng sinh viên")
            val input = readLine()
            newGpa = input?.toFloat()!!
            if(newGpa !in 0f..10f) {
                println("Lỗi, yêu cầu nhập lại")
            }
        } while (newGpa == null || newGpa !in 0f..10f )
        student.gpa = newGpa
    }

    println("Sau khi nhập điểm!")
    listStudent.forEach {
        it.displayInfo()
    }
     */

    //5
    /*
    val major = setOf("CNTT, KHMT, HTTT, ANM, TTNT")
    println(major)

    val studentToName = listStudent.map { it.id to it.name }.toMap()
    studentToName.forEach { (id, name) ->
        println("ID: $id - Name: $name")
    }

     */

    //7
    /*
    val newListStudent = mutableListOf<Student>()
    for(item in listStudent) {
        newListStudent.add(item)
    }

    var input: Int
    do {
        // Hiển thị menu cho người dùng
        println("Nhập lựa chọn của bạn:")
        println("1 -> Nhập sinh viên từ bàn phím")
        println("2 -> Sắp xếp sinh viên theo GPA")
        println("3 -> Số lượng sinh viên theo loại học lực")
        println("Nhấn phím khác để thoát")

        // Đọc giá trị từ bàn phím
        val userInput = readLine()
        input = userInput?.toIntOrNull() ?: -1 // nếu null thì giá trị input sẽ là -1

        // Xử lý từng trường hợp
        when (input) {
            1 -> {
                println("Nhập thông tin sinh viên mới:")
                var id : Int
                do {
                    print("ID: ")
                    id = readLine()?.toIntOrNull() ?: -1
                    if (id == -1 || newListStudent.any { it.id == id }) {
                        println("ID không hợp lệ hoặc đã tồn tại, vui lòng thử lại.")
                    } else {
                        break // Thoát vòng lặp nếu id hợp lệ
                    }
                } while (true)
                print("Tên: ")
                val name = readLine()?.toString()!!
                print("Tuổi: ")
                val age = readLine()?.toInt()!!
                print("GPA: ")
                val gpa = readLine()?.toFloat()!!
                print("Gender: ")
                val gender = readLine()!!.toCharArray()[0]
                print("Scholarship: ")
                val scholarship = readLine()?.toBoolean()!!

                if (newListStudent.none{it.id == id}  && age > 0) {
                    newListStudent.add(Student(id, name, age, gpa, gender, scholarship))
                    println("Thêm sinh viên thành công!")
                } else {
                    println("Dữ liệu nhập không hợp lệ hoặc ID đã tồn tại, vui lòng thử lại.")
                }
            }

                2 -> {
                println("Sắp xếp sinh viên theo GPA:")
                val sortedStudentGpa = newListStudent.sortedBy { it.gpa }
                    sortedStudentGpa.forEach { it.displayInfo() }
                }
            3 -> {
                println("Số lượng sinh viên theo loại học lực:")
                var kem = 0
                var yeu = 0
                var tb = 0
                var tbk = 0
                var kha = 0
                var gioi = 0
                var xuatsac = 0
                for (student in newListStudent) {
                    when {
                        student.gpa < 4 -> kem++
                        student.gpa >= 4 && student.gpa < 5 -> yeu++
                        student.gpa >= 5 && student.gpa < 6 -> tb++
                        student.gpa >= 6 && student.gpa < 7 -> tbk++
                        student.gpa >= 7 && student.gpa < 8 -> kha++
                        student.gpa >= 8 && student.gpa < 9 -> gioi++
                        student.gpa >= 9 -> xuatsac++
                    }
                }
                println("Kém: $kem, Yếu: $yeu, Trung bình: $tb, Trung bình khá: $tbk, Khá: $kha, Giỏi: $gioi, Xuất sắc: $xuatsac")

            }
            else -> {
                println("Thoát chương trình")
            }
        }
    } while (input in 1..3)

    //newListStudent.forEach { it.displayInfo() }

     */


}                }
                }
                println("Kém: $kem, Yếu: $yeu, Trung bình: $tb, Trung bình khá: $tbk, Khá: $kha, Giỏi: $gioi, Xuất sắc: $xuatsac")

            }
            else -> {
                println("Thoát chương trình")
            }
        }
    } while (input in 1..3)

    //newListStudent.forEach { it.displayInfo() }

     */


}