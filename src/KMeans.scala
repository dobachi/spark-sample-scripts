println("**************************")
println("K-Means sample")
println("**************************")
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors

println("")
println("Define the input data")
println("=====================")
println("")
val data = sqlContext.read.format("com.databricks.spark.csv").option("inferSchema", "true").load("/tmp/iris.data")
sqlContext.udf.register("toVector", (a: Double, b: Double, c:Double,  d:Double) => Vectors.dense(a, b, c, d))

println("")
println("Create feature vectors and generate a K-Means model")
println("===================================================")
println("")
val features = data.selectExpr("toVector(C0, C1, C2, C3) as feature", "C4 as name")
val kmeans = new KMeans().setK(3).setFeaturesCol("feature").setPredictionCol("prediction")
val model = kmeans.fit(features)

println("")
println("Calculate cluster centers")
println("=========================")
println("")
val predicted = model.transform(features)
predicted.show
predicted.registerTempTable("predicted")

import org.apache.spark.sql.expressions.Window


println("")
println("Find top three objects")
println("======================")
println("")
val top3 = sqlContext.sql("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (PARTITION BY name) AS rn FROM predicted) x WHERE rn <= 3")
top3.show()

