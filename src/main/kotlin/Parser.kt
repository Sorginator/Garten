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
    if (e is Expression.nothing) return
}

fun düngen(e:Expression.düngen)
{
    if (e.düngerVariante==Dünger.Standart) aktuellerGarten().garten[e.x][e.y][e.z].pflanze+=0.25
    if (e.düngerVariante==Dünger.Globuli) aktuellerGarten().garten[e.x][e.y][e.z].globuli+=1
}

fun beschneiden(e:Expression.beschneiden)
{
    aktuellerGarten().garten[e.x][e.y][e.z].befallen=false
}

fun bewässern(e:Expression.bewässern)
{
    aktuellerGarten().garten[e.x][e.y][e.z].feuchtigkeit+=2.0
}

fun auspendeln(e:Expression.auspendeln)
{
    aktuellerGarten().garten.forEach {
        it.forEach {
            it.forEach {
                var m=1.1
                if(it.anzahlKristalle>3) m -= 0.5
                if (it.feuchtigkeit<=0.5) m-=1.5
                else if (it.feuchtigkeit<2) m+=0.1
                else if (it.feuchtigkeit<=4) m+=0.5
                else if (it.feuchtigkeit<=5.5) m+=0.1
                else if (it.feuchtigkeit>5.5) m-=1.5
                if(it.globuli>19)it.befallen=true
                if (it.befallen)m-=1.5
                it.pflanze=it.pflanze*m
                if (it.pflanze<0)it.pflanze= Double.NaN
            }
        }
    }

}

fun ernten(e:Expression.ernten)
{
    if(aktuellerGarten().garten[e.x][e.y][e.z].pflanze!=Double.NaN)
    {
        var a=aktuellerGarten().garten[e.x][e.y][e.z].pflanze
        aktuellerGarten().garten[e.x][e.y][e.z].pflanze=Double.NaN
        if(a<5.0) print("Zu früh. Kein Ertrag.")
        else print("Erfoglreiche Ernte!")
    }
    else print("Das Feld ist leer.")
}

fun gartenErstellen(e:Expression.gartenErstellen)
{
    if(stuff.garten==null)stuff.garten= arrayListOf(Garten(e.x,e.y,e.z))
    else stuff.garten!!.add(Garten(e.x,e.y,e.z))
    stuff.currentGarten=stuff.garten!!.size-1
}

fun aktuellerGarten(): Garten
{
    val aktuellerGarten = stuff.garten?.get(stuff.currentGarten)
    if (aktuellerGarten == null) throw RuntimeException("Kein Aktueller Garten gefunden!")
    return aktuellerGarten;
}

fun gartenErweitern(e:Expression.gartenErweitern)
{
    if(stuff.garten!=null)
    {
        var g=Garten(aktuellerGarten().garten.size+e.x,aktuellerGarten().garten[0].size+e.y,aktuellerGarten().garten[0][0].size+e.z)
        stuff.garten!!.removeAt(stuff.currentGarten)
        stuff.garten
    }
}

fun gartenVerkleinern(e:Expression.gartenVerkleinern)
{
    if(stuff.garten!=null)
    {
        var g=Garten(aktuellerGarten().garten.size+e.x,aktuellerGarten().garten[0].size+e.y,aktuellerGarten().garten[0][0].size+e.z)
        stuff.garten!!.removeAt(stuff.currentGarten)
        stuff.garten
    }
}

fun pflanzen(e:Expression.pflanzen)
{
    try {
        if(aktuellerGarten().garten[e.x][e.y][e.z].pflanze==Double.NaN)aktuellerGarten().garten[e.x][e.y][e.z].pflanze=0.0
    }catch (e:Exception)
    {
        print("Feld bereits besetzt!")
    }
}