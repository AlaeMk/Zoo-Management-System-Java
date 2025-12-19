package zoo;

import java.time.LocalDate;
import java.time.Period;

public abstract class Animal {
    private static int compteur = 0;
    private int id;
    private String nom;
    private LocalDate dateNaissance;

    public Animal( String nom, LocalDate dateNaissance) {
        this.id = ++compteur;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
    }
   

    public abstract void crier();
    public abstract void manger();
    public abstract void afficherInfos();
    
    
    public int calculAge() {
        return Period.between(dateNaissance, LocalDate.now()).getYears();
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
}
   /* @Override
    public void chasser(){
        System.out.println("\nChasseur ! ");
    }
    @Override
    public void brouter(){
        System.out.println("\nBrouteur ! ");
    }
}*/
