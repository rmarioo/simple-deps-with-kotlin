package reader

import arrow.core.Option

interface AuthenticationService {
    fun authorize(userName: String): Option<User>
}