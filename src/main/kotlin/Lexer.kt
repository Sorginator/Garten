

fun readCode(inputString: String) : ArrayList<Array<String>>
{
    var zeilenWeiseTrennung = inputString.split("\n")
    var out= arrayListOf<Array<String>>()
    zeilenWeiseTrennung.forEach{
        out.add(it.split(" ").toTypedArray())
    }
    return out

}

fun getExpression(potentialExpression: Array<String>): Expression {
    var nothing=Expression.nothing("Keine Akzeptierte Eingabe")
    when(potentialExpression[0]) {
        "gartenErstellen" -> {
            var c = potentialExpression[1].split("x")
            when(c.size){
                1-> {
                    try {
                        var x = c[0].toInt()
                        return Expression.gartenErstellen(x,1,1)
                    }catch(e:Exception){
                        return nothing
                    }
                }
                2-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        return Expression.gartenErstellen(x,y,1)
                    }catch(e:Exception){
                        return nothing
                    }
                }
                3-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[0].toInt()
                        var z = c[0].toInt()
                        return Expression.gartenErstellen(x,y,z)
                    }catch(e:Exception){
                        return nothing
                    }
                }
            }
        }
        "gartenErweitern" ->{
            var c = potentialExpression[1].split("x")
            when(c.size){
                1-> {
                    try {
                        var x = c[0].toInt()
                        return Expression.gartenErweitern(x,0,0)
                    }catch(e:Exception){
                        return nothing
                    }
                }
                2-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        return Expression.gartenErweitern(x,y,0)
                    }catch(e:Exception){
                        return nothing
                    }
                }
                3-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[0].toInt()
                        var z = c[0].toInt()
                        return Expression.gartenErweitern(x,y,z)
                    }catch(e:Exception){
                        return nothing
                    }
                }
            }
        }
        "gartenVerkleinern" -> {
            var c = potentialExpression[1].split("x")
            when(c.size){
                1-> {
                    try {
                        var x = c[0].toInt()
                        return Expression.gartenVerkleinern(x,0,0)
                    }catch(e:Exception){
                        return nothing
                    }
                }
                2-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        return Expression.gartenVerkleinern(x,y,0)
                    }catch(e:Exception){
                        return nothing
                    }
                }
                3-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        var z = c[2].toInt()
                        return Expression.gartenVerkleinern(x,y,z)
                    }catch(e:Exception){
                        return nothing
                    }
                }
            }
        }
        "pflanzen" -> {
            var c = potentialExpression[1].split("x")
            when(c.size){
                1-> {
                    try {
                        var x = c[0].toInt()
                        return Expression.pflanzen(x,1,1)
                    }catch(e:Exception){
                        return nothing
                    }
                }
                2-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        return Expression.pflanzen(x,y,1)
                    }catch(e:Exception){
                        return nothing
                    }
                }
                3-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        var z = c[2].toInt()
                        return Expression.pflanzen(x,y,z)
                    }catch(e:Exception){
                        return nothing
                    }
                }
            }
        }
        "ernten" -> {
            var c = potentialExpression[1].split("x")
            when(c.size){
                1-> {
                    try {
                        var x = c[0].toInt()
                        return Expression.ernten(x,1,1)
                    }catch(e:Exception){
                        return nothing
                    }
                }
                2-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        return Expression.ernten(x,y,1)
                    }catch(e:Exception){
                        return nothing
                    }
                }
                3-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        var z = c[2].toInt()
                        return Expression.ernten(x,y,z)
                    }catch(e:Exception){
                        return nothing
                    }
                }
            }
        }
        "bewässern" -> {
            var c = potentialExpression[1].split("x")
            when(c.size){
                1-> {
                    try {
                        var x = c[0].toInt()
                        return Expression.bewässern(x,1,1)
                    }catch(e:Exception){
                        return nothing
                    }
                }
                2-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        return Expression.bewässern(x,y,1)
                    }catch(e:Exception){
                        try {
                            var x = c[0].toInt()
                            var w:Wasser
                            when(c[1]){
                                "Normal" -> w =Wasser.Normal
                                "Hexagonal" -> w=Wasser.Hexagonal
                                else -> {
                                    w=Wasser.Normal
                                    throw Exception()
                                }
                            }
                            return Expression.bewässern(x,1,1, w)
                        }catch(e:Exception){
                        return nothing
                    }
                    }
                }
                3-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        var z = c[2].toInt()
                        return Expression.bewässern(x,y,z)
                    }catch(e:Exception){
                        try {
                            var x = c[0].toInt()
                            var y = c[1].toInt()
                            var w:Wasser
                            when(c[2]){
                                "Normal" -> w =Wasser.Normal
                                "Hexagonal" -> w=Wasser.Hexagonal
                                else -> {
                                    w=Wasser.Normal
                                    throw Exception()
                                }
                            }
                            return Expression.bewässern(x,y,1, w)
                        }catch(e:Exception){
                            return nothing
                        }
                    }
                }
                4-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        var z = c[2].toInt()
                        var w:Wasser
                        when(c[3]){
                            "Normal" -> w =Wasser.Normal
                            "Hexagonal" -> w=Wasser.Hexagonal
                            else -> {
                                w=Wasser.Normal
                                throw Exception()
                            }
                        }
                        return Expression.bewässern(x,y,z, w)
                    }catch(e:Exception){
                        return nothing
                    }
                }
            }
        }
        "beschneiden" ->  {
            var c = potentialExpression[1].split("x")
            when(c.size){
                1-> {
                    try {
                        var x = c[0].toInt()
                        return Expression.beschneiden(x,1,1)
                    }catch(e:Exception){
                        return nothing
                    }
                }
                2-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        return Expression.beschneiden(x,y,1)
                    }catch(e:Exception){
                        return nothing
                    }
                }
                3-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        var z = c[2].toInt()
                        return Expression.beschneiden(x,y,z)
                    }catch(e:Exception){
                        return nothing
                    }
                }
            }
        }
        "düngen" -> {
            var c = potentialExpression[1].split("x")
            when(c.size){
                1-> {
                    try {
                        var x = c[0].toInt()
                        return Expression.düngen(x,1,1)
                    }catch(e:Exception){
                        return nothing
                    }
                }
                2-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        return Expression.düngen(x,y,1)
                    }catch(e:Exception){
                        try {
                            var x = c[0].toInt()
                            var d:Dünger
                            when(c[1]){
                                "Standard" -> d =Dünger.Standart
                                "Globuli" -> d=Dünger.Globuli
                                else -> {
                                    d=Dünger.Standart
                                    throw Exception()
                                }
                            }
                            return Expression.düngen(x,1,1, d)
                        }catch(e:Exception){
                            return nothing
                        }
                    }
                }
                3-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        var z = c[2].toInt()
                        return Expression.düngen(x,y,z)
                    }catch(e:Exception){
                        try {
                            var x = c[0].toInt()
                            var y = c[1].toInt()
                            var d:Dünger
                            when(c[2]){
                                "Standard" -> d =Dünger.Standart
                                "Globuli" -> d=Dünger.Globuli
                                else -> {
                                    d=Dünger.Standart
                                    throw Exception()
                                }
                            }
                            return Expression.düngen(x,y,1, d)
                        }catch(e:Exception){
                            return nothing
                        }
                    }
                }
                4-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        var z = c[2].toInt()
                        var d:Dünger
                        when(c[3]){
                            "Standard" -> d =Dünger.Standart
                            "Globuli" -> d=Dünger.Globuli
                            else -> {
                                d=Dünger.Standart
                                throw Exception()
                            }
                        }
                        return Expression.düngen(x,y,z, d)
                    }catch(e:Exception){
                        return nothing
                    }
                }
            }
        }
        "auspendeln" -> return Expression.auspendeln()
        "var" -> return nothing
        else -> return nothing
    }
    return nothing
}