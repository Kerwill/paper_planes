package fr.sopra.model.enumerateur;

public enum Niveau {

	Occasionnel(1),
	Normal(2),
	Avancé(3),
	Expert(4);
	
	private int valeur = 0;
	
	Niveau(int valeur) {
		this.valeur = valeur;
	}
  
	public int getValeur() {
		return this.valeur;
	}
}
