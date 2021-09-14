package personnages;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import labyrinthe.ISalle;

/**
 * Classe Monstre
 * @author fchabellard
 */
public class Monstre extends APersonnage {
    
    public ISalle salleChoisie;
    
    public Monstre(int x, int y) {
        super(x, y);
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        Random salleAléatoire = new Random();
        List<ISalle> list = sallesAccessibles.stream().collect(Collectors.toList());
        return list.get(salleAléatoire.nextInt(list.size()));
    }
    
}
