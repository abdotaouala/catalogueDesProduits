package metier;

public class Produit {

	private String ref_prod;
	private String designation;
	private double prix;
	private int quantite;
	
	
	public String getRef_prod() {
		return ref_prod;
	}
	public void setRef_prod(String ref_prod) {
		this.ref_prod = ref_prod;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
}
