package metier;

public class TestMetier {

	public static void main(String[] args) {
		Produit p=new Produit();
		p.setRef_prod("REF123");
		p.setDesignation("HP taoualaK");
		p.setPrix(12.3782);
		p.setQuantite(2);
		CatalogueMetier cm=new CatalogueMetier();
		for(Produit produit:cm.produitsParMc("LG")){
			System.out.println(produit.getDesignation());
		}
	}
}
