package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
* Interface Personnage
* @author INFO Professors team
*/
public interface IPersonnage {
    
    /**
     * Méthode qui permet au héros de choisir où aller.
     * @param sallesAccessibles la collection des salles accessibles.
     * @return la salle choisie.
     */
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles);

    /**
     * Méthode qui renvoie la position courante du personnage.
     * @return la position (X,Y) du personnage.
     */
    public ISalle getPosition();
    
    /**
     * Méthode qui définit la position courante du personnage.
     * @param s la salle où le personnage va se retrouver.
     */
    public void setPosition(ISalle s);
    
}
