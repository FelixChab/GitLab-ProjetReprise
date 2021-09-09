package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
* Interface Personnage
* @author INFO Professors team
*/
public interface IPersonnage {
    
    // Renvoie une salle parmi sallesAccesibles
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles);

    // Renvoie sa position courante
    public ISalle getPosition();
    
    // Définit sa position courante
    public void setPosition(ISalle s);
    
}
