package simple_deps

import arrow.core.getOrElse
import simple_deps.api.ComposedApi
import simple_deps.model.Course
import simple_deps.model.Person
import simple_deps.model.Registration


fun registerToCourseCurried(api: ComposedApi): (Person, Course) -> String =

    fun (person: Person, course: Course) =
                       api.authorizeAndRegisterToCourse(person, course)
                .map { createRegistrationReceipt(it) }
          .getOrElse { createFailureReceipt(person) }


private fun createRegistrationReceipt(registration: Registration) =
     "successful registration for ${registration.user.name} to course ${registration.course.name}"

private fun createFailureReceipt(person: Person) =
     "user ${person.name} is not authorized"

