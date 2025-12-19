// Fichier: Reptile.java
package zoo;

import java.time.LocalDate;

class Reptile extends Animal implements Herbivore { 

    private boolean venimeux; 

  
    public Reptile(String nom, LocalDate dateNaissance, boolean estVenimeux) {
   
        super(nom, dateNaissance);
        
        this.venimeux = estVenimeux; 
    }
    @Override
    public void brouter() {
        System.out.println(getNom() + " (Reptile) broute tranquillement la végétation.");
    }

    public boolean isVenimeux() {
        return venimeux;
    }
    public void setVenimeux(boolean venimeux) {
        this.venimeux = venimeux;
    }
    @Override
    public void crier() {
        System.out.println(getNom() + " pousse un cri de Reptile.");
    }
    @Override
    public void manger(){
        System.out.println(getNom() + " Mange (Reptile) ");
    };
    
    
    @Override
  public void afficherInfos() {
        System.out.println("=== Reptile ===");
        System.out.println("ID: " + getId());
        System.out.println("Nom: " + getNom());
        System.out.println("Venimeux: " + (venimeux ? "Oui" : "Non"));
        System.out.println("Âge: " + calculAge() + " ans");
        System.out.println("Né le: " + getDateNaissance());
    }
}