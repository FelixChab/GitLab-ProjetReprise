package vue2D.sprites;

import javafx.scene.canvas.GraphicsContext;
import personnages.IPersonnage;

/**
*
* @author INFO Professors team
*/
public interface ISprite extends IPersonnage{
    
    /**
     * Méthode pour afficher le sprite d'un personnage en fonction de sa localisation.
     * @param g appel de la "toile" pour le dessin.
     */
    public void dessiner(GraphicsContext g);
    
    /**
     * Méthode pour définir les coordonnées des sprites.
     * @param xpix coordonnée sur l'axe des abscisses du sprite.
     * @param ypix coordonnée sur l'axe des ordonnées du sprite.
     */
    public void setCoordonnees(int xpix, int ypix);
        
}
