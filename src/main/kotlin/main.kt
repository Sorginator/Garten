var stuff:Stuff= Stuff()

fun main (input:String)
{
    readCode(input).forEach{
        parse(getExpression(it))
    }
}