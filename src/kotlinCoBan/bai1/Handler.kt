package com.example.interneco.task1

import com.example.interneco.task1.StudentData.listStudent


object Handler {
    fun addStudent() {
        println("Nhập thông tin sinh viên mới:")
        var id : Int
        do {
            print("ID: ")
            id = readlnOrNull()?.toIntOrNull() ?: -1
            if (id == -1 || listStudent.any { it.id == id }) {
                println("ID không hợp lệ hoặc đã tồn tại, vui lòng thử lại.")
            } else {
                break // Thoát vòng lặp nếu id hợp lệ
            }
        } while (true)
        print("Tên: ")
        val name = readlnOrNull()
        print("Tuổi: ")
        val age = readlnOrNull()?.toInt()!!
        print("GPA: ")
        val gpa = readlnOrNull()?.toFloat()!!
        print("Gender: ")
        val gender = readlnOrNull()!!.toCharArray()[0]
        val scholarship = gpa >= 8.0

        if (listStudent.none{it.id == id}  && age > 0) {
            name?.let { Student(id, it, age, gpa, gender, scholarship) }?.let { listStudent.add(it) }
            println("Thêm sinh viên thành công!")
        } else {
            println("Dữ liệu nhập không hợp lệ hoặc ID đã tồn tại, vui lòng thử lại.")
        }
    }

    fun arrangeStudent() {
        println("Sắp xếp sinh viên theo GPA:")
        val sortedStudentGpa = listStudent.sortedBy { it.gpa }
        sortedStudentGpa.forEach { println(it.displayInfo()) }
    }

    fun studentClassification() {
        println("Số lượng sinh viên theo loại học lực:")
        var kem = 0
        var yeu = 0
        var tb = 0
        var tbk = 0
        var kha = 0
        var gioi = 0
        var xuatsac = 0
        for (student in listStudent) {
            when {
                student.gpa!! < 4 -> kem++
                student.gpa!! < 5 -> yeu++
                student.gpa!! < 6 -> tb++
                student.gpa!! < 7 -> tbk++
                student.gpa!! < 8 -> kha++
                student.gpa!! < 9 -> gioi++
                else -> xuatsac++
            }
        }
        println("Kém: $kem, Yếu: $yeu, Trung bình: $tb, Trung bình khá: $tbk, Khá: $kha, Giỏi: $gioi, Xuất sắc: $xuatsac")
    }
    fun displayStudentList() {
        for (item in listStudent) {
            println(item.displayInfo())
        }
    }
    fun displayGpaMoreThan8() {
        val studentScholarship = listStudent.filter { it.gpa!! >= 8.0 }
        studentScholarship.forEach { println(it.displayInfo()) }
    }

    fun displayAgeClassification() {
        listStudent.forEach { student: Student ->
            when {
                student.age < 18 -> println("ID: ${student.id}, Name: ${student.name}, Age: ${student.age} - Vị thành niên")
                student.age <= 22 -> println("ID: ${student.id}, Name: ${student.name}, Age: ${student.age} - Sinh viên")
                else -> println("ID: ${student.id}, Name: ${student.name}, Age: ${student.age} - Đã tốt nghiệp hoặc đi làm")
            }
        }
    }

    fun enterNewGpaForStudent() {
        println("Nhập điểm hợp lệ cho từng sinh viên")
        listStudent.forEach { student: Student ->
            var newGpa: Float
            do {
                println("Nhập điểm cho từng sinh viên")
                val input = readlnOrNull()
                newGpa = input?.toFloat()!!
                if(newGpa !in 0f..10f) {
                    println("Lỗi, yêu cầu nhập lại")
                }
            } while (newGpa !in 0f..10f)
            student.gpa = newGpa
        }
    }

    fun sumOfGpa(){
        val sumGpa = listStudent.sumOf { it.gpa!!.toDouble() }
        println("Tổng điểm GPA của tất cả sinh viên là: $sumGpa")
    }

    fun displayIdAndName() {
        for (item in listStudent) {
            println("ID: ${item.id} - Name: ${item.name}")
        }

        // or
        /*
        val studentToName = listStudent.associate { it.id to it.name } // return a map
        studentToName.forEach { (id, name) ->
            println("ID: $id - Name: $name")
        }

         */
    }

    fun displayFirstAndLast() {
        val firstStudent = listStudent.first()
        val lastStudent = listStudent.last()
        println("First Student: ${firstStudent.displayInfo()}")
        println("Last Student: ${lastStudent.displayInfo()}")
    }

    fun displayListWithTake() {
        // lấy n phần tử đầu
        listStudent.take(10).forEach { println(it.displayInfo()) }
        println("==========================================================================")

        // lấy n phần tử cuối
        listStudent.takeLast(10).forEach { println(it.displayInfo()) }
        println("==========================================================================")

        // lấy các phần tử từ đầu danh sách thỏa mãn cho đến khi gặp phần tử sai thì dừng
        listStudent.takeWhile { it.gpa!! >= 6.0 }.forEach { println(it.displayInfo()) }
        println("==========================================================================")

        listStudent.takeLastWhile { it.age > 20 }.forEach { println(it.displayInfo()) }

    }

    fun displayListWithDrop() {
        listStudent.drop(10).forEach { println(it.displayInfo()) }
        println("==========================================================================")
        listStudent.dropLast(10).forEach { println(it.displayInfo()) }
        println("==========================================================================")

        // loại bỏ các phần tử từ đầu danh sách miễn là điều kiện được thỏa mãn
        // khi gặp phần tử không thỏa mãn điều kiện, nó sẽ dừng việc loại bỏ và giữ lại tất cả các phần tử từ đó trở đi
        listStudent.dropWhile { it.gpa!! > 8.0}.forEach { println(it.displayInfo()) }
        println("==========================================================================")
        listStudent.dropLastWhile { it.age < 22 }.forEach { println(it.displayInfo()) }
    }

