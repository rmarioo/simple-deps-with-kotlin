package reader.port

import arrow.core.Option
import reader.model.Person
import reader.model.User

class InMemoryAuthenticationService: AuthenticationService {
    override fun authorize(person: Person): Option<User> =
            if (person.name.startsWith("M")) Option.just(User(person.name)) else Option.empty()
}
