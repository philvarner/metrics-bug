package foo

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import fr.davit.akka.http.metrics.core.scaladsl.server.HttpMetricsRoute._
import fr.davit.akka.http.metrics.core.scaladsl.server.HttpMetricsSettings
import fr.davit.akka.http.metrics.prometheus.PrometheusRegistry

object StandardHttpService {

  val metricsSettings: HttpMetricsSettings = HttpMetricsSettings.default
  val metricsRegistry: PrometheusRegistry = PrometheusRegistry(metricsSettings)

  implicit val system: ActorSystem = ActorSystem("service-system")
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  def f1(route: Route): Unit = {
    route.recordMetrics(metricsRegistry, metricsSettings)
  }

}
