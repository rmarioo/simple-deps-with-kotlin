package reader.api

import arrow.core.Option
import reader.model.Person
import reader.model.User
import reader.port.AuthenticationService

interface AuthApi
{
   val authenticationService: AuthenticationService

   fun Person.authorize(): Option<User> = authenticationService.authorize(this)
}