package reader.api

import reader.model.Course
import reader.port.CourseService
import reader.model.User

interface CourseApi {

    val courseService: CourseService

    fun User.applyToCourse(course: Course) =
            courseService.applyToCourse(this, course)
}