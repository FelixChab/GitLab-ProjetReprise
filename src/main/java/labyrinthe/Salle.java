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
    
    @Override
    public int getX() {
        return salleX;
    }
    
    @Override
    public int getY() {
        return salleY;
    }
    
    ///
    /// A CORRIGER ?
    ///
    @Override
    public boolean estAdjacente(ISalle autre) {
        // Si l'autre salle est situé au-dessus, en-dessous, à gauche, à droite, de la salle actuelle.
        if (autre.getX() == getX()+1 || autre.getX() == getX()-1 
         || autre.getY() == getY()+1 || autre.getY() == getY()-1) {
            // On retire les diagonales qui ne sont pas considérées comme adjacentes.
            if (autre.getX() == getX()+1 && autre.getY() == getY()-1) {
                return false; // Diagonale haut-droite
            }
            if (autre.getX() == getX()+1 && autre.getY() == getY()+1) {
                return false; // Diagonale bas-droite
            }
            if (autre.getX() == getX()-1 && autre.getY() == getY()-1) {
                return false; // Diagonale haut-gauche
            }
            if (autre.getX() == getX()-1 && autre.getY() == getY()+1) {
                return false; // Diagonale bas-gauche
            }
            // Case adjacente et non-diagonale
            return true;
        }
        return false;
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
