package zoo;

import java.util.Scanner;
import java.util.HashMap;

public class Zoo {
    private Scanner sc = new Scanner(System.in);
    

    private HashMap<String, Enclos> enclos;

    public Zoo() {
        this.enclos = new HashMap<>();
    }

    // --- GETTERS ---
    public HashMap<String, Enclos> getEnclos() {
        return enclos;
    }

    public int getNombreEnclos() {
        return enclos.size();
    }

    // --- GESTION DES ENCLOS ---

    public void ajouterEnclos(Enclos e) {
        if (e != null) {
            enclos.put(e.getNom(), e);
            System.out.println("Enclos ajouté : " + e.getNom());
        }
    }

    // Version interactive mte3ek (ndhifa)
    public void ajouterEnclos() {
        String nom;
        do {
            System.out.print("\nDonner le nom d'Enclos (nom UNIQUE !) : ");
            nom = sc.nextLine();
        } while (existe_nom_enclos(nom));

        // Paramètres par défaut kima fil code mte3ek
        Enclos e = new Enclos(nom, 10, 10.0, "Inconnue");
        enclos.put(e.getNom(), e);
        System.out.println("L'enclos '" + e.getNom() + "' a été ajouté au Zoo.");
    }

    public boolean existe_nom_enclos(String test_nom) {
        // Testa3mel containsKey: asra3 b barcha mel boucle for
        return enclos.containsKey(test_nom);
    }

    public boolean aDesEnclos() {
        return !enclos.isEmpty();
    }

    // --- GESTION DES ANIMAUX ---

    public void ajouterAnimalAEnclos(Animal a, String nomEnclos) {
        Enclos e = enclos.get(nomEnclos);
        if (e != null) {
            try {
                // Lezem try-catch khater ajouterAnimal t-lansi EnclosPleinException
                e.ajouterAnimal(a);
            } catch (EnclosPleinException ex) {
                System.out.println("Erreur : " + ex.getMessage());
            }
        } else {
            System.out.println("Erreur : L'enclos '" + nomEnclos + "' est introuvable.");
        }
    }

    public void supprimerAnimal(int idAnimal) throws AnimalNonTrouveException {
        boolean trouve = false;
        for (Enclos e : enclos.values()) {
            Animal animal = e.rechercherAnimalParId(idAnimal);
            if (animal != null) {
                e.enleverAnimal(idAnimal);
                trouve = true;
                System.out.println("Animal ID: " + idAnimal + " supprimé.");
                break;
            }
        }
        if (!trouve) {
            throw new AnimalNonTrouveException("Animal avec ID " + idAnimal + " non trouvé.");
        }
    }

    public void deplacerAnimal(int idAnimal, String nomNouvelEnclos) 
            throws AnimalNonTrouveException, DeplacementImpossibleException {

        Animal animalDeplacer = rechercherAnimal(idAnimal);
        Enclos destEnclos = enclos.get(nomNouvelEnclos);

        if (animalDeplacer == null) {
            throw new AnimalNonTrouveException("Animal ID " + idAnimal + " introuvable.");
        }
        if (destEnclos == null) {
            throw new DeplacementImpossibleException("L'enclos destination n'existe pas.");
        }

        // On cherche l'enclos d'origine
        Enclos sourceEnclos = null;
        for (Enclos e : enclos.values()) {
            if (e.rechercherAnimalParId(idAnimal) != null) {
                sourceEnclos = e;
                break;
            }
        }

        try {
            destEnclos.ajouterAnimal(animalDeplacer);
            sourceEnclos.enleverAnimal(idAnimal);
            System.out.println("SUCCESS : Déplacement terminé.");
        } catch (EnclosPleinException e) {
            throw new DeplacementImpossibleException("L'enclos destination est plein !");
        }
    }

    public Animal rechercherAnimal(int idAnimal) {
        for (Enclos e : enclos.values()) {
            Animal a = e.rechercherAnimalParId(idAnimal);
            if (a != null) return a;
        }
        return null;
    }

    // --- AFFICHAGE ---

    public void afficherEnclos() {
        System.out.println("Liste des enclos :");
        for (Enclos e : enclos.values()) {
            System.out.println("- " + e.getNom() + " (" + e.getAnimaux().size() + "/" + e.getCapaciteMax() + " animaux)");
        }
    }

    public void afficherTousLesAnimaux() {
        System.out.println("--- AFFICHAGE DE TOUS LES ANIMAUX DU ZOO ---");
        for (Enclos e : enclos.values()) {
            System.out.println("\n[ ENCLOS : " + e.getNom() + " ]");
            if (e.getAnimaux().isEmpty()) System.out.println("Vide.");
            for (Animal a : e.getAnimaux()) {
                a.afficherInfos();
            }
        }
    }

    public void afficherTousLesAnimauxSimple() {
        for (Enclos e : enclos.values()) {
            for (Animal a : e.getAnimaux()) {
                System.out.println("ID: " + a.getId() + " - " + a.getNom() + " (" + e.getNom() + ")");
            }
        }
    }
}