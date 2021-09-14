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
    /**
     * Méthode qui permet de vérifier si une salle est adjacente ou non.
     * @param autre la salle dont on vérifie l'état (adjacente ou non).
     * @return true si la salle est adjacente.
     */
    @Override
    public boolean estAdjacente(ISalle autre) {
        if ((autre.getX() == getX()) && (autre.getY() == getY()+1 || autre.getY() == getY()-1)) {
            return true;
        }
        if ((autre.getY() == getY()) && (autre.getX() == getX()+1 || autre.getX() == getX()-1)) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int hash = 10;
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
