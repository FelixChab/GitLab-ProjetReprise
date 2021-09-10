package labyrinthe;

import java.io.IOException;
import java.util.Collection;
import personnages.IPersonnage;

/**
 * Interface Labyrinthe
 * @author INFO Professors team
 */
public interface ILabyrinthe extends Collection<ISalle> {

    /**
     * Méthode qui créer le labyrinthe à partir des fichiers "labys".
     * @param file le fichier de labyrinthe.
     * @throws IOException une exception.
     */
    public void creerLabyrinthe(String file) throws IOException; 

    /**
     * Méthode qui renvoie une collection des salles accessibles au héros.
     * @param heros le héros (joueur).
     * @return une collection de salles.
     */
    public Collection<ISalle> sallesAccessibles(IPersonnage heros); 

    /**
     * Méthode qui renvoie l'entrée du labyrinthe.
     * @return l'entrée.
     */
    public ISalle getEntree(); 

    /**
     * Méthode qui renvoie la sortie du labyrinthe.
     * @return la sortie.
     */
    public ISalle getSortie(); 

    // Un plus court chemin entre u et v
    public Collection<ISalle> chemin(ISalle u, ISalle v); 

    // Dimensions grille
    public int getLargeur();
    public int getHauteur();
}
