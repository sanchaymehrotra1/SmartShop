<!DOCTYPE html>
<html>
<head>
    <title>
        Update Product
    </title>
    <link href="https://fonts.googleapis.com/css?family=Aladin" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="AddProduct.js"></script>
    <link rel="stylesheet" href="UpdateProduct.css">
</head>
<body>
<a href="EditProduct.jsp">Back</a>
<a href="Logout.jsp">Logout</a>
    <table>
        <tr>
            <td>
        
		<form action="UpdateServlet" method="post">
		<h3>Update Product</h3>
            <div >
                    <label>Product Name</label>
                    <input type="text" name="Product_Name" id="productName">
             </div>
             <br>
             <div>
                    <label>Number of Items</label>
                    <input type="number" name="Item" id="productItems">
              </div>
              <br>
               <div>
                    <input type="submit" value="Update Product">
                </div>
                </form>
			</td>
		</tr>
    </table>
    </body>
</html>
                