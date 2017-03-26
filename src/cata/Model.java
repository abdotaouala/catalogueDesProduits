package cata;

import java.util.*;
import metier.*;
public class Model {

	private String motCle;
	List<Produit> prodsMC=new ArrayList<Produit>();
	private Produit produit=new Produit();
	private String mode="ajout";
	private String errors="0";
	
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
		CatalogueMetier cm=new CatalogueMetier();
		prodsMC=cm.produitsParMc(motCle);
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
		CatalogueMetier mc=new CatalogueMetier();
		mc.addProduit(this.produit);
	}
	
	public void delete(String ref){
		
		try{
			CatalogueMetier cm=new CatalogueMetier();
			cm.deleteProduit(ref);
		}catch(Exception e){
			System.out.println("produit ne pas supprimer !");
		}
		return ;
	}

	public Produit find(String ref) {
		CatalogueMetier cm=new CatalogueMetier();
		Produit p=cm.findProduit(ref);
		return p;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mod) {
		this.mode = mod;
	}

	public void update(Produit produit2) {
		CatalogueMetier cm=new CatalogueMetier();
		cm.updateProduit(produit2);
		
	}
	
}
