
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import simple_deps.api.ComposedApi
import simple_deps.model.Course
import simple_deps.model.Person
import simple_deps.port.AuthenticationService
import simple_deps.port.CourseService
import simple_deps.port.InMemoryAuthenticationService
import simple_deps.port.InMemoryCourseService
import simple_deps.registerToCourseCurried

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
