
package zoo;

import java.util.ArrayList;


public class Enclos {
    private String nom;
    private int capaciteMax;
    private ArrayList<Animal> animaux; 
    private double superficie;
    private String localite;

    public Enclos(String nom, int capaciteMax, double superficie, String localite) {
         this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.superficie = superficie;
        this.localite = localite;
        this.animaux = new ArrayList<>(); 
        EnclosInconnu(); 
    }
    //ctrl de saisie
     private void EnclosInconnu() {
    if (nom == null || nom.length() == 0) {
    nom = "Enclos inconnu";
     }
    if (capaciteMax <= 0) {
        this.capaciteMax = 1; // valeur min
    }
    if (superficie <= 0) {
        this.superficie = 10;
    }
    if (localite == null || localite.isEmpty()) {
        this.localite = "Inconnue";
    }}
 
    public void ajouterAnimal(Animal a) throws EnclosPleinException { 
        if (enclosPlein()) {
           throw new EnclosPleinException("L'enclos " + this.nom + " est plein. Capacité max: " + this.capaciteMax);
        }
        this.animaux.add(a);
        System.out.println("-> " + a.getNom() + " ajouté à l'enclos " + this.nom + ".");
    }

    public boolean enclosPlein() {
        if (animaux.size() >= capaciteMax)
            return true;
        return false; 
    }
    
    public void enleverAnimal(int idAnimal) throws AnimalNonTrouveException { 
        
        Animal animalTrouve = null; //variable pour stocker l animal trouvé
        for (Animal a : animaux) { 
            if (a.getId()==(idAnimal)) {
                animalTrouve = a;
                break;
            }
        }
        
        if (animalTrouve != null) {
            this.animaux.remove(animalTrouve);
            System.out.println("-> " + animalTrouve.getNom() + " retiré de l'enclos " + this.nom + ".");
        } else {

            throw new AnimalNonTrouveException("L'animal avec l'ID " + idAnimal + " n'a pas été trouvé dans l'enclos " + this.nom + ".");
        }
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    public String getNom() {
        return nom;
    }
    public int getCapaciteMax() {
        return capaciteMax;
    }
    public ArrayList<Animal> getAnimaux() {
        return animaux;
    }   
    public double getSuperficie() {
        return superficie;
    }   
    public String getLocalite() {
        return localite;
    }
   public void afficherAnimaux() {
    if (animaux.isEmpty()) {
        System.out.println("Aucun animal dans l'enclos " + this.nom + ".");
        return;
    }
    System.out.println("Animaux dans l'enclos " + this.nom + ":");
    for (Animal a : animaux) {
        System.out.println("- ID: " + a.getId() + " | Nom: " + a.getNom());
    }
}public Animal rechercherAnimalParId(int id) {
    for (Animal animal : animaux) {
        if (animal.getId() == id) {
            return animal;
        }
    }
    return null; // Non trouvé
}

}

