package vue2D;

import java.util.Collection;
import vue2D.sprites.ISprite;

/**
* Interface Vue
* @author INFO Professors team
*/
public interface IVue extends Collection<ISprite>{
    
    /**
     * Méthode qui permet d'afficher les salles, murs, sprites, etc...
     */
    public void dessiner();
    
}
