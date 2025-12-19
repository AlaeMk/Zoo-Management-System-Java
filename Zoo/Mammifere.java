package zoo;
import java.time.LocalDate;
class Mammifere extends Animal implements Carnivore { 
    private String espece;
    public Mammifere(String nom, LocalDate dateNaissance, String espece) {
        super( nom, dateNaissance);
        this.espece = espece;
    }
    @Override
    public void chasser() {
        System.out.println(getNom() + " (Mammifère) part à la chasse avec ses griffes !");
    }
    @Override
    public void crier() {
        System.out.println(getNom() + " pousse un cri de mammifère.");
    }
    @Override
    public void manger(){
        System.out.println(getNom() + " Mange ");
    };
    
    @Override
    public void afficherInfos() { 
        System.out.println("=== Mammifere ===");
        System.out.println("ID: " + getId());
        System.out.println("Nom: " + getNom());
        System.out.println("Espece: " + espece);
        System.out.println("Age: " + calculAge() + " ans");
        System.out.println("Ne le: " + getDateNaissance());
    }

    public String getEspece() {
        return espece;
    }
}
