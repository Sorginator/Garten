

fun readCode(inputString: String) {
    var zeilenWeiseTrennung = inputString.split("\n")
    zeilenWeiseTrennung.forEach(

    )

}

fun getExpression(potentialExpression: Array<String>): Expression {
    when(potentialExpression[0]) {
        "gartenErstellen" -> {
            var c = potentialExpression[1].split("x")
            when(c.size){
                1-> {
                    try {
                        var x = c[0].toInt()
                        return Expression.gartenErstellen(x,1,1)
                    }catch(e:Exception){
                        //c[0] is not convertable to int so no valid expression
                    }
                }
                2-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        return Expression.gartenErstellen(x,y,1)
                    }catch(e:Exception){
                        //c[0] is not convertable to int so no valid expression
                    }
                }
                3-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[0].toInt()
                        var z = c[0].toInt()
                        return Expression.gartenErstellen(x,y,z)
                    }catch(e:Exception){
                        //c[0] is not convertable to int so no valid expression
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
                        //c[0] is not convertable to int so no valid expression
                    }
                }
                2-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        return Expression.gartenErweitern(x,y,0)
                    }catch(e:Exception){
                        //c[0] is not convertable to int so no valid expression
                    }
                }
                3-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[0].toInt()
                        var z = c[0].toInt()
                        return Expression.gartenErweitern(x,y,z)
                    }catch(e:Exception){
                        //c[0] is not convertable to int so no valid expression
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
                        //c[0] is not convertable to int so no valid expression
                    }
                }
                2-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[1].toInt()
                        return Expression.gartenVerkleinern(x,y,0)
                    }catch(e:Exception){
                        //c[0] is not convertable to int so no valid expression
                    }
                }
                3-> {
                    try {
                        var x = c[0].toInt()
                        var y = c[0].toInt()
                        var z = c[0].toInt()
                        return Expression.gartenVerkleinern(x,y,z)
                    }catch(e:Exception){
                        //c[0] is not convertable to int so no valid expression
                    }
                }
            }
        }
        "pflanzen" -> TODO()
        "ernten" -> TODO()
        "bewässern" -> TODO()
        "beschneiden" -> TODO()
        "düngen" -> TODO()
        "auspendeln" -> TODO()
        "var" -> TODO()
        else -> null
    }
}