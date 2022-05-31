<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Modifier un Medecin</title>
</head>
<body>
<div class="container mt-5">
<div class="card-body">
<form action="updateMedecin" method="post">
<div class="form-group">
<label class="control-label">ID Medecin :</label>
<input type="text" name="idProduit" value="${medecin.idMedecin}"
readonly class="form-control"/>
</div>
<div class="form-group">
<label class="control-label">Nom Medecin :</label>
<input type="text" name="nomMedecin" value="${medecin.nomMedecin}"
class="form-control"/>
</div>
<div class="form-group">
<label class="control-label">Spécialite Medecin :</label>
<input type="text" name="specialiteMedecin" value="${medecin.specialiteMedecin}"
class="form-control"/>
</div>
<div class="form-group">
<label class="control-label"> Date naissance :</label>
<fmt:formatDate pattern="yyyy-MM-dd" value="${medecin.dateNaissance}"
var="formatDate" />

<input type="date" name="date" value="${formatDate}" class="form-
control"/>
</div>
<div>

<button type="submit" class="btn btn-primary">Modifier</button>
</div>
</form>
</div>
<br/>
<br/>
<a href="ListeMedecins">Liste Medecins</a>
</div>
</body>
</html>