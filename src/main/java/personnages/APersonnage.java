package personnages;

import java.util.Collection;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import personnages.APersonnage;

/**
 * Classe abstraite Personnage
 * @author fchabellard
 */
public abstract class APersonnage implements IPersonnage {
    
    public static int posX, posY;
    public ISalle position;
    
    public APersonnage(int x, int y) {
        APersonnage.posX = x;
        APersonnage.posY = y;
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
    
    /**
     * Méthode "override" qui permet au héros de choisir où aller.
     * @param sallesAccessibles la collection des salles qui lui sont accessibles.
     * @return null, rien dans cette classe (voir la classe Heros).
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return null;
    }
    
    /**
     * Méthode "override" qui renvoie la position du héros.
     * @return la position (X,Y) du héros.
     */
    @Override
    public ISalle getPosition() {
        this.position = new Salle(getPosX(), getPosY());
        return position;
    }
    
    /**
     * Méthode "override" qui définit la position du héros, pour se déplacer.
     * @param s la salle où le héros se déplace.
     */
    @Override
    public void setPosition(ISalle s) {
        APersonnage.posX = s.getX();
        APersonnage.posY = s.getY();
    }
    
}
