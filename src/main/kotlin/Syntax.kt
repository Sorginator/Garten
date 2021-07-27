
sealed class Expression {
    //what is this??
    data class Var(val name: String): Expression()
    //he doesn't like Integer yo. We're doing Kotlin if you need nullable do ? instead.
    data class gartenErstellen(val x: Int, val y: Int, val z: Int): Expression()
    data class gartenErweitern(val x: Int, val y: Int, val z: Int): Expression()
    data class gartenVerkleinern(val x: Int, val y: Int, val z: Int): Expression()
    //was zum fick ist nummer???
    data class pflanzen(val x: Int, val y: Int, val z: Int): Expression()
    data class ernten(val x: Int, val y: Int, val z:Int): Expression()
    data class bewässern(val x: Int, val y: Int, val z: Int, val wasserVariante: Wasser = Wasser.Normal): Expression()
    data class beschneiden(val x: Int, val y: Int, val z: Int): Expression()
    data class düngen(val x: Int, val y: Int, val z: Int, val düngerVariante: Dünger = Dünger.Standart):Expression()
    data class auspendeln(val pendelVariante: String = "Standart"): Expression()
    data class nothing(val why:String) : Expression()
}

enum class Dünger {
    Standart, Globuli
}

enum class Wasser {
    Normal, Hexagonal
}