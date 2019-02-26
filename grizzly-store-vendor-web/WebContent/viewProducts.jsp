<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="addProductQuantity">
<table>
<tr>
<th>         </th><th>Product Name</th><th>Enter Id</th><th>Brand</th><th>Product Category</th><th>Quantity</th>
</tr>
<c:forEach items="${productList}" var="product" varStatus="status">

<tr>
<td><input type="radio" name="productSelect" value="${status.count}"/></td>

<td><input type="text" name="productName${status.count}" value="${product.productName}" readonly/></td>


<td><input type="text" name="vendorId${status.count}"/></td>

<td><input type="text" name="productBrand${status.count}" value="${product.brand}" readonly/></td>


<td><input type="text" name="productCategory${status.count}" value="${product.productCategory}" readonly/></td>


<td><input type="text" name="quantity${status.count}"/></td>


</tr>

</c:forEach>
<tr>
<td><input type="submit" value="Add Product"/></td>
</tr>
</table>

</form>
${status}
</body>
</html>