<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 09/08/2025
  Time: 12:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Management</title>
    <link rel="stylesheet" href="/boostrap/css/bootstrap.css">
    <link rel="stylesheet" href="/my-css/my-style.css">
</head>
<body>
<div class="container-fluid custom-container mt-4">
    <div class="row mb-4">
        <div class="col">
            <h2>Product Management</h2>
        </div>
        <div class="col-auto">
            <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#addProductModal">
                + Add Product
            </button>

            <div class="modal fade" id="addProductModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form id="addProductForm" action="/product-list" method="post">
                                <input type="hidden" name="action" value="add">
                                <table class="w-100">
                                    <tr>
                                        <td class="col-4">Product's Name</td>
                                        <td class="col-8"><input name="name" type="text" class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <td>Price</td>
                                        <td><input name="price" type="number" class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <td>Stock</td>
                                        <td><input name="stock" type="number" class="form-control"></td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" form="addProductForm" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row mb-4">

        <div class="col">
                <form class="d-flex" role="search">
                    <input class="form-control" type="search" placeholder="Search" aria-label="Search"/>
                </form>
        </div>
    </div>
    <div class="row mb-4">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Stock Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${productList}" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>${product.stock}</td>
                        <td>
                            <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editProductModal">Edit</button>
                            <button onclick="deleteProduct('${product.id}')" type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteProductModal">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="modal fade" id="editProductModal" tabindex="-1" aria-labelledby="editProduct" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="editProduct">Edit Product</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="editProductForm" action="/product-list" method="post">
                    <input type="hidden" name="action" value="edit">
                    <table class="w-100">
                        <tr>
                            <td class="col-4">Product's Name</td>
                            <td class="col-8"><input name="name" type="text" class="form-control"></td>
                        </tr>
                        <tr>
                            <td>Price</td>
                            <td><input name="price" type="number" class="form-control"></td>
                        </tr>
                        <tr>
                            <td>Stock</td>
                            <td><input name="stock" type="number" class="form-control"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="deleteProductModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="deleteProductForm" action="/product-list" method="post">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="productId" id="deleteProductId">
                    <span>Are you sure you want to delete this product?</span>
                    <span id="deletePreviewId"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Confirm</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script src="/boostrap/js/bootstrap.bundle.js"></script>
<script>
    function deleteProduct(id){
        document.getElementById("deleteProductId").value = id;
        document.getElementById("deletePreviewId").innerHTML = id;
    }
</script>
</html>
