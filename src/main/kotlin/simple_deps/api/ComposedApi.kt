package simple_deps.api

import arrow.core.Option
import simple_deps.model.Course
import simple_deps.model.Person
import simple_deps.model.Registration

interface ComposedApi : AuthApi, CourseApi {

    fun authorizeAndRegisterToCourse(person: Person, course: Course) = person.applyTo(course)

    private fun Person.applyTo(course: Course): Option<Registration> =
            authorize()
                    .map { user -> user.registerToCourse(course) }


}