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
println("WordCount with sorting")
println("=========================")
println("")
wordCounts.sortBy(_._2,false).take(10)
// res0: Array[(String, Int)] = Array(("",61509), (Commit:,6830), (-0700,3672), (-0800,2162), (in,1766), (to,1417), (for,1298), ([SQL],1277), (the,777), (and,663))



println("")
println("WordCount with filtering")
println("=========================")
println("")
wordCounts.filter(_._1.matches("[a-zA-Z0-9]+")).sortBy(_._2,false).take(10)
// res1: Array[(String, Int)] = Array((in,1766), (to,1417), (for,1298), (the,777), (and,663), (Add,631), (of,630), (Fix,547), (Xin,491), (Reynold,490))


