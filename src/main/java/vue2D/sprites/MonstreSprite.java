package vue2D.sprites;

import javafx.scene.image.Image;
import personnages.IPersonnage;

/**
 * Classe MonstreSprite
 * @author fchabellard
 */
public class MonstreSprite extends ASprite {
    
    /**
     * Constructeur de la classe HerosSprite qui hérite d'ASprite.
     * @param perso le personnage dont on affiche le sprite.
     */
    public MonstreSprite(IPersonnage perso) {
        super(perso);
        this.imagePerso = new Image("file:icons/monstre0.gif");
    }
    
}
