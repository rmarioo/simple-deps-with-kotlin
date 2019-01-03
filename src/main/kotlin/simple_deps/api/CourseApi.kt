package simple_deps.api

import simple_deps.model.Course
import simple_deps.model.User
import simple_deps.port.CourseService

interface CourseApi {

    val courseService: CourseService

    fun User.registerToCourse(course: Course) =
            courseService.applyToCourse(this, course)
}