package cata;

import java.util.*;
import metier.*;
public class Model {

	private String motCle;
	List<Produit> prodsMC=new ArrayList<Produit>();
	private Produit produit=new Produit();
	private String mode="ajout";
	private String errors="0";
	private ICatalogueMetier metier;
	
	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	public String getMotCle() {
		return motCle="";
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public List<Produit> getProdsMC() {
		
		prodsMC=metier.produitsParMc(motCle);
		return prodsMC;
	}

	public void setProdsMC(List<Produit> prodsMC) {
		this.prodsMC = prodsMC;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		
		this.produit = produit;
		metier.addProduit(this.produit);
	}
	
	public void delete(String ref){
		
		try{
			metier.deleteProduit(ref);
		}catch(Exception e){
			System.out.println("produit ne pas supprimer !");
		}
		return ;
	}

	public Produit find(String ref) {
		Produit p=metier.findProduit(ref);
		return p;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mod) {
		this.mode = mod;
	}

	public void update(Produit produit2) {
		metier.updateProduit(produit2);
		
	}

	public ICatalogueMetier getMetier() {
		return metier;
	}

	public void setMetier(ICatalogueMetier metier) {
		this.metier = metier;
	}

	
	
}
