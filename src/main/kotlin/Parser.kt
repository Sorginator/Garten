fun parse(e:Expression)
{
    if (e is Expression.gartenErstellen) return //method call
    if (e is Expression.gartenErweitern) return //method call
    if (e is Expression.gartenVerkleinern) return //method call
    if (e is Expression.pflanzen) return //method call
    if (e is Expression.ernten) return //method call
    if (e is Expression.bewässern) return //method call
    if (e is Expression.beschneiden) return //method call
    if (e is Expression.düngen) return //method call
    if (e is Expression.auspendeln) return //method call
    if (e is Expression.nothing) return //method call
}