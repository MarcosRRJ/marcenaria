<html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
Resultado da Busca:

<ul>
<c:forEach var="e" items="${empresas}">
	<li>${e.id}: ${e.nome}</li>	
</c:forEach>

</ul>

</body>
</html>