# code examples
* [twitter](http://twitter.github.io/effectivescala/)

# styleguide
* [spark creator](http://github.com/databricks/scala-style-guide)

# online editor 
* [execute code online](https://scastie.scala-lang.org/)
* [execute code online with ability to draw graphics](https://scalafiddle.io/)
  * https://scalafiddle.io/sf/KOsXSKv/0
  * https://scalafiddle.io/sf/4beVrVc/1

# Shell, Console
[shell scripting](http://ammonite.io/)


# tutorials
* [overview](https://docs.scala-lang.org/overviews/)
* [collection performance](https://docs.scala-lang.org/overviews/collections/performance-characteristics.html)
* [online documentation, api](https://www.scala-lang.org/api/)
* [scala for java programmers](https://docs.scala-lang.org/tutorials/scala-for-java-programmers.html)
* [scala templates and tutorials](https://developer.lightbend.com/start/)
* [spark scala tutorial](https://github.com/deanwampler/spark-scala-tutorial)
* [spark scala tutorial](https://github.com/ktoso/spark-workshop)

![scala collection](https://i.postimg.cc/dtNC7zdf/scala-collection.png)


# scalac
## exception: "IO error while decoding .... with UTF-8"
solution:
> add double quota to "-classpath" parameter

## compile class with classpath
```
scalac -classpath "/home/technik/.sdkman/candidates/spark/2.3.0/jars/*" udt.scala
```

## compile code into jar
```
scalac -classpath "/home/technik/.sdkman/candidates/spark/2.3.0/jars/*" udt.scala -d udt.jar
```
