import java.lang.reflect.Field
import kotlin.collections.arrayListOf
import kotlin.Array

//this is main, it will organize all the shit
class main
{
    var garten= arrayListOf<Array<Field>>()
    //0=nacht, 1=morgen, 2=mittag, 3=abend
    var tageszeit=0
    var globuliZähler: Int = 0
    //four corners, four possible akashas. Arrays are strange so placeholders with 0 height are ignored by the logic
    var akashas: Array<Akasha> = arrayOf(Akasha(0, "air", "dummyno"),Akasha(0, "air", "dummyso"),Akasha(0, "air", "dummysw"),Akasha(0, "air", "dummynw"))

}

