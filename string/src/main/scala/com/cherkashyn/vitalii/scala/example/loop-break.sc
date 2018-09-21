// ------- loop for and break
import scala.util.control.Breaks._
import scala.util.control.Breaks

// example of break
breakable{
  for(i<-0.to(5)){
    if (i==2)break
    print(i)
  }
}

// example of break without Breaks
var shouldStop = false
for(i<- 0 to 5 if shouldStop==false){
  shouldStop = (i==3)
  print(i)
}

// example of continue
for(i<- 0 until 5){
  breakable({
    if(i==2)break
    print(i)
  })
}


// multi break example
val BreakLevel1 = new Breaks()
val BreakLevel2 = new Breaks()

BreakLevel1.breakable{
  for(i<- 1 to 5){
    BreakLevel2.breakable{
      for(j<-1 to 5){
        print(i + " " + j + " | " )
        if(i%2==1){
          println("BreakLevel2.break")
          BreakLevel2.break
        }
        if(j>3){
          println("BreakLevel1.break")
          BreakLevel1.break
        }
      }
    }
  }
}

var index = 0
breakable(
  while( index<10 ){
    if(index==3)break
    print(index+" ")
    index+=1
  }
)

var i = 10
breakable(
  do{
    if(i==7)break
    print(i+" ")
    i-=1
  }while(i>5)
)
