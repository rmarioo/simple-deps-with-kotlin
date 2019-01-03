package simple_deps.port

import simple_deps.model.Course
import simple_deps.model.Registration
import simple_deps.model.User

class InMemoryCourseService: CourseService {
    override fun applyToCourse(user: User, course: Course) = Registration(user, course)
}