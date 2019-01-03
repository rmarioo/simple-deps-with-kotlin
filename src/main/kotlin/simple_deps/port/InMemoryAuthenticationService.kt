package simple_deps.port

import arrow.core.Option
import simple_deps.model.Person
import simple_deps.model.User

class InMemoryAuthenticationService: AuthenticationService {
    override fun authorize(person: Person): Option<User> =
            if (person.name.startsWith("M")) Option.just(User(person.name)) else Option.empty()
}
