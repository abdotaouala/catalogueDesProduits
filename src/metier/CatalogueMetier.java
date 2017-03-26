package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CatalogueMetier implements ICatalogueMetier {

	private List<Produit> produits=new ArrayList<Produit>();
	private SingletonConnection sing=new SingletonConnection();
	private Connection conx=sing.getConnection();
	@Override
	public void addProduit(Produit p) {
		try{
			PreparedStatement ps=conx.prepareStatement("INSERT INTO PRODUIT(`ref_prod`, `designation`, `prix`, `quntitie`) VALUES (?,?,?,?)");
			ps.setString(1, p.getRef_prod());
			ps.setString(2, p.getDesignation());
			ps.setDouble(3, p.getPrix());
			ps.setInt(4, p.getQuantite());
			ps.executeUpdate();
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		
		
	}

	@Override
	public void deleteProduit(String ref) {
		try{
			PreparedStatement ps=conx.prepareStatement("DELETE FROM PRODUIT WHERE ref_prod=?");
			ps.setString(1, ref);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produit> listeProduits() {
		try{
			PreparedStatement ps=conx.prepareStatement("SELECT * FROM  PRODUIT");
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				Produit p=new Produit();
				p.setRef_prod(rs.getString("ref_prod"));
				p.setPrix(rs.getDouble("prix"));
				p.setDesignation(rs.getString("designation"));
				p.setQuantite(rs.getInt("quntitie"));
				produits.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return produits;
	}


	@Override
	public void updateProduit(Produit p) {
		
		try{
			PreparedStatement ps=conx.prepareStatement("UPDATE PRODUIT SET `designation`=?,`prix`=?,`quntitie`=? WHERE REF_PROD=?");
			
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setString(4, p.getRef_prod());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produit> produitsParMc(String mc) {
		List<Produit> prods=new ArrayList<Produit>();
		try{
			PreparedStatement ps=conx.prepareStatement("SELECT * FROM PRODUIT WHERE DESIGNATION LIKE ? ");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				Produit p=new Produit();
				p.setRef_prod(rs.getString("ref_prod"));
				p.setPrix(rs.getDouble("prix"));
				p.setDesignation(rs.getString("designation"));
				p.setQuantite(rs.getInt("quntitie"));
				prods.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public Produit findProduit(String ref) {
		Produit p=new Produit();
		try{
			PreparedStatement ps=conx.prepareStatement("select * from produit where ref_prod=?");
			ps.setString(1,ref);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
			
				p.setRef_prod(rs.getString("ref_prod"));
				p.setDesignation(rs.getString("designation"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quntitie"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return p;
	}

}
