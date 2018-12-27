package reader.api

import reader.model.Course
import reader.model.User
import reader.port.CourseService

interface CourseApi {

    val courseService: CourseService

    fun User.registerToCourse(course: Course) =
            courseService.applyToCourse(this, course)
}