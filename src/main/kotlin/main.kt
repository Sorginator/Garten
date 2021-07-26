import java.lang.reflect.Field
import kot lin.collections.arrayListOf
import kotlin.Array

//this is main, it will organize all the shit

var stuff:Stuff= Stuff()

fun decide(input:String)
{
    var words = input.split(" ")
    if (words!=null&&words.size>=3)
    {
        when (words[0])
        {
            "neuer" -> when (words[1])
            {
                "Garten" -> {
                    var size=words[2].split("x")
                    if(size.size==0) return
                    if(size.size==1)
                    {
                        neuerGarten(size[0].toInt(),1,1)
                    }
                    else if(size.size==2)
                    {
                        neuerGarten(size[0].toInt(),size[1].toInt(),1)
                    }
                    else if(size.size==3)
                    {
                        neuerGarten(size[0].toInt(),size[1].toInt(),size[2].toInt())
                    }
                    else
                    {
                        print("Invalid Syntax")
                    }
                }
            }
            "neue" -> when (words[1])
            {
                "Akasha" -> if(words.size==4){
                    if(words[4]=="auf")
                    {
                        if(stuff.garten!=null&& stuff.garten!![stuff.currentGarten]!=null)try {
                            stuff.garten!![stuff.currentGarten].akashaHinzufuegen(Akasha(words[4].toInt(), words[3], words[2]), words[3].toInt())
                        }catch (e: Exception){
                            print("Invalid Syntax")
                        }
                    }
                }
            }
            "Pflanze"-> when(words[1])
            {
                "einsetzen"->{
                    try {
                        var c=convertCoords(words[2])
                        var a:Double=g()[c[0]][c[1]][c[2]].pflanze
                        if(a!=Double.NaN) g()[c[0]][c[1]][c[2]].pflanze=0.0
                        else
                        {
                            print("Bereits bepflanzt.")
                        }
                    }catch (e:Exception)
                    {
                        print("Invalid Syntax")
                    }
                }
                "ernten"->{try {
                    var c=convertCoords(words[2])
                    var a:Double=g()[c[0]][c[1]][c[2]].pflanze
                    if(a!=Double.NaN) {
                        g()[c[0]][c[1]][c[2]].pflanze=Double.NaN
                        if(a<5.0) print("Zu früh. Kein Ertrag.")
                        else print("Erfoglreiche Ernte!")
                    }
                    else throw Exception()
                }catch(e:Exception){
                    print("Invalid Syntax")
                }}
                "waessern"->{try {
                    var c=convertCoords(words[2])
                    if(c!=null) {
                        g()[c[0]][c[1]][c[2]].feuchtigkeit+=2.0
                    }
                    else throw Exception()
                }catch(e:Exception){
                    print("Invalid Syntax")
                }}
                "duengen"->{try {
                    var c=convertCoords(words[2])
                    if(c!=null) {
                        g()[c[0]][c[1]][c[2]].globuli+=1
                    }
                    else throw Exception()
                }catch(e:Exception){
                    print("Invalid Syntax")
                }}
                "Chakrastein"->if(words.size==4){when(words[2])
                {
                    "hinzufuegen"->{
                        try {
                            var c=convertCoords(words[3])
                            if(c!=null) {
                                g()[c[0]][c[1]][c[2]].anzahlKristalle+=1
                            }
                            else throw Exception()
                        }catch(e:Exception){
                            print("Invalid Syntax")
                        }
                    }
                    "entfernen"->{
                        try {
                            var c=convertCoords(words[3])
                            if(c!=null) {
                                g()[c[0]][c[1]][c[2]].anzahlKristalle-=1
                            }
                            else throw Exception()
                        }catch(e:Exception){
                            print("Invalid Syntax")
                        }
                    }
                }
                }
                "pruefen"->{
                    try {
                        var c=convertCoords(words[2])
                        if(c!=null) {
                            var f=g()[c[0]][c[1]][c[2]]
                            if(f.pflanze==Double.NaN)print("Das Feld liegt brach.")
                            else if (f.pflanze<5.0)print("Die Pflanze wächst vor sich hin.")
                            else print("Die Pflanze ist bereit zum ernten.")

                            if(f.feuchtigkeit<=0.5) print("Die Erde scheint sehr trocken.")
                            if(f.feuchtigkeit<2.0) print("Die Erde trocknet bald aus.")
                            else if(f.feuchtigkeit<=4.0) print("Die Erde ist schön feucht.")
                            else if(f.feuchtigkeit<=5.5) print("Die Erde scheint ein bisschen sehr feucht.")
                            else print("Huii, eine Schlammpfütze!")

                            if(f.befallen) print("Dank der Globukalypse die du hier veranstaltet hast ist die Pflanze jetzt von Schädlingen befallen.")

                            if (f.anzahlKristalle>=4&&!f.pflanze==Double.NaN) print("Die Pflanze weist eine Art Sonnenbrand auf.")
                        }
                        else throw Exception()
                    }catch(e:Exception){
                        print("Invalid Syntax")
                    }
                }
            }

        }
    }
}

fun neuerGarten(a:Int, b:Int, c:Int)
{
    try {
        if(stuff.garten==null)
        {
            stuff.garten= arrayListOf(Garten(a,b,c))
        }
    } catch (e:Exception){
        print("Invalid Syntax")
    }
}

fun g(): Garten?
{
    return stuff.garten?.get(stuff.currentGarten)
}

fun convertCoords(c:String):Array<Int>?
{
    var a=c.split("x")
    when(a.size){
        0->print("Invalid Syntax")
        1->{
            try {
                var b: Array<Int> = arrayOf(a[0].toInt(),1,1)
                return b
            }catch (e:Exception){
                print("Invalid Syntax")
            }
        }
        2->{
            try {
                var b: Array<Int> = arrayOf(a[0].toInt(),a[1].toInt(),1)
                return b
            }catch (e:Exception){
                print("Invalid Syntax")
            }
        }
        3->{
            try {
                var b: Array<Int> = arrayOf(a[0].toInt(),a[1].toInt(),a[2].toInt())
                return b
            }catch (e:Exception){
                print("Invalid Syntax")
            }
        }
    }
    throw Exception()
}