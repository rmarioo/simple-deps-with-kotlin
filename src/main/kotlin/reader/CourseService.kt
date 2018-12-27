package reader

interface CourseService {
    fun applyToCourse(user: User, course: Course): Registration
}