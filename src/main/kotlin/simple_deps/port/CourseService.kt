package simple_deps.port

import simple_deps.model.Course
import simple_deps.model.Registration
import simple_deps.model.User

interface CourseService {
    fun applyToCourse(user: User, course: Course): Registration
}