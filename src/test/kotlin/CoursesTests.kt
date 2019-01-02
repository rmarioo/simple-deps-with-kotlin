
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import reader.api.ComposedApi
import reader.model.Course
import reader.model.Person
import reader.port.AuthenticationService
import reader.port.CourseService
import reader.port.InMemoryAuthenticationService
import reader.port.InMemoryCourseService
import reader.registerToCourseCurried

class CoursesTests
{
    val mainApi = object: ComposedApi
    {
        override val authenticationService: AuthenticationService = InMemoryAuthenticationService()
        override val courseService: CourseService = InMemoryCourseService()
    }

    val registerToCourses = registerToCourseCurried(mainApi)

    @Test
    fun `user with name starting for m is authorized`() {

        val receipt = registerToCourses(Person("Marco"), Course("History"))

        assertThat(receipt,`is`("successful registration for Marco to course History"))
    }

    @Test
    fun `user with name not starting for m is not authorized`() {

        val receipt = registerToCourses(Person("Luigi"), Course("History"))

        assertThat(receipt,`is`("user Luigi is not authorized"))
    }
}
