
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import simple_deps.*

class CoursesTests
{
    val registerToCourses = registerToCourseCurried( InMemoryAuthenticationService(), InMemoryCourseService())

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
