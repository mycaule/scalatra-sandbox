import com.sandbox._
import org.scalatra.LifeCycle
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {

  implicit val swagger = new FootballSwagger

  override def init(context: ServletContext): Unit = {
    context.setInitParameter("org.scalatra.cors.allowedOrigins", "http://petstore.swagger.io")
    context.mount(new teams.TeamsController, "/teams", "teams")
    context.mount(new status.StatusController, "/status", "status")
    context.mount(new ResourcesApp, "/api-docs")
  }
}
