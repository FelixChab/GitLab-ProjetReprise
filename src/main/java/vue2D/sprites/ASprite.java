package vue2D.sprites;

import java.util.Collection;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ISalle;
import personnages.IPersonnage;
import vue2D.javafx.Dessin;

/**
 * Classe abstraite ASprite
 * @author fchabellard
 */
public abstract class ASprite implements ISprite {
    
    public IPersonnage perso;
    public float spriteX, spriteY;
    // Sprites des personnages
    public Image imagePerso;
    
    /**
     * Constructeur de la classe abstraite ASprite.
     * @param perso l'image du sprite du personnage.
     */
    public ASprite(IPersonnage perso) {
        this.spriteX = perso.getPosition().getX();
        this.spriteY = perso.getPosition().getY();
        this.perso = perso;
    }
    
    @Override
    public void dessiner(GraphicsContext g) {
        // Utilisée dans HeroSprite & MonstreSprite
        spriteX = lerp(spriteX, perso.getPosition().getX());
        spriteY = lerp(spriteY, perso.getPosition().getY());
        g.drawImage(imagePerso, spriteX*Dessin.UNITE, spriteY*Dessin.UNITE, Dessin.UNITE, Dessin.UNITE);
    }
    
    @Override
    public void setCoordonnees(int xpix, int ypix) {
        this.spriteX = xpix;
        this.spriteY = ypix;
    }
    
    @Override
    public ISalle getPosition() {
        return perso.getPosition();
    }
    
    @Override
    public void setPosition(ISalle s) {
        perso.setPosition(s);
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return perso.faitSonChoix(sallesAccessibles);
    }
    
    private float lerp(float posSprite, float posDest) {
        float perCent = 0.1f;
        return posSprite + perCent * (posDest - posSprite);
    }
    
}
