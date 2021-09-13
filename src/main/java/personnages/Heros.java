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
