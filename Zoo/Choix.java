package zoo;

import java.time.LocalDate;
import java.util.Scanner;

public class Choix {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        Zoo z = new Zoo();
                        
        int choix;
        
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Ajouter un enclos");
            System.out.println("2. Ajouter un animal (avec date de naissance)");
            System.out.println("3. Déplacer un animal");
            System.out.println("4. Supprimer un animal");
            System.out.println("5. Afficher tous les animaux avec âge calculé");
            System.out.println("6. Rechercher un animal par ID");
            System.out.println("7. Quitter l'application");
            System.out.print("Votre choix : ");
            
            try {
                choix = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Erreur : entrez un nombre valide !");
                choix = 0;
                continue;
            }
            
            
            
            switch(choix) {
                case 1:
                    ajouterEnclosMenu(z, input);
                    break;
                case 2:
                	//-----------------------------------------------------------
                    System.out.println("\n=== AJOUTER UN ANIMAL ===");
                    
                    // 1. Demander le type
                    System.out.println("1. Mammifère");
                    System.out.println("2. Oiseau"); 
                    System.out.println("3. Reptile");
                    System.out.print("Votre choix : ");
                    int type = Integer.parseInt(input.nextLine());
                    
                    // 2. Demander les infos communes
                    System.out.print("Nom : ");
                    String nom = input.nextLine();
                    System.out.print("Date de naissance (AAAA-MM-JJ) : ");
    String dateSaisie = input.nextLine(); // Te5ou el String mel user
    LocalDate dateN = LocalDate.parse(dateSaisie);
                    
                    // 3. Créer l'animal (date d'aujourd'hui pour simplifier)
                    Animal animal = null;
                    if (type == 1) {
                        System.out.print("Espèce : ");
                        String espece = input.nextLine();
                        animal = new Mammifere(nom, dateN, espece);
                    } else if (type == 2) {
                        System.out.print("Envergure : ");
                        double envergure = Double.parseDouble(input.nextLine());
                        animal = new Oiseau(nom, dateN, envergure);
                    } else if (type == 3) {
                        System.out.print("Venimeux (oui/non) ? ");
                        boolean venimeux = input.nextLine().equalsIgnoreCase("oui");
                        animal = new Reptile(nom, dateN, venimeux);
                    }
                    
                    // 4. Demander l'enclos
                    System.out.print("Nom de l'enclos : ");
                    String nomEnclos = input.nextLine();
                    
                    // 5. Utiliser la méthode de ton collègue
                    z.ajouterAnimalAEnclos(animal, nomEnclos);
                    //--------------------------------------------------------------------------
                    break;
                case 3:
                    deplacerAnimalMenu(z, input);
                    break;
                case 4:
                	//-------------------------------------------------------------
                	//code modifié
                    System.out.println("\n=== SUPPRIMER UN ANIMAL ===");
                    
                    // Afficher les animaux disponibles
                    System.out.println("Animaux disponibles :");
                    z.afficherTousLesAnimauxSimple();
                    
                    System.out.print("\nID de l'animal à supprimer : ");
                    int id = Integer.parseInt(input.nextLine());
                    
                    try {
                        z.supprimerAnimal(id);
                        System.out.println("Animal supprimé !");
                    } catch (AnimalNonTrouveException e) {
                        System.out.println("Erreur : " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erreur : " + e.getMessage());
                    }
                    //-----------------------------------------------------------
                    break;
                case 5:
                    z.afficherTousLesAnimaux();  // Utilise la méthode existante
                    break;
                case 6:
                	//--------------------------------------------------------------------------------------
                	//code modifié
                    System.out.println("\n=== RECHERCHER UN ANIMAL PAR ID ===");
                    System.out.print("ID de l'animal à rechercher : ");
                    int idRecherche = Integer.parseInt(input.nextLine());
                    
                    Animal animall = z.rechercherAnimal(idRecherche);
                    if (animall != null) {
                        System.out.println("\nANIMAL TROUVÉ :");
                        animall.afficherInfos();
                        System.out.println("Âge : " + animall.calculAge() + " ans");
                    } else {
                        System.out.println("\nAucun animal trouvé avec l'ID " + idRecherche);
                        
                    }
                    //---------------------------------------------------------------------------------------
                    break;
                case 7:
                    System.out.println("Merci d'avoir utilisé notre application !");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
            
        } while (choix != 7);
        
        
        
        input.close();
    }
    
    // -----------------------------------------------------------------
    // CASE 1 : AJOUTER UN ENCLOS
    // -----------------------------------------------------------------
    private static void ajouterEnclosMenu(Zoo z, Scanner input) {
        System.out.println("\n=== AJOUTER UN ENCLOS ===");
        z.ajouterEnclos();  // Utilise la méthode de ton collègue
    }

    // -----------------------------------------------------------------
    // CASE 3 : DÉPLACER UN ANIMAL
    // -----------------------------------------------------------------
    private static void deplacerAnimalMenu(Zoo z, Scanner input) {
        System.out.println("\n=== DÉPLACER UN ANIMAL ===");
        
        // Demander les infos
        System.out.print("ID de l'animal à déplacer : ");
        int id;
        try {
            id = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("ID invalide !");
            return;
        }
        
        System.out.print("Nom du nouvel enclos : ");
        String nouvelEnclos = input.nextLine();
        
        // Utiliser la méthode de ton collègue
        try {
            z.deplacerAnimal(id, nouvelEnclos);
            System.out.println("Animal déplacé !");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
    
}