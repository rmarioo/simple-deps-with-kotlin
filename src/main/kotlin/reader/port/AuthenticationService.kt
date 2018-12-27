package reader.port

import arrow.core.Option
import reader.model.Person
import reader.model.User

interface AuthenticationService {
    fun authorize(person: Person): Option<User>
}