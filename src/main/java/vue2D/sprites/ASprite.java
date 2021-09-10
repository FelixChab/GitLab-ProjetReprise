package vue2D.sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import personnages.IPersonnage;

/**
 * Classe abstraite ASprite
 * @author fchabellard
 */
public abstract class ASprite implements ISprite {
    
    public IPersonnage spritePerso;
    public int spriteX, spriteY;
    public Image image = new Image("file:icons/link/LinkRunShieldL1.gif");
    
    /**
     * Constructeur de la classe abstraite ASprite.
     * @param x coordonnée sur l'axe des abscisse du sprite.
     * @param y coordonnée sur l'axe des ordonnées du sprite.
     * @param perso l'image du sprite du personnage.
     */
    public ASprite(int x, int y, IPersonnage perso) {
        this.spriteX = x;
        this.spriteY = y;
        this.spritePerso = perso;
    }
    
    @Override
    public void dessiner(GraphicsContext g) {
        g.drawImage(image, spriteX, spriteX);
    }
    
    @Override
    public void setCoordonnees(int xpix, int ypix) {
        this.spriteX = xpix;
        this.spriteY = ypix;
    }
    
}
