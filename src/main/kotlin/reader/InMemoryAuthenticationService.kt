package reader

import arrow.core.Option

class InMemoryAuthenticationService: AuthenticationService {
    override fun authorize(userName: String): Option<User> =
         if (userName.startsWith("M")) Option.just(User(userName)) else Option.empty()
}