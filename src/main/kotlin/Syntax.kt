
sealed class Expression {
    data class Var(val name: String): Expression()
    //he doesn't like Integer yo. We're doing Kotlin if you need nullable do ? instead.
    data class gartenErstellen(val größeX: Int, val größeY: Int, val größeZ: Int): Expression()
    data class gartenErweitern(val x: Int, val y: Int, val z: Int): Expression()
    data class gartenVerkleinern(val x: Int, val y: Int, val z: Int): Expression()
    //was zum fick ist nummer???
    data class pflanzen(val positionX: Integer, val positionY: Integer, val nummer: Integer): Expression()
    data class ernten(val positionX: Integer, val positionY: Integer): Expression()
    data class bewässern(val positionX: Integer, val positionY: Integer, val wasserVariante: Wasser = Wasser.Normal): Expression()
    data class beschneiden(val positionX: Integer, val positionY: Integer): Expression()
    data class düngen(val positionX: Integer, val positionY: Integer, val düngerVariante: Dünger = Dünger.Standart)
    data class auspendeln(val pendelVariante: String = "Standart"): Expression()
}

enum class Dünger {
    Standart, Globuli
}

enum class Wasser {
    Normal, Hexagonal
}