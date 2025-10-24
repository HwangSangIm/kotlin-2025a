package com.appweek06

import android.graphics.Color
import java.util.*

data class Student(
    val name: String,
    val id: String = UUID.randomUUID().toString(),
    val addedDate: Date = Date()
)

data class CartItem(
    val name: String,
    var quantity: Int = 1,
    val price: Double,
    val id: String = UUID.randomUUID().toString(),
    val addedDate: Date = Date()
) {
    fun getTotalPrice(): Double = quantity * price

    override fun toString(): String {
        return "$name (x$quantity) - $%.2f".format(getTotalPrice())
    }
}

data class Task( // 이 과정이 생성자
    val title: String, // 작업명
    val description: String = "", // 설명
    var isCompleted: Boolean = false , // 작업했는지 안했는지
    val priority:TaskPriority, // 우선 순위
    val dueDate: Date? = null, // 끝내야하는 날짜 ?를 사용해서 null값 넣기
    val id: String = UUID.randomUUID().toString(), // id 랜덤하게 선언
    val createdDate: Date = Date() // 시작하는 날짜
) {

    override fun toString(): String { // 출력
        val status = if(isCompleted)"V" else "O"
        val priorityIcon = when (priority){ // switch case문
            TaskPriority.HIGH -> "!!!"
            TaskPriority.MEDIUM -> "!!"
            TaskPriority.LOW -> "!"
        }
        return "$status $priorityIcon $title" // String 타입으로 return
    }
}

// 우선순위
enum class TaskPriority(val displayName: String, val color: Int){
    HIGH("High", Color.RED),        // 상
    MEDIUM("Medium", Color.BLUE),   // 중
    LOW("Low", Color.GREEN)         // 하
}

enum class AppMode(val displayName: String) {
    STUDENT_LIST("Student List"),
    SHOPPING_CART("Shopping Cart"),
    TASK_MANAGER("Task Manager")
}