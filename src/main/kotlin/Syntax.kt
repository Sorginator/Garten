
sealed class Expression {
    data class Var(val name: String): Expression()
    data class gartenErstellen(val größeX: Integer, val größeY: Integer): Expression()
    data class gartenErweitern(val erweiterungX: Integer, val erweiterungY: Integer): Expression()
    data class gartenVerkleinern(val verringernX: Integer, val verringernY: Integer): Expression()
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