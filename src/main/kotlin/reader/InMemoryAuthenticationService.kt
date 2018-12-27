package reader

import arrow.core.Option

class InMemoryAuthenticationService: AuthenticationService {
    override fun authorize(person: Person): Option<User> =
            if (person.name.startsWith("M")) Option.just(User(person.name)) else Option.empty()
}
