package vue2D.sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import personnages.IPersonnage;
import vue2D.javafx.Dessin;

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
     * @param perso l'image du sprite du personnage.
     */
    public ASprite(IPersonnage perso) {
        this.spriteX = perso.getPosition().getX();
        this.spriteY = perso.getPosition().getY();
        this.spritePerso = perso;
    }
    
    @Override
    public void dessiner(GraphicsContext g) {
        g.drawImage(image, spriteX*Dessin.unite, spriteY*Dessin.unite, Dessin.unite, Dessin.unite);
    }
    
    @Override
    public void setCoordonnees(int xpix, int ypix) {
        this.spriteX = xpix;
        this.spriteY = ypix;
    }
    
}
