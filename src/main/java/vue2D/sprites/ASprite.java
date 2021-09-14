package vue2D.sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ISalle;
import personnages.IPersonnage;

/**
 * Classe abstraite ASprite
 * @author fchabellard
 */
public abstract class ASprite implements ISprite {
    
    public IPersonnage spritePerso;
    public int spriteX, spriteY;
    // Sprites du héros (pour chaque direction)
    public Image imageHeroL = new Image("file:icons/link/LinkRunShieldL1.gif");
    public Image imageHeroR = new Image("file:icons/link/LinkRunR1.gif");
    public Image imageHeroU = new Image("file:icons/link/LinkRunU1.gif");
    public Image imageHeroD = new Image("file:icons/link/LinkRunShieldD1.gif");
    // Sprite des monstres
    public Image imageMonstre = new Image("file:icons/monstre0.gif");
    
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
        // Utilisée dans HeroSprite & MonstreSprite
    }
    
    @Override
    public void setCoordonnees(int xpix, int ypix) {
        this.spriteX = xpix;
        this.spriteY = ypix;
    }
    
    @Override
    public ISalle getPosition() {
        return spritePerso.getPosition();
    }
    
    @Override
    public void setPosition(ISalle s) {
        spritePerso.setPosition(s);
        spriteX = s.getX();
        spriteY = s.getY();
    }
    
}
