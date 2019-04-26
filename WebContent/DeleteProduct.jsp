<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cogni.smart_shop.bean.*"%>
<%@page import="java.util.List"%>
<html>

<head>
    <title>
        Delete Product
    </title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="AddProduct.js"></script>
    <link rel="stylesheet" href="DeleteProduct.css">
    <link href="https://fonts.googleapis.com/css?family=Aladin" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
</head>

<body>
<a href="EditProduct.jsp">Back</a>
<a href="Logout.jsp">Logout</a>
    <table>
        <tr>
            <td>

<form action="DeleteProductServlet" method="post">
<h3>Delete Product</h3>
   
    				<div>
    				<label>Product Name</label>
						<input type="text" name="Product_Name" id="productDLT">
					</div>
					<br>
					<div  class="form-action-buttons">
						<input type="submit" value="Delete Product">
					</div>
                </form>
</td>
</tr>
   </table>
   </body>
</html>
   <!--  <table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Product Image</th>
                <th>Item</th>
                <th>Manufacturing Date</th>
                <th>Location</th>
              
            </tr>
        </thead>
        <tbody> --> 
        
        <%-- <%
        List<ProductBean> productBeanList=(ArrayList<ProductBean>)session.getAttribute("productBeanList");
        if(productBeanList!= null && productBeanList.size()>0){
        	for(int i=0;i<productBeanList.size();i++){
        		ProductBean productBean=productBeanList.get(i);
        				
        %>
        
        
            <tr>
                <td><%=productBean.getProduct_Name() %></td>
                <td><a href="ViewImageServlet?id=<%=productBean.getProduct_Name()%>" >Show Image</a></td>
                <td><%=productBean.getItem() %></td>
                <td><%=productBean.getDom() %></td>
                <td><%=productBean.getDoe() %></td>
               
            </tr>
            
            <%} }%>
            
        </tbody>
    </table>
    
     --%>
	

<!-- <script>
$(document).ready(function() {
    $('#example').DataTable();
} );

</script> -->
