// Fichier: Oiseau.java
package zoo;

import java.time.LocalDate;

class Oiseau extends Animal implements Carnivore,Herbivore{ 

    private double envergure; // L'envergure (mesure en mètre, type double)

    // Le constructeur reçoit les attributs de Animal + l'attribut spécifique 'envergure'
    public Oiseau(String nom, LocalDate dateNaissance, double envergure) {

        super( nom, dateNaissance);
        this.envergure = envergure; 
    }
    
    public double getEnvergure() {
        return envergure;
    }

    public void setEnvergure(double envergure) {
        this.envergure = envergure;
    }
    @Override
    public void chasser() {
        System.out.println(getNom() + " (Oiseau) plonge du ciel pour attraper sa proie !");
    }

    // 2. Implementation mte3 Herbivore
    @Override
    public void brouter() {
        System.out.println(getNom() + " (Oiseau) picore des graines et des fruits.");
    }
    
    @Override
    public void crier() {
        System.out.println(getNom() + " pousse un cri de Oiseau.");
    }
    @Override
    public void manger(){
        System.out.println(getNom() + " Mange (Oiseau) ");
    };
    
    @Override
    public void afficherInfos() {
        System.out.println("=== Oiseau ===");
        System.out.println("ID: " + getId());
        System.out.println("Nom: " + getNom());
        System.out.println("Envergure: " + envergure + " m");
        System.out.println("Âge: " + calculAge() + " ans");
        System.out.println("Né le: " + getDateNaissance());
    }
}