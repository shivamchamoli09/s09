<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Product Name</th><th>Vendor Id</th><th>Brand</th><th>Product Category</th><th>Quantity</th>
</tr>
<c:forEach items="${productList}" var="product" varStatus="status">

<tr>

<td><input type="text" name="productName" value="${product.productName}" readonly/></td>


<td><input type="text" name="vendorId" value="${product.vendor.vendorId}"/></td>

<td><input type="text" name="productBrand" value="${product.brand}" readonly/></td>


<td><input type="text" name="productCategory" value="${product.productCategory}" readonly/></td>


<td><input type="text" name="quantity" value="${product.vendor.quantity}"/></td>


</tr>

</c:forEach>

</table>

</body>
</html>