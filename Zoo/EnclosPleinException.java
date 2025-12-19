package zoo;

//EnclosPleinException une class a part qui va recuperer l'exception qui a ete envoye par la class enclos pour la traiter ensuite on va la lier a la class

//predefini Exception qui a tout ce dont on a besoin pour que l'exception fonctionne normalement

public class EnclosPleinException extends RuntimeException{

	//le constructeur EnclosPleinExceotion va prendre le string et ensuite il va l'envoyer a la super class Exception qui va faire l'affichage du message envoyer par enclos
	private static final long serialVersionUID = 1L;
	
	public EnclosPleinException(String str) {
		
		super(str);
		
	}
	
}