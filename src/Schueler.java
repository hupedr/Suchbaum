import sum.werkzeuge.*;

/**
 * Ein Sch&uuml;ler verwaltet als Daten seinen Namen und seine Punktzahl.
 * @author Horst Hildebrecht
 * @version 1.2
 */
public class Schueler implements ComparableContent<Schueler>
{
    // Attribute
    String zName;
    int zPunkte;
    
    // Konstruktor
    /**
     * nachher: Der Sch&uuml;ler wurde mit zuf&auml;lligem Namen und zuf&auml;lliger Punktzahl initialisiert.
     */
    public Schueler()
    {
        zName = this.zufallsgriff("BDFGHJKLMNPRSTVWZ") + this.zufallsgriff("aeiou") + this.zufallsgriff("dfghklmnprstxz") + this.zufallsendung();
        Rechner lRechner = new Rechner();
        zPunkte = lRechner.ganzeZufallszahl(300, 1200);
    }

    /**
     * nachher: Der Sch&uuml;ler wurde mit den angegebenen Daten initialisiert.
     */
    public Schueler(String pName, int pPunkte)
    {
        zName = pName;
        zPunkte = pPunkte;
    }

    // Dienste
    /**
     * nachher: Der Name des Sch&uuml;lers wurde geliefert.
     */
    public String name()
    {
        return zName;
    }
    
    /**
     * nachher: Die Punktzahl des Sch&uuml;lers wurde geliefert.
     */
    public int punktzahl()
    {
        return zPunkte;        
    }
    
    /**
     * nachher: Die Daten des Sch&uuml;lers wurden als Zeichenkette geliefert.
     */
    public String toString()
    {
        return zName + " (" + zPunkte + ")";
    }
        
    private String zufallsgriff(String moeglicheZeichen)
    {
        Textwerkzeug lTextwerkzeug = new Textwerkzeug();
        Rechner lRechner = new Rechner();
        return lTextwerkzeug.zeichenAn(moeglicheZeichen, lRechner.ganzeZufallszahl(1,lTextwerkzeug.laenge(moeglicheZeichen))) + "";
        // Umwandlung in String mit Trick, weil es sonst Probleme beim Zusammenkleben gibt
    }
    
    private String zufallsendung()
    {
        Rechner lRechner = new Rechner();
        switch (lRechner.ganzeZufallszahl(1,5))
        {
            case 1: return "meier";
            case 2: return "m\u00fcller";
            case 3: return "schulze";
            case 4: return "mann";
            case 5: return "hausen";
        }
        return "";
    }    

    public boolean isEqual(Schueler pObjekt)
    {
        Schueler lSchueler = (Schueler) pObjekt;
        Textwerkzeug lTextwerkzeug = new Textwerkzeug();
        return lTextwerkzeug.istGleich(zName, lSchueler.name());
    }
    
    public boolean isLess(Schueler pObjekt)
    {
        Schueler lSchueler = (Schueler) pObjekt;
        Textwerkzeug lTextwerkzeug = new Textwerkzeug();
        return lTextwerkzeug.istKleiner(zName, lSchueler.name());
    }
    
    public boolean isGreater(Schueler pObjekt)
    {
        Schueler lSchueler = (Schueler) pObjekt;
        Textwerkzeug lTextwerkzeug = new Textwerkzeug();
        return lTextwerkzeug.istGroesser(zName, lSchueler.name());
    }
    
}
