package metier;

import java.util.List;

public interface ICatalogueMetier {

	public void addProduit(Produit p);
	public void deleteProduit(String ref);
	public List<Produit> listeProduits();
	public void updateProduit(Produit p);
	public List<Produit> produitsParMc(String mc);
	public Produit findProduit(String ref);
}
