
class Stuff
{
    //0=nacht, 1=morgen(Licht von Osten), 2=mittag,3=nacht
    var tageszeit=0
    var garten: Garten=Garten(1,1,1)
    var currentGarten: Int=0
}

fun yo (input:String)
{
    if(stuff.garten.garten[0][0][0]==null)stuff.garten.init()
    readCode(input).forEach{
        parse(getExpression(it))
    }
}

fun prüfen()
{
    aktuellerGarten().garten.forEach {
        it.forEach {
            it.forEach {
                if (it != null) {
                    print(it.pflanze)
                }else{
                    print(-1.0)
                }
                print(" ")
            }
        }
        println()
        println("------")
    }
}
var stuff:Stuff= Stuff()
fun main()
{

    yo("gartenErstellen 2x2\nbewässern 1x1\npflanzen 1x1\npflanzen 0x0\nauspendeln")
    yo("pflanzen 1x0\npflanzen 0x1\nbewässern 1x1\nbewässern 1x0\nbewässern 0x1\ndüngen Standart 1x1\nauspendeln")
    yo("pflanzen 0x0\nbewässern 0x0 Hexagonal\nbewässern 1x0\nbewässern 1x1\nbewässern 0x1\ndüngen Globuli 0x0\nauspendeln")
    yo("düngen 1x1 Globuli\ndüngen 1x1 Globuli\ndüngen 1x1 Globuli\ndüngen 1x1 Globuli\ndüngen 1x1 Globuli\ndüngen 1x1 Globuli\ndüngen 1x1 Globuli\ndüngen 1x1 Globuli\ndüngen 1x1 Globuli\ndüngen 1x1 Globuli\nauspendeln")
    yo("bewässern 1x1 Hexagonal\nauspendeln")
    yo("beschneiden 1x1\nauspendeln")
    yo("ernten 0x0\nauspendeln")
    yo("ernten 1x0\nernten 0x1\nauspendeln")

    prüfen()

}