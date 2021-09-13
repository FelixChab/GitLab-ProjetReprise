package vue2D;

import java.util.concurrent.CopyOnWriteArrayList;
import vue2D.sprites.ISprite;

/**
* Classe abstraite Vue
* @author INFO Professors team
*/
public abstract class AVue extends CopyOnWriteArrayList<ISprite> implements IVue {}
