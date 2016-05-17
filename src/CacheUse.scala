import org.joda.time.DateTime

println("")
println("*************************")
println("Cache usage sample")
println("*************************")
println("")
val sparkHome = sys.env("SPARK_HOME")
val path = sparkHome + "/CHANGES.txt"
val textFile = sc.textFile(path)

println("")
println("WordCount with no sorting")
println("=========================")
println("")
val wordCounts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey((a, b) => a + b)
wordCounts.take(3)

println("")
println("cache enable for wordCounts")
println("===========================")
println("scala> wordCounts.cache")
println("")
wordCounts.cache

println("")
println("filter and sort #1")
println("==================")
println("")
new DateTime()
wordCounts.filter(_._1.matches("[a-zA-Z0-9]+")).sortBy(_._2,false).take(10)
// res1: Array[(String, Int)] = Array((in,1766), (to,1417), (for,1298), (the,777), (and,663), (Add,631), (of,630), (Fix,547), (Xin,491), (Reynold,490))
new DateTime()


println("")
println("filter and sort #2")
println("==================")
println("")
new DateTime()
wordCounts.filter(_._1.matches("[a-zA-Z0-9]+")).sortBy(_._2,false).take(10)
// res1: Array[(String, Int)] = Array((in,1766), (to,1417), (for,1298), (the,777), (and,663), (Add,631), (of,630), (Fix,547), (Xin,491), (Reynold,490))
new DateTime()
