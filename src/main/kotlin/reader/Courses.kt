package reader

import arrow.core.Option
import arrow.core.Option.Companion.empty
import arrow.core.Option.Companion.just
import arrow.core.getOrElse


fun registerToCourseCurried( authService: AuthService, courseService: CourseService) =

    fun (userName: String,course: Course) =
                       authorize(authService, userName)
                .map { applyToCourse(courseService, it, course) }
                .map { authorizedReceipt(it) }
          .getOrElse { notAuthorizedReceipt(userName) }


fun authorizedReceipt(registration: Registration): String {
    return "successful registration for ${registration.user.name} to course ${registration.course.name}"
}

private fun notAuthorizedReceipt(userName: String) = "user $userName is not authorized"

private fun applyToCourse(courseService: CourseService, user: User, course: Course) =
        courseService.applyToCourse(user, course)

private fun authorize(authService: AuthService, userName: String) =
        authService.authorize(userName)

class AuthService {
    fun authorize(userName: String): Option<User> {
        return if (userName.startsWith("M")) just(User(userName))
        else empty()
    }
}

class CourseService {
    fun applyToCourse(user: User, course: Course): Registration {
          return Registration(user, course)
    }
}

data class User(val name: String)

data class Course(val name: String)

data class Registration(val user: User,val course: Course)
