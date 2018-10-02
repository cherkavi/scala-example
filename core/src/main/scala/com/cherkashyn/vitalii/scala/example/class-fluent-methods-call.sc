class FluentMethodsExample(private var init_value:Int = 0) {
  var x = this.init_value

  def init(startValue:Int): this.type ={
    this.x = startValue
    this
  }

  def add(value:Int):this.type = {
    this.x = this.x + value
    this
  }

  def sub(value:Int):this.type = {
    this.x = this.x - value
    this
  }

  def result:Int = this.x

}

val holder = new FluentMethodsExample
holder.init(5).add(5).sub(3).result