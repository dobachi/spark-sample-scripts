# Spark simple exmaples

This is a set of Spark application script examples,
which run on spark-shell.

You can use these scripts as references and execute them on spark-shell with :load function as a test.

feature

* Easy to run
* Easy to modify
* Suitable for beginners

THe following is the example to execute on spark-shell by :load function.
After these examples, please refer to example's contents.

## WordCount
Start spark-shell

```shell
$ spark-shell
```

Load scala scripts

```
scala> :load src/WordCount.scala
```

## Cache usage

Start spark-shell

```shell
$ spark-shell
```

Load scala scripts

```
scala> :load src/CacheUse.scala
```

## SQL usage

Start spark-shell

```
$ ./bin/shell_csv.sh
```

Load scala scripts

```
scala> :load src/SqlUsage.scala
```

## KMeans

Start spark-shell

```
$ ./bin/shell_csv.sh
```
Load scala scripts

```
scala> :load src/KMeans.scala
```

## KMeans with large data

Start spark-shell

```
$ ./bin/shell_large_kmeans.sh
```

Load scala scripts

```
scala> :load src/KMeansLarge.scala
```

## Tweet printing

Create config.properties

```
twitter_consumerKey=xxxxxxxxx
twitter_consumerSecret=xxxxxxxxx
twitter_accessToken=xxxxxxxxx
twitter_accessTokenSecret=xxxxxxxxxxxx
```

Start spark-shell

```
$ ./bin/shell_tweet.sh
```

Load scala scripts

```
scala> :load src/Tweet.scala
```


