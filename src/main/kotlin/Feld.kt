//ja das ist schon sehr komplex, no worries wenn's nicht passt, nur Idee für Erweiterung
class Feld
{
    //NaN= keine Pflanze, 0=Samen, bis 5 Wachstumsphase, 5 Erntereif
    var pflanze: Double= Double.NaN
    //ab 4 Kristallen wird zu jeder Tageszeit ein Wachstumsmalus durch Verbrennung dank der Reflektion im Glas verrechnet. Ebenfalls trocknet die Erde schneller aus.
    var anzahlKristalle:Int=0
    //über 5.5 und ab 0.5 und weniger ist schlecht fürs Wachstum, zwischen 2 und 4 ist optimal. Zu jeder Tageszeit verringert sich der Wert um 0.5.
    var feuchtigkeit: Double=0.0
}