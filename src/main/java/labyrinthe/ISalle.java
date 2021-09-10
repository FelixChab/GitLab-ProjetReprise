package labyrinthe;

/**
 * Interface Salle
 * @author INFO Professors team
 */
public interface ISalle {
    
    // Méthode qui renvoie la coordonnée X (abscisse) de la salle.
    public int getX(); 
    
    // Méthode qui renvoie la coordonnée Y (ordonnée) de la salle.
    public int getY(); 
    
    /**
     * Méthode qui renvoie vrai ou faux s'il y a une salle adjacente.
     * @param autre l'autre salle adjacente à la salle "utilisée".
     * @return true s'il y a une salle adjacente, false si le contraire.
     */
    public boolean estAdjacente(ISalle autre); 
    
}
