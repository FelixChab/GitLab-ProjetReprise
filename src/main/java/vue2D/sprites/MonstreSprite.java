package vue2D.sprites;

import java.util.Collection;
import javafx.scene.canvas.GraphicsContext;
import labyrinthe.ISalle;
import personnages.IPersonnage;
import personnages.Monstre;
import vue2D.javafx.Dessin;

/**
 * Classe MonstreSprite
 * @author fchabellard
 */
public class MonstreSprite extends ASprite {
    
    private final Monstre monstre;
    
    /**
     * Constructeur de la classe HerosSprite qui hérite d'ASprite.
     * @param perso le personnage dont on affiche le sprite.
     */
    public MonstreSprite(IPersonnage perso) {
        super(perso);
        this.monstre = ((Monstre)perso);
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return spritePerso.faitSonChoix(sallesAccessibles);
    }
    
    /**
     * Méthode pour dessiner les Monstres.
     * @param g objet JavaFX.
     */
    @Override
    public void dessiner(GraphicsContext g) {
        g.drawImage(imageMonstre, spriteX*Dessin.unite, spriteY*Dessin.unite, Dessin.unite, Dessin.unite); 
    }
    
}
