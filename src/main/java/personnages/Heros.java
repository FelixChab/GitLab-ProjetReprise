package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 * Classe Héros
 * @author fchabellard
 */
public class Heros extends APersonnage {
    
    public ISalle salleChoisie;
    
    public Heros(int x, int y) {
        super(x, y);
    }
    
    /**
     * Méthode "override" qui permet au héros de choisir où aller.
     * @param sallesAccessibles la collection des salles qui lui sont accessibles.
     * @return salleChoisie, le choix du héros parmis les salles disponibles.
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (sallesAccessibles.contains(salleChoisie)) {
            return salleChoisie;
        }
        else {
            return position;
        }
    }
    
}
