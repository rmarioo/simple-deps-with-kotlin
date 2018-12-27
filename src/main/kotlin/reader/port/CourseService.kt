package reader.port

import reader.model.Course
import reader.model.Registration
import reader.model.User

interface CourseService {
    fun applyToCourse(user: User, course: Course): Registration
}