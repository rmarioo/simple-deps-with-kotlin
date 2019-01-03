package simple_deps

interface CourseService {
    fun applyToCourse(user: User, course: Course): Registration
}