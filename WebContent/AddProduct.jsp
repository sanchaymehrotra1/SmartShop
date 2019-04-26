<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cogni.smart_shop.bean.*"%>
<%@page import="java.util.List"%>
<html>

<head>
<link href="https://fonts.googleapis.com/css?family=Aladin"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<title>Add Product</title>

<link rel="stylesheet" href="AddProduct.css">
<script type="text/javascript">
	function FormValidation() {
		prodname = document.getElementById('productName').value;
		img = document.getElementById('pic').value;
		item = document.getElementById('productItems').value;
		mfg = document.getElementById('productMFG').value;
		exp = document.getElementById('productEXP').value;
		loc = document.getElementById('plocation').value;
		price = document.getElementById('productprice').value;
		rating = document.getElementById('prating').value;

		if (prodname == "") {
			document.getElementById('productName').style.borderColor = "red";
			document.getElementById('productn').innerHTML = "Please enter details ";
			return false;
		} else {

			document.getElementById('productn').innerHTML = " ";
			document.getElementById('productName').style.borderColor = "green";
		}
		if (img == "") {
			document.getElementById('pic').style.borderColor = "red";
			document.getElementById('picc').innerHTML = "Please select image ";
			return false;
		} else {

			document.getElementById('picc').innerHTML = " ";
			document.getElementById('pic').style.borderColor = "green";
		}

		if (item == "") {
			document.getElementById('productItems').style.borderColor = "red";
			document.getElementById('itemm').innerHTML = "Please enter details ";
			return false;
		} else {

			document.getElementById('itemm').innerHTML = " ";
			document.getElementById('productItems').style.borderColor = "green";
		}
		if (mfg == "") {
			document.getElementById('productMFG').style.borderColor = "red";
			document.getElementById('mfg').innerHTML = "Please enter details ";
			return false;
		} else {

			document.getElementById('mfg').innerHTML = " ";
			document.getElementById('productMFG').style.borderColor = "green";
		}
		if (exp == "") {
			document.getElementById('productEXP').style.borderColor = "red";
			document.getElementById('pxp').innerHTML = "Please enter details ";
			return false;
		} else {

			document.getElementById('pxp').innerHTML = " ";
			document.getElementById('productEXP').style.borderColor = "green";
		}
		if (loc == "") {
			document.getElementById('plocation').style.borderColor = "red";
			document.getElementById('locc').innerHTML = "Please enter details";
			return false;
		} else {

			document.getElementById('locc').innerHTML = " ";
			document.getElementById('plocation').style.borderColor = "green";
		}
		if (price == "") {
			document.getElementById('productprice').style.borderColor = "red";
			document.getElementById('proprice').innerHTML = "Please enter details ";
			return false;
		} else {

			document.getElementById('proprice').innerHTML = " ";
			document.getElementById('productprice').style.borderColor = "green";
		}
		if (rating == "") {
			document.getElementById('prating').style.borderColor = "red";
			document.getElementById('pprating').innerHTML = "Please enter details ";
			return false;
		} else {

			if (parseInt(rating) < 10) {

				document.getElementById('pprating').innerHTML = " ";
				document.getElementById('prating').style.borderColor = "green";
			} else {
				document.getElementById('prating').style.borderColor = "red";
				document.getElementById('pprating').innerHTML = "please enter rating in range of 10 ";
				return false;
			}
			if (exp < mfg) {
				document.getElementById('productEXP').style.borderColor = "red";
				document.getElementById('productMFG').style.borderColor = "red";
				document.getElementById('pxp').innerHTML = "Please enter currecr details ";
				return false;
			}
		}

	}
</script>

</head>

<body>
	<a href="EditProduct.jsp">Back</a>
	<a href="Logout.jsp">Logout</a>
	<table>
		<tr>
			<td>
				<form action="ProductController" method="post" autocomplete="on"
					enctype="multipart/form-data" onsubmit="return FormValidation();"
					onchange="return FormValidation();">
					<h1>
						<center>Add Product</center>
					</h1>
					<div>
						<label><b>Product Name*</b></label> <input type="text"
							name="Product_Name" id="productName"> <font color='red'>
							<DIV id="productn"></DIV>
						</font>
					</div>
					<br>
					<div>
						<label><b>Product Image</b></label> <input type="file" name="pic"
							id="pic"> <font color='red'>
							<DIV id="picc"></DIV>
						</font>
					</div>
					<br>
					<div>
						<label><b>No. of Items</b></label> <input type="number"
							name="Item" id="productItems" min="0"> <font color='red'>
							<DIV id="itemm"></DIV>
						</font>
					</div>
					<div>
						<label><b>Manufacturing Date</b></label> <input type="date"
							name="Manufacture" id="productMFG"> <font color='red'>
							<DIV id="mfg"></DIV>
						</font>
					</div>
					<br>
					<div>
						<label><b>Expiration Date</b></label> <input type="date"
							name="Expiry" id="productEXP"> <font color='red'>
							<DIV id="pxp"></DIV>
						</font>
					</div>

					<div>
						<label><b>Location</b></label> <input type="text" name="location"
							id="plocation"> <font color='red'>
							<DIV id="locc"></DIV>
						</font>
					</div>
					<div>
						<label><b>Product_Price</b></label> <input type="number"
							name="product_price" id="productprice"> <font color='red'>
							<DIV id="proprice"></DIV>
						</font>
					</div>
					<div>
						<label><b>Rating</b></label> <input type="text" name="Rating"
							id="prating"> <font color='red'>
							<DIV id="pprating"></DIV>
						</font>
					</div>
					<div class="form-action-buttons">
						<input type="submit" value="Submit">
					</div>

				</form>
			</td>
			<td></td>
		</tr>
	</table>


	<table id="example" class="display" style="width: 100%">
		<thead>
			<tr>
				<th>Product Name</th>
				<th>Product Image</th>
				<th>Item</th>
				<th>Manufacturing Date</th>
				<th>Expiry Date</th>
				<th>Location</th>
				<th>Price</th>
				<th>Rating</th>

			</tr>
		</thead>
		<tbody>

			<%
				List<ProductBean> productBeanList = (ArrayList<ProductBean>) session.getAttribute("productBeanList");
				if (productBeanList != null && productBeanList.size() > 0) {
					for (int i = 0; i < productBeanList.size(); i++) {
						ProductBean productBean = productBeanList.get(i);
			%>

			<%
				String name = productBean.getProduct_name();
			%>
			<%
				int count = productBean.getNoi();
			%>
			<tr>
				<td><%=name%></td>
				<td><a href="ViewImageServlet?id=<%=name%>">Show Image</a></td>
				<%-- <td><%=productBean.getProduct_Image()%></td> --%>

				<td><%=count%></td>
				<td><%=productBean.getDom()%></td>
				<td><%=productBean.getDoe()%></td>
				<td><%=productBean.getLocation()%>
				<td><%=productBean.getPrice()%>
				<td><%=productBean.getRating()%>
			</tr>

			<%
				}
				}
			%>

		</tbody>
	</table>

</body>


</html>