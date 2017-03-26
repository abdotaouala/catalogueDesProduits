<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalogue des produits </title>
<script type="text/javascript">
	function confirmer(link) {
		var supp=confirm("vous voullez supprimmer ce produit !");
		if(supp==true){
			document.location = link;
		}
	}
</script>
</head>
<body>
<div>
<h3>Rechercher un Produit</h3>
<form action="Chercher.php" method="post">
	<table>
		<tr>
			<td>Designation </td>
			<td><input type="search" class="form-control" placeholder="Entrer un mot clef" name="motcle" value="${model.motCle }"  /></td>
		</tr>
		<tr>
			<td><input type="submit" name="action" class="btn btn-default" value="rechercher" /></td>
		</tr>
	</table>
</form>
<table>
</table>
</div>

<div>
<c:if test="${model.mode=='ajout'}">
	<h3>Ajout Produit</h3> 
</c:if>
<c:if test="${model.mode!='ajout'}">
	<h3>Modifier Produit</h3> 
</c:if>
	<c:if test="${model.errors!='0'}">
	<div class="panel panel-danger">${model.errors}</div>
	</c:if>
	
	<form action="Ajouter.php" method="post">
	<input type="hidden" name="mode" value="${model.mode}" />
	<c:if test="${model.mode=='ajout'}">
	<div class="form-group">
    		<label for="ref">Reference </label>
    		<input type="text" class="form-control" name="ref_prod" id="ref" placeholder="Reference" value="${model.produit.ref_prod }">
  		</div>
</c:if>
<c:if test="${model.mode!='ajout'}">
	<div class="form-group">
    		<label for="ref">Reference </label> : ${model.produit.ref_prod }
    		<input type="hidden" class="form-control" name="ref_prod" id="ref" placeholder="Reference" value="${model.produit.ref_prod }">
  		</div> 
</c:if>
		
  		<div class="form-group">
    		<label for="designation">D esignation </label>
    		<input type="text" class="form-control" id="designation" name="designation" placeholder="Desgnation" value="${model.produit.designation }">
  		</div>
  		<div class="form-group">
    		<label for="prix">Prix </label>
    		<input type="text" class="form-control" name="prix" id="prix" placeholder="Prix" value="${model.produit.prix }">
  		</div>
  		<div class="form-group">
    		<label for="quantite">Quantite </label>
    		<input type="number" class="form-control" name="quantite" id="quantite" placeholder="Quantite" value="${model.produit.quantite }">
  		</div>
  		<input type="submit" name="action" value="save" class="btn btn-default"  />
	</form>
</div>
<div>
<table class="table table-hover">
<thead>
<tr>
<th>REF</th>
<th>DESEGNATION</th>
<th>QUNTITE</th>
<th>PRIX</th>
</tr>
</thead>
<tbody>
<c:forEach var="produit" items="${model.prodsMC}">
	<tr>
		<td>${produit.ref_prod }<td>
		<td>${produit.designation }<td>
		<td>${produit.quantite }<td>
		<td>${produit.prix }<td>
		<td><a href="javascript:confirmer('supprimer.php?action=delete&ref=${produit.ref_prod }')">Supprimer</a><td>
		<td><a href="modifier.php?action=update&ref=${produit.ref_prod }">Modifier</a></td>
	</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>