package reader

import arrow.core.Option
import arrow.core.getOrElse


fun registerToCourseCurried(authService: AuthenticationService, courseService: CourseService): (Person, Course) -> String =

    fun (person: Person,course: Course) =

                       authorize(person, authService)
                .map { registerToCourse(it, course, courseService) }
                .map { createRegistrationReceipt(it) }
          .getOrElse { createFailureReceipt(person) }

private fun authorize(person: Person, authService: AuthenticationService): Option<User> =
        authService.authorize(person)

private fun registerToCourse(user: User, course: Course, courseService: CourseService): Registration =
        courseService.applyToCourse(user, course)

private fun createRegistrationReceipt(registration: Registration) =
     "successful registration for ${registration.user.name} to course ${registration.course.name}"

private fun createFailureReceipt(person: Person) =
     "user ${person.name} is not authorized"

