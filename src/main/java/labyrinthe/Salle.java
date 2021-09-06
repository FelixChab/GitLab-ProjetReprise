package labyrinthe;

/**
 * Classe Salle
 * @author fchabellard
 */
public class Salle implements ISalle {
    
    public int salleX, salleY;
    
    /**
     * Constructeur de la classe Salle.
     * @param x coordonnée abcisses de la salle.
     * @param y coordonnée ordonnées de la salle.
     */
    public Salle(int x, int y) {
        this.salleX = x;
        this.salleY = y;
    }
    
    /**
     * Méthode "override" qui renvoie l'abcisse de la salle.
     * @return salleX coordonnée abcisses de la salle.
     */
    @Override
    public int getX() {
        return salleX;
    }
    
    /**
     * Méthode "override" qui renvoie l'ordonnée de la salle.
     * @return salleY coordonnée ordonnées de la salle.
     */
    @Override
    public int getY() {
        return salleY;
    }
    
    /**
     * Méthode qui renvoi vrai ou faux s'il y a une salle adjacente.
     * @param autre l'autre salle adjacente à la salle "utilisée".
     * @return true s'il y a une salle adjacente, false si le contraire.
     */
    @Override
    public boolean estAdjacente(ISalle autre) {
        // à ce stade, on considère qu'une salle n'est jamais adjacente à une autre
        return false; 
    }
    
}
