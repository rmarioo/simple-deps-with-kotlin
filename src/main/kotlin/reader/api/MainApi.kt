package reader.api

import arrow.core.Option
import reader.model.Course
import reader.model.Person
import reader.model.Registration

interface MainApi: AuthApi, CourseApi {

    fun Person.applyTo(course: Course): Option<Registration> =
            authorize().map { user -> user.applyToCourse(course) }

    fun registerToCourse(person: Person, course: Course) = person.applyTo(course)

}