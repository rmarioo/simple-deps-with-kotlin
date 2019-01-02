package reader

import arrow.core.getOrElse
import reader.api.ComposedApi
import reader.model.Course
import reader.model.Person
import reader.model.Registration


fun registerToCourseCurried(api: ComposedApi): (Person, Course) -> String =

    fun (person: Person, course: Course) =
                       api.authorizeAndRegisterToCourse(person, course)
                .map { createRegistrationReceipt(it) }
          .getOrElse { createFailureReceipt(person) }


private fun createRegistrationReceipt(registration: Registration) =
     "successful registration for ${registration.user.name} to course ${registration.course.name}"

private fun createFailureReceipt(person: Person) =
     "user ${person.name} is not authorized"

