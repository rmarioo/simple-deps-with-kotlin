package simple_deps.port

import arrow.core.Option
import simple_deps.model.Person
import simple_deps.model.User

interface AuthenticationService {
    fun authorize(person: Person): Option<User>
}