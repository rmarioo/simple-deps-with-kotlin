package reader

import arrow.core.Option
import arrow.core.getOrElse


fun registerToCourseCurried(authService: AuthenticationService, courseService: CourseService): (String, Course) -> String =

    fun (userName: String,course: Course) =

                       findUser(userName, authService)
                .map { registerUserToCourse(it, course, courseService) }
                .map { createRegistrationReceipt(it) }
          .getOrElse { createFailureReceipt(userName) }

private fun findUser(userName: String, authService: AuthenticationService): Option<User> =
        authService.authorize(userName)

private fun registerUserToCourse(user: User, course: Course, courseService: CourseService): Registration =
        courseService.applyToCourse(user, course)

private fun createRegistrationReceipt(registration: Registration) =
     "successful registration for ${registration.user.name} to course ${registration.course.name}"

private fun createFailureReceipt(userName: String) =
     "user $userName is not authorized"

