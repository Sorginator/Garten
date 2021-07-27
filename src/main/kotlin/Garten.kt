class Garten (var a: Int,var b: Int,var c: Int)
{
    var garten:Array<Array<Array<Feld?>>> = Array(a) { Array(b) { arrayOfNulls(c) } }
    fun init()
    {
        garten.forEach {
            it.forEach {
                for (i in 0..it.size-1)
                {
                    it[i]=Feld()
                }
            }
        }
    }

    private val akashas = arrayOfNulls<Akasha>(4)

    private fun checkfeld(a: Int, b: Int, c: Int) {
        if (garten[a][b][c] == null) garten[a][b][c] = Feld()
    }

    fun akashaHinzufuegen(a: Akasha?, pos: Int) {
        if (akashas[pos] == null) akashas[pos] = a else println("Platz besetzt.")
    }
}