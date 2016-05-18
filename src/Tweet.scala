println("")
println("*************************")
println("Tweet sample")
println("*************************")
println("")
import org.apache.spark.streaming.twitter.TwitterUtils
import org.apache.spark.streaming.{Durations, StreamingContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.log4j.{Level, Logger}

Logger.getRootLogger.setLevel(Level.ERROR)

val config = new java.util.Properties
config.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"))
System.setProperty("twitter4j.oauth.consumerKey", config.get("twitter_consumerKey").toString)
System.setProperty("twitter4j.oauth.consumerSecret", config.get("twitter_consumerSecret").toString)
System.setProperty("twitter4j.oauth.accessToken", config.get("twitter_accessToken").toString)
System.setProperty("twitter4j.oauth.accessTokenSecret", config.get("twitter_accessTokenSecret").toString)


println("")
println("Create stream")
println("=============")
println("")
val filters = Array("#spark")
val ssc = new StreamingContext(sc, Seconds(3))
val stream = TwitterUtils.createStream(ssc, None, filters)

println("")
println("Extract texts and print")
println("=======================")
println("")
stream.map(status => status.getText()).print

println("")
println("Start")
println("=====")
println("")
ssc.start()
ssc.awaitTermination()

