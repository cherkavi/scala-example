val x = 5
val greeting = "hello"



s"I can greeting [${greeting}] even $x times"

f"I can greeting [$greeting%s] even $x%d times"

"I can greeting [%s] even %d times".format(greeting, x)

s"I can greeting [#{text_message}] even #{number_value} times"
  .format("text_message"->greeting, "number_value"->x)

val mapping = Map("text_message"->greeting, "number_value"->x)
s"I can greeting [#{text_message}] even #{number_value} times".format(mapping)
