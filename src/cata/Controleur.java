package cata;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CatalogueMetier;
import metier.ICatalogueMetier;
import metier.Produit;

public class Controleur extends HttpServlet {
	ICatalogueMetier metier;
	Model model;
	@Override
	public void init(ServletConfig config) throws ServletException {
		metier=new CatalogueMetier();
		model=new Model();
		model.setMetier(metier);
		
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//search
		try{
			
		
		String action = request.getParameter("action") !=null ? request.getParameter("action") : "" ;
		if(action.equals("rechercher")){
			String motClef = request.getParameter("motcle");
			model.setMotCle(motClef);
		}
		//Ajouter
		
		else if(action.equals("save"))
		{
			String mode=request.getParameter("mode");
			Produit produit =new Produit();
			String ref=request.getParameter("ref_prod");
			String designation=request.getParameter("designation");
			double prix=Double.parseDouble(request.getParameter("prix"));
			int quantite=Integer.parseInt(request.getParameter("quantite"));
			produit.setRef_prod(ref);
			produit.setDesignation(designation);
			produit.setPrix(prix);
			produit.setQuantite(quantite);
			if(mode.equals("ajout")){
				model.setProduit(produit);
			}else if (mode.equals("edit")){
				model.update(produit);
			}
			
			model.getProdsMC();
		}else if(action.equals("delete")){
			String ref=request.getParameter("ref");
			model.delete(ref);
		}else if(action.equals("update")){
			String ref=request.getParameter("ref");
			model.setProduit(model.find(ref));
			model.setMode("edit");
		}
		}catch(Exception e){
			model.setErrors(e.getMessage());
		}
		request.setAttribute("model", model);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
