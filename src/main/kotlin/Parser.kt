import java.lang.RuntimeException



fun parse(e:Expression)
{
    if (e is Expression.gartenErstellen)
    {
        gartenErstellen(e)
        return
    }
    if (e is Expression.gartenErweitern)
    {
        gartenErweitern(e)
        return
    }
    if (e is Expression.gartenVerkleinern)
    {
        gartenVerkleinern(e)
        return
    }
    if (e is Expression.pflanzen)
    {
        pflanzen(e)
        return
    }
    if (e is Expression.ernten)
    {
        ernten(e)
        return
    }
    if (e is Expression.bewässern)
    {
        bewässern(e)
        return
    }
    if (e is Expression.beschneiden)
    {
        beschneiden(e)
        return
    }
    if (e is Expression.düngen)
    {
        düngen(e)
        return
    }
    if (e is Expression.auspendeln)
    {
        auspendeln(e)
        return
    }
    if (e is Expression.nothing) {
        println("Invalid syntax")
        return
    }
}

fun düngen(e:Expression.düngen)
{
    if(aktuellerGarten().garten[e.x][e.y][e.z]?.pflanze!=null)
    {
        if (e.düngerVariante==Dünger.Standart) aktuellerGarten().garten[e.x][e.y][e.z]!!.pflanze+=0.25
        if (e.düngerVariante==Dünger.Globuli) aktuellerGarten().garten[e.x][e.y][e.z]!!.globuli+=1
    }
}

fun beschneiden(e:Expression.beschneiden)
{
    stuff.garten.garten[e.x][e.y][e.z]!!.befallen=false
}

fun bewässern(e:Expression.bewässern)
{
    stuff.garten.garten[e.x][e.y][e.z]!!.feuchtigkeit+=2.0
}

fun auspendeln(e:Expression.auspendeln)
{
    aktuellerGarten().garten.forEach {
        it.forEach {
            it.forEach {
                try {
                    var m = 1.1
                    if (it!!.anzahlKristalle > 3) m -= 0.5
                    if (it.feuchtigkeit <= 0.5) m -= 1.5
                    else if (it.feuchtigkeit < 2) m += 0.1
                    else if (it.feuchtigkeit <= 4) m += 0.5
                    else if (it.feuchtigkeit <= 5.5) m += 0.1
                    else if (it.feuchtigkeit > 5.5) m -= 1.5
                    it.feuchtigkeit-=0.5
                    if(it.feuchtigkeit<0)it.feuchtigkeit=0.0
                    if (it.globuli > 9) {
                        it.befallen = true
                        println("Dank der Globukalypse die du veranstaltet hast ist eine Pflanze jetzt von Käfern befallen.")
                        it.globuli-=10
                    }else if (it.befallen) println("Eine Pflanze leidet weiter unter Käferbefall.")
                    if (it.befallen) m -= 1.5
                    it.pflanze += m
                    if (it.pflanze < 0) it.pflanze = Double.NaN
                } catch (e:Exception)
                {
                    println("sth went wrong")
                }
            }
        }
    }

}

fun ernten(e:Expression.ernten)
{
    if(aktuellerGarten().garten[e.x][e.y][e.z]!!.pflanze!=Double.NaN)
    {
        var a= aktuellerGarten().garten[e.x][e.y][e.z]!!.pflanze
        aktuellerGarten().garten[e.x][e.y][e.z]!!.pflanze=Double.NaN
        if(a<5.0) println("Zu früh. Kein Ertrag.")
        else println("Erfoglreiche Ernte!")
    }
    else println("Das Feld ist leer.")
}

fun gartenErstellen(e:Expression.gartenErstellen)
{
    stuff.garten=Garten(e.x,e.y,e.z)
    stuff.garten.init()
}

fun aktuellerGarten(): Garten
{
    val aktuellerGarten = stuff.garten
    return aktuellerGarten;
}

fun gartenErweitern(e:Expression.gartenErweitern)
{
    if(stuff.garten!=null)
    {
        var g=Garten(aktuellerGarten().garten.size+e.x,aktuellerGarten().garten[0].size+e.y,aktuellerGarten().garten[0][0].size+e.z)
        stuff.garten=g
        stuff.garten.init()
    }
}

fun gartenVerkleinern(e:Expression.gartenVerkleinern)
{
    if(stuff.garten!=null)
    {
        var g=Garten(aktuellerGarten().garten.size+e.x,aktuellerGarten().garten[0].size+e.y,aktuellerGarten().garten[0][0].size+e.z)
        stuff.garten=g
        stuff.garten.init()
    }
}

fun pflanzen(e:Expression.pflanzen)
{
    try {
        if(stuff.garten.garten[e.x][e.y][e.z]!!.pflanze.equals(Double.NaN)) {
            aktuellerGarten().garten[e.x][e.y][e.z]!!.pflanze = 0.0
        }
    }catch (e:Exception)
    {
        print("Feld bereits besetzt!")
    }
}