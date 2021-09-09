package labyrinthe;

import java.io.IOException;
import java.util.Collection;
import personnages.IPersonnage;

/**
 * Interface Labyrinthe
 * @author INFO Professors team
 */
public interface ILabyrinthe extends Collection<ISalle> {

    // Crée le labyrinthe a partir d'un fichier 
    public void creerLabyrinthe(String file) throws IOException; 

    // Renvoie les salles accessibles pour le héros
    public Collection<ISalle> sallesAccessibles(IPersonnage heros); 

    // Accesseur sur l'entrée 
    public ISalle getEntree(); 

    // Accesseur sur la sortie
    public ISalle getSortie(); 

    // Un plus court chemin entre u et v
    public Collection<ISalle> chemin(ISalle u, ISalle v); 

    // Dimensions grille
    public int getLargeur();
    public int getHauteur();
}
