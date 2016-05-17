val sparkHome = sys.env("SPARK_HOME")
val path = sparkHome + "/examples/src/main/resources/users.parquet"
val users = sqlContext.read.parquet(path)

users.registerTempTable("users")

val redLover = sqlContext.sql("SELECT name, favorite_color FROM users WHERE favorite_color = 'red'").show

