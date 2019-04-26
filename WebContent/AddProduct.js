

var selectedRow = null

function onFormSubmit() {
    if (validate()) {
        var formData = readFormData();
        if (selectedRow == null)
            insertNewRecord(formData);
        else
            updateRecord(formData);
        resetForm();
    }
}

function readFormData() {
    var formData = {};
    formData["productName"] = document.getElementById("productName").value;
    formData["productImage"] = document.getElementById("productImage").value;
    formData["productItems"] = document.getElementById("productItems").value;
    formData["productMFG"] = document.getElementById("productMFG").value;
    formData["productEXP"] = document.getElementById("productEXP").value;
    return formData;
}

function insertNewRecord(data) {
    var table = document.getElementById("productList").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.length);
    cell1 = newRow.insertCell(0);
    cell1.innerHTML = data.productName;
    cell2 = newRow.insertCell(1);
    cell2.innerHTML = data.productImage;
    cell3 = newRow.insertCell(2);
    cell3.innerHTML = data.productItems;
    cell4 = newRow.insertCell(3);
    cell4.innerHTML = data.productMFG;
    cell5 = newRow.insertCell(4);
    cell5.innerHTML = data.productEXP;
    cell5 = newRow.insertCell(5);
    
    cell5.innerHTML = `<a onClick="onEdit(this)">Edit</a>
                       <a onClick="onDelete(this)">Delete</a>`;
}

function resetForm() {
    document.getElementById("productName").value = "";
    document.getElementById("productImage").value = "";
    document.getElementById("productItems").value = "";
    document.getElementById("productMFG").value = "";
    document.getElementById("productEXP").value = "";
    selectedRow = null;
}

function onEdit(td) {
    selectedRow = td.parentElement.parentElement;
    document.getElementById("productName").value = selectedRow.cells[0].innerHTML;
    document.getElementById("productImage").value = selectedRow.cells[1].innerHTML;
    document.getElementById("productItems").value = selectedRow.cells[2].innerHTML;
    document.getElementById("productMFG").value = selectedRow.cells[3].innerHTML;
    document.getElementById("productEXP").value = selectedRow.cells[4].innerHTML;
}
function updateRecord(formData) {
    selectedRow.cells[0].innerHTML = formData.productName;
    selectedRow.cells[1].innerHTML = formData.productImage;
    selectedRow.cells[2].innerHTML = formData.productItems;
    selectedRow.cells[3].innerHTML = formData.productMFG;
    selectedRow.cells[4].innerHTML = formData.productEXP;
}

function onDelete(td) {
    if (confirm('Are you sure to delete this record ?')) {
        row = td.parentElement.parentElement;
        document.getElementById("productList").deleteRow(row.rowIndex);
        resetForm();
    }
}
function validate() {
    isValid = true;
    if (document.getElementById("productName").value == "") {
        isValid = false;
        document.getElementById("productNameValidationError").classList.remove("hide");
    } else {
        isValid = true;
        if (!document.getElementById("productNameValidationError").classList.contains("hide"))
            document.getElementById("productNameValidationError").classList.add("hide");
    }
    return isValid;
}

