package simple_deps

import arrow.core.Option

interface AuthenticationService {
    fun authorize(person: Person): Option<User>
}