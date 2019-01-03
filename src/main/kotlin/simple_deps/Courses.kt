package simple_deps

import arrow.core.Option
import arrow.core.getOrElse
import simple_deps.api.AuthApi
import simple_deps.api.CourseApi
import simple_deps.model.Course
import simple_deps.model.Person
import simple_deps.model.Registration


fun registerToCourseCurried(api: ComposedApi): (Person, Course) -> String =

    fun (person: Person, course: Course) =
                       api.authorizeAndRegisterToCourse(person, course)
                .map { createRegistrationReceipt(it) }
          .getOrElse { createFailureReceipt(person) }


interface ComposedApi : AuthApi, CourseApi {

    fun authorizeAndRegisterToCourse(person: Person, course: Course) = person.applyTo(course)

    private fun Person.applyTo(course: Course): Option<Registration> =
            authorize()
                    .map { user -> user.registerToCourse(course) }

}


private fun createRegistrationReceipt(registration: Registration) =
     "successful registration for ${registration.user.name} to course ${registration.course.name}"

private fun createFailureReceipt(person: Person) =
     "user ${person.name} is not authorized"

