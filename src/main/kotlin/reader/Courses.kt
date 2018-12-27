package reader

import arrow.core.getOrElse
import reader.api.MainApi
import reader.model.Course
import reader.model.Person
import reader.model.Registration


fun registerToCourseCurried(mainApi: MainApi): (Person, Course) -> String =

    fun (person: Person, course: Course) =
                       mainApi.applyToCourse(person, course)
                .map { createRegistrationReceipt(it) }
          .getOrElse { createFailureReceipt(person) }


private fun createRegistrationReceipt(registration: Registration) =
     "successful registration for ${registration.user.name} to course ${registration.course.name}"

private fun createFailureReceipt(person: Person) =
     "user ${person.name} is not authorized"

