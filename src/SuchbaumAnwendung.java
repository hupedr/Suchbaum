import sum.ereignis.*;
import sum.komponenten.*;

public class SuchbaumAnwendung extends EBAnwendung
{ 
   //Bezugsobjekte
   Knopf hatKnopfBeenden, hatKnopfEinfuegen, hatKnopfSuchen;
   Textfeld hatTextfeldEingabeName, hatTextfeldEingabePunkte;
   Zeilenbereich hatZeilenbereichListe;
   Etikett hatEtikettTestprogrammSuchbaum, hatEtikettBaum, hatEtikettListe, hatEtikettEingabeName, hatEtikettEingabePunkte;
   
   SearchTree hatTestbaum;
   Baumdarsteller hatBaumdarsteller;
   
   public SuchbaumAnwendung() //Konstruktor
   {
      super(1200, 500);
      hatEtikettTestprogrammSuchbaum = new Etikett(350, 36, 170, 25, "Testprogramm Suchbaum");
      hatEtikettTestprogrammSuchbaum.setzeAusrichtung(Ausrichtung.LINKS);
      hatEtikettEingabeName = new Etikett(7, 80, 100, 25, "Name");
      hatEtikettEingabeName.setzeAusrichtung(Ausrichtung.LINKS);
      hatTextfeldEingabeName = new Textfeld(7, 105, 110, 25, "");
      hatEtikettEingabePunkte = new Etikett(7, 135, 100, 25, "Punkte");
      hatEtikettEingabePunkte.setzeAusrichtung(Ausrichtung.LINKS);
      hatTextfeldEingabePunkte = new Textfeld(7, 160, 110, 25, "");
      hatKnopfBeenden = new Knopf(7, 330, 90, 30, "Beenden");
      hatKnopfBeenden.setzeBearbeiterGeklickt("beenden");
      hatKnopfEinfuegen = new Knopf(7, 200, 90, 30, "Einf\u00FCgen");
      hatKnopfEinfuegen.setzeBearbeiterGeklickt("fuegeSchuelerEin");
      hatKnopfEinfuegen = new Knopf(7, 245, 90, 30, "Suchen");
      hatKnopfEinfuegen.setzeBearbeiterGeklickt("sucheSchueler");
      hatEtikettListe = new Etikett(126, 80, 80, 25, "Liste");
      hatEtikettListe.setzeAusrichtung(Ausrichtung.LINKS);
      hatZeilenbereichListe = new Zeilenbereich(126, 104, 200, 363, "Der Baum als Liste");
      hatEtikettBaum = new Etikett(350, 79, 40, 25, "Baum");
      hatEtikettBaum.setzeAusrichtung(Ausrichtung.LINKS);
      
      hatTestbaum = new SearchTree();
      hatBaumdarsteller = new Baumdarsteller();
   }

    public void fuegeSchuelerEin()
    {
        if (hatTextfeldEingabePunkte.inhaltIstGanzeZahl())
        {
            hatTestbaum.insert(new Schueler(hatTextfeldEingabeName.inhaltAlsText(), hatTextfeldEingabePunkte.inhaltAlsGanzeZahl()));
            hatBaumdarsteller.zeige(hatTestbaum, 350, 1150, 110, 462);
            hatZeilenbereichListe.setzeInhalt(hatTestbaum.toString());
        }
        else
            hatTextfeldEingabePunkte.setzeInhalt("Ganzzahl!");
   }
   
   public void sucheSchueler()
   {
        Schueler lSuchSchueler;
        lSuchSchueler = (Schueler) hatTestbaum.search(new Schueler(hatTextfeldEingabeName.inhaltAlsText(), 0));
        if (lSuchSchueler == null)
            hatTextfeldEingabePunkte.setzeInhalt("kenne ich nicht");
        else
            hatTextfeldEingabePunkte.setzeInhalt(lSuchSchueler.punktzahl());

    }
    
}