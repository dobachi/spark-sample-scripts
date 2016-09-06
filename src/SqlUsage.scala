val sparkHome = sys.env("SPARK_HOME")
val path = sparkHome + "/examples/src/main/resources/users.parquet"
val usersDF = sqlContext.read.parquet(path)

usersDF.registerTempTable("users")

// use SQL
val redLover = sqlContext.sql("SELECT name, favorite_color FROM users WHERE favorite_color = 'red'")
redLover.show


// use DataFrame API
val redLover2 = usersDF.where($"favorite_color" === "red").select($"name", $"favorite_color")
redLover2.show
