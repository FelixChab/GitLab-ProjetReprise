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
        boolean adjacente = false;
        // Si l'autre salle est situé au-dessus, en-dessous, à gauche, à droite, de la salle actuelle.
        if (autre.getX() == getX()+1 || autre.getY() == getX()-1 
         || autre.getX() == getY()+1 || autre.getY() == getY()-1) {
            // On retire les diagonales qui ne sont pas considérées comme adjacentes.
            // compléter avec if() bourrins au cas par cas...
            adjacente = true;
        }
        return adjacente;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salle other = (Salle) obj;
        if (this.salleX != other.salleX) {
            return false;
        }
        if (this.salleY != other.salleY) {
            return false;
        }
        return true;
    }
    
}
