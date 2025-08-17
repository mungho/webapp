function deleteProduct(id){
    document.getElementById("deleteProductId").value = id;
    document.getElementById("deletePreviewId").innerHTML = id;
}

// function updateProduct(name, price, stock) {
//     document.getElementById("editProductNameModal").value = name;
//     document.getElementById("editProductPriceModal").value = price;
//     document.getElementById("editProductStockModal").value = stock;
// }

document.querySelectorAll('.edit-btn').forEach(btn => {
    btn.addEventListener('click', () => {
        document.getElementById("editProductNameModal").value = btn.dataset.name;
        document.getElementById("editProductPriceModal").value = btn.dataset.price;
        document.getElementById("editProductStockModal").value = btn.dataset.stock;
    });
});