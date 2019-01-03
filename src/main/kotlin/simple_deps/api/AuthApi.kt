package simple_deps.api

import arrow.core.Option
import simple_deps.model.Person
import simple_deps.model.User
import simple_deps.port.AuthenticationService

interface AuthApi
{
   val authenticationService: AuthenticationService

   fun Person.authorize(): Option<User> = authenticationService.authorize(this)
}