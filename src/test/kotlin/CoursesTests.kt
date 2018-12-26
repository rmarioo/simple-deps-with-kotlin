
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import reader.AuthService
import reader.Course
import reader.CourseService
import reader.registerToCourseCurried

class CoursesTests
{
    val registerToCourses = registerToCourseCurried( AuthService(), CourseService())

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
