
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import reader.Course
import reader.InMemoryAuthenticationService
import reader.InMemoryCourseService
import reader.registerToCourseCurried

class CoursesTests
{
    val registerToCourses = registerToCourseCurried( InMemoryAuthenticationService(), InMemoryCourseService())

    @Test
    fun `user with name starting for m is authorized`() {

        val receipt = registerToCourses("Marco", Course("History"))

        assertThat(receipt,`is`("successful registration for Marco to course History"))
    }

    @Test
    fun `user with name not starting for m is not authorized`() {

        val receipt = registerToCourses("Luigi", Course("History"))

        assertThat(receipt,`is`("user Luigi is not authorized"))
    }
}
