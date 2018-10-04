// import everything from the package
import java.lang.Math._
cos(0)

// import class and rename it
import System.out.{println => p}
p("this is System.out.println")



// import specific class and rename it
import java.util.{ArrayList=>JavaList, Random=>_, _}
new JavaList[String]()



// not to import specific class, except one class
// import everything from the package
import java.util.{Random=>_, _}
// not working - even due statement below
// new Random()


// narrow import inside method
def generateRandom():Int={
  // import visible only inside current block
  import java.util.Random
  new Random().nextInt(1000)
}