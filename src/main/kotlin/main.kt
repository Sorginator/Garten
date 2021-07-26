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