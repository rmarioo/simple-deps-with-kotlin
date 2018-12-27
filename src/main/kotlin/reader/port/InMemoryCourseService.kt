package reader.port

import reader.model.Course
import reader.model.Registration
import reader.model.User

class InMemoryCourseService: CourseService {
    override fun applyToCourse(user: User, course: Course) = Registration(user, course)
}