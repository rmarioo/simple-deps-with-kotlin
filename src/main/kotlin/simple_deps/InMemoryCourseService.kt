package simple_deps

class InMemoryCourseService: CourseService {
    override fun applyToCourse(user: User, course: Course) = Registration(user, course)
}