    fun displayListWithChunked() {
        // chia thành nhóm và xử lý dữ liệu theo từng nhóm
        val result = listStudent.chunked(10) {chunk -> chunk.sumOf { it.gpa!!.toDouble() }}
        println("Result :$result")
    }

    fun displayListWithDistinct() {
        listStudent.distinct().forEach { println(it.displayInfo()) }
        println("==========================================================================")
        // loại bỏ phần tử trùng lặp, giữ lại 1 kết quả đại diện cho mỗi giá trị của khóa (điều kiện bên trong lambda).
        listStudent.distinctBy { it.gender == 'M'}.forEach { println(it.displayInfo()) }
    }

    fun displayWithFlatMap() {
        // flatMap: Áp dụng biến đổi và làm phẳng dữ liệu
        // -> Trả về một danh sách mới
        val doubleGpaList = listStudent.flatMap { listOf(it.gpa?.times(2) ?: 0) }
        println(doubleGpaList)

        // flatMapTo: Áp dụng biến đổi và làm phẳng dữ liệu
        // -> Thêm trực tiếp kết quả vào danh sách đích
        val doubleListGPA = mutableListOf<Double>()
        listStudent.flatMapTo(doubleListGPA) { listOf<Double>(it.gpa!! * 2.0) }
        println(doubleListGPA)

    }
    fun displayWithFlatten() {
        // Tạo danh sách lồng nhau từ listStudent
        val nestedGpaList = listStudent.map { listOf(it.gpa) }

        // Làm phẳng danh sách lồng nhau
        val flatGpaList = nestedGpaList.flatten()
        println("Danh sách GPA làm phẳng: $flatGpaList")
    }

    fun displayWithMapIndexed() {
        // First mapIndexed: Prints index and student name
        listStudent.mapIndexed { index, student ->
            println("$index: ${student.name}")
        }

        // Second mapNotNull and mapIndexed: Prints index and gpa * 2
        listStudent.mapNotNull {it.gpa }
            .mapIndexed { index, value ->
                println("$index: $value")
            }
    }

    fun displayWithAssociate() {
        // tạo map từ collection
        listStudent.associate { it.id to it.name }.forEach { (id, name) -> println("ID: $id - Name: $name") }

        // associateWith mỗi phần tử trong danh sách ban đầu sẽ trở thành một key trong Map , và kết quả tính toán từ lambda sẽ là value.
        listStudent.associateWith { it.gpa?.times(2) ?: 0 }.forEach { println(it) }

        // sử dụng associateBy với một lambda, nó sẽ tạo Map và sử dụng kết quả của lambda làm key, còn value sẽ là đối tượng ban đầu.
        listStudent.associateBy { it.gpa?.times(-1) ?: 0 }.forEach { println(it) }
    }

    fun resultAgeWithSum() {
        val result = listStudent.sumOf { it.age}
        println("Sum of age: $result")

        // Tìm giá trị lớn nhất và index của nó
        val maxOfAge = listStudent.maxByOrNull { it.age }
        val indexOfMaxAge = listStudent.indexOf(maxOfAge)
        println("Max Age: ${maxOfAge?.age}, Index: $indexOfMaxAge")

        // Tìm giá trị nhỏ nhất và index của nó
        val minOfAge = listStudent.minByOrNull { it.age }
        val indexOfMinAge = listStudent.indexOf(minOfAge)
        println("Min Age: ${minOfAge?.age}, Index: $indexOfMinAge")


        val result1 = listStudent.sumBy { if(it.age > 20) it.age else 0 }
        println("Sum of age more than 20: $result1")
    }

    fun resultWithCount() {
        val result2 = listStudent.count()
        println("Number of student: $result2")

        listStudent.let {
            val result = listStudent.count {
                it.age == 22
            }
            println("Number of age equal to 22: $result")
        }
    }

    fun resultWithAverage() {
        listStudent.run {
            mapNotNull { it.gpa }.let { gpaList ->
                if (gpaList.isNotEmpty()) {
                    val averageGpa = gpaList.average()
                    println("Average GPA: $averageGpa")
                } else {
                    println("No valid GPA found.")
                }
            }
        }
        listStudent.filter { it.gpa!! > 7.0 }.let { filteredStudents  ->
            if(filteredStudents .isNotEmpty()) {
                val averageGpa = filteredStudents.map { it.gpa!! }.average()
                println("Average GPA more than 7.0: $averageGpa")
            }
            else {
                println("No valid GPA found.")
            }
        }
    }

    fun resultWithReduce() {
        val result1 = listStudent.mapNotNull { it.gpa }
            .reduce { acc, gpa -> acc+gpa }
        println("Reduce of GPA: $result1")

        val result2 = listStudent.mapNotNull { it.gpa }
            .runningReduce { acc, gpa -> acc+gpa }
        println("Running Reduce of GPA: $result2")

        val result3 = listStudent.mapNotNull { it.gpa }
            .fold(0.0) { acc, gpa -> acc + gpa }
        println("Fold of GPA: $result3")

        val result4 = listStudent.mapNotNull { it.gpa }
            .runningFold(0.0) { acc, gpa -> acc + gpa }
            .map { String.format("%.2f", it) }
        println("Running Fold of GPA: $result4")
    }

}