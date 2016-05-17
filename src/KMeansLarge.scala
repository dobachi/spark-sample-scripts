println("**************************")
println("Large K-Means sample")
println("**************************")
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors

println("")
println("Define the input data")
println("=====================")
println("")
val dataUrl = "s3n://xxxxxxxxxx/USCensus1990.data.txt"
val data = sqlContext.read.format("com.databricks.spark.csv").option("inferSchema", "true").option("header", "true").load(dataUrl)
data.registerTempTable("input")

println("")
println("Create a K-Means model and calculate cluster centers")
println("====================================================")
println("")
sqlContext.udf.register("toVector", (i1: Integer, i2: Integer, i3: Integer) => Vectors.dense(i1.toDouble, i2.toDouble, i3.toDouble))
val features = data.selectExpr("toVector(dIncome1, dIncome2, dIncome3) as feature", "caseid")
val kmeans = new KMeans().setK(3).setFeaturesCol("feature").setPredictionCol("prediction")
val model = kmeans.fit(features)
val predicted = model.transform(features)
predicted.show

