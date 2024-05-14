
public class SearchTree<ContentType extends ComparableContent<ContentType>>
{

    BinaryTree<ContentType> kenntBinaryTree;
    
	/**
	 * Ein leerer Suchbaum wurde erzeugt.
	 */
	public SearchTree()
	{
	   kenntBinaryTree = new BinaryTree();
	}

	/**
	 * Ein Suchbaum wurde mit dem angegebenen Bin&auml;rbaum erzeugt.
	 */
	private SearchTree(BinaryTree<ContentType> pBinaerbaum)
	{
	   kenntBinaryTree = pBinaerbaum;
	}

	/**
	 * Der linke Teilbaum des Suchbaums wurde geliefert.
	 */
    public SearchTree<ContentType> getLeftTree()
    {
        return new SearchTree(kenntBinaryTree.getLeftTree());
    }   
	   
	/**
	 * Der rechte Teilbaum des Suchbaums wurde geliefert.
	 */
    public SearchTree<ContentType> getRightTree()
    {
        return new SearchTree(kenntBinaryTree.getRightTree());
    }	   
	   
	/**
     * Der Inhalt der Wurzel wurde als Item geliefert.
     */
    public ContentType getContent()
    {
        return kenntBinaryTree.getContent();
    }
    
	/**
	 * Es wurde geliefert, ob der Suchbaum leer ist.
	 */
    public boolean isEmpty()
    {
        return kenntBinaryTree.isEmpty();
    }
    
    /**
     * Das angegebene Item wurde eingef&uuml;gt, wenn ein Item mit diesem Schl&uuml;ssel noch nicht im Baum war.
     */
    public void insert(ContentType pInhalt)
    {
       // Eure Aufgabe
       if(isEmpty()) {
           kenntBinaryTree.setContent(pInhalt);
       } else if(getContent().isGreater(pInhalt)) {
           getLeftTree().insert(pInhalt);
       } else {
           getRightTree().insert(pInhalt);
       }
    }
  
    /**
     * Der Inhalt des Suchbaums wurde in Form einer sortierten Liste geliefert.
     */
    public List<ContentType> sortierteListe()
    {
        // Die Inhalte des SearchTrees pSearchTree werden rekursiv geordnet in eine Liste kopiert
        // Achtung: Die rekursive Methode ergaenzeListe wird fuer den Aufbau der Liste aufgerufen
        List lSortierteListe = new List();
        this.ergaenzeListe(lSortierteListe);
        return lSortierteListe;
    }

    private void ergaenzeListe(List<ContentType> pListe)
    {
       if(!isEmpty()) {
           getLeftTree().ergaenzeListe(pListe);
           pListe.append(getContent());
           getRightTree().ergaenzeListe(pListe);
       }
    }
   
    /**
     * Wenn ein Item mit dem Schl&uuml;ssel von pSuchobjekt im SearchTree vorhanden war, wurde es geliefert, sonst null.
     */
    public ContentType search(ContentType pSuchobjekt)
    {
        if(isEmpty()) {
            return null;
        } else if(getContent().isEqual(pSuchobjekt)) {
            return getContent();
        } else if(getContent().isGreater(pSuchobjekt)) {
            return getLeftTree().search(pSuchobjekt);
        } else {
            return getRightTree().search(pSuchobjekt);
        }
    }
    
     /**
     * Der Inhalt des Suchbaums wurde sortiert in Form einer Zeichenkette geliefert.
     */
    public String toString()
    {
        List lSortierteListe = this.sortierteListe();
        String lBaumAlsText = "";
        lSortierteListe.toFirst();
        while (lSortierteListe.hasAccess())
        {
            lBaumAlsText = lBaumAlsText + lSortierteListe.getContent().toString() + "\n";
            lSortierteListe.next();
        }
        return lBaumAlsText;
    }
    
}

