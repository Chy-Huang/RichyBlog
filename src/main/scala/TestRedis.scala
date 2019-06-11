import java.time.Duration
import io.lettuce.core.RedisURI

object RedisUtils {
  val ip = "127.0.0.1"
  val ports = Array(7000,7001,7002,7003,7004,7005)
  def getRedisConnect: StatefulRedisClusterConnection[String, String] ={
    val uris: immutable.Seq[RedisURI] = ports.map(port => {
      RedisURI.builder().withHost(ip).withPort(port).build()
    }).toList
    import scala.collection.JavaConverters._
    val redusClusterClient = RedisClusterClient.create(uris.asJava)
    val topologRefreshOptions =
      ClusterTopologRefreshOptions.builder.enablePeriodicRefresh(Duration.ofMinutes(10).enableAllAdaptiveRefreshTriggers.build)

    redisClusterClient.setOptions(ClusterClientOptions.builder.autoReconnect(true).pingBeforeActivateConnection(true).topologyRefreshOptions(topologRefreshOptions).build)
    redisClusterClient.connect()
  }
}
