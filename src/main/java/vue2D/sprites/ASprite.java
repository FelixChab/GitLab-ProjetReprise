package vue2D.sprites;

import javafx.scene.canvas.GraphicsContext;
import personnages.IPersonnage;

/**
 * Classe abstraite ASprite
 * @author fchabellard
 */
public abstract class ASprite implements ISprite {
    
    public IPersonnage spritePerso;
    // Attributs coordonnées graphiques perso
    
    @Override
    public void dessiner(GraphicsContext g) {
        // ...
    }
    
    @Override
    public void setCoordonnees(int xpix, int ypix) {
        // ...
    }
    
}
