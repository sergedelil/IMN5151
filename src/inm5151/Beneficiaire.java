/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

/**
 *
 * @author sergedelil
 */
public class Beneficiaire {
    
    private String nom;
    private String prenom;
    private Client client;
    private HistRemb historiqRemb;
    
    public Beneficiaire(){}
    
    public Beneficiaire(String nom, String prenom,Client client, HistRemb historiqRemb ){
        
        this.nom = nom;
        this.prenom = prenom;
        this.client = client;
        this.historiqRemb = historiqRemb;
    
    }
    
    
    
    public boolean validerNom(){
        
        return (nom != null && nom.matches("^[A-Z][a-z]{2,}$"));
    }
    
    public boolean validerPrenom(){
        
        return (prenom != null && prenom.matches("^[A-Z][a-z]{2,}"));
    }
    
    public boolean equals(Beneficiaire unAutreBeneficiaire) {

	// Si les 2 objets sont identiques, on doit retourner
	// vrai comme rÈsultat.
	if (this == unAutreBeneficiaire) {
            return true;
	}

	// Si unAutreBeneficiaire vaut null, on doit retourner
	// faux comme rÈsultat.
	if (unAutreBeneficiaire == null) {
            return false;
	}

	// Si les 2 objets (this, unAutreBeneficiaire) ne sont pas de même
	// classe, ils ne peuvent pas Ítre Ègaux, on doit retourner
	// faux comme rÈsultat.
	if (this.getClass() != unAutreBeneficiaire.getClass()) {
            return false;
	}

        // Sachant que unAutreBeneficiaire n'est pas null et que unAutreBeneficiaire
	// et l'objet courant sont de même type, on peut se permettre
	// la conversion de UnAutreObjet en ElementT
	//ElementT elt = (ElementT) unAutreBeneficiaire;

	// Tester si les attributs ont les mêmes valeurs sauf historiqRemb.
        return (this.nom.equals(unAutreBeneficiaire.nom) && this.prenom.equals(unAutreBeneficiaire.prenom)
                && this.client.equals(unAutreBeneficiaire.client));

	}	

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the historiqRemb
     */
    public HistRemb getHistoriqRemb() {
        return historiqRemb;
    }

    /**
     * @param historiqRemb the historiqRemb to set
     */
    public void setHistoriqRemb(HistRemb historiqRemb) {
        this.historiqRemb = historiqRemb;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }
    
}
