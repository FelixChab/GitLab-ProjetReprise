package labyrinthe;

/**
 * Interface Salle
 * @author INFO Professors team
 */
public interface ISalle {

    public int getX(); // Abcisse salle

    public int getY(); // Ordonnée salle

    public boolean estAdjacente(ISalle autre);
}
