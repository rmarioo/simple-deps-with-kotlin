package reader

import arrow.core.Option
import arrow.core.Option.Companion.empty
import arrow.core.Option.Companion.just
import arrow.core.getOrElse


fun registerToCourseCurried( authService: AuthService, courseService: CourseService) =

    fun (userName: String,course: Course) =

                       findUser(userName, authService)
                .map { registerUserToCourse(it, course, courseService) }
                .map { createAuthorizedReceipt(it) }
          .getOrElse { createNotAuthorizedReceipt(userName) }

private fun findUser(userName: String, authService: AuthService): Option<User> =
        authService.authorize(userName)

private fun registerUserToCourse(user: User, course: Course, courseService: CourseService): Registration =
        courseService.applyToCourse(user, course)

private fun createAuthorizedReceipt(registration: Registration) =
     "successful registration for ${registration.user.name} to course ${registration.course.name}"

private fun createNotAuthorizedReceipt(userName: String) =
     "user $userName is not authorized"

class AuthService {
    fun authorize(userName: String): Option<User> =
         if (userName.startsWith("M")) just(User(userName)) else empty()

}

class CourseService {
    fun applyToCourse(user: User, course: Course) = Registration(user, course)
}

data class User(val name: String)

data class Course(val name: String)

data class Registration(val user: User,val course: Course)
