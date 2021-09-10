package personnages;

import java.util.Collection;
import labyrinthe.ISalle;
import labyrinthe.Salle;

/**
 * Classe abstraite Personnage
 * @author fchabellard
 */
public abstract class APersonnage implements IPersonnage {
    
    public int posX, posY;
    public ISalle position;
    
    public APersonnage(int x, int y) {
        this.posX = x;
        this.posY = y;
    }
    
    /**
     * Méthode qui donne la position X du héros.
     * @return posX sa coordonnée sur l'axe des abscisses.
     */
    public int getPosX() {
        return posX;
    }
    
    /**
     * Méthode qui donne la position Y du héros.
     * @return posY sa coordonnée sur l'axe des abscisses.
     */
    public int getPosY() {
        return posY;
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return null;
    }
    
    @Override
    public ISalle getPosition() {
        this.position = new Salle(getPosX(), getPosY());
        return position;
    }
    
    @Override
    public void setPosition(ISalle s) {
        this.posX = s.getX();
        this.posY = s.getY();
    }
    
}
