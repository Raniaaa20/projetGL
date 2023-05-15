package metroparisien;


public class Station {
    private String nom;
    int tempsArret;
    boolean accident;
    
    
    //Constructeur
	public Station(String nom, int tempsArret, boolean accident) {
		super();
		this.nom = nom;
		this.tempsArret = tempsArret;
		this.accident = accident;
		
	}
	
	//Getters et setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public boolean isAccident() {
		return accident;
	}
	
	public void setAccident(boolean accident) {
		this.accident = accident;
	}
	public int getTempsArret() {
		return tempsArret;
	}
	public void setTempsArret(int tempsArret) {
		this.tempsArret = tempsArret;
	}
    

    
    
}
