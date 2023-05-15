package metroparisien;

import java.util.ArrayList;
import java.util.List;

public class Ligne {
    private String nom;
    private List<Voie> voies;
    
    
	public Ligne(String nom, List<Voie> voiesLigne1) {
		super();
		this.nom = nom;
		this.voies = voiesLigne1;
	}
	
	

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Voie> getVoies() {
		return voies;
	}
	public void setVoies(ArrayList<Voie> voies) {
		this.voies = voies;
	}
	
	



	

    
   
}
